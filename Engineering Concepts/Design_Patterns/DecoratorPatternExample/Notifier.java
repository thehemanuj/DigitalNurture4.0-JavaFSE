package DecoratorPatternExample;

public interface Notifier {
    public void send(String message);
}

class EmailNotifier implements Notifier{
    @Override
    public void send(String message){
        System.out.println(message+"Email sent");
    }
}
