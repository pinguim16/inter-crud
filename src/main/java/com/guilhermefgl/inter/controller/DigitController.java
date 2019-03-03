package com.guilhermefgl.inter.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilhermefgl.inter.controller.dto.DigitDto;
import com.guilhermefgl.inter.service.UniqueDigitService;

@RestController
@RequestMapping("/api/digitoUnico")
public class DigitController {

	@Autowired
	UniqueDigitService digitService;

	@PostMapping
	public ResponseEntity<Object> create(@Valid @RequestBody DigitDto digitDto) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(digitDto.getK() == null ? digitService.uniqueDigit(digitDto.getN())
						: digitService.uniqueDigit(digitDto.getK(), digitDto.getN()));
	}

}
