package de.fourteen.account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

  private final Account account = new AccountImpl();

  @Test
  void test1() {
    account.deposit(100);
    if (account.balance() != 100) {
      fail("Balance not correct");
    }
    account.withdraw(50);
    if (account.balance() != 50) {
      fail("Balance not correct after withdraw");
    }
  }

  @Test
  void test2() {
    account.deposit(50);
    try {
      account.withdraw(100);
      fail("Expected exception not thrown");
    } catch (RuntimeException e) {
      assertTrue(e.getMessage().contains("funds"));
    }
  }

  @Test
  void test3() {
    Account another = new AccountImpl();
    account.deposit(200);
    account.transfer(another, 50);
    assertEquals(150, account.balance());
    assertEquals(50, another.balance());
  }
}
