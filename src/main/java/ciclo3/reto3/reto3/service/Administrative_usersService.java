/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclo3.reto3.reto3.service;

import ciclo3.reto3.reto3.model.Administrative_users;
import ciclo3.reto3.reto3.repositor.Administrative_usersRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diana Romero
 */
@Service
public class Administrative_usersService {

    public static Optional<Administrative_users> getAdministrative_users(int idAdministrative_users) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    @Autowired
    private Administrative_usersRepository administrative_usersRepository;

    public List<Administrative_users> getAll() {
        return administrative_usersRepository.getAll();
    }

    public Optional<Administrative_users> getAdministrate_users(int administrative_usersId) {
        return administrative_usersRepository.getAdministrative_users(administrative_usersId);
    }

    public Administrative_users save(Administrative_users administrative_users) {
        if (administrative_users.getIdAdministrative_users() == null) {
            return administrative_usersRepository.save(administrative_users);
        } else {
            Optional<Administrative_users> aux = administrative_usersRepository.getAdministrative_users(administrative_users.getIdAdministrative_users());
            if (aux.isEmpty()) {
                return administrative_usersRepository.save(administrative_users);
            } else {
                return administrative_users;
            }
        }
    }

    public Administrative_users update(Administrative_users administrative_users) {
        if (administrative_users.getIdAdministrative_users() != null) {
            Optional<Administrative_users> aux = administrative_usersRepository.getAdministrative_users(administrative_users.getIdAdministrative_users());
            if (!aux.isEmpty()) {
                if (administrative_users.getName() != null) {
                    aux.get().setName(administrative_users.getName());
                }
                 if (administrative_users.getEmail() != null) {
                    aux.get().setName(administrative_users.getEmail());
                }
                 if (administrative_users.getPassword() != null) {
                    aux.get().setName(administrative_users.getPassword());
                }
                administrative_usersRepository.save(aux.get());
                return aux.get();
            } else {
                return administrative_users;
            }
        } else {
            return administrative_users;
        }
    }

    public boolean deleteAdministrative_users(int administrative_usersId) {
        Boolean aux = getAdministrative_users(administrative_usersId).map(administrative_users -> {
            administrative_usersRepository.delete(administrative_users);
            return true;
        }).orElse(false);
        return aux;
    }
}

    
   

