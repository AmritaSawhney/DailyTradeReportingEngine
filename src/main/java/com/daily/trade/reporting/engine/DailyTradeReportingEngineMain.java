package com.daily.trade.reporting.engine;

import com.daily.trade.reporting.engine.service.DailyTradeReportingGeneratorService;

/**
 * @author Amrita_Sawhney
 *
 */
/*
 * Main Class for DailyTradeReportingEngine
 */
public class DailyTradeReportingEngineMain {

	public static void main(String[] args) {
		//Call the process Report Data method to process and display report on console
		new DailyTradeReportingGeneratorService().processReportData();
	}

}
