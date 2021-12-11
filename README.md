# Twitter-NLP
Projeto que integra a plataforma Twitter e processamento de linguagens naturais. Cada tweet antes de ser enviado à plataforma, é analisado por um módulo que verifica se possui conteúdo agressivo (xingamentos, insultos, entreoutros). Caso afirmativo, o tweet não é publicado. Os tweets DEVEM ser escritos em INGLÊS.
# Como executar ?
- Crie uma conta de desenvolvedor do Twitter (https://medium.com/programadores-ajudando-programadores/api-do-twitter-criando-o-app-e-obtendo-os-tokens-28ef3e2a281c)
- Obtenha os seguintes valores: API key, API secret key, Access token, Access token secret
- Baixe e instale o MySQL 8.0.26 e MySQL 8.0.26 Workbench (Dica: instalar o MySQL 8.0.26 pelo Docker é mais prático !)
- Cria uma nova conexão no Workbench
- Crie um banco chamado "bd_acb"
- Realize DataImport dos arquivos dump fornecidos abaixo (Server->DataImport)
- Abre o projeto e altere a classe IMySQL (Utils) com os dados da sua conexeão criada no Workbench (porta, usuário e senha)
- Adicione na tabela associacaoTwitter os dados da API (Atenta-se a coluna login que faz referência a tabela usuario)
- Realize um build do projeto
- Execute o projeto (telaLogin) e coloca os dados do usuario e senha registrado no banco de dados.


Dump : https://drive.google.com/drive/folders/1OinUm10wcOFv8Ig9pM-d95mvUQmsua33?usp=sharing
# Imagens
- Resultado da emocao do Tweet (happy). Como não é ofensivo, o sistema envia à plataforma do Twitter
<div>
  <img src=https://user-images.githubusercontent.com/88407564/145657779-b18e54f9-3280-4ecb-bbae-f91e9ff3f926.png>
</div>
- Tweet armazenado na plataforma
<div>
  <img src=https://user-images.githubusercontent.com/88407564/145657784-87b5f19b-ba2a-48bd-af40-be922704cb61.png>
</div>
- Inserir um tweet ofensivo
<div>
  <img src=https://user-images.githubusercontent.com/88407564/145657786-7651019b-5a32-42b4-a22b-942494172a08.png>
</div>
