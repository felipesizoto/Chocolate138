package apitest;

import com.google.gson.Gson;
import entities.LoanEntity;
import org.testng.annotations.*;
import org.testng.ITestContext;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class TestBookStore {
    String uri = "https://bookstore.toolsqa.com/BookStore/v1/"; // Endereço Base

    String ct = "application/json";
    TestAccount account = new TestAccount();
    LoanEntity isbn = new LoanEntity(); // Instacia para a lista de livros
    Gson gson = new Gson();
    public ITestContext context;

    @BeforeClass // Antes da classe de todos os testes dentro dela
    // @BeforeMethod // Antes de cada teste
    public void setUp(ITestContext context){

        account.testCreateUser(context);     // cria um novo usuário
        account.testGenerateToken(context);  // gera um novo token
    }
    @AfterClass // Depois da classe e de todos os testes dentro dela
    // @AfterMethod // Depois de cada teste
    public void tearDown() throws InterruptedException { // trows InterruptedException, é uma exceção, utilizada devido o uso do Thread.sleep(3000)
        //account.testResearchUser();
        //Thread.sleep(3000); // espera bruta - algo para ser usado, mas para não ser deixado no código em definitivo - como um alfinete, deve ser removido da roupa antes da mesma ser entregue em definitivo
        account.testDeleteUser(); // exclui o usuário
    }

    @Test(priority = 1)
    public void testResearchBooks(ITestContext context){
        // Configura
        // Dados de entrada não são requeridos - basta chamar o endpoint
        // Resultado esperado é apenas o status code 200 e um json com a lista de livros

        // Executa
        given()
                .log().all()
                .contentType(ct)
                .header("Authorization", "Bearer " + context.getAttribute("token"))
                .when()
                .get(uri + "Books") // consultar a lista om todos os livros
                // Valida
                .then()
                .log().all()
                .statusCode(200)
        ;
    }

    @Test(priority = 2)
    public void testLoanBooks(ITestContext context){ // Emprestar Livros
        // Configura
        // Dados de entrada
        // userID virá pelo context
        isbn.userId = context.getAttribute("userID").toString(); // código do usuário
        isbn.collectionOfIsbns = new LoanEntity.ISBN[] {
                new LoanEntity.ISBN("9781449325862")
        };
        // isbn.isbn = "9781449325862"; // código do livro

        // Dados de saída
        // statusCode = 201
        // Retorne o isbn do livro (echo)

        // Executa
        given()
                .log().all()
                .contentType(ct)
                .header("Authorization", "Bearer " + context.getAttribute("token"))
                .body(gson.toJson(isbn))
                .when()
                .post(uri + "Books")
                // Valida
                .then()
                .log().all()
                .statusCode(201)
                .body("isbn", is(isbn.isbn))
        ;
    }
    @Test(priority = 3)
    public void testUpdateBooks(ITestContext context){ // Atualizar quem está com qual livro
        // Configura
        // Dados de entrada
        // userId é extraído no BeforeMethod
        String isbnAntigo = "9781449325862";
        String isbnNovo = "9781449331818";

        // Alimentar a classe LoanEntity apenas com o código do usuário e o isbn
        isbn = new LoanEntity(); // reiniciando o objeto da classe LoanEntity
        isbn.userId = context.getAttribute("userID").toString(); // código do usuário
        isbn.isbn = isbnNovo; // código do livro novo

        // Executa
        given()
                .log().all()
                .contentType(ct)
                .header("Authorization", "Bearer " + context.getAttribute("token"))
                .body(gson.toJson(isbn))
                .when()
                .put(uri + "Books/" + isbnAntigo)
                // Valida
                .then()
                .log().all()
                .statusCode(200)
                .body("books[0].isbn", is(isbnNovo))
        ;
    }




    @Test(priority = 4)
    public void testDeleteLoans(ITestContext context){
        // Configura
        // userId vem do BeforeClass
        // statusCode = 204

        // Executa
        given()
                .log().all()
                .contentType(ct)
                .header("Authorization", "Bearer " + context.getAttribute("token"))
        .when()
                .delete(uri + "Books?UserId=" + context.getAttribute("userID").toString())
        // Valida
        .then()
                .log().all()
                .statusCode(204)
        ;
    }



}