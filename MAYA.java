import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main{
   
   public static void main(String args[]) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int lineas,n=-1;
        double coef;
        String linea;
        while(true){
            n=Integer.parseInt(br.readLine());
            if(n==0){break;}
            int valor=0;

            for(int i=n-1;i>=0;i--){
                linea=br.readLine();
                coef=Math.pow(20,i);
                if(i>1){coef-=2*Math.pow(20,i-1);}
                valor+=calcular(linea)*coef;
            }
            System.out.println(valor);
            br.readLine(); //linea en blanco
        }
    }

    public static int calcular(String linea){
        if(linea.equals("S")){
            return 0;
        }
        int valor=0;
        char[] nlinea=linea.trim().toCharArray();
        for(char c:nlinea){
            if(c=='.'){valor++;}
            if(c=='-'){valor+=5;}
        }
        return valor;
    }

}
