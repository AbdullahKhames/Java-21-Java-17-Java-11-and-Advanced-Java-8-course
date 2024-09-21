package java21.assignment;

public final record LecturerRecord(
        String name,
        Integer age,
        Faculty faculty,
        Department dept
) {

    public LecturerRecord {
        String errorMessage = """
                Illegal argument passed:
                        "name": %s,
                        "age": %s
                """.formatted(name, age);
        if (name == null || name.isBlank() || age < 0) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
    public boolean hasPhd(){
        String prefix = name.substring(0, 3);
        String suffix = name.substring(name.length() - 3);
        return switch (prefix){
            case "Dr." -> true;
            default ->  switch (suffix){
                case "PhD" -> true;
                default -> false;
            };
        };
    }

    public void whichFaculty(){
        switch (faculty){
            case EngineeringFaculty ef -> {
                System.out.printf("java21.assignment.Faculty of: %s%n", ef);
                ef.engineering();
            }
            case HumanitiesFaculty hf -> {
                System.out.printf("java21.assignment.Faculty of: %s%n", hf);
                hf.humanities();
            }

            case BusinessFaculty bf -> {
                System.out.printf("java21.assignment.Faculty of: %s%n", bf);
                bf.business();
            }
            default -> throw new IllegalArgumentException(faculty.toString());

        }
    }
    public void whichDept(){
        switch (dept){
            case ComputerEngineeringDept ced -> {
                System.out.printf("Dept of : %s%n", ced);
                ced.compEng();
            }
            case SoftwareEngineeringDept hf -> {
                System.out.printf("Dept of : %s%n", hf);
                hf.swEng();
            }

            case SocialCareDept bf -> {
                System.out.printf("Dept of : %s%n", bf);
                bf.socialCare();
            }
            case AccountingDept bf -> {
                System.out.printf("Dept of : %s%n", bf);
                bf.accounting();
            }
            default -> throw new IllegalArgumentException(dept.toString());

        }
    }
}
