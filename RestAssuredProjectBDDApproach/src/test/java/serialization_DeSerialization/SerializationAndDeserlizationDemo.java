package serialization_DeSerialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationAndDeserlizationDemo {

	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub
		Dog d1 = new Dog();
		
		FileOutputStream fos = new FileOutputStream("bcd.ser");
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		//write the object to a file
		oos.writeObject(d1);
		
		//Read the file 
		
		
		FileInputStream fis = new FileInputStream("bcd.ser");
		
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Dog d2	= (Dog) ois.readObject();
		
		//now print the values
		
		System.out.println("The values from the stored file are "+d2.i+" and "+d2.j);
	}

}



class Dog implements Serializable
{
	
	
	int i =10;
	
	int j =20;
}
