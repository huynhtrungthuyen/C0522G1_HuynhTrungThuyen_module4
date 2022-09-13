package com.codegym.service.impl;

import com.codegym.repository.IDeclarationRepository;
import com.codegym.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeclarationService implements IDeclarationService {
    @Autowired
    private IDeclarationRepository iDeclarationRepository;

    @Override
    public int[] getYearOfBirth() {
        return iDeclarationRepository.getYearOfBirth();
    }

    @Override
    public String[] getGender() {
        return iDeclarationRepository.getGender();
    }

    @Override
    public String[] getNationality() {
        return iDeclarationRepository.getNationality();
    }

    @Override
    public String[] getTravelInformation() {
        return iDeclarationRepository.getTravelInformation();
    }

    @Override
    public int[] getDepartureDay() {
        return iDeclarationRepository.getDepartureDay();
    }

    @Override
    public int[] getDepartureMonth() {
        return iDeclarationRepository.getDepartureMonth();
    }

    @Override
    public int[] getDepartureYear() {
        return iDeclarationRepository.getDepartureYear();
    }

    @Override
    public int[] getEndDay() {
        return iDeclarationRepository.getEndDay();
    }

    @Override
    public int[] getEndMonth() {
        return iDeclarationRepository.getEndMonth();
    }

    @Override
    public int[] getEndYear() {
        return iDeclarationRepository.getEndYear();
    }
}
