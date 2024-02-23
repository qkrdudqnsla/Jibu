import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class ApartmentServer {
/*    public static void main(String[] args) {
        try {
            // 단지서버에 연결 (로컬 IP: 127.0.0.1 또는 localhost, 포트: 29500)
            Socket socket = new Socket("127.0.0.1", 29500);

            // 전송할 데이터 생성
            String message = "Type=PARKING&Dong=1301&Ho=301&CarNo=1234&DateTime=200601051330&InOut=IN";
            byte[] byteArray = message.getBytes(StandardCharsets.UTF_8);

            // 서버에 데이터를 바이트로 변환하여 보내는 OutputStream 생성
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(byteArray);

            // 소켓 접속 해제
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public static void main(String[] args) {
        String s[] = new String[605];

        for(int i = 0; i < 605; i++){
            s[i] = UUID.randomUUID().toString().replaceAll("-", "");
            System.out.println(s[i]);
        }

        // write your code here
    }
}
