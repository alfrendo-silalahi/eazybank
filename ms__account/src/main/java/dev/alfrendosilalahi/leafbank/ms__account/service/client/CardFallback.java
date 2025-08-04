package dev.alfrendosilalahi.leafbank.ms__account.service.client;

import dev.alfrendosilalahi.leafbank.ms__account.dto.client.card.CardsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CardFallback implements CardFeignClient {

    @Override
    public ResponseEntity<CardsDto> fetchCardDetails(String correlationId, String mobileNumber) {
        return null;
    }

}
