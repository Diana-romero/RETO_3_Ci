/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ciclo3.reto3.reto3.repository.crud;

import ciclo3.reto3.reto3.model.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Diana Romero
 */
public interface MessageCrudRepository extends CrudRepository<Message, Integer>{
    
}
