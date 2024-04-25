package com.example.SpringBackendCRUD.Controller;

import com.example.SpringBackendCRUD.Model.User;
import com.example.SpringBackendCRUD.Recource.ResourceNotFoundException;
import com.example.SpringBackendCRUD.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// Anotação que marca a classe como um controlador REST, permitindo que ela trate requisições HTTP.
@RestController

// Define o caminho base para todas as requisições HTTP tratadas por este controlador.
// Neste caso, todas as URLs começarão com '/users'.
@RequestMapping("/users")

public class UserController {

    // Injeção de dependência do serviço que lida com a lógica de negócios para usuários.
    // 'final' indica que a referência a userService não pode ser alterada após a inicialização.
    private final UserService userService;

    // Construtor para injeção de dependência do UserService.
    // @Autowired é opcional em construtores quando a classe tem apenas um construtor.
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Método para criar um novo usuário. Recebe um objeto User no corpo da requisição.
    // Retorna o usuário criado com o status HTTP 200 OK.
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        return ResponseEntity.ok(newUser);
    }

    // Método para recuperar todos os usuários cadastrados.
    // Retorna uma lista de usuários com o status HTTP 200 OK.
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    // Método para buscar um usuário pelo seu ID.
    // Caso o usuário não seja encontrado, lança uma ResourceNotFoundException.
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.findUserById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return ResponseEntity.ok(user);
    }

    // Método para atualizar um usuário existente pelo ID.
    // Recebe um objeto User com as novas informações no corpo da requisição.
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(id, userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    // Método para deletar um usuário pelo ID.
    // Retorna uma resposta vazia com status HTTP 200 OK.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}

