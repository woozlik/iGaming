package requests;

import io.restassured.response.Response;
import models.SignUpRequest;

import static io.restassured.RestAssured.given;

public class Profile {
    public static Response createPlayer(SignUpRequest signUpRequest) {
        return
                given().
                    contentType("application/json").
                    body(signUpRequest).
                when().
                    post("/profile/public/signup?send-mail=false").
                then().
                    assertThat().
                        statusCode(200).
                    extract().
                        response();
    }

    public static Response getPlayerProfile(String playerUUID, String token) throws InterruptedException {
        Response profileRespone;
        do {
            Thread.sleep(1000);
            profileRespone =
                    given().
                            contentType("application/json").
                            header("Authorization", "Bearer " + token).
                    when().
                            get("/profile/profiles/" + playerUUID);

        } while (profileRespone.statusCode() != 200);

        return profileRespone;
    }
}
