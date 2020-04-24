public class ArrayPrinter{
	static void print(Object[] data) {
		if(data == null) System.out.println("This object is null.");
		else {
			System.out.print("[");
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i] + ", ");
		}
			System.out.print("]\n");
		}
	} 
}