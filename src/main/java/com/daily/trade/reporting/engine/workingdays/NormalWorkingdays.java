package com.daily.trade.reporting.engine.workingdays;

import java.time.DayOfWeek;

/**
 * @author Amrita_Sawhney
 *
 */
/*
 * Concrete class for NormalWorkingdays
 */
public class NormalWorkingdays extends WorkingDays {

	private NormalWorkingdays() {
	}

	private static class WorkingDaysHelper {
		private static final NormalWorkingdays INSTANCE = new NormalWorkingdays();
	}

	public static NormalWorkingdays getInstance() {
		return WorkingDaysHelper.INSTANCE;
	}

	@Override
	protected void loadDefaultWorkingDays() {
		this.validWorkingDayList.add(DayOfWeek.MONDAY);
		this.validWorkingDayList.add(DayOfWeek.TUESDAY);
		this.validWorkingDayList.add(DayOfWeek.WEDNESDAY);
		this.validWorkingDayList.add(DayOfWeek.THURSDAY);
		this.validWorkingDayList.add(DayOfWeek.FRIDAY);
	}

}
