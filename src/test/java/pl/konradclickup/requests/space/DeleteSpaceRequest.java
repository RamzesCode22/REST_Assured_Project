package pl.konradclickup.requests.space;

import io.restassured.response.Response;
import pl.konradclickup.requests.BaseRequest;
import pl.konradclickup.url.ClickUpUrl;

import static io.restassured.RestAssured.given;

public class DeleteSpaceRequest {

    public static Response deleteSpace(String spaceId) {

        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .when()
                .delete(ClickUpUrl.getSpaceUrl(spaceId))
                .then()
                .log().ifError()
                .extract()
                .response();
    }

}
