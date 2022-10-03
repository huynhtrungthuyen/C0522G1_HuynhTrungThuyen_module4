package com.example.model.contract;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contractDetailId;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "attach_facility_id", referencedColumnName = "attachFacilityId")
    private AttachFacility attachFacility;

    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "contractId")
    private Contract contract;

    public ContractDetail() {
    }

    public int getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(int contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
