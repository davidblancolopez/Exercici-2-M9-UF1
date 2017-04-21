
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
    private String cognom;
    private String usuari;
    private String password;

    public Usuari(String nom, String cognom, String dni) {
        this.dni = dni;
        this.nom = nom;
        this.cognom = cognom;
        
        this.usuari = nom + cognom + dni;
    }
    
    public String getUsuari(){
        return usuari;
    }
    
    private void xifrarPassword(){
        
    }
    
    
    public String generarPassword(){
        String contrasenya = "";
        
        
        
        return contrasenya;
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
    
    
}
