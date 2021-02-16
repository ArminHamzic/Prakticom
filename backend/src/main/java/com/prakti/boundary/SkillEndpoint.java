package com.prakti.boundary;

import com.prakti.control.SkillDAO;
import com.prakti.model.Skill;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/skill")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SkillEndpoint {

    @Inject
    SkillDAO skillDAO;

    @GET
    public List<Skill> getAllSkills(){

        return skillDAO.findAllSkills();
    }

    @GET
    @Path("/{id}")
    public Skill getSkillById(@PathParam("id") Long id){
        return skillDAO.findSkillById(id);
    }


}
