/*
* Created at 19:03 on 16.06.17
*/
package net.kenix.cleanarch.demo.repo.mybatis.mapper;

import net.kenix.cleanarch.demo.domain.Customer;

/**
 * @author zzhao
 */
public interface CustomerMapper {

  Customer selectCustomer(long id);
}
