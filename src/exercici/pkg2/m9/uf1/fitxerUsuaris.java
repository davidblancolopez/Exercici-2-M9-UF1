
package exercici.pkg2.m9.uf1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.crypto.SecretKey;


public class fitxerUsuaris {
    
    File fitxerUsuaris = new File("usuarios.txt");
    String contrasenya = "DAM_M09_FERRERIA$13-14";
    SecretKey clau;
    String cadena_iv = "0123456789ABCDEF"; 
    byte [] cadena = new byte[1024];
    
    private void addKey(){
        
    }
    
    private void encryptFile(){
        
    }
    
    private void decryptFile(){
        
    }
    
    private void adduserFile() throws FileNotFoundException{
        FileInputStream fis = new FileInputStream(fitxerUsuaris);
    }
    
    private void showFile() throws FileNotFoundException{
        FileOutputStream fos = new FileOutputStream(fitxerUsuaris);
    }
    
}
