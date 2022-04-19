package dk.sdu.se_f22.searchmodule.infrastructure.GUI;

import dk.sdu.se_f22.sharedlibrary.SearchHits;
import dk.sdu.se_f22.sharedlibrary.models.Brand;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.util.NodeQueryUtils.hasText;

@ExtendWith(ApplicationExtension.class)
class SEM1customerGUIControllerTest {
    Scene scene;

    @Start
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(SEM1customerGUIController.class.getResource("SEM1customerGUI.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    private Button getOnSem1SearchButton(FxRobot robot) {
        Optional<Button> onSem1SearchButton = robot.lookup(hasText("Search")).tryQueryAs(Button.class);
        if (onSem1SearchButton.isEmpty())
            fail("A button with text 'Search' could not be found!");
        return onSem1SearchButton.get();
    }

    private TextArea getSEM1customerText() {
        Node SEM1customerText = scene.getRoot().lookup("SEM1customerText");
        if (SEM1customerText == null)
            fail("No TextArea could found!");
        return (TextArea) SEM1customerText;
    }

    @Test
    void onSem1SearchButton(FxRobot robot) {
        Button search = getOnSem1SearchButton(robot);
        SearchHits searchHits = new SearchHits();
        List<String> brands = List.of("Google","Nike");
        searchHits.setBrands(brands);

        robot.clickOn(search);
        searchHits
    }
}