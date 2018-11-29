package example.operation.impl.userActOpt;

import example.operation.entity.UserAct;
import example.operation.entity.response.ResponseData;
import example.operation.entity.response.StatusCode;
import example.operation.impl.common.CommonService;
import example.tool.common.Assemble;
import example.tool.common.Common;
import example.tool.common.Mapper;
import example.tool.parser.form.FormData;
import example.tool.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class UserActOpt {
    private static Logger logger = LoggerFactory.getLogger(UserActOpt.class);

    /**
     * 获取用户动态信息
     *
     * @param msg http传递的数据
     */
    public static ResponseData getUserActInfo(Object msg) {
        ResponseData responseData = new ResponseData(StatusCode.ERROR.getValue());
        SqlSession sqlSession = MybatisUtils.getSession();
        String message = "";
        try{
            Map<String, Object> map = FormData.getParam(msg);
            //String openid = (String) map.get(Common.OPENID);
            UserAct UserAct = sqlSession.selectOne(Mapper.GET_USER_ACT_INFO, map);
            //检查是否查找到指定起始位置及数目的新闻并返回相应结果
            Map<String, Object> data = new HashMap<>();
            data.put(Common.USERACT, UserAct); //返回动态信息
            Assemble.responseSuccessSetting(responseData, data);

            if (!CommonService.checkNotNull(UserAct)) {
                message = "news info not found";
                UserActOpt.logger.warn(message);
            }
        } catch (Exception e) {
            message = "sys error";
            UserActOpt.logger.debug(message, e);
            Assemble.responseErrorSetting(responseData, 500, message);
        } finally {
            CommonService.databaseCommitClose(sqlSession, responseData, false);
        }

        return responseData;
    }

    /**
     * 获取某条动态对应的图片信息
     *
     * @param msg http传递的数据
     */
    public static ResponseData setUserActInfo(Object msg) {
        ResponseData responseData = new ResponseData(StatusCode.ERROR.getValue());
        SqlSession sqlSession = MybatisUtils.getSession();
        String message = "";
        int num = 0;
        try{
            //前端新闻数据获取
            UserAct UserAct = (UserAct) FormData.getParam(msg, UserAct.class);
            UserAct.setCreate_time(CommonService.getDateTime());

            num = sqlSession.insert(Mapper.SET_USER_ACT_INFO, UserAct);
            if (num > 0) {
                Assemble.responseSuccessSetting(responseData, null);
            } else {
                message = "database influence record error";
                UserActOpt.logger.warn(message);
                Assemble.responseErrorSetting(responseData, 401, message);
            }
        } catch (Exception e) {
            message = "saveNewsData system error";
            UserActOpt.logger.error(message, e);
            Assemble.responseErrorSetting(responseData, 500, message);
        } finally {
            CommonService.databaseCommitClose(sqlSession, responseData, true);
        }

        return responseData;
    }
}
