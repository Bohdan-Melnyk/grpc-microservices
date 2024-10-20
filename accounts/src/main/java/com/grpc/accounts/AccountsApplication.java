package com.grpc.accounts;

import com.grpc.accounts.dto.AccountsContactInfoClassDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableFeignClients
@SpringBootApplication
@EnableConfigurationProperties(value = {/*AccountsContactInfoDto.class,*/ AccountsContactInfoClassDto.class})
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Accounts microservice REST API Documentation",
                description = "EazyBank Accounts REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Bohdan Melnyk",
                        email = "bodyamelnyk1998@gmail.com",
                        url = "*"
                ),
                license = @License(
                        name = "Spring",
                        url = "https://spring.io/"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "EazyBank Accounts REST API Documentation",
                url = "*"
        )
)
public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }

}
