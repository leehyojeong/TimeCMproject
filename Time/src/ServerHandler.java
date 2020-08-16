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

		// ���� �����̺�Ʈ�� ������ time�� ���
		if (due.getDummyInfo().equals("time")) {
			// �ð� ������ ����� �κ�
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss��");
			Date date1 = new Date();
			String strDate = format1.format(date1);

			// �����̺�Ʈ ���� ����
			due.setDummyInfo(strDate);

			// �����̺�Ʈ�� ���� Ŭ���̾�Ʈ���� �ٽ� ������ �κ�
			m_serverStub.send(due, cme.getSender());
		}
		return;
	}
}
