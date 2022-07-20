package com.idat.iluminatik.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockAdd  extends IdBaseEntity {

    @ManyToOne
    private Product product;
    private int quantity;
    private LocalDate createAt;
    private String provider;
    private String guideNumber;
    private double price;
    @PrePersist
    void prePersist(){
        createAt = LocalDate.now();
    }

}
