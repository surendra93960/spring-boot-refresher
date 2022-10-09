package com.test.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LineItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lineitemid", nullable = false)
    private Long lineitemid;

    @Column(name = "lineItem_name")
    private String lineItemName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_urn")
    @JsonIgnore
    private InvoiceEntity invoiceEntity;



}
