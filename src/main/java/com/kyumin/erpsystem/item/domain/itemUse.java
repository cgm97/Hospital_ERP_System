package com.kyumin.erpsystem.item.domain;

public class itemUse {
	private String drugName;
	private int drugCode;
	private String drugType;
	private int useCount;

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public int getDrugCode() {
		return drugCode;
	}

	public void setDrugCode(int drugCode) {
		this.drugCode = drugCode;
	}

	public String getDrugType() {
		return drugType;
	}

	public void setDrugType(String drugType) {
		this.drugType = drugType;
	}

	public int getUseCount() {
		return useCount;
	}

	public void setUseCount(int useCount) {
		this.useCount = useCount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "itemUse [drugName=" + drugName + ", drugCode=" + drugCode + ", drugType=" + drugType + ", useCount="
				+ useCount + "]";
	}
}
