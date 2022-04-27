package model;

import javax.persistence.*;

@Entity
@Table(name = "agencies")
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AgencyId", nullable = false)
    private Integer id;

    @Column(name = "AgncyAddress", length = 50)
    private String agncyAddress;

    @Column(name = "AgncyCity", length = 50)
    private String agncyCity;

    @Column(name = "AgncyProv", length = 50)
    private String agncyProv;

    @Column(name = "AgncyPostal", length = 50)
    private String agncyPostal;

    @Column(name = "AgncyCountry", length = 50)
    private String agncyCountry;

    @Column(name = "AgncyPhone", length = 50)
    private String agncyPhone;

    @Column(name = "AgncyFax", length = 50)
    private String agncyFax;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgncyAddress() {
        return agncyAddress;
    }

    public void setAgncyAddress(String agncyAddress) {
        this.agncyAddress = agncyAddress;
    }

    public String getAgncyCity() {
        return agncyCity;
    }

    public void setAgncyCity(String agncyCity) {
        this.agncyCity = agncyCity;
    }

    public String getAgncyProv() {
        return agncyProv;
    }

    public void setAgncyProv(String agncyProv) {
        this.agncyProv = agncyProv;
    }

    public String getAgncyPostal() {
        return agncyPostal;
    }

    public void setAgncyPostal(String agncyPostal) {
        this.agncyPostal = agncyPostal;
    }

    public String getAgncyCountry() {
        return agncyCountry;
    }

    public void setAgncyCountry(String agncyCountry) {
        this.agncyCountry = agncyCountry;
    }

    public String getAgncyPhone() {
        return agncyPhone;
    }

    public void setAgncyPhone(String agncyPhone) {
        this.agncyPhone = agncyPhone;
    }

    public String getAgncyFax() {
        return agncyFax;
    }

    public void setAgncyFax(String agncyFax) {
        this.agncyFax = agncyFax;
    }

}