package com.test.ibm;

import com.test.ibm.controller.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestIbmApplicationTests {

	@Autowired
	private AdviserController adviserController;

	@Autowired
	private AppController appController;

	@Autowired
	private CardController cardController;

	@Autowired
	private CustomerController customerController;

	@Autowired
	private TransactionController transactionController;

	@Test
	public void contexLoads() {
		assertThat(adviserController).isNotNull();
		assertThat(appController).isNotNull();
		assertThat(cardController).isNotNull();
		assertThat(customerController).isNotNull();
		assertThat(transactionController).isNotNull();
	}

}
