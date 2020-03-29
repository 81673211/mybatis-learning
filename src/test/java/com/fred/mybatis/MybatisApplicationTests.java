package com.fred.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;

@SpringBootTest
class MybatisApplicationTests {

	@Test
	void contextLoads() {
		Calendar instance = Calendar.getInstance();
		instance.set(2020, Calendar.APRIL, 13);
		instance.add(Calendar.DAY_OF_YEAR, 158);
		System.out.println(instance.getTime());
	}

}
