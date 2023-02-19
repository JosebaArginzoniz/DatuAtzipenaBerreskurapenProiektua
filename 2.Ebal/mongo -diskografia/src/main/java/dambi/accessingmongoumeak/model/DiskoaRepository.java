package dambi.accessingmongoumeak.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface DiskoaRepository {
    
    List<Diskoa> findAll(); // 1, 2
    Diskoa findById(String id); //6
    Diskoa save(Diskoa person); //3
    long delete(String izena); //5
    Diskoa prezioaAldatu(Diskoa prezioaAlda); //4

}
