package dambi.accessingmongoumeak.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dambi.accessingmongoumeak.model.Diskoa;
import dambi.accessingmongoumeak.model.DiskoaRepository;
import dambi.accessingmongoumeak.model.Taldea;

@RestController // This means that this class is a Controller baina @Controller bakarrik jarrita, PUT eta DELETEak ez dabiz
@RequestMapping(path = "/diskak") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired // This means to get the bean called umeaRepository
				// Which is auto-generated by Spring, we will use it to handle the data
	private DiskoaRepository diskoaRepository;

	// 1.- Disko Guztiak OK
	@GetMapping(path = "/diskoGuztienDatuak")
	public @ResponseBody Iterable<Diskoa> getAllDiskoak() {
		return diskoaRepository.findAll();
	}

	// 2.- Disko kantitatea OK
	@GetMapping(path = "/diskoKantitatea")
	public @ResponseBody int getAllDiskoKantitatea() {
		int diskoKantitatea = 0;
		for (int i = 0; i <= diskoaRepository.findAll().size(); i++) {
			diskoKantitatea++;
		}
		return diskoKantitatea -1;
	}

	// 3.- Disko barri bat sortu OK

	// @ResponseBody means the returned String is the response, not a view name
	// @RequestParam means it is a parameter from the GET or POST request
	@PostMapping(path = "/diskoBarriBat") // Map ONLY POST Requests
	public @ResponseBody Diskoa diskoBarriaSortu( 
											@RequestParam String diskoarenIzena, @RequestParam int urtea,
											@RequestParam String formatoa, @RequestParam float iraupena,
											@RequestParam float prezioa, @RequestParam String disketxea,
											@RequestParam String mediaCondition, @RequestParam List<String> abestiak,
											@RequestParam String taldearenIzena, @RequestParam String bateria, 
											@RequestParam String baxua, @RequestParam String gitarraSolista, 
											@RequestParam String gitarra, @RequestParam String ahotsa
											) {
		
		Diskoa diskoa = new Diskoa();
		diskoa.setIzena(diskoarenIzena);
		diskoa.setUrtea(urtea);
		diskoa.setFormatoa(formatoa);
		diskoa.setIraupena(iraupena);
		diskoa.setPrezioa(prezioa);		
		diskoa.setDisketxea(disketxea);							
		diskoa.setMediaCondition(mediaCondition);
		diskoa.setAbestiak(abestiak);										

		Taldea taldea = new Taldea();
		taldea.setIzena(taldearenIzena);
		taldea.setBateria(bateria);
		taldea.setBaxua(baxua);
		taldea.setGitarraSolista(gitarraSolista);
		taldea.setGitarra(gitarra);
		taldea.setAhotsa(ahotsa);

		diskoa.setTaldea(taldea);

		diskoaRepository.save(diskoa);
		return diskoa;
	}

	// 4.- Disko bati prezioa aldatu OK
	@PutMapping(value = "/prezioaAldatu")
	public Diskoa prezioaAldatu(@RequestParam String id, @RequestParam float prezioa) {
		try {
			Diskoa diskoa = new Diskoa();
			diskoa = diskoaRepository.findById(id);
			diskoa.setPrezioa(prezioa);

			diskoaRepository.prezioaAldatu(diskoa);
			return diskoa;
		} catch (Exception ex) {
			return null;
		}
	}

	// 5.- Disko bat ezabatu OK
	@DeleteMapping(path = "/delete/{diskoarenIzena}")
	public ResponseEntity<Void> deleteDisko(@PathVariable String diskoarenIzena) {
		try {
			long zenbat = diskoaRepository.delete(diskoarenIzena);
			System.out.println("Ezabatutako disko kopurua????: "+ zenbat);
			return ResponseEntity.ok().build();

		} catch (Exception ex) {
			System.out.println("Errorea " + diskoarenIzena + " diskoa ezabatzerakoan. ");
			return ResponseEntity.notFound().build();
		}
	} 

	// 6.- Diskoa topatu Id-gaz OK
	@GetMapping(path = "/diskoById/{id}")
	public @ResponseBody Diskoa getDiskoById(@RequestParam String id) {
		return diskoaRepository.findById(id);
	}

	// 7.- Disko baten formatua aldatu OK
	@PutMapping(value = "/formatoaAldatu")
	public Diskoa formatoaAldatu(@RequestParam String id, @RequestParam String formatoa) {
		try {
			Diskoa diskoa = diskoaRepository.findById(id);
			diskoa.setFormatoa(formatoa);

			diskoaRepository.formatoaAldatu(diskoa);
			return diskoa;
			
		} catch (Exception ex) {
			return null;
		}
	}

	// 8.- Talde bakoitzaren diskoak OK
	@GetMapping(path = "/taldeBatenDiskoak/{taldea}")
	public @ResponseBody Iterable<Diskoa> findByTaldea(@Valid @RequestParam String taldearenIzena) {
		return diskoaRepository.findByTaldea(taldearenIzena);
	}

	// 9.- Disko bakoitzaren taldeak eta partaideak OK
	@GetMapping(path = "/diskoenTaldePartaideak")
	public @ResponseBody Iterable<Taldea> getTaldeak() {
		return diskoaRepository.getTaldeak();
	}

	// 11.- Prezio baten baino garestiagoa OK
	@GetMapping(path = "/xBainoGarestiagoa")
    public @ResponseBody Iterable<Diskoa> xBainoGarestiagoa(float prezioa) {
        return diskoaRepository.xBainoGarestiagoa(prezioa);
    }

}




