package com.codegym.repository.impl;

import com.codegym.repository.IDeclarationRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DeclarationRepository implements IDeclarationRepository {

    @Override
    public int[] getYearOfBirth() {
        return new int[]{1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004};
    }

    @Override
    public String[] getGender() {
        return new String[]{"Nam", "Nu", "LGBT"};
    }

    @Override
    public String[] getNationality() {
        return new String[]{"Viet Nam", "Trung Quoc", "Nhat Ban", "Lao", "Thai Lan", "Han Quoc", "An Do", "Nga"};
    }

    @Override
    public String[] getTravelInformation() {
        return new String[]{"May bay", "Tau thuyen", "O to", "Khac"};
    }

    @Override
    public int[] getDepartureDay() {
        return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
                27, 28, 29, 30, 31};
    }

    @Override
    public int[] getDepartureMonth() {
        return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    }

    @Override
    public int[] getDepartureYear() {
        return new int[]{2018, 2019, 2020, 2021, 2022};
    }

    @Override
    public int[] getEndDay() {
        return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
                27, 28, 29, 30, 31};
    }

    @Override
    public int[] getEndMonth() {
        return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    }

    @Override
    public int[] getEndYear() {
        return new int[]{2018, 2019, 2020, 2021, 2022};
    }
}
