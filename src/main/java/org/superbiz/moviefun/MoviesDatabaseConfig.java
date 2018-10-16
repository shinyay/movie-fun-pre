package org.superbiz.moviefun;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration
public class MoviesDatabaseConfig {

    @Bean
    public DataSource moviesDataSource(DatabaseServiceCredentials serviceCredentials) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(serviceCredentials.jdbcUrl("movies-mysql"));
        return dataSource;
    }

    @Bean
    LocalContainerEntityManagerFactoryBean moviesEntityManagerFactory(DataSource moviesDataSource, HibernateJpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(moviesDataSource);
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setPackagesToScan(DatabaseConfig.class.getPackage().getName());
        factoryBean.setPersistenceUnitName("movies");
        return factoryBean;
    }
}
