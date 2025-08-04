package dev.alfrendosilalahi.leafbank.ms__account.dto.request;

import lombok.Data;

@Data
public class AccountRequestDto {

    private Long number;

    private String type;

    private String branchAddress;

}
