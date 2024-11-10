package dev.alfrendosilalahi.eazybank.account.dto.request;

import lombok.Data;

@Data
public class AccountRequestDto {

    private Long number;

    private String type;

    private String branchAddress;

}
