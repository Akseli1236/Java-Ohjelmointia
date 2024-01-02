package fi.tuni.prog3.sisu.course;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import fi.tuni.prog3.sisu.course.fields.*;

public class Course{

	@SerializedName("learningMaterial")
	private LearningMaterial learningMaterial;

	@SerializedName("possibleAttainmentLanguages")
	private List<String> possibleAttainmentLanguages;

	@SerializedName("metadata")
	private Metadata metadata;

	@SerializedName("code")
	private String code;

	@SerializedName("subject")
	private Object subject;

	@SerializedName("cefrLevel")
	private Object cefrLevel;

	@SerializedName("groupId")
	private String groupId;

	@SerializedName("additional")
	private Additional additional;

	@SerializedName("searchTags")
	private List<String> searchTags;

	@SerializedName("universityOrgIds")
	private List<String> universityOrgIds;

	@SerializedName("studyLevel")
	private String studyLevel;

	@SerializedName("content")
	private Content content;

	@SerializedName("validityPeriod")
	private ValidityPeriod validityPeriod;

	@SerializedName("prerequisites")
	private Prerequisites prerequisites;

	@SerializedName("categoryTags")
	private List<Object> categoryTags;

	@SerializedName("literature")
	private List<Object> literature;

	@SerializedName("compulsoryFormalPrerequisites")
	private List<CompulsoryFormalPrerequisitesItem> compulsoryFormalPrerequisites;

	@SerializedName("substitutions")
	private List<List<SubstitutionsItemItem>> substitutions;

	@SerializedName("organisations")
	private List<OrganisationsItem> organisations;

	@SerializedName("equivalentCoursesInfo")
	private EquivalentCoursesInfo equivalentCoursesInfo;

	@SerializedName("credits")
	private Credits credits;

	@SerializedName("outcomes")
	private Outcomes outcomes;

	@SerializedName("assessmentItemOrder")
	private List<String> assessmentItemOrder;

	@SerializedName("tweetText")
	private Object tweetText;

	@SerializedName("courseUnitType")
	private String courseUnitType;

	@SerializedName("id")
	private String id;

	@SerializedName("studyFields")
	private List<String> studyFields;

	@SerializedName("cooperationNetworkStatus")
	private Object cooperationNetworkStatus;

	@SerializedName("recommendedFormalPrerequisites")
	private List<Object> recommendedFormalPrerequisites;

	@SerializedName("inclusionApplicationInstruction")
	private Object inclusionApplicationInstruction;

	@SerializedName("approvalState")
	private String approvalState;

	@SerializedName("completionMethods")
	private List<CompletionMethodsItem> completionMethods;

	@SerializedName("abbreviation")
	private Object abbreviation;

	@SerializedName("documentState")
	private String documentState;

	@SerializedName("customCodeUrns")
	private CustomCodeUrns customCodeUrns;

	@SerializedName("responsibilityInfos")
	private List<ResponsibilityInfosItem> responsibilityInfos;

	@SerializedName("name")
	private Name name;

	@SerializedName("gradeScaleId")
	private String gradeScaleId;

	@SerializedName("cooperationNetworkIds")
	private Object cooperationNetworkIds;

	@SerializedName("curriculumPeriodIds")
	private List<String> curriculumPeriodIds;
	/*
	public Course(String filename) throws IOException {
		Gson gson = new Gson();
		Course course = new Course();
		gson.toJson(course, new FileWriter(filename));
	}
	public Course(){
	}*/


	public void setLearningMaterial(LearningMaterial learningMaterial){
		this.learningMaterial = learningMaterial;
	}

	public LearningMaterial getLearningMaterial(){
		return learningMaterial;
	}

	public void setPossibleAttainmentLanguages(List<String> possibleAttainmentLanguages){
		this.possibleAttainmentLanguages = possibleAttainmentLanguages;
	}

	public List<String> getPossibleAttainmentLanguages(){
		return possibleAttainmentLanguages;
	}

	public void setMetadata(Metadata metadata){
		this.metadata = metadata;
	}

	public Metadata getMetadata(){
		return metadata;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setSubject(Object subject){
		this.subject = subject;
	}

	public Object getSubject(){
		return subject;
	}

	public void setCefrLevel(Object cefrLevel){
		this.cefrLevel = cefrLevel;
	}

	public Object getCefrLevel(){
		return cefrLevel;
	}

	public void setGroupId(String groupId){
		this.groupId = groupId;
	}

	public String getGroupId(){
		return groupId;
	}

	public void setAdditional(Additional additional){
		this.additional = additional;
	}

	public Additional getAdditional(){
		return additional;
	}

	public void setSearchTags(List<String> searchTags){
		this.searchTags = searchTags;
	}

	public List<String> getSearchTags(){
		return searchTags;
	}

	public void setUniversityOrgIds(List<String> universityOrgIds){
		this.universityOrgIds = universityOrgIds;
	}

	public List<String> getUniversityOrgIds(){
		return universityOrgIds;
	}

	public void setStudyLevel(String studyLevel){
		this.studyLevel = studyLevel;
	}

	public String getStudyLevel(){
		return studyLevel;
	}

	public void setContent(Content content){
		this.content = content;
	}

	public Content getContent(){
		return content;
	}

	public void setValidityPeriod(ValidityPeriod validityPeriod){
		this.validityPeriod = validityPeriod;
	}

	public ValidityPeriod getValidityPeriod(){
		return validityPeriod;
	}

	public void setPrerequisites(Prerequisites prerequisites){
		this.prerequisites = prerequisites;
	}

	public Prerequisites getPrerequisites(){
		return prerequisites;
	}

	public void setCategoryTags(List<Object> categoryTags){
		this.categoryTags = categoryTags;
	}

	public List<Object> getCategoryTags(){
		return categoryTags;
	}

	public void setLiterature(List<Object> literature){
		this.literature = literature;
	}

	public List<Object> getLiterature(){
		return literature;
	}

	public void setCompulsoryFormalPrerequisites(List<CompulsoryFormalPrerequisitesItem> compulsoryFormalPrerequisites){
		this.compulsoryFormalPrerequisites = compulsoryFormalPrerequisites;
	}

	public List<CompulsoryFormalPrerequisitesItem> getCompulsoryFormalPrerequisites(){
		return compulsoryFormalPrerequisites;
	}

	public void setSubstitutions(List<List<SubstitutionsItemItem>> substitutions){
		this.substitutions = substitutions;
	}

	public List<List<SubstitutionsItemItem>> getSubstitutions(){
		return substitutions;
	}

	public void setOrganisations(List<OrganisationsItem> organisations){
		this.organisations = organisations;
	}

	public List<OrganisationsItem> getOrganisations(){
		return organisations;
	}

	public void setEquivalentCoursesInfo(EquivalentCoursesInfo equivalentCoursesInfo){
		this.equivalentCoursesInfo = equivalentCoursesInfo;
	}

	public EquivalentCoursesInfo getEquivalentCoursesInfo(){
		return equivalentCoursesInfo;
	}

	public void setCredits(Credits credits){
		this.credits = credits;
	}

	public Credits getCredits(){
		return credits;
	}

	public void setOutcomes(Outcomes outcomes){
		this.outcomes = outcomes;
	}

	public Outcomes getOutcomes(){
		return outcomes;
	}

	public void setAssessmentItemOrder(List<String> assessmentItemOrder){
		this.assessmentItemOrder = assessmentItemOrder;
	}

	public List<String> getAssessmentItemOrder(){
		return assessmentItemOrder;
	}

	public void setTweetText(Object tweetText){
		this.tweetText = tweetText;
	}

	public Object getTweetText(){
		return tweetText;
	}

	public void setCourseUnitType(String courseUnitType){
		this.courseUnitType = courseUnitType;
	}

	public String getCourseUnitType(){
		return courseUnitType;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setStudyFields(List<String> studyFields){
		this.studyFields = studyFields;
	}

	public List<String> getStudyFields(){
		return studyFields;
	}

	public void setCooperationNetworkStatus(Object cooperationNetworkStatus){
		this.cooperationNetworkStatus = cooperationNetworkStatus;
	}

	public Object getCooperationNetworkStatus(){
		return cooperationNetworkStatus;
	}

	public void setRecommendedFormalPrerequisites(List<Object> recommendedFormalPrerequisites){
		this.recommendedFormalPrerequisites = recommendedFormalPrerequisites;
	}

	public List<Object> getRecommendedFormalPrerequisites(){
		return recommendedFormalPrerequisites;
	}

	public void setInclusionApplicationInstruction(Object inclusionApplicationInstruction){
		this.inclusionApplicationInstruction = inclusionApplicationInstruction;
	}

	public Object getInclusionApplicationInstruction(){
		return inclusionApplicationInstruction;
	}

	public void setApprovalState(String approvalState){
		this.approvalState = approvalState;
	}

	public String getApprovalState(){
		return approvalState;
	}

	public void setCompletionMethods(List<CompletionMethodsItem> completionMethods){
		this.completionMethods = completionMethods;
	}

	public List<CompletionMethodsItem> getCompletionMethods(){
		return completionMethods;
	}

	public void setAbbreviation(Object abbreviation){
		this.abbreviation = abbreviation;
	}

	public Object getAbbreviation(){
		return abbreviation;
	}

	public void setDocumentState(String documentState){
		this.documentState = documentState;
	}

	public String getDocumentState(){
		return documentState;
	}

	public void setCustomCodeUrns(CustomCodeUrns customCodeUrns){
		this.customCodeUrns = customCodeUrns;
	}

	public CustomCodeUrns getCustomCodeUrns(){
		return customCodeUrns;
	}

	public void setResponsibilityInfos(List<ResponsibilityInfosItem> responsibilityInfos){
		this.responsibilityInfos = responsibilityInfos;
	}

	public List<ResponsibilityInfosItem> getResponsibilityInfos(){
		return responsibilityInfos;
	}

	public void setName(Name name){
		this.name = name;
	}

	public Name getName(){
		return name;
	}

	public void setGradeScaleId(String gradeScaleId){
		this.gradeScaleId = gradeScaleId;
	}

	public String getGradeScaleId(){
		return gradeScaleId;
	}

	public void setCooperationNetworkIds(Object cooperationNetworkIds){
		this.cooperationNetworkIds = cooperationNetworkIds;
	}

	public Object getCooperationNetworkIds(){
		return cooperationNetworkIds;
	}

	public void setCurriculumPeriodIds(List<String> curriculumPeriodIds){
		this.curriculumPeriodIds = curriculumPeriodIds;
	}

	public List<String> getCurriculumPeriodIds(){
		return curriculumPeriodIds;
	}


}