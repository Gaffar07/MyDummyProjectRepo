
public class fibonacci {

	public static void main(String[] args) {
		
		int n=10,num1=0,num2=1;
		
		for(int i=0;i<=n;i++) {
			System.out.println(num1);
			int sum=num1+num2;  //sum=1,2,3
			num1=num2;			//num1=1,1,2
			num2=sum;			//num2=1,2,3
		}

	}

}
