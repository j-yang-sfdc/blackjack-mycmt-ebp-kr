package com.jitterted.ebp.blackjack;

public class Player {
  private int balance;
  private int bet;

  public Player() {
    this(0);
  }

  public Player(int initialBalance) {
    balance = initialBalance;
    bet = 0;
  }

  public void deposit(int amount) {
    balance += amount;
  }

  public int balance() {
    return balance;
  }

  public void bet(int betAmount) {
    bet = betAmount;
    balance -= betAmount;
  }

  public void win() {
    balance += bet * 2;
  }

  public void lose() {
    balance += bet * 0;
  }

  public void tie() {
    balance += bet * 1;
  }
}
