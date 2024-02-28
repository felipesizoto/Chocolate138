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
    Gson gson = new Gson(); // instaciar
    @Test
    public void testCreateuser(){
        // Configura
        //Dados de Entrada
        UserEntity user = new UserEntity();
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
}
