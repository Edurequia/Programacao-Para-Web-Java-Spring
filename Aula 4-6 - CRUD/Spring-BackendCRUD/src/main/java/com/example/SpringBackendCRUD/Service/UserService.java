package com.example.SpringBackendCRUD.Service;

import com.example.SpringBackendCRUD.Model.User;
import com.example.SpringBackendCRUD.Recource.ResourceNotFoundException;
import com.example.SpringBackendCRUD.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

// Anotação que marca a classe como um componente de serviço no contexto do Spring.
// Isso permite a injeção de dependência e a gestão do ciclo de vida pelo container do Spring.
@Service
public class UserService {

    // A referência para o repositório que gerencia as entidades User.
    // A anotação 'final' indica que a referência não pode ser alterada após a construção do objeto.
    private final UserRepository userRepository;

    // Construtor para injeção de dependência do UserRepository.
    // O Spring injeta automaticamente uma instância de UserRepository quando UserService é criado.
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Método para criar um novo usuário. Recebe um objeto User e o persiste no banco de dados.
    // Retorna o objeto User salvo, incluindo o ID atribuído automaticamente pelo banco de dados.
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Método para encontrar todos os usuários cadastrados no banco de dados.
    // Retorna uma lista de objetos User. Pode ser vazia se nenhum usuário for encontrado.
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    // Método para encontrar um usuário pelo seu ID.
    // Retorna um Optional<User>, que pode ou não conter um objeto User, dependendo se o usuário foi encontrado.
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    // Método para atualizar os dados de um usuário existente, identificado pelo seu ID.
    // Se o usuário com o ID fornecido não for encontrado, uma ResourceNotFoundException será lançada.
    // Retorna o objeto User atualizado.
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        // A lista de telefones é atualizada assumindo que o setter copia o estado. Em uma aplicação real,
        // você pode precisar de lógica adicional para gerenciar corretamente as relações e evitar problemas
        // como a duplicação de entidades.
        user.setPhones(userDetails.getPhones());
        return userRepository.save(user);
    }

    // Método para deletar um usuário pelo seu ID.
    // Se o usuário com o ID fornecido não for encontrado, uma ResourceNotFoundException será lançada.
    // Não retorna nenhum valor.
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        userRepository.delete(user);
    }
}

