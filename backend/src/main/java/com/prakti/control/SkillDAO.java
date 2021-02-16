package com.prakti.control;

import com.prakti.model.Skill;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;

@Transactional
@ApplicationScoped
public class SkillDAO implements PanacheRepository<Skill> {

    public List<Skill> findAllSkills(){
        return Skill.findAll().list();
    }

    public Skill findSkillById(Long id){
        Optional<Skill> optionalSkill = Skill.find("id", id).singleResultOptional();
        return optionalSkill.orElseThrow(NotFoundException::new);
    }

    public Skill persistSkill(Skill skill){
        return this.getEntityManager().merge(skill);
    }

    public void deleteSkill(Long id){
        delete(findSkillById(id));
    }



}
