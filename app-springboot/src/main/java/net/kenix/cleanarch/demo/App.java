/*
* Created at 18:42 on 16.06.17
*/
package net.kenix.cleanarch.demo;

import net.kenix.cleanarch.demo.converter.EntityConverter;
import net.kenix.cleanarch.demo.repo.CustomerRepo;
import net.kenix.cleanarch.demo.repo.mybatis.CustomerRepoImpl;
import net.kenix.cleanarch.demo.repo.mybatis.mapper.CustomerMapper;
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

  @Bean
  EntityConverter entityConverter() {
    return new EntityConverter();
  }

  @Bean
  CustomerRepo customerRepo(CustomerMapper customerMapper) throws Exception {
    return new CustomerRepoImpl(customerMapper);
  }
}
