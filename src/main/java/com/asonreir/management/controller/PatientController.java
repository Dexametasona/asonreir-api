package com.asonreir.management.controller;

import com.asonreir.management.model.dto.request.PatientReq;
import com.asonreir.management.service.interfaces.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.base}/patients")
public class PatientController {
  private final PatientService patientService;

  @PostMapping
  public ResponseEntity<?> create(@RequestBody PatientReq patientReq){
    return null;
  }
}
