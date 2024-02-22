// 1 - Pacote
package apitest;
// 2 - Bibliotecas

import com.google.gson.Gson;
import entities.AccountEntitiy;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

// 3 - Classe
public class Account {
    // 3.1 - Atributos

    String userID;

    // 3.1.2 Instanciar Classes Externas
    Gson gson = new Gson(); // Instancia o objeto de conversão classe para Json
    // 3.2 - Métodos e Funções 

    // Método #1 - Criar usuário
    @Test
    public void testCreateUser(){
        // Arrange - Configura

        // Forma utilizando a classe AccountEntity
        AccountEntitiy account = new AccountEntitiy(); // Instacia a entidade usuário
        account.userName = "charlie198"; // entrada e saída ( resultado esperado)
        account.password = "P@ssw0rd!";  // entrada

        String jsonBody = gson.toJson(account); // Converte a entidade usuário no formato Json

        // Act - Executa

        // Dado - Quando - Então
        // Given - When - Then

        Response resposta = (Response) given()      // dado
                .contentType("application/json") // tipo do conteudo
                .log().all()                        // registre tudo na ida
                .body(jsonBody)    // corpo da mensagem que será enviada
        .when() // quando
                .post("https://bookstore.toolsqa.com/Account/v1/User")
        // Assert - Valida
        .then() // então
                .log().all()      // registre tudo na volta
                .statusCode(201)      // valide a comunicação
                .body("username", is(account.userName)) // valida o usuário
                .extract()
        ; // fim da linha do REST-assured

            // extrair o userID(identificação do usuário)

        userID = resposta.jsonPath().getString("userID");
        System.out.println("UserID extraído: " + userID);

    } // fim do método de criação do usuário

    public void testGenerateToken(){

        // Configura
        // Executa
        //Valida


    } // fim do metódo de geração de token de identificação do usuário

}
