package MarkSheet;

public class MarkSheetClient {

    public static void main(String[] args) {
        StudentMarkSheet[] studArray = new StudentMarkSheet[5];
        studArray[0] = new StudentMarkSheet("Jay", 1002, 489);
        studArray[1] = new StudentMarkSheet("Max", 1026, 509);
        studArray[2] = new StudentMarkSheet("Kyle", "SY BCA", 1172, 299);
        studArray[3] = new StudentMarkSheet("Brock", "SY BCA", 1150, 589);
        studArray[4] = new StudentMarkSheet("Randy", "TY BCA", 1222, 359);

        for (StudentMarkSheet student : studArray) {
            student.calCGPA();
            student.calCGPAGrade();
        }
        for (StudentMarkSheet student : studArray) {
            System.out.println("Roll No: " + student.getRollNo());
            System.out.println("Name: " + student.getName());
            System.out.println("Standard: " + student.getStd());
            System.out.println("CGPA: " + student.getCgpa());
            System.out.println("Grade: " + student.getCgpaGrade());
            System.out.println();
        }
    }
}
