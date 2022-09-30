package ua.com.solution.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class University extends BaseEntity {
    public University() {
        super();
    }

    @Column(name = "name")
    private String name;
    @Column(name = "state")
    private String state;
    @Column(name = "institution_type")
    private String institutionType;
    @Column(name = "phone")
    private String phone;
    @Column(name = "website")
    private String website;
}