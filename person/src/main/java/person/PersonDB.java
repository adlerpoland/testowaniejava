package person;

public interface PersonDB 
{
    void addPerson(Person person);
    void updatePerson(Person person);
    Person getPerson(int id);
    void deletePerson(int id);
}
