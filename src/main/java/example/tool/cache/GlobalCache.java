package example.tool.cache;


import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.Configuration;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;

/**
 * Created by Administrator on 2018/5/12.
 */
public class GlobalCache {

    private static CacheManager cacheManager;
    private static Cache<String, String> exampleCache;

    static {
        //初始化cache manager信息
        Configuration xmlConf = new XmlConfiguration(CacheManager.class.getResource("/cache/ehcache.xml"));
        cacheManager = CacheManagerBuilder.newCacheManager(xmlConf);
        cacheManager.init();

        //初始化各个cache到对象
        exampleCache = cacheManager.getCache("exampleCache", String.class, String.class);
    }

    /**
     * 返回registerVerifyCache的cache信息
     * @return
     */
    public static Cache<String, String> getExampleCache() {
        return exampleCache;
    }

    //测试方法
//    public static void main(String[] args) {
//        simulateCache.put("good",123);
//        simulateCache.put("good",456);
//        simulateCache.put("good",789);
//        Integer value = simulateCache.get("good");
//        System.out.println(value);
//        simulateCache.clear();
//        cacheManager.removeCache("simulate");
//        cacheManager.close();

//        projectProgressCache.clear();
//        cacheManager.removeCache("projectMark");
//        cacheManager.close();
//    }

//    @Test
//    public void tryRegister(){
//        registerVerifyCache.put("123123123","213124");
//        System.out.println(registerVerifyCache.get("123123123"));
//    }
}
