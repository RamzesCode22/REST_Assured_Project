package pl.konradclickup.requests.task;

import io.restassured.response.Response;
import org.json.JSONObject;
import pl.konradclickup.properties.ClickUpProperties;
import pl.konradclickup.requests.BaseRequest;
import pl.konradclickup.url.ClickUpUrl;

import static io.restassured.RestAssured.given;

public class UpdateTaskRequest {
    public static Response updateTask(JSONObject updateTask, String taskId) {

        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .body(updateTask.toString())
                .when()
                .put(ClickUpUrl.getTaskUrl(taskId))
                .then()
                .statusCode(200)
                .log().ifError()
                .extract()
                .response();
    }

}
