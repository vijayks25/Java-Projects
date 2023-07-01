import java.util.*;
public class Game
{
    Player p1, p2;
    Board b;
    Game()
    {

    }

    void initialise()
    {
        int rows,cols;
        char def;
        Scanner sc;
        sc=new Scanner(System.in);
        System.out.println("Enter the name of Player1:");
        String n=sc.next();
        System.out.println("Enter the coin for Player1:");
        char c=sc.next().charAt(0);

        p1=new Player(n,c);

        System.out.println("Enter the name of Player2:");
        n=sc.next();
        System.out.println("Enter the coin for Player2:");
        c=sc.next().charAt(0);

        p2=new Player(n,c);

        System.out.println("Enter the rows:");
        rows=sc.nextInt();
        System.out.println("Enter the columns:");
        cols=sc.nextInt();
        System.out.println("Enter the default character:");
        def= sc.next().charAt(0);

        this.b= new Board(rows,cols,def);
    }

    public boolean check_Row(int row_no,char c)
    {
        int temp=0;
        for(int i=0;i<=b.grid[row_no].length-4;i=i+1)
        {
            for(int j=i;j<i+4;j=j+1)
            {
                if(b.grid[row_no][j]==c)
                {
                    temp=temp+1;
                }
                else
                {
                    temp=0;
                    break;
                }
            }
            if (temp>=4)
            {
                System.out.println("Won by row");
                return true;
            }
        }
        return false;
    }

    public boolean check_Col(int col_no,char c)
    {
        int temp=0;
        for(int i=0;i<=b.grid.length-4;i=i+1)
        {
            for(int j=i;j<i+4;j=j+1)
            {
                if(b.grid[j][col_no]==c)
                {
                    temp=temp+1;
                }
                else
                {
                    temp=0;
                    break;
                }
            }
            if (temp>=4)
            {
                System.out.println("Won by col");
                return true;
            }
        }
        return false;
    }

    public boolean check_Diagonal(char c)
    {
        for (int i=0;i<b.grid.length-3;i=i+1)
        {
            for(int j=0;j<b.grid[0].length-3;j=j+1)
            {
                if(b.grid[i][j]!= b.def && b.grid[i][j]==c && b.grid[i+1][j+1]==c && b.grid[i+2][j+2]==c && b.grid[i+3][j+3]==c)
                {
                    return true;
                }
            }
        }

        for (int i=0;i<b.grid.length-3;i=i+1)
        {
            for(int j=3;j<b.grid[0].length;j=j+1)
            {
                if(b.grid[i][j]!= b.def && b.grid[i][j]==c && b.grid[i+1][j-1]==c && b.grid[i+2][j-2]==c && b.grid[i+3][j-3]==c)
                {
                    return true;
                }
            }
        }
        return false;
    }

    boolean check_Won(int row_no, int col_no, char c)
    {
        boolean row,col,diagonal;
        row=check_Row(row_no,c);
        col=check_Col(col_no,c);
        diagonal=check_Diagonal(c);
        if(row==true)
        {
            return true;

        }
        if(col==true)
        {
            return true;
        }
        if(diagonal==true)
        {
            return true;
        }
        return false;
    }

    void play()
    {
        int col=0;
        int row=0;
        Scanner sc= new Scanner(System.in);
        while(true)
        {
            System.out.print("Input column number for player 1:");
            col=sc.nextInt();
            row=b.input_Coin(col,p1.coin);
            b.print_Grid();
            if(check_Won(row,col,p1.coin)==true)
            {
                System.out.print(p1.name + " " + "won the game!");
                break;
            } 
            System.out.print("Input column number for player 2:");
            col=sc.nextInt();
            row=b.input_Coin(col,p2.coin);
            b.print_Grid();  
            if(check_Won(row,col,p2.coin)==true)
            {
                System.out.print(p2.name + " " + "won the game!");
                break;
            }
        }
    }  

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        Game g= new Game();
        int x=-1;
        int option;
        while(x!=0)
        {
            System.out.println();
            System.out.println("Press 1 to play");
            System.out.println("Press 0 to exit");
            option = sc.nextInt();
            switch(option)
            {
                case 1:
                g.initialise();
                g.play();
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