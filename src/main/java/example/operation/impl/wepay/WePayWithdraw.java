package example.operation.impl.wepay;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import example.operation.entity.wepay.Transfers;
import example.operation.entity.wepay.TransfersBack;
import example.operation.impl.common.CommonService;
import example.tool.common.Common;
import example.tool.config.GlobalConfig;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by Administrator on 2018/10/29.
 */
public class WePayWithdraw {

    private static Logger logger = LoggerFactory.getLogger(WePayWithdraw.class.getName());

    /**
     * 微信提现（企业付款）
     */
    public static String weixinWithdraw(String openId, String money) {

//        String openId = "oaCnbs6EiIYbXgc8aYlRRSlJvqGk";
//        String money = "100";

        if (StringUtils.isNotBlank(money) && StringUtils.isNotBlank(openId)) {
            //从config配置中获取参数组
            String appid = GlobalConfig.getProperties(Common.COM_PAY_WECHAT_APPDI);
            String mchid = GlobalConfig.getProperties(Common.COM_PAY_WECHAT_MCHID);

            //是否校验用户姓名 NO_CHECK：不校验真实姓名  FORCE_CHECK：强校验真实姓名
            String checkName = GlobalConfig.getProperties(Common.COM_PAY_WECHAT_CHECK_NAME);
            String spBillCreateIp = GlobalConfig.getProperties(Common.COM_PAY_WECHAT_CREATE_IP);
            String wepayUrl = GlobalConfig.getProperties(Common.COM_PAY_WECHAT_TRANSFER_URL);

            //字符串数据计算和拼接操作
            Integer amount = Integer.valueOf(money);
            String nonce_str = CommonService.getUnionId();
            String partner_trade_no = CommonService.getUnionId();
            String desc = "阳江南网活动领取红包金额" + (amount / 100) + "元"; //红包描述

            //参数：开始生成第一次签名
            SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
            parameters.put(Common.MCH_APPID, appid);
            parameters.put(Common.MCHID, mchid);
            parameters.put(Common.NONCE_STR, nonce_str);
            parameters.put(Common.PARTNER_TRADE_NO, partner_trade_no);
            parameters.put(Common.OPENID, openId);
            parameters.put(Common.CHECK_NAME, checkName);
            parameters.put(Common.AMOUNT, amount);
            parameters.put(Common.DESC, desc);
            parameters.put(Common.SPBILL_CREATE_IP, spBillCreateIp);
            String sign = WXSignUtils.createSign(Common.UTF8, parameters);

            //实体类装载数据
            Transfers transfers = new Transfers();
            transfers.setMch_appid(appid);
            transfers.setMchid(mchid);
            transfers.setNonce_str(nonce_str);
            transfers.setPartner_trade_no(partner_trade_no);
            transfers.setOpenid(openId);
            transfers.setCheck_name(checkName);
            transfers.setAmount(amount);
            transfers.setDesc(desc);
            transfers.setSpbill_create_ip(spBillCreateIp);
            transfers.setSign(sign);

            //实体类转化为xml发送格式
            XStream xStream = new XStream(new DomDriver(Common.UTF8, new XmlFriendlyNameCoder("_-", "_")));
            xStream.alias(Common.XML, Transfers.class);
            String xmlInfo = xStream.toXML(transfers);
            logger.debug("prepare to send red package: " + xmlInfo);

            try {
                //http请求发送数据
                CloseableHttpResponse response = WePayHttpsPost.postOpt(wepayUrl, xmlInfo);
                String transfersXml = EntityUtils.toString(response.getEntity(), Common.UTF8);

                //解析最终xml数据
                XStream.setupDefaultSecurity(xStream);
                xStream.alias("xml", TransfersBack.class);
                xStream.allowTypes(new Class[]{TransfersBack.class});
                TransfersBack transfersBack = (TransfersBack) xStream.fromXML(transfersXml);

                logger.debug("get data back: " + transfersBack);
                //如果返回非success则打印错误消息并插入数据库记录
                if (!Objects.equals(transfersBack.getReturn_code(), "SUCCESS")) {
                    WePayWithdraw.logger.error(openId);

                    //对发送不成功的数据插入数据库操作
                    // TODO
                }

            } catch (Exception e) {
                logger.debug("system error: " + e);
                //log.error(e.getMessage());
                //throw new Exception(this, "企业付款异常" + e.getMessage());
            }
        } else {
            logger.debug("失败");
        }
        return "";
    }

}
