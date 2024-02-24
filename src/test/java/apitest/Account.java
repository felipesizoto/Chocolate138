// 1 - Pacote
package apitest;
// 2 - Bibliotecas

import com.google.gson.Gson;
import entities.AccountEntitiy;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

// 3 - Classe
public class Account {
    // 3.1 - Atributos

    String userID;
    String ct = "application/json"; // contentType da API
    String jsonBody; // variavel para guardar um json que será enviado
    String uri = "https://bookstore.toolsqa.com/Account/v1/"; // Endereço Base
    Response resposta; // guardar o retorno da API
    String token; // guardar o token - autenticação do usuário

    // 3.1.2 Instanciar Classes Externas
    Gson gson = new Gson(); // Instancia o objeto de conversão classe para Json
    // 3.2 - Métodos e Funções 

    // Método #1 - Criar usuário
    @Test(priority = 1)
    public void testCreateUser(){
        // Arrange - Configura

        // Forma utilizando a classe AccountEntity
        AccountEntitiy account = new AccountEntitiy(); // Instacia a entidade usuário
        account.userName = "charlie189"; // entrada e saída ( resultado esperado)
        account.password = "P@ssw0rd!";  // entrada

        jsonBody = gson.toJson(account); // Converte a entidade usuário no formato Json

        // Act - Executa

        // Dado - Quando - Então
        // Given - When - Then

        resposta = (Response) given()      // dado
                .contentType(ct) // tipo do conteudo
                .log().all()                        // registre tudo na ida
                .body(jsonBody)    // corpo da mensagem que será enviada
        .when() // quando
                .post(uri + "User")
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

   @Test (priority = 2)
    public void testGenerateToken(){

        // Configura
        // --> Dados de Entrada são fornecidos pela AccountEntity
        // --> Resultado Esperado é que ele receba um token

        // Executa
        resposta = (Response) given()                // dado
                .contentType(ct) // tipo do conteudo
                .log().all()                        // registre tudo na ida
                .body(jsonBody)
        .when()
                .post(uri + "GenerateToken")
        .then()
                .log().all()
                .statusCode(200) // valida a comunicação
                .body("status", is("Success")) // Status = Sucesso
                .body("result", is("User authorized successfully."))
        .extract()
        ;1


        // Extração do Token
        token = resposta.jsonPath().getString("token");
        System.out.println("Token: " + token);

        // Valida
       Assert.assertTrue(token.length() != 0);

    } // fim do metódo de geração de token de identificação do usuário

}
