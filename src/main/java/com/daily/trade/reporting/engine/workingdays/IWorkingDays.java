package com.daily.trade.reporting.engine.workingdays;

import java.time.LocalDate;

/**
 * @author Amrita_Sawhney
 *
 */
/*
 * Interface for Working Days
 */
public interface IWorkingDays {

	public LocalDate findNextWorkingDay(LocalDate date);

}
