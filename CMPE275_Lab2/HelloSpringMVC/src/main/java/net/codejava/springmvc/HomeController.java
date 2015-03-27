package net.codejava.springmvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
 	public static ModelData modeldata = new ModelDataImpl();
 	ModelStore modelstore = new ModelStore();
 	String modeNew = null;
 	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

	@RequestMapping(value = "/modelstore",method = RequestMethod.GET)
	public String setupForm(Model model)
	{
		//addJSPAttributes(model, null, null, null, null, null, null, null);
		return "modelstore";
	}
	
	@RequestMapping(value = "/modelstore", method = RequestMethod.POST)
	public String submitForm(String userid, String firstname, String lastname, String email, String address, String organization, String aboutMyself,Model model)
	{  
		try { 
			setStoreAttributes(modelstore, userid, firstname, lastname, email, address, organization, aboutMyself);
			modeldata.createDB(modelstore);
			
			addJSPAttributes(model, userid, firstname, lastname, email, address, organization, aboutMyself);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		System.out.println(modelstore.getId());
		return "redirect:/modelstore/" + modelstore.getId();
	}
	
	@RequestMapping(value = "/modelstore/{userid}", method = RequestMethod.GET)
	public String ViewUserDetails(Model model, @PathVariable String userid) {
		  try { 
			  	if(modeNew == null){ modeNew = "No";}
			    if (modeNew.equalsIgnoreCase("Brief")) {
			    ObjectMapper mapper = new ObjectMapper();
				modelstore = modeldata.retrieveDB(userid);
				String result = mapper.writeValueAsString(modelstore);
				model.addAttribute("result", result);
				return "modelstorejson";
		        }
		  else {
				modelstore = modeldata.retrieveDB(userid);
				
				addJSPAttributes(model,userid, modelstore.getFirstName(), modelstore.getLastName(), modelstore.getEmail(), modelstore.getAddress(), modelstore.getOrganization(), modelstore.getAboutMyself());
		  }				
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		  return "modelstoreupdate";
	}
	
	@RequestMapping(value = "/modelstore/{userid}", method = RequestMethod.POST)
	public String modifyUserDetails(Model model, @PathVariable String userid, String firstname, String lastname, String email, String address, String organization, String aboutMyself, String mode) {
		  try {
				modeNew = null;
				//addJSPAttributes(model,userid, modelstore.getFirstName(), modelstore.getLastName(), modelstore.getEmail(), modelstore.getAddress(), modelstore.getOrganization(), modelstore.getAboutMyself());
				if(mode.equalsIgnoreCase("Update")){
					modelstore = modeldata.retrieveDB(userid);
					firstname = (firstname.split(","))[1];
					lastname=(lastname.split(","))[1];
					email = (email.split(","))[1];
					address = (address.split(","))[1];
					organization = (organization.split(","))[1];
					aboutMyself = (aboutMyself.split(","))[1];
					setStoreAttributes(modelstore, userid, firstname, lastname, email, address, organization, aboutMyself);
					modelstore = modeldata.updateDB(modelstore);
				
					System.out.print(modelstore.getFirstName()+modelstore.getEmail());
					System.out.println(lastname);	
					addJSPAttributes(model,userid, firstname, lastname, email, address, organization, aboutMyself);		
				    return "redirect:/modelstore/{userid}";
				}
				else if (mode.equalsIgnoreCase("Delete")){
					modelstore = modeldata.retrieveDB(userid);
					setStoreAttributes(modelstore, userid, firstname, lastname, email, address, organization, aboutMyself);
					modeldata.deleteDB(userid);
					model.addAttribute("userid", userid);
					return "redirect:/modelstoredelete";
				}
				else if (mode.equalsIgnoreCase("Brief")){
					modelstore = modeldata.retrieveDB(userid);
					setStoreAttributes(modelstore, userid, firstname, lastname, email, address, organization, aboutMyself);
					model.addAttribute("brief", "true");
					modeNew = "Brief";
					return "redirect:/modelstore/{userid}";
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		  return "redirect:/modelstore";
	}
	
//	@RequestMapping(value = "/modelstoreupdated", method = RequestMethod.GET)
//	public String ViewUser(Model model, String userid) {
//			System.out.println("yaha hu yo yo");
//		  try {
//				modelstore = modeldata.retrieveDB(userid);
//				addJSPAttributes(model,userid, modelstore.getFirstName(), modelstore.getLastName(), modelstore.getEmail(), modelstore.getAddress(), modelstore.getOrganization(), modelstore.getAboutMyself());
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		  return "modelstoreupdated";
//	}
	
	@RequestMapping(value = "/modelstore/brief/{userid}", method = RequestMethod.GET)
	public @ResponseBody String listUserJson(ModelMap model, @PathVariable String userid) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		modelstore = modeldata.retrieveDB(userid);
		String result = mapper.writeValueAsString(modelstore);
		return result;
	}
	
	@RequestMapping(value = "/modelstoredelete", method = RequestMethod.GET)
	public String DeletedUser(Model model, String userid) {
		  model.addAttribute("userid", userid);
		  return "modelstoredelete";
	}
	
	public void addJSPAttributes(Model model,String userid, String firstname, String lastname, String email, String address, String organization, String aboutMyself){
		
		model.addAttribute("userid",userid);
		model.addAttribute("firstname",firstname);
		model.addAttribute("lastname",lastname);
		model.addAttribute("email",email);
		model.addAttribute("organization",organization);
		model.addAttribute("aboutMyself",aboutMyself);
		model.addAttribute("address",address);
    }
	
	public void setStoreAttributes(ModelStore modelstore, String userid, String firstname, String lastname, String email, String address, String organization, String aboutMyself){
		    modelstore.setId(userid);
			modelstore.setFirstName(firstname);
			modelstore.setLastName(lastname);
			modelstore.setEmail(email);
			modelstore.setOrganization(organization);
			modelstore.setAboutMyself(aboutMyself);
			modelstore.setAddress(address);
	}
	
}
