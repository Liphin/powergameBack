package example.operation.mapper;

import example.operation.entity.UserAct;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserActMapper {

    /***********用户活动数据操作***********/

    /*********select*********/
    @Select("select * from useract where openid=#(openid)")
    public UserAct getUserActInfo(@Param("openid") String openid);


    /*********insert*********/
    //新增朋友圈，同时新增动态信息图片表，记录图片个数和图片名字
    @Insert("insert into useract(openid, item_list, last_item_list, pass_1, pass_2, pass_3, pass_4, passStatus_1, passStatus_2, passStatus_3, passStatus_4, enjoy_num, chance_num,harvest_flag,harvest_type,harvest_money,timestamp,create_time) " +
            "values(#{openid}, #{item_list}, #{last_item_list}, #{pass_1}, #{pass_2}, #{pass_3}, #{pass_4}, #{passStatus_1}, #{passStatus_2}, #{passStatus_3}, #{passStatus_4}, #{enjoy_num}, #{chance_num},#(harvest_flag),#(harvest_type),#(harvest_money),#(timestamp),#(create_time))")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int setUserActInfo(UserAct UserAct);


}
