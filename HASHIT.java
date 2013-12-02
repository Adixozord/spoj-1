import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class Main{

    String hash[];
    int hash_length=0;
    
    int h(String key){
        int i,h=0;
        int n=key.length();
        for(i=0;i<n;i++){
            h+=(((int)key.charAt(i))*(i+1));
        }

        return 19*h;
    }

    int Hash(String key){
        return h(key)%101;
    }

    int find(String key){
        int index=-1;
        for(int i=0;i<101;i++){
            if(hash[i]!=null && hash[i].equals(key)){
                index=i;break;
            }
        }
        return index;
    }

    void insert(String key){
        int index=find(key);
        int j,key_hash=Hash(key);
        if(index==-1){
            for(j=0;j<20;j++){
                index=(key_hash+j*(j+23)) % 101;
                if(hash[index]==null){
                    hash[index]=key;
                    hash_length++;
                    break;
                }
            }
        }
    }

    void delete(String key){
        int index=find(key);
        if(index!=-1){
            hash[index]=null;
            hash_length--;
        }
    }

    public static void main(String []args) throws IOException{
        new Main().run();
    }

    public void run() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine().trim());
        int n;
        String linea,key,op,pedazos[];
        while(t-->0){
            hash=new String[101];
            hash_length=0;
            n=Integer.parseInt(br.readLine().trim());
            while(n-->0){
                linea=br.readLine().trim();
                pedazos=linea.split(":");
                if(pedazos[0].equals("ADD")){
                    insert(pedazos[1]);
                }else{
                    delete(pedazos[1]);
                }
            }
            System.out.println(hash_length);
            for(int i=0;i<101;i++){
                if(hash[i]!=null){
                    System.out.println(i+":"+hash[i]);
                }
            }
        }
    }
}