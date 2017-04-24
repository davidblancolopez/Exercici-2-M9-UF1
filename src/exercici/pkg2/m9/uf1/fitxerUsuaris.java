
package exercici.pkg2.m9.uf1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/*  ESTA SENSE PROBAR PERQUE A CASA NO HABIA MODIFICAT ELS ARXIUS DE JAVA I NO PODIA FER LA PROVA BÉ*/

public class fitxerUsuaris {
    
    private File fitxerUsuaris = new File("usuarios.txt");
    private SecretKey clau;
    String cadena_iv = "0123456789ABCDEF"; 
    public static final byte[] IV_PARAM = {0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07,
        0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F};
    
    public SecretKey addKey(String pass) throws UnsupportedEncodingException, NoSuchAlgorithmException{
       
            byte[] data = pass.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(data);
            System.out.println("Clave generada correctamente.");
            clau = new SecretKeySpec(hash, "AES");
        
        return clau;
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
        Cipher cifrador = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(cadena_iv.getBytes());
        cifrador.init(Cipher.ENCRYPT_MODE, clau);
        
        //Creamos un buffer que es un array de bytes donde almacenaremos el texto.
        byte[] buffer = new byte[1024];
        
        int bytes;
        //Utilizamos un bucle para ir leyendo el archivo de texto que le hemos pasado.
        while((bytes = fis.read(buffer, 0, buffer.length))!=-1){
            byte [] update = cifrador.update(buffer, 0, bytes);
            fos.write(cifrador.doFinal());
        }
        
        //Cerramos recursos.
        fos.write(cifrador.doFinal());
        fis.close();
        fos.close();
        
        
    }
    
    
    /**
     * Metodo para descifrar un fichero.
     *
     * @param fitxerEncriptat
     * @param clave
     * @param fitxerDesencriptat
     */
    public void decryptFile(String fitxerEncriptat, SecretKey clave, String fitxerDesencriptat) throws FileNotFoundException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        //Creamos el FileInputStream
        FileInputStream fis = new FileInputStream(fitxerEncriptat);
        //Creamos el FileOutputStream para escribir en el fichero.
        FileOutputStream fos = new FileOutputStream(new File(fitxerDesencriptat));
        
        //Creamos un descifrador para descifrar el texto del fichero Encriptado.
        Cipher descifrador = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(cadena_iv.getBytes());
        descifrador.init(Cipher.DECRYPT_MODE, clave, iv);

        byte[] buffer = new byte[1024];
        int bytes;
        
        //Utilizamos un bucle para ir leyendo el archivo de texto Encriptado que le hemos pasado.
        while((bytes = fis.read(buffer, 0, buffer.length))!=-1){
            byte [] update = descifrador.update(buffer, 0, bytes);
            fos.write(descifrador.doFinal());
        }
        
        //Cerramos recursos.
        fos.write(descifrador.doFinal());
        fis.close();
        fos.close();
        
        
    }
    
    /**
     * Metode per afegir usuaris al fitxer.
     * @param usuari
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void adduserFile(Usuari usuari) throws FileNotFoundException, IOException{
        FileWriter fw = new FileWriter(fitxerUsuaris, true);
        
        fw.write(usuari.getDni());
        fw.write(usuari.getNom());
        fw.write(usuari.getCognom1());
        fw.write(usuari.getCognom2());
        fw.write(usuari.getPassword());
        
        fw.close();
    }
    
    /**
     * Metode per a mostrar el fitxer.
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void showFile() throws FileNotFoundException, IOException{
        ArrayList<String> arxiu = new ArrayList<>();
        
        BufferedReader br = new BufferedReader(new FileReader(fitxerUsuaris));
        
        String usuari;
        
        while((usuari = br.readLine()) != null){
            arxiu.add(usuari);
        }
        
        for (int i = 0; i < arxiu.size(); i++) {
            System.out.println(arxiu.get(i));
        }
    }
    
}
