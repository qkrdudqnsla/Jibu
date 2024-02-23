import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    final static int SERVER_PORT = 1225;

    public static void main(String[] args) {

        ServerSocket serverSocket = null;

        try {
            // 서버 소켓 생성
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("서버가 " + SERVER_PORT + " 포트에서 시작되었습니다. 클라이언트 연결 대기 중...");

            while (true) {
                // 클라이언트로부터 연결 요청 수락
                Socket clientSocket = serverSocket.accept();
                System.out.println("클라이언트가 연결되었습니다.");

                // 클라이언트로부터 데이터 받기 위한 통로
                InputStream is = clientSocket.getInputStream();
                // 클라이언트로 데이터 보내기 위한 통로
                OutputStream os = clientSocket.getOutputStream();

                // 클라이언트에서의 요청 읽기
                byte[] data = new byte[1024];
                int bytesRead = is.read(data);
                String requestData = new String(data, 0, bytesRead);
                System.out.println("클라이언트에서 받은 데이터: " + requestData);

                // 서버에서 클라이언트로 응답 보내기
                String responseData = requestData;
                os.write(responseData.getBytes());
                os.flush();

                // 클라이언트 소켓 닫기
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 서버 소켓 닫기
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
