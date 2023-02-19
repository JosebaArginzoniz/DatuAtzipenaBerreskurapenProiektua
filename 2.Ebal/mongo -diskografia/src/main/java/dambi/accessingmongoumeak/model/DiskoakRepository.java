package dambi.accessingmongoumeak.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface DiskoakRepository {
    
    List<Diskoak> findAll();
    Diskoak findById(String id);
    
    //Todos los metodos que usamos en el controller

}
