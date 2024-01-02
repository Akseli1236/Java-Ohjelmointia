package fi.tuni.prog3.sisu.course.fields;

import com.google.gson.annotations.SerializedName;

public class OrganisationsItem{

	@SerializedName("validityPeriod")
	private ValidityPeriod validityPeriod;

	@SerializedName("organisationId")
	private String organisationId;

	@SerializedName("roleUrn")
	private String roleUrn;

	@SerializedName("share")
	private int share;

	@SerializedName("educationalInstitutionUrn")
	private Object educationalInstitutionUrn;

	public void setValidityPeriod(ValidityPeriod validityPeriod){
		this.validityPeriod = validityPeriod;
	}

	public ValidityPeriod getValidityPeriod(){
		return validityPeriod;
	}

	public void setOrganisationId(String organisationId){
		this.organisationId = organisationId;
	}

	public String getOrganisationId(){
		return organisationId;
	}

	public void setRoleUrn(String roleUrn){
		this.roleUrn = roleUrn;
	}

	public String getRoleUrn(){
		return roleUrn;
	}

	public void setShare(int share){
		this.share = share;
	}

	public int getShare(){
		return share;
	}

	public void setEducationalInstitutionUrn(Object educationalInstitutionUrn){
		this.educationalInstitutionUrn = educationalInstitutionUrn;
	}

	public Object getEducationalInstitutionUrn(){
		return educationalInstitutionUrn;
	}
}