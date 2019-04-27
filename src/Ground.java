import java.util.ArrayList;

public class Ground {
    private String x;
    private int y;
    Pices[] chessPicess = new Pices[33];
    public void makingChessPicess(){
            chessPicess[0] = new Rook('a',1,"white",1);
            chessPicess[1] = new Knight('b',1,"white",1);
            chessPicess[2] = new Bishop('c',1,"white",1);
            chessPicess[3] = new Queen('d',1,"white");
            chessPicess[4] = new King('e',1,"white");
            chessPicess[5] = new Bishop('f',1,"white",2);
            chessPicess[6] = new Knight('g',1,"white",2);
            chessPicess[7] = new Rook('h',1,"white",2);
            chessPicess[8] = new Rook('a',8,"black",1);
            chessPicess[9] = new Knight('b',8,"black",1);
            chessPicess[10] = new Bishop('c',8,"black",1);
            chessPicess[11] = new Queen('d',8,"black");
            chessPicess[12] = new King('e',8,"black");
            chessPicess[13] = new Bishop('f',8,"black",2);
            chessPicess[14] = new Knight('g',8,"black",2);
            chessPicess[15] = new Rook('h',8,"black",2);
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
                chessPicess[i] = new Pawn(y.get(r),2,"white");
                r++;
            }
            r=0;
            for(int i=24;i<=31;i++){
                chessPicess[i] = new Pawn(y.get(r),7,"black");
                r++;
            }
    }

    public void display(){
        for(int t=0;t<=31;t++){
            System.out.println("name"+chessPicess[t].getName()+chessPicess[t].getX()+","+chessPicess[t].getY()+"t"+t);
        }
        int y=0;
        for(int j=1;j<=8;j++){
            for(int i=1;i<=8;i++){
                for(int g=0;g<=31;g++){
                    y=0;
                    if(chessPicess[g].getX()==i && chessPicess[g].getY()==j){
                        System.out.print("|"+chessPicess[g].getName());
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




}
