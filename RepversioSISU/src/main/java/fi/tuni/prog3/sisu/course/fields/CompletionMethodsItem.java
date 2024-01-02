package fi.tuni.prog3.sisu.course.fields;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CompletionMethodsItem{

	@SerializedName("assessmentItemIds")
	private List<String> assessmentItemIds;

	@SerializedName("prerequisites")
	private Object prerequisites;

	@SerializedName("repeats")
	private List<RepeatsItem> repeats;

	@SerializedName("automaticEvaluation")
	private boolean automaticEvaluation;

	@SerializedName("studyType")
	private String studyType;

	@SerializedName("evaluationCriteria")
	private EvaluationCriteria evaluationCriteria;

	@SerializedName("description")
	private Description description;

	@SerializedName("assessmentItemOptionalityDescription")
	private Object assessmentItemOptionalityDescription;

	@SerializedName("require")
	private Object require;

	@SerializedName("localId")
	private String localId;

	@SerializedName("typeOfRequire")
	private String typeOfRequire;

	public void setAssessmentItemIds(List<String> assessmentItemIds){
		this.assessmentItemIds = assessmentItemIds;
	}

	public List<String> getAssessmentItemIds(){
		return assessmentItemIds;
	}

	public void setPrerequisites(Object prerequisites){
		this.prerequisites = prerequisites;
	}

	public Object getPrerequisites(){
		return prerequisites;
	}

	public void setRepeats(List<RepeatsItem> repeats){
		this.repeats = repeats;
	}

	public List<RepeatsItem> getRepeats(){
		return repeats;
	}

	public void setAutomaticEvaluation(boolean automaticEvaluation){
		this.automaticEvaluation = automaticEvaluation;
	}

	public boolean isAutomaticEvaluation(){
		return automaticEvaluation;
	}

	public void setStudyType(String studyType){
		this.studyType = studyType;
	}

	public String getStudyType(){
		return studyType;
	}

	public void setEvaluationCriteria(EvaluationCriteria evaluationCriteria){
		this.evaluationCriteria = evaluationCriteria;
	}

	public EvaluationCriteria getEvaluationCriteria(){
		return evaluationCriteria;
	}

	public void setDescription(Description description){
		this.description = description;
	}

	public Description getDescription(){
		return description;
	}

	public void setAssessmentItemOptionalityDescription(Object assessmentItemOptionalityDescription){
		this.assessmentItemOptionalityDescription = assessmentItemOptionalityDescription;
	}

	public Object getAssessmentItemOptionalityDescription(){
		return assessmentItemOptionalityDescription;
	}

	public void setRequire(Object require){
		this.require = require;
	}

	public Object getRequire(){
		return require;
	}

	public void setLocalId(String localId){
		this.localId = localId;
	}

	public String getLocalId(){
		return localId;
	}

	public void setTypeOfRequire(String typeOfRequire){
		this.typeOfRequire = typeOfRequire;
	}

	public String getTypeOfRequire(){
		return typeOfRequire;
	}
}