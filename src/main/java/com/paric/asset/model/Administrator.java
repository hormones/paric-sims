package com.paric.asset.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="administrator")
public class Administrator extends BaseCharacter implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3353682959733725603L;
	
}
