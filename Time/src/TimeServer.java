import kr.ac.konkuk.ccslab.cm.stub.CMServerStub;

public class TimeServer {
	private CMServerStub m_serverStub;
	private ServerHandler m_serverHandler;

	public TimeServer() { 
		m_serverStub = new CMServerStub();
		m_serverHandler = new ServerHandler(m_serverStub);
	}

	public static void main(String[] args) {
		TimeServer server = new TimeServer();
		server.m_serverStub.setAppEventHandler(server.m_serverHandler);
		server.m_serverStub.startCM();
	}
}
