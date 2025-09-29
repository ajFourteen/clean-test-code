package de.fourteen.account;

final class AccountImpl implements Account {
  private int balance;

  @Override
  public void deposit(final int amount) {
    balance += amount;
  }

  @Override
  public int balance() {
    return balance;
  }

  @Override
  public void withdraw(final int amount) {
    if(amount > balance) throw new IllegalArgumentException("insufficient funds");
    balance -= amount;
  }

  @Override
  public void transfer(final Account to, final int amount) {
    withdraw(amount);
    to.deposit(amount);
  }
}
