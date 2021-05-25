package com.kyumin.erpsystem.humanresource.domain;

public class Salary {
	private String paidDate;
	private int monthSalary;
	private double np;
	private double hi;
	private double ltc;
	private double ei;
	private double monthTotalPension;
	private double monthTotalSalary;
	
	public Salary(int monthSalary,String paidDate) {
		setPaidDate(paidDate); // 지급 날짜
		setMonthSalary(monthSalary); // 월급
		setNp(Math.round(monthSalary * 0.045)); //국민연금
		setHi(Math.round(monthSalary * 0.0343)); // 건강보험
		setLtc(Math.round(getHi() * 0.1152)); // 장기요양보
		setEi(Math.round(monthSalary * 0.008)); // 고용보험
		setMonthTotalPension(getNp()+getHi()+getLtc()+getEi()); // 총 세금 금액
		setMonthTotalSalary(monthSalary - getMonthTotalPension()); // 실수령액
	}

	/**
	 * @return the paidDate
	 */
	public String getPaidDate() {
		return paidDate;
	}

	/**
	 * @param paidDate the paidDate to set
	 */
	public void setPaidDate(String paidDate) {
		this.paidDate = paidDate;
	}

	/**
	 * @return the monthSalary
	 */
	public int getMonthSalary() {
		return monthSalary;
	}

	/**
	 * @param monthSalary the monthSalary to set
	 */
	public void setMonthSalary(int monthSalary) {
		this.monthSalary = monthSalary;
	}

	/**
	 * @return the np
	 */
	public double getNp() {
		return np;
	}

	/**
	 * @param np the np to set
	 */
	public void setNp(double np) {
		this.np = np;
	}

	/**
	 * @return the hi
	 */
	public double getHi() {
		return hi;
	}

	/**
	 * @param hi the hi to set
	 */
	public void setHi(double hi) {
		this.hi = hi;
	}

	/**
	 * @return the ltc
	 */
	public double getLtc() {
		return ltc;
	}

	/**
	 * @param ltc the ltc to set
	 */
	public void setLtc(double ltc) {
		this.ltc = ltc;
	}

	/**
	 * @return the ei
	 */
	public double getEi() {
		return ei;
	}

	/**
	 * @param ei the ei to set
	 */
	public void setEi(double ei) {
		this.ei = ei;
	}

	/**
	 * @return the monthTotalPension
	 */
	public double getMonthTotalPension() {
		return monthTotalPension;
	}

	/**
	 * @param monthTotalPension the monthTotalPension to set
	 */
	public void setMonthTotalPension(double monthTotalPension) {
		this.monthTotalPension = monthTotalPension;
	}

	/**
	 * @return the monthTotalSalary
	 */
	public double getMonthTotalSalary() {
		return monthTotalSalary;
	}

	/**
	 * @param monthTotalSalary the monthTotalSalary to set
	 */
	public void setMonthTotalSalary(double monthTotalSalary) {
		this.monthTotalSalary = monthTotalSalary;
	}
	
	
}
