
Criar um aplicativo para consultar a API do GitHub e trazer os repositó rios mais
populares de Java.

Exemplo de aplicação:

Deve conter
Lista de repositórios.
Exemplo de chamada na API:
https://api.github.com/search/repositories?q=language:Java&sort=stars&
page=1

Paginação na tela de lista, com endless scroll / scroll infinito (incrementando o
parâ metro page).
Cada repositório deve exibir Nome do repositó rio, Descrição do Repositório,
Nome / Foto do autor, Número de Stars, Número de Forks

Ao tocar em um item, deve levar a lista de Pull Requests do repositório
Pull Requests de um repositório.

Exemplo de chamada na API:
https://api.github.com/repos/<criador>/<repositório>/pulls
Cada item da lista deve exibir Nome do autor do PR, Título do PR, Data do PR e Body do PR
Observações:
• Pode utilizar a arquitetura desejada (MVC, MVVM, etc.)
• Mockup é meramente ilustrativa, poderá́ ser feito um layout diferente
• Projeto deve ser desenvolvido em Kotlin (Android) ou Swift (iOS)
• Itens adicionais obrigatórios para vaga de Sênior e diferenciais para vaga de
Júnior e Pleno:
o testes unitários
o testes instrumentados
o seguir boas práticas de acessibilidade (configuração para leitura de tela)
o programação reativa (reactive programming)
o injeção de dependências
