package de.tub.ise.as.td.web;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import de.tub.ise.as.td.ejb.UserManagement;
import de.tub.ise.as.td.entity.User;

@Path("/user")
public class UserService {
   
    @EJB
    private UserManagement userMgmt;

    public UserService() {
    }

    /**
     * Retrieves representation of an instance of User
     * @return an JSON as a string.
     */
    
//    @GET
//    @Path("/delete")
//    public void delete() {
//    	userMgmt.deleteUser();
//    }

    
    @GET
    @Path("/id")
    @Produces("application/json")
    public String getUserRole() {
    	List<User> users =userMgmt.getUsers();
    	Jsonb jsonb = JsonbBuilder.create();
        List<Integer> ids = new ArrayList<>();
        for (User u : users) {
        	ids.add(u.getId());
        }
        return jsonb.toJson(ids);
    }

    
    @GET
    @Path("/starsign/M")
    @Produces("application/json")
    public String getUserStarSignM() {
    	Jsonb jsonb = JsonbBuilder.create();
    	String s = userMgmt.getUser("Markus").getStarSign();
        return jsonb.toJson(s);
    }
    
    @GET
    @Path("/starsign/D")
    @Produces("application/json")
    public String getUserStarSignD() {
    	Jsonb jsonb = JsonbBuilder.create();
    	String s = userMgmt.getUser("Dennis").getStarSign();
        return jsonb.toJson(s);
    }
    
    @GET
    @Path("/starsign/C")
    @Produces("application/json")
    public String getUserStarSignC() {
    	Jsonb jsonb = JsonbBuilder.create();
    	String s = userMgmt.getUser("Chris").getStarSign();
        return jsonb.toJson(s);
    }
    
    @GET
    @Path("/starsign/P")
    @Produces("application/json")
    public String getUserStarSignP() {
    	Jsonb jsonb = JsonbBuilder.create();
    	String s = userMgmt.getUser("Carloss").getStarSign();
        return jsonb.toJson(s);
    } 
    
    @GET
    @Path("/course/M")
    @Produces("application/json")
    public String getUserCourseOfStudiesM() {
    	Jsonb jsonb = JsonbBuilder.create();
    	String s = userMgmt.getUser("Markus").getCourseOfStudies();
        return jsonb.toJson(s);
    }
    
    @GET
    @Path("/course/D")
    @Produces("application/json")
    public String getUserCourseOfStudiesD() {
    	Jsonb jsonb = JsonbBuilder.create();
    	String s = userMgmt.getUser("Dennis").getCourseOfStudies();
        return jsonb.toJson(s);
    }
    
    @GET
    @Path("/course/C")
    @Produces("application/json")
    public String getUserCourseOfStudiesC() {
    	Jsonb jsonb = JsonbBuilder.create();
    	String s = userMgmt.getUser("Chris").getCourseOfStudies();
        return jsonb.toJson(s);
    }
    
    @GET
    @Path("/course/P")
    @Produces("application/json")
    public String getUserCourseOfStudiesP() {
    	Jsonb jsonb = JsonbBuilder.create();
    	String s = userMgmt.getUser("Carloss").getCourseOfStudies();
        return jsonb.toJson(s);
    }
    
    @GET
    @Path("/age/M")
    @Produces("application/json")
    public String getUserAgeM() {
    	Jsonb jsonb = JsonbBuilder.create();
    	int s = userMgmt.getUser("Markus").getAge();
        return jsonb.toJson(s);
    }
    
    @GET
    @Path("/age/D")
    @Produces("application/json")
    public String getUserAgeD() {
    	Jsonb jsonb = JsonbBuilder.create();
    	int s = userMgmt.getUser("Dennis").getAge();
        return jsonb.toJson(s);
    }
    
    @GET
    @Path("/age/C")
    @Produces("application/json")
    public String getUserAgeC() {
    	Jsonb jsonb = JsonbBuilder.create();
    	int s = userMgmt.getUser("Chris").getAge();
        return jsonb.toJson(s);
    }
    
    @GET
    @Path("/age/P")
    @Produces("application/json")
    public String getUserAgeP() {
    	Jsonb jsonb = JsonbBuilder.create();
    	int s = userMgmt.getUser("Carloss").getAge();
        return jsonb.toJson(s);
    }
    
    @GET
    @Path("/name/M")
    @Produces("application/json")
    public String getUserNameM() {
    	Jsonb jsonb = JsonbBuilder.create();
    	String s = userMgmt.getUser("Markus").getName();
        return jsonb.toJson(s);
    }
    
    @GET
    @Path("/name/D")
    @Produces("application/json")
    public String getUserNameD() {
    	Jsonb jsonb = JsonbBuilder.create();
    	String s = userMgmt.getUser("Dennis").getName();
        return jsonb.toJson(s);
    }
    
    @GET
    @Path("/name/C")
    @Produces("application/json")
    public String getUserNameC() {
    	Jsonb jsonb = JsonbBuilder.create();
    	String s = userMgmt.getUser("Chris").getName();
        return jsonb.toJson(s);
    }
    
    @GET
    @Path("/name/P")
    @Produces("application/json")
    public String getUserNameP() {
    	Jsonb jsonb = JsonbBuilder.create();
    	String s = userMgmt.getUser("Carloss").getName();
        return jsonb.toJson(s);
    }

}