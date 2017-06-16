/*
* Created at 10:02 on 16.06.17
*/
package net.kenix.cleanarch.demo.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author zzhao
 */
@Data
@Builder
public class PaymentInfoDto {

  private long id;

  private String cardNum;
}
