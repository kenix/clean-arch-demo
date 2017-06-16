/*
* Created at 18:33 on 16.06.17
*/
package net.kenix.cleanarch.demo.converter;

import net.kenix.cleanarch.demo.domain.Customer;
import net.kenix.cleanarch.demo.domain.DeliveryInfo;
import net.kenix.cleanarch.demo.domain.PaymentInfo;
import net.kenix.cleanarch.demo.dto.CustomerDto;
import net.kenix.cleanarch.demo.dto.CustomerDto.CustomerDtoBuilder;
import net.kenix.cleanarch.demo.dto.DeliveryInfoDto;
import net.kenix.cleanarch.demo.dto.PaymentInfoDto;

/**
 * @author zzhao
 */
public class EntityConverter {

  public CustomerDto fromCustomer(Customer customer) {
    final CustomerDtoBuilder builder =
        CustomerDto
            .builder()
            .id(customer.getId())
            .firstName(customer.getFirstName())
            .lastName(customer.getLastName());

    if (customer.getDeliveryInfos() != null) {
      customer.getDeliveryInfos().forEach(di -> builder.deliveryInfo(fromDeliveryInfo(di)));
    }

    if (customer.getPaymentInfos() != null) {
      customer.getPaymentInfos().forEach(pi -> builder.paymentInfo(fromPaymentInfo(pi)));
    }

    return builder.build();
  }

  public DeliveryInfoDto fromDeliveryInfo(DeliveryInfo deliveryInfo) {
    return DeliveryInfoDto.builder()
        .id(deliveryInfo.getId())
        .address(deliveryInfo.getAddress())
        .build();
  }

  public PaymentInfoDto fromPaymentInfo(PaymentInfo paymentInfo) {
    return PaymentInfoDto.builder()
        .id(paymentInfo.getId())
        .cardNum(paymentInfo.getCardNum())
        .build();
  }
}
