package program1;
class program1 {
	String name;
	int age;
	
	void displayInfo() {
		System.out.print("name :" +name + ", age:" +age);
	}

	public static void main(String[] args) {
		program1 p1= new program1();
		p1.name ="suzaina";
		p1.age=19;
		p1.displayInfo();	

	}

}
