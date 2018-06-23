package de.tub.ise.as.td.web;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.sun.corba.se.impl.orbutil.ObjectWriter;

import de.tub.ise.as.td.ejb.PostManagement;
import de.tub.ise.as.td.ejb.UserManagement;
import de.tub.ise.as.td.entity.Post;
import de.tub.ise.as.td.entity.User;

@Path("/user")
public class UserService {
   
    @EJB
    private UserManagement userMgmt;
    private PostManagement postMgmt;

    public UserService() {
    }

    /**
     * Retrieves representation of an instance of User
     * @return an JSON as a string.
     */
    /*
    @GET
    @Produces("application/json")
    public String getUsersAsJson() {
    	
        //List<User> users = userMgmt.getUsers();
        
        Jsonb jsonb = JsonbBuilder.create();
    	
        return jsonb.toJson("hallo");
    }
    */
    
    @GET 
    @Path("/users")
    @Produces("application/json")
    public String getUsers() { 
    	List<User> users = userMgmt.getUsers();
    	Jsonb jsonb = JsonbBuilder.create();
    	return jsonb.toJson(users);
    }

    @GET
    @Produces("application/json")
    public String getUser(@QueryParam("userId") String userId) {
    	User user = userMgmt.getUser(Integer.parseInt(userId));
    	String jsonResp = "{"
    			+ "\"name\":\"" + user.getName() + "\","
    			+ "\"age\":\"" + user.getAge() + "\","
    			+ "\"starsign\":\"" + user.getStarsign() + "\","
    			+ "\"course\":\"" + user.getCourse() + "\","
    			+ "\"imagePath\":\"" + user.getImagePath() + "\","
    			+ "\"postings\":[";
    	try {
    		System.out.println("starting");
    		List<Post> postList = postMgmt.getPosts(Integer.parseInt(userId));
    		for (Post post : postList) {
        		jsonResp += "{"
        				+ "\"author\":\"" + post.getAuthor() + "\","
        				+ "\"date\":\"" + post.getTimeStamp() + "\","
        				+ "\"content\":\"" + post.getContent() + "\","
        				+ "}";
        	}
    	} catch (NullPointerException e) {
    		
    	}
    	jsonResp += "]}";
    	return jsonResp;
    }
    
    @POST
    @Produces("application/json")
    public String savePost(String request) {
    	String[] params = request.split("&");
    	String author = params[0].replace("author=", "");
    	String targetId = params[1].replace("targetId=", "");
    	String content = params[2].replace("content=", "");
    	System.out.println(author + ", " + targetId + ", " + content);
    	System.out.println(Integer.parseInt(targetId));
    	String response = postMgmt.setPosting(author, Integer.parseInt(targetId), content);
    	System.out.println(response);
    	Jsonb jsonb = JsonbBuilder.create();
    	return jsonb.toJson("");
    }

}