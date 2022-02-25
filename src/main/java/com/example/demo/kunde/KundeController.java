package com.example.demo.kunde;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class KundeController {
	
	private final KundeService kundeService;

	@Autowired
	public KundeController(KundeService kundeservice) {		
		this.kundeService = kundeservice;
	}
	
	
	

	@GetMapping("/kunden")
	public List<Kunde> getKunden() {
		return kundeService.getKunden();
	}
	
	@PostMapping("/kundenverwaltung/registrierung")
	public void registriereNeuenKunden(@RequestBody Kunde kunde) {
		kundeService.addNewKunde(kunde);
	}
	
	@DeleteMapping(path = "kundenverwaltung/entfernen/kundeId={kundeId}")
	public void entferneKunden(@PathVariable("kundeId") int kundId) {
		kundeService.deleteKunde(kundId);
	}
	
	@PutMapping(path = "kundenverwaltung/aktuallisierung/kundeId={kundeId}")
	public void aktualisiereKunde(
								  @PathVariable("kundeId") int kundeId,
								  @RequestParam(required = false) String lastName,
								  @RequestParam(required = false) String email) {
		
		kundeService.updateKunde(kundeId, lastName, email);
	
		
	}
}
