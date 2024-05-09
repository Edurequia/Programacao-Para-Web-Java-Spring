<div align="center">
    
![9d0a6780-394a-11eb-9fd1-6296a684b124](https://github.com/Herysson/Programacao-Para-Web-Java-Spring/assets/7634437/d58fb7b2-5d74-46cb-8cb1-e8987945ea2d)

</div>

# React

É uma biblioteca JavaScript de código aberto projetada para criar interfaces de usuário de forma eficiente e intuitiva. É mantida pelo Facebook e uma comunidade de desenvolvedores e empresas. 
React é usado principalmente para desenvolver aplicativos de página única (SPAs) e permite criar componentes de interface reutilizáveis, que podem gerenciar seu próprio estado.

# TypeScript

é um superconjunto de JavaScript desenvolvido pela Microsoft, que adiciona tipagem estática opcional à linguagem. 
Isso significa que os tipos são verificados durante o desenvolvimento, reduzindo a probabilidade de certos tipos de bugs e melhorando a legibilidade do código. 
TypeScript é compilado para JavaScript puro, o que significa que pode ser executado em qualquer navegador ou ambiente JavaScript. 
Ele é particularmente útil em projetos grandes ou complexos, pois facilita a manutenção e o gerenciamento do código.
# Ferramentas Utilizadas na Aula de FrontEnd

## Node.js

[Node.js](https://nodejs.org/) é um ambiente de execução para JavaScript do lado do servidor que permite aos desenvolvedores executar código JavaScript fora de um navegador. É construído no motor V8 do Google Chrome, proporcionando uma execução rápida do código JavaScript. Node.js é popular para desenvolvimento de aplicações web devido à sua arquitetura assíncrona e orientada a eventos.

## NPM

[NPM](https://www.npmjs.com/) (Node Package Manager) é o gerenciador de pacotes para Node.js, permitindo aos desenvolvedores instalar, compartilhar e gerenciar dependências em seus projetos JavaScript. NPM é essencial para gerenciar bibliotecas e ferramentas externas, facilitando a instalação e atualização de pacotes necessários para o desenvolvimento de aplicações.

## VsCode

[Visual Studio Code](https://code.visualstudio.com/) (VsCode) é um editor de código-fonte leve, mas poderoso, que suporta várias linguagens de programação. Desenvolvido pela Microsoft, o VsCode é altamente personalizável e extensível, oferecendo recursos como depuração integrada, controle de versão Git, e uma vasta biblioteca de extensões que melhoram a produtividade de desenvolvimento.

## Vite

[Vite](https://vitejs.dev/) é uma ferramenta de construção moderna para projetos web que oferece uma inicialização rápida e um desenvolvimento mais eficiente. Vite melhora significativamente o tempo de 
carregamento no desenvolvimento local usando o esforço de transformação apenas quando necessário e aproveitando amplamente o módulo ES nativo do navegador.

```bash
npm create vite@latest
```

## React Query

[React Query](https://react-query.tanstack.com/) é uma biblioteca para buscar, sincronizar e atualizar dados em aplicações React, sem a necessidade de gerenciar o estado global da aplicação.
React Query proporciona funcionalidades poderosas para lidar com requisições de dados assíncronos, caching e sincronização, simplificando o gerenciamento de estado derivado de dados externos.

```bash
npm install @tanstack/react-query
```

## Axios

Axios é uma biblioteca JavaScript usada para fazer requisições HTTP. Para instalar Axios, use o comando:

```bash
npm install axios
```

Para incluir a imagem que você enviou no tutorial de configuração do projeto com o Vite, aqui está uma versão atualizada do texto para seu arquivo `.md` no GitHub, com a inclusão do passo a passo usando o terminal (cmd) e a referência à imagem:

## Criando o Projeto com Vite

Para criar um novo projeto utilizando o Vite, siga os passos abaixo:

1. Abra o terminal (cmd) e execute o seguinte comando para iniciar a criação do projeto:

```bash
npm create vite@latest
```

2. Quando solicitado, confirme a instalação do pacote necessário respondendo com `y`.

3. Em seguida, você será solicitado a fornecer um nome para o projeto, por exemplo, `menuStream`.

4. Você precisará selecionar um framework para o seu projeto. Para este exemplo, usaremos `React`. Use as setas do teclado para selecionar a opção desejada e pressione `Enter` para confirmar.

Abaixo está uma captura de tela do processo no terminal:

![Vite Config](https://github.com/Herysson/Programacao-Para-Web-Java-Spring/assets/7634437/ab0ec5e5-44ef-4c6e-bd50-5f9a615fc1f2)

Com estas etapas, o Vite configurará o ambiente necessário para seu projeto React.

## Configurando o Projeto no VSCode

Para abrir o projeto no Visual Studio Code (VSCode) e começar a instalação das dependências, siga os passos abaixo:

1. **Abrir o projeto no VSCode:**
   - Primeiro, certifique-se de que o Visual Studio Code esteja instalado em seu sistema. Se não estiver, você pode baixá-lo do site oficial: [Visual Studio Code](https://code.visualstudio.com/).
   - Abra o Visual Studio Code.
   - Utilize o atalho `Ctrl + O` (Windows/Linux) ou `Cmd + O` (Mac) para abrir a caixa de diálogo de abertura de arquivo.
   - Navegue até o diretório do projeto que você criou com o Vite, selecione-o e clique em "Abrir".

2. **Instalar dependências no VSCode:**
   - No Visual Studio Code, abra o terminal integrado pressionando `Ctrl + `` (crase) ou navegando pelo menu `View` > `Terminal`.
   - Com o terminal aberto, você estará automaticamente no diretório do seu projeto. Aqui, você pode começar a instalar todas as dependências necessárias.

3. **Comandos para instalar as dependências:**
   - Supondo que você precise instalar Axios, React Query, e outras bibliotecas que você mencionou anteriormente, aqui estão os comandos que você precisará executar no terminal do VSCode:
   
   ```bash
   npm install 
   npm install axios
   npm install @tanstack/react-query
   ```
   - Execute cada comando separadamente para garantir que cada pacote seja instalado corretamente.

4. **Verificar as instalações:**
   - Após a instalação de cada pacote, você pode verificar se as bibliotecas foram adicionadas corretamente ao seu arquivo `package.json`, que gerencia todas as dependências do projeto.

   - Para rodar o servidor:

    ```bash
   npm run dev
   ```

6. **Começar o desenvolvimento:**
   - Com as dependências instaladas, você está pronto para começar a escrever código e desenvolver o projeto. Utilize os recursos do VSCode como IntelliSense, depuração e extensões para React para auxiliar no desenvolvimento.

Agora, com o projeto aberto e as dependências instaladas, você pode começar a codificar e aproveitar as funcionalidades do React e outras bibliotecas que você escolheu para o seu projeto.


# Projeto Exemplo

## `main.tsx`

O arquivo `main.tsx` é o ponto de entrada para uma aplicação React criada com o Vite e utilizando TypeScript. Vamos detalhar cada parte deste arquivo e sua funcionalidade:

1. **Importações de Bibliotecas e Componentes:**
   ```typescript
   import React from 'react'
   import ReactDOM from 'react-dom/client'
   import App from './App.tsx'
   import './index.css'
   import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
   ```
   - `React`: Biblioteca principal do React, usada para construir componentes e gerenciar o estado.
   - `ReactDOM`: Subpacote de React usado para renderizar elementos no DOM.
   - `App`: Importação do componente principal `App.tsx` que geralmente contém a estrutura principal da sua aplicação.
   - `./index.css`: Arquivo de estilos CSS que será aplicado globalmente ao projeto.
   - `QueryClient` e `QueryClientProvider`: Importações do React Query para gerenciar estados de consultas de forma eficiente em aplicações React.

2. **Criação do Cliente de Consulta (Query Client):**
   ```typescript
   const queryClient = new QueryClient();
   ```
   - Cria uma instância de `QueryClient`, que é usada para configurar e gerenciar o estado das consultas e mutações no React Query. Este cliente permite configurar opções globais de consultas, como tempos de recarga, cache e comportamento de erro.

3. **Renderização do Componente Raiz:**
   ```typescript
   ReactDOM.createRoot(document.getElementById('root')!).render(
     <React.StrictMode>
       <QueryClientProvider client={queryClient}>
         <App />
       </QueryClientProvider>
     </React.StrictMode>,
   )
   ```
   - `ReactDOM.createRoot`: Método usado para criar um contêiner de raiz no DOM. Aqui, ele está sendo aplicado ao elemento com ID `root`, que é o ponto de montagem para a aplicação React no HTML.
   - `<React.StrictMode>`: Um componente que verifica a aplicação para potenciais problemas. Ele ativa verificações e avisos adicionais para seus descendentes.
   - `<QueryClientProvider client={queryClient}>`: Componente que fornece o contexto de React Query para a árvore de componentes. Isso significa que qualquer componente dentro deste provedor pode usar hooks do React Query.
   - `<App />`: O componente principal da sua aplicação que contém a lógica da interface do usuário.

Este arquivo é essencial para inicializar e configurar a aplicação React, integrando a gestão de estado de dados externos com React Query, e definindo o contexto global para o estilo com CSS.

## Interface
A relação entre a interface `productData` definida no arquivo `productData.ts` para uso no frontend e a classe `Product` definida no backend ilustra uma prática comum no desenvolvimento de aplicações com separação clara entre frontend e backend. Esta prática facilita a consistência dos dados e a integração entre as duas partes da aplicação. Vamos analisar a relação entre os dois:

### `productData`

A interface `productData` no frontend TypeScript define a estrutura dos dados conforme esperado pelo frontend. Isso serve como um contrato que garante que o frontend manipule os dados de produto de forma correta. Aqui estão seus campos:

```typescript
export interface productData {
    id: number,
    name: string,
    description: string,
    price: number,
    category: string,
    availability: boolean,
    image: string
}
```

### Classe `Product`

No backend, a classe `Product` é definida usando Java com anotações do JPA para mapeamento objeto-relacional e Lombok para geração automática de getters, setters e outros métodos padrão. Veja seus campos correspondentes:

```java
@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 1024)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private boolean availability;

    @Column
    private String image;
}
```

### Relação entre Interface e Classe

1. **Tipos de Dados e Nomenclatura**: Os nomes dos campos em ambos são quase idênticos, facilitando o mapeamento direto dos dados entre o frontend e o backend. As diferenças notáveis estão no uso de tipos:
   - `BigDecimal` no backend para `price` que é mapeado para `number` no TypeScript, um mapeamento comum considerando que JavaScript não distingue tipos de números.
   - O tipo de `id` é `Long` no Java e `number` no TypeScript, ambos adequados para representar identificadores numéricos.

2. **Anotações e Decoradores**: O backend utiliza anotações do JPA (`@Entity`, `@Column`, etc.) para definir como a classe se mapeia para uma tabela de banco de dados, enquanto no frontend, a interface é apenas uma definição de tipo sem qualquer comportamento ou armazenamento de dados associado.

3. **Campos Adicionais e Convenções de Banco de Dados**: O backend pode incluir anotações como `@Column(nullable = false)` para impor restrições de banco de dados, que são independentes do frontend.

4. **Serialização e Desserialização**: Quando os dados são enviados do backend para o frontend (e vice-versa), eles são geralmente serializados em JSON no backend e desserializados no frontend. A estrutura da interface e da classe deve ser compatível para que essa operação ocorra sem erros.

Esta relação clara entre a definição de dados no frontend e no backend facilita o desenvolvimento e manutenção de ambos os lados da aplicação, garantindo que ambos operem com uma visão consistente do que é um "produto".

## Hook

O arquivo `useProductData.ts` é um exemplo de como criar um hook customizado em React utilizando o React Query para gerenciar o estado de dados de produtos de forma eficiente e moderna. Vamos detalhar cada parte deste arquivo e sua funcionalidade:

1. **Importações:**
   ```typescript
   import axios, { AxiosPromise } from "axios"
   import { productData } from "../interface/productData";
   import { useQuery } from "@tanstack/react-query";
   ```
   - `axios`: Biblioteca utilizada para fazer requisições HTTP.
   - `AxiosPromise`: Tipo específico do TypeScript usado para tipar as promessas retornadas pelo axios.
   - `productData`: Tipo customizado definido em outro arquivo, representando a estrutura de dados de um produto.
   - `useQuery`: Hook do React Query utilizado para buscar, armazenar em cache e atualizar dados de maneira assíncrona e eficiente.

2. **Definição da URL da API:**
   ```typescript
   const API_URL = 'http://localhost:8080';
   ```
   - Constante que define a URL base da API que será consultada para obter dados dos produtos.

3. **Função de busca de dados:**
   ```typescript
   const fetchData = async (): AxiosPromise<productData[]> => {
       const response = axios.get(API_URL + '/products');
       return response;
   }
   ```
   - `fetchData`: Uma função assíncrona que utiliza o axios para fazer uma requisição GET ao endpoint `/products` da API. Retorna uma promessa que resolve para um array de `productData`.

4. **Hook Customizado `useProductData`:**
   ```typescript
   export function useProductData(){
       const query = useQuery({
           queryFn: fetchData,
           queryKey: ['Product-data'],
           retry: 2
       })

       return {
           ...query,
           data: query.data?.data
       }
   }
   ```
   - `useProductData`: Um hook customizado que encapsula a lógica de uso do React Query para buscar dados.
   - `useQuery`: Configuração do hook, onde:
     - `queryFn`: Função que define como os dados serão buscados (neste caso, `fetchData`).
     - `queryKey`: Uma chave única para a consulta, usada pelo React Query para rastrear e armazenar em cache os dados de consulta.
     - `retry`: Número de tentativas que o React Query deve fazer em caso de falha na consulta.
   - Retorna um objeto que estende a resposta do `useQuery`, adicionando uma propriedade `data` que acessa diretamente os dados da resposta do axios (usualmente acessível via `query.data?.data` devido à estrutura padrão de resposta do axios).

Este arquivo ilustra uma prática avançada e muito comum em aplicações React modernas, onde hooks customizados são usados para simplificar e modularizar a lógica de acesso a dados, facilitando a reutilização e manutenção do código.

## Components

O componente `Card` em React é um exemplo claro de como você pode criar um componente reutilizável para exibir informações de maneira estilizada, neste caso, para produtos. Abaixo está a descrição detalhada deste componente `Card.tsx`, que utiliza TypeScript para definir as propriedades esperadas e CSS para estilização.

### Componente `Card`

```typescript
import "./card.css";

interface CardProps {
    price: number,
    name: string,
    image: string
}

export function Card({ price, image, name } : CardProps){
    return(
        <div className="card">
            <img src={image} alt={`Imagem de ${name}`}/>
            <h2>{name}</h2>
            <p><b>Valor:</b> {price}</p>
        </div>
    )
}
```

### Explicação dos Elementos

1. **Importação de Estilos CSS**:
   - `import "./card.css";`: Importa um arquivo CSS para aplicar estilos específicos ao componente. Este arquivo deve conter regras CSS que definem a aparência dos elementos dentro de um `.card`.

2. **Interface `CardProps`**:
   - Define as propriedades esperadas pelo componente. Essas propriedades são:
     - `price`: Um número que representa o preço do produto.
     - `name`: Uma string que contém o nome do produto.
     - `image`: Uma string que contém o URL da imagem do produto.

3. **Componente Funcional `Card`**:
   - O componente é definido como uma função que recebe `CardProps` como parâmetro. Este é um exemplo de um componente funcional em React.
   - Desestruturação das props diretamente na assinatura da função para acessar as propriedades mais facilmente.

4. **Renderização do Componente**:
   - `<div className="card">`: Elemento raiz do componente que usa a classe `card` para aplicar estilos.
   - `<img src={image} alt={`Imagem de ${name}`}/>`: Exibe a imagem do produto. O atributo `alt` é usado para acessibilidade, fornecendo uma descrição textual da imagem.
   - `<h2>{name}</h2>`: Título do card que exibe o nome do produto.
   - `<p><b>Valor:</b> {price}</p>`: Parágrafo que exibe o preço do produto, destacando a palavra "Valor" em negrito.

### Uso do Componente `Card`

Este componente pode ser usado em qualquer parte de uma aplicação React onde se deseja exibir informações de produtos em um formato de card. Por ser um componente reutilizável, `Card` pode ser facilmente integrado em listas ou grades de produtos, apenas passando os dados apropriados para as props de cada instância do componente.

### Estilização (card.css)

O arquivo `card.css` deve conter regras para definir como os cards serão apresentados. Isso pode incluir definições para o layout do card, estilos para a imagem, título e texto, bem como qualquer hover ou outros efeitos interativos. A estilização é crucial para garantir que o componente não só funcione bem, mas também tenha uma aparência coerente e atraente dentro do contexto da UI do usuário.

## Estilização .css

O arquivo `card.css` contém as regras de estilo para o componente `Card` em sua aplicação React. Este arquivo é fundamental para definir a aparência visual dos cards que exibem as informações do produto. Vamos detalhar cada regra de estilo aplicada e explicar o propósito de cada uma.

### Arquivo CSS: `card.css`

```css
.card {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    width: 250px;
    border-radius: 8px;
    box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;
    padding: 0;
}

img {
    border-radius: 8px 8px 0 0;
    width: 250px;
    height: 200px;
}
```

### Explicação dos Estilos

1. **Estilos para `.card`**:
   - `display: flex;`: Define o container `.card` como um flex container, o que permite usar Flexbox para organizar os elementos filhos (imagem, nome e preço).
   - `flex-direction: column;`: Os itens dentro do `.card` são organizados em uma coluna vertical.
   - `align-items: center;`: Centraliza os itens filhos horizontalmente.
   - `justify-content: center;`: Centraliza os itens filhos verticalmente dentro do container, útil especialmente se houver espaçamento adicional ou altura dinâmica.
   - `width: 250px;`: Define a largura do card.
   - `border-radius: 8px;`: Aplica um raio de borda para arredondar os cantos do card.
   - `box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;`: Adiciona uma sombra ao redor do card para um efeito de elevação, melhorando a distinção visual do card em relação ao fundo.
   - `padding: 0;`: Remove o padding interno do card para que o conteúdo possa se alinhar precisamente às bordas definidas.

2. **Estilos para `img`**:
   - `border-radius: 8px 8px 0 0;`: Aplica bordas arredondadas apenas aos cantos superiores da imagem, mantendo os cantos inferiores quadrados para se alinhar com o card.
   - `width: 250px;`: Define a largura da imagem para coincidir com a largura do card, garantindo que a imagem cubra a largura total do card.
   - `height: 200px;`: Define a altura fixa da imagem, proporcionando consistência visual entre diferentes cards.


### Arquivo CSS: `app.css`

O arquivo `app.css` contém as regras de estilo para o layout geral da aplicação, incluindo a organização dos cards em uma grade e o estilo de um botão. Abaixo, vou detalhar e explicar cada conjunto de regras para que você possa entender como cada parte contribui para o design e a funcionalidade da interface do usuário.

```css
.container {
  display: flex;
  align-items: center;
  flex-direction: column;
  justify-content: center;
  width: 100vw;
}

.card-grid {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  gap: 16px;
}

.container button {
  background-color: #0275d8;
  color: white;
  font-weight: bold;
  position: fixed;
  bottom: 16px;
  right: 24px;
  transition: all 0.1s linear 0.1s;
}

.container button:hover {
  box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 7px 0px;
  transform: scale(1.1);
}
```

### Explicação dos Estilos

1. **Estilos para `.container`:**
   - `display: flex;`: Define o `.container` como um contêiner flexível para facilitar o alinhamento dos itens internos.
   - `align-items: center;`: Centraliza os itens filhos horizontalmente.
   - `flex-direction: column;`: Organiza os itens filhos em uma coluna vertical.
   - `justify-content: center;`: Centraliza os itens filhos verticalmente dentro do contêiner.
   - `width: 100vw;`: Define a largura do contêiner para 100% da largura da viewport, garantindo que o contêiner se estenda horizontalmente em toda a tela.

2. **Estilos para `.card-grid`:**
   - `display: grid;`: Utiliza o layout de grade para organizar os cards dentro do contêiner.
   - `grid-template-columns: 1fr 1fr 1fr;`: Divide o contêiner em três colunas de tamanhos iguais para dispor os cards de forma uniforme.
   - `gap: 16px;`: Define um espaço de 16 pixels entre os cards, proporcionando um espaçamento adequado para que o layout não fique sobrecarregado.

3. **Estilos para `button` dentro de `.container`:**
   - `background-color: #0275d8;`: Aplica uma cor de fundo azul ao botão.
   - `color: white;`: Define a cor do texto do botão para branco, garantindo uma boa visibilidade.
   - `font-weight: bold;`: Torna o texto do botão em negrito.
   - `position: fixed;`: Fixa o botão em uma posição na tela, fazendo com que ele não se mova ao rolar a página.
   - `bottom: 16px;`: Posiciona o botão 16 pixels acima do fundo da viewport.
   - `right: 24px;`: Posiciona o botão 24 pixels à direita da viewport.
   - `transition: all 0.1s linear 0.1s;`: Define uma transição suave para todas as propriedades alteradas do botão, com duração de 0.1 segundos e um delay de 0.1 segundos.

4. **Efeito hover para `button`:**
   - `box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 7px 0px;`: Adiciona uma sombra ao botão quando o mouse está sobre ele, elevando visualmente o botão.
   - `transform: scale(1.1);`: Aumenta o tamanho do botão em 10% ao passar o mouse, destacando-o e melhorando a interatividade.
