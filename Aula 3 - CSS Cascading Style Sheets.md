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

## Elementos Básicos do CSS: `background`

O plano de fundo de um elemento pode ser estilizado com **cores sólidas**, **imagens**, **gradientes** e **propriedades combinadas**. Essas técnicas ajudam a destacar seções, organizar visualmente a página e melhorar a experiência do usuário.

### 1. `background-color`

Define uma **cor sólida de fundo**.

```css
body {
  background-color: lightblue;
}

.secao {
  background-color: #f0f0f0;
}

.destaque {
  background-color: rgba(255, 0, 0, 0.3); /* vermelho com transparência */
}
```

Você pode usar cores em:

* nome (`red`, `blue`, `lightgray`)
* hexadecimal (`#f5f5f5`)
* RGB/RGBA (`rgb(255,255,255)`, `rgba(255,0,0,0.5)`)
* HSL/HSLA (`hsl(0, 100%, 50%)`)

 

### 2. `background-image`

Define uma **imagem como plano de fundo**.

```css
body {
  background-image: url("textura.png");
}
```

Para evitar repetições inesperadas, configure:

```css
body {
  background-repeat: no-repeat;
  background-position: center;
  background-size: cover;
}
```

 

### 3. `background-repeat`

Controla **se a imagem de fundo será repetida**.

```css
background-repeat: repeat;      /* padrão */
background-repeat: repeat-x;    /* só na horizontal */
background-repeat: repeat-y;    /* só na vertical */
background-repeat: no-repeat;   /* não repete */
```

 

### 4. `background-position` e `background-size`

Controlam **onde a imagem será exibida** e **seu tamanho**.

```css
background-position: top right;
background-size: cover;       /* preenche a área toda mantendo proporção */
background-size: contain;     /* ajusta a imagem dentro do espaço */
```

 

### 5. `linear-gradient` (fundo com gradiente de cores)

O `linear-gradient()` permite criar transições suaves entre duas ou mais cores. Pode ser usado como valor de `background-image`.

```css
body {
  background: linear-gradient(135deg, #ffffff, #e0f0ff, #cce0f5, #b3d1f0);
  margin: 0;
}
```

Neste exemplo:

* `135deg` define o ângulo do gradiente.
* A sequência de cores será misturada suavemente.

Outros exemplos:

```css
header {
  background: linear-gradient(to right, #ffcc00, #ff9900);
}

.destaque {
  background: linear-gradient(to bottom, #ffffff, #eeeeee);
}
```

 

## Exercício Prático

**Objetivo:** Explorar diferentes técnicas de fundo (cores, imagens, gradientes) no currículo.

**Instruções:**

1. No seu arquivo `curriculo.css`, aplique ao menos **3 variações de background**:

   * Um com **cor sólida** usando `rgba` ou `hsl`.
   * Um com **imagem de fundo**, utilizando `background-repeat`, `background-position` e `background-size`.
   * Um com **gradiente** utilizando `linear-gradient`.

2. Experimente aplicar essas variações em diferentes seções da página:

   * `body`
   * `.secao` (classe de uma seção do currículo)
   * `#formacao` ou `#experiencia` (IDs de seções específicas)

3. Comente ao lado de cada regra explicando o que ela faz.

Perfeito! Vamos construir uma seção **completa e didática sobre bordas (borders) em CSS**, incluindo:

* tipos de bordas,
* propriedades de largura, cor e lados,
* uso de bordas arredondadas (`border-radius`),
* a propriedade `border` no formato *shorthand*,
* e um exercício prático baseado no currículo dos alunos.

A seção também inclui exemplos semelhantes à imagem que você enviou.

 

## Elementos Básicos do CSS: `border`

A propriedade `border` é usada para aplicar **contornos visuais** em volta de elementos HTML. Ela é muito útil para destacar seções, caixas de conteúdo, menus e divisores.

### Tipos de bordas

Você pode definir diferentes estilos de borda usando `border-style`. Os valores permitidos são:

```css
border-style: dotted;   /* pontilhada */
border-style: dashed;   /* tracejada */
border-style: solid;    /* sólida */
border-style: double;   /* dupla */
border-style: groove;   /* efeito 3D entalhado */
border-style: ridge;    /* efeito 3D em relevo */
border-style: inset;    /* parece afundado */
border-style: outset;   /* parece elevado */
border-style: none;     /* sem borda */
border-style: hidden;   /* borda oculta (usado em tabelas) */
```

### Exemplo:

```css
div {
  border-style: solid;
}
```

 

### Largura da borda (`border-width`)

Controla **a espessura da borda**:

```css
border-width: 1px;
border-width: 2px 4px; /* cima/baixo | esquerda/direita */
```

Você pode especificar larguras diferentes para cada lado com:

```css
border-top-width: 4px;
border-bottom-width: 2px;
```

 

### Cor da borda (`border-color`)

Define a cor da borda:

```css
border-color: red;
border-top-color: blue;
```

 

### Lados da borda

Você pode aplicar bordas em lados específicos:

```css
border-top: 2px solid red;
border-bottom: 1px dashed blue;
border-left: 5px solid green;
border-right: none;
```

 

### Shorthand `border`

Você pode combinar estilo, cor e largura de forma simplificada:

```css
border: 2px solid black;
```

 

### Bordas arredondadas (`border-radius`)

Permite **arredondar os cantos** de um elemento:

```css
border-radius: 10px;
```

Exemplo completo:

```css
.caixa {
  border: 1px solid gray;
  border-radius: 8px;
  padding: 10px;
}
```

 

### Exemplos práticos

```html
<div style="border: 1px solid black; padding: 10px;">
  Eu tenho bordas em todos os lados.
</div>

<div style="border-bottom: 2px solid red; margin-top: 20px;">
  Eu tenho uma borda inferior vermelha.
</div>

<div style="border: 1px solid #ccc; border-radius: 10px; padding: 10px; margin-top: 20px;">
  Eu tenho bordas arredondadas.
</div>

<div style="border-left: 5px solid blue; background-color: #e0fafa; padding: 10px; margin-top: 20px;">
  Eu tenho uma borda esquerda azul.
</div>
```

 

## Exercício Prático

**Objetivo:** Aplicar diferentes tipos e estilos de bordas no projeto de currículo.

**Instruções:**

1. No seu arquivo `curriculo.css`, escolha pelo menos **3 seções** do currículo para aplicar estilos de borda diferentes.

2. Em cada uma, utilize uma combinação de:

   * `border-style`
   * `border-color`
   * `border-width`
   * `border-radius` (quando quiser cantos arredondados)

3. Teste também aplicar bordas **em apenas um lado** (topo, esquerda, etc).

4. Adicione comentários no CSS explicando suas escolhas.


## Espaçamento e Tamanho de Elementos: `margin`, `padding`, `width`, `height`

No CSS, o **tamanho e espaçamento dos elementos** são controlados principalmente por estas quatro propriedades:

* `margin`: espaço **externo** ao redor do elemento (fora da borda).
* `padding`: espaço **interno** entre o conteúdo e a borda do elemento.
* `width`: **largura** do elemento.
* `height`: **altura** do elemento.

 

### `margin`

Define o espaço **ao redor** do elemento (do lado de fora da borda).

```css
div {
  margin: 20px;
}
```

#### Variações:

```css
margin-top: 10px;
margin-right: 15px;
margin-bottom: 20px;
margin-left: 5px;
```

#### Shorthand:

```css
margin: 10px 15px 20px 5px;
/* ordem: top right bottom left */
```

Se dois valores forem usados:

```css
margin: 10px 20px;
/* top/bottom = 10px, left/right = 20px */
```

 

### `padding`

Define o espaço **interno** entre o conteúdo e a borda do elemento.

```css
div {
  padding: 10px;
}
```

#### Variações:

```css
padding-top: 8px;
padding-right: 12px;
padding-bottom: 10px;
padding-left: 5px;
```

#### Shorthand:

```css
padding: 8px 12px 10px 5px;
/* ordem: top right bottom left */
```

 

### `width` e `height`

Definem a **largura** e a **altura** de um elemento. Podem ser usadas com unidades fixas ou relativas.

```css
div {
  width: 300px;
  height: 150px;
}
```

Também é possível usar valores relativos como `%`:

```css
div {
  width: 80%;
}
```

 

### Exemplo completo

```html
<div style="width: 300px; height: 100px; background-color: lightgray; padding: 15px; margin: 20px;">
  Este é um bloco com width, height, padding e margin definidos.
</div>
```

 

## Diferença visual entre margin e padding

| Propriedade | Descrição                  | Resultado                                              |
| ----------- | -------------------------- | ------------------------------------------------------ |
| `padding`   | Espaço **dentro** da borda | Aumenta o espaço entre o conteúdo e a borda            |
| `margin`    | Espaço **fora** da borda   | Aumenta a distância entre o elemento e outros ao redor |

 

## Exercício Prático

**Objetivo:** Aplicar espaçamentos e tamanhos personalizados às seções do currículo usando `margin`, `padding`, `width` e `height`.

**Instruções:**

1. No seu arquivo `curriculo.css`, escolha pelo menos **três seções** e defina:

   * Um `padding` interno que deixe o conteúdo confortável.
   * Um `margin` para separar visualmente essa seção das demais.
   * Uma `width` fixa ou relativa (como `80%`).
   * Uma `height` (opcional, mas interessante testar).

2. Use diferentes combinações de shorthand e propriedades específicas (`top`, `left`, etc).

3. Adicione **comentários explicando** por que cada espaçamento foi usado.

Claro! Abaixo está a seção completa e didática sobre **`position` e `align` no CSS**, abordando:

* os cinco valores da propriedade `position`,
* todas as propriedades de alinhamento tratadas em [W3Schools - CSS Align](https://www.w3schools.com/css/css_align.asp),
* explicações, exemplos claros,
* e um **exercício prático** para aplicação no currículo dos alunos.

 

## Controle de Posição e Alinhamento no CSS

### Parte 1: `position`

A propriedade `position` define **como um elemento HTML é posicionado no documento**. Ela funciona em conjunto com as propriedades `top`, `right`, `bottom` e `left`.

#### 1. `static` (padrão)

* É o valor padrão.
* Os elementos são posicionados de forma "normal", seguindo o fluxo do HTML.
* Não aceita `top`, `left`, etc.

```css
div {
  position: static;
}
```

#### 2. `relative`

* Posiciona o elemento **relativamente à sua posição original**.
* Ele continua ocupando o mesmo espaço no fluxo do documento.

```css
div {
  position: relative;
  top: 20px;   /* move 20px para baixo */
  left: 10px;  /* move 10px para a direita */
}
```

#### 3. `absolute`

* Remove o elemento do fluxo normal da página.
* Ele é posicionado **em relação ao elemento pai mais próximo com `position: relative`** (ou ao `<html>` se não houver pai posicionado).

```css
div {
  position: absolute;
  top: 0;
  right: 0;
}
```

#### 4. `fixed`

* O elemento é fixado em um lugar da tela, **mesmo durante o scroll da página**.
* Muito usado em menus fixos e botões “voltar ao topo”.

```css
#topo {
  position: fixed;
  top: 10px;
  right: 10px;
}
```

#### 5. `sticky`

* Combina características de `relative` e `fixed`.
* O elemento se comporta como `relative` até atingir um limite (ex: topo da página), e então passa a agir como `fixed`.

```css
h2 {
  position: sticky;
  top: 0;
  background-color: white;
}
```

 

## Parte 2: Alinhamento

A seguir, vamos abordar as propriedades que controlam o alinhamento de texto e blocos.

### `text-align`

Alinha o **conteúdo de texto** (e elementos inline) **dentro de um elemento**.

```css
p {
  text-align: center;   /* left | right | justify */
}
```

### `text-align-last`

Alinha a **última linha** de um parágrafo.

```css
p {
  text-align: justify;
  text-align-last: right;
}
```

### `vertical-align`

Alinha elementos **inline** verticalmente dentro de sua linha.

```css
img {
  vertical-align: middle; /* top | bottom | text-top | text-bottom */
}
```

### `line-height`

Define o **espaçamento vertical entre as linhas de texto**.

```css
p {
  line-height: 1.5;
}
```

### `direction`

Define a direção do texto: da esquerda para a direita (`ltr`) ou da direita para a esquerda (`rtl`).

```css
p {
  direction: rtl;
}
```

### `unicode-bidi`

Controla como o navegador deve lidar com direções mistas (esquerda-direita / direita-esquerda).

```css
p {
  direction: rtl;
  unicode-bidi: bidi-override;
}

```
### Centralizando Elementos com Flexbox

Além do `text-align` e `vertical-align`, uma forma poderosa e moderna de **centralizar elementos horizontal e verticalmente** é utilizando **Flexbox**, com as propriedades `display: flex`, `justify-content` e `align-items`.

### Exemplo: centralização perfeita no centro do contêiner

```css
.align-center-container {
    display: flex;
    justify-content: center; /* Centraliza horizontalmente */
    align-items: center;     /* Centraliza verticalmente */
    height: 100px;           /* Altura do contêiner */
    border: 1px solid #aaa;  /* Visualização */
}
```

HTML correspondente:

```html
<div class="align-center-container">
  <p>Eu estou centralizado!</p>
</div>
```

**Explicação**:

* `display: flex` ativa o layout flexível no contêiner.
* `justify-content: center` centraliza o conteúdo **na horizontal**.
* `align-items: center` centraliza o conteúdo **na vertical**.
* O contêiner precisa de uma **altura definida** para que a centralização vertical funcione corretamente.

 

## Exercício Prático

**Objetivo:** Aplicar posicionamento e alinhamento em seções do currículo.

### Parte A: Position

1. Escolha **dois elementos** do seu currículo:

   * Um que será reposicionado com `position: relative`.
   * Outro que pode ser fixado com `position: fixed` (ex: botão "voltar ao topo").

2. Adicione um bloco com `position: absolute` dentro de um contêiner com `position: relative`.

3. Teste um cabeçalho de seção com `position: sticky`.

### Parte B: Align

1. Aplique `text-align: center` nos títulos.
2. Ajuste o `line-height` dos parágrafos para melhorar a leitura.
3. Experimente `vertical-align` em uma imagem com texto ao lado.

## Estilizando Tabelas com CSS

As tabelas HTML podem ser estilizadas com CSS para ficarem mais legíveis, modernas e responsivas. A seguir, veremos como personalizar tabelas utilizando as propriedades de `border`, tamanho, alinhamento, estilo visual e responsividade.


### 1. Bordas de Tabelas (`border`)

Por padrão, as tabelas exibem bordas separadas para cada célula. Podemos unificá-las com `border-collapse`.

```css
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  border: 1px solid black;
  padding: 8px;
}
```

### 2. Tamanho de Colunas e Altura de Linhas (`width` e `height`)

Você pode controlar a **largura das colunas** e a **altura das linhas**:

```css
th, td {
  width: 150px;
  height: 40px;
}
```

Use `width: 100%` na tabela para que ela se expanda completamente no contêiner pai.



### 3. Alinhamento (`text-align` e `vertical-align`)

O alinhamento do conteúdo das células pode ser ajustado horizontal e verticalmente.

```css
th {
  text-align: center;
  vertical-align: middle;
}

td {
  text-align: left;
  vertical-align: top;
}
```


### 4. Estilo Visual (Cores Alternadas, Hover)

Use pseudo-classes para criar efeitos visuais agradáveis:

```css
tr:nth-child(even) {
  background-color: #f2f2f2;
}

tr:hover {
  background-color: #e0f7fa;
}

th {
  background-color: #4caf50;
  color: white;
}
```

Esses estilos melhoram a leitura e a experiência do usuário.

### 5. Tabela Responsiva

Tabelas largas podem estourar o layout em telas pequenas. Use `overflow-x: auto` para adicionar rolagem horizontal.

```css
.table-container {
  overflow-x: auto;
}

table {
  width: 100%;
  border-collapse: collapse;
}
```

HTML correspondente:

```html
<div class="table-container">
  <table>
    <thead>
      <tr>
        <th>Nome</th>
        <th>Cargo</th>
        <th>Departamento</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>João</td>
        <td>Desenvolvedor</td>
        <td>TI</td>
      </tr>
      <tr>
        <td>Ana</td>
        <td>Designer</td>
        <td>Criação</td>
      </tr>
    </tbody>
  </table>
</div>
```


### Exemplo completo de CSS para Tabela

```css
.table-container {
  overflow-x: auto;
  margin-top: 20px;
}

table {
  border-collapse: collapse;
  width: 100%;
  min-width: 600px;
}

th, td {
  border: 1px solid #ddd;
  padding: 12px;
  text-align: left;
  height: 50px;
}

th {
  background-color: #4caf50;
  color: white;
}

tr:nth-child(even) {
  background-color: #f9f9f9;
}

tr:hover {
  background-color: #e0f7fa;
}
```

## Exercício Prático

**Objetivo:** Criar uma tabela estilizada com CSS que organize alguma informação relevante no currículo (ex: histórico profissional, habilidades técnicas, cronograma de projetos).

**Instruções:**

1. Crie uma tabela em seu HTML com pelo menos **3 colunas e 3 linhas**.
2. Envolva a tabela em uma `div` com classe `table-container` para torná-la responsiva.
3. Aplique as seguintes propriedades:

   * `border` com `border-collapse`
   * cores alternadas nas linhas com `:nth-child(even)`
   * alinhamento do texto
   * `hover` na linha
   * largura 100% e rolagem horizontal
4. Utilize `th` para os cabeçalhos.


## Estilizando Formulários com CSS

Formulários são componentes essenciais da web. Com CSS, é possível torná-los mais elegantes, acessíveis e integrados ao design da página.

A seguir, trabalharemos com um exemplo HTML de formulário que será incrementado passo a passo com técnicas de estilização.


### Exemplo Base de Formulário

```html
<form>
  <label for="nome">Nome:</label>
  <input type="text" id="nome" name="nome">

  <label for="email">Email:</label>
  <input type="email" id="email" name="email">

  <label for="mensagem">Mensagem:</label>
  <textarea id="mensagem" name="mensagem"></textarea>

  <label for="setor">Setor:</label>
  <select id="setor" name="setor">
    <option>TI</option>
    <option>RH</option>
    <option>Financeiro</option>
  </select>

  <input type="submit" value="Enviar">
</form>
```


### Styling Input Fields

```css
input[type=text],
input[type=email],
textarea,
select {
  width: 100%;
  padding: 10px;
  margin-top: 6px;
  margin-bottom: 16px;
  box-sizing: border-box;
}
```


### Padded Inputs

Adicionando preenchimento interno (`padding`) para melhor usabilidade.

```css
input[type=text] {
  padding: 12px;
}
```


### Bordered Inputs

```css
input[type=text],
input[type=email],
textarea {
  border: 2px solid #ccc;
  border-radius: 4px;
}
```

### Colored Inputs

```css
input[type=text] {
  background-color: #f8f8f8;
}
```

### Focused Inputs

```css
input[type=text]:focus,
textarea:focus {
  border: 2px solid #4CAF50;
  background-color: #e8f5e9;
  outline: none;
}
```


### Input com ícone

```html
<div class="input-icon">
  <i class="fa fa-user"></i>
  <input type="text" placeholder="Nome de usuário">
</div>
```

```css
.input-icon {
  position: relative;
}

.input-icon i {
  position: absolute;
  left: 10px;
  top: 12px;
  color: gray;
}

.input-icon input {
  padding-left: 30px;
}
```


### Animated Search Input

```html
<input type="text" id="pesquisa" placeholder="Pesquisar...">
```

```css
#pesquisa {
  width: 100px;
  transition: width 0.4s ease-in-out;
}

#pesquisa:focus {
  width: 250px;
}
```


### Styling Textareas

```css
textarea {
  height: 100px;
  resize: vertical; /* ou none, both, horizontal */
}
```

### Styling Select Menus

```css
select {
  background-color: #fff;
  border: 1px solid #ccc;
  padding: 10px;
  border-radius: 4px;
}
```

### Styling Input Buttons

```css
input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}
```


## Exemplo Final Combinado

```html
<form>
  <label for="nome">Nome:</label>
  <input type="text" id="nome" name="nome" placeholder="Digite seu nome">

  <label for="email">Email:</label>
  <input type="email" id="email" name="email" placeholder="Digite seu email">

  <label for="mensagem">Mensagem:</label>
  <textarea id="mensagem" name="mensagem" placeholder="Digite sua mensagem"></textarea>

  <label for="setor">Setor:</label>
  <select id="setor" name="setor">
    <option>TI</option>
    <option>RH</option>
    <option>Financeiro</option>
  </select>

  <input type="submit" value="Enviar">
</form>
```

```css
form {
  max-width: 500px;
  margin: auto;
  background-color: #f2f2f2;
  padding: 20px;
  border-radius: 8px;
}

input[type=text],
input[type=email],
textarea,
select {
  width: 100%;
  padding: 12px;
  margin-top: 6px;
  margin-bottom: 16px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=text]:focus,
input[type=email]:focus,
textarea:focus {
  border: 2px solid #4CAF50;
  background-color: #e8f5e9;
  outline: none;
}

input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}
```



## Exercício Prático

**Objetivo:** Criar um formulário de contato ou cadastro no seu currículo, aplicando diferentes técnicas de estilização.

**Instruções:**

1. Crie uma seção `<form>` no seu currículo com os campos:

   * Nome
   * Email
   * Área de atuação (Select)
   * Comentários (Textarea)
   * Botão de envio

2. Aplique:

   * `padding` e `border-radius` nos inputs
   * `hover` e `focus` para campos e botões
   * Um input com ícone (opcional)
   * Campo de busca com `transition` (opcional)

3. Comente seu CSS explicando cada estilo aplicado.

