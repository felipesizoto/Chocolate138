# #language: pt
#  Funcionalidade: Selecionar Produto na loja
#    Cenario: Selecionar Produto com Sucesso
#      Dado que acessa a loda SauceDemo
#      Quando preencho o usuário e senha
#      E clica em login
#      Entao exibi o título da página como "Products"
#      E exibe o link do carrinho de compras
#      Quando clica no produto "Sauce Labs Backpack"

  Feature: Select Product in Store
    Scenario: Selecting Product with Success
      Given I access SauceDemo store
      When I filled a user "standart_user" and "secret_sauce"
      And I click in login
      Then show pag's title "Products"
      And show cart's link
      When I click in product "Sauce Labs Bacpack"
      Then I verify the product title "Sauce Labs Backpack"
      And I verify the product price "$ 29.99"
      When I click in Add to Cart
      And I click in Cart icon
      Then I verify the page's title "Your Cart"
      And I verify the product title "Sauce Labs Backpack"
      And I verify the quantity is "1"
      And I verify the product price "$ 29.99"







