package com.coforge.training.airline.service;

import java.util.List;

import com.coforge.training.airline.model.Card;

public interface CardService {

	Card saveCard(Card card);

	List<Card> getCard();

	Boolean verifycard(long cardno);

	Boolean verifyCardDetails(Card card);

	Boolean verifyByCode(Card card);

}
