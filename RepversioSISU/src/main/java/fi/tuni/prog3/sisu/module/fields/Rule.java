package fi.tuni.prog3.sisu.module.fields;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Rule{

	@SerializedName("allMandatory")
	private boolean allMandatory;

	@SerializedName("description")
	private Object description;

	@SerializedName("rules")
	private List<RulesItem> rules;

	@SerializedName("require")
	private Object require;

	@SerializedName("type")
	private String type;

	@SerializedName("localId")
	private String localId;

	public void setAllMandatory(boolean allMandatory){
		this.allMandatory = allMandatory;
	}

	public boolean isAllMandatory(){
		return allMandatory;
	}

	public void setDescription(Object description){
		this.description = description;
	}

	public Object getDescription(){
		return description;
	}

	public void setRules(List<RulesItem> rules){
		this.rules = rules;
	}

	public List<RulesItem> getRules(){
		return rules;
	}

	public void setRequire(Object require){
		this.require = require;
	}

	public Object getRequire(){
		return require;
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