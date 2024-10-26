/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.demo.controller;

import com.web.demo.entity.Place;
import com.web.demo.repository.PlaceRepositry;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author chira
 */


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/place")
public class PlaceCotroller {
    @Autowired
    private PlaceRepositry repository;
    @PostMapping
    public ResponseEntity<Place> saveRecord(@RequestParam String placeName,
            @RequestParam String discription,
            @RequestPart("file")MultipartFile file)throws IOException
    {
        Place obj = Place.builder().placeName(placeName).
                discription(discription).picture(file.getBytes()).build();
        repository.save(obj);
        return ResponseEntity.ok(obj);
    }

    /**
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Place>> getAll()
    {
        List<Place> list = repository.findAll();
        return ResponseEntity.ok(list);
    }
        @GetMapping("/{id}")
        public Place findById(@PathVariable long id)
        {
        Optional<Place> op = repository.findById(id);
      if (op.isPresent())
      {
            Place get = op.get();
            return get;
      }
      return null;
        }
        
        @DeleteMapping("/{id}")
        public Place deleteById(@PathVariable long id)
        {
        Place find = findById(id);
        if(find!=null)
        {
            repository.deleteById(id);
        }
        return find;
        }
}
