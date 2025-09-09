public class classA {
    public static void main(String[] args) {
        C one = new C(); // This will print: "i am A", "i am B", "i am C"
    }
}

class A {
    String name;

    A() {
        this.name = "i am A";
        System.out.println(name);
    }
}

class B extends A {
    B() {
        this.name = "i am B";
        System.out.println(name);
    }
}

class C extends B {
    C() {
        this.name = "i am C";
        System.out.println(name);
    }
}
