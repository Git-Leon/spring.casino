package com.zipcodewilmington.springutils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AbstractController<EntityType, IdType> implements ControllerInterface<EntityType, IdType> {
    protected ServiceInterface<EntityType, IdType> service;

    public AbstractController(ServiceInterface<EntityType, IdType> serviceInterface) {
        this.service = serviceInterface;
    }

    @Override
    public ResponseEntity<EntityType> create(EntityType entity) {
        return new ResponseEntity<>(service.create(entity), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<EntityType> read(IdType id) {
        return new ResponseEntity<>(service.read(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EntityType> update(IdType id, EntityType entity) {
        return new ResponseEntity<>(service.update(id, entity), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EntityType> delete(IdType id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
