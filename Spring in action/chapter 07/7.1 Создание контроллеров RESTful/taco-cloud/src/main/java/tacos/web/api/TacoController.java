package tacos.web.api;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tacos.data.repository.TacoRepository;
import tacos.model.Taco;
import tacos.model.TacoOrder;

@RestController
@RequestMapping(path="/api/tacos", produces="application/json")
@CrossOrigin(origins={"http://tacocloud:8080", "http://tacocloud.com"})
public class TacoController {
	private TacoRepository tacoRepo;

	public TacoController(TacoRepository tacoRepo) {
		this.tacoRepo = tacoRepo;
	}
	
	@GetMapping(params="recent")
	public List<Taco> recentTacos(){
		// Нам нужна только первая страница (0) с 12 результатами, отсортированная по дате создания в порядке убывания
		PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
		return tacoRepo.findAll(page).getContent();
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Taco> tacoById(@PathVariable Long id) {
		Optional<Taco> found = tacoRepo.findById(id);
		if(found.isPresent()) {
			return new ResponseEntity<>(found.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Taco postTaco(@RequestBody Taco taco) {
		return tacoRepo.save(taco);
	}	
}