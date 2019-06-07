package ru.company.laborant.jpa.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Заказчики
 *
 * @author Cheranev N.
 * created on 04.02.2017.
 */
@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CUSTOMER")
    @SequenceGenerator(name = "SEQ_CUSTOMER", sequenceName = "SEQ_CUSTOMER", allocationSize = 100)
    private Long id;
    private String fullName;
    private String address;
    private String phone;
    private String postIndex;
    @ManyToOne
    @JoinColumn(name = "folderId")
    private Folder folder;

    public Customer(String s1, String s2, String s3, String s4) {
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.postIndex = postIndex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(String postIndex) {
        this.postIndex = postIndex;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }
}
