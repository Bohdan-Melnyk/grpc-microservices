package com.grpc.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(
        name = "ErrorResponse",
        description = "Schema, that contains error response information"
)
public class ErrorResponseDto {

    @Schema(
            description = "Api path"
    )
    private String apiPath;

    @Schema(
            description = "Error code"
    )
    private HttpStatus errorCode;

    @Schema(
            description = "Error message"
    )
    private String errorMessage;

    @Schema(
            description = "Time of the error"
    )
    private LocalDateTime errorTime;
}
