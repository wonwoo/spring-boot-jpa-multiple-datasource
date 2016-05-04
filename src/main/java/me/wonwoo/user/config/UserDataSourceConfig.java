package me.wonwoo.user.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by wonwoo on 2016. 5. 4..
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "userEntityManagerFactory",
  transactionManagerRef = "userTransactionManager",
  basePackages = {"me.wonwoo.user.repository"})
public class UserDataSourceConfig {

  @Bean(name = "userDataSource")
  @ConfigurationProperties(prefix = "user.datasource")
  public DataSource userDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "userEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean userEntityManagerFactory(
    EntityManagerFactoryBuilder builder, @Qualifier("userDataSource") DataSource userDataSource) {
    return builder
      .dataSource(userDataSource)
      .packages("me.wonwoo.user.domain")
      .persistenceUnit("user")
      .build();
  }

  @Bean(name = "userTransactionManager")
  public PlatformTransactionManager userTransactionManager(
    @Qualifier("userEntityManagerFactory") EntityManagerFactory userEntityManagerFactory) {
    return new JpaTransactionManager(userEntityManagerFactory);
  }
}
