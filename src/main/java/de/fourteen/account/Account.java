package de.fourteen.account;

public interface Account {
  void deposit(int amount);

  int balance();

  void withdraw(int amount);

  void transfer(Account to, int amount);
}
