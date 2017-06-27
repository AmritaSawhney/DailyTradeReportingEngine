package com.daily.trade.reporting.engine.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Amrita_Sawhney
 *
 */
/*
 * Model class to represt Instruction
 */
public class Instruction {

	private String entity;

	private String instruction;

	private BigDecimal agreedFx;

	private String currency;

	private LocalDate instructionDate;

	private LocalDate settlementDate;

	private int units;

	private BigDecimal unitPrice;

	private BigDecimal totalEntityPrice;

	private int rank;

	public Instruction()
	{
		
	}
	
	/**
	 * @return the entity
	 */
	public String getEntity() {
		return entity;
	}

	/**
	 * @param entity
	 *            the entity to set
	 */
	public void setEntity(String entity) {
		this.entity = entity;
	}

	/**
	 * @return the instruction
	 */
	public String getInstruction() {
		return instruction;
	}

	/**
	 * @param instruction
	 *            the instruction to set
	 */
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the unitPrice
	 */
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	/**
	 * @param unitPrice
	 *            the unitPrice to set
	 */
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * @return the instructionDate
	 */
	public LocalDate getInstructionDate() {
		return instructionDate;
	}

	/**
	 * @param instructionDate
	 *            the instructionDate to set
	 */
	public void setInstructionDate(LocalDate instructionDate) {
		this.instructionDate = instructionDate;
	}

	/**
	 * @return the settlementDate
	 */
	public LocalDate getSettlementDate() {
		return settlementDate;
	}

	/**
	 * @param settlementDate
	 *            the settlementDate to set
	 */
	public void setSettlementDate(LocalDate settlementDate) {
		this.settlementDate = settlementDate;
	}

	/**
	 * @return the agreedFx
	 */
	public BigDecimal getAgreedFx() {
		return agreedFx;
	}

	/**
	 * @param agreedFx
	 *            the agreedFx to set
	 */
	public void setAgreedFx(BigDecimal agreedFx) {
		this.agreedFx = agreedFx;
	}

	/**
	 * @return the totalEntityPrice
	 */
	public BigDecimal getTotalEntityPrice() {
		return totalEntityPrice;
	}

	/**
	 * @param totalEntityPrice
	 *            the totalEntityPrice to set
	 */
	public void setTotalEntityPrice(BigDecimal totalEntityPrice) {
		this.totalEntityPrice = totalEntityPrice;
	}

	/**
	 * @return the units
	 */
	public int getUnits() {
		return units;
	}

	/**
	 * @param units
	 *            the units to set
	 */
	public void setUnits(int units) {
		this.units = units;
	}

	/**
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * @param rank
	 *            the rank to set
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Instruction [entity=" + entity + ", instruction=" + instruction + ", agreedFx=" + agreedFx
				+ ", currency=" + currency + ", instructionDate=" + instructionDate + ", settlementDate="
				+ settlementDate + ", units=" + units + ", unitPrice=" + unitPrice + ", totalEntityPrice="
				+ totalEntityPrice + ", rank=" + rank + "]";
	}

}
