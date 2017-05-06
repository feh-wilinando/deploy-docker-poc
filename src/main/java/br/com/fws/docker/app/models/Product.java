package br.com.fws.docker.app.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by nando on 06/05/17.
 */
@Entity
public class Product {

    public static Product empty() {
        return new Product();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(unique = true)
    private String name;

    @NotEmpty
    private String description;


    private LocalDate registrationDate;

    @DecimalMin("5.0")
    @NotNull
    private BigDecimal price;


    @Deprecated
    protected Product() {
    }

    public Product(String name, String description, LocalDate registrationDate, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.registrationDate = registrationDate;
        this.price = price;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @PrePersist
    public void prePersist(){
        registrationDate = LocalDate.now();
    }

}
