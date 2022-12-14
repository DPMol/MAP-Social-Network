package frontend.frontend;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageService {
    private static StageService instance;

    private final Stage stage = new Stage();

    private StageService(){}

    public static StageService getInstance() {
        if (instance == null) {
            instance = new StageService();
        }
        return instance;
    }

    public void changeStage(Scene scene){
        stage.setScene(scene);
    }

    public void changeStage(Scene scene, String title){
        if(scene == null){
            throw new RuntimeException("Stage scene cannot be null");
        }

        stage.setScene(scene);
        this.changeTitle(title);
    }

    public void changeStage(Scene scene, String title, Boolean resizeable){
        if(scene == null){
            throw new RuntimeException("Stage scene cannot be null");
        }

        stage.setScene(scene);
        this.changeTitle(title);
        this.changeResizeable(resizeable);
        stage.show();
    }

    public void changeStage(Scene scene, Boolean resizeable){
        if(scene == null){
            throw new RuntimeException("Stage scene cannot be null");
        }

        stage.setScene(scene);
        this.changeResizeable(resizeable);
    }

    public void changeTitle(String title){
        if(title == null || title.isBlank()){
            throw new RuntimeException("Stage title cannot be null");
        }
        stage.setTitle(title);
    }

    public void changeResizeable(Boolean resizeable){
        if(resizeable == null){
            throw new RuntimeException("Resizeable cannot be null");
        }
        stage.setResizable(resizeable);
    }
}