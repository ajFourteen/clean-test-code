package de.fourteen.account;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

class AccountImplTest {

  private final Account sut = new AccountImpl();

  @Test
  void test1() {
    // given

    // when
    sut.deposit(100);

    // then
    if (sut.balance() != 100) {
      fail("Balance not correct");
    }
  }

  @Test
  void test1a() {
    // given
    sut.deposit(100);

    // when
    sut.withdraw(50);

    // then
    if (sut.balance() != 50) {
      fail("Balance not correct after withdraw");
    }
  }

  @Test
  void test2() {
    // given
    sut.deposit(50);

    // when
    var exception = catchThrowable(() -> sut.withdraw(100));

    // then
    assertThat(exception).isNotNull();
    assertThat(exception.getMessage()).contains("funds");
  }

  @Test
  void test3() {
    // given
    Account another = new AccountImpl();
    sut.deposit(200);

    // when
    sut.transfer(another, 50);

    // then
    assertEquals(150, sut.balance());
    assertEquals(50, another.balance());
  }
}
