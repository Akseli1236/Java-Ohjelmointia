package fi.tuni.prog3.sisu.course.fields;

import com.google.gson.annotations.SerializedName;

public class PrerequisitesItem{

	@SerializedName("courseUnitGroupId")
	private String courseUnitGroupId;

	@SerializedName("type")
	private String type;

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
}