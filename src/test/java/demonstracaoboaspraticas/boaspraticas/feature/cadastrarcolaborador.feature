  Feature: Cadastrar Colaborador
    Como um analista de recursos humanos
    Eu quero cadastrar um colaborador no sistema
    Para que eu possa relacionar esta pessoa junto com as demais ao hall de colaboradores da empresa

    Scenario: Deve cadastrar um colaborador externo no sistema
      Given que necessito cadastrar um colaborador externo com os dados basicos suficientes
      When um novo colaborador da area externo e contratado
      Then a aplicacao deve retornar que o colaborador externo foi cadastro com suceso

    Scenario: Deve cadastrar um colaborador de interno no sistema
      Given que o cpf do analista é valido e o numero é "711.331.430-91"
      Given que o nome do analista é "Augusto Barbosa"
      Given que o telefone do analista é "11956418889"
      Given que o tipo do analista é "interno"
      Given que o salario do analista é 5000.00
      When um novo colaborador da area de arquitetura esta sendo contratado
      Then a aplicacao deve retornar que o colaborador de arquitetura foi cadastro com suceso na base
