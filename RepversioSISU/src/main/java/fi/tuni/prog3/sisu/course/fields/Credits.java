package fi.tuni.prog3.sisu.course.fields;

import com.google.gson.annotations.SerializedName;

public class Credits{

	@SerializedName("min")
	private int min;

	@SerializedName("max")
	private int max;

	public void setMin(int min){
		this.min = min;
	}

	public int getMin(){
		return min;
	}

	public void setMax(int max){
		this.max = max;
	}

	public int getMax(){
		return max;
	}
}