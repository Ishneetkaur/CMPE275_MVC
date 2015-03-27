package net.codejava.springmvc;

public class ModelDataImpl implements ModelData{

	@Override
	public void createDB(ModelStore modelstore) throws Exception {
		if(userDB.containsKey(modelstore.getId())){
			System.out.println("The Details are already present in Database.");
			throw new Exception("The Details are already present in Database.");
		}
		else {
			userDB.put(modelstore.getId(), modelstore);
			System.out.println("Details Stored in the Database.");
		}
		
	}
	
	@Override
	public void deleteDB(String userid) throws Exception {
		if(!userDB.containsKey(userid)){
			System.out.println("The Details are not present in Database.");
			throw new Exception("The Details are not present in Database.");
		}
		else {
			userDB.remove(userid);
			System.out.println("Details removed from the Database.");
		}
		
	}

	@Override
	public ModelStore updateDB(ModelStore modelstore) throws Exception {
		if(userDB.containsKey(modelstore.getId())){
			userDB.remove(modelstore.getId());
			System.out.println(userDB.size());
			userDB.put(modelstore.getId(), modelstore);
			System.out.println(userDB.size());
			System.out.println("The Details have been updated in Database.");
			return modelstore;
		}
		else {
			System.out.println("The Details are not present in Database.");
			throw new Exception("The Details are not present in Database.");
		}
	}

	@Override
	public ModelStore retrieveDB(String userid) throws Exception {
		if(userDB.containsKey(userid)){
			System.out.println("The Details being retrieved from Database.");
			return (ModelStore) userDB.get(userid);
		}
		else {
			System.out.println("No such details stored in the Database.");
			throw new Exception("The Details are not present in Database.");
		}
	}
	
}
