/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculator_project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Mariam
 */
public class Calculator_Project extends Application{

    /**
     * @param args the command line arguments
     */
    Integer i;
    Float data = 0f;
    int nflag = 0, firstDot = 1;
    char oper = '+';
    
    @Override
    public void start(Stage s) throws Exception{
        /*TextField*/
        TextArea opField = new TextArea();
        opField.setId("textArea");
        opField.setDisable(true);
        opField.setMaxHeight(175);
        opField.setMinHeight(175);
        opField.setText("");
        
        /*Result Label*/
        Label resLabel = new Label("0");
        resLabel.setId("label");
        
        /*Result Pane*/
        StackPane resPane = new StackPane(opField, resLabel);
        resPane.setAlignment(Pos.BOTTOM_RIGHT);
        
        /*Operations*/
        Button add = new Button("+");
        add.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        add.setId("opButton");
        add.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                /*data += Float.parseFloat(opField.getText());
                opField.setText(data.toString()+"+");
                resLabel.setText(data.toString());*/
                
                opField.setText(opField.getText() + resLabel.getText()+"+");
                nflag = 0;
                increment();
                oper = '+';
                firstDot = 1;                
            }

            private void increment() {
                switch (oper){
                    case '+':
                        data += Float.parseFloat(resLabel.getText());
                        break;
                    case '-':
                        data -= Float.parseFloat(resLabel.getText());
                        break;
                    case '*':
                        data *= Float.parseFloat(resLabel.getText());
                        break;
                    case '/':
                        data /= Float.parseFloat(resLabel.getText());
                        break;
                }
                resLabel.setText(data.toString());
            }
        });
        
        Button sub = new Button("-");
        sub.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        sub.setId("opButton");
        sub.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                /*data += Float.parseFloat(opField.getText());
                opField.setText(data.toString()+"+");
                resLabel.setText(data.toString());*/
                //oper = '-';
                opField.setText(opField.getText() + resLabel.getText()+"-");
                nflag = 0;
                //data -= Float.parseFloat(resLabel.getText());
                //resLabel.setText(data.toString());
                decrement();
                oper = '-';
                firstDot = 1;
                
            }

            private void decrement() {
                switch (oper){
                    case '+':
                        data += Float.parseFloat(resLabel.getText());
                        break;
                    case '-':
                        data -= Float.parseFloat(resLabel.getText());
                        break;
                    case '*':
                        data *= Float.parseFloat(resLabel.getText());
                        break;
                    case '/':
                        data /= Float.parseFloat(resLabel.getText());
                        break;
                }
                resLabel.setText(data.toString());
            }
        });
        
        Button div = new Button("/");
        div.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        div.setId("opButton");
        div.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                /*data += Float.parseFloat(opField.getText());
                opField.setText(data.toString()+"+");
                resLabel.setText(data.toString());*/
                
                opField.setText(opField.getText() + resLabel.getText()+"/");
                nflag = 0;
                divide();
                oper = '/';
                firstDot = 1;
            }

            private void divide() {
                switch (oper){
                    case '+':
                        data += Float.parseFloat(resLabel.getText());
                        break;
                    case '-':
                        data -= Float.parseFloat(resLabel.getText());
                        break;
                    case '*':
                        data *= Float.parseFloat(resLabel.getText());
                        break;
                    case '/':
                        data /= Float.parseFloat(resLabel.getText());
                        break;
                }
                resLabel.setText(data.toString());
            }
        });
        
        Button mul = new Button("*");
        mul.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        mul.setId("opButton");
        mul.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                /*data += Float.parseFloat(opField.getText());
                opField.setText(data.toString()+"+");
                resLabel.setText(data.toString());*/
                
                opField.setText(opField.getText() + resLabel.getText()+"*");
                nflag = 0;
                multiply();
                oper = '*';
                firstDot = 1;
            }

            private void multiply() {
                switch (oper){
                    case '+':
                        data += Float.parseFloat(resLabel.getText());
                        break;
                    case '-':
                        data -= Float.parseFloat(resLabel.getText());
                        break;
                    case '*':
                        data *= Float.parseFloat(resLabel.getText());
                        break;
                    case '/':
                        data /= Float.parseFloat(resLabel.getText());
                        break;
                }
                resLabel.setText(data.toString());
            }
        });
        
        Button dot = new Button(".");
        dot.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        dot.setId("opButton");
        dot.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                if (firstDot == 1)
                {
                    //resLabel.setText(resLabel.getText() + ".");
                    if(nflag == 0)
                    {
                        resLabel.setText("0");
                    }
                    nflag = 1;
                    resLabel.setText(resLabel.getText() + ".");
                    firstDot=0;
                }
            }
        });
        
        Button equal = new Button("=");
        equal.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        equal.setId("opButton");
        equal.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                nflag = 0;
                opField.setText("");
                equal();
                data = 0f;
            }

            private void equal() {
                switch (oper){
                    case '+':
                        data += Float.parseFloat(resLabel.getText());
                        break;
                    case '-':
                        data -= Float.parseFloat(resLabel.getText());
                        break;
                    case '*':
                        data *= Float.parseFloat(resLabel.getText());
                        break;
                    case '/':
                        data /= Float.parseFloat(resLabel.getText());
                        break;
                }
                resLabel.setText(data.toString());
                oper = '+';
            }
        });
        
        GridPane buttonsPane = new GridPane();
        
        for (int col = 0 ; col < 4 ; col++ ){
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setHgrow(Priority.ALWAYS) ;
            colConst.setFillWidth(true);
            buttonsPane.getColumnConstraints().add(colConst); 
        }
        
        for (int row = 0 ; row < 4 ; row++ ){
            RowConstraints rowConst = new RowConstraints();
            rowConst.setVgrow(Priority.ALWAYS) ;
            rowConst.setFillHeight(true);
            buttonsPane.getRowConstraints().add(rowConst); 
        }
        
        
        /*Numbers Buttons*/
        Button zero = new Button("0");
        zero.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        zero.setId("numButton");
        zero.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    if(nflag == 0)
                    {
                        resLabel.setText("");
                    }
                    nflag = 1;
                    resLabel.setText(resLabel.getText()+"0");
                    //zero.setStyle("-fx-background-color: Grey");
                }
            }
            );
        
        
        Button one = new Button("1");
        one.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        one.setId("numButton");
        one.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    //opField.setText(opField.getText()+"1");
                    if(nflag == 0)
                    {
                        resLabel.setText("");
                    }
                    nflag = 1;
                    resLabel.setText(resLabel.getText()+"1");
                   
                }
            }
            );

        Button two = new Button("2");
        two.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        two.setId("numButton");
        two.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    
                    if(nflag == 0)
                    {
                        resLabel.setText("");
                    }
                    nflag = 1;
                    //opField.setText(opField.getText()+"2");
                    resLabel.setText(resLabel.getText()+"2");
                    
                }
            }
            );
        
        Button three = new Button("3");
        three.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        three.setId("numButton");
        three.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    if(nflag == 0)
                    {
                        resLabel.setText("");
                    }
                    nflag = 1;
                    //opField.setText(opField.getText()+"3");
                    resLabel.setText(resLabel.getText()+"3");
                }
            }
            );
        
        Button four = new Button("4");
        four.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        four.setId("numButton");
        four.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    if(nflag == 0)
                    {
                        resLabel.setText("");
                    }
                    nflag = 1;
                    //opField.setText(opField.getText()+"4");
                    resLabel.setText(resLabel.getText()+"4");
                }
            }
            );
        
        Button five = new Button("5");
        five.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        five.setId("numButton");
        five.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    if(nflag == 0)
                    {
                        resLabel.setText("");
                    }
                    nflag = 1;
                    //opField.setText(opField.getText()+"5");
                    resLabel.setText(resLabel.getText()+"5");
                }
            }
            );
        
        Button six = new Button("6");
        six.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        six.setId("numButton");
        six.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    if(nflag == 0)
                    {
                        resLabel.setText("");
                    }
                    nflag = 1;
                    //opField.setText(opField.getText()+"6");
                    resLabel.setText(resLabel.getText()+"6");
                }
            }
            );
        
        Button seven = new Button("7");
        seven.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        seven.setId("numButton");
        seven.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    if(nflag == 0)
                    {
                        resLabel.setText("");
                    }
                    nflag = 1;
                    //opField.setText(opField.getText()+"7");
                    resLabel.setText(resLabel.getText()+"7");
                }
            }
            );
        
        Button eight = new Button("8");
        eight.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        eight.setId("numButton");
        eight.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    if(nflag == 0)
                    {
                        resLabel.setText("");
                    }
                    nflag = 1;
                    //opField.setText(opField.getText()+"8");
                    resLabel.setText(resLabel.getText()+"8");
                }
            }
            );
        
        Button nine = new Button("9");
        nine.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        nine.setId("numButton");
        nine.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    if(nflag == 0)
                    {
                        resLabel.setText("");
                    }
                    nflag = 1;
                    //opField.setText(opField.getText()+"9");
                    resLabel.setText(resLabel.getText()+"9");
                }
            }
            );
        
        buttonsPane.addRow(0, seven, eight, nine, add);
        buttonsPane.addRow(1, four, five, six, sub);
        buttonsPane.addRow(2, one, two, three, div);
        buttonsPane.addRow(3, dot, zero, equal, mul);
        
        /*Numbers Buttons*/
        /*int row = 0;
        int col = 0;
        for(i = 9; i >= 0; i--){
            Button num = new Button(i.toString());
            num.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            num.setId("numButton");
            
            num.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    opField.setText(i.toString());
                }
            }
            );
            
            if(i == 0){
                buttonsPane.add(num, 1, 3);
            }
            else
                buttonsPane.add(num, col, row);
            col++;
            if(col == 3){
                row++;
                col = 0;
            }
            
        }
        
        
        buttonsPane.add(dot, 0, 3);
        buttonsPane.add(equal, 2, 3);
        buttonsPane.addColumn(3, add, sub, div, mul);*/
        
       
        /*CopyRights Label*/
        Label copyRights = new Label("All rights reserved @ Team Bta3");
        
        /*Pane*/
        BorderPane mainPane = new BorderPane();
        mainPane.setTop(resPane);
        mainPane.setCenter(buttonsPane);
        mainPane.setBottom(copyRights);
        
        /*Scene*/
        Scene mainScene = new Scene(mainPane, 550, 750);
        mainScene.getStylesheets().add(getClass().getResource("calcStyle.css").toString());
        
        /*Stage*/
        s.setTitle("SuperCalc");
        s.setScene(mainScene);
        s.initStyle(StageStyle.UTILITY);
        s.show();
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Application.launch(args);
    }
    
}
