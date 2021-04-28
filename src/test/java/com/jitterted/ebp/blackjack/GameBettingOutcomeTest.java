package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GameBettingOutcomeTest {

  // Player Ties = get Bet back
  // Player BJ = Bet + Bet + 50% Bet

  @Test
  public void playerWith20Bets10WhenWinsBalanceIs30() throws Exception {
    Game game = createGameWithPlayerBalanceOf(20);
    game.player.bet(10);

    game.player.win();

    assertThat(game.player.balance())
        .isEqualTo(30);
  }

  @Test
  public void playerWith80Bets70WhenTiesBalanceIs80() throws Exception {
    Game game = createGameWithPlayerBalanceOf(80);
    game.player.bet(70);

    game.player.tie();

    assertThat(game.player.balance())
        .isEqualTo(80);
  }

  @Test
  public void playerWith35Bets30WhenLosesBalanceIs5() throws Exception {
    Game game = createGameWithPlayerBalanceOf(35);

    game.player.bet(30);
    game.player.lose();

    assertThat(game.player.balance())
        .isEqualTo(5);
  }

  @Test
  public void playerWith40Bets15BalanceIs25() throws Exception {
    Game game = createGameWithPlayerBalanceOf(40);

    game.player.bet(15);

    assertThat(game.player.balance())
        .isEqualTo(25);
  }

  @Test
  public void playerDeposits18DollarsBalanceIs18Dollars() throws Exception {
    Game game = createGameWithPlayerBalanceOf(18);

    assertThat(game.player.balance())
        .isEqualTo(18);
  }

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

  private Game createGameWithPlayerBalanceOf(int amount) {
    Game game = new Game();
    game.player.deposit(amount);
    return game;
  }
}
