package erciyes.edu.tr.kelimeoyunu;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.IndexRange;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


public class kelimeoyunuController {
    private int sonucKelimeSayisi=0;
    private int count=1;
    private int kelimeLblcount=0;
    private int manuelLblcount=0;
    private int skor;
    private ArrayList<String> sablon = new ArrayList<>();
    private ArrayList<String> anlikSonuc = new ArrayList<>();
    @FXML
    private Label bildirimLbl;
    @FXML
    private TextField manuelLbl;
    @FXML
    private Label sonucLbl;
    @FXML
    private Label sonucLbl2;
    @FXML
    private TextArea kelimeLbl;
    @FXML
    private Polygon middleBtn;
    @FXML
    private Polygon btn1;
    @FXML
    private Polygon btn2;
    @FXML
    private Polygon btn3;
    @FXML
    private Polygon btn4;
    @FXML
    private Polygon btn5;
    @FXML
    private Polygon btn6;
    @FXML
    private ImageView bee;
    @FXML
    private Label lblm;
    @FXML
    private Label lbl1;
    @FXML
    private Label lbl2;
    @FXML
    private Label lbl3;
    @FXML
    private Label lbl4;
    @FXML
    private Label lbl5;
    @FXML
    private Label lbl6;
    @FXML
    private Label skorLbl;

    public void setSablon(ArrayList<String> sablon) {
        this.sablon = sablon;
    }

    @FXML
    protected void onMousePressedm() {
        middleBtn.setScaleX(0.90);
        middleBtn.setScaleY(0.90);
        clear();
        kelimeLbl.appendText(lblm.getText());
     }
     @FXML
    protected void onMouseReleasedm(){
        middleBtn.setScaleX(1);
        middleBtn.setScaleY(1);
     }
     @FXML
    protected void onMousePressed1(){
        btn1.setScaleX(0.90);
        btn1.setScaleY(0.90);
        clear();
        kelimeLbl.appendText(lbl1.getText());
     }
     @FXML
    protected void onMouseReleased1(){
        btn1.setScaleX(1);
        btn1.setScaleY(1);
     }
    @FXML
    protected void onMousePressed2(){
        btn2.setScaleX(0.90);
        btn2.setScaleY(0.90);
        clear();
        kelimeLbl.appendText(lbl2.getText());
    }
    @FXML
    protected void onMouseReleased2(){
        btn2.setScaleX(1);
        btn2.setScaleY(1);
    }
    @FXML
    protected void onMousePressed3(){
        btn3.setScaleX(0.90);
        btn3.setScaleY(0.90);
        clear();
        kelimeLbl.appendText(lbl3.getText());
    }
    @FXML
    protected void onMouseReleased3(){
        btn3.setScaleX(1);
        btn3.setScaleY(1);
    }
    @FXML
    protected void onMousePressed4(){
        btn4.setScaleX(0.90);
        btn4.setScaleY(0.90);
        clear();
        kelimeLbl.appendText(lbl4.getText());
    }
    @FXML
    protected void onMouseReleased4(){
        btn4.setScaleX(1);
        btn4.setScaleY(1);
    }
    @FXML
    protected void onMousePressed5(){
        btn5.setScaleX(0.90);
        btn5.setScaleY(0.90);
        clear();
        kelimeLbl.appendText(lbl5.getText());
    }
    @FXML
    protected void onMouseReleased5(){
        btn5.setScaleX(1);
        btn5.setScaleY(1);
    }
    @FXML
    protected void onMousePressed6(){
        btn6.setScaleX(0.90);
        btn6.setScaleY(0.90);
        clear();
        kelimeLbl.appendText(lbl6.getText());
    }
    @FXML
    protected void onMouseReleased6(){
        btn6.setScaleX(1);
        btn6.setScaleY(1);
    }
    @FXML
    protected void onShufflePressed(){
        ArrayList<String> list = new ArrayList<>();
        list.add(lbl1.getText());
        list.add(lbl2.getText());
        list.add(lbl3.getText());
        list.add(lbl4.getText());
        list.add(lbl5.getText());
        list.add(lbl6.getText());
        Collections.shuffle(list);
        lbl1.setText(list.get(0));
        lbl2.setText(list.get(1));
        lbl3.setText(list.get(2));
        lbl4.setText(list.get(3));
        lbl5.setText(list.get(4));
        lbl6.setText(list.get(5));
        if(manuelLbl.getLength()==0){
            manuelLbl.setText("Ben yazayım");
            manuelLblcount=0;
        }
        if(kelimeLbl.getLength()==0){
            kelimeLbl.setText("Yaz veya tıkla");
            kelimeLblcount=0;
        }
    }
    @FXML
    protected void onBeeClicked(){
        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                bee.setX(bee.getX()+20);
                bee.setY(bee.getY()+11);
            }
        }));
        loop.setCycleCount(36);
        if (count%2==0){
            bee.setY(bee.getY()-20);
            count++;
        }
        else if (count==15){
            loop.play();
            count++;
        }
        else{
            bee.setY(bee.getY()+20);
            count++;
        }
    }
    @FXML
    protected void onKelimeLblClicked(){
        clear();
    }
    private void clear(){
        if(kelimeLblcount==0){
            kelimeLbl.clear();
            kelimeLblcount++;
        }
        if(kelimeLbl.getLength()>15){
            kelimeLbl.clear();
            bildirimLbl.setText("Çok uzun!");
            bildirim(bildirimLbl);
        }
        if(manuelLbl.getLength()==0){
            manuelLbl.setText("Yaz veya tıkla");
            manuelLblcount=0;
        }
    }
    @FXML
    protected void onDeleteClicked(){
        if (kelimeLbl.getText().equals("Yaz veya tıkla")){
            kelimeLbl.clear();
        }
        if(kelimeLbl.getLength()>=1){
            kelimeLbl.deleteText(new IndexRange(kelimeLbl.getLength()-1,kelimeLbl.getLength()));
        }
        if(manuelLbl.getLength()==0){
            manuelLbl.setText("Ben yazayım");
            manuelLblcount=0;
        }
        if(kelimeLbl.getLength()==0){
            kelimeLbl.setText("Yaz veya tıkla");
            kelimeLblcount=0;
        }
    }
    @FXML
    protected void onTickClicked() throws FileNotFoundException {
        kelimeLbl.setText(kelimeLbl.getText().toLowerCase(Locale.ROOT));
        if(kelimeLbl.getText().equals("Yaz veya tıkla")){
            kelimeLbl.clear();
        }
        if(kelimeLbl.getText().indexOf(lblm.getText())!=-1){
            if(gameBuilder.kelimeVarmi(kelimeLbl.getText())){
                if(!anlikSonuc.contains(String.valueOf(kelimeLbl.getText()))){
                    if(sonucKelimeSayisi>9){
                        sonucLbl2.setText(sonucLbl2.getText()+kelimeLbl.getText()+"\n");
                    }
                    else{
                        sonucLbl.setText(sonucLbl.getText()+kelimeLbl.getText()+"\n");
                    }
                    sonucKelimeSayisi++;
                    if(gameBuilder.isPangram(kelimeLbl.getText())){
                        skor+=kelimeLbl.getLength()+4;
                        bildirimLbl.setText("Mükemmel! +"+String.valueOf(kelimeLbl.getLength()+4));
                        bildirim(bildirimLbl);
                    }
                    else{skor+=kelimeLbl.getLength()-3;
                        if(kelimeLbl.getLength()-3==1){
                            bildirimLbl.setText("İdare eder +"+String.valueOf(kelimeLbl.getLength()-3));
                            bildirim(bildirimLbl);
                        }
                        if(kelimeLbl.getLength()-3==2){
                            bildirimLbl.setText("Güzel! +"+String.valueOf(kelimeLbl.getLength()-3));
                            bildirim(bildirimLbl);
                        }
                        if(kelimeLbl.getLength()-3==3){
                            bildirimLbl.setText("İyi! +"+String.valueOf(kelimeLbl.getLength()-3));
                            bildirim(bildirimLbl);
                        }
                        if(kelimeLbl.getLength()-3>=4){
                            bildirimLbl.setText("Çok iyi! +"+String.valueOf(kelimeLbl.getLength()-3));
                            bildirim(bildirimLbl);
                        }

                    }

                }
                anlikSonuc.add(kelimeLbl.getText());
            }

            skorLbl.setText(String.valueOf(skor));

        }
        kelimeLbl.clear();
        if(manuelLbl.getLength()==0){
            manuelLbl.setText("Ben yazayım");
            manuelLblcount=0;
        }
        if(kelimeLbl.getLength()==0){
            kelimeLbl.setText("Yaz veya tıkla");
            kelimeLblcount=0;
        }
        if(skor>30){
            bildirimLbl.setText("Tebrikler çok iyiydin");
            lbl1.setText("");
            lbl2.setText("");
            lbl3.setText("");
            lbl4.setText("");
            lbl5.setText("");
            lbl6.setText("");
            lblm.setText("");
            skor=0;
        }
    }
    @FXML
    protected void onManuelClicked(){
        if(manuelLblcount==0){
            manuelLbl.clear();
            manuelLblcount++;
        }
        if(kelimeLbl.getLength()==0){
            kelimeLbl.setText("Yaz veya tıkla");
            kelimeLblcount=0;
        }
    }
    private void bildirim(Label label){
        label.setScaleX(1);
        label.setScaleY(1);
        final Timeline loop = new Timeline(new KeyFrame(new Duration(100), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                label.setScaleX(label.getScaleX()+0.15);
                label.setScaleY(label.getScaleY()+0.15);
            }
        }));
        loop.setCycleCount(4);
        loop.play();
    }
    @FXML
    protected void onManuelEntered() throws IOException {
        manuelLbl.setText(manuelLbl.getText().toLowerCase(Locale.ROOT));
        if(gameBuilder.isPangram(manuelLbl.getText())){
            System.out.println("pangram");
            gameBuilder.clearAnlikSablon();
            gameBuilder.setAnlikSablon(manuelLbl.getText(0,1));
            gameBuilder.setAnlikSablon(manuelLbl.getText(1,2));
            gameBuilder.setAnlikSablon(manuelLbl.getText(2,3));
            gameBuilder.setAnlikSablon(manuelLbl.getText(3,4));
            gameBuilder.setAnlikSablon(manuelLbl.getText(4,5));
            gameBuilder.setAnlikSablon(manuelLbl.getText(5,6));
            gameBuilder.setAnlikSablon(manuelLbl.getText(6,7));
            System.out.println(gameBuilder.getAnlikSablon());
            gameBuilder.anlikKelimeListOlustur();
            if(gameBuilder.isSablonUygunmu()){
                lbl1.setText(manuelLbl.getText(0,1));
                lbl2.setText(manuelLbl.getText(1,2));
                lbl3.setText(manuelLbl.getText(2,3));
                lblm.setText(manuelLbl.getText(3,4));
                lbl4.setText(manuelLbl.getText(4,5));
                lbl5.setText(manuelLbl.getText(5,6));
                lbl6.setText(manuelLbl.getText(6,7));
                bildirimLbl.setText("Oluşturuldu");
                bildirim(bildirimLbl);
            }
            else{
                bildirimLbl.setText("Uygun Değil");
                bildirim(bildirimLbl);
            }

        }
        else{
            bildirimLbl.setText("Uygun Değil");
            bildirim(bildirimLbl);
        }


    }
    @FXML
    protected void onYeniClicked() throws IOException {
        gameBuilder.anlikSablonRandom();
        setSablon(gameBuilder.getAnlikSablon());
        System.out.println(sablon);
        lbl1.setText(sablon.get(0));
        lbl2.setText(sablon.get(1));
        lbl3.setText(sablon.get(2));
        lblm.setText(sablon.get(3));
        lbl5.setText(sablon.get(4));
        lbl6.setText(sablon.get(5));
        lbl4.setText(sablon.get(6));
        sonucLbl.setText("");
        sonucLbl2.setText("");
        sonucKelimeSayisi=0;
    }

}