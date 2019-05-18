package com.ramper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramper.domain.Multiplication;
import com.ramper.service.MultiplicationService;

@RestController
@RequestMapping("/multiplications")
public class MultiplicationController {

    private final MultiplicationService multiplicationService;

    @Autowired
    public MultiplicationController(final MultiplicationService multiplicationService) {
	this.multiplicationService = multiplicationService;
    }

    @GetMapping("/random")
    Multiplication getRandomMultiplication() {
	return multiplicationService.createRandomMultiplication();
    }
}
