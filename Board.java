public class Board
{
    char [][]grid;
    char def;
    public Board(int rows,int cols,char def)
    {
        grid = new char[rows][cols];
        this.def= def;
        for (int i=0;i<rows;i=i+1)
        {
            for (int j=0;j<cols;j=j+1)
            {
                grid [i][j] = def;
            }
        }
    }

    public void print_Grid()
    {
        System.out.print("\f");
        for(int i=0;i<grid.length;i=i+1)
        {
            for(int j=0;j<grid[0].length;j=j+1)
            {
                if(grid[i][j]== def)
                {
                    System.out.print(" ");
                }
                else
                {
                    System.out.print(grid[i][j]);
                }
                System.out.print("|");
            }
            System.out.println();
            for(int j=0;j<grid.length;j=j+1)
            {
                System.out.print("--");
            }
            System.out.println();
        }
    }

    public int input_Coin(int col_no,char c)
    {
        for(int i=grid.length-1;i>=0;i=i-1)
        {
            if(grid[i][col_no] == def)
            {
                grid[i][col_no]=c;
                return i;
            }
        }
        System.out.println("Columns are full");
        return -1;
    }
}