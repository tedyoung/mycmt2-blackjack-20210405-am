package com.jitterted.ebp.blackjack.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameOutcomeTest {

  @Test
  public void playerBeatsDealer() throws Exception {
    Deck playerBeatsDealerDeck = new StubDeck(Rank.QUEEN, Rank.EIGHT,
                                              Rank.TEN, Rank.JACK);
    Game game = new Game(playerBeatsDealerDeck);
    game.initialDeal();

    game.playerStands();

    assertThat(game.determineOutcome())
        .isEqualByComparingTo(GameOutcome.PLAYER_BEATS_DEALER);
  }

  @Test
  public void playerHitsGoesBustResultsInPlayerLoses() throws Exception {
    Deck playerHitsGoesBustDeck = StubDeck.createPlayerHitsGoesBustDeck();
    Game game = new Game(playerHitsGoesBustDeck);
    game.initialDeal();

    game.playerHits();

    assertThat(game.determineOutcome())
        .isEqualByComparingTo(GameOutcome.PLAYER_BUSTED);
  }

  @Test
  public void playerDealtAceAndTenResultsInWinBlackjack() throws Exception {
    Deck playerDealtBlackjackDeck = new StubDeck(Rank.ACE, Rank.EIGHT,
                                                 Rank.TEN, Rank.JACK);
    Game game = new Game(playerDealtBlackjackDeck);
    game.initialDeal();

    assertThat(game.isPlayerDone())
        .isTrue();

    assertThat(game.determineOutcome())
        .isEqualByComparingTo(GameOutcome.PLAYER_WINS_BLACKJACK);
  }

  @Test
  public void playerStandsDealerTakesAdditionalCard() throws Exception {
    Deck dealerDrawsAdditionalCardDeck = new StubDeck(Rank.TEN,   Rank.QUEEN,
                                                      Rank.EIGHT, Rank.FIVE,
                                                                  Rank.SIX);
    Game game = new Game(dealerDrawsAdditionalCardDeck);
    game.initialDeal();

    game.playerStands();

    assertThat(game.dealerHand().cards())
        .hasSize(3);
  }

}