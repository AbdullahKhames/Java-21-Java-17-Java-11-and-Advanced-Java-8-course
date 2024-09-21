import java21.assignment.*;

import java.util.*;


public static final EngineeringFaculty ENGINEERING_FACULTY = new EngineeringFaculty();
public static final SoftwareEngineeringDept SOFTWARE_ENGINEERING_DEPT = new SoftwareEngineeringDept();
public static final BusinessFaculty BUSINESS_FACULTY = new BusinessFaculty();
public static final AccountingDept ACCOUNTING_DEPT = new AccountingDept();
public static final HumanitiesFaculty HUMANITIES_FACULTY = new HumanitiesFaculty();
public static final SocialCareDept SOCIAL_CARE_DEPT = new SocialCareDept();
public static final int retirementAge = 64;

void main() {
//        seqColl();
                
//        seqSet();
                
//        seqMap();

        LecturerRecord mike = new LecturerRecord("Mike Bloggs", 44, ENGINEERING_FACULTY, SOFTWARE_ENGINEERING_DEPT);
        recordPatterns(mike);

        LecturerRecord alan = new LecturerRecord("Alan Austin", 64, BUSINESS_FACULTY, ACCOUNTING_DEPT);
        recordPatterns(alan);

        LecturerRecord lisa = new LecturerRecord("Lisa Bloggs", 65, HUMANITIES_FACULTY, SOCIAL_CARE_DEPT);
        recordPatterns(lisa);
}

private void recordPatterns(Object obj) {

        System.out.println(
                switch (obj){
                        case LecturerRecord lecturerRecord when lecturerRecord.age() >= retirementAge ->{
                                String output = """
                                  Name is :  %s
                                  Age is : %s
                                  Faculty is :  %s
                                  Department is : %s
                                """.formatted(
                                        lecturerRecord.name(),
                                        lecturerRecord.age(),
                                        lecturerRecord.faculty(),
                                        lecturerRecord.dept()
                                );
                                yield output;
                        }
                        case null, default -> "";
                }
        );
}

private void seqMap() {
        LecturerRecord Lear = new LecturerRecord("King Lear", 88, HUMANITIES_FACULTY, SOCIAL_CARE_DEPT);
        LecturerRecord Goneril = new LecturerRecord("Goneril", 55, HUMANITIES_FACULTY, SOCIAL_CARE_DEPT);
        LecturerRecord Regan = new LecturerRecord("Regan", 50, HUMANITIES_FACULTY, SOCIAL_CARE_DEPT);
        LecturerRecord Cordelia = new LecturerRecord("Cordelia", 45, HUMANITIES_FACULTY, SOCIAL_CARE_DEPT);


        SequencedMap<LecturerRecord, String> seqMap = new LinkedHashMap<>();

        seqMap.putFirst(Goneril, "Eldest");
        seqMap.putFirst(Regan, "Middle");
        seqMap.putLast(Cordelia, "Youngest");
        seqMap.putLast(Lear, "Father");

        System.out.println(seqMap);

        System.out.printf("firstEntry() : %s\n", seqMap.firstEntry());
        System.out.printf("lastEntry() : %s\n", seqMap.lastEntry());
        System.out.printf("pollLastEntry() : %s\n", seqMap.pollLastEntry());

        System.out.println(seqMap);

        for (Map.Entry<LecturerRecord, String> record : seqMap.entrySet()) {
                System.out.printf("%s;\n%s\n", record.getKey(), record.getValue());
        }
        for (Map.Entry<LecturerRecord, String> record : seqMap.reversed().entrySet()) {
                System.out.printf("%s;\n%s\n", record.getKey(), record.getValue());
        }
}

private void seqSet() {
        LecturerRecord jane = new LecturerRecord("Jane Austin", 24, BUSINESS_FACULTY, ACCOUNTING_DEPT);
        LecturerRecord Charlotte = new LecturerRecord("Dr. Charlotte Bronte", 35, BUSINESS_FACULTY, ACCOUNTING_DEPT);
        LecturerRecord Anne = new LecturerRecord("Anne Bronte PhD", 54, BUSINESS_FACULTY, ACCOUNTING_DEPT);

        SequencedSet<LecturerRecord> seqSet = new LinkedHashSet<>();
        seqSet.addFirst(jane);
        seqSet.addFirst(jane);
        seqSet.addFirst(jane);
        seqSet.addFirst(Charlotte);
        seqSet.addLast(jane);
        seqSet.addLast(Anne);

        System.out.println(seqSet);

        System.out.printf("getFirst() : %s\n", seqSet.getFirst());
        System.out.printf("getLast() : %s\n", seqSet.getLast());
        System.out.printf("removeFirst() : %s\n", seqSet.removeFirst());
        System.out.println(seqSet);

        for (LecturerRecord record : seqSet) {
                System.out.println(record);
        }
        for (LecturerRecord record : seqSet.reversed()) {
                System.out.println(record);
        }
}

private void seqColl() {
        LecturerRecord jane = new LecturerRecord("Jane Bloggs", 24, ENGINEERING_FACULTY, SOFTWARE_ENGINEERING_DEPT);
        LecturerRecord anne = new LecturerRecord("Dr. Anne Bloggs", 35, ENGINEERING_FACULTY, SOFTWARE_ENGINEERING_DEPT);
        LecturerRecord joe = new LecturerRecord("Joe Bloggs PhD", 54, ENGINEERING_FACULTY, SOFTWARE_ENGINEERING_DEPT);

        SequencedCollection<LecturerRecord> seqColl = new ArrayList<>();
        seqColl.addFirst(jane);
        seqColl.addFirst(anne);
        seqColl.addLast(joe);

        System.out.println(seqColl);

        System.out.printf("getFirst() : %s\n", seqColl.getFirst());
        System.out.printf("getLast() : %s\n", seqColl.getLast());
        System.out.printf("removeLast() : %s\n", seqColl.removeLast());
        System.out.println(seqColl);

        for (LecturerRecord record : seqColl) {
                System.out.println(record);
        }
        for (LecturerRecord record : seqColl.reversed()) {
                System.out.println(record);
        }
}



