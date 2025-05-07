# **HTML**  


## **Introdução ao HTML**  

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

---

### **Estrutura Básica de um Documento HTML**  
Todo arquivo HTML deve seguir este esqueleto:  
```html
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Meu Site</title>
</head>
<body>
    <!-- Conteúdo aqui -->
</body>
</html>
```
- `lang="pt-BR"`: Define o idioma.  
- `meta charset="UTF-8"`: Permite acentos e caracteres especiais.  
- `viewport`: Adapta a página para dispositivos móveis.  

---

