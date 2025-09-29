package de.fourteen.account;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AccountImplTest {

  private final Account sut = new AccountImpl();

  @Test
  void test1() {
    sut.deposit(100);
    if (sut.balance() != 100) {
      fail("Balance not correct");
    }
    sut.withdraw(50);
    if (sut.balance() != 50) {
      fail("Balance not correct after withdraw");
    }
  }

  @Test
  void test2() {
    sut.deposit(50);
    try {
      sut.withdraw(100);
      fail("Expected exception not thrown");
    } catch (RuntimeException e) {
      assertThat(e.getMessage()).contains("funds");
    }
  }

  @Test
  void test3() {
    Account another = new AccountImpl();
    sut.deposit(200);
    sut.transfer(another, 50);
    assertEquals(150, sut.balance());
    assertEquals(50, another.balance());
  }
}
