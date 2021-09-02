package day2;

import java.io.*;
import java.util.*;

public class MainEtudiant {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		List<Etudiant> etudiants = new ArrayList<>();
		etudiants.add(new Etudiant("Tommy", 25));
		etudiants.add(new Etudiant("Peter", 28));

		File dataFile = new File("etudiants.data");
		createEtudiantsFile(etudiants, dataFile);
		System.out.println(getEtudiants(dataFile));
		//System.out.println("Ok");

	}

	public static void createEtudiantsFile(List<Etudiant> etudiants, File dataFile) throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(dataFile)))) {
			for (Etudiant etudiant : etudiants) {
				out.writeObject(etudiant);
			}
		}
	}

	public static List<Etudiant> getEtudiants(File dataFile) throws IOException, ClassNotFoundException {
		List<Etudiant> animals = new ArrayList<Etudiant>();
		try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
			while (true) {
				Object object = in.readObject();
				if (object instanceof Etudiant) {
					animals.add((Etudiant) object);
				}
			}
		} catch (EOFException e) {
			//File end reached
		}
		return animals;
	}

}
