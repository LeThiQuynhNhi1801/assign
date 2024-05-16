package com.example.Assgin.service;

import com.example.Assgin.dto.AssignRequest;

public interface AssignService {

    void assign(AssignRequest assignRequest, Integer idUser, Integer idTeam);
}
