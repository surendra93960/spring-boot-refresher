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
public class LineItemDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "line_Item_Detail_Id", nullable = false)
    private Long lineItemDetailId;

    @Column(name = "lineItem_detail_name")
    private String lineItemDetailName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lineItemId",referencedColumnName = "lineitemid")
    @JsonIgnore
    private LineItemEntity lineItemEntity;

}
