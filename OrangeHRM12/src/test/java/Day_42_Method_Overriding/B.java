package Day_42_Method_Overriding;

public class B extends A{

	public static void main(String[] args) throws Exception {
		
		A a1=new A();
		a1.Address();
	
		B b2=new B();
		b2.Address();

	}
	
	public void Address() throws Exception
	{
		System.out.println("Send Invoice to Home address");
		
	}

}
