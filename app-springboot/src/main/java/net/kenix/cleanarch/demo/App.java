/*
* Created at 18:42 on 16.06.17
*/
package net.kenix.cleanarch.demo;

import javax.sql.DataSource;
import net.kenix.cleanarch.demo.converter.EntityConverter;
import net.kenix.cleanarch.demo.repo.CustomerRepo;
import net.kenix.cleanarch.demo.repo.mybatis.RepoFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zzhao
 */
@EnableTransactionManagement
@SpringBootApplication
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  @Autowired
  private DataSource dataSource;

  @Bean
  EntityConverter entityConverter() {
    return new EntityConverter();
  }

  @Bean
  RepoFactory repoFactory() {
    final Environment env = new Environment("development",
        new JdbcTransactionFactory(), this.dataSource);
    final Configuration configuration = new Configuration(env);
    return new RepoFactory(configuration);
  }

  @Bean
  CustomerRepo customerRepo() {
    return repoFactory().getCustomerRepo();
  }
}
