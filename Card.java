public class Card
{
    int rank;
    String suite;

    Card(int r, String s)  
    {
        rank=r;
        suite=s;       
    }

    public void print_Card()
    {
        System.out.print(suite + rank);
    }
}