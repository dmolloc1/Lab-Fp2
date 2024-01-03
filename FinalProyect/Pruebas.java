import javax.swing.*;

public class Pruebas {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Ventana de mensaje "Ganaste" con botón para continuar
            JOptionPane.showMessageDialog(null, "¡Ganaste!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            int result = JOptionPane.showConfirmDialog(null, "¿Quieres continuar?", "Continuar",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                
                metodoContinuar();
            } else {
                // Lógica para hacer algo después de presionar "No" o cerrar la ventana
            }

            // Ventana de mensaje "Oh, suerte a la próxima" con botón para continuar
            JOptionPane.showMessageDialog(null, "¡Oh, suerte a la próxima!", "Mensaje",
                    JOptionPane.WARNING_MESSAGE);
            int result2 = JOptionPane.showConfirmDialog(null, "¿Quieres continuar?", "Continuar",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result2 == JOptionPane.YES_OPTION) {

                metodoContinuar();
            } else {
                // Lógica para hacer algo después de presionar "No" o cerrar la ventana
            }
        });
    }

    public static void metodoContinuar() {
        // Método para continuar después de presionar "Sí" en el JOptionPane
        System.out.println("Continuar...");
    }
}

