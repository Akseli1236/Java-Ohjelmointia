package fi.tuni.prog3.sisu.course.fields;

import com.google.gson.annotations.SerializedName;

public class SubstitutionsItemItem{

	@SerializedName("courseUnitGroupId")
	private String courseUnitGroupId;

	@SerializedName("credits")
	private Object credits;

	public void setCourseUnitGroupId(String courseUnitGroupId){
		this.courseUnitGroupId = courseUnitGroupId;
	}

	public String getCourseUnitGroupId(){
		return courseUnitGroupId;
	}

	public void setCredits(Object credits){
		this.credits = credits;
	}

	public Object getCredits(){
		return credits;
	}
}