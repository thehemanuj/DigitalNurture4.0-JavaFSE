package singletonpatternexample;


class Logger {
    private static Logger instance;
    private int value;  

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) 
            instance=new Logger();
        return instance;
    }

    public void log(int val) {
        value = val;
        System.out.println(value);
    }

    public int getValue() {
        return value;
    }
}
