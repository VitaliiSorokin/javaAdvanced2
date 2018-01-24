public class Main {
    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Teacher("Billy Bob", 55, "M", 3000, "Engineering");
        persons[1] = new Student("Student1", 18, "M", "FR4590", 4.5);
        persons[2] = new Student("Student2", 18, "F", "DD8734", 3.4);
        persons[3] = new Student("Student3", 19, "M", "FDwdsd", 3.2);
        persons[4] = new CollegeStudent("Jack one", 20, "F", "FR4422", 3.4, 3,"CS");

        for(Person person: persons) {
            System.out.println(person.toString());
        }
    }
}
