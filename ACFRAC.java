import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main{
    
    String linea;
    String uno="1";
    int total=0;
    Pattern entero = Pattern.compile("\\.*(\\d+)\\.\\+\\.(\\-)+");
    Matcher matcher = null;

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
        linea="";
        int i=0;
        linea=br.readLine();
        while(true){
            if (linea==null || linea.equals("C")){
                break;
            }else if(linea.trim().equals("A")){
                System.out.println("Case "+(++i)+":");
                fraccionADibujo(br);
                linea=br.readLine();
            }else if (linea.trim().equals("B")){
                System.out.println("Case "+(++i)+":");
                dibujoAFraccion(br);
            }
        }
    }

    void fraccionADibujo(BufferedReader br) throws IOException{
        BigInteger den,num,tmp;
        int ls,ancho_guiones;
        String pedazos[];
        ArrayList<String> lineas;

        linea=br.readLine().trim();
        
        pedazos=linea.split(" ");
        
        num=new BigInteger(pedazos[0]);
        den=new BigInteger(pedazos[1]);
        lineas=new ArrayList<String>();
        tmp=BigInteger.ONE;
        BigInteger divmod[];
        while(tmp.compareTo(BigInteger.ZERO)>0){
            divmod=num.divideAndRemainder(den);
            tmp=divmod[1];
            //tmp=num.mod(den);
            lineas.add(divmod[0].subtract(((tmp.compareTo(BigInteger.ZERO)>0)?BigInteger.ZERO:BigInteger.ONE))+"");
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

    void dibujoAFraccion(BufferedReader br) throws IOException{
        BigInteger num,den,tmp;
        
        ArrayList<BigInteger> enteros=new ArrayList<BigInteger>();
        int i=0;
        while(true){
            linea=br.readLine().trim();            
            if(linea.equals("A") || linea.equals("B") || linea.equals("C")){
                break;
            }
            if(i%2!=0){
                matcher=entero.matcher(linea);
                matcher.matches();
                enteros.add(new BigInteger(matcher.group(1)));
            }
            i++;
        }

        den=enteros.get(enteros.size()-1).add(BigInteger.ONE);
        num=BigInteger.ONE;
        
        for(i=enteros.size()-2;i>=0;i--){
            tmp=den.multiply(enteros.get(i)).add(num);
            //tmp=den*enteros[i]+num;
            num=den;
            den=tmp;
        }
        //Lo imprimo al reves por la ultima inversion que se hizo
        //en el ciclo que no es necesaria;
        System.out.println(den+" "+num);
    }
}