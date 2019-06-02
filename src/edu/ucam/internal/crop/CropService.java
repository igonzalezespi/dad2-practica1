package edu.ucam.internal.crop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.Hashtable;

import edu.ucam.internal.farm.Farm;
import edu.ucam.internal.farm.FarmService;

public class CropService {
	static String path = System.getProperty("java.io.tmpdir") + "crops.dat";
	protected static Hashtable<Number, Crop> list = new Hashtable<Number, Crop>();
	protected static int autoincrement = 1;

	public static Hashtable<Number, Crop> findAll() {
		if (list.size() == 0) {
			get();
		}

		return list;
	}

	public static Crop findOne(Number id) {
		if (list.size() == 0) {
			get();
		}

		return list.get(id);
	}

	public static void update(Number id, Crop modCrop) {
		list.put(id, modCrop);
		set();
		get();
	}

	public static void insert(Number id, Crop newCrop) {
		list.put(id, newCrop);
		set();
		get();
	}

	public static void remove(Number id) {
		// Check si existe en una finca
		if (check(id)) {
			list.remove(id);
			set();
			get();
		}
	}

	public static Hashtable<Number, Crop> findAllInString(String ids) {
		if (ids == null || ids.isEmpty()) {
			return new Hashtable<Number, Crop>();
		}
		String[] idsStr = ids.split("\\-"); 
		Hashtable<Number, Crop> all = CropService.findAll();
		Hashtable<Number, Crop> selected = new Hashtable<Number, Crop>();

		for (int i = 0; i < idsStr.length; i++) {
			Number id = (Number) Integer.parseInt(idsStr[i]);
			selected.put(id, all.get(id));
		}
		return selected;
	}
	
	private static boolean check(Number id) {
		Hashtable<Number, Farm> list = FarmService.findAll();
		if (list != null && list.size() > 0) {
			Enumeration<Number> i = list.keys();
			while (i.hasMoreElements()) {
				// Recorremos las fincas buscando una con el cultivo a borrar. FALSE si se encuentra el cultivo
				if (list.get(i.nextElement()).getCrops().get(id) != null) {
					return false;
				}
			}
		}
		return true;
	}

	public static Number getNextId() {
		return autoincrement + 1;
	}

	private static void get() {
		try {
			File file = new File(CropService.path);
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
				list = new Hashtable<Number, Crop>();
			} else {
				list = (Hashtable<Number, Crop>) obj.readObject();

				// Cogiendo el máximo (autoincrement)
				for (Number key : list.keySet()) {
					autoincrement = Math.max(autoincrement, (int) key);
				}
			}
		} catch (Error e) {
			list = new Hashtable<Number, Crop>();
			e.printStackTrace();
		} catch (IOException e) {
			list = new Hashtable<Number, Crop>();
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			list = new Hashtable<Number, Crop>();
			e.printStackTrace();
		}
	}

	private static void set() {
		try {
			File file = new File(CropService.path);
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
			list = new Hashtable<Number, Crop>();
			e.printStackTrace();
		} catch (IOException e) {
			list = new Hashtable<Number, Crop>();
			e.printStackTrace();
		}
	}

}
