import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {

    int socketPort = 1111;
    int bufferSize = 1024;

    public void fncServer()
    {
        ServerSocket serverSocket;
        Socket socket;

        try
        {
            // ServerSocket 생성
            serverSocket = new ServerSocket();

            // 포트 바인딩
            // IP 미입력 시 "localhost"가 기본값
            serverSocket.bind(new InetSocketAddress(socketPort));

            while(true)
            {
                // 연결 대기
                // 요청 승인
                socket = serverSocket.accept();
                // 데이터 받는 부분
                InputStream input = socket.getInputStream();

                byte[] b = new byte[bufferSize];
                int readCnt = input.read(b);

                String msgStr = new String(b, 0, readCnt, "UTF-8");

                input.close();
                socket.close();
            }
        }
        catch (Exception e)
        {
            // Exception 처리
        }
    }

}
