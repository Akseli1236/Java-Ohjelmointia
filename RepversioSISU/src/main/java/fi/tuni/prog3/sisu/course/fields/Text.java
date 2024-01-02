package fi.tuni.prog3.sisu.course.fields;

import com.google.gson.annotations.SerializedName;

public class Text{

	@SerializedName("fi")
	private String fi;

	@SerializedName("en")
	private String en;

	public void setFi(String fi){
		this.fi = fi;
	}

	public String getFi(){
		return fi;
	}

	public void setEn(String en){
		this.en = en;
	}

	public String getEn(){
		return en;
	}
}