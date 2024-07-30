import java.util.*;

public class TowerHonai {
  public static void  towerH(int n, String src, String help, String dest){
    if(n==1){
      System.out.println("Move tower "+n+" from "+src+" to "+dest);
      return;
    }
    towerH(n-1, src, dest, help);
    System.out.println("Move tower "+n+" from "+src+" to "+dest);
    towerH(n-1, help, src, dest);
  }
  public static void main(String[] args) {
  int n = 3;
    towerH(n,"S", "H", "D");
  }

}