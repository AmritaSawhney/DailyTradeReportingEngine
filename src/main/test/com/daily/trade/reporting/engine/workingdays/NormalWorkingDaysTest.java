package com.daily.trade.reporting.engine.workingdays;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class NormalWorkingDaysTest {
	
	private IWorkingDays workingDays;

	@Before
	public void setUp() {
		workingDays = NormalWorkingdays.getInstance();
	}

	@Test
	public void testFindNextWorkingDay_ValidInDayInput() {

		assertEquals(LocalDate.of(2017, 6, 27), workingDays.findNextWorkingDay(LocalDate.of(2017, 6, 27)));

	}

	@Test
	public void testFindNextWorkingDay_NonWorkingDayInput() {

		assertEquals(LocalDate.of(2017, 6, 26), workingDays.findNextWorkingDay(LocalDate.of(2017, 6, 24)));

	}

}
