package dambi.accessingmongoumeak.controller;

import java.util.List;

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

	// 1 Disko Guztiak OK
	@GetMapping(path = "/diskoGuztiak")
	public @ResponseBody Iterable<Diskoa> getAllDiskoak() {
		return diskoaRepository.findAll();
	}

	// 2 Disko kantitatea OK
	@GetMapping(path = "/diskoKantitatea")
	public @ResponseBody int getAllDiskoKantitatea() {
		int diskoKantitatea = 0;
		for (int i = 0; i <= diskoaRepository.findAll().size(); i++) {
			diskoKantitatea++;
		}
		return diskoKantitatea -1;
	}

	// 3 Disko barri bat NON OK

	// @ResponseBody means the returned String is the response, not a view name
	// @RequestParam means it is a parameter from the GET or POST request
	@PostMapping(path = "/diskoBarriBat") // Map ONLY POST Requests
	public @ResponseBody String addNewDisko( @RequestParam Taldea taldea,
											@RequestParam String izena,
											@RequestParam int urtea,
											@RequestParam String formatoa,
											@RequestParam float iraupena,
											@RequestParam float prezioa,
											@RequestParam String disketxea,
											@RequestParam String mediaCondition,
											@RequestParam List<String> abestiak
											) {
		
		Diskoa d = new Diskoa();
		d.setTaldea(taldea);
		d.setIzena(izena);
		d.setUrtea(urtea);
		d.setFormatoa(formatoa);
		d.setIraupena(iraupena);
		d.setPrezioa(prezioa);		
		d.setDisketxea(disketxea);							
		d.setMediaCondition(mediaCondition);
		d.setAbestiak(abestiak);										
		diskoaRepository.save(d);
		return "Saved";
	}


	// 4 Disko bati prezioa aldatu NON OK

	@PutMapping(value = "/prezioaAldatu")
	public @ResponseBody Diskoa prezioaAldatu(@RequestParam String id, @RequestParam float prezioa) {
		try {
			Diskoa diskoa = new Diskoa();
			diskoa = diskoaRepository.findById(id);
			diskoa.setId(diskoa.getId());
			diskoa.setPrezioa(prezioa);

			diskoaRepository.prezioaAldatu(diskoa);
			return diskoa;
		} catch (Exception ex) {
			return null;
		}
	}

	// 5 Disko bat ezabatu OK
	@DeleteMapping(path = "/delete/{diskoarenIzena}")
	public ResponseEntity<Void> deleteDisko(@PathVariable String diskoarenIzena) {
		try {
			long zenbat = diskoaRepository.delete(diskoarenIzena);
			System.out.println("Ezabatutako disko kopurua🔆: "+ zenbat);
			return ResponseEntity.ok().build();

		} catch (Exception ex) {
			System.out.println("Errorea " + diskoarenIzena + " diskoa ezabatzerakoan. ");
			return ResponseEntity.notFound().build();
		}
	} 

	// 6 Diskoa topatu Id-gaz OK
	@GetMapping(path = "/diskoById/{id}")
	public @ResponseBody Diskoa getDiskoById(@RequestParam String id) {
		return diskoaRepository.findById(id);
	}

	// 7 Partaide barria

	
}



