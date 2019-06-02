package edu.ucam.internal.farm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import edu.ucam.internal.crop.Crop;

public class Farm implements Serializable {
	private static final long serialVersionUID = 1L;

	private Number id;
	private String name;
	private Hashtable<Number, Crop> crops;

	public Farm() {
		this.setId(null);
		this.setName("");
	}

	public Farm(Number id, String name, Hashtable<Number, Crop> crops) {
		this.setId(id);
		this.setName(name);
		this.setCrops(crops);
	}

	public Number getId() {
		return id;
	}

	public void setId(Number id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hashtable<Number, Crop> getCrops() {
		return crops;
	}

	public void setCrops(Hashtable<Number, Crop> crops) {
		this.crops = crops;
	}
	
	public String getCropsString() {
		ArrayList<String> crops = new ArrayList<String>();
		if (this.crops != null && this.crops.size() > 0) {
		   	Enumeration<Number> i = this.crops.keys();
	  		Number id;
	  		while(i.hasMoreElements()) {
	  			id = (Number) i.nextElement();
	  			crops.add(Integer.toString((int)id));
	  		}
		}
		return String.join("-", crops);
	}

	public String toString() {
		return this.id + " : " + this.name + " : " + this.crops.size();
	}

}
