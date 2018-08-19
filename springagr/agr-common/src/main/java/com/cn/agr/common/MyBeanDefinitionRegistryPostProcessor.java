package com.cn.agr.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.*;
import org.springframework.data.redis.core.StringRedisTemplate;



public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    private ScopeMetadataResolver scopeMetadataResolver = new AnnotationScopeMetadataResolver();
    private BeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // 这里可以设置属性，例如
        /*BeanDefinition bd = beanFactory.getBeanDefinition("dataSourceA");
        MutablePropertyValues mpv =  bd.getPropertyValues();
        mpv.addPropertyValue("driverClassName", "com.mysql.jdbc.Driver");
        mpv.addPropertyValue("url", "jdbc:mysql://localhost:3306/test");
        mpv.addPropertyValue("username", "root");
        mpv.addPropertyValue("password", "123456");*/
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        registerBean(registry, "stringRedisTemplate", StringRedisTemplate.class);
    }

    private void registerBean(BeanDefinitionRegistry registry, String name, Class<?> beanClass){
        AnnotatedGenericBeanDefinition abd = new AnnotatedGenericBeanDefinition(beanClass);

        ScopeMetadata scopeMetadata = this.scopeMetadataResolver.resolveScopeMetadata(abd);
        abd.setScope(scopeMetadata.getScopeName());
        // 可以自动生成name
        String beanName = (name != null ? name : this.beanNameGenerator.generateBeanName(abd, registry));

        AnnotationConfigUtils.processCommonDefinitionAnnotations(abd);

        BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(abd, beanName);
        BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder, registry);
    }

}
