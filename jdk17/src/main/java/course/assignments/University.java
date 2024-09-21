package course.assignments;

public class University {
    public static void main(String[] args) {
//        Lecturer error1 = new Lecturer(-1, "asd", new EngineeringFaculty(), new SoftwareEngineeringDept());
//        Lecturer error2 = new Lecturer(1, "", new HumanitiesFaculty(), new SocialCareDept());
        Lecturer jane = new Lecturer( "Jane Bloggs",24, new EngineeringFaculty(), new SoftwareEngineeringDept());
        System.out.println("Name is : " + jane.name());
        System.out.println("Age is : " + jane.age());
        System.out.println("Faculty is : " + jane.faculty());
        System.out.println("Department is : " + jane.dept());
        jane.whichFaculty();
        jane.whichDept();
        System.out.println("Does Jane have a PhD?");
        System.out.println(jane.hasPhd());

        Lecturer anne = new Lecturer( "Dr. Anne Bloggs",35, new BusinessFaculty(), new AccountingDept());
        System.out.println(anne);
        System.out.println(anne.hasPhd() ? "Ann has a PhD" : "Anne has not a PhD");

        Lecturer joe = new Lecturer( "Joe Bloggs PhD",54, new HumanitiesFaculty(), new SocialCareDept());
        System.out.println(joe);
        System.out.println(joe.hasPhd() ? "Joe has a PhD" : "Joe has not a PhD");
    }
}
