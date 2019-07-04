import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * used for defining the features and methods of the chess board
 * Tahoora Majlesi
 *
 */
public class Ground {
    private String x;

    private int y;
    private String turnPiece = "white";
    private boolean start = false;
    ArrayList<String> deletedBlackChess= new ArrayList<>();
    ArrayList<String> getDeletedWhiteChess = new ArrayList<>();
    ArrayList<Pices> chessPicess = new ArrayList<>();
    private Square currentSquare;

    public void setStart(boolean start){
        this.start = start;
    }

    public boolean getStart(){
        return start;
    }
    public void setCurrentSquare(Square square){
        currentSquare = square;
    }

    public Square getCurrentSquare(){
        return currentSquare;
    }

    public void setTurnPiece(String h){
        turnPiece = h;
    }

    public String getTurnPiece(){
        return turnPiece;
    }


    public void makingChessPicess(){
        chessPicess.add(new Rook(1,1,"black",1));
        chessPicess.add(new Knight(2,1,"black",1));
        chessPicess.add(new Bishop(3,1,"black"));
        chessPicess.add(new Queen(4,1,"black"));
        chessPicess.add(new King(5,1,"black"));
        chessPicess.add(new Bishop(6,1,"black"));
        chessPicess.add(new Knight(7,1,"black",2));
        chessPicess.add(new Rook(8,1,"black",2));
        chessPicess.add(new Rook(1,8,"white",1));
        chessPicess.add(new Knight(2,8,"white",1));
        chessPicess.add(new Bishop(3,8,"white"));
        chessPicess.add(new Queen(4,8,"white"));
        chessPicess.add(new King(5,8,"white"));
        chessPicess.add(new Bishop(6,8,"white"));
        chessPicess.add(new Knight(7,8,"white",2));
        chessPicess.add(new Rook(8,8,"white",2));
            int t=1;
            for(int i=16;i<=23;i++){
                chessPicess.add(new Pawn(t,2,"black"));
                t++;
            }
            t=1;
            for(int i=24;i<=31;i++){
                chessPicess.add(new Pawn(t,7,"white"));
                t++;
            }
    }

    /**
     * used for displaying the pieces of chess
     */
    public void display(){
        int y=0;
        for(int i=0;i<chessPicess.size();i++){
            System.out.print(chessPicess.get(i).getName()+chessPicess.get(i).getColor()+"x:"+chessPicess.get(i).getX()+"y:"+chessPicess.get(i).getY()+"I:"+i+"   ");
        }
        System.out.println();
        for(int j=8;j>=1;j--){
            for(int i=1;i<=8;i++){
                for(int g=(chessPicess.size()-1);g>=0;g--){
                    y=0;
                    if(chessPicess.get(g).getX()==i && chessPicess.get(g).getY()==j){
                        System.out.print("|"+chessPicess.get(g).getName()+chessPicess.get(g).getColor()+"x:"+chessPicess.get(g).getX()+"y:"+chessPicess.get(g).getY());
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

    /**
     * identify that we can move this rook piece or not
     * @param x1 x of the starting point
     * @param x2 x of the destination point
     * @param y1 y of the starting point
     * @param y2 y of the destination point
     * @return yes or no to continue or not
     */
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

    /**
     * identify that we can move this bishop piece or not
     * @param x1 x of the starting point
     * @param x2 x of the destination point
     * @param y1 y of the starting point
     * @param y2 y of the destination point
     * @return yes or no to continue or not
     */

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
                    if (chessPicess.get(r).getX() == i && chessPicess.get(r).getY() == t) {
                        if (chessPicess.get(r).getY() == y2 && chessPicess.get(r).getX() == x2) {
                            if (chessPicess.get(r).getColor().equals(colorss)) {
                            } else {
                                conts++;
                            }
                        }
                    }
                    t++;
                }
                if (chessPicess.get(r).getY() == y2 && chessPicess.get(r).getX() == x2) {
                    if (chessPicess.get(r).getColor().equals(colorss)) {
                    } else {
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

    /**
     * identify that we can move this queen piece or not
     * @param x1 x of the starting point
     * @param x2 x of the destination point
     * @param y1 y of the starting point
     * @param y2 y of the destination point
     * @return colorss :yes or no to continue or not
     * @return colorss yes or no to continue
     */

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

    /**
     * identify that we can move this king piece or not
     * @param x1 x of the starting point
     * @param x2 x of the destination point
     * @param y1 y of the starting point
     * @param y2 y of the destination point
     * @return yes or no to continue or not
     */

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

    /**
     * identify that we can move this knight piece or not
     * @param x1 x of the starting point
     * @param x2 x of the destination point
     * @param y1 y of the starting point
     * @param y2 y of the destination point
     * @return yes or no to continue or not
     */

    public String checkKnight(int x1,int x2,int y1,int y2,String colorss){
        int dx = Math.abs(x2-x1);
        int dy = Math.abs(y2-y1);
        String continues = "no";
        int t=0;
        for(int r=0;r<chessPicess.size();r++){
            if(chessPicess.get(r).getX()==x1 && chessPicess.get(r).getY()==y1){
                t=r;
            }
        }
        int conts = 0;
        if (dx != dy && ((dx == 1 && dy == 2) || (dx == 2 && dy == 1))) {
                if (chessPicess.get(t).getX() == x2 && chessPicess.get(t).getY() == y2) {
                    if (chessPicess.get(t).getColor().equals(colorss)) {
                      //  System.out.println("color" + colorss);
                        conts++;
                    }
                }
            }
            if (conts == 0) {
                continues = "yes";
            }
        return continues;
    }

    /**
     * identify that we can move this pawn piece or not
     * @param x1 x of the starting point
     * @param x2 x of the destination point
     * @param y1 y of the starting point
     * @param y2 y of the destination point
     * @return yes or no to continue or not
     */

    public String checkPawn(int x1,int x2,int y1,int y2){
        int dy = Math.abs(y2-y1);
        int dx = Math.abs(x2-x1);
        String continues = "no";
        dy = y2-y1;
        int t=0;
        System.out.println("x1:"+x1+" y1:"+y1+" x2:"+x2+" y2:"+y2+" dx:"+dx+" dy:"+dy);
        for(int r=0;r<chessPicess.size();r++){
            if(chessPicess.get(r).getX()==x1 && chessPicess.get(r).getY()==y1){
                t=r;
            }
        }
        System.out.println("color:"+chessPicess.get(t).getColor()+"dx checkpawn:"+dx+"x1:"+x1+" x2:"+x2+"dy checkpawn:"+dy+"y1:"+y1+"y2:"+y2);

        if(chessPicess.get(t).getFirst().equals("no") && dx==0 && (Math.abs(dy)==1 || Math.abs(dy)==2)){
            if(chessPicess.get(t).getColor().equals("black") && (dy>0)){
                continues = "yes";
                //chessPicess.get(t).setFirst("yes");
            }
            if(chessPicess.get(t).getColor().equals("white") && (dy<0)){
                continues = "yes";
                //chessPicess.get(t).setFirst("yes");
            }
        }
        if(chessPicess.get(t).getFirst().equals("yes") && dx==0 && ( Math.abs(dy)==1)){
            if(chessPicess.get(t).getColor().equals("black") && (dy>0)){
                continues = "yes";
            }
            if(chessPicess.get(t).getColor().equals("white") && (dy<0)) {
                continues = "yes";
            }
        }

        return continues;
    }

    /**
     * this function gives the x and y of the destination point and move it
     * @param address gives the x and y of the destination point
     * @param colorChoice gives the color of piece
     * @return yes or no that we can move or not
     */

    public String  move(String address , String colorChoice) {
        Scanner input = new Scanner(System.in);
        String finish = "no";
        int go = 0;
        int x1 = Character.getNumericValue(address.charAt(0));
        int y1 = Character.getNumericValue(address.charAt(1));
        int x2 =Character.getNumericValue(address.charAt(3));
        int y2 = Character.getNumericValue(address.charAt(4));
        System.out.println("x1:"+x1+"y1:"+y1+"x2:"+x2+"y2:"+y2);
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
                    dx = Math.abs(x2 - x1);
                    dy = Math.abs(y2 - y1);
                    continues = "no";
                    System.out.println("dx:"+dx+"dy"+dy);
                    name = chessPicess.get(j).getName();
                    String colorss = chessPicess.get(j).getColor();
                   switch (name) {
                        case "Rook":
                            continues = checkRook(x1,x2,y1,y2);
                            break;
                        case "Pawn":
                            System.out.println("x:"+x1+"x2:"+x2+"y1:"+y1+"y2:"+y2);
                            continues = checkPawn(x1,x2,y1,y2);
                            if(continues.equals("yes")){
                                for(int i=0;i<chessPicess.size();i++){
                                    if(chessPicess.get(i).getX()==x2 && chessPicess.get(i).getY()==y2){
                                        chessPicess.get(i).setFirst("yes");
                                    }
                                }
                            }
                            System.out.println("continues"+continues);
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
                            s = checkKing(x1,x2,y1,y2,colorss);
                             if(checkKingChoiceKish(x1,x2,y1,y2)){
                                 System.out.println("kish , pay more attention on choosing your next move");
                             }
                            if(s.equals("no")){
                                System.out.println("wrong move try one more time");
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
                        System.out.println("yesyes");
                        if(chessPicess.get(j).getColor().equals("black")){
                            deletedBlackChess.add(chessPicess.get(j).getName());
                        }if(chessPicess.get(j).getColor().equals("white")){
                            getDeletedWhiteChess.add(chessPicess.get(j).getName());
                        }
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
                    chessPicess.get(i).setX(Character.getNumericValue(address.charAt(3)));
                    chessPicess.get(i).setY(Character.getNumericValue(address.charAt(4)));
                    System.out.println("x:"+chessPicess.get(i).getName()+chessPicess.get(i).getColor()+"x"+chessPicess.get(i).getX()+"y"+chessPicess.get(i).getY());
                    break;
                }
            }
        makingPicessChoices();
            return finish;
    }

    /**
     * define the places that the piece can move
     */
    public void makingPicessChoices(){
        int t;
        int x1=0;
        int y1=0;
        String result;
        String type = null;
        String colors = null;
        //for(Pices ui:chessPicess){
            for (int zx = 0; zx <chessPicess.size() ; zx++) {
               // x1 = ui.getX();
                x1 = chessPicess.get(zx).getX();
                //y1 = ui.getY();
                y1 = chessPicess.get(zx).getY();
                //type = ui.getName();
                type = chessPicess.get(zx).getName();
                //colors = ui.getColor();
            colors = chessPicess.get(zx).getColor();
                System.out.println(chessPicess.get(zx).getName()+"%%%%the sample%%%%%%%%%%%%%%%%%%%%%%%%%%"+"x1::"+x1+" y1::"+y1+type+colors);
            t=1;
            /*
            for(int y=0;y<chessPicess.size();y++){
                for (int u=0;u<chessPicess.get(y).getNumber();u++){
                    chessPicess.get(y).xChoice[u]=0;
                    chessPicess.get(y).yChoice[u]=0;
                }
            }

            for(int y=0;y<chessPicess.size();y++){
                if(chessPicess.get(y).getX()==x1 && chessPicess.get(y).getY()==y1){
                    type = chessPicess.get(y).getName();
                    colors = chessPicess.get(y).getColor();
                    System.out.println("type"+type);
                    break;
                }
            }*/
            switch (type){
                case "Pawn":
                    System.out.println(type+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    for (t = 1; t <= 8; t++) {

                    for(int u=1;u<=8;u++){
                        System.out.println("111xx::"+chessPicess.get(zx).getX()+"yy::"+chessPicess.get(zx).getY());
                        result = checkPawn(chessPicess.get(zx).getX(),u,chessPicess.get(zx).getY(),t);
                        System.out.println("result::::::::"+result+"x2:"+t+" y2:"+u+chessPicess.get(zx).getName()+"x111::"+chessPicess.get(zx).getX()+"y1:"+chessPicess.get(zx).getY());
                        if(result.equals("yes")){
                            for(int y=0;y<chessPicess.size();y++){
                                if(chessPicess.get(y).getX()==chessPicess.get(zx).getX() && chessPicess.get(y).getY()==chessPicess.get(zx).getY()){
                                    int num = chessPicess.get(y).getSizeOfChoices();
                                    chessPicess.get(y).setChoices(t-1,u-1,num);
                                    System.out.println("t"+t+"u"+u+"name"+"****************************************************");
                                    break;
                                }
                            }
                        }
                    }
                    }
                    System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
                    break;
                case "Rook":
                    t=1;

                    for(int u=1;u<=8;u++){
                        result = checkRook(x1,y1,t,u);
                        if(result.equals("yes")){
                            for(int y=0;y<chessPicess.size();y++){
                                if(chessPicess.get(y).getX()==x1 && chessPicess.get(y).getY()==y1){
                                    int num = chessPicess.get(y).getChoice().size();
                                    chessPicess.get(y).setChoices(t,u,num);
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
                                    int num = chessPicess.get(y).getChoice().size();
                                    chessPicess.get(y).setChoices(t,u,num);
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
                                    int num = chessPicess.get(y).getChoice().size();
                                    chessPicess.get(y).setChoices(t,u,num);
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
                                   // chessPicess.get(y).setX(t);
                                  //  chessPicess.get(y).setY(u);
                                    int num = chessPicess.get(y).getChoice().size();
                                    chessPicess.get(y).setChoices(t,u,num);
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
                                    int num = chessPicess.get(y).getChoice().size();
                                    chessPicess.get(y).setChoices(t,u,num);
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

    /**
     *  check that we can move the piece or not
     * @param x1 get the x of starting point
     * @param x2 get the x of destination point
     * @param y1 get the y of starting point
     * @param y2 get the y of destination point
     * @return
     */

    public Boolean checkKingChoiceKish(int x1,int x2,int y1,int y2){
        Boolean kish = Boolean.valueOf("false");
        int t=1;

        for(int y=0;y<chessPicess.size();y++){
            if(chessPicess.get(y).getX()==x1 && chessPicess.get(y).getY()==y1){
                t=y;
                break;
            }
        }

        for(int g=0;g<chessPicess.get(t).getChoice().size();g++) {
            for (int u = 0; u < chessPicess.size(); u++) {
                for(int i=0;i<chessPicess.get(u).getChoice().size();i++){
                    if(chessPicess.get(u).xChoice[i]==chessPicess.get(t).xChoice[g] && chessPicess.get(u).yChoice[i]==chessPicess.get(t).yChoice[g]){
                        kish = Boolean.valueOf("true");
                        break;
                    }
                }
            }
        }
       return kish;
    }

    /**
     * used to move the pieces
     */

    public void moving(){
        Scanner input = new Scanner(System.in);
        String finish = "no";
        String voroodi;
        String voroodii;
        String color;
        while(finish!="yes"){
            System.out.println("white turn");
        //    makingPicessChoices();
            voroodi = input.next();
            color = "white";
            finish = move(voroodi,color);
            System.out.println("black turn");
            voroodii = input.next();
            color = "black";
            finish = move(voroodii,color);
            display();
            for(int u=0;u<chessPicess.size();u++){
                if(chessPicess.get(u).getName().equals("king") && chessPicess.get(u).getNumber()==0){
                    finish="yes";
                }
            }
            //finish = "yes";
        }
    }




}
