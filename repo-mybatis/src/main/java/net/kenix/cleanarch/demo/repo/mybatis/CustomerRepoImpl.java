/*
* Created at 18:53 on 16.06.17
*/
package net.kenix.cleanarch.demo.repo.mybatis;

import net.kenix.cleanarch.demo.domain.Customer;
import net.kenix.cleanarch.demo.repo.CustomerRepo;
import net.kenix.cleanarch.demo.repo.mybatis.mapper.CustomerMapper;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author zzhao
 */
public class CustomerRepoImpl extends RepoBaseMyBatis implements CustomerRepo {

  public CustomerRepoImpl(SqlSessionFactory sqlSessionFactory) {
    super(sqlSessionFactory);
  }

  @Override
  public Customer findById(Long id) {
    return withSession(
        sqlSessionFactory -> sqlSessionFactory.openSession(ExecutorType.REUSE),
        sqlSession -> sqlSession.getMapper(CustomerMapper.class).selectCustomer(id)
    );
  }
}
