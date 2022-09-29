package com.example.dto;

import com.example.model.facility.FacilityType;
import com.example.model.facility.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class FacilityDto implements Validator {
    private Integer facilityId;

    @NotBlank(message = "Tên dịch vụ không được để trống.")
    @Pattern(regexp = "^(([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}( \\d*)?)| *$",
            message = "Tên dịch vụ được phép chứa số, và các kí tự đầu tiên của mỗi từ phải viết hoa.")
    private String facilityName;

    @NotBlank(message = "Diện tích sử dụng không được để trống.")
    @Pattern(regexp = "^[1-9]\\d*| *$", message = "Diện tích sử dụng phải là số nguyên dương.")
    private String facilityArea;

    @NotBlank(message = "Chi phí thuê không được để trống.")
    @Pattern(regexp = "^[1-9]\\d*| *$", message = "Chi phí thuê (VNĐ) phải là số nguyên dương.")
    private String rentCost;

    @NotBlank(message = "Số người tối đa không được để trống.")
    @Pattern(regexp = "^[1-9]\\d*| *$", message = "Số người tối đa phải là số nguyên dương.")
    private String maxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;

    @Pattern(regexp = "^[1-9]\\d*| *$", message = "Diện tích hồ bơi phải là số nguyên dương.")
    private String poolArea;

    @Pattern(regexp = "^[1-9]\\d*| *$", message = "Số tầng phải là số nguyên dương.")
    private String numberOfFloors;
    private String facilityFree;
    private RentType rentType;

    @NotNull
    private FacilityType facilityType;

    public FacilityDto() {
    }

    public Integer getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Integer facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityArea() {
        return facilityArea;
    }

    public void setFacilityArea(String facilityArea) {
        this.facilityArea = facilityArea;
    }

    public String getRentCost() {
        return rentCost;
    }

    public void setRentCost(String rentCost) {
        this.rentCost = rentCost;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;
    }
}
