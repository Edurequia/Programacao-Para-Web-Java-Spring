## create-modal

### Importações e Interfaces

```typescript
import { useState } from "react";
```
- `import { useState } from "react";`: Esta linha importa o hook `useState` do React. `useState` é usado para adicionar estados locais em componentes funcionais.

```typescript
interface InputProps {
    label: string,
    value: string | number,
    updateValue(value: any): void
}   
```
- `interface InputProps`: Define a estrutura das propriedades esperadas pelo componente `Input`. Inclui `label` (string), `value` (string ou número), e `updateValue` (função que recebe um valor de qualquer tipo).

### Componente Input

```typescript
const Input = ({ label, value, updateValue }: InputProps) => {
    return (
        <>
            <label>{label}</label>
            <input value={value} onChange={event => updateValue(event.target.value)}></input>
        </>
    )
}
```
- `const Input = ({ label, value, updateValue }: InputProps)`: Esta é uma função de componente funcional que aceita `label`, `value`, e `updateValue` como props.
- `<label>{label}</label>`: Renderiza uma etiqueta HTML (`label`) com o texto da prop `label`.
- `<input value={value} onChange={event => updateValue(event.target.value)}></input>`: Renderiza um campo de entrada HTML (`input`). O valor do campo (`value`) é controlado pela prop `value`, e quando o valor do campo muda (`onChange`), a função `updateValue` é chamada com o novo valor (`event.target.value`).

### Componente CreateModal

```typescript
export function CreateModal(){
    const [name, setName] = useState("");
    const [description, setDescription] = useState("");
    const [price, setPrice] = useState(0);
    const [category, setCategory] = useState("");
    const [availability, setAvailability] = useState(true);
    const [image, setImage] = useState("");
```
- `export function CreateModal()`: Define e exporta uma função de componente funcional chamada `CreateModal`.
- `const [name, setName] = useState("");`: Declara um estado chamado `name` com um valor inicial de uma string vazia. `setName` é uma função usada para atualizar o estado `name`.
- O mesmo padrão é repetido para `description`, `price`, `category`, `availability`, e `image`, cada um com seu respectivo estado e função de atualização.

### Renderização do Modal

```typescript
    return(
        <div className="modal-overlay">
            <div className="modal-body">
                <h2>Add a new item to the menu</h2>
                <form className="input-container">
                    <Input label="name" value={name} updateValue={setName}/>
                    <Input label="description" value={description} updateValue={setDescription}/>
                    <Input label="price" value={price} updateValue={setPrice}/>
                    <Input label="category" value={category} updateValue={setCategory}/>
                    <Input label="availability" value={availability} updateValue={setAvailability}/>
                    <Input label="image" value={image} updateValue={setImage}/>
                </form>
            </div>
        </div>
    )
}
```
- `<div className="modal-overlay">` e `<div className="modal-body">`: Estrutura do modal, onde `modal-overlay` provavelmente aplica um fundo semi-transparente e `modal-body` define o conteúdo principal do modal.
- `<h2>Add a new item to the menu</h2>`: Cabeçalho do modal.
- `<form className="input-container">`: Define um contêiner de formulário que agrupa os campos de entrada.
- Cada `<Input ... />`: Renderiza um campo de entrada com suas respectivas props (`label`, `value`, `updateValue`) correspondentes aos estados (`name`, `description`, `price`, `category`, `availability`, `image`) e suas funções de atualização (`setName`, `setDescription`, `setPrice`, `setCategory`, `setAvailability`, `setImage`).


- **useState**: Hook que permite adicionar estados locais em componentes funcionais.
- **Interface**: Define a estrutura de dados esperada como prop em um componente.
- **Props**: Parâmetros passados para componentes para configuração e manipulação.
- **Desestruturação**: Sintaxe usada para extrair valores de objetos ou arrays.
- **Função de Componente Funcional**: Função em React que retorna elementos JSX para renderização.
- **Eventos**: `onChange` captura mudanças em campos de entrada e chama uma função de atualização.

## useProductDataMutate()

Vamos analisar o código em TypeScript para a função de mutação de dados de um produto usando `react-query`. Vou explicar cada parte do código e os comandos utilizados:

### Importações e Constantes

```typescript
import { productData } from "../interface/productData";
import { useMutation, useQueryClient } from "@tanstack/react-query";
import axios, { AxiosPromise } from "axios";

const API_URL = 'http://localhost:8080';
```
- `import { productData } from "../interface/productData";`: Importa a interface `productData`, que define a estrutura dos dados de um produto.
- `import { useMutation, useQueryClient } from "@tanstack/react-query";`: Importa os hooks `useMutation` e `useQueryClient` da biblioteca `react-query`. `useMutation` é usado para manipulações de dados (como POST, PUT, DELETE), enquanto `useQueryClient` permite o acesso ao cliente de consulta para operações avançadas.
- `import axios, { AxiosPromise } from "axios";`: Importa o módulo `axios` para fazer requisições HTTP e o tipo `AxiosPromise` para tipar as promessas retornadas pelas requisições.

```typescript
const API_URL = 'http://localhost:8080';
```
- `const API_URL = 'http://localhost:8080';`: Define a URL base da API que será utilizada para as requisições.

### Função de Postagem de Dados

```typescript
const postData = async (data: productData): AxiosPromise<any> => {
    const response = axios.post(API_URL + '/products', data);
    return response;
}
```
- `const postData = async (data: productData): AxiosPromise<any>`: Define uma função assíncrona `postData` que aceita um parâmetro `data` do tipo `productData` e retorna uma promessa (`AxiosPromise`).
- `const response = axios.post(API_URL + '/products', data);`: Utiliza `axios` para enviar uma requisição POST para a URL da API, incluindo os dados do produto no corpo da requisição.
- `return response;`: Retorna a resposta da requisição.

### Hook Personalizado para Mutação de Dados

```typescript
export function useProductDataMutate(){
    const queryClient = useQueryClient();
    const mutate = useMutation({
        mutationFn: postData,
        retry: 2,
        onSuccess: () => {
            queryClient.invalidateQueries({ queryKey: ['product-data'] })
        }
    });

    return mutate;
}
```
- `export function useProductDataMutate()`: Define e exporta uma função de hook personalizado chamada `useProductDataMutate`.
- `const queryClient = useQueryClient();`: Utiliza `useQueryClient` para obter uma instância do cliente de consulta, que permite manipulações avançadas de cache e estado de dados.
- `const mutate = useMutation({ ... })`: Define uma mutação usando `useMutation`. As opções passadas incluem:
  - `mutationFn: postData`: Especifica a função de mutação (`postData`) que será chamada para realizar a operação de POST.
  - `retry: 2`: Define o número de tentativas de repetição da mutação em caso de falha (2 vezes).
  - `onSuccess: () => { queryClient.invalidateQueries({ queryKey: ['product-data'] }) }`: Define uma função de callback que é chamada quando a mutação é bem-sucedida. Nesta função, `invalidateQueries` é usado para invalidar as consultas com a chave `['product-data']`, forçando uma refetch dos dados atualizados.

- **import**: Importa módulos, interfaces, e funções necessárias para o funcionamento do código.
- **axios**: Biblioteca para fazer requisições HTTP.
- **useMutation**: Hook do `react-query` usado para criar e gerenciar mutações de dados.
- **useQueryClient**: Hook do `react-query` usado para acessar o cliente de consulta, permitindo manipulações avançadas de cache e estado de dados.
- **postData**: Função assíncrona que realiza uma requisição POST para adicionar um novo produto.
- **queryClient.invalidateQueries**: Invalida as consultas em cache, forçando uma atualização dos dados.

## Alterando create-modal.tsx
### Mudanças na Função CreateModal

1. **Importação de Hooks e Interfaces**:
    ```typescript
    import { useProductDataMutate } from "../../hooks/useProductDataMutate";
    import { productData } from "../../interface/productData";
    ```
    - Foram adicionadas importações para `useProductDataMutate` e `productData`. `useProductDataMutate` é um hook personalizado para realizar mutações de dados de produtos, e `productData` é a interface que define a estrutura dos dados do produto.

2. **Uso do Hook de Mutação**:
    ```typescript
    const { mutate } = useProductDataMutate();
    ```
    - O hook `useProductDataMutate` é utilizado para obter a função `mutate`, que será usada para enviar os dados do produto para o backend.

3. **Função de Submit**:
    ```typescript
    const submit = () => {
        const productData: productData = {
            name,
            description,
            price,
            category,
            availability,
            image
        };
        mutate(productData);
    };
    ```
    - Foi adicionada a função `submit` que cria um objeto `productData` com os dados do produto coletados dos estados locais e chama `mutate` para enviar esses dados.

4. **Botão de Envio**:
    ```typescript
    <button onClick={submit} className="btn-secondary">
        postar
    </button>
    ```
    - Um botão foi adicionado ao final do modal. Este botão, quando clicado, chama a função `submit` para postar os dados do produto.

## Alterando App.tsx

### Mudanças no Código

1. **Importação de `useState`**:
    ```typescript
    import { useState } from 'react';
    ```
    - Foi adicionada a importação do hook `useState` do React para gerenciar o estado de abertura do modal.

2. **Importação do `CreateModal`**:
    ```typescript
    import { CreateModal } from './components/create-modal/create-modal';
    ```
    - Foi adicionada a importação do componente `CreateModal` que permite a criação de novos produtos.

3. **Estado para Controlar a Abertura do Modal**:
    ```typescript
    const [isModalOpen, setIsModalOpen] = useState(false);
    ```
    - Foi adicionado um estado booleano `isModalOpen` para controlar se o modal de criação de produto está aberto ou fechado. `setIsModalOpen` é a função que atualiza esse estado.

4. **Função para Alternar a Abertura do Modal**:
    ```typescript
    const handleOpenModal = () => {
        setIsModalOpen(prev => !prev);
    }
    ```
    - Foi adicionada a função `handleOpenModal` que alterna o estado de `isModalOpen` entre `true` e `false` (abrindo ou fechando o modal).

5. **Renderização Condicional do `CreateModal`**:
    ```typescript
    {isModalOpen && <CreateModal/>}
    ```
    - Foi adicionada uma renderização condicional para o componente `CreateModal`. O modal será renderizado apenas se `isModalOpen` for `true`.

6. **Botão para Abrir o Modal**:
    ```typescript
    <button onClick={handleOpenModal}>novo</button>
    ```
    - Foi adicionado um botão com o texto "novo" que, ao ser clicado, chama a função `handleOpenModal` para abrir ou fechar o modal.

- **Estado Adicional**: Adição de `useState` para gerenciar a abertura do modal.
- **Novo Componente**: Importação e uso do `CreateModal` para permitir a criação de novos produtos.
- **Função de Controle**: Função `handleOpenModal` para alternar o estado de abertura do modal.
- **Renderização Condicional**: Condicional para renderizar `CreateModal` com base no estado `isModalOpen`.
- **Interatividade**: Botão "novo" para abrir e fechar o modal.

### Resultado
![image](https://github.com/Herysson/Programacao-Para-Web-Java-Spring/assets/7634437/93b6b4ca-75e8-435a-a09d-add95483c78c)

## modal.css

### Explicação do CSS para o Modal

#### .modal-overlay
```css
.modal-overlay {
    position: fixed;
    inset: 0;
    background-color: rgba(0,0,0,0.4);
    overflow: hidden;
    height: 100vh;
    width: 100vw;

    display: flex;
    align-items: center;
    justify-content: center;

    z-index: 999;
}
```
- `position: fixed;`: Fixa o modal na tela, independentemente da rolagem.
- `inset: 0;`: Define as propriedades top, right, bottom e left como 0, estendendo o modal para cobrir toda a área da tela.
- `background-color: rgba(0,0,0,0.4);`: Define uma cor de fundo semi-transparente preta para criar um efeito de sobreposição.
- `overflow: hidden;`: Oculta qualquer conteúdo que transborde da área do modal.
- `height: 100vh; width: 100vw;`: Define a altura e largura do modal como 100% da altura e largura da viewport.
- `display: flex; align-items: center; justify-content: center;`: Utiliza flexbox para centralizar o conteúdo do modal tanto vertical quanto horizontalmente.
- `z-index: 999;`: Define uma alta prioridade de empilhamento para garantir que o modal fique acima de outros elementos da página.

#### .modal-body
```css
.modal-overlay .modal-body {
    background-color: rgb(182, 182, 182);
    padding: 24px;
    height: 80%;
    width: 60%;
    border-radius: 24px;

    display: flex;
    align-items: flex-start;
    flex-direction: column;
    justify-content: space-between;
}
```
- `background-color: rgb(182, 182, 182);`: Define a cor de fundo do corpo do modal como cinza claro.
- `padding: 24px;`: Adiciona um preenchimento interno de 24px ao redor do conteúdo do modal.
- `height: 80%; width: 60%;`: Define a altura e largura do corpo do modal como 80% e 60% da altura e largura da viewport, respectivamente.
- `border-radius: 24px;`: Adiciona cantos arredondados ao corpo do modal com um raio de 24px.
- `display: flex; align-items: flex-start; flex-direction: column; justify-content: space-between;`: Utiliza flexbox para organizar o conteúdo do modal em uma coluna, alinhando os itens no início e espaçando-os uniformemente.

#### .modal-body h2
```css
.modal-overlay .modal-body h2 {
    font-size: 32px;
    color: #2d2d2d;
}
```
- `font-size: 32px;`: Define o tamanho da fonte do título (`h2`) como 32px.
- `color: #2d2d2d;`: Define a cor do texto do título como um tom de cinza escuro.

#### .input-container
```css
.modal-overlay .modal-body .input-container {
    width: calc(100% - 24px);
}
```
- `width: calc(100% - 24px);`: Define a largura do contêiner de entrada como 100% menos 24px, ajustando-o para se alinhar ao preenchimento do modal.

#### input
```css
.modal-overlay .modal-body input {
    padding: 12px;
    border: 2px solid #c6c5c5;
    color: rgba(53, 53, 53, 0.9);
    background-color: rgb(255, 255, 255);
    font-size: 18px;
    line-height: 24px;
    border-radius: 12px;
    width: 100%;

    margin-bottom: 12px;
}
```
- `padding: 12px;`: Adiciona um preenchimento interno de 12px aos campos de entrada.
- `border: 2px solid #c6c5c5;`: Define uma borda sólida de 2px com uma cor cinza clara.
- `color: rgba(53, 53, 53, 0.9);`: Define a cor do texto dos campos de entrada como um tom de cinza.
- `background-color: rgb(255, 255, 255);`: Define a cor de fundo dos campos de entrada como branca.
- `font-size: 18px; line-height: 24px;`: Define o tamanho da fonte e a altura da linha dos campos de entrada.
- `border-radius: 12px;`: Adiciona cantos arredondados aos campos de entrada com um raio de 12px.
- `width: 100%;`: Define a largura dos campos de entrada como 100%.
- `margin-bottom: 12px;`: Adiciona uma margem inferior de 12px aos campos de entrada para espaçamento.

#### label
```css
.modal-overlay .modal-body label {
    color: #242424;
    font-weight: 600;
    margin-bottom: 8px;
    font-size: 18px;
}
```
- `color: #242424;`: Define a cor do texto das etiquetas como um tom de cinza escuro.
- `font-weight: 600;`: Define o peso da fonte das etiquetas como 600 (semi-negrito).
- `margin-bottom: 8px;`: Adiciona uma margem inferior de 8px às etiquetas para espaçamento.
- `font-size: 18px;`: Define o tamanho da fonte das etiquetas como 18px.

#### .btn-secondary
```css
.modal-overlay .modal-body .btn-secondary {
    position: initial;
    width: 100%;
    margin-top: 32px;
}

.modal-overlay .modal-body .btn-secondary:hover {
    background-color: #3a44f8;
    transform: scale(1);
}
```
- `position: initial;`: Define a posição do botão como inicial (padrão do navegador).
- `width: 100%;`: Define a largura do botão como 100%.
- `margin-top: 32px;`: Adiciona uma margem superior de 32px ao botão para espaçamento.
- `background-color: #3a44f8;`: (no hover) Define a cor de fundo do botão ao passar o mouse como um tom de azul.
- `transform: scale(1);`: (no hover) Define a escala do botão como 1, para efeito de transformação.

### Resultado

![image](https://github.com/Herysson/Programacao-Para-Web-Java-Spring/assets/7634437/d5044f1d-bf2d-4393-ad37-849f4d872bfc)

## Feedback para o usuário

### App.tsx - Renderização Condicional
```jsx
{isModalOpen && <CreateModal closeModal={handleOpenModal}/>}
```
- **`isModalOpen`**: Esta variável de estado é um booleano que indica se o modal está aberto (`true`) ou fechado (`false`).
- **`&&`**: O operador lógico `&&` é usado para renderizar o componente `CreateModal` apenas quando `isModalOpen` for `true`. Isso é uma forma comum em React de realizar renderização condicional. Se `isModalOpen` for `false`, o lado direito da expressão (`<CreateModal closeModal={handleOpenModal}/>`) não será avaliado, e nada será renderizado.
- **`<CreateModal closeModal={handleOpenModal}/>`**: Este é o componente `CreateModal` sendo renderizado. Note que um prop adicional chamado `closeModal` está sendo passado para ele.

### create-model.tsx

### Comentários sobre as Diferenças no Código

#### Importações Adicionadas
```typescript
import { useEffect, useState } from "react";
import "./modal.css"
```
- **useEffect**: Adicionada para realizar efeitos colaterais, como fechar o modal quando a mutação for bem-sucedida.
- **modal.css**: Adicionada a importação do arquivo CSS específico para o modal.

#### Novo Interface ModalProps
```typescript
interface ModalProps {
    closeModal(): void
}
```
- Adicionada uma nova interface `ModalProps` que define a prop `closeModal` para fechar o modal.

#### Modificações no Componente `CreateModal`
- **Novo parâmetro `closeModal`**:
  ```typescript
  export function CreateModal({ closeModal }: ModalProps) {
  ```
  - O componente agora recebe `closeModal` como prop, permitindo que ele feche o modal após uma operação bem-sucedida.

#### Estado Adicional
```typescript
const { mutate, isSuccess } = useProductDataMutate();
```
- Além da função `mutate`, o hook `useProductDataMutate` agora também retorna `isSuccess`, que indica se a mutação foi bem-sucedida.

#### Efeito para Fechar o Modal
```typescript
useEffect(() => {
    if (!isSuccess) return;
    closeModal();
}, [isSuccess])
```
- Adicionado um `useEffect` que monitora `isSuccess`. Quando `isSuccess` for `true`, o modal será fechado através da chamada `closeModal`.

#### Chamando `closeModal` após Sucesso
```typescript
const submit = () => {
    const productData: productData = {
        name,
        description,
        price,
        category,
        availability,
        image
    }
    mutate(productData)
}
```
- A função `submit` permanece a mesma, mas agora o sucesso da mutação é monitorado para fechar o modal.

#### Uso do Arquivo CSS
```typescript
import "./modal.css"
```
- Importação explícita do arquivo CSS `modal.css` para garantir que os estilos específicos do modal sejam aplicados.

### Resumo das Diferenças
1. **Importação do `useEffect`**: Para monitorar e reagir ao sucesso da mutação.
2. **Interface `ModalProps`**: Para definir a prop `closeModal`.
3. **Prop `closeModal` no `CreateModal`**: Adicionada para permitir o fechamento do modal.
4. **Estado `isSuccess`**: Usado para verificar se a mutação foi bem-sucedida.
5. **Efeito `useEffect`**: Para fechar o modal automaticamente após o sucesso da mutação.
6. **Importação do Arquivo CSS**: Para garantir que os estilos do modal sejam aplicados corretamente.

Essas mudanças permitem que o modal se feche automaticamente após a criação bem-sucedida de um produto, melhorando a experiência do usuário ao fornecer um feedback visual imediato.


