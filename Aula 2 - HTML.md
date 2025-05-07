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

