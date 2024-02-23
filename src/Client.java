import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    //final static String SERVER_IP = "172.20.200.200";
    //final static int SERVER_PORT = 29500;
    final static String SERVER_IP = "192.168.0.77";
    final static int SERVER_PORT = 1225;

    public static void main(String[] args) {

        Socket socket = null;

        try {
            // 소켓 통신 시작
            socket = new Socket(SERVER_IP, SERVER_PORT);
            System.out.println("소켓 연결");

            // Client에서 Server로 보내기 위한 통로
            OutputStream os = socket.getOutputStream();
            // Server에서 보낸 값을 받기 위한 통로
            InputStream is = socket.getInputStream();

            // 전송할 데이터 생성
            String sendData = "00000000Type=PARKING&Dong=906&Ho=1603&CarNo=12박1234&DateTime=20240115000000&InOut=IN";

            // 데이터 전송
            os.write(sendData.getBytes());
            os.flush();

            // 서버에서의 응답 받기
            byte[] data = new byte[1024];
            int bytesRead = is.read(data);
            String resultFromServer = new String(data, 0, bytesRead);

            System.out.println("서버 return 값: " + resultFromServer);

            // 소켓 닫기
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
