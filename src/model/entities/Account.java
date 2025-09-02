package model.entities;

import entities.exception.DomainException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account() {
    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getwithdrawLimit() {
        return withdrawLimit;
    }

    public void deposit(double amount){
        balance += amount;
    }
    
    public void withdraw(double amount) throws DomainException{
        validartewithdraw(amount);
        balance -= amount;
    }
    
    private void validartewithdraw(double amount) throws DomainException{
        if(getBalance() < amount){
            throw new DomainException("Nao tem saldo");
        }
        if(getwithdrawLimit() < amount){
            throw new DomainException("Nao tem limite");
        }
    }
}
