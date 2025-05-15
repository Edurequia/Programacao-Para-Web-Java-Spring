# CSS Cascading Style Sheets

## Introdução ao CSS

CSS é a sigla para **Cascading Style Sheets** (Folhas de Estilo em Cascata).

CSS descreve como os **elementos HTML** devem ser exibidos na tela, em papel ou em outros meios.

CSS **economiza muito trabalho**. Ele pode controlar o layout de várias páginas da web ao mesmo tempo.

Elementos HTML podem ser exibidos de forma diferente, dependendo do **dispositivo** ou **tamanho da tela**.
Com o CSS, é possível adaptar a exibição de uma página para **diferentes tipos de dispositivos**, como telas grandes, pequenas ou impressoras.

### Exemplo simples de CSS
#### Estilo 1
![image](https://github.com/user-attachments/assets/5f71e2af-dbde-46a7-adb8-a744887a9ab2)
#### Estilo 2
![image](https://github.com/user-attachments/assets/3eccf5f5-6f3d-418b-96a1-303b6ebe5929)

## Sintaxe do CSS

A sintaxe básica do CSS é formada por um **seletor** e um **bloco de declaração**.

```css
seletor {
  propriedade: valor;
}
```

### Exemplo:

```css
p {
  color: red;
  text-align: center;
}
```

Nesse exemplo:

* `p` é o seletor (aplica-se a todos os parágrafos `<p>`).
* `color` e `text-align` são propriedades.
* `red` e `center` são os valores atribuídos a essas propriedades.
* As declarações são separadas por ponto e vírgula `;`.

## Selectors (Seletores)

Seletores são usados para **apontar qual ou quais elementos HTML devem ser estilizados** com CSS. Abaixo estão os tipos mais comuns de seletores.

### Seletor de Elemento (Type Selector)

Aplica estilo a todas as ocorrências de um elemento HTML.

```css
h1 {
  color: blue;
}
```

Aplica a todos os títulos `<h1>`.

### Seletor de Classe (Class Selector)

Aplica estilo a elementos com um atributo `class` específico. Usa o `.` antes do nome.

```css
.intro {
  font-size: 20px;
}
```

```html
<p class="intro">Este parágrafo será estilizado.</p>
```

### Seletor de ID (ID Selector)

Aplica estilo a um único elemento com `id`. Usa `#` antes do nome.

```css
#menu {
  background-color: lightgray;
}
```

```html
<div id="menu">Menu aqui</div>
```

### Seletor Universal

Aplica estilo a todos os elementos.

```css
* {
  margin: 0;
  padding: 0;
}
```

### Seletor de Agrupamento (Grouping Selector)

Aplica o mesmo estilo a vários seletores separados por vírgula.

```css
h1, h2, p {
  font-family: Arial;
}
```

### Seletor de Descendente

Aplica estilo a elementos que estão **dentro de outros elementos**.

```css
div p {
  color: green;
}
```

Seleciona todos os `<p>` que estão dentro de um `<div>`.

### Exercício Prático

**Objetivo:** Aplicar seletores CSS para estilizar diferentes seções do currículo.

**Instruções:**

1. Abra o arquivo HTML do seu currículo.
2. Adicione um arquivo CSS externo ou uma tag `<style>` no `<head>` do seu HTML.
3. Utilize os seguintes seletores para aplicar estilos:

   * **Seletor de Elemento:** Estilize todos os títulos `<h2>` com uma cor de sua escolha.
   * **Seletor de ID:** Aplique um fundo diferente à seção com `id="experiencia"`.
   * **Seletor de Classe:** Altere a fonte dos parágrafos com `class="descricao"`.
   * **Seletor de Descendente:** Mude a cor do texto dos `<li>` que estão dentro de uma `<ul>` com `class="habilidades"`.

## Como Usar CSS

Existem três maneiras principais de aplicar CSS a documentos HTML. Cada uma tem suas características, e a escolha adequada depende da organização e do tamanho do projeto.

### 1. CSS Externo

O CSS externo é definido em um arquivo separado com a extensão `.css`. Esse arquivo é então referenciado no HTML com a tag `<link>` dentro do elemento `<head>`.

```html
<head>
  <link rel="stylesheet" href="estilo.css">
</head>
```

Arquivo `estilo.css`:

```css
body {
  background-color: lightblue;
}
```

**Vantagens:**

* Permite reutilização de estilos em várias páginas.
* Mantém o HTML limpo e organizado.
* Facilita a manutenção e a colaboração em equipe.

É a forma **mais recomendada** para projetos reais e páginas com múltiplas seções.

---

### 2. CSS Interno

O CSS interno é definido dentro do próprio documento HTML, utilizando a tag `<style>` no cabeçalho (`<head>`).

```html
<head>
  <style>
    body {
      font-family: Arial, sans-serif;
    }
  </style>
</head>
```

**Vantagens:**

* Útil para páginas únicas ou testes rápidos.
* Código CSS e HTML ficam no mesmo arquivo.

**Desvantagens:**

* Pode dificultar a manutenção se o código CSS crescer.

---

### 3. CSS Inline

O CSS inline é inserido diretamente no elemento HTML, usando o atributo `style`.

```html
<p style="color:red;">Este parágrafo está em vermelho</p>
```

**Vantagens:**

* Aplicação rápida e direta.

**Desvantagens:**

* Não reutilizável.
* Dificulta a leitura e manutenção do código.
* Deve ser **evitado em projetos maiores**.

---

## Ordem de Prioridade (Cascade Order)

Quando diferentes formas de CSS são aplicadas ao mesmo elemento, a **ordem de cascata** determina qual estilo será aplicado.

A prioridade é a seguinte (da menor para a maior):

1. CSS Externo
2. CSS Interno
3. CSS Inline

Ou seja, o CSS inline **sobrepõe** o CSS interno e externo. O CSS interno **sobrepõe** o externo.

Além da forma de inserção, a **especificidade do seletor** (ID > Classe > Elemento) também influencia. Por exemplo, um seletor `#id` tem mais prioridade que `.classe`.

Exemplo de prioridade:

```html
<p id="exemplo" class="texto" style="color: red;">Texto</p>
```

* `color: red` no `style` será aplicado mesmo que exista `#exemplo { color: blue; }` no CSS.

Essa lógica é importante para entender por que certos estilos “não funcionam” — geralmente estão sendo sobrescritos por outro com maior prioridade.

---

## Comentários em CSS

Comentários são usados para explicar partes do código ou desativar regras temporariamente. Eles são ignorados pelo navegador e não afetam a exibição da página.

### Sintaxe

```css
/* Isso é um comentário */
```

### Usos comuns:

1. **Explicação de regras**

   ```css
   /* Define cor de fundo da página */
   body {
     background-color: white;
   }
   ```

2. **Desativar trechos de código**

   ```css
   /*
   p {
     font-size: 18px;
   }
   */
   ```

Utilize comentários para documentar seu código, especialmente em projetos maiores ou em equipe.

### Exercício Prático

**Objetivo:** Consolidar os conceitos de forma de uso do CSS, ordem de prioridade e uso de comentários no código.

**Instruções:**

1. Crie um arquivo chamado `estilo.css` na pasta do seu currículo.
2. Vincule esse arquivo ao seu HTML com a tag `<link>` no `<head>`.
3. No CSS externo, aplique pelo menos três estilos:

   * Um para o `body` (cor de fundo ou fonte).
   * Um para um elemento com classe (ex: `.secao`).
   * Um para um elemento com ID (ex: `#contato`).
4. Escreva comentários explicando para que serve cada regra.
5. Crie um exemplo comentando uma regra para testá-la desativada.





