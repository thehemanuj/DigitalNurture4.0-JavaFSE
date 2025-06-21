package ProxyPatternExample;

public class TestProxyPattern {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("scenery1.jpg");
        Image image2 = new ProxyImage("scenery2.jpg");

        // Image will be loaded from remote server
        image1.display();

        // Cached image will be used
        image1.display();

        // Image will be loaded from remote server
        image2.display();
    }
}
