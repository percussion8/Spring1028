package com.green.test1;

import com.green.test1.domain.Expense;
import com.green.test1.domain.ExpensiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan({"com.green"}) //찾는 경로 지정
public class Test1Application implements CommandLineRunner {

	@Autowired
	ExpensiveRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(Test1Application.class, args); //스프링부트에는 톰캣서버가 내장되어있어
		//이 메서드로 서버를 시작할 수 있다
	}

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Expense("Breakfast", 5));
		repository.save(new Expense("coffee", 2));
		repository.save(new Expense("new SSD drive", 200));
		repository.save(new Expense("Tuition", 350));
		repository.save(new Expense("Apple", 5));
		Iterable<Expense> iterator = repository.findAll();
		System.out.println("총 항목의 비용은 : ");
		iterator.forEach(item-> System.out.println(item));

		List<Expense> breakfast = repository.findByItem("Breakfast");
		System.out.println("\n 내 아침식사 비용은 얼마?");
		breakfast.forEach(item-> System.out.println(item));
//        List<Expense> expensiveItems = repository.listItemWithPriceOver(200);
//        System.out.println("\n 값비싼건?");
//        expensiveItems.forEach(item-> System.out.println(item));
	}
}
