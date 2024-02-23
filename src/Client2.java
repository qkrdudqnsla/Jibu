import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client2 {

    final static String SERVER_IP = "127.0.0.1";
    final static int SERVER_PORT = 1225;
    //final static String dong = "";

    public static void main(String[] args) {

        Socket socket = null;

        //String dong = "101";
        //String ho = "1001";
        //String carNo = "12박1234";

        String sendData = "Type=PARKING&Dong=1301&Ho=301&CarNo=1234&DateTime=200601051330&InOut=IN";

        try {
            /** 소켓통신 시작 */
            socket = new Socket(SERVER_IP,SERVER_PORT);
            System.out.println("socket 연결");

            /**	Client에서 Server로 보내기 위한 통로 */
            OutputStream os = socket.getOutputStream();
            /**	Server에서 보낸 값을 받기 위한 통로 */
            InputStream is = socket.getInputStream();

            os.write( sendData.getBytes() );
            os.flush();

            byte[] data = new byte[16];
            int n = is.read(data);
            final String resultFromServer = new String(data,0,n);

            System.out.println(resultFromServer);

            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
