package com.green.test1.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExpensiveRepository extends CrudRepository<Expense, Long> {
    // 방법1) 맴버변수(칼럼명)으로 자동 생성하는 메서드
    public List<Expense> findByItem(String item);

    //방법) 쿼리문을 이용하여 사용자가 임의로 정하는 메서드
    @Query("select e from Expense e where e.amount >= :amount")
    public List<Expense> listItemWithPriceOver(float amount);

}
