/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Charly Ponce
 */
public class Principal {
    public static void main(String[] args) throws Exception {
        String ruta1 = Directories.LEXER_PATH;
        String ruta2 = Directories.SIMPLIFIED_LEXER_CUP_PATH;
        String[] rutaS = {"-parser", "Sintax", Directories.SYNTAX_PATH};
        generar(ruta1, ruta2, rutaS);
    }
    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
        File archivo;
        archivo = new File(ruta1);
        jflex.Main.generate(archivo);
        archivo = new File(ruta2);
        jflex.Main.generate(archivo);
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get(Directories.SYM_PATH);
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get(Directories.SIMPLIFIED_SYM_PATH),
                Paths.get(Directories.SYM_PATH)
        );
        Path rutaSin = Paths.get(Directories.SYNTAX_PATH);
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get(Directories.SIMPLIFIED_SYNTAX_PATH),
                Paths.get(Directories.SYNTAX_PATH)
        );
    }
}
