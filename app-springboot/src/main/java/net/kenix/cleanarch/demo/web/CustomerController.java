/*
* Created at 09:51 on 16.06.17
*/
package net.kenix.cleanarch.demo.web;

import lombok.RequiredArgsConstructor;
import net.kenix.cleanarch.demo.converter.EntityConverter;
import net.kenix.cleanarch.demo.dto.CustomerDto;
import net.kenix.cleanarch.demo.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzhao
 */
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
@RestController
@RequestMapping(path = "customer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CustomerController {

  private final EntityConverter entityConverter;

  private final CustomerRepo customerRepo;

  @GetMapping("{id}")
  CustomerDto getCustomer(@PathVariable long id) {
    return this.entityConverter.fromCustomer(this.customerRepo.findById(id));
  }
}
