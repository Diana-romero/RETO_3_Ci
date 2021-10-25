/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclo3.reto3.reto3.repositor;

import ciclo3.reto3.reto3.model.Administrative_users;
import ciclo3.reto3.reto3.repository.crud.Administrative_usersCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Diana Romero
 */
@Repository
public class Administrative_usersRepository {

    @Autowired
    private Administrative_usersCrudRepository administrative_usersCrudRepository;

    public List<Administrative_users> getAll() {
        return (List<Administrative_users>) administrative_usersCrudRepository.findAll();
    }

    public Optional<Administrative_users> getAdministrative_users(int id) {
        return administrative_usersCrudRepository.findById(id);
    }

    public Administrative_users save(Administrative_users administrative_users) {
        return administrative_usersCrudRepository.save(administrative_users);
    }

    public void delete(Administrative_users Administrative_users) {
        administrative_usersCrudRepository.delete(Administrative_users);
    }

}
