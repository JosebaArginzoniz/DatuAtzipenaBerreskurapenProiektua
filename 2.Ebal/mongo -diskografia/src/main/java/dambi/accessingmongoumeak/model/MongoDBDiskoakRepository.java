package dambi.accessingmongoumeak.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

@Repository
public class MongoDBDiskoakRepository implements DiskoakRepository {

    @Autowired
    private MongoClient client;
    private MongoCollection<Diskoak> diskoakCollection;

    @PostConstruct
    void init() {
        diskoakCollection = client.getDatabase("Diskografia").getCollection("Diskoak",
                Diskoak.class);
    }

    // buscar todos los estadios
    @Override
    public List<Diskoak> findAll() {
        return diskoakCollection.find().into(new ArrayList<>());
    }

    @Override
    public Diskoak findById(String id) {
        return diskoakCollection.find(Filters.eq("_id", id)).first();
    }

    

}