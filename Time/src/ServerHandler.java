import java.text.SimpleDateFormat;
import java.util.Date;

import kr.ac.konkuk.ccslab.cm.event.CMDummyEvent;
import kr.ac.konkuk.ccslab.cm.event.CMEvent;
import kr.ac.konkuk.ccslab.cm.event.handler.CMAppEventHandler;
import kr.ac.konkuk.ccslab.cm.info.CMInfo;
import kr.ac.konkuk.ccslab.cm.stub.CMServerStub;

public class ServerHandler implements CMAppEventHandler {

	private TimeServer m_server;
	private CMServerStub m_serverStub;

	public ServerHandler(CMServerStub serverStub) {
		m_serverStub = serverStub;
	}

	@Override
	public void processEvent(CMEvent cme) {
		if (cme.getType() == CMInfo.CM_DUMMY_EVENT) {
			processDummyEvent(cme);
		}
	}

	private void processDummyEvent(CMEvent cme) {
		CMDummyEvent due = (CMDummyEvent) cme;

		// 받은 더미이벤트의 내용이 time인 경우
		if (due.getDummyInfo().equals("time")) {
			// 시간 데이터 만드는 부분
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
			Date date1 = new Date();
			String strDate = format1.format(date1);

			// 더미이벤트 내용 설정
			due.setDummyInfo(strDate);

			// 더미이벤트를 보낸 클라이언트한테 다시 보내는 부분
			m_serverStub.send(due, cme.getSender());
		}
		return;
	}
}
