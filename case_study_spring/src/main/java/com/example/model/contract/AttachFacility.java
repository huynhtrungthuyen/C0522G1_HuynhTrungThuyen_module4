package com.example.model.contract;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attachFacilityId;
    private String attachFacilityName;
    private String attachFacilityCost;
    private String attachFacilityUnit;
    private String attachFacilityStatus;

    @OneToMany(mappedBy = "attachFacility")
    private Set<ContractDetail> contractDetail;

    public AttachFacility() {
    }

    public Integer getAttachFacilityId() {
        return attachFacilityId;
    }

    public void setAttachFacilityId(Integer attachFacilityId) {
        this.attachFacilityId = attachFacilityId;
    }

    public String getAttachFacilityName() {
        return attachFacilityName;
    }

    public void setAttachFacilityName(String attachFacilityName) {
        this.attachFacilityName = attachFacilityName;
    }

    public String getAttachFacilityCost() {
        return attachFacilityCost;
    }

    public void setAttachFacilityCost(String attachServiceCost) {
        this.attachFacilityCost = attachServiceCost;
    }

    public String getAttachFacilityUnit() {
        return attachFacilityUnit;
    }

    public void setAttachFacilityUnit(String attachServiceUnit) {
        this.attachFacilityUnit = attachServiceUnit;
    }

    public String getAttachFacilityStatus() {
        return attachFacilityStatus;
    }

    public void setAttachFacilityStatus(String attachServiceStatus) {
        this.attachFacilityStatus = attachServiceStatus;
    }

    public Set<ContractDetail> getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(Set<ContractDetail> contractDetail) {
        this.contractDetail = contractDetail;
    }
}
