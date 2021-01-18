
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class piskorky {
    static ArrayList<Integer> hracPositions = new ArrayList<Integer>();
     static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
   
public static void main(String[] arges) {
        char [][] hraciaDoska = {{' ', '|', ' ', '|', ' '},
                               {'-', '+', '-', '+', '-'},
                               {' ', '|', ' ', '|', ' '},
                               {'-', '+', '-', '+', '-'},
                               {' ', '|', ' ', '|', ' '}};
    printHraciaDoska(hraciaDoska);
   
  
    while(true){
          Scanner scan = new Scanner(System.in); 
        System.out.println("Zadaj pozicou (1-9):");
   int hracPos = scan.nextInt();
   while(hracPositions.contains(hracPos) || cpuPositions.contains(hracPositions)){
    System.out.println("Pozicia je zabrata! Daj volnu poziciu.");
    hracPos =    scan.nextInt();
    }
   placePiece(hraciaDoska, hracPos, "hrac");
   String resoult = otestujVytaza(); 
   if(resoult.length() > 0) {
        System.out.println(resoult);
    break;
   }
   Random rand= new Random();
   int cpuPos = rand.nextInt(9) + 1;
   while(hracPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)){
   cpuPos = rand.nextInt(9) + 1; 
   }
   placePiece(hraciaDoska, cpuPos, "pocitac");
   
   printHraciaDoska(hraciaDoska);
     resoult = otestujVytaza();
    if(resoult.length() > 0) {
        System.out.println(resoult);
    break;
    }
    System.out.println(resoult);
    }
  
    }
    public static void printHraciaDoska(char[] [] hraciaDoska){
        for(char[] row: hraciaDoska) {
        for(char c : row) {
            System.out.print(c);
        }
       System.out.println();
    }
    }
public static void placePiece(char[][] hraciaDoska, int pos, String user) {
    char symbol = ' ';
    if(user.equals("hrac")) {
        symbol = 'X';
        hracPositions.add(pos);
    } else if(user.equals("pocitac")) {
        symbol = 'O';
        cpuPositions.add(pos);
    }
    
    switch(pos) {
            case 1:
            hraciaDoska[0][0] = symbol;
            break;
            case 2:
            hraciaDoska[0][2] = symbol;
            break;
            case 3:
            hraciaDoska[0][4] = symbol;
            break;
            case 4:
            hraciaDoska[2][0] = symbol;
            break;
            case 5:
            hraciaDoska[2][2] = symbol;
            break;
            case 6:
            hraciaDoska[2][4] = symbol;
            break;
            case 7:
            hraciaDoska[4][0] = symbol;
            break;
            case 8:
            hraciaDoska[4][2] = symbol;
            break;
            case 9:
            hraciaDoska[4][4] = symbol;
            break;
           
            default:
                break;
    }
}
public static String otestujVytaza() {
List topRow = Arrays.asList(1, 2, 3);
List midRow = Arrays.asList(4, 5, 6);
List botRow = Arrays.asList(7, 8, 9);
List leftCol = Arrays.asList(1, 4, 7);
List midCol = Arrays.asList(2, 5, 8);
List rightCol = Arrays.asList(3, 6, 9);   
List cross1 = Arrays.asList(1, 5, 9);
List cross2 = Arrays.asList(7, 5, 3);

List<List>vytaznePodmienky = new ArrayList<List>();
vytaznePodmienky.add(topRow);
vytaznePodmienky.add(midRow);
vytaznePodmienky.add(botRow);
vytaznePodmienky.add(leftCol);
vytaznePodmienky.add(midCol);
vytaznePodmienky.add(rightCol);
vytaznePodmienky.add(cross1);
vytaznePodmienky.add(cross2);

for(List l : vytaznePodmienky) {
    if(hracPositions.containsAll(l)){
    return "Vyhravas";
} else if(cpuPositions.containsAll(l)) {
        return "Pocitac vyhrava";
        } else if (hracPositions.size() + cpuPositions.size() == 9) {
        return "Remiza";
        }
}
return "";

}
}