
import javafx.animation.AnimationTimer;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class RootDesigner {

    private List<Button> listOfButtons = new ArrayList<>();
    private List<Image> listOfImages = new ArrayList<>();
    private List<ImageView> listOfPassengers = new ArrayList<>();
    private List<ImageView> listOfPassengers2 = new ArrayList<>();
    private List<ImageView> listOfPassengers3 = new ArrayList<>();
    private Pane root;
    private Text speedCounter;
    private Text passengersAmount;

    public Pane createRoot(int num) {

        if(num == 0){
            root = new Pane();

        } else {
            root.getChildren().clear();
            listOfPassengers.clear();
            listOfPassengers2.clear();
            listOfButtons.clear();
            listOfImages.clear();
        }


        Button car = new Button("Car");
        Button motorbike = new Button("Motorbike");
        Button speedBoat = new Button("Speed boat");

        ImageView background = new ImageView(new Image("mb.jpg"));
        background.setX(0);
        background.setY(0);
        background.setFitWidth(2 * 700);
        background.setFitHeight(700);
        root.getChildren().add(background);

        Image carImg = new Image("car.png");
        Image motorbikeImg = new Image("motorbike.png");
        Image speedBoatImg = new Image("speed boat.png");

        listOfButtons.add(car);
        listOfButtons.add(motorbike);
        listOfButtons.add(speedBoat);

        listOfImages.add(carImg);
        listOfImages.add(motorbikeImg);
        listOfImages.add(speedBoatImg);

        for (int i = 0; i < listOfButtons.size(); i++) {
            Button b = listOfButtons.get(i);

            if (i == 0) {
                b.setTranslateX(100);
                b.setOnMouseClicked(event -> {
                    carProperties();
                });
            }
            if (i == 1) {
                b.setTranslateX(490);
                b.setOnMouseClicked(event -> {
                    motorbikeProperties();
                });
            }
            if (i == 2) {
                b.setTranslateX(880);
                b.setOnMouseClicked(event -> {
                    speedBoatProperties();
                });
            }

            b.setTranslateY(500);
            b.setPrefWidth(200);
            b.setPrefHeight(50);

            root.getChildren().add(b);
        }

        for (int i = 0; i < listOfImages.size(); i++) {
            ImageView img = new ImageView(listOfImages.get(i));

            if (i == 0) {
                img.setTranslateX(50);
            }
            if (i == 1) {
                img.setTranslateX(490);
            }
            if (i == 2) {
                img.setTranslateX(880);
            }
            if (i == 0) {
                img.setFitWidth(300);
            } else {
                img.setFitWidth(200);
            }

            img.setTranslateY(250);
            img.setFitHeight(120);

            root.getChildren().add(img);

            Rectangle rect = new Rectangle();
            rect.setWidth(680);
            rect.setHeight(100);
            rect.setX(250);
            rect.setY(25);
            rect.setFill(Color.BLACK);

            Text text = new Text("Choose a vehicle");
            text.setX(300);
            text.setY(90);
            text.setFill(Color.WHITE);
            text.setFont(Font.font("Monospaced", 60));

            root.getChildren().add(rect);
            root.getChildren().add(text);
        }

        return root;
    }

    private void carProperties() {
        root.getChildren().clear();

        Vehicle car = new Vehicle(0, 20, 0, 4, "Frank Johnson");

        speedCounter = new Text("" + car.getCurrentSpeed());
        speedCounter.setX(240);
        speedCounter.setY(350);
        speedCounter.setFill(Color.BLACK);
        speedCounter.setFont(Font.font("Monospaced", 30));

        passengersAmount = new Text("" + car.getAmountOfPassengers());
        passengersAmount.setX(920);
        passengersAmount.setY(350);
        passengersAmount.setFill(Color.BLACK);
        passengersAmount.setFont(Font.font("Monospaced", 30));

        ImageView background1 = new ImageView(new Image("street.png"));
        background1.setX(0);
        background1.setY(0);
        background1.setFitHeight(200);
        background1.setFitWidth(1400);

        ImageView background2 = new ImageView(new Image("street.png"));
        background2.setX(1200);
        background2.setY(0);
        background2.setFitHeight(200);
        background2.setFitWidth(1400);

        ImageView vehicleImg = new ImageView(new Image("car.png"));
        vehicleImg.setFitHeight(120);
        vehicleImg.setFitWidth(300);
        vehicleImg.setY(70);
        vehicleImg.setX(100);

        ImageView kImg = new ImageView(new Image("kanye-west.png"));
        kImg.setFitHeight(40);
        kImg.setFitWidth(30);
        kImg.setY(80);
        kImg.setX(250);

        ImageView aImg = new ImageView(new Image("Ainsley.png"));
        aImg.setFitHeight(40);
        aImg.setFitWidth(35);
        aImg.setY(80);
        aImg.setX(200);

        ImageView sImg = new ImageView(new Image("Sitting man.png"));
        sImg.setFitHeight(100);
        sImg.setFitWidth(185);
        sImg.setY(60);
        sImg.setX(210);

        ImageView swImg = new ImageView(new Image("Sitting woman.png"));
        swImg.setFitHeight(100);
        swImg.setFitWidth(130);
        swImg.setY(60);
        swImg.setX(90);

        ImageView dImg = new ImageView(new Image("dog.gif"));
        dImg.setFitHeight(80);
        dImg.setFitWidth(80);
        dImg.setY(20);
        dImg.setX(200);

        listOfPassengers.add(aImg);
        listOfPassengers.add(sImg);
        listOfPassengers.add(swImg);
        listOfPassengers.add(dImg);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                if (background1.getX() <= -1200) {
                    background1.setX(1200);
                }
                if (background2.getX() <= -1200) {
                    background2.setX(1200);
                }
                background1.setX(background1.getX() - car.getCurrentSpeed());
                background2.setX(background2.getX() - car.getCurrentSpeed());
            }
        };

        Text speed = new Text("Speed");
        speed.setX(200);
        speed.setY(300);
        speed.setFill(Color.BLACK);
        speed.setFont(Font.font("Monospaced", 30));

        Text passengers = new Text("Passengers");
        passengers.setX(840);
        passengers.setY(300);
        passengers.setFill(Color.BLACK);
        passengers.setFont(Font.font("Monospaced", 30));

        Text ownersNameAndSurname = new Text("Owner's name and surname");
        ownersNameAndSurname.setX(380);
        ownersNameAndSurname.setY(500);
        ownersNameAndSurname.setFill(Color.BLACK);
        ownersNameAndSurname.setFont(Font.font("Monospaced", 30));

        Button plusSpeed = new Button("+");
        Button minusSpeed = new Button("-");

        plusSpeed.setPrefSize(50, 50);
        plusSpeed.setTranslateX(330);
        plusSpeed.setTranslateY(320);

        minusSpeed.setPrefSize(50, 50);
        minusSpeed.setTranslateX(120);
        minusSpeed.setTranslateY(320);
        minusSpeed.setDisable(true);

        plusSpeed.setOnMouseClicked(event -> {
            car.accelerate(1);
            if (car.getCurrentSpeed() == car.getMaxSpeed()) {
                plusSpeed.setDisable(true);
            }
            minusSpeed.setDisable(false);
            speedCounter.setText("" + car.getCurrentSpeed());
        });
        minusSpeed.setOnMouseClicked(event -> {
            car.slowDown(1);
            if (car.getCurrentSpeed() == 0) {
                minusSpeed.setDisable(true);
            }
            plusSpeed.setDisable(false);
            speedCounter.setText("" + car.getCurrentSpeed());
        });

        Text nameText = new Text("*from car* Hi! I'm " + car.getOwnersNameAndSurname() + "!");
        nameText.setX(350);
        nameText.setY(90);
        nameText.setFill(Color.WHITE);
        nameText.setFont(Font.font("Monospaced", 20));

        TextArea nameArea = new TextArea("" + car.getOwnersNameAndSurname());
        nameArea.setTranslateX(360);
        nameArea.setTranslateY(530);
        nameArea.setMaxHeight(50);
        nameArea.setPrefWidth(360);
        nameArea.setFont(Font.font("Monospaced", 20));

        TextArea vehicleProperties = new TextArea("");
        vehicleProperties.setTranslateX(950);
        vehicleProperties.setTranslateY(480);
        vehicleProperties.setMaxHeight(20);
        vehicleProperties.setPrefWidth(200);
        vehicleProperties.setFont(Font.font("Monospaced", 14));
        vehicleProperties.setEditable(false);

        Button printProperties = new Button("Print vehicle properties");
        printProperties.setPrefSize(200, 55);
        printProperties.setTranslateX(950);
        printProperties.setTranslateY(530);
        printProperties.setOnMouseClicked(event -> {
            vehicleProperties.setText(""+car.toString());
        });

        root.getChildren().add(vehicleProperties);
        root.getChildren().add(printProperties);

        Button editName = new Button("Edit");
        editName.setPrefSize(80, 55);
        editName.setTranslateX(750);
        editName.setTranslateY(530);
        editName.setOnMouseClicked(event -> {
            String newName = nameArea.getText();
            car.setOwnersNameAndSurname(newName);
            if (newName.equals("")) {
                nameText.setText("");
            } else {
                nameText.setText("*from car* Hi! I'm " + car.getOwnersNameAndSurname() + "!");

            }

        });
        Button plusPassenger = new Button("+");
        Button minusPassenger = new Button("-");

        plusPassenger.setPrefSize(50, 50);
        plusPassenger.setTranslateX(1010);
        plusPassenger.setTranslateY(320);

        minusPassenger.setPrefSize(50, 50);
        minusPassenger.setTranslateX(800);
        minusPassenger.setTranslateY(320);

        plusPassenger.setOnMouseClicked(event -> {
            car.getIntoVehicle(1);

            if(car.getAmountOfPassengers()==1){
                if(!root.getChildren().contains(listOfPassengers.get(0))){
                    root.getChildren().add(listOfPassengers.get(0));

                }
            }
            if(car.getAmountOfPassengers()==2){
                if(!root.getChildren().contains(listOfPassengers.get(1))){
                    root.getChildren().add(listOfPassengers.get(1));

                }
            }
            if(car.getAmountOfPassengers()==3){
                if(!root.getChildren().contains(listOfPassengers.get(2))){
                    root.getChildren().add(listOfPassengers.get(2));

                }
            }
            if(car.getAmountOfPassengers()==4){
                if(!root.getChildren().contains(listOfPassengers.get(3))){
                    root.getChildren().add(listOfPassengers.get(3));

                }
            }
            if (car.getAmountOfPassengers() == car.getMaxAmountOfPassengers()) {
                plusPassenger.setDisable(true);
            }
            minusPassenger.setDisable(false);
            passengersAmount.setText("" + car.getAmountOfPassengers());
        });
        minusPassenger.setOnMouseClicked(event -> {
            car.getOutOfVehicle(1);

            if(car.getAmountOfPassengers()==0){
                if(root.getChildren().contains(listOfPassengers.get(0))){
                    root.getChildren().remove(listOfPassengers.get(0));

                }
            }
            if(car.getAmountOfPassengers()==1){
                if(root.getChildren().contains(listOfPassengers.get(1))){
                    root.getChildren().remove(listOfPassengers.get(1));

                }
            }
            if(car.getAmountOfPassengers()==2){
                if(root.getChildren().contains(listOfPassengers.get(2))){
                    root.getChildren().remove(listOfPassengers.get(2));

                }
            }
            if(car.getAmountOfPassengers()==3){
                if(root.getChildren().contains(listOfPassengers.get(3))){
                    root.getChildren().remove(listOfPassengers.get(3));

                }
            }
            if (car.getAmountOfPassengers() == 0) {
                minusPassenger.setDisable(true);
            }
            plusPassenger.setDisable(false);
            passengersAmount.setText("" + car.getAmountOfPassengers());
        });

        minusPassenger.setDisable(true);
        Button backToMenu = new Button("Back to menu");

        backToMenu.setPrefSize(100, 55);
        backToMenu.setTranslateX(50);
        backToMenu.setTranslateY(530);

        backToMenu.setOnMouseClicked(event -> {
            createRoot(1);
        });

        root.getChildren().add(background1);
        root.getChildren().add(background2);
        root.getChildren().add(vehicleImg);
        root.getChildren().add(speed);
        root.getChildren().add(passengers);
        root.getChildren().add(ownersNameAndSurname);
        root.getChildren().add(plusSpeed);
        root.getChildren().add(minusSpeed);
        root.getChildren().add(plusPassenger);
        root.getChildren().add(minusPassenger);
        root.getChildren().add(backToMenu);
        root.getChildren().add(speedCounter);
        root.getChildren().add(passengersAmount);
        root.getChildren().add(nameText);
        root.getChildren().add(editName);
        root.getChildren().add(nameArea);
        root.getChildren().add(kImg);

        timer.start();
    }

    private void motorbikeProperties() {
        Vehicle motorbike = new Vehicle(0, 15, 0, 1, "Michael Stones");
        root.getChildren().clear();
        speedCounter = new Text("" + motorbike.getCurrentSpeed());
        speedCounter.setX(240);
        speedCounter.setY(350);
        speedCounter.setFill(Color.BLACK);
        speedCounter.setFont(Font.font("Monospaced", 30));

        passengersAmount = new Text("" + motorbike.getAmountOfPassengers());
        passengersAmount.setX(920);
        passengersAmount.setY(350);
        passengersAmount.setFill(Color.BLACK);
        passengersAmount.setFont(Font.font("Monospaced", 30));

        ImageView background1 = new ImageView(new Image("street.png"));
        background1.setX(0);
        background1.setY(0);
        background1.setFitHeight(200);
        background1.setFitWidth(1400);

        ImageView background2 = new ImageView(new Image("street.png"));
        background2.setX(1200);
        background2.setY(0);
        background2.setFitHeight(200);
        background2.setFitWidth(1400);

        ImageView vehicleImg = new ImageView(new Image("motorbike.png"));
        vehicleImg.setFitHeight(100);
        vehicleImg.setFitWidth(200);
        vehicleImg.setY(80);
        vehicleImg.setX(100);

        ImageView kImg = new ImageView(new Image("motorbike driver.png"));
        kImg.setFitHeight(120);
        kImg.setFitWidth(60);
        kImg.setY(30);
        kImg.setX(180);

        ImageView aImg = new ImageView(new Image("cat.png"));
        aImg.setFitHeight(40);
        aImg.setFitWidth(60);
        aImg.setY(70);
        aImg.setX(130);

        listOfPassengers2.add(aImg);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                if (background1.getX() <= -1200) {
                    background1.setX(1200);
                }
                if (background2.getX() <= -1200) {
                    background2.setX(1200);
                }
                background1.setX(background1.getX() - motorbike.getCurrentSpeed());
                background2.setX(background2.getX() - motorbike.getCurrentSpeed());
            }
        };

        Text speed = new Text("Speed");
        speed.setX(200);
        speed.setY(300);
        speed.setFill(Color.BLACK);
        speed.setFont(Font.font("Monospaced", 30));

        Text passengers = new Text("Passengers");
        passengers.setX(840);
        passengers.setY(300);
        passengers.setFill(Color.BLACK);
        passengers.setFont(Font.font("Monospaced", 30));

        Text ownersNameAndSurname = new Text("Owner's name and surname");
        ownersNameAndSurname.setX(380);
        ownersNameAndSurname.setY(500);
        ownersNameAndSurname.setFill(Color.BLACK);
        ownersNameAndSurname.setFont(Font.font("Monospaced", 30));

        TextArea vehicleProperties = new TextArea("");
        vehicleProperties.setTranslateX(950);
        vehicleProperties.setTranslateY(480);
        vehicleProperties.setMaxHeight(20);
        vehicleProperties.setPrefWidth(200);
        vehicleProperties.setFont(Font.font("Monospaced", 14));
        vehicleProperties.setEditable(false);

        Button printProperties = new Button("Print vehicle properties");
        printProperties.setPrefSize(200, 55);
        printProperties.setTranslateX(950);
        printProperties.setTranslateY(530);
        printProperties.setOnMouseClicked(event -> {
            vehicleProperties.setText(""+motorbike.toString());
        });

        root.getChildren().add(vehicleProperties);
        root.getChildren().add(printProperties);

        Button plusSpeed = new Button("+");
        Button minusSpeed = new Button("-");

        plusSpeed.setPrefSize(50, 50);
        plusSpeed.setTranslateX(330);
        plusSpeed.setTranslateY(320);

        minusSpeed.setPrefSize(50, 50);
        minusSpeed.setTranslateX(120);
        minusSpeed.setTranslateY(320);
        minusSpeed.setDisable(true);

        plusSpeed.setOnMouseClicked(event -> {
            motorbike.accelerate(1);
            if (motorbike.getCurrentSpeed() == motorbike.getMaxSpeed()) {
                plusSpeed.setDisable(true);
            }
            minusSpeed.setDisable(false);
            speedCounter.setText("" + motorbike.getCurrentSpeed());
        });
        minusSpeed.setOnMouseClicked(event -> {
            motorbike.slowDown(1);
            if (motorbike.getCurrentSpeed() == 0) {
                minusSpeed.setDisable(true);
            }
            plusSpeed.setDisable(false);
            speedCounter.setText("" + motorbike.getCurrentSpeed());
        });

        Text nameText = new Text("*from motorbike* Hi! I'm " + motorbike.getOwnersNameAndSurname() + "!");
        nameText.setX(350);
        nameText.setY(90);
        nameText.setFill(Color.WHITE);
        nameText.setFont(Font.font("Monospaced", 20));

        TextArea nameArea = new TextArea("" + motorbike.getOwnersNameAndSurname());
        nameArea.setTranslateX(360);
        nameArea.setTranslateY(530);
        nameArea.setMaxHeight(50);
        nameArea.setPrefWidth(360);
        nameArea.setFont(Font.font("Monospaced", 20));


        Button editName = new Button("Edit");
        editName.setPrefSize(80, 55);
        editName.setTranslateX(750);
        editName.setTranslateY(530);
        editName.setOnMouseClicked(event -> {
            String newName = nameArea.getText();
            motorbike.setOwnersNameAndSurname(newName);
            if (newName.equals("")) {
                nameText.setText("");
            } else {
                nameText.setText("*from car* Hi! I'm " + motorbike.getOwnersNameAndSurname() + "!");

            }

        });

        Button plusPassenger = new Button("+");
        Button minusPassenger = new Button("-");

        plusPassenger.setPrefSize(50, 50);
        plusPassenger.setTranslateX(1010);
        plusPassenger.setTranslateY(320);

        minusPassenger.setPrefSize(50, 50);
        minusPassenger.setTranslateX(800);
        minusPassenger.setTranslateY(320);

        plusPassenger.setOnMouseClicked(event -> {
            motorbike.getIntoVehicle(1);

            if(motorbike.getAmountOfPassengers()==1){
                if(!root.getChildren().contains(listOfPassengers2.get(0))){
                    root.getChildren().add(listOfPassengers2.get(0));

                }
            }
            if(motorbike.getAmountOfPassengers()==2){
                if(!root.getChildren().contains(listOfPassengers2.get(1))){
                    root.getChildren().add(listOfPassengers2.get(1));

                }
            }
            if(motorbike.getAmountOfPassengers()==3){
                if(!root.getChildren().contains(listOfPassengers2.get(2))){
                    root.getChildren().add(listOfPassengers2.get(2));

                }
            }
            if(motorbike.getAmountOfPassengers()==4){
                if(!root.getChildren().contains(listOfPassengers2.get(3))){
                    root.getChildren().add(listOfPassengers2.get(3));

                }
            }
            if (motorbike.getAmountOfPassengers() == motorbike.getMaxAmountOfPassengers()) {
                plusPassenger.setDisable(true);
            }
            minusPassenger.setDisable(false);
            passengersAmount.setText("" + motorbike.getAmountOfPassengers());
        });
        minusPassenger.setOnMouseClicked(event -> {
            motorbike.getOutOfVehicle(1);

            if(motorbike.getAmountOfPassengers()==0){
                if(root.getChildren().contains(listOfPassengers2.get(0))){
                    root.getChildren().remove(listOfPassengers2.get(0));

                }
            }
            if(motorbike.getAmountOfPassengers()==1){
                if(root.getChildren().contains(listOfPassengers2.get(1))){
                    root.getChildren().remove(listOfPassengers2.get(1));

                }
            }
            if(motorbike.getAmountOfPassengers()==2){
                if(root.getChildren().contains(listOfPassengers2.get(2))){
                    root.getChildren().remove(listOfPassengers2.get(2));

                }
            }
            if(motorbike.getAmountOfPassengers()==3){
                if(root.getChildren().contains(listOfPassengers2.get(3))){
                    root.getChildren().remove(listOfPassengers2.get(3));

                }
            }
            if (motorbike.getAmountOfPassengers() == 0) {
                minusPassenger.setDisable(true);
            }
            plusPassenger.setDisable(false);
            passengersAmount.setText("" + motorbike.getAmountOfPassengers());
        });
        minusPassenger.setDisable(true);
        Button backToMenu = new Button("Back to menu");

        backToMenu.setPrefSize(100, 55);
        backToMenu.setTranslateX(50);
        backToMenu.setTranslateY(530);

        backToMenu.setOnMouseClicked(event -> {
            createRoot(1);
        });

        root.getChildren().add(background1);
        root.getChildren().add(background2);
        root.getChildren().add(vehicleImg);
        root.getChildren().add(speed);
        root.getChildren().add(passengers);
        root.getChildren().add(ownersNameAndSurname);
        root.getChildren().add(plusSpeed);
        root.getChildren().add(minusSpeed);
        root.getChildren().add(plusPassenger);
        root.getChildren().add(minusPassenger);
        root.getChildren().add(backToMenu);
        root.getChildren().add(speedCounter);
        root.getChildren().add(passengersAmount);
        root.getChildren().add(nameText);
        root.getChildren().add(editName);
        root.getChildren().add(nameArea);
        root.getChildren().add(kImg);

        timer.start();
    }

    private void speedBoatProperties() {
        Vehicle speedBoat = new Vehicle(0, 30, 0, 3, "Nuck Chorris");
        root.getChildren().clear();
        speedCounter = new Text("" + speedBoat.getCurrentSpeed());
        speedCounter.setX(240);
        speedCounter.setY(350);
        speedCounter.setFill(Color.BLACK);
        speedCounter.setFont(Font.font("Monospaced", 30));

        passengersAmount = new Text("" + speedBoat.getAmountOfPassengers());
        passengersAmount.setX(920);
        passengersAmount.setY(350);
        passengersAmount.setFill(Color.BLACK);
        passengersAmount.setFont(Font.font("Monospaced", 30));

        ImageView background1 = new ImageView(new Image("sea.jpg"));
        background1.setX(0);
        background1.setY(0);
        background1.setFitHeight(200);
        background1.setFitWidth(1400);

        ImageView background2 = new ImageView(new Image("sea.jpg"));
        background2.setX(1200);
        background2.setY(0);
        background2.setFitHeight(200);
        background2.setFitWidth(1400);

        ImageView vehicleImg = new ImageView(new Image("speed boat.png"));
        vehicleImg.setFitHeight(125);
        vehicleImg.setFitWidth(250);
        vehicleImg.setY(50);
        vehicleImg.setX(80);

        ImageView kImg = new ImageView(new Image("boat driver.png"));
        kImg.setFitHeight(40);
        kImg.setFitWidth(30);
        kImg.setY(73);
        kImg.setX(200);

        ImageView aImg = new ImageView(new Image("nicholas cage.png"));
        aImg.setFitHeight(50);
        aImg.setFitWidth(40);
        aImg.setY(75);
        aImg.setX(165);

        ImageView sImg = new ImageView(new Image("memeGirl.png"));
        sImg.setFitHeight(60);
        sImg.setFitWidth(90);
        sImg.setY(70);
        sImg.setX(80);

        ImageView swImg = new ImageView(new Image("doge.png"));
        swImg.setFitHeight(60);
        swImg.setFitWidth(100);
        swImg.setY(60);
        swImg.setX(230);

        listOfPassengers3.add(aImg);
        listOfPassengers3.add(sImg);
        listOfPassengers3.add(swImg);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                if (background1.getX() <= -1200) {
                    background1.setX(1200);
                }
                if (background2.getX() <= -1200) {
                    background2.setX(1200);
                }
                background1.setX(background1.getX() - speedBoat.getCurrentSpeed());
                background2.setX(background2.getX() - speedBoat.getCurrentSpeed());
            }
        };

        Text speed = new Text("Speed");
        speed.setX(200);
        speed.setY(300);
        speed.setFill(Color.BLACK);
        speed.setFont(Font.font("Monospaced", 30));

        Text passengers = new Text("Passengers");
        passengers.setX(840);
        passengers.setY(300);
        passengers.setFill(Color.BLACK);
        passengers.setFont(Font.font("Monospaced", 30));

        Text ownersNameAndSurname = new Text("Owner's name and surname");
        ownersNameAndSurname.setX(380);
        ownersNameAndSurname.setY(500);
        ownersNameAndSurname.setFill(Color.BLACK);
        ownersNameAndSurname.setFont(Font.font("Monospaced", 30));

        TextArea vehicleProperties = new TextArea("");
        vehicleProperties.setTranslateX(950);
        vehicleProperties.setTranslateY(480);
        vehicleProperties.setMaxHeight(20);
        vehicleProperties.setPrefWidth(200);
        vehicleProperties.setFont(Font.font("Monospaced", 14));
        vehicleProperties.setEditable(false);

        Button printProperties = new Button("Print vehicle properties");
        printProperties.setPrefSize(200, 55);
        printProperties.setTranslateX(950);
        printProperties.setTranslateY(530);
        printProperties.setOnMouseClicked(event -> {
            vehicleProperties.setText(""+speedBoat.toString());
        });

        root.getChildren().add(vehicleProperties);
        root.getChildren().add(printProperties);

        Button plusSpeed = new Button("+");
        Button minusSpeed = new Button("-");

        plusSpeed.setPrefSize(50, 50);
        plusSpeed.setTranslateX(330);
        plusSpeed.setTranslateY(320);

        minusSpeed.setPrefSize(50, 50);
        minusSpeed.setTranslateX(120);
        minusSpeed.setTranslateY(320);
        minusSpeed.setDisable(true);

        plusSpeed.setOnMouseClicked(event -> {
            speedBoat.accelerate(1);
            if (speedBoat.getCurrentSpeed() == speedBoat.getMaxSpeed()) {
                plusSpeed.setDisable(true);
            }
            minusSpeed.setDisable(false);
            speedCounter.setText("" + speedBoat.getCurrentSpeed());
        });
        minusSpeed.setOnMouseClicked(event -> {
            speedBoat.slowDown(1);
            if (speedBoat.getCurrentSpeed() == 0) {
                minusSpeed.setDisable(true);
            }
            plusSpeed.setDisable(false);
            speedCounter.setText("" + speedBoat.getCurrentSpeed());
        });

        Text nameText = new Text("*from speed boat* Hi! I'm " + speedBoat.getOwnersNameAndSurname() + "!");
        nameText.setX(350);
        nameText.setY(90);
        nameText.setFill(Color.WHITE);
        nameText.setFont(Font.font("Monospaced", 20));

        TextArea nameArea = new TextArea("" + speedBoat.getOwnersNameAndSurname());
        nameArea.setTranslateX(360);
        nameArea.setTranslateY(530);
        nameArea.setMaxHeight(50);
        nameArea.setPrefWidth(360);
        nameArea.setFont(Font.font("Monospaced", 20));


        Button editName = new Button("Edit");
        editName.setPrefSize(80, 55);
        editName.setTranslateX(750);
        editName.setTranslateY(530);
        editName.setOnMouseClicked(event -> {
            String newName = nameArea.getText();
            speedBoat.setOwnersNameAndSurname(newName);
            if (newName.equals("")) {
                nameText.setText("");
            } else {
                nameText.setText("*from car* Hi! I'm " + speedBoat.getOwnersNameAndSurname() + "!");

            }

        });

        Button plusPassenger = new Button("+");
        Button minusPassenger = new Button("-");

        plusPassenger.setPrefSize(50, 50);
        plusPassenger.setTranslateX(1010);
        plusPassenger.setTranslateY(320);

        minusPassenger.setPrefSize(50, 50);
        minusPassenger.setTranslateX(800);
        minusPassenger.setTranslateY(320);

        plusPassenger.setOnMouseClicked(event -> {
            speedBoat.getIntoVehicle(1);

            if(speedBoat.getAmountOfPassengers()==1){
                if(!root.getChildren().contains(listOfPassengers3.get(0))){
                    root.getChildren().add(listOfPassengers3.get(0));

                }
            }
            if(speedBoat.getAmountOfPassengers()==2){
                if(!root.getChildren().contains(listOfPassengers3.get(1))){
                    root.getChildren().add(listOfPassengers3.get(1));

                }
            }
            if(speedBoat.getAmountOfPassengers()==3){
                if(!root.getChildren().contains(listOfPassengers3.get(2))){
                    root.getChildren().add(listOfPassengers3.get(2));

                }
            }
            if(speedBoat.getAmountOfPassengers()==4){
                if(!root.getChildren().contains(listOfPassengers3.get(3))){
                    root.getChildren().add(listOfPassengers3.get(3));

                }
            }
            if (speedBoat.getAmountOfPassengers() == speedBoat.getMaxAmountOfPassengers()) {
                plusPassenger.setDisable(true);
            }
            minusPassenger.setDisable(false);
            passengersAmount.setText("" + speedBoat.getAmountOfPassengers());
        });
        minusPassenger.setOnMouseClicked(event -> {
            speedBoat.getOutOfVehicle(1);

            if(speedBoat.getAmountOfPassengers()==0){
                if(root.getChildren().contains(listOfPassengers3.get(0))){
                    root.getChildren().remove(listOfPassengers3.get(0));

                }
            }
            if(speedBoat.getAmountOfPassengers()==1){
                if(root.getChildren().contains(listOfPassengers3.get(1))){
                    root.getChildren().remove(listOfPassengers3.get(1));

                }
            }
            if(speedBoat.getAmountOfPassengers()==2){
                if(root.getChildren().contains(listOfPassengers3.get(2))){
                    root.getChildren().remove(listOfPassengers3.get(2));

                }
            }
            if(speedBoat.getAmountOfPassengers()==3){
                if(root.getChildren().contains(listOfPassengers3.get(3))){
                    root.getChildren().remove(listOfPassengers3.get(3));

                }
            }
            if (speedBoat.getAmountOfPassengers() == 0) {
                minusPassenger.setDisable(true);
            }
            plusPassenger.setDisable(false);
            passengersAmount.setText("" + speedBoat.getAmountOfPassengers());
        });
        minusPassenger.setDisable(true);
        Button backToMenu = new Button("Back to menu");

        backToMenu.setPrefSize(100, 55);
        backToMenu.setTranslateX(50);
        backToMenu.setTranslateY(530);

        backToMenu.setOnMouseClicked(event -> {
            createRoot(1);
        });

        root.getChildren().add(background1);
        root.getChildren().add(background2);
        root.getChildren().add(vehicleImg);
        root.getChildren().add(speed);
        root.getChildren().add(passengers);
        root.getChildren().add(ownersNameAndSurname);
        root.getChildren().add(plusSpeed);
        root.getChildren().add(minusSpeed);
        root.getChildren().add(plusPassenger);
        root.getChildren().add(minusPassenger);
        root.getChildren().add(backToMenu);
        root.getChildren().add(speedCounter);
        root.getChildren().add(passengersAmount);
        root.getChildren().add(nameText);
        root.getChildren().add(editName);
        root.getChildren().add(nameArea);
        root.getChildren().add(kImg);

        timer.start();
    }
}
