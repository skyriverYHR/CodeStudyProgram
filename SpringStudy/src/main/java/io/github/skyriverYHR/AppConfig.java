package io.github.skyriverYHR;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import javax.sql.DataSource;

@Configuration
@ComponentScan("io.github.skyriverYHR")
@MapperScan("io.github.skyriverYHR.mapper") //Mybatis需要专门扫描处理
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {
    /**
     * 这是Thymeleaf配置方法
     * @return 返回页面处理器
     */
    //这是一个Thymeleaf的配置信息
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setCacheable(false);
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());
        engine.setEnableSpringELCompiler(true); // 开启 Spring EL 表达式支持
        return engine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8"); // 确保中文不乱码
        return viewResolver;
    }

    //资源搜索配置
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 这行代码的意思是：当 HTML 请求 /static/xxx 时，去 resources/static/ 目录下找
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

    /**
     * 数据库配置
     * @return mybatis 工厂
     * @throws Exception
     */
    //资源扫描类名，不需要在mybatis导入类时全局搜索
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());

        // 【核心配置】：指定实体类所在的包(数据读取后的封装)
        factoryBean.setTypeAliasesPackage("io.github.skyriverYHR.entity");

        //读取xml文件
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));

        // ... 其他配置 (如 MapperLocations)
        return factoryBean.getObject();
    }

    /**
     * 数据库登录数据
     * @return 数据库登录资源
     */
    @Bean
    public DataSource dataSource() {
        // 1. 定义数据源（电源）
        //添加需要用到的数据库的必要数据
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/expenditure");
        ds.setUsername("root");
        ds.setPassword("123456");
        return ds;
    }
}
