package edu.ucam.internal.crop;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Crop implements Serializable {
	private static final long serialVersionUID = 1L;

	private Number id;
	private String name;
	private Number size;

	public Crop() {
		this.setId(null);
		this.setName("");
	}

	public Crop(Number id, String name, Number size) {
		this.setId(id);
		this.setName(name);
		this.setSize(size);
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

	public Number getSize() {
		return size;
	}

	public String getFormattedSize() {
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();
		otherSymbols.setDecimalSeparator(',');
		otherSymbols.setGroupingSeparator('.');
		return new DecimalFormat("###,###,###").format(size);
	}

	public void setSize(Number size) {
		this.size = size;
	}
	
	public String toString() {
		return this.id + " : " + this.name;
	}

}
