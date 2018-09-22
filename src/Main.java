import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private RootDesigner rootDesigner;

    public static void main(String[] args) {

        launch(args);


    }

    @Override
    public void start(Stage stage) throws Exception {
        rootDesigner = new RootDesigner();
        Scene scene = new Scene(rootDesigner.createRoot(0));
        stage.setScene(scene);
        stage.getIcons().add(new Image("gameIcon.png"));
        stage.setResizable(false);
        stage.setTitle("Vehicles");
        stage.setWidth(1200);
        stage.setHeight(700);
        stage.show();
    }
}
