package org.igaming;

import models.SignUpRequest;
import models.SigninPlayerRequest;
import org.junit.Test;
import requests.Auth;

import static net.andreinc.mockneat.unit.user.Emails.emails;
import static org.hamcrest.core.IsEqual.equalTo;
import static requests.Profile.createPlayer;
import static requests.Profile.getPlayerProfile;

public class ProfileTest extends BaseTest {
    @Test(timeout = 500000)
    public void bonusBalanceAmountShouldBeZeroForNewProfile() throws InterruptedException {
        final String email = emails().val();

        SignUpRequest signUpRequest = SignUpRequest.builder().email(email).build();
        String playerUUID = createPlayer(signUpRequest).path("playerUUID");

        SigninPlayerRequest signinPlayerRequest = SigninPlayerRequest.builder().login(email).build();
        String token = Auth.postSignIn(signinPlayerRequest).path("token");

        getPlayerProfile(playerUUID, token)
                .then()
                    .assertThat()
                .body("bonusBalance.amount", equalTo(0));
    }
}
