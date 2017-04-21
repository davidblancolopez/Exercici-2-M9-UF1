
package exercici.pkg2.m9.uf1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;


public class fitxerUsuaris {
    
    File fitxerUsuaris = new File("usuarios.txt");
    String contrasenya = "DAM_M09_FERRERIA$13-14";
    SecretKey clau;
    String cadena_iv = "0123456789ABCDEF"; 
    byte [] cadena = new byte[1024];
    
    private void addKey(){
        
    }
    
    /**
     * Metodo para cifrar un fichero.
     *
     * @param fitxer
     * @param clau
     */
    public void encryptFile(String fitxer, SecretKey clau) throws FileNotFoundException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IOException, IllegalBlockSizeException, BadPaddingException {
        //Creamos el FileInput Stream para leer el archivo.
        FileInputStream fis = new FileInputStream(fitxer);
        //Creamos el FileOutputStream para escribir en el fichero.
        FileOutputStream fos = new FileOutputStream(new File("mensajeCifrado.txt"));
        
        //Creamos un cifrador para cifrar el texto.
        Cipher cifrador = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cifrador.init(Cipher.ENCRYPT_MODE, clau);
        
        //Creamos un buffer que es un array de bytes donde almacenaremos el texto.
        byte[] buffer = new byte[1000];
        
        int bytes;
        //Utilizamos un bucle para ir leyendo el archivo de texto que le hemos pasado.
        while((bytes = fis.read(buffer, 0, buffer.length))!=-1){
            cifrador.update(buffer, 0, bytes);
        }
        
        //Escribimos el archivo cifrado.
        fos.write(cifrador.doFinal());
    }
    
    
    /**
     * Metodo para descifrar un fichero.
     *
     * @param fitxerEncriptat
     * @param clave
     * @param fitxerDesencriptat
     */
    public void decryptFile(String fitxerEncriptat, SecretKey clave, String fitxerDesencriptat) throws FileNotFoundException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
        //Creamos el FileInputStream
        FileInputStream fis = new FileInputStream(fitxerEncriptat);
        //Creamos el FileOutputStream para escribir en el fichero.
        FileOutputStream fos = new FileOutputStream(new File(fitxerDesencriptat));
        
        //Creamos un descifrador para descifrar el texto del fichero Encriptado.
        Cipher descifrador = Cipher.getInstance("AES/ECB/PKCS5Padding");
        descifrador.init(Cipher.DECRYPT_MODE, clave);
        
        //Creamos un buffer que es un array de bytes donde almacenaremos el texto.
        byte[] buffer = new byte[1000];
        int bytes;
        
        //Utilizamos un bucle para ir leyendo el archivo de texto Encriptado que le hemos pasado.
        while((bytes = fis.read(buffer, 0, buffer.length))!=-1){
            descifrador.update(buffer, 0, bytes);
        }

        //Escribimos el archivo desencriptado.
        fos.write(descifrador.doFinal());
        
    }
    
    private void adduserFile(Usuari usuari) throws FileNotFoundException{
        FileInputStream fis = new FileInputStream(fitxerUsuaris);
        
        
    }
    
    private void showFile() throws FileNotFoundException{
        FileOutputStream fos = new FileOutputStream(fitxerUsuaris);
    }
    
}
