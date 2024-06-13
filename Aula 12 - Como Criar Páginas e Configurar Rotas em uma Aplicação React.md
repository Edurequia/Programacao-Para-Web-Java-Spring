# Como Criar Páginas e Configurar Rotas em uma Aplicação React

#### Objetivos da Aula
- Compreender a estrutura básica de um projeto React criado com Vite.
- Aprender a criar páginas em uma aplicação React.
- Configurar o roteamento utilizando `react-router-dom`.

#### Ferramentas Utilizadas
- Node.js
- Vite
- React
- react-router-dom
- VsCode

## 1. Introdução
Apresentação dos objetivos da aula e visão geral sobre a importância de rotas em aplicações web.

## 2. Criando um Novo Projeto com Vite
Vamos criar um novo projeto React utilizando Vite, uma ferramenta de build que oferece um ambiente de desenvolvimento mais rápido.

```bash
# Instalação do Vite
npm create vite@latest my-react-app --template react

# Acesse o diretório do projeto
cd my-react-app

# Instale as dependências
npm install

# Inicie o servidor de desenvolvimento
npm run dev
```

## 3. Estrutura do Projeto
Explicação da estrutura básica do projeto gerado pelo Vite:
- `index.html`
- `src/main.jsx`
- `src/App.jsx`
- `src/assets` (para arquivos estáticos)

## 4. Instalando e Configurando `react-router-dom`
O `react-router-dom` é uma biblioteca essencial para gerenciar rotas em aplicações React.

```bash
# Instalação do react-router-dom
npm install react-router-dom
```

Claro, podemos simplificar a navegação removendo a estrutura `<nav>` e `<ul>`. Veja como fica o código simplificado:

## 5. Configurando o Roteamento
### a. Configurando o BrowserRouter
No arquivo `src/main.tsx`, envolva o componente `<App />` com `<BrowserRouter>`.

```tsx
import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter } from 'react-router-dom';
import App from './App.tsx';


ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <BrowserRouter>
      <App />
    </BrowserRouter>
  </React.StrictMode>,
);
```

#### Importações

1. **`import React from 'react';`**
   - Importa o módulo React, necessário para criar componentes e usar funcionalidades do React.

2. **`import ReactDOM from 'react-dom/client';`**
   - Importa o módulo ReactDOM, que é usado para renderizar o componente React no DOM. O método `createRoot` é utilizado para criar um ponto de entrada para a aplicação React a partir do React 18.

3. **`import { BrowserRouter } from 'react-router-dom';`**
   - Importa o componente `BrowserRouter` da biblioteca `react-router-dom`, que é usado para habilitar o roteamento baseado em navegador em uma aplicação React.

4. **`import App from './App.tsx';`**
   - Importa o componente principal da aplicação, `App`, que contém a lógica e estrutura principal da aplicação React.

5. **`import './index.css';`**
   - Importa o arquivo CSS `index.css`, que contém os estilos globais da aplicação.

#### Estrutura de Renderização

```tsx
ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <BrowserRouter>
      <App />
    </BrowserRouter>
  </React.StrictMode>,
);
```

1. **`ReactDOM.createRoot(document.getElementById('root')!).render(...)`**
   - Este método é usado para criar um ponto de entrada da aplicação React no elemento do DOM com o id `root`. A exclamação (`!`) após `getElementById('root')` é uma asserção de não-null (non-null assertion) do TypeScript, garantindo ao compilador que o elemento existe.
   - A função `render` então renderiza os componentes React dentro desse elemento.

2. **`<React.StrictMode>`**
   - O componente `React.StrictMode` envolve a aplicação para ativar verificações e avisos adicionais durante o desenvolvimento. Ele não afeta o comportamento da aplicação em produção, mas ajuda a identificar problemas potenciais no código.

3. **`<BrowserRouter>`**
   - O componente `BrowserRouter` do `react-router-dom` envolve a aplicação para fornecer funcionalidades de roteamento baseadas no navegador. Ele permite definir e gerenciar rotas dentro da aplicação React.

4. **`<App />`**
   - O componente principal da aplicação que é renderizado. Este componente geralmente contém a lógica principal e a estrutura de navegação da aplicação.

#### Fluxo Geral

- O arquivo `main.jsx` é o ponto de entrada da aplicação.
- Ele importa os módulos necessários, incluindo React, ReactDOM, BrowserRouter, o componente App e estilos CSS.
- O `ReactDOM.createRoot` cria a raiz da aplicação React dentro do elemento DOM com o id `root`.
- A estrutura JSX passada para o método `render` é renderizada dentro do elemento `root`.
- `React.StrictMode` fornece verificações adicionais durante o desenvolvimento.
- `BrowserRouter` habilita o roteamento na aplicação.
- O componente `App` é o componente principal que define a estrutura e lógica da aplicação.

### b. Criando Páginas
Crie um diretório `src/pages` e adicione arquivos para cada página que deseja criar, por exemplo, `Home.tsx`, `About.tsx` e `NotFound.tsx`.

**src/pages/Home.tsx**
```tsx
const Home = () => {
  return (
    <div>
      <h1>Home Page</h1>
      <p>Welcome to the home page!</p>
    </div>
  );
};

export default Home;
```

**src/pages/About.tsx**
```tsx
const About = () => {
  return (
    <div>
      <h1>About Page</h1>
      <p>Learn more about us on this page.</p>
    </div>
  );
};

export default About;
```

**src/pages/NotFound.tsx**
```tsx
const NotFound = () => {
  return (
    <div>
      <h1>404 - Page Not Found</h1>
      <p>Sorry, the page you are looking for does not exist.</p>
    </div>
  );
};

export default NotFound;
```

### c. Configurando Rotas

Para separar as rotas em um arquivo diferente, podemos criar um novo arquivo para a configuração das rotas e importar esse arquivo no componente `App`. Isso ajuda a manter o código organizado e modularizado.

#### 1. Criar o Arquivo `routes.jsx`

Crie um novo arquivo chamado `routes.tsx` na pasta `src` e defina as rotas nesse arquivo:

```tsx
import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import About from './pages/About';
import NotFound from './pages/NotFound';

const AppRoutes: React.FC = () => {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/about" element={<About />} />
      <Route path="*" element={<NotFound />} />
    </Routes>
  );
};

export default AppRoutes;

```

#### Importações

1. **`import React from 'react';`**
   - Importa o módulo React, necessário para criar componentes e usar funcionalidades do React.

2. **`import { Routes, Route } from 'react-router-dom';`**
   - Importa os componentes `Routes` e `Route` da biblioteca `react-router-dom`, que são usados para definir e gerenciar as rotas da aplicação.

3. **`import Home from './pages/Home';`**
   - Importa o componente `Home` da pasta `pages`. Este componente representa a página inicial da aplicação.

4. **`import About from './pages/About';`**
   - Importa o componente `About` da pasta `pages`. Este componente representa a página "Sobre" da aplicação.

5. **`import NotFound from './pages/NotFound';`**
   - Importa o componente `NotFound` da pasta `pages`. Este componente representa a página "404 - Not Found", que é exibida quando uma rota não é encontrada.

#### Definição do Componente `AppRoutes`

6. **`const AppRoutes = () => { ... };`**
   - Define um componente funcional chamado `AppRoutes` usando uma função de seta. Este componente encapsula a lógica de roteamento da aplicação.

#### Estrutura de Rotas

7. **`<Routes>`**
   - O componente `Routes` do `react-router-dom` é usado para definir um conjunto de rotas. Ele age como um contêiner para os componentes `Route` que especificam as diferentes rotas da aplicação.

8. **`<Route path="/" element={<Home />} />`**
   - Define uma rota para o caminho `/`. Quando a URL é exatamente `/`, o componente `Home` será renderizado.

9. **`<Route path="/about" element={<About />} />`**
   - Define uma rota para o caminho `/about`. Quando a URL é `/about`, o componente `About` será renderizado.

10. **`<Route path="*" element={<NotFound />} />`**
    - Define uma rota curinga usando o caminho `*`. Esta rota captura todas as URLs não definidas anteriormente e renderiza o componente `NotFound`. Isso é útil para exibir uma página de erro 404 quando a URL não corresponde a nenhuma das rotas definidas.

#### Exportação do Componente

11. **`export default AppRoutes;`**
    - Exporta o componente `AppRoutes` como padrão. Isso permite que outros arquivos importem e usem este componente para integrar a lógica de roteamento na aplicação.
      

### 2. Modificar o Componente `App`

Atualize o componente `App` para importar e usar o `AppRoutes`:

```jsx
import { Link } from 'react-router-dom';
import AppRoutes from './routes';

function App() {
  return (
    <div>
      <Link to="/">Home</Link> | <Link to="/about">About</Link>
      <AppRoutes />
    </div>
  );
}

export default App;
```

#### Importações

1. **`import React from 'react';`**
   - Importa o módulo React, necessário para criar componentes e usar funcionalidades do React.

2. **`import { Link } from 'react-router-dom';`**
   - Importa o componente `Link` da biblioteca `react-router-dom`, que é usado para criar links de navegação na aplicação sem recarregar a página.

3. **`import AppRoutes from './routes';`**
   - Importa o componente `AppRoutes` que contém a definição das rotas da aplicação. Esse componente foi definido anteriormente em um arquivo separado (`routes.jsx`).

#### Definição do Componente `App`

4. **`function App() { ... }`**
   - Define um componente funcional chamado `App` usando uma função tradicional. Este componente representa o componente principal da aplicação.

#### Estrutura do Componente

5. **`<div>`**
   - Um contêiner `div` que agrupa os elementos dentro do componente `App`.

6. **`<Link to="/">Home</Link> | <Link to="/about">About</Link>`**
   - Usa o componente `Link` para criar links de navegação. Estes links permitem navegar para diferentes rotas na aplicação sem recarregar a página.
     - **`<Link to="/">Home</Link>`**: Cria um link que redireciona para a rota raiz (`/`).
     - **`<Link to="/about">About</Link>`**: Cria um link que redireciona para a rota `/about`.
   - O símbolo `|` é usado como um separador visual entre os links.

7. **`<AppRoutes />`**
   - Renderiza o componente `AppRoutes`, que contém todas as definições de rotas da aplicação. Este componente é responsável por renderizar os componentes de página apropriados com base na URL atual.

#### Exportação do Componente

8. **`export default App;`**
   - Exporta o componente `App` como padrão. Isso permite que outros arquivos importem e usem este componente como o ponto de entrada principal da aplicação


## 7. Testando a Aplicação
- Inicie o servidor de desenvolvimento: `npm run dev`.
- Acesse `http://localhost:3000` no navegador.
- Navegue entre as páginas Home e About utilizando os links de navegação.
- Teste a página 404 acessando uma rota inexistente.


## Tarefa
- Adicionar uma nova página chamada `Contact`.
- Configurar a rota para a nova página.
- Adicionar um link de navegação para a página `Contact`.

## Recursos Adicionais
- [Documentação do React Router](https://reactrouter.com/)
- [Documentação do Vite](https://vitejs.dev/)



Espero que isso ajude na preparação da sua aula! Se precisar de mais alguma coisa, estou à disposição.
