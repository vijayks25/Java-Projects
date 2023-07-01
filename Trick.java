import java.util.*;
public class Trick
{
    Deck trick_Deck=new Deck();
    Card [] c1,c2,c3;

    public Trick()
    {
        trick_Deck.shuffle_Deck();
        c1=new Card[7];
        c2=new Card[7];
        c3=new Card[7];

        for(int i=0;i<7;i=i+1)
        {
            c1[i]=trick_Deck.deck[i];
            c2[i]=trick_Deck.deck[i+7];
            c3[i]=trick_Deck.deck[i+14];
        }
    }

    public void print_Trick()
    {
        System.out.println("COL1"+"\t"+"COL2"+"\t"+"COL3");
        for(int i=0;i<7;i=i+1)
        {
            c1[i].print_Card();
            System.out.print("\t");
            c2[i].print_Card();
            System.out.print("\t");
            c3[i].print_Card(); 
            System.out.println();
        }
    }

    void trick_Working()
    {
        print_Trick();
        int col;
        Card [] finaldeck =new Card [21];
        Scanner sc=new Scanner(System.in);
        System.out.print("Please choose a column:");
        col=sc.nextInt();
        switch(col)
        {
            case 1:
            for (int i=0; i<7; i=i+1)
            {
                finaldeck[i] = c2[i];
                finaldeck[7+i] = c1[i];
                finaldeck[14+i] = c3[i];
            }
            break;

            case 2:
            for (int i=0; i<7; i=i+1)
            {
                finaldeck[i] = c1[i];
                finaldeck[7+i] = c2[i];
                finaldeck[14+i] = c3[i];
            }
            break;

            case 3:
            for (int i=0; i<7; i=i+1)
            {
                finaldeck[i] = c1[i];
                finaldeck[7+i] = c3[i];
                finaldeck[14+i] = c2[i];
            }
            break;

            default: 
            System.out.print("Wrong Input");
        }
        int k=0;
        for(int i=0; i<7; i=i+1)
        {
            c1[i] = finaldeck[k];
            c2[i] = finaldeck[k+1];
            c3[i] = finaldeck[k+2];
            k=k+3;
        }
        return;
    }

    public static void main (String [] args)
    {
        Scanner sc = new Scanner(System.in);
        Trick t = new Trick ();
        int x=-1;
        int option;
        while(x!=0)
        {
            System.out.println();
            System.out.println("Press 1 for the trick");
            System.out.println("Press 0 to quit");
            option=sc.nextInt();
            switch(option)
            {
                case 1:
                for (int i=0 ;i<3 ;i=i+1)
                {
                    System.out.print("\f");
                    t.trick_Working();
                } 
                System.out.print("Your Card is: ");
                t.c2[3].print_Card();
                System.out.println();
                break;

                case 0:
                x=0;
                break;

                default:
                System.out.println("Wrong input");
            }
        }
    }
}