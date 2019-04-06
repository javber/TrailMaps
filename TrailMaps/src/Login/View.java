package Login;

import Util.BooleanReason;
import Util.Constant;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Class View Login
 * @author J.Bermudez
 *
 */
public class View {

	/**
	 * Controller Login
	 */
	private Contoller controller;
	
	/**
	 * Stage
	 */
	private Stage stage;

	/**
	 * VBox Main
	 */
	private VBox vbMainLogin = new VBox();

	/**
	 * Stack Login
	 */
	private StackPane stLogin = new StackPane();

	/**
	 * GridLogin
	 */
	private GridPane gdLogin = new GridPane();
	
	/**
	 * TextField User
	 */
	private TextField tfUser = new TextField();
	
	/**
	 * TextField Password
	 */
	private TextField tfPassword = new TextField();
	
	/**
	 * TextField Password
	 */
	private Button btUser = new Button();

	/**
	 * Imagen After Check
	 */
	private Image imageResult;
	
	/**
	 * Text Title
	 */
	private Text scenetitle = new Text(Constant.GN_NAME_APP);
	
	public View(Stage stage, Contoller controller) {
		this.stage = stage;
		this.controller = controller;
	}

	/**
	 * Init the view
	 */
	public void init() {

		// Image BackGround
		Image imBG = new Image(Constant.LG_IMAGE_BACKGROUND_LOGIN);
		ImageView imageView = new ImageView(imBG);
		imageView.setOpacity(0.3);

		// Text Title
		scenetitle.setId(Constant.LG_CSS_TXLogin);
		
		// TextField User
		tfUser = createTFLogin(Constant.LG_TF_USER);

		// TextField Password
		tfPassword = createTFLogin(Constant.LG_TF_PASSWORD);
		
		// Button Login
		btUser = createBTLogin(Constant.LG_BT_SINGUP, scenetitle);

		// GRID
		RowConstraints row1 = new RowConstraints();
		row1.setPercentHeight(25);
		gdLogin.getRowConstraints().add(row1);

		ColumnConstraints colConstraints = new ColumnConstraints();
		colConstraints.setHalignment(HPos.CENTER);
		gdLogin.getColumnConstraints().add(colConstraints);

		gdLogin.setAlignment(Pos.CENTER);
		gdLogin.setHgap(10);
		gdLogin.setVgap(20);
		gdLogin.setPadding(new Insets(25, 25, 25, 25));
		gdLogin.addRow(0, scenetitle);
		gdLogin.addRow(2, tfUser);
		gdLogin.addRow(3, tfPassword);
		gdLogin.addRow(4, btUser);

		// STACK Pane
		stLogin.getChildren().addAll(imageView);
		stLogin.getChildren().addAll(gdLogin);

		// VBox
		vbMainLogin.getChildren().add(stLogin);
		vbMainLogin.setAlignment(Pos.CENTER);
		VBox.setMargin(stLogin, new Insets(1, 280, 1, 280));

		// Scene
		Scene scene = new Scene(vbMainLogin, 950, 600);
		scene.getStylesheets().add(getClass().getResource(Constant.LG_CSS_File).toExternalForm());
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();

	}
	
	/**
	 * Close the view
	 */
	public void stop() {
		stage.close();
	}

	/**
	 * Create TextField with a style
	 * 
	 * @param pane Panel where the TextField is
	 * @param text Label of the TextField
	 * @return TextField
	 */
	public TextField createTFLogin(String textLabel) {
		TextField tfLogin = new TextField();

		tfLogin.setText(textLabel);
		tfLogin.getStyleClass().add(Constant.LG_CSS_TFLogin);

		tfLogin.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if (tfLogin.getText().equals(textLabel)) {
					tfLogin.setText("");
				}
				tfLogin.requestFocus();
			}
		});

		tfLogin.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if (tfLogin.getText().isEmpty()) {
					tfLogin.setText(textLabel);
				}
				stLogin.requestFocus();
			}
		});
		
		tfLogin.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					checkLogin();
				}
			}
		});

		return tfLogin;
	}

	/**
	 * Create button login
	 * 
	 * @param textLabel  Label of the button
	 * @param scenetitle TextTitle to animate
	 * @return Button
	 */
	public Button createBTLogin(String textLabel, Text scenetitle) {
		Button btLogin = new Button(textLabel);

		btLogin.setPrefSize(250, 10);
		btLogin.setId(Constant.LG_CSS_BTLogin);

		btLogin.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				checkLogin();
			}
		});

		btLogin.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(1000), btLogin);

				scaleTransition.setFromX(1);
				scaleTransition.setFromY(1);
				scaleTransition.setToX(0.9);
				scaleTransition.setToY(0.9);
				scaleTransition.play();
			}
		});

		btLogin.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(1000), btLogin);

				scaleTransition.setFromX(0.9);
				scaleTransition.setFromY(0.9);
				scaleTransition.setToX(1);
				scaleTransition.setToY(1);
				scaleTransition.play();
			}
		});

		return btLogin;
	}
	
	/**
	 * Check Login
	 */
	public void checkLogin() {
		tfUser.setEditable(false);
		tfPassword.setEditable(false);
		
		RotateTransition rotateTransition = new RotateTransition(Duration.millis(Constant.LG_DURATION_BEFORE_CHECK_LOGIN), scenetitle);

		rotateTransition.setByAngle(360);
		rotateTransition.setCycleCount(50);
		rotateTransition.setAutoReverse(false);
		rotateTransition.play();

		ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(Constant.LG_DURATION_BEFORE_CHECK_LOGIN), scenetitle);
		scaleTransition.setFromX(1);
		scaleTransition.setFromY(1);
		scaleTransition.setToX(0.2);
		scaleTransition.setToY(0.2);
		scaleTransition.play();
		
		Timeline timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);

		timeline.getKeyFrames().add(new KeyFrame(Duration.millis(Constant.LG_DURATION_BEFORE_CHECK_LOGIN),
				new EventHandler<ActionEvent>() {
					public void handle(ActionEvent t) {
						scenetitle.setScaleX(1.0);
						scenetitle.setScaleY(1.0);
						scenetitle.setScaleZ(1.0);
						rotateTransition.stop();
						timeline.stop();
						
						String user = tfUser.getText();
						String password = tfPassword.getText();
						BooleanReason brcheckLogin = controller.checkLogin(user, password);
						
						if (brcheckLogin != null) {
							Boolean bReason = brcheckLogin.getbReason();
							String tString = brcheckLogin.gettReason();

							gdLogin.setVisible(false);

							if (bReason) {
								imageResult = new Image(Constant.LG_IMAGE_ACCEPT_LOGIN);
							} else {
								imageResult = new Image(Constant.LG_IMAGE_DENY_LOGIN);
							}
							
							ImageView imageViewResult = new ImageView(imageResult);
							imageViewResult.setScaleX(0.5);
							imageViewResult.setScaleY(0.5);
							
							ScaleTransition scaleTransitionAfterCheck = new ScaleTransition(Duration.millis(Constant.LG_DURATION_BEFORE_CHECK_LOGIN), imageViewResult);
							scaleTransitionAfterCheck.setFromX(0.7);
							scaleTransitionAfterCheck.setFromY(0.7);
							scaleTransitionAfterCheck.setToX(1);
							scaleTransitionAfterCheck.setToY(1);
							scaleTransitionAfterCheck.play();
							
							stLogin.getChildren().add(imageViewResult);
							System.out.println(tString);

							Timeline tlAfterCheck = new Timeline();
							tlAfterCheck.getKeyFrames()
									.add(new KeyFrame(Duration.millis(Constant.LG_DURATION_AFTERCHECK_LOGIN),
											new EventHandler<ActionEvent>() {
												public void handle(ActionEvent t) {
													if (bReason) {
														//Cambiar vista a la aplicacion (está logeado)
														gdLogin.setVisible(true);
														tfUser.setEditable(true);
														tfPassword.setEditable(true);
														imageViewResult.setVisible(false);
														
														System.out.println("Change the view to the app");
														
													} else {
														gdLogin.setVisible(true);
														tfUser.setEditable(true);
														tfPassword.setEditable(true);
														imageViewResult.setVisible(false);
													}
												}
											}));

							tlAfterCheck.play();
						} else {
							System.err.println("Error brcheckLogin null");
						}

					}
				}));

		timeline.play();
	}
	
}
