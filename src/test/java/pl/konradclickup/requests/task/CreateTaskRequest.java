package pl.konradclickup.requests.task;

import io.restassured.response.Response;
import org.json.JSONObject;
import pl.konradclickup.dto.request.CreateTaskRequestDto;
import pl.konradclickup.dto.response.CreateTaskResponseDto;
import pl.konradclickup.requests.BaseRequest;
import pl.konradclickup.url.ClickUpUrl;

import static io.restassured.RestAssured.given;

public class CreateTaskRequest {

    public static Response createTask(JSONObject task, String listId) {

        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .body(task.toString())
                .when()
                .post(ClickUpUrl.getTasksUrl(listId))
                .then()
                .log().ifError()
                .extract()
                .response();
    }

    public static CreateTaskResponseDto createTask(CreateTaskRequestDto taskDto, String listId) {

        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .body(taskDto)
                .when()
                .post(ClickUpUrl.getTasksUrl(listId))
                .then()
                .statusCode(200)
                .log().ifError()
                .extract()
                .response()
                .as(CreateTaskResponseDto.class);
    }
}
