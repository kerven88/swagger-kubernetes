package club.mydlq.swagger.kubernetes.config;

import club.mydlq.swagger.kubernetes.param.SwaggerAutoConfig;
import club.mydlq.swagger.kubernetes.swagger.SwaggerResources;
import club.mydlq.swagger.kubernetes.swagger.SwaggerUIMvcConfig;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 开启 Swagger 配置
 */
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
@EnableConfigurationProperties(SwaggerAutoConfig.class)
public class SwaggerConfig {

    @Autowired
    private SwaggerAutoConfig swaggerAutoConfig;

    @Bean
    @Primary
    public SwaggerResources swaggerResourcesProcessor() {
        return new SwaggerResources(swaggerAutoConfig);
    }

    @Bean
    public SwaggerUIMvcConfig swaggerUIModifyMvcConfig() {
        return new SwaggerUIMvcConfig();
    }

}
