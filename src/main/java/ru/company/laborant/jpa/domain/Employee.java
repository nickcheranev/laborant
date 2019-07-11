package ru.company.laborant.jpa.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 * Сотрудники
 *
 * @author Cheranev N.
 * created on 04.02.2017.
 */
@Entity
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EMPLOYEE")
    @SequenceGenerator(name = "SEQ_EMPLOYEE", sequenceName = "SEQ_EMPLOYEE", allocationSize = 100)
    private Long id;
    private String fullName;
    private String address;
    private String phone;
    private String postIndex;
    private String description;
    @ManyToOne
    @JoinColumn(name = "folderId")
    private Folder folder;

    public Employee(String fullName, String address, String phone, String postIndex, String description) {
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.postIndex = postIndex;
        this.description = description;
    }
    public Long getId() {
        return id;
    }
    @Override
    public String toString () {
        return String.format("Employee[id=%d, fullName='%s', address='%s', phone='%s'," +
                "postIndex='%s', description='%s']", id, fullName, address, phone, postIndex, description);
    }
}
