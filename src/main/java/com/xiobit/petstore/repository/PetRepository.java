package com.xiobit.petstore.repository;

import com.xiobit.petstore.domain.Pet;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Pet entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    Pet findOneByName(String name);

    List<Pet> findAllByName(String name);

}
