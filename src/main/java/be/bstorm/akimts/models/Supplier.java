package be.bstorm.akimts.models;

import lombok.Data;

@Data
public class Supplier {

    private long id;
    private String company;
    private String contactName;
    private String contactTitle;
    private String address;
    private String city;
    private String country;
    private String region;
    private String postalCode;
    private String phone;
    private String fax;
    private String homepage;

}
