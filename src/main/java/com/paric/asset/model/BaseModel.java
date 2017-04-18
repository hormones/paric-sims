package com.paric.asset.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7563287601551613405L;

	protected long id;

	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@GenericGenerator( name="id_gen", strategy="enhanced-table", 
			parameters = {
					@Parameter( name = "table_name", value = "enhanced_gen"), 
					@Parameter( name ="value_column_name", value = "next"), 
					@Parameter( name = "segment_column_name",value = "segment_name"), 
					@Parameter( name = "segment_value", value = "table_seq"),
					@Parameter( name = "increment_size", value = "1"), 
					@Parameter( name = "optimizer",value = "pooled-lo") 
	}) 
	@Id 
	@GeneratedValue(generator="id_gen") 
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
