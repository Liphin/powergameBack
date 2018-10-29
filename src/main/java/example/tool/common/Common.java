package example.tool.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2018/2/12.
 */
public class Common {

    private static Logger logger = LoggerFactory.getLogger(Common.class.getName());

    //global环境设置配置
    public static String DEV_ENVIRONMENT = "dev"; //测试环境
    public static String PROD_ENVIRONMENT = "prod"; //生产环境
    public static String UTF8 = "UTF-8";
    public static String SETTING_FILES = "com.viewcoder.setting.files"; //设定目标环境下的文件

    //数据返回设置
    public static String RETURN_TEXT_HTML = "text/html;charset=UTF-8";
    public static String RETURN_JSON = "application/json";
    public static String XML = "xml";
    public static String CONTENT_TYPE = "Content-Type";
    public static String TEXT_XML = "text/xml";

    //微信红包发放接口String参数
    public static String MCH_APPID="mch_appid";
    public static String MCHID="mchid";
    public static String NONCE_STR="nonce_str";
    public static String PARTNER_TRADE_NO="partner_trade_no";
    public static String OPENID="openid";
    public static String CHECK_NAME="check_name";
    public static String AMOUNT="amount";
    public static String DESC="desc";
    public static String SPBILL_CREATE_IP="spbill_create_ip";
    //微信红包发放接口获取配置文件的参数
    public static String COM_PAY_WECHAT_APPDI="com.pay.wechat.appid";
    public static String COM_PAY_WECHAT_MCHID="com.pay.wechat.mchid";
    public static String COM_PAY_WECHAT_CHECK_NAME="com.pay.wechat.check_name";
    public static String COM_PAY_WECHAT_CREATE_IP="com.pay.wechat.create_ip";
    public static String COM_PAY_WECHAT_TRANSFER_URL="com.pay.wechat.transfer_url";
    public static String COM_PAY_WECHAT_API_KEY="com.pay.wechat.api_key";
    public static String COM_PAY_WECHAT_CERT_PATH="com.pay.wechat.cert.path";


    //证书配置
    public static String PKCS12 = "PKCS12";
    public static String TLSV1 = "TLSv1";



}
