package com.daily.trade.reporting.engine.util;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.daily.trade.reporting.engine.model.Instruction;

public class DailyTradeReportingEngineUtilityTest {

	private List<Instruction> instrList = null;

	@Before
	public void setUp() {
		instrList = setUpInitialData();
	}

	private List<Instruction> setUpInitialData() {
		Instruction instruction = new Instruction();
		List<Instruction> instrList = new ArrayList<>();
		instruction.setAgreedFx(new BigDecimal(0.20));
		instruction.setCurrency("AED");
		instruction.setEntity("foo");
		instruction.setInstruction("B");
		instruction.setInstructionDate(LocalDate.of(2017, 6, 20));
		instruction.setSettlementDate(LocalDate.of(2017, 6, 23));
		instruction.setTotalEntityPrice(new BigDecimal(20.00));
		instruction.setUnitPrice(new BigDecimal(10));
		instruction.setUnits(10);
		instrList.add(instruction);
		return instrList;
	}

	@Test
	public void testSetValidInstructionSettlementDate_AED() {

		DailyTradeReportingEngineUtility.setValidInstructionSettlementDate(instrList);
		assertEquals(instrList.get(0).getSettlementDate(), LocalDate.of(2017, 6, 25));

	}

	@Test
	public void testSetValidInstructionSettlementDate_Default() {

		DailyTradeReportingEngineUtility.setValidInstructionSettlementDate(instrList);
		assertEquals(instrList.get(0).getSettlementDate(), LocalDate.of(2017, 6, 25));

	}

	@Test
	public void testCalculateInsSettlementAmt() {

		Map<LocalDate, BigDecimal> instrMap = DailyTradeReportingEngineUtility.calculateInsSettlementAmt(instrList);
		assertEquals(instrMap.get(LocalDate.of(2017, 6, 23)), new BigDecimal(20.00));

	}

}
