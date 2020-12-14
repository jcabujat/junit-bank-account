package com.jcabujat;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;
    private static int count;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all... count = " + count++);
    }

    @BeforeEach
    void setup() {
        account = new BankAccount("Jonathan", "Cabujat", 1000.00, BankAccount.CHECKING);
        System.out.println("Setting up the bank account...");
    }

    @org.junit.jupiter.api.Test
    void deposit() {
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, balance, 0); // 'delta' is like a lee-way or threshold of difference
    }

    @org.junit.jupiter.api.Test
    void withdraw_branch() {
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
    }

    @Test
    public void withdraw_notBranch() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(600.00, false));
    }

    @org.junit.jupiter.api.Test
    void getBalance_deposit() {
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void getBalance_withdraw() {
        double balance = account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    public void isChecking_true() {
        assertTrue(account.isChecking(), "The account is not a checking account");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all.. count = " + count++);
    }

    @AfterEach
    void afterEach() {
        System.out.println("After each.. count = " + count++);
    }

}