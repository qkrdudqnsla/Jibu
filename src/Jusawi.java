public class Jusawi {
    public static void jusawi(){
        int i;
        int j;

        for (i = 1 ; i <= 6 ; i++) {
            for (j = 1 ; j <= 6 ; j++) {
                if(i + j == 5) {
                    int ij = i + j;
                    System.out.println(i + "+" + j + "=" + ij);
                }
            }
        }
    }

}
