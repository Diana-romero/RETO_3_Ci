/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclo3.reto3.reto3.repositor;

import ciclo3.reto3.reto3.model.Cabin;
import ciclo3.reto3.reto3.repository.crud.CabinCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Diana Romero
 */

@Repository
public class CabinRepository {
    
    @Autowired
    private CabinCrudRepository cabinCrudRepository;
    
    public List<Cabin> getAll(){
       return (List<Cabin>) cabinCrudRepository.findAll();       
    }
    
    public Optional<Cabin> getCabin (int id){
        return cabinCrudRepository.findById(id);
    }
    
    public Cabin save (Cabin cabin){
        return cabinCrudRepository.save(cabin);
    }
     public void delete(Cabin cabin){
        cabinCrudRepository.delete(cabin);
    }
    
}
