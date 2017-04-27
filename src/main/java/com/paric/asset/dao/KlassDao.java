package com.paric.asset.dao;

import com.paric.asset.model.Klass;

public interface KlassDao extends BaseDao<Klass> {
	
	public Klass findKlassByName(String instituteName, String majorName, String klassName);

}
