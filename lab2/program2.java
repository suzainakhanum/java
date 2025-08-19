package program2;
class program2 {
	String brand;
	int year;
	
	program2(String b, int y){
		brand=b;
		year=y;
	}
	void displayInfo() {
		System.out.println("car:"+brand+",year:"+year);
	}
	public static void main(String[]args) {
		program2 p1= new program2("Toyata",2020);
		program2 p2= new program2("Honda", 2022);
		p1.displayInfo();
		p2.displayInfo();	}
}
