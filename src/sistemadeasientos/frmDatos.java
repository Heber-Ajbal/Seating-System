package sistemadeasientos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class frmDatos extends javax.swing.JFrame {

    private frmBus parentForm;
    public static String nombre;
    public String posicion;
    public float precio;
    private boolean ocupado;

    /**
     * Constructor para la ventana de ingreso de datos.
     *
     * @param parent El formulario principal (frmBus) que actúa como padre de
     * esta ventana.
     * @param aNombre El nombre del cliente.
     * @param aPrecio El precio del asiento.
     * @param aPosicion La posición del asiento.
     */
    public frmDatos(frmBus parent, String aNombre, float aPrecio, String aPosicion) {
        initComponents();
        parentForm = parent;
        posicion = aPosicion;
        nombre = aNombre;
        precio = aPrecio;
        CargarDatos();
    }

    public frmDatos() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("RESERVACION DE LOS ASIENTOS");

        jLabel2.setText("PRECIO:");

        jLabel3.setText("Q00.00");

        jLabel4.setText("LUGAR SELECCIONADO:");

        jLabel5.setText("Ventana");

        jLabel6.setText("NOMBRE:");

        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("CANCELAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que se ejecuta al hacer clic en el botón jButton1. Realiza
     * diferentes acciones dependiendo del estado del asiento. Si el asiento
     * está ocupado, elimina la reserva y actualiza la interfaz. Si el asiento
     * está disponible, recoge el nombre del cliente ingresado y envía los datos
     * al formulario principal. Finalmente, cierra la ventana actual.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (ocupado) {
            eliminarReserva();
            parentForm.EliminarDato(posicion);
        } else {
            nombre = txtNombre.getText();
            parentForm.EnviarDatos(nombre);
        }
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Este método se encarga de eliminar una reserva de un archivo de asientos.
     * Lee el archivo de entrada línea por línea, omite la línea que contiene la
     * posición del asiento a eliminar, y escribe las líneas restantes en un
     * archivo temporal. Luego, reemplaza el archivo original con el archivo
     * temporal.
     */
    private void eliminarReserva() {
        // Obtener la ruta del archivo de entrada y el nombre del archivo

        //NOTA IMPORTANTE:CAMBIAR A SU RUTA DONDE GUARDO EL PROYECTO
        String archivoEntrada = "D:\\Heber\\Documents\\github\\Seating-System\\src\\sistemadeasientos\\resource\\asientos.txt";
        File archivo = new File(archivoEntrada);
        String directorio = archivo.getParent();
        String nombreArchivo = archivo.getName();

        // Crear la ruta para el archivo de salida
        String rutaArchivoSalida = directorio + File.separator + "temp_" + nombreArchivo;

        try (BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));
                BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivoSalida))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.contains(posicion)) {
                    bw.write(linea);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Eliminar el archivo original y renombrar el archivo de salida
        File archivoSalida = new File(rutaArchivoSalida);
        archivo.delete();
        archivoSalida.renameTo(new File(directorio + File.separator + nombreArchivo));
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Este método se encarga de cargar los datos en la ventana de ingreso de
     * datos (frmDatos). Establece el tipo de asiento (ventana o pasillo) y el
     * precio según la posición del asiento. Si hay datos previamente ingresados
     * (nombre y precio), los muestra en la ventana y cambia el texto de los
     * botones.
     */
    private void CargarDatos() {
        if (posicion.contains("A") || posicion.contains("D")) {
            jLabel5.setText("VENTANA");
            jLabel3.setText("Q" + 5.00);

        } else {
            jLabel5.setText("PASILLO");
            jLabel3.setText("Q" + 10.00);
        }

        if (!nombre.equals("") && precio != 0) {
            txtNombre.setText(nombre);
            jLabel3.setText("Q" + precio);
            jButton1.setText("Cancelar Reservacion");
            jButton2.setText("Cerrar");
            ocupado = true;
            txtNombre.setEditable(false);
        } else {
            ocupado = false;
        }
    }

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
            java.util.logging.Logger.getLogger(frmDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
