# bank_event_sourcing
Bank application to demo event sourcing

Axon server is used to manage events and the server need to be up to run the applicaiton
Axon server console URL http://localhost:8024/
H2 datebase is used to mangage and persist the bank accounts and and only dealing with one table BANK_ACCOUNT 
H2 consle URL http://localhost:18088/h2-console
the application is configured to run on port 18088
Swagger 2 is used to manafge and test apis
Swagger URL  = http://localhost:18088/swagger-ui.html#/
the applicatin has two REST resources one for write  (command) and one for read (query)
Database only maintain on record per account  and the account update by the command
all transction stored in the event store in the Axon server
bank-account-command-resource
Bank Account Command Resource

POST
/accounts
createAccount
PUT
/deposite/{accountId}
creditMoneyToAccount
PUT
/withdraw/{accountId}
debitMoneyFromAccount


bank-account-query-resource

GET
/accounts/{accountId}
findById
GET
/accounts/{accountId}/events
listEventsForAccount
GET
/accounts/{accountId}/transactions/{transactionType}/events
listEventsForAccount

