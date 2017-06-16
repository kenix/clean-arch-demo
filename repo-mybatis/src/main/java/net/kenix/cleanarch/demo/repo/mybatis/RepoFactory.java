/*
* Created at 19:02 on 16.06.17
*/
package net.kenix.cleanarch.demo.repo.mybatis;

import lombok.Getter;
import net.kenix.cleanarch.demo.repo.CustomerRepo;
import net.kenix.cleanarch.demo.repo.mybatis.mapper.CustomerMapper;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author zzhao
 */
@Getter
public class RepoFactory {

  private final CustomerRepo customerRepo;

  public RepoFactory(Configuration configuration) {
    configuration.addMapper(CustomerMapper.class);
    final SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    this.customerRepo = new CustomerRepoImpl(sqlSessionFactory);
  }
}
