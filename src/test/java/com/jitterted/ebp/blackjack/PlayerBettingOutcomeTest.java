package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerBettingOutcomeTest {

  @Test
  public void playerWith6Deposits7ThenBalanceIs13() {
    Player player = new Player(6);

    player.deposit(7);

    assertThat(player.balance())
            .isEqualTo(6 + 7);
  }

  @Test
  public void playerWith33Bets11ThenBalanceIs22() {
    Player player = new Player(33);

    player.bet(11);

    assertThat(player.balance())
            .isEqualTo(33 - 11);
  }

  @Test
  public void playerWith20Bets4AndWinsThenBalanceIs24() {
    Player player = new Player(20);

    player.bet(4);
    player.win();

    assertThat(player.balance())
            .isEqualTo(20 - 4 + 4 * 2);
  }

  @Test
  public void playerWith5Bets5AndLosesThenBalanceIs0() {
    Player player = new Player(5);

    player.bet(5);
    player.lose();

    assertThat(player.balance())
            .isEqualTo(5 - 5);
  }

  @Test
  public void playerWith17Bets9AndTiesThenBalanceIs17() {
    Player player = new Player(17);

    player.bet(9);
    player.tie();

    assertThat(player.balance())
            .isEqualTo(17 - 9 + 9);
  }

  @Test
  public void playerWith34Bets16AndWinsThenTotalAmountBetIs26() {
    Player player = new Player(34);

    player.bet(16);
    player.win();

    assertThat(player.totalAmountBet())
            .isEqualTo(16);
  }

  @Test
  public void playerWith81Bets27TiesBets14AndLosesThenTotalAmountBetIs41() {
    Player player = new Player(81);

    player.bet(27);
    player.tie();
    player.bet(14);
    player.lose();

    assertThat(player.totalAmountBet())
            .isEqualTo(27 + 14);
  }
}
