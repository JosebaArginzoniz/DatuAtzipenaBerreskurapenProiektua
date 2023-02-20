package dambi.accessingmongoumeak.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface DiskoaRepository {
    
    List<Diskoa> findAll(); //1, 2
    Diskoa findById(String id); //6
    Diskoa save(Diskoa disko); //3
    long delete(String izena); //5
    Diskoa prezioaAldatu(Diskoa diskoa); //4
    Diskoa formatoaAldatu(Diskoa diskoa); //7
    List<Diskoa> findByTaldea(String taldea); //8
    Iterable<Taldea> getTaldeak(); //9
    List<Diskoa> xBainoGarestiagoa(Float prezioa); //11
}
