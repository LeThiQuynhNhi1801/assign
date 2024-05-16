package com.example.Assgin.service.imp;

import com.example.Assgin.config.WebClientConfig;
import com.example.Assgin.dto.AssignItemRequest;
import com.example.Assgin.dto.AssignRequest;
import com.example.Assgin.dto.AssignmentReponse;
import com.example.Assgin.dto.AssignmentRequest;
import com.example.Assgin.entity.Assign;
import com.example.Assgin.repository.AssignRepository;
import com.example.Assgin.service.AssignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.ArrayList;
import java.util.List;
@Service
public class AssignServiceImp implements AssignService {
    @Autowired
    private AssignRepository assignRepository;

    private final WebClientConfig webClientConfig;

    public AssignServiceImp(WebClientConfig webClientConfig) {
        this.webClientConfig = webClientConfig;
    }

    @Override
    public void assign(AssignRequest assignRequest, Integer idUser, Integer idTeam) {
        List<Assign> assigns = new ArrayList<>();
        for (int i = 0; i < assignRequest.getListAssign().size(); i++) {
            AssignmentRequest assignmentRequest = new AssignmentRequest(assignRequest.getListAssign().get(i).getName(),assignRequest.getListAssign().get(i).getDeadline(),assignRequest.getListAssign().get(i).getDescription(),idUser);
            Integer a = webClientConfig.webClient().post()
                    .uri("http://localhost:8081/apiv1/assignment")
                    .body(BodyInserters.fromValue(assignRequest.getListAssign().get(i)))
                    .retrieve()
                    .bodyToMono(AssignmentReponse.class)
                    .map(response -> Integer.valueOf(response.getAssignmentId()))
                    .block();
            AssignItemRequest assignment = assignRequest.getListAssign().get(i); // Get the current assignment
            for (int j = 0; j < assignment.getListUser().size(); j++) {
                Assign assign = new Assign(null,a, assignment.getListUser().get(j),assignment.getDeadline(), idTeam);
                assigns.add(assign);
            }
        }
        assignRepository.saveAll(assigns);
    }
}
