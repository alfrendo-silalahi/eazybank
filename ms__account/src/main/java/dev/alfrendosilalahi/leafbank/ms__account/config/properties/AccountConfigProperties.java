package dev.alfrendosilalahi.leafbank.ms__account.config.properties;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "account")
public class AccountConfigProperties {

    private String message;

    private Map<String, String> contactDetails;

    private List<String> onCallSupport;

}
