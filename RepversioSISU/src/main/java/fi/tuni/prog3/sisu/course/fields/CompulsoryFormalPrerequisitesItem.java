package fi.tuni.prog3.sisu.course.fields;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CompulsoryFormalPrerequisitesItem{

	@SerializedName("prerequisites")
	private List<PrerequisitesItem> prerequisites;

	public void setPrerequisites(List<PrerequisitesItem> prerequisites){
		this.prerequisites = prerequisites;
	}

	public List<PrerequisitesItem> getPrerequisites(){
		return prerequisites;
	}
}