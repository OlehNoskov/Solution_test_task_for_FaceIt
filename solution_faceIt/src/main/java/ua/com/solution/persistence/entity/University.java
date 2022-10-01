package ua.com.solution.persistence.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "universities")
@JsonPropertyOrder({"state","name", "institutionType", "phone", "website"})
public class University extends BaseEntity {

    public University() {
        super();
    }
    @Column(name = "state")
    private String state;
    @Column(name = "name")
    private String name;
    @Column(name = "institution_type")
    private String institutionType;
    @Column(name = "phone")
    private String phone;
    @Column(name = "website")
    private String website;
}