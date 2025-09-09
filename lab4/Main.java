public class Main {
    public static void main(String[] args) {
        B one = new B();
        String first = one.add("one","plus");
        int sec = one.add(1,2);
        double third = one.add(10000.0, 1299.0);
        System.out.println(sec);
        System.out.println(third);
        System.out.print(first);
    }
}
class A{
    int add(int a ,int b){
    return a+b;
    }
    double add(double a, double b){
        return a+b;
    }
}
class B extends A{
 String add(String a, String b){
     return a+b;
 }
}
