package fi.tuni.prog3.sisu.course.fields;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CustomCodeUrns{

	@SerializedName("urn:code:custom:tuni-university-root-id:offering-location")
	private List<String> urnCodeCustomTuniUniversityRootIdOfferingLocation;

	@SerializedName("urn:code:custom:tuni-university-root-id:tentit")
	private List<String> urnCodeCustomTuniUniversityRootIdTentit;

	@SerializedName("urn:code:custom:tuni-university-root-id:offering-information")
	private List<String> urnCodeCustomTuniUniversityRootIdOfferingInformation;

	public void setUrnCodeCustomTuniUniversityRootIdOfferingLocation(List<String> urnCodeCustomTuniUniversityRootIdOfferingLocation){
		this.urnCodeCustomTuniUniversityRootIdOfferingLocation = urnCodeCustomTuniUniversityRootIdOfferingLocation;
	}

	public List<String> getUrnCodeCustomTuniUniversityRootIdOfferingLocation(){
		return urnCodeCustomTuniUniversityRootIdOfferingLocation;
	}

	public void setUrnCodeCustomTuniUniversityRootIdTentit(List<String> urnCodeCustomTuniUniversityRootIdTentit){
		this.urnCodeCustomTuniUniversityRootIdTentit = urnCodeCustomTuniUniversityRootIdTentit;
	}

	public List<String> getUrnCodeCustomTuniUniversityRootIdTentit(){
		return urnCodeCustomTuniUniversityRootIdTentit;
	}

	public void setUrnCodeCustomTuniUniversityRootIdOfferingInformation(List<String> urnCodeCustomTuniUniversityRootIdOfferingInformation){
		this.urnCodeCustomTuniUniversityRootIdOfferingInformation = urnCodeCustomTuniUniversityRootIdOfferingInformation;
	}

	public List<String> getUrnCodeCustomTuniUniversityRootIdOfferingInformation(){
		return urnCodeCustomTuniUniversityRootIdOfferingInformation;
	}
}