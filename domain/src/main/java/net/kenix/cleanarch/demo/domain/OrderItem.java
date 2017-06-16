/*
* Created at 22:18 on 15.06.17
*/
package net.kenix.cleanarch.demo.domain;

import lombok.Data;

/**
 * @author zzhao
 */
@Data
public class OrderItem {

  private long id;

  private Product product;

  private int quantity;
}
