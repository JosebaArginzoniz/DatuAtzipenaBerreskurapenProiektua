package dambi.accessingmongodiskografia.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface DiskografiaRepository {
    List<Diskoa> findAll();

} 
