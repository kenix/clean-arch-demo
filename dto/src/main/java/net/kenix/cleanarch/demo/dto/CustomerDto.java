/*
* Created at 10:01 on 16.06.17
*/
package net.kenix.cleanarch.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

/**
 * @author zzhao
 */
@Data
@Builder
public class CustomerDto {

  private long id;

  private String firstName;

  private String lastName;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate birthday;

  @Singular
  private List<DeliveryInfoDto> deliveryInfos;

  @Singular
  private List<PaymentInfoDto> paymentInfos;
}
