package com.codegym.repository;

public interface IDeclarationRepository {
    int[] getYearOfBirth();

    String[] getGender();

    String[] getNationality();

    String[] getTravelInformation();

    int[] getDepartureDay();

    int[] getDepartureMonth();

    int[] getDepartureYear();

    int[] getEndDay();

    int[] getEndMonth();

    int[] getEndYear();
}
