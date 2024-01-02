package fi.tuni.prog3.sisu.course.fields;

import com.google.gson.annotations.SerializedName;

public class ValidityPeriod{

	@SerializedName("startDate")
	private String startDate;

	@SerializedName("endDate")
	private String endDate;

	public void setStartDate(String startDate){
		this.startDate = startDate;
	}

	public String getStartDate(){
		return startDate;
	}

	public void setEndDate(String endDate){
		this.endDate = endDate;
	}

	public String getEndDate(){
		return endDate;
	}
}