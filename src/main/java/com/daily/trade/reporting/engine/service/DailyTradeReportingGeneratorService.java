package com.daily.trade.reporting.engine.service;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.daily.trade.reporting.engine.config.InstructionReportConstants;
import com.daily.trade.reporting.engine.model.Instruction;
import com.daily.trade.reporting.engine.util.DailyTradeReportingEngineUtility;

/**
 * @author Amrita_Sawhney
 *
 */
/*
 * Class containing business logic to process the instructions and display the
 * reports generated on console
 */
public class DailyTradeReportingGeneratorService {

	public void processReportData() {
		// Initialize the dummy data
		List<Instruction> instructionList = initializeDummyInputData();

		// Call utility method to set settlement date for each instruction
		DailyTradeReportingEngineUtility.setValidInstructionSettlementDate(instructionList);

		// Call method to get the list each for buyer/seller
		Map<String, List<Instruction>> instrMap = getInstructionBuyerOrSellerDtls(instructionList);

		// Generate report for incoming amount in USD settled everyday
		generateIncomingAmtReport(DailyTradeReportingEngineUtility
				.calculateInsSettlementAmt(instrMap.get(InstructionReportConstants.SELL_INSTRUCTION)));

		// Generate report for outgoing amount in USD settled everyday
		generateOutgoingAmtReport(DailyTradeReportingEngineUtility
				.calculateInsSettlementAmt(instrMap.get(InstructionReportConstants.BUY_INSTRUCTION)));

		// Generate report for ranking of entities for incoming amount in USD
		generateIncomingRankingReport(DailyTradeReportingEngineUtility
				.calculateInsSettlementAmtRank((instrMap.get(InstructionReportConstants.SELL_INSTRUCTION))));

		// Generate report for ranking of entities for outgoing amount in USD
		generateOutgoingRankingReport(DailyTradeReportingEngineUtility
				.calculateInsSettlementAmtRank((instrMap.get(InstructionReportConstants.BUY_INSTRUCTION))));

	}

	private static void generateIncomingAmtReport(Map<LocalDate, BigDecimal> incomingAmtMap) {
		System.out.println("----------Printing Incoming Amount Report---------------");
		System.out.println("SettlementDate      TotalIncomingAmount");
		for (LocalDate settlementDate : incomingAmtMap.keySet()) {
			System.out.println(settlementDate + "         " + incomingAmtMap.get(settlementDate));
		}
	}

	private static void generateOutgoingAmtReport(Map<LocalDate, BigDecimal> outgoingAmtMap) {
		System.out.println("----------Printing Outgoing Amount Report---------------");
		System.out.println("SettlementDate      TotalOutgoingAmount");
		for (LocalDate settlementDate : outgoingAmtMap.keySet()) {
			System.out.println(settlementDate + "         " + outgoingAmtMap.get(settlementDate));
		}
	}

	private static Map<String, List<Instruction>> getInstructionBuyerOrSellerDtls(List<Instruction> instructionList) {
		Map<String, List<Instruction>> instructionMap = new HashMap<>();
		List<Instruction> buyerList = new ArrayList<>();
		List<Instruction> sellerList = new ArrayList<>();
		for (Instruction instr : instructionList) {
			if (instr.getInstruction().equals("B")) {
				buyerList.add(instr);
			} else {
				sellerList.add(instr);
			}
		}
		instructionMap.put("BUY", buyerList);
		instructionMap.put("SELL", sellerList);
		return instructionMap;
	}

	private static void generateIncomingRankingReport(Map<LocalDate, List<Instruction>> instructionMap) {

		System.out.println("----------Printing Incoming Amt Ranking Report---------------");
		System.out.println("SettlementDate" + "|" + "Entity" + "|" + "TotalEntityPrice" + "|" + "Rank");
		for (LocalDate settlementDate : instructionMap.keySet()) {
			for (Instruction instr : instructionMap.get(settlementDate))
				System.out.println(settlementDate + "|" + instr.getEntity() + "|" + instr.getTotalEntityPrice() + "|"
						+ instr.getRank());
		}
	}

	private static void generateOutgoingRankingReport(Map<LocalDate, List<Instruction>> instructionMap) {

		System.out.println("----------Printing Outgoing Amt Ranking Report---------------");
		System.out.println("SettlementDate" + "|" + "Entity" + "|" + "TotalEntityPrice" + "|" + "Rank");
		for (LocalDate settlementDate : instructionMap.keySet()) {
			for (Instruction instr : instructionMap.get(settlementDate))
				System.out.println(settlementDate + "|" + instr.getEntity() + "|" + instr.getTotalEntityPrice() + "|"
						+ instr.getRank());
		}
	}

	private static List<Instruction> initializeDummyInputData() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("DDMMMyyyy");
		List<Instruction> instructionList = new ArrayList<>();
		Instruction instruction = null;
		try (Scanner scanner = new Scanner(new File("src/main/resources/samplefile.txt"))) {
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] values = line.split("\\|");
				instruction = new Instruction();
				instruction.setEntity(values[0]);
				instruction.setInstruction(values[1]);
				instruction.setAgreedFx(new BigDecimal(values[2]));
				instruction.setCurrency(values[3]);
				if (values[4] != null)
					instruction.setInstructionDate(LocalDate.parse(values[4], dtf));
				if (values[5] != null)
					instruction.setSettlementDate(LocalDate.parse(values[5], dtf));
				if (values[6] != null)
					instruction.setUnits(Integer.parseInt(values[6]));
				if (values[7] != null)
					instruction.setUnitPrice(new BigDecimal(values[7]));
				BigDecimal totalEntityPrice = instruction.getUnitPrice().multiply(instruction.getAgreedFx())
						.multiply(BigDecimal.valueOf(instruction.getUnits()));
				instruction.setTotalEntityPrice(totalEntityPrice);
				instructionList.add(instruction);
			}

		} catch (Exception ex) {
			System.out.println("Exception occured in application while reading csv data" + ex);
		}
		return instructionList;
	}

}
