package ciclo3.reto3.reto3.web;

import ciclo3.reto3.reto3.model.Administrative_users;
import ciclo3.reto3.reto3.service.Administrative_usersService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Diana Romero
 */
@RestController
@RequestMapping("/api/Administrative_usersWeb")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class Administrative_usersWeb {
     @Autowired
    private Administrative_usersService administrative_usersService;
    
    @GetMapping("/all")
    public List<Administrative_users> getAdministrative_users(){
        return administrative_usersService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Administrative_users> getAdministrative_users (@PathVariable("id") int idAdministrative_users){
        return Administrative_usersService.getAdministrative_users(idAdministrative_users);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Administrative_users save(@RequestBody Administrative_users administrative_users){
        return administrative_usersService.save(administrative_users);
        
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Administrative_users update(@RequestBody Administrative_users administrative_users) {
        return administrative_usersService.update(administrative_users);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int idAdministrative_users) {
        return administrative_usersService.deleteAdministrative_users(idAdministrative_users);
    }
}
  
