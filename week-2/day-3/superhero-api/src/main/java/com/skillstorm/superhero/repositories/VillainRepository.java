package com.skillstorm.superhero.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.superhero.models.Villain;

import jakarta.transaction.Transactional;

@Repository
public interface VillainRepository extends CrudRepository<Villain, Integer> {
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM villain WHERE villain_id = ?1;", nativeQuery = true)
	void forceDelete(int villainId);

}
