package example.operation.entity;

public class UserMoney {
    private int id;
    private String openid;
    private int harvest_type;
    private int harvest_money;
    private String timestamp;
    private String create_time;
    private String update_time;

    public UserMoney() {
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
        return "UserMoney{" +
                "id=" + id +
                ", openid='" + openid + '\'' +
                ", harvest_type=" + harvest_type +
                ", harvest_money=" + harvest_money +
                ", timestamp='" + timestamp + '\'' +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }
}
