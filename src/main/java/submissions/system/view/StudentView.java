package submissions.system.view;

public class StudentView {
    public void printStudentDetails(int matNum, String fName, String lName) {
        System.out.println("Student: ");
        System.out.println("Name: " + fName + " " + lName);
        System.out.println("Matriculation Number: " + matNum);
    }
}
