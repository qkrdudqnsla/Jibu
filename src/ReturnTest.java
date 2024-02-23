public class ReturnTest {
    public static Object test() {
        System.out.println(new ReturnType(1).getContent());
        return new ReturnType(1).getContent();
    }

    public Object test1() {

        //ReturnCollection returnCollection = new ReturnCollection(1, "13");
        //ReturnType returnType = new ReturnType(returnCollection);

        // 데이터 확인: ReturnCollection의 var3 값 출력
        //System.out.println("데이터 확인 - var3 값: " + ((ReturnCollection) returnType.getData()).getVar2());
        System.out.println("test");

        return new ReturnType(new ReturnType2(1, "성공"));
    }

}
