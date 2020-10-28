package com.green.test1.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //테이블생성
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String item;
    private float amount;

    public Expense(){}
    public Expense(String item, float amount){ //생성자 오버로딩

        this.item=item;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return id + ", " + item + " - " + amount + " USD";
    }
}
