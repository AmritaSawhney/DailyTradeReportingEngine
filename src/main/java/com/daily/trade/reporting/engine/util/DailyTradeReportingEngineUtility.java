package com.daily.trade.reporting.engine.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.daily.trade.reporting.engine.config.InstructionReportConstants;
import com.daily.trade.reporting.engine.model.Instruction;
import com.daily.trade.reporting.engine.workingdays.AEDOrSARSpecificWorkingdays;
import com.daily.trade.reporting.engine.workingdays.NormalWorkingdays;

/**
 * @author Amrita_Sawhney
 *
 */
/*
 * Utility class for Daily Trade Reporting Engine
 */
public class DailyTradeReportingEngineUtility {

	//setting valid working day for settlement date for each transaction
	public static void setValidInstructionSettlementDate(List<Instruction> instructionList) {
		instructionList.forEach(instruction -> {
			if (instruction.getCurrency().equals(InstructionReportConstants.CURRENCY_AED)
					|| instruction.getCurrency().equals(InstructionReportConstants.CURRENCY_SAR))
				instruction.setSettlementDate(
						AEDOrSARSpecificWorkingdays.getInstance().findNextWorkingDay(instruction.getSettlementDate()));
			else
				instruction.setSettlementDate(
						NormalWorkingdays.getInstance().findNextWorkingDay(instruction.getSettlementDate()));
		});
	}

	//calculate the instruction amount in USD for each settlement date(incoming/outgoing)
	public static Map<LocalDate, BigDecimal> calculateInsSettlementAmt(List<Instruction> instructionList) {
		Map<LocalDate, BigDecimal> incomingAmtMap = new HashMap<>();
		BigDecimal totalEntityPrice = BigDecimal.ZERO;
		for (Instruction instruction : instructionList) {
			if (incomingAmtMap.containsKey(instruction.getSettlementDate())) {
				totalEntityPrice = instruction.getTotalEntityPrice()
						.add(incomingAmtMap.get(instruction.getSettlementDate()));
				incomingAmtMap.put(instruction.getSettlementDate(), totalEntityPrice);
			} else {
				incomingAmtMap.put(instruction.getSettlementDate(), instruction.getTotalEntityPrice());
			}
		}
		return incomingAmtMap;
	}

	//calculate the ranking of different entities for each settlement date (incoming/outgoing settlement)
	public static Map<LocalDate, List<Instruction>> calculateInsSettlementAmtRank(List<Instruction> instructionList) {

		Collections.sort(instructionList, new Comparator<Instruction>() {

			public int compare(Instruction o1, Instruction o2) {

				LocalDate s1 = ((Instruction) o1).getSettlementDate();
				LocalDate s2 = ((Instruction) o2).getSettlementDate();
				int sComp = s1.compareTo(s2);

				if (sComp != 0) {
					return sComp;
				} else {
					BigDecimal x1 = ((Instruction) o1).getTotalEntityPrice();
					BigDecimal x2 = ((Instruction) o2).getTotalEntityPrice();
					return x1.compareTo(x2);
				}
			}

		});

		Map<LocalDate, List<Instruction>> instrMap = new LinkedHashMap<>();
		List<Instruction> instList = null;
		int rank = 0;
		for (Instruction instr : instructionList) {
			if (instrMap.containsKey(instr.getSettlementDate())) {
				rank++;
				instr.setRank(rank);
				instList.add(instr);
				instrMap.put(instr.getSettlementDate(), instList);
			} else {
				instList = new ArrayList<Instruction>();
				rank = 1;
				instr.setRank(rank);
				instList.add(instr);
				instrMap.put(instr.getSettlementDate(), instList);
			}
		}

		return instrMap;
	}
}
