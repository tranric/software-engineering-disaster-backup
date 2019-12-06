package carregistry.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

// StackOverflow to the rescue!
// https://stackoverflow.com/questions/134492/how-to-serialize-an-object-into-a-string

public class ObjectEncoder {
	public static Object decode(String s){
		byte[] data = Base64.getDecoder().decode(s);
		Object o = null;
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
			o = ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return o;
	}
	
	public static String encode(Serializable o){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(o);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Base64.getEncoder().encodeToString(baos.toByteArray());
	}
}