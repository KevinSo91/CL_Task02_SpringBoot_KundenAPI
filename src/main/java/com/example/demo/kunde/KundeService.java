package com.example.demo.kunde;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service  // = Component (Service für bessere Semantik)
public class KundeService {
	
	private final KundeRepository kundeRepository ;
	
	
	
//	public KundeService() {		
//	}
	
	@Autowired
	public KundeService(KundeRepository kundeRepository) {
		this.kundeRepository = kundeRepository;
	}

	
	// Methode zum Anzeigen aller Kunden
	public List<Kunde> getKunden() {
		return kundeRepository.findAll();
	}

	// Methode zum hinzufügen eines Kunden
	public void addNewKunde(Kunde kunde) {
		
		Optional<Kunde> kundeOptional = kundeRepository.findKundeByEmail(kunde.getEmail());
		
		if(kundeOptional.isPresent()) {
			throw new IllegalStateException("Kunde with this email already exists");
		}
		else {			
			kundeRepository.save(kunde);
		}				
	}
	
	// Methode zum löschen eines Kunden
	public void deleteKunde(int kundeId) {
		
		// Prüfe, ob Kunde existiert
		if (kundeRepository.existsById(kundeId)){
			kundeRepository.deleteById(kundeId);
		}
		else {
			throw new IllegalStateException("kunde with id " + kundeId + " does not exist");
		}		
	}

	@Transactional
	public void updateKunde(int kundeId, String lastName, String email) {		
		
		// Prüfe, ob Kunde existiert		
		Kunde kunde = kundeRepository.findById(kundeId).orElseThrow(
						() -> new IllegalStateException("kunde with id " + kundeId + " does not exist"));
		
		if(lastName != null && lastName.length() > 0 && !Objects.equals(kunde.getLastName(), lastName)) {
			kunde.setLastName(lastName);
		}
		
		if(email != null && email.length() > 0 && !Objects.equals(kunde.getEmail(), email)) {
			Optional<Kunde> kundeOptional = kundeRepository.findKundeByEmail(email);
			
			if(kundeOptional.isPresent()) {
				throw new IllegalStateException("Kunde with this email already exists");
			}
			kunde.setEmail(email);
		}		
	}
	
	
//	// Methode zum löschen eines Kunden (Exception Handling)
//	public void deleteKundeById(int id) {
//		
//		try {
//			int idInt;
//			idInt = Integer.parseInt(id);
//			
//			Optional<Kunde> kundeOptional = kundeRepository.findKundeById(idInt);
//			
//			if(kundeOptional.isPresent()) {
//				throw new IllegalStateException("kunde does not exist");
//			}
//			else {			
//				kundeRepository.deleteById(idInt);;
//			}
//			
//			kundeRepository.deleteById(idInt);
//		}catch (NumberFormatException e){
//			throw new IllegalStateException("no valid id");
//		}
//		
//	}
	
	
	
	
	
	
	
}
