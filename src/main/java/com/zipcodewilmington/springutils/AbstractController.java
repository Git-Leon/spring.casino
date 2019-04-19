package com.zipcodewilmington.springutils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class AbstractController<EntityType, IdType> implements ControllerInterface<EntityType, IdType> {
    protected ServiceInterface<EntityType, IdType> service;

    public AbstractController(ServiceInterface<EntityType, IdType> service) {
        this.service = service;
    }

    @Override
    @PostMapping("/new")
    public ResponseEntity<EntityType> create() {
        return new ResponseEntity<>(service.create(), HttpStatus.CREATED);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<EntityType> create(EntityType entity) {
        return new ResponseEntity<>(service.create(entity), HttpStatus.CREATED);
    }
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<EntityType> read(IdType id) {
        return new ResponseEntity<>(service.read(id), HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<EntityType> update(IdType id, EntityType entity) {
        return new ResponseEntity<>(service.update(id, entity), HttpStatus.OK);
    }


    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<EntityType> delete(IdType id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}

