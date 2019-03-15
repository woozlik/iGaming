package models;

import lombok.Builder;
import lombok.Value;

@Builder @Value
public class SignUpRequest {
    @Builder.Default private String password = "fert4367HYDdsad#433";
    @Builder.Default private String currency = "EUR";
    private String email;
    @Builder.Default private String languageCode = "aa";
    @Builder.Default private String brandId = "redbox";
}