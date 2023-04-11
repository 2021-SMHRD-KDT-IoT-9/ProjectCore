import realMqtt
from DB import ConcentDAO
import time
# MQTT 객체들을 리스트로 관리
mqttList = []
# 학습을 반복하지 않기 위해 상태를 구분 
# 20시에 학습을 시작하고 21시에는 학습 상태를 안된 상태로 돌린다.
learning = False
# 데이터 베이스 연결
dao = ConcentDAO.ConcentDAO()
# 시간 시작 시간
last_run_time = time.time()
while True:
    # TODO  특정 시간에 동작을 한다.
        # 현재 동작 시간 측정
        current_time = time.time()
        # 00시에 동작하도록
        # 00시 부분만 문자열로 가져온다.
        hour = time.strftime("%H",time.localtime(current_time))
        if hour == "11" and mqttList != [] and learning == False:
            print("학습합니다.")
            learning = True
            for mqtt in mqttList:
                 mqtt.new_kmean()
                 mqtt.new_LSTM()
        if learning == True and hour == "12":
            learning = False


        # 1분이상일 때, id 개수 판단
        if current_time - last_run_time >= 5:
            print("check 합니다.")
            last_run_time = current_time
            if dao.count_concent_ids() == False:
                # 새롭게 추가된 콘센트를 가져온다.
                newConcent = dao.get_member_concent_ids()
                for new in newConcent:
                     mqttList.append(realMqtt.MQTTClient(new[0]))
