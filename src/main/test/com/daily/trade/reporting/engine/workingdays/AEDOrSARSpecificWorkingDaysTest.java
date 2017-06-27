package com.daily.trade.reporting.engine.workingdays;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class AEDOrSARSpecificWorkingDaysTest {

	private IWorkingDays workingDays;

	@Before
	public void setUp() {
		workingDays = AEDOrSARSpecificWorkingdays.getInstance();
	}

	@Test
	public void testFindNextWorkingDay_ValidInDayInput() {

		assertEquals(LocalDate.of(2017, 6, 25), workingDays.findNextWorkingDay(LocalDate.of(2017, 6, 25)));

	}

	@Test
	public void testFindNextWorkingDay_NonWorkingDayAED() {

		assertEquals(LocalDate.of(2017, 6, 25), workingDays.findNextWorkingDay(LocalDate.of(2017, 6, 23)));

	}
}
