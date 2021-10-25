/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclo3.reto3.reto3.model;

/**
 *
 * @author Diana Romero
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cabin")
/*
 * Se crea la clase principal Cabanas, que es el producto a traves del cual se generan los ingresos.
 */
public class Cabin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*
     *@ Atributo id: Mostrara el numero de caabanas  
     */
    private Integer id;
    /*
     *@ Atributo name: Definira el nombre de cada una de las cabanas 
     */
    private String name;
    /*
     *@ Atributo brand: Mostrara la marca de la cabana 
     */
    private String brand;
    /*
     *@ Atributo rooms: Establece el numero de cuartos que tiene las cabana  
     */
    private Integer rooms;
    /*
     *@ Atributo description: Mostrara una definición corta de la cabana  
     */
    private String description;
    
    /*
     * Se crea la relacion de muchos a uno entre la entidad cabanas y la entidad categorias  
     */
    
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("cabins")
    private Category category;
    
    /*
     * Se crea la relacion de uno a muchos entre la entidad cabanas y la entidad mensages
     * Se crea el metodo lista para los mensajes
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cabin")
    @JsonIgnoreProperties({"cabin","client"})
    private List<Message> messages;
    
    /*
     * Se crea la relacion de uno a muchos entre la entidad cabanas y la entidad reservation 
     * Se crea el metodo lista para las reservaciones
     */
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cabin")
    @JsonIgnoreProperties({"cabin","client"})
    public List<Reservation> reservations;
    
    /*
     * Se crea el getId para mostrar los Id de las cabanas  
     */
    public Integer getId() {
        return id;
    }
    
     /*
     * Se crea el setId para modificar el Id de las cabanas  
     */
    
    public void setId(Integer id) {
        this.id = id;
    }
    
     /*
     * Se crea el getName para mostrar los nombres de las cabanas  
     */

    public String getName() {
        return name;
    }
    
    /*
     * Se crea el setName para modificar el nombre de las cabanas  
     */

    public void setName(String name) {
        this.name = name;
    }
    
    /*
     * Se crea el getBrand para mostrar las marcas de las cabanas  
     */
    
    public String getBrand() {
        return brand;
    }
    
     /*
     * Se crea el setBrand para modificar las marcas de cabanas  
     */

    public void setBrand(String brand) {
        this.brand = brand;
    }
    /*
     * Se crea el getRooms para mostrar el numero de cuartos que tiene cada cabana  
     */

    public Integer getRooms() {
        return rooms;
    }
    /*
     * Se crea el setRooms para modificar el numero de cuartos que tienen las cabanas  
     */
    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }
    /*
     * Se crea el getDescription para mostrar la descripción de las cabanas  
     */
    public String getDescription() {
        return description;
    }
    /*
     * Se crea el setDescription para modificar la descripcion de las cabanas  
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /*
     * Se crea el getCategory para mostrar la relacion de muchos a uno entre la entidad cabanas y la entidad categorias  
     */

    public Category getCategory() {
        return category;
    }
    
    /*
     * Se crea el setCategory para modificar la relacion de muchos a uno entre la entidad cabanas y la entidad categorias  
     */

    public void setCategory(Category category) {
        this.category = category;
    }
    
    /*
     * Se crea el getMessage para mostrar la relacion de uno a muchos entre la entidad cabanas y la entidad mensages  
     */

    public List<Message> getMessages() {
        return messages;
    }
    
    /*
     * Se crea el setMessage para modificar la relacion de uno a muchos entre la entidad cabanas y la entidad mensages  
     */

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    
    /*
     * Se crea el getReservation para mostrar la relacion de uno a  muchos entre la entidad cabanas y la entidad reservation  
     */

    public List<Reservation> getReservations() {
        return reservations;
    }
    /*
     * Se crea el setReservation para modificar la relacion de uno a muchos entre la entidad cabanas y la entidad reservation  
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
   
}
