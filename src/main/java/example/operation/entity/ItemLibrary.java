package example.operation.entity;

public class ItemLibrary {
    private int id;
    private String item_introduce;
    private String item_img;
    private int item_type;
    private String item_problem;
    private String item_select_1;
    private String item_select_2;
    private String item_select_3;
    private String item_select_4;
    private String item_answer;
    private String create_time;
    private String update_time;

    public ItemLibrary() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem_introduce() {
        return item_introduce;
    }

    public void setItem_introduce(String item_introduce) {
        this.item_introduce = item_introduce;
    }

    public String getItem_img() {
        return item_img;
    }

    public void setItem_img(String item_img) {
        this.item_img = item_img;
    }

    public int getItem_type() {
        return item_type;
    }

    public void setItem_type(int item_type) {
        this.item_type = item_type;
    }

    public String getItem_problem() {
        return item_problem;
    }

    public void setItem_problem(String item_problem) {
        this.item_problem = item_problem;
    }

    public String getItem_select_1() {
        return item_select_1;
    }

    public void setItem_select_1(String item_select_1) {
        this.item_select_1 = item_select_1;
    }

    public String getItem_select_2() {
        return item_select_2;
    }

    public void setItem_select_2(String item_select_2) {
        this.item_select_2 = item_select_2;
    }

    public String getItem_select_3() {
        return item_select_3;
    }

    public void setItem_select_3(String item_select_3) {
        this.item_select_3 = item_select_3;
    }

    public String getItem_select_4() {
        return item_select_4;
    }

    public void setItem_select_4(String item_select_4) {
        this.item_select_4 = item_select_4;
    }

    public String getItem_answer() {
        return item_answer;
    }

    public void setItem_answer(String item_answer) {
        this.item_answer = item_answer;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "ItemLibrary{" +
                "id=" + id +
                ", item_introduce='" + item_introduce + '\'' +
                ", item_img='" + item_img + '\'' +
                ", item_type=" + item_type +
                ", item_problem='" + item_problem + '\'' +
                ", item_select_1='" + item_select_1 + '\'' +
                ", item_select_2='" + item_select_2 + '\'' +
                ", item_select_3='" + item_select_3 + '\'' +
                ", item_select_4='" + item_select_4 + '\'' +
                ", item_answer='" + item_answer + '\'' +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }
}
