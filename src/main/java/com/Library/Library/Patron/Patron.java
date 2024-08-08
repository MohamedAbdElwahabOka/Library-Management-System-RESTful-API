package com.Library.Library.Patron;

import com.Library.Library.BorrowingRecord.BorrowingRecord;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Patron {
    @Id
    @SequenceGenerator(
            name = "Patron_sequence",
            sequenceName = "Patron_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Patron_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String zip;

    @OneToMany(mappedBy = "patron")
    private List<BorrowingRecord> borrowingRecords;

    public Patron() {}

    public Patron(String name, String email, String phone, String address, String zip) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.zip = zip;
    }

    public Patron(
            Long id,
            String name,
            String email,
            String phone,
            String address,
            String zip) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.zip = zip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Patron{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
