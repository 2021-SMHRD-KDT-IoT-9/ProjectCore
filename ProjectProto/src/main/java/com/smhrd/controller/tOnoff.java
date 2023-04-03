package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

@WebServlet("/tOnoff")
public class tOnoff extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static String conid;
	public static String num;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 요청 파라미터 추출
		conid = request.getParameter("conid");
		num = request.getParameter("num");

		// 값 확인을 위한 로그 출력
		System.out.println("conid: " + conid);
		System.out.println("num: " + num);

		MyMqtt_Pub_Client sender = new MyMqtt_Pub_Client();
		String msg = "{" + conid + ":" + num + "}";
		sender.send(msg);

	}

	public class MyMqtt_Pub_Client {
		// MQTT통신에서 publisher와 Subscriber의 역할을 하기 위한 기	능을 가진 객체
		private MqttClient client;

		public MyMqtt_Pub_Client() {

			try {
				// broker와 MQTT통신을 하며 메세지를 전송할 클라이언트 객체를 만들고 접속
				client = new MqttClient("tcp://119.200.31.252:8883", ""); // broker 서버
				client.connect();// broker접속
				System.out.println("success");
			} catch (MqttException e) {
				e.printStackTrace();
				System.out.println("fail...");
			}
		}

		// 메세지 전송을 위한 메소드
		public boolean send(String msg) {
			try {
				// broker로 전송할 메세지 생성 -MqttMessage
				MqttMessage message = new MqttMessage();
				message.setPayload(msg.getBytes()); // 실제 broker로 전송할 메세지
				client.publish("MQTT_Topic", message);
				System.out.println("success2");
			} catch (MqttException e) {
				e.printStackTrace();
				System.out.println("fail...");
			}
			return true;
		}

		public void close() {
			if (client != null) {
				try {
					client.disconnect();
					client.close();
				} catch (MqttException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
