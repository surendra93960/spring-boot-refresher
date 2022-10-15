package com.test.jpa;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Log4j2
public class TestController {

    @Autowired
    InvoiceService invoiceService;

    @Autowired
    LineItemRepoSitory lineItemRepoSitory;
    @Autowired
    InvoiceRepository invoiceRepository;

    @GetMapping
    public String testMsg(){
        return "Welcome !! ";
    }

//    @PostMapping("/invoice/savekjhkj")
//    public void saveInvoice(@RequestBody InvoiceDTORequest invoiceDTORequest){
//        System.out.println("Enjoyy");
//    }

    @GetMapping("/invoice/all")
    public List<InvoiceEntity> getAllInvoices(){
        return invoiceRepository.findAll();
    }
    @GetMapping("/linitem/{invoiceUrn}")
    public List<InvoiceEntity> updateAndGetAllLineItems(@PathVariable(value = "invoiceUrn") Long invoiceUrn){
        Optional<InvoiceEntity> byId = invoiceRepository.findById(invoiceUrn);
        InvoiceEntity invoiceEntity = byId.get();
        invoiceEntity.setInvoiceName("updated invoice");
        invoiceEntity.getLineItemEntityList().stream().forEach(lineItemEntity -> {
            lineItemEntity.setLineItemName("updated second tym as weell!!");
        });
        invoiceRepository.save(invoiceEntity);
        return invoiceRepository.findAll();
    }

    @PostMapping("/invoice/save")
    @Transactional
    public ResponseEntity<InvoiceEntity> saveInvoice(@RequestBody InvoiceDTORequest invoicedto){

        log.info("invoice DTO is {}",invoicedto);
        List<LineItemEntity> lineItemEntities = new ArrayList<>();
        //LineItemEntity lineItemEntity = null;
        InvoiceEntity invoiceEntity = InvoiceEntity.builder()
                .invoiceName(invoicedto.getInvoiceName())
                .build();

        invoicedto.getLineItemDTOS().stream().forEach(lineItemDTO -> {
            LineItemEntity lineItemEntity = LineItemEntity.builder()
                    .lineItemName(lineItemDTO.getLineItemName())
                    .invoiceEntity(invoiceEntity)
                    .build();
            lineItemEntities.add(lineItemEntity);
        });
        invoiceEntity.setLineItemEntityList(lineItemEntities);
        InvoiceEntity inv = invoiceRepository.save(invoiceEntity);


        return new ResponseEntity<InvoiceEntity>(inv,HttpStatus.CREATED);
        //return "";
    }

    @GetMapping("/lineitem/all")
    public List<LineItemEntity> getAllLineitems(){
        return lineItemRepoSitory.findAll();
    }

}
