package it.MagicComparator;

import java.net.URL;
import java.util.ResourceBundle;

import it.MagicComparator.model.Card;
import it.MagicComparator.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class MagicComparatorController {

	Model model;

	public void setModel(Model model) {
		this.model = model;
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextArea txtFirst;

	@FXML
	private TextArea txtSecond;

	@FXML
	private Button btnMerge;

	@FXML
	private TextArea txtResult;

	@FXML
	void doMerge(ActionEvent event) {
		String result = "";
		for (Card c : model.merge(txtFirst.getText(), txtSecond.getText())) {
			result+= c.getAmountof()+ " " + c.getCardname()+"\n";
		}
		txtResult.setText(result);
	}

	@FXML
	void initialize() {
		assert txtFirst != null : "fx:id=\"txtFirst\" was not injected: check your FXML file 'MagicComparator.fxml'.";
		assert txtSecond != null : "fx:id=\"txtSecond\" was not injected: check your FXML file 'MagicComparator.fxml'.";
		assert btnMerge != null : "fx:id=\"btnMerge\" was not injected: check your FXML file 'MagicComparator.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'MagicComparator.fxml'.";

	}
}
