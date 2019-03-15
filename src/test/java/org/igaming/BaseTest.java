package org.igaming;

import io.restassured.RestAssured;

abstract public class BaseTest {
    BaseTest(){
        RestAssured.baseURI = "https://api.dev.hrzn.io";
    }
}
