package edu.ucam.internal.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletContext;

public class UserService {
	ServletContext context;
	String path;
	protected static Hashtable<Number,User> list = new Hashtable<Number,User>();

	public UserService(ServletContext servletContext) {
		this.context = servletContext;
		this.path = this.context.getRealPath("WEB-INF" + File.separator + "users.dat");
	}
	
	public Hashtable<Number,User> findAll() {
		get();
		return list;
	}
	
	public User findOne(Number id) {
		get();
		return list.get(id);
	}
	
	public User findByLogin(String login) {
		get();
		Enumeration<Number> i = list.keys();
  		Number id;
  		User user;

  		while(i.hasMoreElements()) {
  			id = (Number) i.nextElement();
  			user = list.get(id);
  		   if (user.getLogin().equals(login)) {
  			   return user;
  		   }
  		}
		return null;
	}
	
	public void update(Number id, User modUser) {
		list.put(id, modUser);
		set();
	}
	
	public void insert(Number id, User newUser) {
		list.put(id, newUser);
		set();
	}
	
	public void remove(Number id) {
		list.remove(id);
		set();
	}
	
	public Number getNextId() {
		return list.size() + 1;
	}
	
	private void get() {
		try {
			File file = new File(this.path);
			ObjectInputStream obj = null;
			if (file.exists()) {
				try {
					FileInputStream fis = new FileInputStream(file);
					obj = new ObjectInputStream(fis);
				} catch (IOException e) {
					e.printStackTrace();
					throw e;
				}
			}
			if (obj == null) {
				list = new Hashtable<Number,User>();
			} else {
				list = (Hashtable<Number,User>) obj.readObject();
			}
		} catch(Error e) {
			list = new Hashtable<Number,User>();
			e.printStackTrace();
		} catch (IOException e) {
			list = new Hashtable<Number,User>();
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			list = new Hashtable<Number,User>();
			e.printStackTrace();
		}
	}
	
	private void set() {
		try {
			File file = new File(this.path);
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			FileOutputStream fout = new FileOutputStream(file);
			ObjectOutputStream obj = new ObjectOutputStream(fout);   
			obj.writeObject(list);
		} catch(Error e) {
			list = new Hashtable<Number,User>();
			e.printStackTrace();
		} catch (IOException e) {
			list = new Hashtable<Number,User>();
			e.printStackTrace();
		}
	}

}
