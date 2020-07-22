package dao;

import controller.data.Person;

import java.util.Collection;

public interface PersonDao {
    Collection<Person> savePersons(Collection<Person> persons);
    int savePerson(Person person);
    int deletePersonById(int id);
   Collection<Person> getSavedPersons();
}
