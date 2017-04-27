package com.paric.asset.service;

import com.paric.asset.model.Klass;

public interface KlassService extends BaseService<Klass> {
	
	/***
	 * 通过班级的名字、所属的专业和所属的学院查询班级
	 * @param instituteName
	 * @param majorName
	 * @param klassName
	 * @return
	 */
	public Klass findKlassByName(String instituteName, String majorName, String klassName);

}
