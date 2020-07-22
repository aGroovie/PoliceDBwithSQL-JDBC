package controller;

import controller.data.Person;
import dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.PersonService;
import dao.impl.InMemoryPersonDao;


import java.util.Collection;


@Controller
public class DataBaseController  {
    private PersonService personService;






    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }



    @GetMapping("/home")
  public String showHome(){
        return  "home";
    }


    @RequestMapping("/registration")
    public String showForm(Model m){
        m.addAttribute("command", new Person());
        return "/registration";
    }



@RequestMapping(value = "/save",method=RequestMethod.POST)
    public String save(@ModelAttribute("person") Person person){

        personService.savePerson(person);


        return "redirect:/result";
}



@RequestMapping("/result")
    public String showResult(Model m){
    Collection<Person> personList = personService.getPersons();
    m.addAttribute("personList",personList);
    return "result";
}

@RequestMapping(value ="/deletePersonById/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
personService.deletePersonById(id);
        return "redirect:/result";

}





}

