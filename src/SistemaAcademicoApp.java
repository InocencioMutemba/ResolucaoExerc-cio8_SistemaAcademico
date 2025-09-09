
import model.SistemaAcademico;
import view.MainView;
import controller.MainController;
import javax.swing.UIManager;

/**
 * Classe principal para iniciar o sistema Implementa o
 * padrão MVC e inicia a aplicação
 */
public class SistemaAcademicoApp {

    public static void main(String[] args) {
        // Configurar look and feel para interface moderna
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Criar instância do sistema
        SistemaAcademico sistema = SistemaAcademico.getInstance();

        // Criar view e controller
        MainView view = new MainView();
        MainController controller = new MainController(view, sistema);

        // Iniciar aplicação
        controller.iniciar();
    }
}
