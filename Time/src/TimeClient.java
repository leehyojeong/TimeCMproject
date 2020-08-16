import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import kr.ac.konkuk.ccslab.cm.entity.CMUser;
import kr.ac.konkuk.ccslab.cm.event.CMDummyEvent;
import kr.ac.konkuk.ccslab.cm.info.CMInteractionInfo;
import kr.ac.konkuk.ccslab.cm.stub.CMClientStub;

public class TimeClient {
	private CMClientStub m_clientStub;
	private ClientHandler m_clientHandler;
	private Scanner m_scan = null;
	private boolean m_bRun;

	public TimeClient() {
		m_clientStub = new CMClientStub();
		m_clientHandler = new ClientHandler();
		m_bRun = true;
	}

	public static void main(String[] args) {
		TimeClient client = new TimeClient();
		client.m_clientStub.setAppEventHandler(client.m_clientHandler);
		client.m_clientStub.startCM();

		client.m_clientStub.loginCM("201711336", "1111");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		client.m_scan = new Scanner(System.in);
		String strInput = null;

		try {
			Thread.sleep(2500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		while (client.m_bRun) {
			System.out.println("time�� �Է��ϸ� �ð��� ��µ˴ϴ�.");
			System.out.print("> ");

			// string�� �Է¹޴� �κ�
			try {
				strInput = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				continue;
			}

			// �Է��� String�� time�� ��� ó��
			if (strInput.equals("time")) {
				CMInteractionInfo interInfo = client.m_clientStub.getCMInfo().getInteractionInfo();
				CMUser myself = interInfo.getMyself();

				// �����̺�Ʈ ����� �κ�
				CMDummyEvent due = new CMDummyEvent();
				due.setHandlerSession(myself.getCurrentSession());
				due.setHandlerGroup(myself.getCurrentGroup());
				due.setDummyInfo(strInput);
				due.setSender(myself.getName());

				// ������ �����̺�Ʈ ����
				client.m_clientStub.send(due, "SERVER");
				due = null;

				break;
			}
		} // while�� ��
	}
}
