import java.util.UUID;

public class TEST {
    public static void main(String[] args) {
        String s[] = new String[4500];

        for(int i = 0; i < 4500; i++){
            s[i] = UUID.randomUUID().toString().replaceAll("-", "");
            System.out.println(s[i]);
        }

        // write your code here
    }
}
