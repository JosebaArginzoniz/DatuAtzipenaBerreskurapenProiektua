package dambi.accessingmongodiskografia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dambi.accessingmongodiskografia.model.Diskoa;
import dambi.accessingmongodiskografia.model.DiskoaRepository;
import dambi.accessingmongodiskografia.model.Taldea;

@RestController // This means that this class is a Controller baina @Controller bakarrik jarrita, PUT eta DELETEak ez dabiz
@RequestMapping(path = "/diskografia") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired // This means to get the bean called diskoaRepository
				// Which is auto-generated by Spring, we will use it to handle the data

	private DiskoaRepository diskografiaRepository;

	@GetMapping(path = "/diskoGuztiak")
	public @ResponseBody Iterable<Diskoa> getAllDiskoak() {
		return diskografiaRepository.findAll();
	}

	@GetMapping(path = "/taldeak")
	public @ResponseBody Iterable<Taldea> getTaldeak() {
		return diskografiaRepository.getTaldeak();
	
	}
}
