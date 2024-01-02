package fi.tuni.prog3.sisu.module.fields;

import com.google.gson.annotations.SerializedName;

public class RulesItem{

	@SerializedName("courseUnitGroupId")
	private String courseUnitGroupId;

	@SerializedName("type")
	private String type;

	@SerializedName("localId")
	private String localId;

	public void setCourseUnitGroupId(String courseUnitGroupId){
		this.courseUnitGroupId = courseUnitGroupId;
	}

	public String getCourseUnitGroupId(){
		return courseUnitGroupId;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setLocalId(String localId){
		this.localId = localId;
	}

	public String getLocalId(){
		return localId;
	}
}