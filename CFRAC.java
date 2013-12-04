import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

class Main{
    
    String uno="1";
    int total=0;

    public static void main(String []args) throws IOException{
        new Main().run();
    }

    String crearLineaFraccion(int n){
        String l="-";
        while(--n>0){l+="-";}
        return l;
    }

    String pad(String s){
        return String.format("%"+total+"s",s).replace(" ",".");
    }

    void run() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //int den,num,tmp;
        BigInteger den,num,tmp;
        int i=0,ls,ancho_guiones;
        String linea,pedazos[];
        ArrayList<String> lineas;
        while(true){
            linea=br.readLine().trim();
            if(linea.equals("0 0")){break;}
            
            pedazos=linea.split(" ");
            //num=Integer.parseInt(pedazos[0]);
            //den=Integer.parseInt(pedazos[1]);
            num=new BigInteger(pedazos[0]);
            den=new BigInteger(pedazos[1]);
            lineas=new ArrayList<String>();
            tmp=BigInteger.ONE;
            
            System.out.println("Case "+(++i)+":\n"+num+" / "+den);
            while(tmp.compareTo(BigInteger.ZERO)>0){
                tmp=num.mod(den);
                lineas.add(num.divide(den).subtract(((tmp.compareTo(BigInteger.ZERO)>0)?BigInteger.ZERO:BigInteger.ONE))+"");
                num=den;
                den=tmp;
            }
            
            ls=lineas.size();
            ancho_guiones=0;
            for(int j=ls-1;j>=0;j--){
                String guiones=crearLineaFraccion(ancho_guiones);
                linea=lineas.get(j)+" + ";
                linea=linea+guiones;
                ancho_guiones=linea.length();
                lineas.set(j,linea);
            }
            
            total=lineas.get(0).length();
            for(String n:lineas){
                String padded=pad(n);
                ancho_guiones=total-padded.indexOf("-");
                String padr=String.format("%-"+(ancho_guiones/2+1)+"s",uno).replace(" ",".");
                System.out.println(pad(padr));
                System.out.println(padded);
            }
            System.out.println(pad(uno));
        }
    }
}