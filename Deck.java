public class Deck
{
    Card [] deck;

    public Deck()
    {
        deck=new Card[52];

        for(int i=0; i<4 ;i=i+1)
        {
            String s= "";

            if (i==0)
            {
                s = "\u2663";               
            }

            if(i==1)
            {
                s= "\u2665";
            }

            if(i==2)
            {
                s= "\u2660";
            }

            if(i==3)
            {
                s= "\u2666";
            }

            for(int j=0;j<13;j=j+1)
            {
                deck[(13*i)+j]= new Card(j+1,s);
            }
        }
    }

    public void print_Deck()
    {
        for(int i=0;i<13;i=i+1)
        {
            deck[i].print_Card();
            System.out.print("\t");
            deck[i+13].print_Card();
            System.out.print("\t");
            deck[i+26].print_Card();
            System.out.print("\t");
            deck[i+39].print_Card();
            System.out.println();
        }
    }

    public void shuffle_Deck()
    {
        Card temp;
        int to;
        for(int i=0;i<52;i=i+1)
        {
            to=(int)(Math.random()*52);
            temp=deck[i];
            deck[i]=deck[to];
            deck[to]=temp;
        }
    } 

    public void sort_Card_Rank()
    {
        Card c;
        for(int i=0;i<52;i=i+1)
        {
            for(int j=0;j<50;j=j+1)
            {
                if(deck[j].rank>deck[j+1].rank)
                {
                    c=deck[j];
                    deck[j]=deck[j+1];
                    deck[j+1]=c;
                }
            }
        }
        print_Deck();
    }
}  