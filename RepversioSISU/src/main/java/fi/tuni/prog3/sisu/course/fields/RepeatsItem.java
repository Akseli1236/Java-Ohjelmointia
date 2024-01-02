package fi.tuni.prog3.sisu.course.fields;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RepeatsItem{

	@SerializedName("studyYearRange")
	private StudyYearRange studyYearRange;

	@SerializedName("repeatPossibility")
	private List<String> repeatPossibility;

	@SerializedName("yearInterval")
	private Object yearInterval;

	public void setStudyYearRange(StudyYearRange studyYearRange){
		this.studyYearRange = studyYearRange;
	}

	public StudyYearRange getStudyYearRange(){
		return studyYearRange;
	}

	public void setRepeatPossibility(List<String> repeatPossibility){
		this.repeatPossibility = repeatPossibility;
	}

	public List<String> getRepeatPossibility(){
		return repeatPossibility;
	}

	public void setYearInterval(Object yearInterval){
		this.yearInterval = yearInterval;
	}

	public Object getYearInterval(){
		return yearInterval;
	}
}