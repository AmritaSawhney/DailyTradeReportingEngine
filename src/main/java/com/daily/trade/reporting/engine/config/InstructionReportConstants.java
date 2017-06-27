package com.daily.trade.reporting.engine.config;

/**
 * @author Amrita_Sawhney
 *
 */
/*
 * Constants class for the Daily Trade Reporting Engine
 */
public class InstructionReportConstants {

	/**
	 * private constructor to prevent class instantiation
	 */
	private InstructionReportConstants() {
		// Not Called
	}

	/** The Constant Default Config Directory Path */
	public static final String DEFAULT_CONFIG_PATH = "./src/main/resources/application.properties";

	/** The Constant BLANK_STR. */
	public static final String BLANK_STR = "";

	/** The Constant CURRENCY_AED. */
	public static final String CURRENCY_AED = "AED";

	/** The Constant CURRENCY_SAR. */
	public static final String CURRENCY_SAR = "SAR";

	/** The Constant BUY_INSTRUCTION . */
	public static final String BUY_INSTRUCTION = "BUY";

	/** The Constant SELL_INSTRUCTION . */
	public static final String SELL_INSTRUCTION = "SELL";

}
