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
No arquivo `src/main.jsx`, envolva o componente `<App />` com `<BrowserRouter>`.

```jsx
import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter } from 'react-router-dom';
import App from './App';
import './index.css';

ReactDOM.render(
  <React.StrictMode>
    <BrowserRouter>
      <App />
    </BrowserRouter>
  </React.StrictMode>,
  document.getElementById('root')
);
```

### b. Criando Páginas
Crie um diretório `src/pages` e adicione arquivos para cada página que deseja criar, por exemplo, `Home.jsx`, `About.jsx` e `NotFound.jsx`.

**src/pages/Home.jsx**
```jsx
import React from 'react';

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

**src/pages/About.jsx**
```jsx
import React from 'react';

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

**src/pages/NotFound.jsx**
```jsx
import React from 'react';

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

### c. Configurando Rotas no App
No arquivo `src/App.jsx`, importe as páginas e configure as rotas usando `Routes` e `Route`.

```jsx
import React from 'react';
import { Routes, Route, Link } from 'react-router-dom';
import Home from './pages/Home';
import About from './pages/About';
import NotFound from './pages/NotFound';

const App = () => {
  return (
    <div>
      <Link to="/">Home</Link> | <Link to="/about">About</Link>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </div>
  );
};

export default App;
```

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
