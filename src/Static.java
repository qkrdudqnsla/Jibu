public class Static {
    static int num = 0; //클래스 변수(공용)
    int num2 = 0; // 인스턴스 변수

    public static void method(){
        System.out.println("출력1");
    }

    public void method2() {
        System.out.println("출력2");
    }
}
