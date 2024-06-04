package MarkSheet;

public final class StudentMarkSheet {

    private String name;
    private String std;
    private int rollNo;
    private double totalMarks;
    final double maxMarks = 600;
    private float CGPA;
    private String CGPAGrade;

    public StudentMarkSheet() {
        setName("");
        setStd("");
        setRollNo(0);
        setTotalMarks(0);

    }

    public StudentMarkSheet(String name, String std, int rollNo, int totalMarks) {
        this.name = name;
        this.std = std;
        this.rollNo = rollNo;
        this.totalMarks = totalMarks;
    }

    public StudentMarkSheet(String name, int rollNo, int totalMarks) {
        this.name = name;
        this.std = "FY BCA";
        this.rollNo = rollNo;
        this.totalMarks = totalMarks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public double getTotalMarks() {
        return totalMarks;
    }

    public void calCGPA() {
        this.CGPA = (float) ((totalMarks * 100) / (maxMarks * 10));
    }

    public float getCgpa() {
        return CGPA;
    }

    public String getCgpaGrade() {
        return CGPAGrade;
    }

    public void calCGPAGrade() {
        String[] grade = {"F", "E", "D", "C", "B", "A", "O"};
        double j = 1.4285;
        for (int i = 0; j < 10; i += 1) {
            if (j > CGPA) {
                this.CGPAGrade = grade[i];
                break;
            }
            j += 1.4285;
        }
    }
}
