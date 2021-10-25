/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclo3.reto3.reto3.service;


import ciclo3.reto3.reto3.model.Category;
import ciclo3.reto3.reto3.repositor.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diana Romero
 */
@Service
public class CategoryService {
    @Autowired
     private CategoryRepository categoryRepository;
     
     public List<Category> getAll(){
        return categoryRepository.getAll();
    }
     public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category save(Category categorys){
        if(categorys.getId()==null){
            return categoryRepository.save(categorys);
        }else{
            Optional<Category> cataux=categoryRepository.getCategory(categorys.getId());
            if(cataux.isEmpty()){
                return categoryRepository.save(categorys);
            }else{
                return categorys;
            }
        }
    }
    
     public Category update(Category categorys){
        if(categorys.getId()!=null){
            Optional<Category>cataux=categoryRepository.getCategory(categorys.getId());
            if(!cataux.isEmpty()){
                if(categorys.getDescription()!=null){
                    cataux.get().setDescription(categorys.getDescription());
                }
                if(categorys.getName()!=null){
                    cataux.get().setName(categorys.getName());
                }
                return categoryRepository.save(cataux.get());
            }
        }
        return categorys;
    }
    public boolean deleteCategory(int categorysId){
        Boolean cataux=getCategory(categorysId).map(categorys -> {
            categoryRepository.delete(categorys);
            return true;
        }).orElse(false);
        return cataux;
    }
}
