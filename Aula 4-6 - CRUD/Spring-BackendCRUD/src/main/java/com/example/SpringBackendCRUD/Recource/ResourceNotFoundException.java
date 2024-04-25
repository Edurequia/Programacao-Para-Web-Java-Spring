package com.example.SpringBackendCRUD.Recource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Anotação usada para definir a resposta HTTP que deve ser retornada quando essa exceção for lançada.
// Neste caso, indica que a resposta HTTP será 404 NOT FOUND, sugerindo que o recurso solicitado não foi encontrado.
@ResponseStatus(value = HttpStatus.NOT_FOUND)

// Definição da classe ResourceNotFoundException que estende RuntimeException, permitindo que essa exceção seja
// lançada durante a execução do programa sem a necessidade de tratá-la obrigatoriamente com try-catch.
public class ResourceNotFoundException extends RuntimeException {

    // Construtor que aceita uma mensagem como argumento. Essa mensagem é passada para o construtor da superclasse
    // RuntimeException e pode ser usada para fornecer mais detalhes sobre a exceção.
    public ResourceNotFoundException(String message) {
        super(message);
    }

    // Este é um local onde você pode adicionar construtores adicionais, se necessário, por exemplo, para aceitar
    // o identificador do recurso não encontrado ou para construir uma mensagem de erro mais detalhada internamente.
    // Além disso, métodos auxiliares também podem ser definidos aqui para melhorar a manipulação da exceção ou
    // para enriquecer as informações de erro retornadas ao cliente da API.

    // Exemplo de um construtor adicional que também inclui o nome da classe do recurso não encontrado para
    // construir uma mensagem mais detalhada:
    /*
    public ResourceNotFoundException(String resourceName, Object resourceId) {
        super(String.format("%s com ID %s não encontrado", resourceName, resourceId));
    }
    */
}

