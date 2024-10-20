package com.grpc.accounts.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "accounts")
@Getter
@Setter
public class AccountsContactInfoClassDto {

    String message;

    Map<String, String> contactDetails;

    List<String> onLocalSupport;
}
