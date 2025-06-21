package BuilderPatternExample;

public class TestBuilderPattern {
    public static void main(String[] args) {
        Computer basicPC = new Computer.Builder("Intel i5", "8GB")
                                .setStorage("512GB SSD")
                                .build();

        System.out.println(basicPC);
    }
}
