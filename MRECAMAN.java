import java.io.*;
import java.util.ArrayList;
class Main{
    public static void main(String []args) throws IOException{
        boolean presente[]=new boolean[3050000];
        ArrayList<Integer> numeros=new ArrayList<Integer>();
        numeros.add(0);
        presente[0]=true;
        int am=0;
        for(int i=1;i<=500000;i++){
            am-=i;
            if(am<0 || presente[am]){
                am+=2*i;
            }
            numeros.add(am);
            presente[am]=true;
        }

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int n=Integer.parseInt(br.readLine().trim());
            if(n==-1){break;}
            System.out.println(numeros.get(n));
        }
    }
}