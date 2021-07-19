package cn.darkjrong.spring.boot.autoconfigure;

import cn.darkjrong.http.utils.RestTemplateClient;
import cn.hutool.core.util.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.client.RestTemplate;

/**
 *  Http 工厂类
 * @author Rong.Jia
 * @date 2021/02/03 09:03
 */
public class HttpFactoryBean implements FactoryBean<RestTemplateClient>, InitializingBean, ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(HttpFactoryBean.class);

    private ApplicationContext applicationContext;
    private RestTemplateClient restTemplateClient;

    @Override
    public void afterPropertiesSet() {
        try {
            if (ObjectUtil.isNotNull(applicationContext)) {
                this.restTemplateClient = new RestTemplateClient((RestTemplate)applicationContext.getBean("httpClientTemplate"));
            }
        }catch (Exception e) {
            logger.error("The alarm message callback thread failed to start {}", e.getMessage());
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    @Override
    public RestTemplateClient getObject() {
        return this.restTemplateClient;
    }

    @Override
    public Class<?> getObjectType() {
        return RestTemplateClient.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
