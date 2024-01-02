package fi.tuni.prog3.sisu.course.fields;

import com.google.gson.annotations.SerializedName;

public class EvaluationCriteria{

	@SerializedName("fi")
	private String fi;

	public void setFi(String fi){
		this.fi = fi;
	}

	public String getFi(){
		return fi;
	}
}