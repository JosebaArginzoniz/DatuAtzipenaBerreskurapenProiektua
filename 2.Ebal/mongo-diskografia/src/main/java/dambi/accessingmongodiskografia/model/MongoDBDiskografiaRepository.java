package dambi.accessingmongodiskografia.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

@Repository
public class MongoDBDiskografiaRepository implements DiskoaRepository {

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
                                                                           .readPreference(ReadPreference.primary())
                                                                           .readConcern(ReadConcern.MAJORITY)
                                                                           .writeConcern(WriteConcern.MAJORITY)
                                                                           .build();
                                                                           
    @Autowired
    private MongoClient client;
    private MongoCollection<Diskoa> diskoaCollection;

    @PostConstruct
    void init() {
        diskoaCollection = client.getDatabase("diskografia").getCollection("diskoak", Diskoa.class);
    }

    @Override
    public List<Diskoa> findAll() {
        return diskoaCollection.find().into(new ArrayList<>());
    }

    @Override
    public Iterable<Taldea> getTaldeak() {
        ArrayList <Diskoa> diskoGuztiak = diskoaCollection.find().into(new ArrayList<>());
        ArrayList <Taldea> taldeak = new ArrayList<>();
        for (Diskoa diskoa : diskoGuztiak ) {
            diskoa.getTaldea();
            if(taldeak.contains(diskoa.getTaldea())){

            }else{
                taldeak.add(diskoa.getTaldea());
            }
        }
        return taldeak; 
    }

}
