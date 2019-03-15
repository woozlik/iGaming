package requests;

import io.restassured.response.Response;
import models.SigninPlayerRequest;

import static io.restassured.RestAssured.given;

public class Auth {
    public static Response postSignIn(SigninPlayerRequest signinPlayerRequest) {
        return
                given().
                    contentType("application/json").
                    body(signinPlayerRequest).
                when().
                    post("/auth/signin").
                then().
                    assertThat().
                        statusCode(200).
                extract().
                        response();
    }
}
