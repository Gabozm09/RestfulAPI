package com.example.geektext.Controller;

import com.example.geektext.model.CreditCard;
import com.example.geektext.repository.CreditCardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/credit-cards")
public class CreditCardController {

    @Autowired
    private CreditCardRepository creditCardRepository;

    // Get all credit cards
    @GetMapping
    public List<CreditCard> getAllCreditCards() {
        return creditCardRepository.findAll();
    }

    // Get a credit card by ID
    @GetMapping("/{id}")
    public ResponseEntity<CreditCard> getCreditCardById(@PathVariable("id") String id) {
        Optional<CreditCard> creditCardData = creditCardRepository.findById(id);

        return creditCardData.map(creditCard -> new ResponseEntity<>(creditCard, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create a new credit card
    @PostMapping
    public ResponseEntity<CreditCard> createCreditCard(@RequestBody CreditCard creditCard) {
        try {
            CreditCard newCreditCard = creditCardRepository.save(creditCard);
            return new ResponseEntity<>(newCreditCard, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update a credit card by ID
    @PutMapping("/{id}")
    public ResponseEntity<CreditCard> updateCreditCard(@PathVariable("id") String id, @RequestBody CreditCard creditCard) {
        Optional<CreditCard> creditCardData = creditCardRepository.findById(id);

        if (creditCardData.isPresent()) {
            CreditCard updatedCreditCard = creditCardData.get();
            updatedCreditCard.setUserId(creditCard.getUserId());
            updatedCreditCard.setCardNumber(creditCard.getCardNumber());
            updatedCreditCard.setExpirationDate(creditCard.getExpirationDate());
            updatedCreditCard.setCardholderName(creditCard.getCardholderName());

            return new ResponseEntity<>(creditCardRepository.save(updatedCreditCard), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a credit card by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCreditCard(@PathVariable("id") String id) {
        try {
            creditCardRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

