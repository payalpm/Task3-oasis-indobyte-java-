# Task3-oasis-indobyte-java- #java #task3 #atminterface #oasisinfobyte
The ATM Interface is a Java-based console application that simulates an Automated Teller Machine (ATM). The application consists of five different classes and is designed to provide users with a secure and convenient way to manage their bank accounts. 
Transactions History: view a list of recent transactions
Withdraw: withdraw a specified amount from the account
Deposit: deposit a specified amount into the account
Transfer: transfer a specified amount from the user's account to another account
Quit: exit the ATM interface

Importing necessary libraries:

The first line imports the Scanner class from the java.util library to allow the program to receive input from the user.
The second line imports the ArrayList class from the java.util library to allow the program to store transactions.
The Transaction class:

This class represents a single transaction with two instance variables: amount and type.
The class provides two getter methods to retrieve these variables.
The constructor sets the instance variables when a new Transaction object is created.
The User class:

This class represents a user with four instance variables: userId, pin, balance, and transactions.
The transactions variable is an ArrayList of Transaction objects to store the user's transactions.

The class provides methods to perform the following actions:
validate(): Validates the user by checking if the input userId and pin match the user's userId and pin.
getBalance(): Returns the user's balance.
withdraw(): Withdraws amount from the user's balance and adds a new transaction with type "withdraw".
deposit(): Deposits amount to the user's balance and adds a new transaction with type "deposit".
transfer(): Transfers amount from the user's balance to another user's balance and adds two transactions (one with type "transfer" and one with type "deposit").
showTransactions(): Displays the user's transactions.
The constructor sets the instance variables when a new User object is created and initializes the transactions ArrayList.


