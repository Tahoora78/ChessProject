import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Ground {
    private String x;
    private int y;
    ArrayList<Pices> chessPicess = new ArrayList<>();
    public void makingChessPicess(){
        chessPicess.add(new Rook('a',1,"black",1));
        chessPicess.add(new Knight('b',1,"black",1));
            chessPicess.add(new Bishop('c',1,"black",1));
            chessPicess.add(new Queen('d',1,"black"));
            chessPicess.add(new King('e',1,"black"));
            chessPicess.add(new Bishop('f',1,"black",2));
            chessPicess.add(new Knight('g',1,"black",2));
            chessPicess.add(new Rook('h',1,"black",2));
            chessPicess.add(new Rook('a',8,"white",1));
            chessPicess.add(new Knight('b',8,"white",1));
            chessPicess.add(new Bishop('c',8,"white",1));
            chessPicess.add(new Queen('d',8,"white"));
            chessPicess.add(new King('e',8,"white"));
            chessPicess.add(new Bishop('f',8,"white",2));
            chessPicess.add(new Knight('g',8,"white",2));
            chessPicess.add(new Rook('h',8,"white",2));
        ArrayList<Character> y = new ArrayList<Character>();
        y.add('a');
        y.add('b');
        y.add('c');
        y.add('d');
        y.add('e');
        y.add('f');
        y.add('g');
        y.add('h');
        int r=0;
            for(int i=16;i<=23;i++){
                chessPicess.add(new Pawn(y.get(r),2,"black"));
                r++;
            }
            r=0;
            for(int i=24;i<=31;i++){
                chessPicess.add(new Pawn(y.get(r),7,"white"));
                r++;
            }
  //      System.out.println(chessPicess.get(0).getName()+"  "+chessPicess.get(31).getName()+"x:"+chessPicess.get(31).getX()+"y:"+chessPicess.get(31).getY()+"color"+chessPicess.get(31).getColor());
    }

    public void display(){
        int y=0;
        for(int j=8;j>=1;j--){
            for(int i=1;i<=8;i++){
                for(int g=(chessPicess.size()-1);g>=0;g--){
                    y=0;
                    if(chessPicess.get(g).getX()==i && chessPicess.get(g).getY()==j){
                        System.out.print("|"+chessPicess.get(g).getName()+chessPicess.get(g).getColor());
                        y=1;
                        break;
                    }
                }
                if(y!=1){
                    System.out.print("|    ");
                }
            }
            System.out.print("|");
            System.out.println();
            System.out.print("__________________________________________________");
            System.out.println();
        }
    }

    public String checkRook(int x1,int x2,int y1,int y2){
        int cont;
        cont = 0;
        String continues = "no";
        int dx = Math.abs(x2-x1);
        int dy = Math.abs(y2-y1);
        if (dx != dy && (dx == 0 || dy == 0)) {
            continues = "no";
            dy = y2 - y1;
            if ((dx == 0)) {
                for (int e = 0; e < chessPicess.size(); e++) {
                    for (int i = (Math.min(y1, y2)) + 1; i < Math.max(y1, y2); i++) {
                        if (chessPicess.get(e).getX() == x1 && chessPicess.get(e).getY() == i) {
                            cont++;
                        }
                    }
                }
                if (cont == 0) {
                    continues = "yes";
                }
            }
            cont = 0;
            if ((dy == 0)) {
                for (int r = (Math.min(x1, x2) + 1); r < Math.max(x1, x2); r++) {
                    if (chessPicess.get(r).getX() == r && chessPicess.get(r).getY() == y1) {
                        cont++;
                    }
                }
                if (cont == 0) {
                    continues = "yes";
                }
            }
        }
        return continues;
    }

    public String checkBishop(int x1,int x2,int y1,int y2,String colorss){
        int t = 0;
        int dx = Math.abs(x2-x1);
        int dy = Math.abs(y2-y1);
        int conts = 0;
        String continues = "no";
        if (dx == dy) {
            continues = "no";
            conts = 0;
            for (int r = 0; r < chessPicess.size(); r++) {
                t = Math.min(y1, y2) + 1;
                for (int i = (Math.min(x1, x2) + 1); i < Math.max(x1, x2); i++) {
                    //System.out.println("ooooooo");
                    if (chessPicess.get(r).getX() == i && chessPicess.get(r).getY() == t) {
                        //System.out.println("i" + i + "y" + t + "name" + chessPicess.get(r).getName());

                        if (chessPicess.get(r).getY() == y2 && chessPicess.get(r).getX() == x2) {
                            if (chessPicess.get(r).getColor().equals(colorss)) {
                      //          System.out.println("color" + chessPicess.get(r).getColor());
                            } else {
                        //        System.out.println("000000000000");
                                conts++;
                            }
                        }
                    }
                    t++;
                }
                if (chessPicess.get(r).getY() == y2 && chessPicess.get(r).getX() == x2) {
                    if (chessPicess.get(r).getColor().equals(colorss)) {
                        //System.out.println("color" + chessPicess.get(r).getColor());
                    } else {
                        //System.out.println("000000000000");
                        conts++;
                    }
                }

            }
            if (conts == 0) {
                continues = "yes";
            }
            conts = 0;
        }
        return continues;
    }

    public String checkQueen(int x1,int x2,int y1,int y2,String colorss){
        int dx = Math.abs(x2-x1);
        int dy = Math.abs(y2-y1);
        int conts = 0;
        String continues = "no";

        if ((dy == dx) || (dy == 0) || (dx == 0)) {
            continues = "no";
            if (dy == 0) {
                conts = 0;
                for (int w = Math.min(x1, x2) + 1; w < Math.max(x1, x2); w++) {
                    for (int r = 0; r < chessPicess.size(); r++) {
                        if (chessPicess.get(r).getX() == w && chessPicess.get(w).getY() == y1) {
                            conts++;
                        }
                    }
                }
                for (int i = 0; i < chessPicess.size(); i++) {
                    if (chessPicess.get(i).getX() == x2 && chessPicess.get(i).getY() == y2) {
                        if (chessPicess.get(i).getColor().equals(colorss)) {
                        } else {
                            conts++;
                        }
                    }
                }
                if (conts == 0) {
                    continues = "yes";
                }
            }
            if (dx == 0) {
                conts = 0;
                for (int w = Math.min(y1, y2) + 1; w < Math.max(y1, y2); w++) {
                    for (int r = 0; r < chessPicess.size(); r++) {
                        if (chessPicess.get(r).getX() == x1 && chessPicess.get(w).getY() == w) {
                            conts++;
                        }
                    }
                }
                for (int i = 0; i < chessPicess.size(); i++) {
                    if (chessPicess.get(i).getX() == x2 && chessPicess.get(i).getY() == y2) {
                        if (chessPicess.get(i).getColor().equals(colorss)) {
                        } else {
                            conts++;
                        }
                    }
                }
                if (conts == 0) {
                    continues = "yes";
                }
            }
            if (dx == dy) {
                conts = 0;
                int t =0;
                t = Math.min(x1, x2) + 1;
                for (int g = Math.min(y1, y2) + 1; g < Math.max(y1, y2); g++) {
                    for (int r = 0; r < chessPicess.size(); r++) {
                        if (chessPicess.get(r).getX() == t && chessPicess.get(r).getY() == g) {
                            conts++;
                        }
                    }
                }
                for (int i = 0; i < chessPicess.size(); i++) {
                    if (chessPicess.get(i).getX() == x2 && chessPicess.get(i).getY() == y2) {
                        if (chessPicess.get(i).getColor().equals(colorss)) {
                        } else {
                            conts++;
                        }
                    }
                }
                if (conts == 0) {
                    continues = "yes";
                }
            }
        }
        return continues;
    }

    public String checkKing(int x1,int x2,int y1,int y2,String colorChoice){
        int dx = Math.abs(x2-x1);
        int dy = Math.abs(y2-y1);
        String continues = "no";

        if ((dx == 1 && dy == 0) || (dx == 0 && dy == 1) || (dy == dx && dy == 1)) {
            for(int o=0;o<chessPicess.size();o++){
                if(chessPicess.get(o).getX()==x2 && chessPicess.get(o).getY()==y2){
                    if(chessPicess.get(o).getColor().equals(colorChoice)){
                    }
                    else{
                        continues = "yes";
                    }
                }
            }
        }
        return continues;
    }

    public String checkKnight(int x1,int x2,int y1,int y2,String colorss){
        int dx = Math.abs(x2-x1);
        int dy = Math.abs(y2-y1);
        String continues = "no";

        int conts = 0;
        if (dx != dy && ((dx == 1 && dy == 2) || (dx == 2 && dy == 1))) {
            for (int i = 0; i < chessPicess.size(); i++) {
                if (chessPicess.get(i).getX() == x2 && chessPicess.get(i).getY() == y2) {
//                    System.out.println("colors" + colorss);
                    if (chessPicess.get(i).getColor().equals(colorss)) {
                        System.out.println("color" + colorss);
                        conts++;
  //                      System.out.println("counts" + conts);
                    }
                }
            }
            if (conts == 0) {
                continues = "yes";
            }
        }
        return continues;
    }

    public String checkPawn(int x1,int x2,int y1,int y2){
        int dy = Math.abs(y2-y1);
        int dx = Math.abs(x2-x1);
        String continues = "no";
        dy = y2-y1;

    //    System.out.println("dy"+dy);
      //  System.out.println("con"+continues);
        for(int j=0;j<chessPicess.size();j++){
        if(chessPicess.get(j).getFirst().equals("no") && dx==0 && (Math.abs(dy)==1 || Math.abs(dy)==2)){
            if(chessPicess.get(j).getColor().equals("black") && (dy<0)){
                continues = "yes";
                chessPicess.get(j).setFirst("yes");
            }
            if(chessPicess.get(j).getColor().equals("white") && (dy>0)){
                continues = "yes";
                chessPicess.get(j).setFirst("yes");
            }
        }
        if(chessPicess.get(j).getFirst().equals("yes") && dx==0 && Math.abs(dy)==1){
            if(chessPicess.get(j).getColor().equals("black") && (dy<0)){
                continues = "yes";
            }
            if(chessPicess.get(j).getColor().equals("white") && (dy>0)) {
                continues = "yes";
            }
        }
        }
        return continues;
    }

    public String  move(String address , String colorChoice) {
        Scanner input = new Scanner(System.in);
        int x1;
        String finish = "no";
        int go = 0;
        Pices p = new Queen('a', 2, "white");
        x1 = p.setX(address.charAt(0));
        int y1 = Character.getNumericValue(address.charAt(1));
        int x2 = p.setX(address.charAt(3));
        int y2 = Character.getNumericValue(address.charAt(4));
        for (int o = 0; o < chessPicess.size(); o++) {
            if (chessPicess.get(o).getX() == x1 && chessPicess.get(o).getY() == y1) {
                if (chessPicess.get(o).getColor().equals(colorChoice)) {
                    go = 0;
                } else {
                    go++;
                    System.out.println("It's not your chess picess  try from yours! ");
                    String vorood = input.next();
                    move(vorood, colorChoice);
                }
            }
        }

            String name;
        String s = "no";
            String continues = "no";
            for (int j = 0; j < chessPicess.size(); j++) {
                if (chessPicess.get(j).getX() == x1 && chessPicess.get(j).getY() == y1) {
                    int dx;
                    int dy;
                   // System.out.println("color of " + chessPicess.get(j).getColor());
                   // System.out.println("*********************************");
                    dx = Math.abs(x2 - x1);
                    dy = Math.abs(y2 - y1);
                    continues = "no";
                    name = chessPicess.get(j).getName();
                    String colorss = chessPicess.get(j).getColor();
                   // System.out.println("name" + name + chessPicess.get(j).getY());
                    switch (name) {
                        case "Rook":
                            continues = checkRook(x1,x2,y1,y2);
                            break;
                        case "Pawn":
                            continues = checkPawn(x1,x2,y1,y2);
                            break;
                        case "Bishop":
                            continues = checkBishop(x1,x2,y1,y2,colorss);
                            break;
                        case "Queen":
                            continues = checkQueen(x1,x2,y1,y2,colorss);
                            break;
                        case "Knight":
                            continues = checkKnight(x1,x2,y1,y2,colorss);
                            break;
                        case "King":
                            makingPicessChoices();
                            s = checkKingChoice(x1,x2,y1,y2);
                            if(s.equals("no")){
                                System.out.println("wrong move(kish) try one more time");
                                String r = input.next();
                                move(r,colorChoice);
                            }
                            else {
                                continues = checkKing(x1, x2, y1, y2, colorChoice);
                            }

                            if(chessPicess.get(j).getSizeOfChoices()==0){
                                System.out.println("you loose");
                                finish = "yes";
                            }
                            break;
                    }
                    break;
                }
            }
            for (int j = 0; j < chessPicess.size(); j++) {
                if (chessPicess.get(j).getX() == x2 && chessPicess.get(j).getY() == y2) {
                    if (continues.equals("yes")) {
                        chessPicess.remove(j);
                    }
                }
                if (continues.equals("no")) {
                    System.out.println("wrong move");
                    System.out.println("try one more time");
                    String newVoroodi = input.next();
                    move(newVoroodi,colorChoice);
                    break;
                }
                break;
            }

            for (int i = 0; i < chessPicess.size(); i++) {
                if (chessPicess.get(i).getX() == x1 && chessPicess.get(i).getY() == y1 && continues.equals("yes")) {
                    chessPicess.get(i).setX(address.charAt(3));
                 //   System.out.println("**************************************");
                    chessPicess.get(i).setY(Character.getNumericValue(address.charAt(4)));
                   // System.out.println("x::" + chessPicess.get(i).getX() + "y::" + chessPicess.get(i).getY() + chessPicess.get(i).getName() + chessPicess.get(i).getColor());
                    break;
                }
            }
            return finish;
    }


    public void makingPicessChoices(){
        int t;
        int x1=0;
        int y1=0;
        String result;
        String type = null;
        String colors = null;
        for(Pices ui:chessPicess){
                x1 = ui.getX();
                y1 = ui.getY();
            t=1;
            for(int y=0;y<chessPicess.size();y++){
                if(chessPicess.get(y).getX()==x1 && chessPicess.get(y).getY()==y1){
                    type = chessPicess.get(y).getName();
                    colors = chessPicess.get(y).getColor();
                    break;
                }
            }
            switch (type){
                case "Pawn":
                    t=1;
                    for(int u=1;u<=8;u++){
                        result = checkPawn(x1,y1,t,u);
                        if(result.equals("yes")){
                            for(int y=0;y<chessPicess.size();y++){
                                if(chessPicess.get(y).getX()==x1 && chessPicess.get(y).getY()==y1){
                                    chessPicess.get(y).setChoices(t,u);
                                    break;
                                }
                            }
                        }
                        t++;
                    }

                    break;
                case "Rook":
                    t=1;
                    for(int u=1;u<=8;u++){
                        result = checkRook(x1,y1,t,u);
                        if(result.equals("yes")){
                            for(int y=0;y<chessPicess.size();y++){
                                if(chessPicess.get(y).getX()==x1 && chessPicess.get(y).getY()==y1){
                                    chessPicess.get(y).setChoices(t,u);
                                    break;
                                }
                            }
                        }
                        t++;
                    }

                    break;
                case "Knight":
                        t=1;
                    for(int u=1;u<=8;u++){
                        result = checkKnight(x1,y1,t,u,colors);
                        if(result.equals("yes")){
                            for(int y=0;y<chessPicess.size();y++){
                                if(chessPicess.get(y).getX()==x1 && chessPicess.get(y).getY()==y1){
                                    chessPicess.get(y).setChoices(t,u);
                                    break;
                                }
                            }
                        }
                        t++;
                    }
                        break;
                case "Bishop":
                    t=1;
                    for(int u=1;u<=8;u++){
                        result = checkBishop(x1,y1,t,u,colors);
                        if(result.equals("yes")){
                            for(int y=0;y<chessPicess.size();y++){
                                if(chessPicess.get(y).getX()==x1 && chessPicess.get(y).getY()==y1){
                                    chessPicess.get(y).setChoices(t,u);
                                    break;
                                }
                            }
                        }
                        t++;
                    }

                    break;
                case "Queen":
                    t=1;
                    for(int u=1;u<=8;u++){
                        result = checkQueen(x1,y1,t,u,colors);
                        if(result.equals("yes")){
                            for(int y=0;y<chessPicess.size();y++){
                                if(chessPicess.get(y).getX()==x1 && chessPicess.get(y).getY()==y1){
                                    chessPicess.get(y).setChoices(t,u);
                                    break;
                                }
                            }
                        }
                        t++;
                    }

                    break;
                case"King":
                    t=1;
                    for(int u=1;u<=8;u++){
                        result = checkKing(x1,y1,t,u,colors);
                        if(result.equals("yes")){
                            for(int y=0;y<chessPicess.size();y++){
                                if(chessPicess.get(y).getX()==x1 && chessPicess.get(y).getY()==y1){
                                    chessPicess.get(y).setChoices(t,u);
                                    break;
                                }
                            }
                        }
                        t++;
                    }

                    break;
            }
        }
    }

    public String checkKingChoice(int x1,int x2,int y1,int y2){
        String f="no";
        int t=1;
        for(int y=0;y<chessPicess.size();y++){
            if(chessPicess.get(y).getX()==x1 && chessPicess.get(y).getY()==y1){
                t=y;
                break;
            }
        }
        int yz=0;

        for(int o=0;o<chessPicess.get(t).getXChoice().size();o++) {
            for(int r=0;r<chessPicess.get(t).getyChoice().size();r++) {
                for(Pices p:chessPicess){
                    for(int x22: p.getXChoice()){
                        if(x22==chessPicess.get(t).getXChoice().get(o) && chessPicess.get(t).getyChoice().get(r)==p.getyChoice().get(yz) ){
                            chessPicess.get(t).getXChoice().remove(o);
                            chessPicess.get(t).getyChoice().remove(r);
                        }
                        yz++;
                    }
                }
            }
        }
        int r=0;
        for(int i=0;i<chessPicess.get(t).getXChoice().size();i++){
            if(chessPicess.get(t).getXChoice().get(i)== x2 && chessPicess.get(t).getyChoice().get(i)==y2){
                f = "yes";
            }
        }

        return f;
    }

    public void moving(){
        Scanner input = new Scanner(System.in);
        String finish = "no";
        String voroodi;
        String voroodii;
        String color;
        while(finish!="yes"){
            System.out.println("white turn");
            makingChessPicess();
            voroodi = input.next();
            color = "white";
            finish = move(voroodi,color);
            System.out.println("black turn");
            voroodii = input.next();
            color = "black";
            finish = move(voroodii,color);
            display();
            //finish = "yes";
        }
    }




}
