package edu.ucam.internal.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.Hashtable;

public class UserService {
	static String path = System.getProperty("java.io.tmpdir") + "users.dat";
	protected static Hashtable<Number, User> list = new Hashtable<Number, User>();
	protected static int autoincrement = 1;

	public static Hashtable<Number, User> findAll() {
		if (list.size() == 0) {
			get();
		}

		return list;
	}

	public static User findOne(Number id) {
		if (list.size() == 0) {
			get();
		}

		return list.get(id);
	}

	public static User findByLogin(String login) {
		if (list.size() == 0) {
			get();
		}

		Enumeration<Number> i = list.keys();
		Number id;
		User user;

		while (i.hasMoreElements()) {
			id = (Number) i.nextElement();
			user = list.get(id);
			if (user.getLogin().equals(login)) {
				return user;
			}
		}
		return null;
	}

	public static void update(Number id, User modUser) {
		list.put(id, modUser);
		set();
		get();
	}

	public static void insert(Number id, User newUser) {
		list.put(id, newUser);
		set();
		get();
	}

	public static void remove(Number id) {
		list.remove(id);
		set();
		get();
	}

	public static Number getNextId() {
		return autoincrement + 1;
	}

	private static void get() {
		try {
			File file = new File(UserService.path);
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
				list = new Hashtable<Number, User>();
			} else {
				list = (Hashtable<Number, User>) obj.readObject();

				// Cogiendo el m�ximo (autoincrement)
				for (Number key : list.keySet()) {
					autoincrement = Math.max(autoincrement, (int) key);
				}
			}
		} catch (Error e) {
			list = new Hashtable<Number, User>();
			e.printStackTrace();
		} catch (IOException e) {
			list = new Hashtable<Number, User>();
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			list = new Hashtable<Number, User>();
			e.printStackTrace();
		}
	}

	private static void set() {
		try {
			File file = new File(UserService.path);
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
		} catch (Error e) {
			list = new Hashtable<Number, User>();
			e.printStackTrace();
		} catch (IOException e) {
			list = new Hashtable<Number, User>();
			e.printStackTrace();
		}
	}

}
