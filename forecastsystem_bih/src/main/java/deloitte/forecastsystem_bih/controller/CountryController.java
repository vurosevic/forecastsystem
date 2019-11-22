package deloitte.forecastsystem_bih.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController {	
	
	@Autowired
	CountryService countryService;

	@GetMapping(value="/demo")
	public HashMap<String, Object> demo() {
		HashMap<String, Object> map = new HashMap<String, Object>();
	    map.put("message", "Welcome to OAuth demo");
		return map;
	}	
	
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public @ResponseBody Object getOsobe() {
        List<Country> countries = countryService.findAll();
        
        System.out.println("(Service Side) Get all countries.");
        
        return ResponseEntity.status(HttpStatus.OK).body(countries);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public @ResponseBody Object getOsoba(@PathVariable Long id) {
        Country c = countryService.findById(id);  
        
        System.out.println("(Service Side) Get osoba with Id: " + c.getId());
        
        return ResponseEntity.status(HttpStatus.OK).body(c); 
    }   
   
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody Object delete(@PathVariable Long id) {
    	countryService.delete(id); 
        
        System.out.println("(Service Side) Delete osoba with Id: " + id);
        
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Object update(@RequestBody Country o) { 
    	
    	System.out.println("UPDATE COMMAND");    	
    	System.out.println(o);    	
    	
        Country country = (Country) countryService.save(o); 
        
    	System.out.println("AFTER UPDATE COMMAND");    	
    	System.out.println(country);
    	
        return ResponseEntity.status(HttpStatus.OK).body(country); 
    }    
    
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody Object save(@RequestBody  Country o) {
    	
    	System.out.println("SAVE COMMAND");    	
    	System.out.println(o);
    	o.setId(0L); 
    	Country country = (Country) countryService.save(o);
        return ResponseEntity.status(HttpStatus.OK).body(country);
    	//return ResponseEntity.status(HttpStatus.OK).body(o);
    }  
	
	
}
