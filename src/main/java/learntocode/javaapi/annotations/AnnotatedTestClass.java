package learntocode.javaapi.annotations;

public class AnnotatedTestClass {

    @TestAnnotation(10)
    public void demonstrateValueAnnotationsFiledName() {
        System.out.println("Something is done!");
    }

    @TestAnnotation(value = 99, str = "World")
    public void demonstrateAnnotation() {
        System.out.println("Something is done againt!");
    }
}
