package dev.alfrendosilalahi.eazybank.account.config.properties;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties(prefix = "account")
public class AccountConfigProperties {

    private String message;

    private Map<String, String> contactDetails;

    private List<String> onCallSupport;

}
