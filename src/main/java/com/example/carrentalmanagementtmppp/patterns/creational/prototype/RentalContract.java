package com.example.carrentalmanagementtmppp.patterns.creational.prototype;

public class RentalContract implements RentalContractPrototype {

    private String title;
    private String standardTerms;
    private String additionalNotes;
    private Long reservationId;
    private String customerName;
    private String carDetails;

    public RentalContract() {
    }

    public RentalContract(String title, String standardTerms, String additionalNotes,
                          Long reservationId, String customerName, String carDetails) {
        this.title = title;
        this.standardTerms = standardTerms;
        this.additionalNotes = additionalNotes;
        this.reservationId = reservationId;
        this.customerName = customerName;
        this.carDetails = carDetails;
    }

    @Override
    public RentalContractPrototype cloneContract() {
        return new RentalContract(
                this.title,
                this.standardTerms,
                this.additionalNotes,
                this.reservationId,
                this.customerName,
                this.carDetails
        );
    }

    public String getTitle() {
        return title;
    }

    public String getStandardTerms() {
        return standardTerms;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCarDetails() {
        return carDetails;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStandardTerms(String standardTerms) {
        this.standardTerms = standardTerms;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCarDetails(String carDetails) {
        this.carDetails = carDetails;
    }
}
