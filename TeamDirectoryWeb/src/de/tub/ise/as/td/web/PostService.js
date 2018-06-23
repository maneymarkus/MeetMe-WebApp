package de.tub.ise.as.td.web;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import de.tub.ise.as.td.ejb.PostManagement;
import de.tub.ise.as.td.entity.Post;

@Path("/post")
public class PostService {
   
    @EJB
    private PostManagement postMgmt;

    public PostService() {
    }

    /**
     * Retrieves representation of an instance of User
     * @return an JSON as a string.
     */
    
    @GET
    @Path("/id")
    @Produces("application/json")
    public String getPostRole() {
    	List<Post> posts = postMgmt.getPosts();
    	Jsonb jsonb = JsonbBuilder.create();
        List<Integer> ids = new ArrayList<>();
        for (Post p : posts) {
        	ids.add(p.getId());
        }
        return jsonb.toJson(ids);
    }
}
