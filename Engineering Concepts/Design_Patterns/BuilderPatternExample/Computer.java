package BuilderPatternExample;

public class Computer {
    private final String CPU;
    private final String RAM;
    private final String Storage;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.Storage = builder.Storage;
    }

    public static class Builder {
        private final String CPU;
        private final String RAM;
        private String Storage;

        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public Builder setStorage(String Storage) {
            this.Storage = Storage;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + Storage + "]";
    }
}
