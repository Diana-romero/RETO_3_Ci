/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclo3.reto3.reto3.service;

import ciclo3.reto3.reto3.repositor.CabinRepository;
import ciclo3.reto3.reto3.model.Cabin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Diana Romero
 */

@Service
public class CabinService {
    
    @Autowired
    private CabinRepository cabinRepository;
    
    public List<Cabin> getAll(){
        return cabinRepository .getAll();
        
    }
    public Optional<Cabin> getCabin(int idCabin){
        return cabinRepository.getCabin(idCabin);
    }
    public Cabin save(Cabin cabin){
        if(cabin.getId()==null){
            return cabinRepository.save(cabin);
        }else{
            Optional<Cabin> caux=cabinRepository.getCabin(cabin.getId());
            if(caux.isEmpty()){
                return cabinRepository.save(cabin);
            }else{
                return cabin;
            }
        }
    }
     public Cabin update(Cabin cabin){
        if(cabin.getId()!=null){
            Optional<Cabin> caux=cabinRepository.getCabin(cabin.getId());
            if(!caux.isEmpty()){
                 if(cabin.getName()!=null){
                    caux.get().setName(cabin.getName());
                }
                if(cabin.getBrand()!=null){
                    caux.get().setBrand(cabin.getBrand());
                }
                if(cabin.getRooms()!=null){
                    caux.get().setRooms(cabin.getRooms());
                }
                if(cabin.getDescription()!=null){
                    caux.get().setDescription(cabin.getDescription());
                }
                if(cabin.getCategory()!=null){
                    caux.get().setCategory(cabin.getCategory());
                }
                cabinRepository.save(caux.get());
                return caux.get();
            }else{
                return cabin;
            }
        }else{
            return cabin;
        }
    }


    public boolean deleteCabin(int cabinId) {
        Boolean caux = getCabin(cabinId).map(cabin -> {
            cabinRepository.delete(cabin);
            return true;
        }).orElse(false);
        return caux;
    }
           
}
