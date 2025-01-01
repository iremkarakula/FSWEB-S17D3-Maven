package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.validations.ZooValidations;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/koalas")
public class KoalaController {

    private Map<Integer, Koala> koalas;

    @PostConstruct
    public void init(){
        koalas = new HashMap<>();
    }

    @GetMapping
    public List<Koala> findAll(){
        return koalas.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Koala getById(@PathVariable("id") Integer id){
        ZooValidations.checkIdIsValid(id);
        return koalas.get(id);
    }

    @PostMapping
    public Koala save(@RequestBody Koala koala){
        ZooValidations.checkIdIsValid(koala.getId());
        koalas.put(koala.getId(), koala);
        return koalas.get(koala.getId());
    }

    @PutMapping("/{id}")
    public Koala update(@PathVariable("id") Integer id,@RequestBody Koala koala){
        ZooValidations.checkIdIsValid(id);

        koala.setId(id);
        koalas.put(id, koala);
        return koalas.get(id);
    }

    @DeleteMapping("/{id}")
    public Koala delete(@PathVariable("id") Integer id){
        ZooValidations.checkIdIsValid(id);

        return koalas.remove(id);
    }

}
