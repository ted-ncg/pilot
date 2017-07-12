# Steps to process Deposit

-- ADAPTER LAYER --

1. Convert depositRequest to Deposit
1. Invoke depositService.process(deposit)

## DepositService

process(Deposit deposit)

1. Persist the Deposit object to the DepositRepository
1. Get account via Deposit.accountId from AccountRepository
1. account.deposit( deposit.amount )
1. Persist the Account back to AccountRepository

## Dependencies

* DepositRepository
* AccountRepository
