package com.example.demo.kunde;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface KundeRepository extends JpaRepository<Kunde, Integer> {
	
	@Query("SELECT k FROM Kunde k WHERE k.email = ?1") // Kunde bezieht sich auf die Klasse (Entity), nicht direkt auf die Tabelle der DB
	Optional<Kunde> findKundeByEmail(String email);
	
	@Query("DELETE FROM Kunde WHERE id = ?1")
	Optional<Kunde> findKundeById(int id);
	
	

}
