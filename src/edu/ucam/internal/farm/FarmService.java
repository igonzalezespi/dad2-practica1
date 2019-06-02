package edu.ucam.internal.farm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

public class FarmService {
	static String path = System.getProperty("java.io.tmpdir") + "farms.dat";
	protected static Hashtable<Number, Farm> list = new Hashtable<Number, Farm>();
	protected static int autoincrement = 1;

	public static Hashtable<Number, Farm> findAll() {
		if (list.size() == 0) {
			get();
		}

		return list;
	}

	public static Farm findOne(Number id) {
		if (list.size() == 0) {
			get();
		}

		return list.get(id);
	}

	public static void update(Number id, Farm modFarm) {
		list.put(id, modFarm);
		set();
		get();
	}

	public static void insert(Number id, Farm newFarm) {
		list.put(id, newFarm);
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
			File file = new File(FarmService.path);
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
				list = new Hashtable<Number, Farm>();
			} else {
				list = (Hashtable<Number, Farm>) obj.readObject();

				// Cogiendo el máximo (autoincrement)
				for (Number key : list.keySet()) {
					autoincrement = Math.max(autoincrement, (int) key);
				}
			}
		} catch (Error e) {
			list = new Hashtable<Number, Farm>();
			e.printStackTrace();
		} catch (IOException e) {
			list = new Hashtable<Number, Farm>();
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			list = new Hashtable<Number, Farm>();
			e.printStackTrace();
		}
	}

	private static void set() {
		try {
			File file = new File(FarmService.path);
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
			list = new Hashtable<Number, Farm>();
			e.printStackTrace();
		} catch (IOException e) {
			list = new Hashtable<Number, Farm>();
			e.printStackTrace();
		}
	}

}
