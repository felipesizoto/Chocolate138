package apiPetStore;

import com.google.gson.Gson;
import entities.UserEntity;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;



public class User {
    // Atributos
    String jsonBody;
    String ct = "application/json";
    String uri = "https://petstore.swagger.io/v2/";
    UserEntity user = new UserEntity();
    Gson gson = new Gson(); // instaciar
    @Test(priority = 1)
    public void testCreateUser(){
        // Configura
        //Dados de Entrada

        user.id = 999;
        user.username = "charlie";
        user.firstName = "charlie";
        user.lastName = "brown";
        user.email = "charlie@iterasys.com.br";
        user.password = "123456";
        user.phone = "11 99887755";
        user.userStatus = 0;

        jsonBody = gson.toJson(user);
        
        // Dados de Saída / Resultado Esperado
        int code = 200;
        String type = "unknown";
        String message = "999";

        // Executa

        given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri + "user")

        // Valida
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(code))
                .body("type", is(type))
                .body("message", is(message))
        ;

    }
    @Test(priority = 2)
    public void ResearchUser() {

            // Executa
            given()
                    .contentType(ct)
                    .log().all()
                    .when()
                    .get(uri + "user/" + user.username)
                    // Valida
                    .then()
                    .log().all()
                    .statusCode(200)
                    .body("id", is(user.id))
                    .body("username", is(user.username))
                    .body("firstName", is(user.firstName))
                    .body("lastName", is(user.lastName))
                    .body("email", is(user.email))
                    .body("password", is(user.password))
                    .body("phone", is(user.phone))
                    .body("userStatus", is(user.userStatus))
                  ;
        }

    @Test(priority = 3)
    public void testDeleteUser() {
        // Configura
        // Dados de entrada vem do metódo anterior
        // Resultado esperado é o código e mensagem de sucesso na exclusão do usuário

        // Executa
        given()
                .log().all()
                .contentType(ct)
        .when()
                .delete(uri + "user/charlie")
                // Valida
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is("charlie"))
        ;
    }
}
