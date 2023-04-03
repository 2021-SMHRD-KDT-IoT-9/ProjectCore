#include <Wire.h> // I2C 통신을 위한 라이브러리
#include <ArduinoJson.h> // JSON 라이브러리
// network 통신을 위한 라이브러리 - 다운로드 필요
#include <PubSubClient.h>
#include <WiFi.h>
// 현재 시간을 network를 통해 가져온다.
#include <WiFiUdp.h>
#include <NTPClient.h>


// WiFi 설정
const char* ssid = "";
const char* password = "";

// MQTT 설정
const char* mqttServer = "";
const int mqttPort = 8883;
const char* mqttUser = "";
const char*  mqttPassword  = "";
const char* mqttTopic = "MQTT_Topic";
// client 객체 생성
WiFiClient wifiClient;
PubSubClient mqttClient(wifiClient);

// 현재 시간을 네트워크를 통해 가져오기 위한 
const char* ntpServerName = "pool.ntp.org";
const int timeZone = 9;     // 한국 표준시

WiFiUDP ntpUDP;
NTPClient timeClient(ntpUDP, ntpServerName, timeZone * 3600, 60000);

// 콘센트 ID 정의
const String id_con = "A001";

// pin 번호 정의
const int currentPin = 14;
const int relayPin = 12;
const int buttonPin = 19;
const int ledPin = 13;

unsigned long lastTime = 0;  // 마지막 전류 측정 시간
int relayState = 0;
int buttonState = HIGH;

// 전류 측정을 위한 setting
float sensitivity = 0.066;  // ACS712 모듈의 감도 값 (mV/A)
float zeroOffset = 2047;  
float VRMS = 0;  
float AmpsRMS = 0;  
float Watt = 0;  
double totalVolts = 0; // 평균 전압 값을 계산하기 위한 전압 합
int count  = 0; // 전압 측정 횟수 

StaticJsonDocument<100> doc; // JSON 데이터를 저장할 버퍼 생성

void setup() {
   // WiFi 연결 ------------------------------------
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.println("Connecting to WiFi...");
  }
  Serial.println("Connected to WiFi");

  // MQTT 브로커 연결 ------------------------------
  mqttClient.setServer(mqttServer, mqttPort);

  mqttClient.setCallback(callback);
  while (!mqttClient.connected()) {
    Serial.println("Connecting to MQTT Broker...");
    if (mqttClient.connect("ArduinoClient", mqttUser, mqttPassword )) {
      Serial.println("Connected to MQTT Broker");
    } else {
      Serial.println("Failed with state ");
      Serial.println(mqttClient.state());
      delay(2000);
    }
  }
  // time client 시작
  timeClient.begin();
  // ------------------- wifi & broker 연결 ---------- 
  pinMode(currentPin, INPUT);
  pinMode(relayPin, OUTPUT);
  pinMode(buttonPin, INPUT);
  pinMode(ledPin, OUTPUT);
  lastTime = millis(); // 마지막 전류 측정 시간 초기화

  Serial.begin(115200); // 시리얼 통신 시작
}

void loop() {
//------------------------hole effect 전압 읽기 ------------------------------------------------------
  int analogValue = analogRead(currentPin);
  float voltage = 3.3 * analogValue / 4096 + 0.05; // 아날로그 값을 전압 값으로 변환
  // float current = (voltage - zeroOffset * 3.3 / 4096.0) / sensitivity; // 전류 값으로 변환
  // Serial.print("voltage value raw(V):");
  // Serial.println(voltage);
  // Serial.print("current value raw(A):");
  // Serial.println(current);

  totalVolts += voltage; // 평균 전류 값을 계산하기 위한 전류 합에 현재 전류 값을 더합니다.
  count++; // 전류 측정 횟수를 증가시킵니다.

  unsigned long currentTime = millis(); // 현재 시간을 읽어옵니다.
  if(currentTime - lastTime >= 60000){ // 1분이 경과한 경우

    double avgVolts = totalVolts/ count; // 1분간의 평균 전류 값을 계산합니다.
    Watt = getWatt(avgVolts);  // 단위 출력
        // -------------------Json Data 만들기------------------------------------------------------------------------------
        doc.clear(); // 이전에 저장된 데이터를 삭제
        doc["T_concent"] = id_con;
        doc["Date"] = getDate();
        doc["Watt"] = Watt;
        // JSON 데이터를 MQTT 브로커 서버에 전송
        char buffer[100];
        serializeJson(doc, buffer); // JSON 데이터를 문자열로 변환
        //-----------------------------------------------------------------------------------------------------------------
        // mqtt 데이터 발행
         mqttClient.publish(mqttTopic, buffer);
        // --------------------------------------------------------------------------------------------------------------------  
    totalVolts = 0; // 1분간의 전류 합과 전류 측정 횟수를 초기화합니다.
    count = 0;
    lastTime = currentTime; // 마지막 전류 측정 시간을 현재 시간으로 갱신합니다.
  }
  //------------------------------------------------------------------------------------------------------------





  // // 버튼 값 읽기
  int buttonValue = digitalRead(buttonPin);

  // 버튼 상태 업데이트
  if (buttonValue == HIGH) {
    relayControl();
  }
  
  // LED 상태 업데이트
  // digitalWrite(ledPin, relayState);

  // delay(1000); // 딜레이를 추가하여 버튼 debounce 처리
  // client 객체에서 토픽 읽기
  client.loop();
}

float getWatt(float avgVolt){
  VRMS = (avgVolt/2.0) *0.707;   //root 2 is 0.707
  AmpsRMS = ((VRMS * 1000)/sensitivity);
  Serial.print("AmpsRMS(mA): ");
  Serial.println(AmpsRMS);

  Serial.println(" Amps RMS  ---  ");

  Watt = (AmpsRMS*240);

  Serial.print(Watt);

  Serial.println(" Watts");


  Serial.print (AmpsRMS);

  Serial.print (" Amps ");

  //Here cursor is placed on first position (col: 0) of the second line (row: 1)


  Serial.print (Watt);

  Serial.print (" watt ");
  //0.3 is the error I got for my sensor
  return Watt;
}

void relayControl(){
    if (relayState == 0){
      relayState = 1;
    } else{
      relayState = 0;
    }
  // 릴레이 상태 업데이트
  digitalWrite(relayPin, relayState);
}


void callback(char* topic, byte* payload, unsigned int length) {
  // 메시지 수신 콜백 함수
  Serial.println('callback');
}

String getDate(){
   timeClient.update();
  

  String formattedTime = timeClient.getFormattedTime();
  int year = formattedTime.substring(0, 4).toInt();
  int month = formattedTime.substring(5, 7).toInt();
  int day = formattedTime.substring(8, 10).toInt();
  int hour = formattedTime.substring(11, 13).toInt();
  int minute = formattedTime.substring(14, 16).toInt();
  int second = formattedTime.substring(17, 19).toInt();

  // 날짜 및 시간을 "YYYY-MM-DD HH:mm:ss" 형식의 문자열로 변환
  String datetime = String(year) + "-";
  if (month < 10) datetime += "0";
  datetime += String(month) + "-";
  if (day < 10) datetime += "0";
  datetime += String(day) + " ";
  if (hour < 10) datetime += "0";
  datetime += String(hour) + ":";
  if (minute < 10) datetime += "0";
  datetime += String(minute) + ":";
  if (second < 10) datetime += "0";
  datetime += String(second);

  return datetime;
}