/*
* Created at 22:18 on 15.06.17
*/
package net.kenix.cleanarch.demo.domain;

import lombok.Data;

/**
 * @author zzhao
 */
@Data
public class Product {

  private long id;

  private String name;

  private String producer;
}
