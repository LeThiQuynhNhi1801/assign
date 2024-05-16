package com.example.Assgin.controller;

import com.example.Assgin.dto.AssignRequest;
import com.example.Assgin.service.AssignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assign")
@CrossOrigin("*")
public class AssignController {
    @Autowired
    private AssignService assignService;

    @PostMapping("/addAssign/{idUser}")
    public ResponseEntity<?> addAssign(@RequestParam("idTeam") Integer idTeam, @RequestBody AssignRequest assignRequest, @PathVariable("idUser") Integer idUser){
        assignService.assign(assignRequest,idUser, idTeam);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
