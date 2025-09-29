package de.fourteen.account;

import org.assertj.core.api.AbstractAssert;

final class AccountAssert extends AbstractAssert<AccountAssert, Account> {

  public AccountAssert(final Account actual, final Class<?> selfType) {
    super(actual, selfType);
  }

  static AccountAssert assertThat(Account actual) {
    return new AccountAssert(actual, AccountAssert.class);
  }

  void hasBalance(final int expectedBalance) {
    if(expectedBalance != actual.balance()) {
      failWithMessage("Expected account to have balance %s but had %s", expectedBalance, actual.balance());
    }
  }
}
