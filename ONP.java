import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.Stack;

class Main {

    public static void main(String args[]) {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=0;
        String[] exprs=null;
        try {
            t=Integer.parseInt(br.readLine());
            exprs=new String[t];
            for(int i=0;i<t;i++){
                exprs[i]=br.readLine();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main onp=new Main();
        System.out.println();
        for(int i=0;i<t;i++){
            System.out.println(onp.process(exprs[i]));
        }
    }

    public String process(String infix) {
        String postfixString = "";
        Stack<String> stack = new Stack<String>();
        int n = infix.length();
        String c = "";
        String topStack = "";
        int pre_c,pre_top;
        for (int i = 0; i < n; i++) {
            c = infix.charAt(i) + "";
            if(c.equals("(")){
                stack.push(c);
            }else if(c.equals(")")){
                topStack="";
                while(!stack.isEmpty() && !topStack.equals("(")){
                    topStack=stack.pop();
                    if(!topStack.equals("(")){
                        postfixString+=topStack;
                    }
                }
            }else if(c.matches("[a-z]")){
                postfixString+=c;
            }else{
                if(stack.isEmpty()){
                    stack.push(c);
                }else{
                    pre_c=precedence(c);
                    pre_top=precedence(stack.lastElement());
                    if(pre_top<pre_c){
                        stack.push(c);
                    }else{
                        while(pre_top>=pre_c){
                            postfixString+=stack.pop();
                            try{
                                pre_top=precedence(stack.lastElement());
                            }catch(EmptyStackException e){
                                pre_top=-1;
                            }catch(NoSuchElementException s){
                                pre_top=-1;
                            }
                        }
                    }
                }
            }
            

        }
        while (!stack.isEmpty()) {
            postfixString += stack.pop();
        }

        return postfixString;
    }

    public int precedence(String op) {
        int p = 0;
        if (op.equals("(") || op.equals(")")) {
            p--;
        }
        if (op.equals("*") || op.equals("/")) {
            p++;
        }
        if (op.equals("^")) {
            p += 2;
        }
        return p;
    }
}