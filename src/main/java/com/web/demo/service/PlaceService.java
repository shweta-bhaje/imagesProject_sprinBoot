/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.demo.service;

import com.web.demo.repository.PlaceRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chira
 */
@Service
public class PlaceService {
    @Autowired
    private PlaceRepositry repository;
    
}
