package com.zxb.druid.Config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.zxb.druid.Mapper.tpc",sqlSessionFactoryRef = "tpcSqlSessionFactory")
public class tpcDruid {
    @Bean(name = "tpc-datasource")
    @ConfigurationProperties("spring.tpc-datasource")
    public DataSource tpcDatasource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "tpcSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("tpc-datasource") DataSource dataSource) throws  Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/tpc/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
    @Bean(name = "tpcTransactionManager")
    public DataSourceTransactionManager tpcTransactionManager(){
        return new DataSourceTransactionManager(tpcDatasource());
    }
    @Bean(name = "tpcsqlSessionTemplate")
    public SqlSessionTemplate tpcsqlSessionTemplateOne(@Qualifier("tpcSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
