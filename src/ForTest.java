import java.util.ArrayList;

public class ForTest {

    public static void fortest() {

        // 문자열을 담은 ArrayList 생성
        ArrayList<String> stringList = new ArrayList<>();
        String[] oldName = {"(구)장비1", "(구)장비2", "(구)장비3", "(구)장비4"};
        String[] newName = {"(신)장비1", "(신)장비2", "(신)장버3", "(신)장비4"};

        for (int i = 0; i < newName.length; i++) {
            for (String test : oldName) {
                if (newName[i].substring(3).equals(test.substring(3))) {
                    stringList.add(newName[i]);
                    System.out.println("(신제품) : " + newName[i]);
                    break;
                }
            }
        }

    }
}
