package entities;

public class LoanEntity {
    public String userId;
    public ISBN[] collectionOfIsbns; // Lista com os códigos dos livros emprestado
    public String isbn; // código do livro externo

    public static class ISBN {
        private final String isbn;    // código do livro interno
        public ISBN(String isbn){       // Construtor
            this.isbn = isbn;
        }
    }
}
