import java.util.*;

public class game {

    public static void main(String args[]) {
        Scanner sc= new Scanner(System.in);
        System.out.println("HOLLA\nWelcome to the game of coins!\nEnter the no. of coins (EVEN ONLY)");
        int n=sc.nextInt();
        if(n%2!=0){
            System.out.println("Fuck you!\nTAA TAA!\n*handwave*");
            System.exit(0);
        }
        int a[]= new int[n];
        System.out.println("Line up the coins!");
        for(int i=0; i<n; i++) {
            a[i]= sc.nextInt();
        }
        int l=0;
        int r=a.length-1;
        int sump=0;
        int sumc=0;

        System.out.println("Would you like to go first?");
        sc.nextLine();
        String s= sc.nextLine();
        if(s.equalsIgnoreCase("Y") || s.equalsIgnoreCase("YES")) {
            System.out.println("OHK!, you go first\nChoose the left or right coin. (l/r)\nThe elements are:");
            listAr(a,l,r);
            for(int i=0; i<n/2; i++) {
                System.out.println("Enter your choice");
                String ch= sc.nextLine();
                if(ch.equalsIgnoreCase("l")) {
                    System.out.println("You chose left coin");
                    sump=sump+a[l];
                    l++;
                }
                else if(ch.equalsIgnoreCase("r")) {
                    System.out.println("You chose right coin");
                    sump=sump+a[r];
                    r--;
                }
                else{
                    System.out.println("WRONG INPUT BRO!\nTry again");
                    i--;
                    continue;
                }
                if(l==r){
                    System.out.println("Comp chose the left out coin");
                    sumc=sumc+a[l];
                }
                else{
                    int cc=coin(a,l,r,0);
                    if(cc==r){
                        System.out.println("Comp chose right coin");
                        sumc=sumc+a[r];
                        r--;
                    }
                    else {
                    System.out.println("Comp chose left coin");
                    sumc=sumc+a[l];
                    l++;
                    }
                }
                
                System.out.println("Your balance is: "+sump+"\nComp's balance is: "+sumc);
                if(l-r!=0){
                    System.out.println("Left out coins are:");
                    listAr(a,l,r);
                }
            }
        }
        else if(s.equalsIgnoreCase("N") || s.equalsIgnoreCase("NO")) {
            System.out.println("OHK!, you go second\nChoose the left or right coin. (l/r)\nThe elements are:");
            listAr(a,l,r);
            for(int i=0; i<n/2; i++){
                if(l+1==r){
                    if(a[l]>a[r]){
                        System.out.println("Comp chose left coin");
                        sumc=sumc+a[l];
                        l++;
                    }
                    else{
                        System.out.println("Comp chose right coin");
                        sumc=sumc+a[r];
                        r--;
                    }
                }
                else{
                    int cc=coin(a,l,r,0);
                    if(cc==r){
                        System.out.println("Comp chose right coin");
                        sumc=sumc+a[r];
                        r--;
                    }
                    else {
                        System.out.println("Comp chose left coin");
                        sumc=sumc+a[l];
                        l++;
                    }
                }
                System.out.println("Left out coins are:");
                listAr(a,l,r);

                if(l==r){
                    System.out.println("You are given the left out coin");
                    sump=sump+a[l];
                }
                else{
                    System.out.println("Enter your choice");
                    String ch= sc.nextLine();
                    if(ch.equalsIgnoreCase("l")) {
                        System.out.println("You chose left coin");
                        sump=sump+a[l];
                        l++;
                    }
                    else if(ch.equalsIgnoreCase("r")) {
                        System.out.println("You chose right coin");
                        sump=sump+a[r];
                        r--;
                    }
                    else{
                        System.out.println("WRONG INPUT BRO!\nTry again");
                        i--;
                        continue;
                    }
            
                }
                System.out.println("Your balance is: "+sump+"\nComp's balance is: "+sumc);
                if(l-r!=0){
                    System.out.println("Left out coins are:");
                    listAr(a,l,r);
                }
            }
        }
        else{
            System.out.println("Dumbass!");
        }
        if(sump>sumc){
            System.out.println("DAMNIT! You won!");
        }
        else{
            System.out.println("YOU LOST to a BOT!! YOU FUCKING DOONKEY XD!");
        }
        sc.close();
    }

    static int coin(int a[], int l, int r, int c) {

        if(l+1==r || l==r) {
            return (int)Math.max(a[r],a[l]);
        }

        if(c!=0) {
            return Math.max(a[l]+Math.min(coin(a,l+1,r,c),coin(a,l+1,r-1,c)),a[r]+Math.min(coin(a,l,r-2,c),coin(a,l+1,r-1,c)));
        }
        else if(a[l]+Math.min(coin(a,l+1,r,++c),coin(a,l+1,r-1,++c))>a[r]+Math.min(coin(a,l,r-2,++c),coin(a,l+1,r-1,++c))) {
            return l;
        }
        else{
            return r;
        }
    }

    public static void listAr(int a[], int l, int r) {
        for(int i=l; i<=r; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
