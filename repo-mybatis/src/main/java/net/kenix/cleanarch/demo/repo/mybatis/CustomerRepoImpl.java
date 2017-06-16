/*
* Created at 18:53 on 16.06.17
*/
package net.kenix.cleanarch.demo.repo.mybatis;

import lombok.RequiredArgsConstructor;
import net.kenix.cleanarch.demo.domain.Customer;
import net.kenix.cleanarch.demo.repo.CustomerRepo;
import net.kenix.cleanarch.demo.repo.mybatis.mapper.CustomerMapper;

/**
 * @author zzhao
 */
@RequiredArgsConstructor
public class CustomerRepoImpl implements CustomerRepo {

  private final CustomerMapper customerMapper;

  @Override
  public Customer findById(Long id) {
    return this.customerMapper.selectCustomer(id);
  }
}
