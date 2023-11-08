Feature: Consultar Colaborador
  Como um analista de recursos humanos
  Eu quero consultar um colaborador no sistema
  Para que eu possa analisar os dados relacionados a esta pessoa

  Scenario: Deve consultar um colaborador no sistema por ID
    Given existe um colaborador cadastrado no sistema
    When preciso consultar os dados de um colaborador
    Then a aplicacao deve retornar os dados do colaborador