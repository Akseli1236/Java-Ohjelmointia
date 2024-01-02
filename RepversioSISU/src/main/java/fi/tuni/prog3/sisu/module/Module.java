package fi.tuni.prog3.sisu.module;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import fi.tuni.prog3.sisu.module.fields.Metadata;
import fi.tuni.prog3.sisu.module.fields.Name;
import fi.tuni.prog3.sisu.module.fields.Rule;

public class Module{

	@SerializedName("metadata")
	private Metadata metadata;

	@SerializedName("code")
	private Object code;

	@SerializedName("groupId")
	private String groupId;

	@SerializedName("name")
	private Name name;

	@SerializedName("universityOrgIds")
	private List<String> universityOrgIds;

	@SerializedName("rule")
	private Rule rule;

	@SerializedName("id")
	private String id;

	@SerializedName("type")
	private String type;

	@SerializedName("documentState")
	private String documentState;

	@SerializedName("contentFilter")
	private Object contentFilter;

	@SerializedName("moduleContentApprovalRequired")
	private boolean moduleContentApprovalRequired;

	@SerializedName("curriculumPeriodIds")
	private List<Object> curriculumPeriodIds;

	public void setMetadata(Metadata metadata){
		this.metadata = metadata;
	}

	public Metadata getMetadata(){
		return metadata;
	}

	public void setCode(Object code){
		this.code = code;
	}

	public Object getCode(){
		return code;
	}

	public void setGroupId(String groupId){
		this.groupId = groupId;
	}

	public String getGroupId(){
		return groupId;
	}

	public void setName(Name name){
		this.name = name;
	}

	public Name getName(){
		return name;
	}

	public void setUniversityOrgIds(List<String> universityOrgIds){
		this.universityOrgIds = universityOrgIds;
	}

	public List<String> getUniversityOrgIds(){
		return universityOrgIds;
	}

	public void setRule(Rule rule){
		this.rule = rule;
	}

	public Rule getRule(){
		return rule;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setDocumentState(String documentState){
		this.documentState = documentState;
	}

	public String getDocumentState(){
		return documentState;
	}

	public void setContentFilter(Object contentFilter){
		this.contentFilter = contentFilter;
	}

	public Object getContentFilter(){
		return contentFilter;
	}

	public void setModuleContentApprovalRequired(boolean moduleContentApprovalRequired){
		this.moduleContentApprovalRequired = moduleContentApprovalRequired;
	}

	public boolean isModuleContentApprovalRequired(){
		return moduleContentApprovalRequired;
	}

	public void setCurriculumPeriodIds(List<Object> curriculumPeriodIds){
		this.curriculumPeriodIds = curriculumPeriodIds;
	}

	public List<Object> getCurriculumPeriodIds(){
		return curriculumPeriodIds;
	}
}