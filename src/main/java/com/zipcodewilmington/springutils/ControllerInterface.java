package com.zipcodewilmington.springutils;

import org.springframework.http.ResponseEntity;

public interface ControllerInterface<EntityType, IdType> {
    ResponseEntity<EntityType> create(EntityType entity);

    ResponseEntity<EntityType> read(IdType id);

    ResponseEntity<EntityType> update(IdType id, EntityType entity);

    ResponseEntity<EntityType> delete(IdType id);
}
