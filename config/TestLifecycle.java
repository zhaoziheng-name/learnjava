package niko.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class TestLifecycle implements BeanNameAware,
        BeanFactoryAware,
        ApplicationContextAware,
        BeanPostProcessor,
        InitializingBean,
        DisposableBean {

        //
        @Override
        public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

        }

        @Override
        public void setBeanName(String name) {

        }

        @Override
        public void destroy() throws Exception {

        }

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        }

        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                return null;
        }

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                return null;
        }

        @Override
        public void afterPropertiesSet() throws Exception {

        }
}
