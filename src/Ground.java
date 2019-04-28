import java.util.ArrayList;
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
                chessPicess.add(new Pawn(y.get(r),2,"white"));
                r++;
            }
            r=0;
            for(int i=24;i<=31;i++){
                chessPicess.add(new Pawn(y.get(r),7,"black"));
                r++;
            }
        System.out.println("size::::"+chessPicess.size());
        System.out.println(chessPicess.get(0).getName()+"  "+chessPicess.get(31).getName()+"x:"+chessPicess.get(31).getX()+"y:"+chessPicess.get(31).getY()+"color"+chessPicess.get(31).getColor());
           // chessPicess.add(new King(y.get(0),7,"black"));
            //chessPicess.add(new King(y.get(0),2,"black"));
    }

    public void display(){
        int y=0;
        for(int j=8;j>=1;j--){
            for(int i=1;i<=8;i++){
                for(int g=(chessPicess.size()-1);g>=0;g--){
                    y=0;
                    if(chessPicess.get(g).getX()==i && chessPicess.get(g).getY()==j){
                        System.out.print("|"+chessPicess.get(g).getName());
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

    public void move(String address){
        Scanner input = new Scanner(System.in);
        int x1;
        Pices p = new Queen('a',2,"white");
        x1 = p.setX(address.charAt(0));
        int y1 = Character.getNumericValue(address.charAt(1));
        int x2 = p.setX(address.charAt(3));
        int y2 = Character.getNumericValue(address.charAt(4));
        String name ;
        String continues = "no";
        for(int j=0;j<chessPicess.size();j++){
            if(chessPicess.get(j).getX()==x1 && chessPicess.get(j).getY()==y1){
                int dx;
                int dy;
                System.out.println("*********************************");
                dx = Math.abs(x2-x1);
                dy = Math.abs(y2-y1);
                continues= "no";
                name = chessPicess.get(j).getName();
                String colorss = chessPicess.get(j).getColor();
            System.out.println("name"+name+chessPicess.get(j).getY());
                switch (name){
                    case "Rook":
                        int cont;
                        cont=0;
                        if(dx!=dy && (dx==0 || dy==0)){
                            dy = y2-y1;
                            if((dx==0)){
                                for(int e=0;e<chessPicess.size();e++){
                                    for(int i=(Math.min(y1,y2))+1;i<Math.max(y1,y2);i++){
                                        if(chessPicess.get(e).getX()==x1 && chessPicess.get(e).getY()==i){
                                            cont++;
                                        }
                                    }
                                }
                                if(cont==0){
                                    continues = "yes";
                                }
                            }
                            cont =0;
                            if((dy==0)) {
                                for (int r = (Math.min(x1, x2) + 1); r < Math.max(x1, x2); r++) {
                                    if(chessPicess.get(r).getX()==r && chessPicess.get(r).getY()==y1){
                                        cont++;
                                    }
                                }
                                if(cont==0){
                                    continues="yes";
                                }
                            }
                        }
                        break;

                    case"Bishop":
                        System.out.println("BIshop");
                        int t=0;
                        int conts =0;
                        if(dx==dy){
                            conts =0;
                                for(int r=0;r<chessPicess.size();r++){
                                    t = Math.min(y1,y2)+1;
                                    for(int i=(Math.min(x1,x2)+1);i<Math.max(x1,x2);i++){
                                        System.out.println("ooooooo");
                                        if(chessPicess.get(r).getX()==i && chessPicess.get(r).getY()==t){
                                            System.out.println("i"+i+"y"+t+"name"+chessPicess.get(r).getName());

                                            if(chessPicess.get(r).getY()==y2 && chessPicess.get(r).getX()==x2){
                                                    if(chessPicess.get(r).getColor().equals(colorss)){
                                                        System.out.println("color"+chessPicess.get(r).getColor());
                                                    }else{
                                                        System.out.println("000000000000");
                                                        conts++;
                                                    }
                                            }
                                        }
                                        t++;
                                    }
                                    if(chessPicess.get(r).getY()==y2 && chessPicess.get(r).getX()==x2){
                                        if(chessPicess.get(r).getColor().equals(colorss)){
                                            System.out.println("color"+chessPicess.get(r).getColor());
                                        }else{
                                            System.out.println("000000000000");
                                            conts++;
                                        }
                                    }

                                }
                                if(conts==0){
                                    continues = "yes";
                                }
                                conts=0;
                        }
                        break;
                    case "Queen":
                        conts=0;
                        if((dy==dx)|| (dy==0) || (dx==0)){
                            if(dy==0){
                                conts=0;
                                for(int w=Math.min(x1,x2)+1;w<Math.max(x1,x2);w++){
                                    for (int r=0;r<chessPicess.size();r++){
                                        if(chessPicess.get(r).getX()== w && chessPicess.get(w).getY()==y1){
                                            conts++;
                                        }
                                    }
                                }
                                for(int i=0;i<chessPicess.size();i++){
                                    if(chessPicess.get(i).getX()==x2 && chessPicess.get(i).getY()==y2 ){
                                        if(chessPicess.get(i).getColor().equals(colorss)) {
                                        }else{
                                            conts++;
                                        }
                                    }
                                }
                                if(conts==0){
                                    continues = "yes";
                                }
                            }
                            if(dx==0){
                                conts=0;
                                for(int w=Math.min(y1,y2)+1;w<Math.max(y1,y2);w++){
                                    for (int r=0;r<chessPicess.size();r++){
                                        if(chessPicess.get(r).getX()== x1 && chessPicess.get(w).getY()==w){
                                            conts++;
                                        }
                                    }
                                }
                                for(int i=0;i<chessPicess.size();i++){
                                    if(chessPicess.get(i).getX()==x2 && chessPicess.get(i).getY()==y2 ){
                                        if(chessPicess.get(i).getColor().equals(colorss)) {
                                        }else{
                                            conts++;
                                        }
                                    }
                                }
                                if(conts==0){
                                    continues = "yes";
                                }
                            }
                            if(dx==dy){
                                conts=0;
                                t = Math.min(x1,x2)+1;
                                for(int g=Math.min(y1,y2)+1;g<Math.max(y1,y2);g++){
                                    for(int r=0;r<chessPicess.size();r++){
                                        if(chessPicess.get(r).getX()==t && chessPicess.get(r).getY()==g){
                                            conts++;
                                        }
                                    }
                                }
                                for(int i=0;i<chessPicess.size();i++){
                                    if(chessPicess.get(i).getX()==x2 && chessPicess.get(i).getY()==y2 ){
                                        if(chessPicess.get(i).getColor().equals(colorss)) {
                                        }else{
                                            conts++;
                                        }
                                    }
                                }
                                if(conts==0){
                                    continues = "yes";
                                }
                            }
                        }

                        break;
                    case "Knight":
                        if(dx!=dy && ((dx==1 && dy==2) || (dx==2 && dy==1))){
                            continues = "yes";
                        }

                        break;
                    case "Pawn":
                        System.out.println("pawn*****************");
                        dy = y2-y1;
                        System.out.println("dy"+dy);
                        System.out.println("con"+continues);
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
                        break;
                    case "King":
                       if((dx==1 && dy==0) ||(dx==0 && dy==1) || (dy==dx && dy==1)){
                           continues = "yes";
                       }
                        break;
                }
                break;
            }
        }
        System.out.println("cont"+continues);
            for(int j=0;j<chessPicess.size();j++){
                if(chessPicess.get(j).getX() == x2 && chessPicess.get(j).getY()== y2){
                    if(continues.equals("yes")){
                        chessPicess.remove(j);
                    }
            }
            if(continues.equals("no")){
                System.out.println("wrong move");
                System.out.println("try one more time");
                String newVoroodi = input.next();
                move(newVoroodi);
                break;
            }
            break;
            }

        for(int i=0;i<chessPicess.size();i++){
            if(chessPicess.get(i).getX()==x1 && chessPicess.get(i).getY()== y1 && continues.equals("yes") ){
                chessPicess.get(i).setX(address.charAt(3));
               chessPicess.get(i).setY(Character.getNumericValue(address.charAt(4)));
            }
        }
    }

    public void moving(){
        Scanner input = new Scanner(System.in);
        String finish = "no";
        String voroodi;
        String voroodii;
        while(finish!="yes"){
            System.out.println("white turn");
            voroodi = input.next();
            move(voroodi);
            System.out.println("black turn");
            voroodii = input.next();
            move(voroodii);
            display();
            //finish = "yes";
        }
    }




}
