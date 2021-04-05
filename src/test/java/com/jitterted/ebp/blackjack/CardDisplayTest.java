package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CardDisplayTest {

  @Test
  public void displayAsTenCard() throws Exception {
    Card tenCard = new Card(Suit.CLUBS, Rank.TEN);

    assertThat(ConsoleCard.display(tenCard))
        .isEqualTo("[30m┌─────────┐[1B[11D│10       │[1B[11D│         │[1B[11D│    ♣    │[1B[11D│         │[1B[11D│       10│[1B[11D└─────────┘");
  }

  @Test
  public void displayNonTenCard() throws Exception {
    Card threeCard = new Card(Suit.DIAMONDS, Rank.THREE);

    assertThat(ConsoleCard.display(threeCard))
        .isEqualTo("[31m┌─────────┐[1B[11D│3        │[1B[11D│         │[1B[11D│    ♦    │[1B[11D│         │[1B[11D│        3│[1B[11D└─────────┘");
  }
}
