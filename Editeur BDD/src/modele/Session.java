package modele;

import java.io.File;
import java.util.ArrayList;

public class Session {

	/**
	 * Nom de l'utilisateur
	 */
	private String nom;
	
	private String BDDPath;
	
	/**
	 * Initialise les attributs
	 * @param nom Le nom de l'utilisateur
	 */
	public Session(String nom){
		this.nom = nom;
		this.BDDPath = this.nom+"/ListeBDD/";
	}
	
	/**
	 * Acceder à la liste des noms des bases de données auquel l'utilisateur a acces
	 * @return liste des noms des bases de données auquel l'utilisateur a acces
	 */
	public ArrayList<String> getListeBDD(){
		
		ArrayList<String> ret = new ArrayList<String>();
		File file = new File(ELFichier.getRacine()+this.BDDPath);
		File[] files = file.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
            	ret.add(files[i].getName());
            }
        }
        return ret;
	}
	
	/**
	 * @return L'url où sont stockés les informations des BDD de l'utilisateur
	 */
	public String getBDDPath(){
		return this.BDDPath;
	}
	
	/**
	 * @return Le nom de l'utilisateur
	 */
	public String getNom(){
		return this.nom;
	}
}
