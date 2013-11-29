import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

class Main{

    HashMap<String,Integer> ntzolkin=new HashMap<String,Integer>();
    HashMap<String,Integer> nhaab=new HashMap<String,Integer>();
    String[] tzolkin={"Imix","Ik","Akbal","Kan","Chikchan","Kimi","Manik","Lamat","Muluk","Ok","Chuen","Eb","Ben","Ix","Men","Kib","Kaban","Etznab","Kawak","Ajaw"};
    String[] haab={"Pohp","Wo","Sip","Zotz","Sek","Xul","Yaxkin","Mol","Chen","Yax","Sak","Keh","Mak","Kankin","Muan","Pax","Kayab","Kumku","Wayeb"};
    final int ciclo=18980; //dias

    String fechaInicial="9 Ajaw 3 Sip";

    public static void main(String []args) throws IOException{
        Main m=new Main();
        m.run();
    }

    public void init(){
        ntzolkin.put("Imix",0);ntzolkin.put("Ik",1);ntzolkin.put("Akbal",2);ntzolkin.put("Kan",3);ntzolkin.put("Chikchan",4);ntzolkin.put("Kimi",5);ntzolkin.put("Manik",6);ntzolkin.put("Lamat",7);ntzolkin.put("Muluk",8);
        ntzolkin.put("Ok",9);ntzolkin.put("Chuen",10);ntzolkin.put("Eb",11);ntzolkin.put("Ben",12);ntzolkin.put("Ix",13);ntzolkin.put("Men",14);ntzolkin.put("Kib",15);ntzolkin.put("Kaban",16);ntzolkin.put("Etznab",17);ntzolkin.put("Kawak",18);ntzolkin.put("Ajaw",19);

        nhaab.put("Pohp",0);nhaab.put("Wo",1);nhaab.put("Sip",2);nhaab.put("Zotz",3);nhaab.put("Sek",4);nhaab.put("Xul",5);nhaab.put("Yaxkin",6);nhaab.put("Mol",7);nhaab.put("Chen",8);
        nhaab.put("Yax",9);nhaab.put("Sak",10);nhaab.put("Keh",11);nhaab.put("Mak",12);nhaab.put("Kankin",13);nhaab.put("Muan",14);nhaab.put("Pax",15);nhaab.put("Kayab",16);nhaab.put("Kumku",17);nhaab.put("Wayeb",18);
    }

    public void run() throws IOException{
        init();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int d=Integer.parseInt(br.readLine().trim());
        String fecha;
        while(d-->0){
            fecha=br.readLine().trim();
            if(isValid(fecha)){
                ArrayList<String> fechas=new ArrayList<String>();
                
                int diasIniciales=buscarDias(fecha); //buscamos la cantidad de dias desde 8.0.0.0.0
                
                int baktun=8+diasIniciales/144000;
                int diasResto=diasIniciales%144000;
                int katun=diasResto/7200;
                diasResto%=7200;
                int tun = diasResto/360;
                diasResto%=360;
                int winal = diasResto/20;
                diasResto%=20;
                int dias=diasResto;

                while(baktun<10 && katun<20 && tun<20 && winal<18 && dias<20){

                    //sumamos los valores iniciales y empezamos a contar desde ahi hasta 9.19.19.17.19
                    fechas.add(baktun+"."+katun+"."+tun+"."+winal+"."+dias);
                    //18980 dias (ciclo maya) es 0.2.12.13.0
                    winal+=13;
                    boolean llevo=false;
                    if(winal>=18){
                        winal%=18;
                        llevo=true;
                    }
                    tun+=12+((llevo)?1:0);
                    if(tun>=20){
                        tun%=20;
                        llevo=true;
                    }else{llevo=false;}
                    katun+=2+((llevo)?1:0);
                    if(katun>=20){
                        katun%=20;
                        llevo=true;
                    }else{llevo=false;}
                    baktun+=((llevo)?1:0);
                }

                System.out.println(fechas.size());
                for(String f:fechas){
                    System.out.println(f);
                }


            }else{
                System.out.println(0);
            }
        }
    }

    public int buscarDias(String fechaDestino){
        if(fechaDestino.equals(fechaInicial)){
            return 0;
        }
        String[] pedazos=fechaInicial.split(" ");
        int ntz=Integer.parseInt(pedazos[0]);
        String tz=pedazos[1];
        int nhb=Integer.parseInt(pedazos[2]);
        String hb=pedazos[3];
        
        String nfecha=fechaInicial;
        int dias=0;
        while(!nfecha.equals(fechaDestino)){
            ntz+=1;
            if(ntz>13){ntz=1;}
            int tmp=ntzolkin.get(tz);
            tz=tzolkin[(tmp+1)%20];

            nhb+=1;
            if((nhb>20 && !hb.equals("Wayeb")) || (nhb>5 && hb.equals("Wayeb"))){
                nhb=1;
                tmp=nhaab.get(hb);
                hb=haab[(tmp+1)%19];
            }
            nfecha=ntz+" "+tz+" "+nhb+" "+hb;
            dias++;
        }
        return dias;
    }

    public boolean isValid(String fecha){
        String[] pedazos=fecha.split(" ");
        String tz=pedazos[1];
        int hb=Integer.parseInt(pedazos[2]);
        if(tz.equals("Imix") || tz.equals("Kimi") || tz.equals("Chuen") || tz.equals("Kib")){
            return (hb==4 || hb==9 || hb==14 || hb==19);
        }
        if(tz.equals("Ik") || tz.equals("Manik") || tz.equals("Eb") || tz.equals("Kaban")){
            return (hb==5 || hb==10 || hb==15 || hb==20);
        }
        if(tz.equals("Akbal") || tz.equals("Lamat") || tz.equals("Ben") || tz.equals("Etznab")){
            return (hb==1 || hb==6 || hb==11 || hb==16);
        }
        if(tz.equals("Kan") || tz.equals("Muluk") || tz.equals("Ix") || tz.equals("Kawak")){
            return (hb==2 || hb==7 || hb==12 || hb==17);
        }
        if(tz.equals("Chikchan") || tz.equals("Ok") || tz.equals("Men") || tz.equals("Ajaw")){
            return (hb==3 || hb==8 || hb==13 || hb==18);
        }
        return false;
    }

}