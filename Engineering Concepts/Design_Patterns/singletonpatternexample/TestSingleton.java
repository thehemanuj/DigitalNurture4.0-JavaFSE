package singletonpatternexample;

public class TestSingleton {
    public static void main(String args[]){
        Logger one=Logger.getInstance();
        Logger two=Logger.getInstance();

        one.log(4);
        int a=two.getValue();
        System.out.println(a);

        if(one==two){
            System.out.println("Same instances");
        }else{
            System.out.println("Different instances");
        }
    }
}
