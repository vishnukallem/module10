import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class vishnuGradeBookApp extends Application {

    private Label firstNameLabel = new Label("First Name:");
    private Label lastNameLabel = new Label("Last Name:");
    private Label courseLabel = new Label("Course:");
    private Label gradeLabel = new Label("Grade:");

    private TableView<Grade> tableView = new TableView<>();
    private ObservableList<Grade> grades = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {

        // Creating textfields
        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        TextField courseField = new TextField();
        ComboBox<String> gradeComboBox = new ComboBox<>();
        gradeComboBox.getItems().addAll("A", "B", "C", "D", "F");

        // Adding Buttons
        Button clearButton = new Button("Clear");
        Button saveButton = new Button("Save");
        Button viewButton = new Button("View Saved Grades");

        // Adding Table columns
        TableColumn<Grade, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Grade, String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Grade, String> courseColumn = new TableColumn<>("Course");
        courseColumn.setCellValueFactory(new PropertyValueFactory<>("course"));

        TableColumn<Grade, String> gradeColumn = new TableColumn<>("Grade");
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));

        tableView.getColumns().addAll(firstNameColumn, lastNameColumn, courseColumn, gradeColumn);
        tableView.setItems(grades);

        // Setting width for the table columns
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);

        // Layout for the form, buttons, and table
        GridPane formGridPane = new GridPane();
        formGridPane.setPadding(new Insets(20));
        formGridPane.setHgap(10);
        formGridPane.setVgap(10);
        formGridPane.setAlignment(Pos.CENTER);

        // Adding form fields to the grid
        formGridPane.add(firstNameLabel, 0, 0);
        formGridPane.add(firstNameField, 1, 0);
        formGridPane.add(lastNameLabel, 0, 1);
        formGridPane.add(lastNameField, 1, 1);
        formGridPane.add(courseLabel, 0, 2);
        formGridPane.add(courseField, 1, 2);
        formGridPane.add(gradeLabel, 0, 3);
        formGridPane.add(gradeComboBox, 1, 3);

        // Adding buttons to the grid
        HBox buttonRow = new HBox(10);
        buttonRow.getChildren().addAll(clearButton, saveButton);
        buttonRow.setAlignment(Pos.CENTER);
        formGridPane.add(buttonRow, 1, 4);

        // Adding "View Grades" button
        HBox viewButtonRow = new HBox(10);
        viewButtonRow.getChildren().addAll(viewButton);
        viewButtonRow.setAlignment(Pos.CENTER);
        formGridPane.add(viewButtonRow, 1, 5);

        // Centering the elements in the grid
        for (int i = 0; i < 4; i++) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setHgrow(javafx.scene.layout.Priority.ALWAYS);
            formGridPane.getColumnConstraints().add(columnConstraints);
        }

        // Adding ScrollPane 
        ScrollPane scrollPane = new ScrollPane(tableView);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefWidth(600);

        // VBox to hold the form and table
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(formGridPane,  scrollPane);
        vbox.setAlignment(Pos.CENTER);

        // Apply light blue background color to the application
        vbox.setStyle("-fx-background-color: lightblue;");

        // Scene and stage setup
        Scene scene = new Scene(vbox, 600, 400);
        primaryStage.setTitle("Grade Book Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static class Grade {
        private String firstName;
        private String lastName;
        private String course;
        private String grade;

        public Grade(String firstName, String lastName, String course, String grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.course = course;
            this.grade = grade;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getCourse() {
            return course;
        }

        public String getGrade() {
            return grade;
        }
    }
}
