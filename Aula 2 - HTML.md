# **HTML**  


## **Seção 1:Introdução ao HTML**  

### **O que é HTML?**  
HTML (*HyperText Markup Language*) é a linguagem padrão para criar páginas da web. Ele define a estrutura e o conteúdo de uma página usando **elementos** (tags) que informam ao navegador como exibir textos, imagens, links e outros componentes.  

### **Como o HTML Funciona?**  
- O HTML consiste em uma série de **tags** (etiquetas) que envolvem o conteúdo.  
- O navegador lê o HTML e renderiza a página conforme as instruções das tags.  
- Páginas HTML são salvas com a extensão **.html**.  

Exemplo básico:  
```html
<!DOCTYPE html>
<html>
<head>
    <title>Título da Página</title>
</head>
<body>
    <h1>Meu Primeiro Cabeçalho</h1>
    <p>Meu primeiro parágrafo.</p>
</body>
</html>
```

---

### **Estrutura Básica de um Documento HTML**  
Todo documento HTML possui uma estrutura fundamental:  

1. **`<!DOCTYPE html>`**  
   - Declara o tipo de documento (HTML5).  

2. **`<html>`**  
   - Elemento raiz que engloba todo o conteúdo da página.  

3. **`<head>`**  
   - Contém metadados, como título da página (`<title>`), links para CSS e scripts.  

4. **`<body>`**  
   - Contém o conteúdo visível da página (textos, imagens, links, etc.).  

---

### **Tags HTML Básicas**  
Algumas das principais tags incluem:  

| Tag         | Descrição                          | Exemplo                     |
|-------------|------------------------------------|-----------------------------|
| `<h1> - <h6>` | Cabeçalhos (títulos)               | `<h1>Título Principal</h1>` |
| `<p>`       | Parágrafo                          | `<p>Texto aqui.</p>`        |
| `<br>`       | Qubra de linha                         | `<p>Bairro Jardim<br> São Paulo/SP</p>`        |
| `<a>`       | Link                               | `<a href="url">Link</a>`    |
| `<img>`     | Imagem                             | `<img src="imagem.jpg">`    |
| `<ul>`, `<ol>`, `<li>` | Listas (não ordenadas/ordenadas) | `<ul><li>Item 1</li></ul>`  |
| `<div>`     | Divisão/container genérico         | `<div>Conteúdo</div>`       |

---

### **Atributos HTML**  
Atributos fornecem informações adicionais sobre elementos. Exemplos comuns:  

- **`href`** (em `<a>`) – Define o destino de um link.  
  ```html
  <a href="https://www.google.com">Visite o Google</a>
  ```
- **`src`** (em `<img>`) – Especifica o caminho da imagem.  
  ```html
  <img src="foto.jpg" alt="Descrição da imagem">
  ```
- **`alt`** – Texto alternativo para acessibilidade.  

Ótimo! Vamos integrar essas informações ao material, organizando de forma didática. Segue a versão atualizada:

---

### **Estrutura Básica de um Documento HTML**  
Todo arquivo HTML válido deve seguir este esqueleto:  
```html
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Título da Página</title>
</head>
<body>
    <!-- Conteúdo visível vai aqui -->
</body>
</html>
```

#### **Explicação das Tags Essenciais:**
| Tag/Atributo               | Função                                                                 |
|----------------------------|------------------------------------------------------------------------|
| `<!DOCTYPE html>`          | Define o documento como HTML5.                                         |
| `<html lang="pt-BR">`      | Raiz do documento + idioma (português do Brasil).                      |
| `<meta charset="UTF-8">`   | Permite acentos, ç, emojis e caracteres especiais.                     |
| `<meta name="viewport"...` | Adapta a página para telas de celulares e tablets.                     |
| `<title>`                  | Define o título da aba/janela do navegador.                            |

---

### **Como os Navegadores Funcionam?**  
Os navegadores (*browsers* como Chrome, Firefox, Edge) **não exibem as tags HTML**, mas as usam para renderizar o conteúdo corretamente.  >

![image](https://github.com/user-attachments/assets/fdd5fe09-61e0-4318-956d-3af37771825a)

---

### **Estrutura da pagina HTML**  

Abaixo uma visualização da estrutura de uma pagina HTML.

![image](https://github.com/user-attachments/assets/ecc8f0b3-ca65-4a52-9459-6ad1162622b1)

--- 

### Atividade: 

Criar um mini currículo pessoal em HTML contendo:
- Foto
- Nome, profissão
- Pequena bio
- Lista de habilidades
- Link para redes sociais

Perfeito! Com base na sua ideia e na referência do W3Schools, aqui está a **Seção 2** do seu material didático, abordando **elementos HTML e seus atributos**, com explicações claras, exemplos comentados e estrutura didática:

---

## **Seção 2: Elementos HTML e Atributos**

### **O que é um Elemento HTML?**

Um **elemento HTML** é a unidade fundamental de um documento HTML. Ele é composto por uma **tag de abertura**, **conteúdo** e, na maioria dos casos, uma **tag de fechamento**:

```html
<p>Este é um parágrafo.</p>
```

Neste exemplo:

* `<p>` é a **tag de abertura**.
* `Este é um parágrafo.` é o **conteúdo**.
* `</p>` é a **tag de fechamento**.

Alguns elementos são **autofechados**, ou seja, não possuem conteúdo interno:

```html
<img src="foto.jpg" alt="Foto de perfil">
<br>
```

---

### **O que são Atributos HTML?**

Atributos HTML fornecem **informações adicionais** sobre os elementos. Eles são sempre especificados **dentro da tag de abertura** e seguem o formato:

```html
<tag atributo="valor">Conteúdo</tag>
```

### **Regras Gerais dos Atributos**

* Sempre aparecem na tag de abertura.
* São compostos por um **nome** e um **valor**.
* Os valores devem estar entre **aspas duplas** `" "`.

---

### **Principais Atributos HTML e Exemplos**

#### `href` (em `<a>`)

Especifica o destino de um link.

```html
<a href="https://www.w3schools.com">Visite o W3Schools</a>
```

#### `src` (em `<img>`)

O atributo `src` especifica o **caminho para o arquivo de imagem** que será exibido na página.

```html
<img src="foto.jpg" alt="Foto de perfil">
```

##### **Formas de especificar o valor de `src`:**

Existem duas formas principais de informar o caminho da imagem:

---

**1. URL Absoluta**

* Aponta para uma **imagem externa**, hospedada em outro site.
* Inclui o protocolo (https) e o nome do domínio.

```html
<img src="https://www.w3schools.com/images/img_girl.jpg" alt="Imagem externa">
```

> ⚠️ **Atenção:**
>
> * Imagens externas podem estar protegidas por direitos autorais. Usá-las sem permissão pode violar leis de copyright.
> * Você **não tem controle** sobre imagens externas – elas podem ser removidas ou alteradas a qualquer momento, quebrando sua página.

---

**2. URL Relativa**

* Aponta para uma **imagem armazenada no próprio site** (no seu servidor).
* É o método mais recomendado.

**Exemplo 1: Caminho relativo ao arquivo atual (sem barra inicial)**

```html
<img src="img/foto.jpg" alt="Foto local">
```

**Exemplo 2: Caminho relativo à raiz do domínio (com barra inicial)**

```html
<img src="/imagens/foto.jpg" alt="Foto da pasta imagens">
```

> 💡 **Dica:**
> Prefira **URLs relativas**. Elas são mais seguras e **não quebram** caso o domínio do site seja alterado ou movido para outro servidor.

---

#### `width` e `height` (em `<img>`)

Definem a largura e altura de imagens (em pixels ou porcentagem).

```html
<img src="foto.jpg" width="300" height="200" alt="Paisagem">
```

#### `alt` (em `<img>`)

Texto alternativo, exibido quando a imagem não carrega. Também é importante para **acessibilidade**.

```html
<img src="grafico.png" alt="Gráfico de barras mostrando crescimento">
```

#### `style` (em qualquer elemento)

Permite adicionar **estilo CSS** direto na tag HTML.

```html
<p style="color:blue; font-size:18px;">Texto azul e maior</p>
```

#### `lang` (em `<html>`)

Declara o idioma principal da página. Essencial para SEO e acessibilidade.

```html
<html lang="pt-BR">
```

#### `title` (em qualquer elemento)

Mostra uma **dica flutuante** (tooltip) quando o mouse passa sobre o elemento.

```html
<p title="Este é um parágrafo explicativo.">Passe o mouse aqui</p>
```

---

### **Resumo: Atributos Comuns e Sua Utilização**

| Atributo       | Tag Comum | Finalidade                                          |
| -------------- | --------- | --------------------------------------------------- |
| `href`         | `<a>`     | URL de destino de um link                           |
| `src`          | `<img>`   | Caminho para o arquivo de imagem                    |
| `alt`          | `<img>`   | Texto alternativo em caso de erro ou acessibilidade |
| `width/height` | `<img>`   | Dimensões da imagem                                 |
| `style`        | Todos     | Aplicar CSS inline                                  |
| `lang`         | `<html>`  | Define o idioma do documento                        |
| `title`        | Todos     | Exibe uma dica sobre o conteúdo                     |

---

### **Exemplo Integrado**

```html
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <title>Exemplo com Atributos</title>
</head>
<body>

  <h1 title="Título Principal">Bem-vindo!</h1>
  
  <p style="color:orange;" title="Texto de introdução">Este parágrafo está em verde.</p>

  <img src="logo.png" alt="Logotipo da empresa" width="150" height="150">

  <a href="https://www.exemplo.com" title="Clique para visitar">Acesse nosso site</a>

</body>
</html>
```

![image](https://github.com/user-attachments/assets/3e69415f-3f91-4c5e-bd69-e8e7c5473a0c)


---
Claro! Aqui está a versão **simplificada da atividade do mini currículo**, **sem ícones** e com foco apenas no uso correto do HTML e dos atributos aprendidos:

---

### **Atividade Prática – Mini Currículo com Atributos**

Agora que você aprendeu sobre **elementos HTML** e seus **atributos mais comuns**, **refaça a atividade** criando uma página HTML com as seguintes informações:

#### **Requisitos do mini currículo:**

* Uma **foto pessoal ou ilustrativa** usando `<img>` com os atributos:

  * `src` (caminho da imagem),
  * `alt` (texto alternativo),
  * `width` (largura),
  * `title` (dica ao passar o mouse).
* **Nome completo** e **profissão** com uso de títulos (`<h1>`, `<h2>`).
* Uma **breve biografia** utilizando parágrafo (`<p>`), com atributo `title`.
* Uma **lista de habilidades** utilizando `<ul>` e `<li>`.
* Um ou mais **links para suas redes sociais** com `<a>` contendo `href` e `title`.

###  **Dicas Técnicas:**

* Utilize **URL relativa** para a imagem (por exemplo: `src="minhafoto.jpg"`).
* Adicione `lang="pt-BR"` no elemento `<html>` e `meta charset="UTF-8"` no `<head>`.
* O uso de `style` inline é opcional, mas pode ser usado para personalização simples.

---


