package com.ramper.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class RandomGeneratorServiceImpl implements RandomGeneratorService {

    final static int MAXIMUM_FACTOR = 99;
    final static int MINIMUM_FACTOR = 11;

    @Override
    public int generateRandomFactor() {
	return new Random().nextInt((MAXIMUM_FACTOR - MINIMUM_FACTOR) + 1) + MINIMUM_FACTOR;
    }

}
