# devWebAvancado
REST API de um CMS para Desenvolvimento Web Avançado.

<*> ENDPOINTS DA API (até então) <*>

Atividade ("/atividades"):
  -listarAtividade ('Retorna todas as atividades')  { GET }
  -obterAtividade ('Retorna uma atividade com base no id')  { GET }-----("/{id}")
  -criarAtividade ('Insere uma atividade')   { POST }
  -atualizarAtividade ('Atualiza os dados de uma atividade com base no id')   { PUT }-----("/{id}")
  -deletarAtividade ('Deleta uma atividade com base no id')   { DELETE }-----("/{id}")

Edicao ("/edicoes"):
  -listarEdicao ('Retorna todas as edições')   { GET }
  -obterEdicao ('Retorna uma edição com base no id')   { GET }-----("/{id}")
  -criarEdicao ('Insere uma edição')   { POST }
  -atualizarEdicao ('Atualiza os dados de uma edição com base no id. Seta a afiliação de um Usuario como Organizador')   { PUT }-----("/{id}")
  -deletarEdicao ('Deleta uma edição com base no id')   { DELETE }-----("/{id}")

Evento ("/eventos"):
  -listarEvento ('Retorna todas os eventos')   { GET }
  -obterEvento ('Retorna um evento com base no id')   { GET }-----("/{id}")
  -criarEvento ('Insere um evento')   { POST }
  -atualizarEvento ('Atualiza os dados de uma edição com base no id')   { PUT }-----("/{id}")
  -deletarEvento ('Deleta uma edição com base no id')   { DELETE }-----("/{id}")

Espaco ("/espacos"):
  -listarEspacos ('Retorna todas os espaços')   { GET }
  -obterEspaco ('Retorna um espaço com base no id')   { GET }-----("/{id}")
  -criarEspaco ('Insere uma espaço')   { POST }
  -atualizarEspaco ('Atualiza os dados de um espaço com base no id')   { PUT }-----("/{id}")
  -deletarEspaco ('Deleta um espaço com base no id')   { DELETE }-----("/{id}")

Usuario ("/usuarios"):
  -listarUsuarios ('Retorna todos os usuarios')   { GET }
  -obterUsuario ('Retorna um usuário com base no id')   { GET }-----("/{id}")
  -criarUsuario ('Insere um usuário. Sua afiliação por padrão vem como Usuario')   { POST }
  -atualizarUsuario ('Atualiza os dados de um usuário com base no id')   { PUT }-----("/{id}")
  -deletarUsuario ('Deleta um usuário com base no id')   { DELETE }-----("/{id}")
  -favoritarAtividade ('Favorita (insere numa lista) uma atividade existente com base no id do usuário e id da atividade')   { POST }-----("/{usuarioId}/favoritar/{atividadeId}")
