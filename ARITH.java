import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    static Pattern p = Pattern.compile("(\\d+)(\\+|\\-|\\*)(\\d+)");
    static Matcher m = null;
    
    public static void main(String args[]) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 0;
        
        Stack<String> operaciones=new Stack<String>();
        
        try {
            t = Integer.parseInt(br.readLine());

            while (t > 0) {
                operaciones.push(br.readLine());
                t--;
            }
            
            for(String s:operaciones){
                procesar(s);
                System.out.println();
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void procesar(String operacion){
        BigDecimal operando1, operando2,resultado,resultadoTemp,numeroTemp;
        String operador,operando2Str="";
        int largoLinea=0,largoResultado=0;
        
        m = p.matcher(operacion);
        m.matches();
        
        operando1=new BigDecimal(m.group(1));
        operando2=new BigDecimal(m.group(3));
        operador=m.group(2);
        
        operando2Str=operador+operando2.toPlainString();
        
        if(!operador.equals("*")){
            if(operador.equals("-")){
                operando2=operando2.negate();
            }
            resultado=operando1.add(operando2);
            
            largoResultado=resultado.toPlainString().length();
            largoLinea=Math.max(operando2Str.length(), largoResultado);
            
            System.out.println(padLeft(operando1.toPlainString(),largoLinea));
            System.out.println(padLeft(operando2Str,largoLinea));
            System.out.println(linea(largoLinea));
            System.out.println(padLeft(resultado,largoLinea));
            
        }else{
            resultado=operando1.multiply(operando2);
            
            largoResultado=resultado.toPlainString().length();
            largoLinea=Math.max(operando1.toPlainString().length(),operando2Str.length());
            
            System.out.println(padLeft(operando1.toPlainString(),largoResultado));
            System.out.println(padLeft(operando2Str,largoResultado));
            
            int n=operando2Str.length();
            boolean hayLinea=false;
            if(n>2){
                int k=0;
                for(int i=n-1;i>=1;i--){
                    numeroTemp=new BigDecimal(operando2Str.charAt(i)+"");
                    resultadoTemp=operando1.multiply(numeroTemp);
                    if(!hayLinea){
                        hayLinea=true;
                        largoLinea=Math.max(operando2Str.length(),resultadoTemp.toPlainString().length());
                        System.out.println(padLeft(linea(largoLinea),largoResultado));
                    }
                    
                    System.out.println(padLeft(resultadoTemp,largoResultado-(k++)));
                }
            }
            
            System.out.println(linea(largoResultado));
            System.out.println(resultado);
        }
    }
    
    public static String linea(int n) {
        return String.format(String.format("%%0%dd", n), 0).replace("0", "-");
    }

    public static String padLeft(String s, int n) {
        return String.format("%1$#" + n + "s", s);
    }
    
    public static String padLeft(BigDecimal bd, int n) {
        return padLeft(bd.toPlainString(),n);
    }
}