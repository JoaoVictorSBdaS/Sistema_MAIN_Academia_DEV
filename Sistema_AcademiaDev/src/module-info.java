module Sistema_AcademiaDev {
	requires javafx.controls;
	requires java.sql;
	requires javafx.fxml;
	
	
	exports packageControler;
	exports packageModel;
	exports packageController;
	
	opens packageController to javafx.fxml;
	opens packageModel to javafx.fxml;
	opens packageControler to javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;

	
}
