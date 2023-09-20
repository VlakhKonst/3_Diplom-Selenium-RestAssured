package site.nomoreparties.stellarburgers;

import io.restassured.response.Response;
import site.nomoreparties.stellarburgers.models.delete.Delete;
import site.nomoreparties.stellarburgers.models.login.request.RequestLogin;
import site.nomoreparties.stellarburgers.models.login.response.ResponseLogin;
import site.nomoreparties.stellarburgers.models.registration.request.RequestRegistration;
import site.nomoreparties.stellarburgers.models.registration.response.ResponseRegistration;

import static io.restassured.RestAssured.given;
import static site.nomoreparties.stellarburgers.Environment.*;

public class Method {

    public Response registrationUser(RequestRegistration requestRegistration) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(requestRegistration)
                .when()
                .post(URL_REGISTRATION);
    }
    public Response deleteUserAfterLogin(Delete delete, ResponseLogin responseLogin) {
        return given()
                .header("Content-type", "application/json")
                .header("Authorization", responseLogin.getAccessToken())
                .and()
                .body(delete)
                .when()
                .delete(URL_DELETE);
    }
    public Response deleteUser(Delete delete, ResponseRegistration responseRegistration) {
        return given()
                .header("Content-type", "application/json")
                .header("Authorization", responseRegistration.getAccessToken())
                .and()
                .body(delete)
                .when()
                .delete(URL_DELETE);
    }
    public ResponseLogin loginUser(RequestLogin login) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(login)
                .when()
                .post(URL_LOGIN)
                .body()
                .as(ResponseLogin.class);
    }
}
