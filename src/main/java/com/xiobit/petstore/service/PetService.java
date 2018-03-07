package com.xiobit.petstore.service;

import com.xiobit.petstore.service.dto.PetDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing Pet.
 */
public interface PetService {

    /**
     * Save a pet.
     *
     * @param petDTO the entity to save
     * @return the persisted entity
     */
    PetDTO save(PetDTO petDTO);

    /**
     * Get all the pets.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<PetDTO> findAll(Pageable pageable);

    /**
     * Get the "id" pet.
     *
     * @param id the id of the entity
     * @return the entity
     */
    PetDTO findOne(Long id);

    /**
     * Delete the "id" pet.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
