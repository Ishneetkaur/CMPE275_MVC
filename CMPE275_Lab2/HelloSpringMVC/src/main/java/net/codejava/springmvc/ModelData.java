package net.codejava.springmvc;

import java.util.HashMap;

public interface ModelData {
	HashMap<String, Object> userDB = new HashMap<String, Object>();
	void createDB(ModelStore modelstore) throws Exception;
	void deleteDB(String id) throws Exception;
	ModelStore updateDB(ModelStore modelstore) throws Exception;
	ModelStore retrieveDB(String id) throws Exception;
}
