import java.util.Scanner;
public class TESt {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Geben Sie ein ob 1 oder 2");
		System.out.println(Jensi(sc.nextInt()));
		sc.close();
	}
	private static String Jensi(int a){
		if(a==1){
			return "Sie haben keine 1 eingegeben";
		}else if(a==2){
			return "Sie haben keine 2 eingegeben";
		}else{
			return "Sie haben 1 und 2 eingegeben";
		}
		
		
	}
}
