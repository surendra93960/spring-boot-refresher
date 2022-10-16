package com.test.jpa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import java.util.List;


@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class LineItemDTO {

    private String lineItemName;
    private List<LineItemDetailDTO> lineItemDetailDTOS;
}
