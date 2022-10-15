package com.test.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceEntity {
    @Id
    @Column(name = "invoice_urn", nullable = false)
    private Long invoiceUrn;

    @Column(name = "invoice_name")
    private String invoiceName;

    @OneToMany(mappedBy = "invoiceEntity",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<LineItemEntity> lineItemEntityList;

}
