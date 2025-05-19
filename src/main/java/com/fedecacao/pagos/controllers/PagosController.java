package com.fedecacao.pagos.controllers;

import com.fedecacao.pagos.dtos.dtos.PagosDto;
import com.fedecacao.pagos.dtos.dtos.WebhookDto;
import com.fedecacao.pagos.services.impl.PagosImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagos")
@Slf4j
public class PagosController {

     private PagosImpl pagosService;

     public PagosController(PagosImpl pagosService) {
         this.pagosService = pagosService;
     }

     @PostMapping("/create")
     public ResponseEntity<Void> createPagos(@RequestBody PagosDto pagosDto) {
         System.out.println("PagosDto: " + pagosDto);
         pagosService.savePagos(pagosDto);
         return ResponseEntity.ok().build();
     }

    @PostMapping("/receive")
    public ResponseEntity<Void> receiveWebhookEvent(@RequestBody WebhookDto payload) {
        log.info("Evento de webhook recibido: {}", payload);

        // Verificar la firma del webhook (opcional pero recomendado)
//        if (signature != null && !webhookService.verifySignature(payload, signature)) {
//            return ResponseEntity.badRequest().build();
//        }

        // Procesar el evento
        //pagosService.processWebhookEvent(payload);

        return ResponseEntity.ok().build();
    }

}
