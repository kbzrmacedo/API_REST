package com.matheus.apirest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.apirest.model.Model;
 
@RestController
public class ControllerResource {
 
  private Map<Integer, Model> Models;
 
  public ControllerResource() {
    Models = new HashMap<Integer, Model>();
 
    Model c1 = new Model(1, "Workshop Rest", "24hs");
    Model c2 = new Model(2, "Workshop Spring MVC", "24hs");
    Model c3 = new Model(3, "Desenvolvimento Web com JSF 2", "60hs");
 
    Models.put(1, c1);
    Models.put(2, c2);
    Models.put(3, c3);
  }
 
  @RequestMapping(value = "/models", method = RequestMethod.GET)
  public ResponseEntity<List<Model>> listar() {
    return new ResponseEntity<List<Model>>(new ArrayList<Model>(Models.values()), HttpStatus.OK);
  }
  
  @RequestMapping(value = "/models/{id}", method = RequestMethod.GET)
  public ResponseEntity<Model> buscar(@PathVariable("id") Integer id) {
    Model model = Models.get(id);
   
    if (model == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
   
    return new ResponseEntity<Model>(model, HttpStatus.OK);
  }
  
  @RequestMapping(value = "/models/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<?> deletar(@PathVariable("id") int id) {
    Model model = Models.remove(id);
   
    if (model == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
   
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
 
}