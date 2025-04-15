package dev.alfrendosilalahi.eazybank.account.service.client;

import dev.alfrendosilalahi.eazybank.account.dto.client.card.CardsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CardFallback implements CardFeignClient {

    @Override
    public ResponseEntity<CardsDto> fetchCardDetails(String correlationId, String mobileNumber) {
        return null;
    }

}
