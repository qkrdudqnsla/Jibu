public class Gugudan {
    public static int call(){
        int result = 0;
        int part1[] = {1,2,3,4,5,6,7,8,9};
        int part2[] = {1,2,3,4,5,6,7,8,9};
        int ij = 0;

        for(int i = 0; i < part1.length; i++){
            for(int j = 0; j < part2.length; j++) {
                ij = part1[i] * part2[j];
                System.out.print(ij);
                if (part2[j] + 1 <= part2.length) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        return result;
    }
}
