/*
* Created at 22:18 on 15.06.17
*/
package net.kenix.cleanarch.demo.domain;

import java.time.LocalDate;
import java.util.List;
import lombok.Data;

/**
 * @author zzhao
 */
@Data
public class Customer {

  private long id;

  private String firstName;

  private String lastName;

  private LocalDate birthday;

  private List<DeliveryInfo> deliveryInfos;

  private List<PaymentInfo> paymentInfos;
}
