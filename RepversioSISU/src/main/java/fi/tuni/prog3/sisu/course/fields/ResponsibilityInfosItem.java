package fi.tuni.prog3.sisu.course.fields;

import com.google.gson.annotations.SerializedName;

public class ResponsibilityInfosItem{

	@SerializedName("validityPeriod")
	private ValidityPeriod validityPeriod;

	@SerializedName("personId")
	private String personId;

	@SerializedName("roleUrn")
	private String roleUrn;

	@SerializedName("text")
	private Text text;

	public void setValidityPeriod(ValidityPeriod validityPeriod){
		this.validityPeriod = validityPeriod;
	}

	public ValidityPeriod getValidityPeriod(){
		return validityPeriod;
	}

	public void setPersonId(String personId){
		this.personId = personId;
	}

	public String getPersonId(){
		return personId;
	}

	public void setRoleUrn(String roleUrn){
		this.roleUrn = roleUrn;
	}

	public String getRoleUrn(){
		return roleUrn;
	}

	public void setText(Text text){
		this.text = text;
	}

	public Text getText(){
		return text;
	}
}