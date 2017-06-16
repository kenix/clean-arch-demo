/*
* Created at 22:18 on 15.06.17
*/
package net.kenix.cleanarch.demo.domain;

import java.util.List;

/**
 * @author zzhao
 */
public class Order {

  private long id;

  private List<OrderItem> items;

  private Customer customer;

  private DeliveryInfo deliveryInfo;

  private PaymentInfo paymentInfo;
}
