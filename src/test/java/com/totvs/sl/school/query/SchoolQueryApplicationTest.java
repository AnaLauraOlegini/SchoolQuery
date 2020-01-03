package com.totvs.sl.school.query;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class SchoolQueryApplicationTest {

	@Test
	public void contextLoads() {
		SchoolQueryApplication.main(new String[] { "--spring.profiles.active=local" });
		assertThat(true).isTrue();
	}
}
