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
        String route1 = Directories.LEXER_PATH;
        String route2 = Directories.SIMPLIFIED_LEXER_CUP_PATH;
        String[] routeS = {"-parser", "Sintax", Directories.SYNTAX_PATH};
        generar(route1, route2, routeS);
    }
    public static void generar(String route1, String route2, String[] routeS) throws IOException, Exception{
        File archivo;
        archivo = new File(route1);
        jflex.Main.generate(archivo);
        archivo = new File(route2);
        jflex.Main.generate(archivo);
        java_cup.Main.main(routeS);
        
        Path routeSym = Paths.get(Directories.SYM_PATH);
        if (Files.exists(routeSym)) {
            Files.delete(routeSym);
        }
        Files.move(
                Paths.get(Directories.SIMPLIFIED_SYM_PATH),
                Paths.get(Directories.SYM_PATH)
        );
        Path routeSyntax = Paths.get(Directories.SYNTAX_PATH);
        if (Files.exists(routeSyntax)) {
            Files.delete(routeSyntax);
        }
        Files.move(
                Paths.get(Directories.SIMPLIFIED_SYNTAX_PATH),
                Paths.get(Directories.SYNTAX_PATH)
        );
    }
}
