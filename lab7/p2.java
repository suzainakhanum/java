public class WrapperExample {
    public static void main(String[] args) {
        
       
        int a = 10;
        Integer obj = Integer.valueOf(a); // manually boxing (int → Integer)
        System.out.println("Wrapper Class (Boxing): " + obj);

        
        Integer num = a; // automatically converts int → Integer
        System.out.println("Autoboxing: " + num);

        
        int b = num; // automatically converts Integer → int
        System.out.println("Auto-unboxing: " + b);

        Double dObj = 55.6; // autoboxing (double → Double)
        double d = dObj;    // auto-unboxing (Double → double)
        System.out.println("Double Wrapper: " + dObj);
        System.out.println("After Auto-unboxing: " + d);
    }
}
