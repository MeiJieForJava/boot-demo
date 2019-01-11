package com.boot.global.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@SpringBootConfiguration
@ConfigurationProperties(prefix = "spring.datasource.pop")
@PropertySource(value = {"classpath:db.properties", "classpath:important.properties"})
@MapperScan(value = "com.boot.dao.pop", sqlSessionFactoryRef = "popSqlSessionFactory")
@Data
public class PopDruidDataSourceConfig {
    private String name;
    private String url;
    private String username;
    private String password;
    private String type;
    private String driverClassName;
    private String filters;
    private int maxActive;
    private int initialSize;
    private int maxWait;
    private int minIdle;
    private int timeBetweenEvictionRunsMillis;
    private int minEvictableIdleTimeMillis;
    private boolean testWhileIdle;
    private String validationQuery;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private boolean poolPreparedStatements;
    private int maxOpenPreparedStatements;
    private int maxPoolPreparedStatementPerConnectionSize;
    private String connectionProperties;

    @Bean(name = "popDataSource",initMethod="init",destroyMethod = "close")
    @Primary
    public DruidDataSource testDataSource() throws Exception{
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMaxActive(maxActive);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxWait(maxWait);
        dataSource.setMinIdle(minIdle);
        dataSource.setTimeBetweenConnectErrorMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
//        dataSource.setConnectionProperties(connectionProperties);
//        dataSource.setFilters("mergeStat,wall,log4j");//mergeStat代替stat表示sql合并,wall表示防御SQL注入攻击
        /*try {
            dataSource.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return dataSource;
    }

    @Bean(name = "popSqlSessionFactory")
    @Primary
    public SqlSessionFactory popSessionFactory(@Qualifier("popDataSource")DataSource testDataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(testDataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("mapper/pop/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "popTransactionManager")
    @Primary
    public PlatformTransactionManager popTransactionManager(@Qualifier("popDataSource")DataSource popDataSource) {
        return new DataSourceTransactionManager(popDataSource);
    }
}
