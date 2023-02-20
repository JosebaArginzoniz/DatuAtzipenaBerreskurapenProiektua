package dambi.accessingmongoumeak.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class MongoDBDiskoakRepository implements DiskoaRepository {

    @Autowired
    private MongoClient client;
    private MongoCollection<Diskoa> diskoakCollection;

    @PostConstruct
    void init() {
        diskoakCollection = client.getDatabase("Diskografia").getCollection("Diskoak",
                Diskoa.class);
    }

    // 1 Disko guztiak OK
    @Override
    public List<Diskoa> findAll() {
        return diskoakCollection.find().into(new ArrayList<>());
    }

    // //Taldeak eta taldekideak guztiak
    // @Override
    // public Iterable<Taldea> getTaldeak() {
    //     ArrayList <Diskoa> diskoGuztiak = diskoakCollection.find().into(new ArrayList<>());
    //     ArrayList <Taldea> taldeak = new ArrayList<>();
    //     for (Diskoa diskoa : diskoGuztiak ) {
    //         if(taldeak.contains(diskoa.getTaldea()) ){

    //         }else{
    //             taldeak.add(diskoa.getTaldea());
    //         }
    //     }
    //     return taldeak; 
    // }

    // 3 Disko bat gehitu NON OK
    @Override
    public Diskoa save(Diskoa diskoa) {
        ArrayList <Diskoa> diskoGuztiak = diskoakCollection.find().into(new ArrayList<>());
        Diskoa diskoBarria = diskoakCollection.find().first();
        diskoa.setId(diskoBarria.getId() + diskoGuztiak.size());
        diskoakCollection.insertOne(diskoa);

        return diskoa; 
    }

    // 4 Prezioa Aldatu NON OK
    @Override
    public Diskoa prezioaAldatu(Diskoa diskoa) {
        
        return diskoa;

    }

    // 5 Disko bat ezabatu OK
    @Override
    public long delete(String izena) {
        return diskoakCollection.deleteMany(eq("izena", izena)).getDeletedCount();
    }

    // 6 Disko bat topatu Id-gaz OK
    @Override
    public Diskoa findById(String id) {
        return diskoakCollection.find(eq("_id", new Integer (id))).first();        
    }
    
}
