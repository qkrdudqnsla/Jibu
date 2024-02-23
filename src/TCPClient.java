import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        try {
            // 서버에 연결
            Socket socket = new Socket("localhost", 7777);

            // 서버에 데이터를 보내는 OutputStream 생성
            OutputStream outputStream = socket.getOutputStream();
            String message = "안녕하세요. 서버에 접속했습니다.";
            outputStream.write(message.getBytes());

            // 서버로부터 데이터를 받는 InputStream 생성
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int length = inputStream.read(buffer);

            // 받은 데이터 출력
            System.out.println("서버로부터 받은 응답: " + new String(buffer, 0, length));

            // 자원 해제
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
