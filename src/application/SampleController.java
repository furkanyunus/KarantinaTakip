package application;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class SampleController {
   

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private TableView<KayitlarTable> kayitlarTable;

    @FXML
    private TableColumn<KayitlarTable, String> hasta_Adi;
  
    @FXML
    private TableColumn<KayitlarTable, String> sehir_Adi;
    @FXML
    private TableColumn<KayitlarTable, String> meslekler;
    @FXML
    private TableColumn<KayitlarTable, String> cinsiyetler;
	
    @FXML
    private ToggleGroup cinsiyet_Adi;
    
	
    @FXML
    private ToggleGroup meslek_Adi;
    
    
    @FXML
    private TableColumn<KayitlarTable, String> ates_Olc;
	
    @FXML
    private TableColumn<KayitlarTable, String> tshs;
	
 

    @FXML
    private Button btn_ekle;

    @FXML
    private Button btn_sil;

    @FXML
    private Button btn_guncelle;
	
    @FXML
    private Button btn_sorgula;

    @FXML
    private TextField txt_Ad;
    
    @FXML
    private CheckBox teshis_Oluru;
  

    @FXML
    private ComboBox<String> combo_Sehir;
    

    //sliderKısmı
    @FXML
    private Slider slider_Ates;
    @FXML
    private Label label_Deg;
    
    
    ObservableList<KayitlarTable> tumveriler;


    int sayac=0;
    
    @FXML
    void teshis_Oluru_clicked(ActionEvent event) {
    	
    	sayac++;
    	if(sayac%2==1)
    	{
    		teshis_Oluru.setText("Pozitif");
    	}
    	if(sayac%2==0)
    	{
    		teshis_Oluru.setText("Negatif");
    	}
    	
    	

    }
  
	 
    @FXML
    void btn_ekle_Clicked(ActionEvent event) {
  
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Onay");
    	alert.setHeaderText(null);
    	alert.setContentText("eklem Başarılı olmustur");
    	alert.showAndWait();
    	
    	RadioButton cinsiyet=(RadioButton)cinsiyet_Adi.getSelectedToggle();
    	String cinsiyet_Adi=cinsiyet.getText();
    	
    	RadioButton meslek=(RadioButton)meslek_Adi.getSelectedToggle();
    	String meslek_Adi=meslek.getText();
    	String a=teshis_Oluru.getText();
    	
    	tumveriler=FXCollections.observableArrayList();
    	
		tumveriler.add(new KayitlarTable(txt_Ad.getText(), combo_Sehir.getValue(), meslek_Adi, cinsiyet_Adi, label_Deg.getText(),a));
    	kayitlarTable.getItems().addAll(tumveriler);
    	
    	
    }
    
    
    @FXML
    void btn_sil_Clicked(ActionEvent event) {
    	
    	
    	ObservableList<KayitlarTable> secilenKayit, tumKayitlar;
    	tumKayitlar=kayitlarTable.getItems();
    	secilenKayit=kayitlarTable.getSelectionModel().getSelectedItems();
    	

    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Uyarı!!!");
    	alert.setHeaderText("Seçtiginiz  kayıt silinsin mi!");
    	alert.setContentText("Gerçekten silmek istiyormusunuz ?");
    	ButtonType tipi1= new ButtonType("Evet");
    	ButtonType tipi2= new ButtonType("Hayır");
    	alert.getButtonTypes().setAll(tipi1,tipi2);
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get()==tipi1) {
    		secilenKayit.forEach(tumKayitlar::remove);
		}
    	else {
    		
    		
    	}
    	kayitlarTable.refresh();
    	
    	
    }

    
    @FXML
    void btn_guncelle_Clicked(ActionEvent event) {
    	
    	KayitlarTable kayit=new KayitlarTable();
    	kayit= (KayitlarTable) kayitlarTable.getItems().get(kayitlarTable.getSelectionModel().getSelectedIndex());
    	
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Uyarı");
    	alert.setHeaderText("Seçili olan kaydı günceliyosunuz !");
    	alert.setContentText("Gerçekten güncellemek istiyormusunuz ?");
    	ButtonType tipi1= new ButtonType("Evet");
    	ButtonType tipi2= new ButtonType("Hayır");
    	alert.getButtonTypes().setAll(tipi1,tipi2);
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get()==tipi1.OK) {
    		RadioButton meslek=(RadioButton)meslek_Adi.getSelectedToggle();
        	String meslek_Adi=meslek.getText();
        	
        	RadioButton cins=(RadioButton)cinsiyet_Adi.getSelectedToggle();
        	String cinsiyet_Adi=cins.getText();
        	
        	KayitlarTable kk=new KayitlarTable(txt_Ad.getText(),combo_Sehir.getValue(), meslek_Adi, cinsiyet_Adi, label_Deg.getText(), teshis_Oluru.getText()); 	
        	int sira= kayitlarTable.getSelectionModel().getSelectedIndex();
        	kayitlarTable.getItems().set(sira, kk);
        	
    		
    		tumveriler.remove(sira );
    		
    	}
      	
else {
    		
    		alert.close();
    	}
    	kayitlarTable.refresh();
    	
    		
    	
    }


    @FXML
    void btn_sorgula_Clicked(ActionEvent event) {
    	KayitlarTable kayit=new KayitlarTable();
    	if(kayitlarTable.getSelectionModel().getSelectedIndex()!=-1) {
    		kayit= (KayitlarTable) kayitlarTable.getItems().get(kayitlarTable.getSelectionModel().getSelectedIndex());
    		System.out.println("Seçilen hasta Adı:"+ kayit.getHasta_Adi() + "\n" + //
    							"Şehir:"+ kayit.getSehir_Adi() + "\n" + //
    							"Meslek:"+ kayit.getMeslek_Adi()+ "\n" + //
    							"Cinsiyet:"+ kayit.getCinsiyet_Adi()+ "\n" + //
    							"Ateş:"+ kayit.getAtes_Olc()+ "\n" + //
    							"Teşhis:"+ kayit.getTeshis_Oluru());
    	}
    	else {
    		System.out.println("Herhangi bir kayit secilmedi...");
    	}
    }
    
    @FXML
    void kayitlar_table_Clicked(MouseEvent event) {
    	
    	KayitlarTable kayit=new KayitlarTable();
    	kayit= (KayitlarTable) kayitlarTable.getItems().get(kayitlarTable.getSelectionModel().getSelectedIndex());

    	txt_Ad.setText(kayit.getHasta_Adi());
    	combo_Sehir.setValue(kayit.getSehir_Adi());
    
    	label_Deg.setText(kayit.getAtes_Olc());
    	
    }
    
    
    @FXML
    void combo_sehir_Clicked(ActionEvent event) {
    	System.out.println( combo_Sehir.getSelectionModel().getSelectedItem());
    	
    }
    
    
    
    
    @FXML
    void initialize() {
    	

    	tumveriler=FXCollections.observableArrayList();
    	tumveriler.add(new KayitlarTable("kasapSaru","istanbul" , "işçi", "Erkek", "22", "Pozitif" ));
    	
   
    	hasta_Adi.setCellValueFactory(new PropertyValueFactory<> ("hasta_Adi"));
    	sehir_Adi.setCellValueFactory(new PropertyValueFactory<> ("sehir_Adi"));
    	
    	meslekler.setCellValueFactory(new PropertyValueFactory<> ("meslek_Adi"));
    	cinsiyetler.setCellValueFactory(new PropertyValueFactory<> ("cinsiyet_Adi"));
      
    	ates_Olc.setCellValueFactory(new PropertyValueFactory<> ("ates_Olc"));
    	tshs.setCellValueFactory(new PropertyValueFactory<> ("teshis_Oluru"));
    	

    	kayitlarTable.setItems(tumveriler);

    	//SLİDER KISMI
    	
    	
    	slider_Ates.setMax(43.7);
    	slider_Ates.setMin(21);
    			
    	slider_Ates.setShowTickLabels(true);
    	
    	   slider_Ates.valueProperty().addListener(new ChangeListener<Number>() {
    				@Override
    				public void changed(ObservableValue<? extends Number> observed, Number oldValue, Number newValue) {
    					
    					label_Deg.setText("Ateşi:"+ newValue+"derece");
    					
    				}
    			});
    	   
    	   ObservableList<String>list=FXCollections.observableArrayList(
    	            "Hatay","İstanbul","Ankara","İzmir","Bursa");
    	   combo_Sehir.getItems().addAll(list);
    	   


    }
    	
    
	}















