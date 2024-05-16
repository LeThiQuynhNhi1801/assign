package com.example.Assgin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignRequest {
    private List<AssignItemRequest> listAssign;
}
