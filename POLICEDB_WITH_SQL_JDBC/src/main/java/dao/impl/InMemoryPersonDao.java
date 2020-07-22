package dao.impl;

import controller.data.Person;
import dao.PersonDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;


@Repository
public class InMemoryPersonDao implements PersonDao {

    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    Collection<Person> savedPersons = new ArrayList<>();


    @Override
    public Collection<Person> savePersons(Collection<Person> persons) {
        savedPersons.addAll(persons);
        return savedPersons;
    }

    @Override
    public int savePerson(Person person) {
        savedPersons.add(person); // eto ya probyy prosto ne ori
        return jdbcTemplate.update("INSERT INTO policedb.prisoners VALUES (?,?,?,?,?)", person.getId(), person.getName(), person.getState(), person.getDaysArrested(), person.getGender());

    }


    @Override
    public int deletePersonById(int id) {
        return jdbcTemplate.update("DELETE FROM policedb.prisoners WHERE id =" + id);
    }

    @Override
    public Collection<Person> getSavedPersons() {
        return jdbcTemplate.query("SELECT * FROM policedb.prisoners", (resultSet, i) -> {
            Person person = new Person();
            person.setId(resultSet.getInt(1));
            person.setName(resultSet.getString(2));
            person.setState(resultSet.getString(3));
            person.setDaysArrested(resultSet.getInt(4));
            person.setGender(resultSet.getString(5));
            return person;
        });
    }

}
