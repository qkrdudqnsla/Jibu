public class ReturnType {

    private String content;

    private Object data;

    public ReturnType(int v) {
        switch (v) {
            case(1):
                this.content = "1입니당";
                break;
            case(2):
                this.content = "2입니당";
                break;
            case(3):
                this.content = "3입니당";
                break;
        }
    }

    public ReturnType(Object data) {
        this.data = data;
    }


    public String getContent() {
        return content;
    }

    public Object getData(){

        return data;
    }



}
