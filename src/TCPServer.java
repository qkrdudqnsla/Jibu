import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        try {
            // 서버 소켓 생성 및 포트 지정
            ServerSocket serverSocket = new ServerSocket(7777);

            System.out.println("서버가 시작되었습니다. 클라이언트의 연결을 기다립니다.");

            // 클라이언트의 연결을 기다림
            Socket socket = serverSocket.accept();
            System.out.println("클라이언트가 연결되었습니다.");

            // 클라이언트로부터 데이터를 받는 InputStream 생성
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int length = inputStream.read(buffer);

            // 받은 데이터 출력
            System.out.println("클라이언트로부터 받은 데이터: " + new String(buffer, 0, length));

            // 클라이언트에게 응답을 보내는 OutputStream 생성
            OutputStream outputStream = socket.getOutputStream();
            String response = "서버에서 보낸 응답입니다.";
            outputStream.write(response.getBytes());

            // 자원 해제
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
