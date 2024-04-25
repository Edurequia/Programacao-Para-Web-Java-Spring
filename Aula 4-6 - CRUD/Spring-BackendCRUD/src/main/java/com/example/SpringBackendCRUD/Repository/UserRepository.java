package com.example.SpringBackendCRUD.Repository;

import com.example.SpringBackendCRUD.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface UserRepository, que estende JpaRepository para fornecer funcionalidades CRUD
// para a entidade User. O JpaRepository requer dois parâmetros: o tipo da entidade e o tipo de seu identificador.
public interface UserRepository extends JpaRepository<User, Long> {
}
