import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ParkingServer {
    public static void main(String[] args) {
        try {
            // 서버 소켓 생성 및 포트 지정
            ServerSocket serverSocket = new ServerSocket(29500);

            System.out.println("주차서버가 시작되었습니다. 클라이언트의 연결을 기다립니다.");

            while (true) {
                // 클라이언트의 연결을 기다림
                Socket socket = serverSocket.accept();
                System.out.println("클라이언트가 연결되었습니다.");

                // 클라이언트로부터 데이터를 받는 BufferedReader 생성
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // 받은 데이터 출력
                byte[] byteArray = reader.readLine().getBytes("UTF-8");
                System.out.println("받은 바이트 배열: " + byteArrayToString(byteArray));

                // 응답 생성
                String response = createResponse(byteArray);

                // 클라이언트에게 응답을 보내는 OutputStream 생성
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(response.getBytes());

                // 소켓 접속 해제
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 주차서버 응답 생성 메서드
    private static String createResponse(byte[] requestData) {
        // 여기에서 주차서버 응답을 생성하고 반환하는 로직을 작성
        // 예제로 주차서버에서 받은 데이터를 그대로 응답으로 사용하는 코드를 작성했습니다.
        return new String(requestData, java.nio.charset.StandardCharsets.UTF_8) + "&Return=ok";
    }

    // 바이트 배열을 문자열로 변환하여 출력하는 메서드
    private static String byteArrayToString(byte[] byteArray) {
        StringBuilder result = new StringBuilder();
        for (byte b : byteArray) {
            result.append(String.format("%02X ", b));
        }
        return result.toString().trim();
    }
}
