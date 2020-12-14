package freshworks;

import java.util.Scanner;

public class CRD {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int flag = 0;
		while(flag == 0)
		{
		System.out.println("ENTER OPERATION : CREATE - to create a new key value pair, READ - to read a key value pair, DELETE - to delete a key value pair, any other input to exit");
		String op = sc.next();
		String key;
		Singleton tmp = Singleton.getInstance( );
		if("CREATE".equals(op)){
			String name;
			String age;
			System.out.println("Enter key");
			key = sc.next();
			System.out.println("Enter Name");
			name = sc.next();
			System.out.println("Enter Age");
			age = sc.next();
			JSONObject obj = new JSONObject(name, age , new java.util.Date().getTime());
			tmp.performFileOperation(op, key, obj);
			System.out.println("Operation Done");
		}
		else if("READ".equals(op) || "DELETE".equals(op))
		{
			System.out.println("Enter key");
			key = sc.next();
			tmp.performFileOperation(op, key, null);
			System.out.println("Operation Done");
		}
		else
		{
			flag = 1;
		}
		}
		sc.close();
	}
}
