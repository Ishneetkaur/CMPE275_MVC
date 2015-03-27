package net.codejava.springmvc;

public class ModelStore {
	private String userid;
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private String organization;
    private String aboutMyself;
    
    public ModelStore() {
    }

    public String getId() {
   	 return userid;
    }

    public void setId(String userid) {
   	 this.userid = userid;
    }
    
    public String getFirstName()
	{
		return firstname;
	}
	
	public void setFirstName(String firstname)
	{
		this.firstname=firstname;
	}
	
	public String getLastName()
	{
		return lastname;
	}
	
	public void setLastName(String lastname)
	{
		this.lastname=lastname;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email=email;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String address)
	{
		this.address=address;
	}
	
	public String getOrganization()
	{
		return organization;
	}
	
	public void setOrganization(String organization)
	{
		this.organization=organization;
	}
	
	public String getAboutMyself()
	{
		return aboutMyself;
	}
	
	public void setAboutMyself(String aboutMyself)
	{
		this.aboutMyself=aboutMyself;
	}

}
