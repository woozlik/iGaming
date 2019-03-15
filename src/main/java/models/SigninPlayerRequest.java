package models;

import lombok.Builder;
import lombok.Value;

@Builder @Value
public class SigninPlayerRequest {
    @Builder.Default private String password = "fert4367HYDdsad#433";
    @Builder.Default private String brandId = "redbox";
    private String login;
}
