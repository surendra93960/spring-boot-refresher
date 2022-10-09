package com.test.jpa;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;


@Data
@Builder
@ToString
public class InvoiceDTORequest {

    private String invoiceName;

    List<LineItemDTO> lineItemDTOS;
}
