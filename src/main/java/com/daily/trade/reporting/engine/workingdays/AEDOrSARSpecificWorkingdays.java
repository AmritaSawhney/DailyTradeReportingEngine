package com.daily.trade.reporting.engine.workingdays;

import java.time.DayOfWeek;

/**
 * @author Amrita_Sawhney
 *
 */
/*
 * Concrete class for AEDOrSARSpecificWorkingDays
 */
public class AEDOrSARSpecificWorkingdays extends WorkingDays {
	
	private AEDOrSARSpecificWorkingdays(){}

	private static class SingletonHelper {
		private static final AEDOrSARSpecificWorkingdays INSTANCE = new AEDOrSARSpecificWorkingdays();
	}

	public static AEDOrSARSpecificWorkingdays getInstance() {
		return SingletonHelper.INSTANCE;
	}

	@Override
	protected void loadDefaultWorkingDays() {
		this.validWorkingDayList.add(DayOfWeek.SUNDAY);
		this.validWorkingDayList.add(DayOfWeek.MONDAY);
		this.validWorkingDayList.add(DayOfWeek.TUESDAY);
		this.validWorkingDayList.add(DayOfWeek.WEDNESDAY);
		this.validWorkingDayList.add(DayOfWeek.THURSDAY);
	}

}
