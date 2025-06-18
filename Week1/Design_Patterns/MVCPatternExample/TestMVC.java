package MVCPatternExample;

public class TestMVC {
    public static void main(String[] args) {
        Student model = new Student("Alice", "101", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        controller.updateView();

        controller.setStudentName("Bob");
        controller.setStudentGrade("B+");

        controller.updateView();
    }
}
