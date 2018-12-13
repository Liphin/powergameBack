package example.operation.entity;

public class UserAct {

    private int id;
    private String openid;
    private String item_list;
    private String last_item_list;
    private String pass_1_list;
    private String pass_2_list;
    private String pass_3_list;
    private int pass_1;
    private int pass_2;
    private int pass_3;
    private int pass_4;
    private int passStatus_1;
    private int passStatus_2;
    private int passStatus_3;
    private int passStatus_4;
    private int enjoy_num;
    private int chance_num;
    private int harvest_flag;
    private int harvest_type;
    private int harvest_money;
    private String timestamp;
    private String create_time;
    private String update_time;

    public UserAct() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getItem_list() {
        return item_list;
    }

    public void setItem_list(String item_list) {
        this.item_list = item_list;
    }

    public String getLast_item_list() {
        return last_item_list;
    }

    public void setLast_item_list(String last_item_list) {
        this.last_item_list = last_item_list;
    }

    public String getPass_1_list() {
        return pass_1_list;
    }

    public void setPass_1_list(String pass_1_list) {
        this.pass_1_list = pass_1_list;
    }

    public String getPass_2_list() {
        return pass_2_list;
    }

    public void setPass_2_list(String pass_2_list) {
        this.pass_2_list = pass_2_list;
    }

    public String getPass_3_list() {
        return pass_3_list;
    }

    public void setPass_3_list(String pass_3_list) {
        this.pass_3_list = pass_3_list;
    }


    public int getPass_1() {
        return pass_1;
    }

    public void setPass_1(int pass_1) {
        this.pass_1 = pass_1;
    }

    public int getPass_2() {
        return pass_2;
    }

    public void setPass_2(int pass_2) {
        this.pass_2 = pass_2;
    }

    public int getPass_3() {
        return pass_3;
    }

    public void setPass_3(int pass_3) {
        this.pass_3 = pass_3;
    }

    public int getPass_4() {
        return pass_4;
    }

    public void setPass_4(int pass_4) {
        this.pass_4 = pass_4;
    }

    public int getPassStatus_1() {
        return passStatus_1;
    }

    public void setPassStatus_1(int passStatus_1) {
        this.passStatus_1 = passStatus_1;
    }

    public int getPassStatus_2() {
        return passStatus_2;
    }

    public void setPassStatus_2(int passStatus_2) {
        this.passStatus_2 = passStatus_2;
    }

    public int getPassStatus_3() {
        return passStatus_3;
    }

    public void setPassStatus_3(int passStatus_3) {
        this.passStatus_3 = passStatus_3;
    }

    public int getPassStatus_4() {
        return passStatus_4;
    }

    public void setPassStatus_4(int passStatus_4) {
        this.passStatus_4 = passStatus_4;
    }

    public int getEnjoy_num() {
        return enjoy_num;
    }

    public void setEnjoy_num(int enjoy_num) {
        this.enjoy_num = enjoy_num;
    }

    public int getChance_num() {
        return chance_num;
    }

    public void setChance_num(int chance_num) {
        this.chance_num = chance_num;
    }

    public int getHarvest_flag() {
        return harvest_flag;
    }

    public void setHarvest_flag(int harvest_flag) {
        this.harvest_flag = harvest_flag;
    }

    public int getHarvest_type() {
        return harvest_type;
    }

    public void setHarvest_type(int harvest_type) {
        this.harvest_type = harvest_type;
    }

    public int getHarvest_money() {
        return harvest_money;
    }

    public void setHarvest_money(int harvest_money) {
        this.harvest_money = harvest_money;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
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
        return "UserAct{" +
                "id=" + id +
                ", openid='" + openid + '\'' +
                ", item_list='" + item_list + '\'' +
                ", last_item_list='" + last_item_list + '\'' +
                ", pass_1_list='" + pass_1_list + '\'' +
                ", pass_2_list='" + pass_2_list + '\'' +
                ", pass_3_list='" + pass_3_list + '\'' +
                ", pass_1=" + pass_1 +
                ", pass_2=" + pass_2 +
                ", pass_3=" + pass_3 +
                ", pass_4=" + pass_4 +
                ", passStatus_1=" + passStatus_1 +
                ", passStatus_2=" + passStatus_2 +
                ", passStatus_3=" + passStatus_3 +
                ", passStatus_4=" + passStatus_4 +
                ", enjoy_num=" + enjoy_num +
                ", chance_num=" + chance_num +
                ", harvest_flag=" + harvest_flag +
                ", harvest_type=" + harvest_type +
                ", harvest_money=" + harvest_money +
                ", timestamp='" + timestamp + '\'' +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }
}
