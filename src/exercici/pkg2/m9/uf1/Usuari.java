
package exercici.pkg2.m9.uf1;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class Usuari {
    private String dni;
    private String nom; 
    private String cognom1;
    private String cognom2;
    private String usuari;
    private String password;

    public static String caracters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdef"
            + "ghijklmnopqrstuvwxyzñÑ=/-";
    
    public Usuari(String dni, String nom, String cognom1, String cognom2) {
        this.dni = dni;
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        
        this.usuari = nom.substring(0, 1) + cognom1 + cognom2 + dni.substring(5, 8);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
        
    
    
    
    /**
     * Metodo para generar la clave a partir del nombre de usuario.
     *
     * @param usuari
     * @param tamany
     * @return
     */
    public SecretKey generarClau(String usuari, int tamany) throws UnsupportedEncodingException {
        SecretKey clau = null;

        if ((tamany == 128) || (tamany == 192) || (tamany == 256)) {
            try {
                byte[] data = usuari.getBytes("UTF-8");
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hash = md.digest(data);
                byte[] key = Arrays.copyOf(hash, tamany / 8);
                clau = new SecretKeySpec(key, "AES");
            } catch (NoSuchAlgorithmException ex) {
                System.err.println("Generador no disponible.");
            }
        }
        return clau;
    }
    
    /**
     * Metode per a crear aleatoriament la contrasenya.
     */
    public void crearContrasenya(){
        String pass = "";
        
        //Bucle que serveix per a recorrer l'array de caracters per a generar la contrasenya de forma
        //aleatoria.
        for (int i = 0; i < 20; i++) {
            pass += (caracters.charAt((int) (Math.random() * caracters.length())));
        }
        
        this.setPassword(pass);
    }
    
}
