package fi.tuni.prog3.sisu.module.fields;

import com.google.gson.annotations.SerializedName;

public class Metadata{

	@SerializedName("createdBy")
	private String createdBy;

	@SerializedName("lastModifiedBy")
	private String lastModifiedBy;

	@SerializedName("modificationOrdinal")
	private int modificationOrdinal;

	@SerializedName("createdOn")
	private String createdOn;

	@SerializedName("revision")
	private int revision;

	@SerializedName("lastModifiedOn")
	private String lastModifiedOn;

	public void setCreatedBy(String createdBy){
		this.createdBy = createdBy;
	}

	public String getCreatedBy(){
		return createdBy;
	}

	public void setLastModifiedBy(String lastModifiedBy){
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getLastModifiedBy(){
		return lastModifiedBy;
	}

	public void setModificationOrdinal(int modificationOrdinal){
		this.modificationOrdinal = modificationOrdinal;
	}

	public int getModificationOrdinal(){
		return modificationOrdinal;
	}

	public void setCreatedOn(String createdOn){
		this.createdOn = createdOn;
	}

	public String getCreatedOn(){
		return createdOn;
	}

	public void setRevision(int revision){
		this.revision = revision;
	}

	public int getRevision(){
		return revision;
	}

	public void setLastModifiedOn(String lastModifiedOn){
		this.lastModifiedOn = lastModifiedOn;
	}

	public String getLastModifiedOn(){
		return lastModifiedOn;
	}
}