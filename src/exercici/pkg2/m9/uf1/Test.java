
package exercici.pkg2.m9.uf1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;


public class Test {


    public static void main(String[] args) throws IOException, UnsupportedEncodingException, NoSuchAlgorithmException, FileNotFoundException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
         
        /*  ESTA SENSE PROBAR PERQUE A CASA NO HABIA MODIFICAT ELS ARXIUS DE JAVA I NO PODIA FER LA PROVA BÉ*/
        
        //Creem els usuaris.
        Usuari us1 = new Usuari("12345678A", "David", "Blanco", "López");
        us1.crearContrasenya();

        Usuari us2 = new Usuari("45879632B", "Pepe", "Goteras", "López");
        us2.crearContrasenya();
        
        //Creem el fitxer d'usuaris.
        fitxerUsuaris fu = new fitxerUsuaris();
        
        
        //Afegim els usuaris al fitxer d'usuaris.
        fu.adduserFile(us1);
        
        fu.adduserFile(us2);
        
        //Mostrem el fitxer d'usuaris.
        fu.showFile();
        
        //Creem la clau per encriptar.
        SecretKey key = fu.addKey(us1.getUsuari());
        
        //Encriptacio del fitxer.
        fu.encryptFile("usuarios.txt", key);
        
        //Desencriptació del fitxer.
        fu.decryptFile("usuariosDes", key, "usuariosDes2");
        
   
        
        
        
    }
    
}
