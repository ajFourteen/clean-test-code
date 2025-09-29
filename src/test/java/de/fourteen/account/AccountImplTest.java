package de.fourteen.account;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static de.fourteen.account.AccountAssert.assertThat;

class AccountImplTest {

  private final Account sut = new AccountImpl();

  @Test
  void depositingIncreasesTheBalance() {
    // given

    // when
    sut.deposit(100);

    // then
    assertThat(sut).hasBalance(100);
  }

  @Test
  void withdrawingDecreasesTheBalance() {
    // given
    sut.deposit(100);

    // when
    sut.withdraw(50);

    // then
    assertThat(sut).hasBalance(50);
  }

  @Test
  void withdrawingIsNotPossibleWithInsufficientFunds() {
    // given
    sut.deposit(50);

    // when
    var exception = catchThrowable(() -> sut.withdraw(100));

    // then
    assertThat(exception).isNotNull();
    assertThat(exception).hasMessageContaining("funds");
  }

  @Test
  void itsPossibleToTransferMoneyFromOneAccountToAnother() {
    // given
    Account another = new AccountImpl();
    sut.deposit(200);

    // when
    sut.transfer(another, 50);

    // then
    assertThat(sut).hasBalance(150);
    assertThat(another).hasBalance(50);
  }
}
