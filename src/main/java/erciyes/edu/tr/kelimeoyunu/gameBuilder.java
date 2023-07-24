package erciyes.edu.tr.kelimeoyunu;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class gameBuilder {
    public static int sayac;
    public static String a;
    public static boolean sablonUygunmu=false;


    public static ArrayList<String> getAnlikSablon() {
        return anlikSablon;
    }

    public static ArrayList<String> anlikSablon = new ArrayList<>();
    public static ArrayList<String> anlikKelimeList = new ArrayList<>();
    static File file = new File("VPSOZLUK.txt");
    static File newFile = new File("anlikkelimelist.txt");
    static File pangramFile = new File("pangram.txt");



    public gameBuilder() throws FileNotFoundException {
    }

    public static boolean isPangram(String string) {
        ArrayList<String> temp = new ArrayList<>();
        boolean cevap = false;
        int farklilikSayaci = 0;
        for (int i = 0; i < string.length(); i++) {
            if (!temp.contains(String.valueOf(string.charAt(i)))) {
                farklilikSayaci++;
                temp.add(String.valueOf(string.charAt(i)));
            }
        }
        if (farklilikSayaci == 7) {
            cevap = true;
        }
        return cevap;
    }

    public static String sablonExt(String string) {
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            if (!temp.contains(String.valueOf(string.charAt(i)))) {
                temp.add(String.valueOf(string.charAt(i)));
            }

        }
        return temp.toString();
    }
    public static void anlikSablonOlustur(String string){
        for(int i=1;i<20;i+=3){
            anlikSablon.add(String.valueOf(sablonExt(string).charAt(i)));
        }
    }

    public static boolean uygunMu(String string) {
        boolean cevap=true;
        if (string.length() >= 4) {
            for (int i = 0; i <string.length(); i++) {
                if(!anlikSablon.contains(String.valueOf(string.charAt(i)))){
                    cevap = false;
                }
            }
        }
        else {
            cevap=false;
        }
        return cevap;
    }

    public static void setAnlikSablon(String string) {
        anlikSablon.add(string);
    }

    public static void anlikSablonRandom() throws IOException {
        anlikSablon.clear();
        Scanner scanner = new Scanner(file);
        FileWriter pangramWriter = new FileWriter(pangramFile,false);
        int random;
        String line="";
        int pangramsayac=0;
        while(scanner.hasNext()){
            String[] tokens = scanner.nextLine().split(" ");
            String last = tokens[tokens.length - 1];
            if(isPangram(last)){
                pangramWriter.write(last+"\n");
                pangramsayac++;
            }
        }
        random = ThreadLocalRandom.current().nextInt(pangramsayac);
        try (Stream<String> lines = Files.lines(Paths.get("pangram.txt"))) {
            line = lines.skip(random).findFirst().orElse("abcdefg");
        }
        a = line;
        anlikSablonOlustur(a);
        anlikKelimeListOlustur();
        pangramWriter.close();
        scanner.close();
    }

    public static boolean isSablonUygunmu() {
        return sablonUygunmu;
    }

    public static void anlikKelimeListOlustur() throws IOException {
        Scanner scanner2 = new Scanner(file);
        FileWriter fileWriter=new FileWriter(newFile,false);
        int kelimeSayac=0;
        sablonUygunmu=false;
        while(scanner2.hasNext()){
            String[] tokens = scanner2.nextLine().split(" ");
            String last = tokens[tokens.length - 1];
            if(uygunMu(last)){
                fileWriter.write(last+"\n");
                kelimeSayac++;
            }
        }
        if(kelimeSayac>=20){
            sablonUygunmu=true;
        }
        System.out.println(kelimeSayac);
        scanner2.close();
        fileWriter.close();
    }
    public static boolean kelimeVarmi(String string) throws FileNotFoundException {
        Scanner scanner3 = new Scanner(newFile);
        Boolean cevap=false;
        while(scanner3.hasNext()){
            String[] tokens = scanner3.nextLine().split(" ");
            String last = tokens[tokens.length - 1];
            if(last.equals(string)){
                cevap = true;
            }
        }
        return cevap;
    }
    public static void clearAnlikSablon(){
        anlikSablon.clear();
    }

}


