// 1 - Pacote
package apitest;
// 2 - Bibliotecas

import com.google.gson.Gson;
import entities.AccountEntity;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.ITestContext;          // Interface do TestNG para compartilhar variaveis

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

// 3 - Classe
public class TestAccount {
    // 3.1 - Atributos

    String userID;
    String ct = "application/json"; // contentType da API
    String jsonBody; // variavel para guardar um json que será enviado
    String uri = "https://bookstore.toolsqa.com/Account/v1/"; // Endereço Base
    Response resposta; // guardar o retorno da API
    static String token; // guardar o token - autenticação do usuário


    // 3.1.2 Instanciar Classes Externas
    Gson gson = new Gson(); // Instancia o objeto de conversão classe para Json
    AccountEntity account = new AccountEntity(); // Instacia a entidade usuário

    // 3.2 - Métodos e Funções

    // Método #1 - Criar usuário
    @Test(priority = 1)
    public void testCreateUser(ITestContext context) {
        // Arrange - Configura

        // Forma utilizando a classe AccountEntity

        account.userName = "charlie991"; // entrada e saída ( resultado esperado)
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
        context.setAttribute("userID", userID);
        System.out.println("UserID extraído: " + userID);

    } // fim do método de criação do usuário

    @Test(priority = 2)
    public void testGenerateToken(ITestContext context){ // declarar a interface

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
        ;


        // Extração do Token
        token = resposta.jsonPath().getString("token");
        context.setAttribute("token", token);
        System.out.println("Token: " + token);

        // Valida
        Assert.assertTrue(token.length() != 0);

    } // fim do metódo de geração de token de identificação do usuário

    @Test(priority = 3)
    public void testAuthorized() {
        // Configura
        // Dados de Entrada
        // Fornecidos pela AccountEntity atráves do método testCreatUser - priority = 1


        // Dados de Saída
        // StatusCode = 200
        // Response Body = true


        // Executa
        given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri + "Authorized")
                // Valida
        .then()
                .log().all()
                .statusCode(200) // valida a comunicação
        //.body(is("true"))
        ;

    }

    @Test(priority = 4)
    public void testResearchtUserNoAuthorized() {

        // Configura
        // Dados de Entrada
        // userID foi extraido no metódo testCreateUser e está na memória
        // Dados de Saída / Resultado Esperado
        // Status Code = 401, Code = 401 e Message = User not authorized !

        // Executa
        given()                                 // Dado // Comandos do Rest-assured
                .contentType(ct)                // Formato da mensagem
                .log().all()                    // Exibir tudo que acontece na ida
        .when()                                 // Quando
                .get(uri + "User/" + userID) // Consulta o usuário pelo ID
                // Valida
        .then()                                 // Então
                .log().all()                    // Exibir tudo que acontece na volta
                .statusCode(401)             // Valida se não está autorizado
                .body("code", is("1200")) // Valida o nome do usuário
                .body("message", is("User not authorized!"))
        ;                                              // Conclui o bloco do Rest-assured
    }

    @Test(priority = 5)
    public void testResearchtUser() {
        // Configura
        // Dados de Entrada
        // userID foi extraido no metódo testCreateUser e está na memória
        // Dados de Saída
        // userName virá da classe Account e o status code deve ser 200

        // Executa
        given()                                                   // Dado // Comandos do Rest-assured
                .contentType(ct)                                  // Formato da mensagem
                .log().all()                                      // Exibir tudo que acontece na ida
                .header("Authorization", "Bearer " + token)
        .when()                                                   // Quando
                .get(uri + "User/" + userID)                   // Consulta o usuário pelo ID
                // Valida
        .then()                                                   // Então
                .log().all()                                      // Exibir tudo que acontece na volta
                .statusCode(200)                               // Valida se a conexão teve sucesso
                .body("userId", is(userID))                    // Valida o ID do usuário
                .body("username", is(account.userName));       // Valida o nome do usuário
    }
    @Test(priority = 6)
    public void testDeleteUser(){
        // Configura
        // Dados de entrada vem do metódo anterior
        // Resultado esperado é o código e mensagem de sucesso na exclusão do usuário

        // Executa
        given()
                .log().all()
                .contentType(ct)
                .header("Authorization", "Bearer " + token)
        .when()
                .delete(uri + "User/" + userID)
        // Valida
        .then()
                .log().all()
                .statusCode(204)
        ;
    }
}