package com.zxb.druid.Config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.zxb.druid.Mapper.ego",sqlSessionFactoryRef = "egoSqlSessionFactory")
public class egoDruid {
    @Bean(name = "ego-datasource")
    @ConfigurationProperties("spring.ego-datasource")
    @Primary
    public DataSource  egoDatasource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "egoSqlSessionFactory")
    @Primary
    public SqlSessionFactory  sqlSessionFactory(@Qualifier("ego-datasource") DataSource dataSource) throws  Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/ego/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "egoTransactionManager")
    @Primary
    public DataSourceTransactionManager egoTransactionManager(){
        return new DataSourceTransactionManager(egoDatasource());
    }

    @Bean(name = "egosqlSessionTemplate")
    @Primary
    public SqlSessionTemplate egosqlSessionTemplateOne(@Qualifier("egoSqlSessionFactory") SqlSessionFactory sqlSessionFactory)throws Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
