package com.example.geektext.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "credit_cards")
public class CreditCard {

    @Id
    private String id;

    @Field("user_id")
    private String userId;

    @Field("card_number")
    private String cardNumber;

    @Field("expiration_date")
    private String expirationDate;

    @Field("cardholder_name")
    private String cardholderName;

    public CreditCard() {
    }

    public CreditCard(String userId, String cardNumber, String expirationDate, String cardholderName) {
        this.userId = userId;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cardholderName = cardholderName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }
}

