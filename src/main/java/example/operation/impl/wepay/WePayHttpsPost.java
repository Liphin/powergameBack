package example.operation.impl.wepay;

import example.tool.common.Common;
import example.tool.config.GlobalConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;

/**
 * Created by Administrator on 2018/10/29.
 */
public class WePayHttpsPost {

    private static Logger logger = LoggerFactory.getLogger(WePayHttpsPost.class.getName());


    /**
     * 微信企业付款 https的post请求
     * @param urlStr
     * @param message
     * @return
     */
    public static CloseableHttpResponse postOpt(String urlStr, String message) {
        try {
            //分别获取证书的密码和路径
            String MCHID = GlobalConfig.getProperties(Common.MCHID);
            String certPath = GlobalConfig.getProperties(Common.COM_PAY_WECHAT_CERT_PATH);

            //加载证书
            FileInputStream instream = new FileInputStream(new File(certPath));
            KeyStore keyStore = KeyStore.getInstance(Common.PKCS12);
            keyStore.load(instream, MCHID.toCharArray());

            //关闭流
            if (null != instream) {
                instream.close();
            }

            //加载https请求携带的证书
            SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore,MCHID.toCharArray()).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[]{Common.TLSV1},
                    null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);

            //http post请求数据
            HttpPost httpPost = new HttpPost(urlStr);
            //得指明使用UTF-8编码，否则到API服务器XML的中文不能被成功识别
            httpPost.addHeader(Common.CONTENT_TYPE, Common.TEXT_XML);
            httpPost.setEntity(new StringEntity(message, Common.UTF8));
            return HttpClients.custom().setSSLSocketFactory(sslsf).build().execute(httpPost);

        } catch (Exception e) {
            logger.error("http post error", e);
            return null;
        }
    }


}
