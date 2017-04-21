
package exercici.pkg2.m9.uf1;

import java.io.File;
import java.io.IOException;
import javax.crypto.SecretKey;


public class Test {


    public static void main(String[] args) throws IOException {
        
        File fitxer = new File("usuarios.txt");
        File fitxer2 = new File("usuariosDes.txt");
        
        //Creem els usuaris.
        Usuari us1 = new Usuari("12345678A", "David", "Blanco", "López");

        Usuari us2 = new Usuari("45879632B", "Pepe", "Goteras", "López");
        
        //Creem el fitxer d'usuaris.
        fitxerUsuaris fu = new fitxerUsuaris();
        
        
        //Afegim els usuaris al fitxer d'usuaris.
        fu.adduserFile(us1);
        
        fu.adduserFile(us2);
        
        //Mostrem el fitxer d'usuaris.
        fu.showFile();
        
        //Creem la clau per encriptar.
        SecretKey key = fu.addKey(us1.getUsuari());
        
        
   
        
        
        
    }
    
}
