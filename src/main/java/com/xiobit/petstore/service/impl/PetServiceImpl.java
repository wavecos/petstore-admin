package com.xiobit.petstore.service.impl;

import com.xiobit.petstore.domain.User;
import com.xiobit.petstore.repository.UserRepository;
import com.xiobit.petstore.service.PetService;
import com.xiobit.petstore.domain.Pet;
import com.xiobit.petstore.repository.PetRepository;
import com.xiobit.petstore.service.dto.PetDTO;
import com.xiobit.petstore.service.mapper.PetMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing Pet.
 */
@Service
@Transactional
public class PetServiceImpl implements PetService {

    private final Logger log = LoggerFactory.getLogger(PetServiceImpl.class);

    private final PetRepository petRepository;

    private final UserRepository userRepository;

    private final PetMapper petMapper;

    public PetServiceImpl(PetRepository petRepository, PetMapper petMapper, UserRepository userRepository) {
        this.petRepository = petRepository;
        this.petMapper = petMapper;
        this.userRepository = userRepository;
    }

    /**
     * Save a pet.
     *
     * @param petDTO the entity to createPet
     * @return the persisted entity
     */
    @Override
    @Transactional
    public PetDTO createPet(PetDTO petDTO) {
        log.debug("Request to createPet Pet : {}", petDTO);
        Pet pet = petMapper.toEntity(petDTO);
        pet = petRepository.save(pet);
        return petMapper.toDto(pet);
    }

    /**
     * Get all the pets.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<PetDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Pets");
        return petRepository.findAll(pageable)
            .map(petMapper::toDto);
    }

    /**
     * Get one pet by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public PetDTO findOne(Long id) {
        log.debug("Request to get Pet : {}", id);
        Pet pet = petRepository.findOne(id);
        return petMapper.toDto(pet);
    }

    /**
     * Delete the pet by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Pet : {}", id);
        petRepository.delete(id);
    }

    @Override
    public void registerHistorial(PetDTO petDTO) {





    }
}
