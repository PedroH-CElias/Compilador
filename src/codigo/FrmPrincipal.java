/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;

import static codigo.sym.Linea;

/**
 *
 * @author Charly Ponce
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private void analizarLexico() throws IOException{
        int cont = 1;
        
        String expr = (String) txtResultado.getText();
        AnalisadorLexico lexer = new AnalisadorLexico(new StringReader(expr));
        String resultado = "LINEA " + cont + "\t\tSIMBOLO\n";
        while (true) {
            Token token = lexer.yylex();
            if (token == null) {
                txtAnalizarLex.setText(resultado);
                return;
            }
            switch (token) {
                case LINHA:
                    cont++;
                    resultado += "LINHA " + cont + "\n";
                    break;
                case ID_INVALIDO:
                    resultado += "  <Comillas>\t\t" + lexer.lexeme + "\n";
                    break;
                case ERRO:
                    resultado += "ERRO \t\t" + lexer.lexeme + "\n";
                    break;
                case PROGRAMA:
                    resultado += "PROGRAMA \t\t" + lexer.lexeme + "\n";
                    break;
                case UTILIZE:
                    resultado += "UTILIZE \t\t" + lexer.lexeme + "\n";
                    break;
                case BIB_IO:
                    resultado += "BIB_IO \t\t" + lexer.lexeme + "\n";
                    break;
                case CONST:
                    resultado += "CONST \t\t" + lexer.lexeme + "\n";
                    break;
                case INICIO:
                    resultado += "INICIO \t\t" + lexer.lexeme + "\n";
                    break;
                case FIM:
                    resultado += "FIM \t\t" + lexer.lexeme + "\n";
                    break;
                case INTEIRO:
                    resultado += "INTEIRO \t\t" + lexer.lexeme + "\n";
                    break;
                case REAL:
                    resultado += "REAL \t\t" + lexer.lexeme + "\n";
                    break;
                case CARACTERE:
                    resultado += "CARACTERE \t\t" + lexer.lexeme + "\n";
                    break;
                case PALAVRA:
                    resultado += "PALAVRA \t\t" + lexer.lexeme + "\n";
                    break;
                case LOGICO:
                    resultado += "LOGICO \t\t" + lexer.lexeme + "\n";
                    break;
                case VAR:
                    resultado += "VAR \t\t" + lexer.lexeme + "\n";
                    break;
                case ARRANJO:
                    resultado += "ARRANJO \t\t" + lexer.lexeme + "\n";
                    break;
                case LEIA:
                    resultado += "LEIA \t\t" + lexer.lexeme + "\n";
                    break;
                case LEIA_LN:
                    resultado += "LEIA_LN \t\t" + lexer.lexeme + "\n";
                    break;
                case ESCREVA:
                    resultado += "ESCREVA \t\t" + lexer.lexeme + "\n";
                    break;
                case ESCREVA_LN:
                    resultado += "ESCREVA_LN \t\t" + lexer.lexeme + "\n";
                    break;
                case SE:
                    resultado += "SE \t\t" + lexer.lexeme + "\n";
                    break;
                case ENTAO:
                    resultado += "ENTAO \t\t" + lexer.lexeme + "\n";
                    break;
                case SENAO:
                    resultado += "SENAO \t\t" + lexer.lexeme + "\n";
                    break;
                case PARA:
                    resultado += "PARA \t\t" + lexer.lexeme + "\n";
                    break;
                case DE:
                    resultado += "DE \t\t" + lexer.lexeme + "\n";
                    break;
                case ATE:
                    resultado += "ATE \t\t" + lexer.lexeme + "\n";
                    break;
                case FACA:
                    resultado += "FACA \t\t" + lexer.lexeme + "\n";
                    break;
                case ENQUANTO:
                    resultado += "ENQUANTO \t\t" + lexer.lexeme + "\n";
                    break;
                case REPITA:
                    resultado += "REPITA \t\t" + lexer.lexeme + "\n";
                    break;
                case PROCEDIMENTO:
                    resultado += "PROCEDIMENTO \t\t" + lexer.lexeme + "\n";
                    break;
                case FUNCAO:
                    resultado += "FUNCAO \t\t" + lexer.lexeme + "\n";
                    break;
                case OU:
                    resultado += "OU \t\t" + lexer.lexeme + "\n";
                    break;
                case E:
                    resultado += "E \t\t" + lexer.lexeme + "\n";
                    break;
                case NAO:
                    resultado += "NAO \t\t" + lexer.lexeme + "\n";
                    break;
                case ABRE_PARENTESES:
                    resultado += "ABRE_PARENTESES \t\t" + lexer.lexeme + "\n";
                    break;
                case FECHA_PARENTESES:
                    resultado += "FECHA_PARENTESES \t\t" + lexer.lexeme + "\n";
                    break;
                case ASPAS_DUPLAS:
                    resultado += "ASPAS_DUPLAS \t\t" + lexer.lexeme + "\n";
                    break;
                case ASPAS_SIMPLES:
                    resultado += "ASPAS_SIMPLES \t\t" + lexer.lexeme + "\n";
                    break;
                case PONTO:
                    resultado += "PONTO \t\t" + lexer.lexeme + "\n";
                    break;
                case VIRGULA:
                    resultado += "VIRGULA \t\t" + lexer.lexeme + "\n";
                    break;
                case ABRE_CHAVES:
                    resultado += "ABRE_CHAVES \t\t" + lexer.lexeme + "\n";
                    break;
                case FECHA_CHAVES:
                    resultado += "FECHA_CHAVES \t\t" + lexer.lexeme + "\n";
                    break;
                case ABRE_COLCHETE:
                    resultado += "ABRE_COLCHETE \t\t" + lexer.lexeme + "\n";
                    break;
                case FECHA_COLCHETE:
                    resultado += "FECHA_COLCHETE \t\t" + lexer.lexeme + "\n";
                    break;
                case MAIOR:
                    resultado += "MAIOR \t\t" + lexer.lexeme + "\n";
                    break;
                case MENOR:
                    resultado += "MENOR \t\t" + lexer.lexeme + "\n";
                    break;
                case DIFERENTE:
                    resultado += "DIFERENTE \t\t" + lexer.lexeme + "\n";
                    break;
                case MENOR_IGUAL:
                    resultado += "MENOR_IGUAL \t\t" + lexer.lexeme + "\n";
                    break;
                case MAIOR_IGUAL:
                    resultado += "MAIOR_IGUAL \t\t" + lexer.lexeme + "\n";
                    break;
                case RESTO_DIVISAO:
                    resultado += "RESTO_DIVISAO \t\t" + lexer.lexeme + "\n";
                    break;
                case POTENCIA:
                    resultado += "POTENCIA \t\t" + lexer.lexeme + "\n";
                    break;
                case ATRIBUICAO:
                    resultado += "ATRIBUICAO \t\t" + lexer.lexeme + "\n";
                    break;
                case IGUALDADE:
                    resultado += "IGUALDADE \t\t" + lexer.lexeme + "\n";
                    break;
                case SOMA:
                    resultado += "SOMA \t\t" + lexer.lexeme + "\n";
                    break;
                case MULTIPLICACAO:
                    resultado += "MULTIPLICACAO \t\t" + lexer.lexeme + "\n";
                    break;
                case SUBTRACAO:
                    resultado += "SUBTRACAO \t\t" + lexer.lexeme + "\n";
                    break;
                case DIVISAO:
                    resultado += "DIVISAO \t\t" + lexer.lexeme + "\n";
                    break;
                case ID:
                    resultado += "ID \t\t" + lexer.lexeme + "\n";
                    break;
                case BRANCO:
                    resultado += "BRANCO \t\t" + lexer.lexeme + "\n";
                    break;
                default:
                    resultado += "Token desconhecido: " + lexer.lexeme + "\n";
                    break;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnArchivo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAnalizarLex = new javax.swing.JTextArea();
        btnAnalizarLex = new javax.swing.JButton();
        btnLimpiarLex = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAnalizarSin = new javax.swing.JTextArea();
        btnAnalizarSin = new javax.swing.JButton();
        btnLimpiarSin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Analizador Lexico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        btnArchivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnArchivo.setText("Abrir archivo");
        btnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoActionPerformed(evt);
            }
        });

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        txtAnalizarLex.setEditable(false);
        txtAnalizarLex.setColumns(20);
        txtAnalizarLex.setRows(5);
        jScrollPane2.setViewportView(txtAnalizarLex);

        btnAnalizarLex.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAnalizarLex.setText("Analizar");
        btnAnalizarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarLexActionPerformed(evt);
            }
        });

        btnLimpiarLex.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLimpiarLex.setText("Limpiar");
        btnLimpiarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarLexActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAnalizarLex)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiarLex))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(386, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnArchivo)
                    .addComponent(btnAnalizarLex)
                    .addComponent(btnLimpiarLex))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 50, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Analizador Sintactico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        txtAnalizarSin.setEditable(false);
        txtAnalizarSin.setColumns(20);
        txtAnalizarSin.setRows(5);
        jScrollPane3.setViewportView(txtAnalizarSin);

        btnAnalizarSin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAnalizarSin.setText("Analizar");
        btnAnalizarSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarSinActionPerformed(evt);
            }
        });

        btnLimpiarSin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLimpiarSin.setText("Limpiar");
        btnLimpiarSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarSinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAnalizarSin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiarSin))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnalizarSin)
                    .addComponent(btnLimpiarSin))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File archivo = new File(chooser.getSelectedFile().getAbsolutePath());
        
        try {
            String ST = new String(Files.readAllBytes(archivo.toPath()));
            txtResultado.setText(ST);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnArchivoActionPerformed

    private void btnLimpiarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarLexActionPerformed
        // TODO add your handling code here:
        txtAnalizarLex.setText(null);
    }//GEN-LAST:event_btnLimpiarLexActionPerformed

    private void btnLimpiarSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarSinActionPerformed
        // TODO add your handling code here:
        txtAnalizarSin.setText(null);
    }//GEN-LAST:event_btnLimpiarSinActionPerformed

    private void btnAnalizarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarLexActionPerformed
        try {
            analizarLexico();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAnalizarLexActionPerformed

    private void btnAnalizarSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarSinActionPerformed
        // TODO add your handling code here:
        String ST = txtResultado.getText();
        Sintax s = new Sintax(new codigo.LexerCup(new StringReader(ST)));
        
        try {
            s.parse();
            txtAnalizarSin.setText("Analisis realizado correctamente");
            txtAnalizarSin.setForeground(new Color(25, 111, 61));
        } catch (Exception ex) {
            Symbol sym = s.getS();
            txtAnalizarSin.setText("Error de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
            txtAnalizarSin.setForeground(Color.red);
        }
    }//GEN-LAST:event_btnAnalizarSinActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizarLex;
    private javax.swing.JButton btnAnalizarSin;
    private javax.swing.JButton btnArchivo;
    private javax.swing.JButton btnLimpiarLex;
    private javax.swing.JButton btnLimpiarSin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtAnalizarLex;
    private javax.swing.JTextArea txtAnalizarSin;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
