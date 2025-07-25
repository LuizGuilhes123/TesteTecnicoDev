Desafio Técnico – Nasajon
Este repositório contém as resoluções de dois exercícios propostos, focando em soluções organizadas, eficientes e de fácil manutenção, escritas em Java puro com manipulação de arquivos e estruturas de dados. Cada código foi desenvolvido com responsabilidade única e clareza, simulando cenários reais de uso em sistemas empresariais.

📝 Exercício 1 – Tradutor XML (Internacionalização)
Este exercício simula a adaptação de um sistema de BI internacionalizado, traduzindo arquivos XML de localização do inglês para o português.

📌 Objetivo:

Ler um arquivo XML contendo chaves e textos em inglês e gerar um novo XML com os textos traduzidos automaticamente para português, preservando a estrutura e a legibilidade.

🔧 Tecnologias e abordagens utilizadas:

Java (JDK 17+)

Manipulação de arquivos XML com DocumentBuilder (DOM)

Tradução automatizada com integração HTTP via Google Translate API

Escrita em XML formatada com indentação e codificação UTF-8

Organização por responsabilidade: uma classe lida, traduz e escreve o XML

📂 Arquivos:

TradutorXML.java → código principal do tradutor

entrada.xml → arquivo de entrada com strings em inglês

saida.xml → saída traduzida gerada após execução

📊 Exercício 2 – Analisador de Folha de Ponto
Este exercício simula a análise de folhas de ponto de funcionários para sistemas de RH, identificando dias de ausência com base nos registros por funcionário.

📌 Objetivo:

Ler um arquivo com registros de ponto e agrupar por funcionário os dias nos quais não há batidas, permitindo identificar ausências.

🔧 Tecnologias e abordagens utilizadas:

Java (JDK 17+)

Manipulação de arquivos TXT linha por linha

Organização dos dados com Map<String, List<RegistroFolha>>

Classe RegistroFolha para encapsular os dados de cada linha

Lógica de agrupamento por CPF e análise de presença

📂 Arquivos:

AnalisadorFolhaPonto.java → código principal da análise

folha.txt → entrada com registros de ponto por CPF, data e hora

ausencias.txt → saída com dias de ausência por funcionário

🚀 Execução
Coloque todos os arquivos na mesma pasta e compile com:

javac TradutorXML.java
java TradutorXML

javac AnalisadorFolhaPonto.java
java AnalisadorFolhaPonto

Certifique-se de que os arquivos de entrada (entrada.xml e folha.txt) estejam presentes na pasta do projeto.

🛠️ Conclusão

O projeto demonstra domínio em:

Manipulação de arquivos e XML

Integração com serviços externos sem bibliotecas de terceiros

Organização orientada a domínio

Boas práticas em código limpo, modularização e separação de responsabilidades

Desenvolvido com atenção aos detalhes, visando clareza, robustez e manutenção fácil. Qualquer sugestão ou melhoria é bem-vinda!
