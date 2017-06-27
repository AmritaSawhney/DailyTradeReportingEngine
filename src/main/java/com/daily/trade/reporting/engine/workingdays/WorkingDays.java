package com.daily.trade.reporting.engine.workingdays;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Amrita_Sawhney
 *
 */
/*
 * Abstract class to provide abstract method implementation
 */
public abstract class WorkingDays implements IWorkingDays {

	protected List<DayOfWeek> validWorkingDayList = new ArrayList<>();

	protected abstract void loadDefaultWorkingDays();

	public WorkingDays() {
		loadDefaultWorkingDays();
	}

	@Override
	public LocalDate findNextWorkingDay(LocalDate date) {
		while (!isWorkingDay(date)) {
			date = date.plusDays(1);
		}
		return date;
	}

	private boolean isWorkingDay(LocalDate date) {
		final DayOfWeek inputDay = date.getDayOfWeek();
		if (validWorkingDayList.contains(inputDay)) {
			return true;
		}
		return false;
	}

}
