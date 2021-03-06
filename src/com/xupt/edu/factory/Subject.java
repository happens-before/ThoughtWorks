package com.xupt.edu.factory;

import com.xupt.edu.pojo.Command;

/**
 * @author: zhaowanyue
 * @date: 2018/7/28
 * @description:
 */
public class Subject implements MazeFactory{
    @Override
    public String[][] create(Command command) {
        int [] x=new int [100];
        int [] y=new int [100];
        int countx=0;
        int county=0;
        int hang=command.getHang();
        int lie=command.getLie();
        int [][] array=new int[50][50];
        //1.创建迷宫矩阵
        if(hang<=0 || lie<=0)
        {
            //测试数字超出预定范围：数字超出了允许的范围，例如为负数等。
            System.out.print("Number out of range.");
        }
        String [][] maze =new String[(2*command.getHang()+1)][(2*command.getLie()+1)];
        //2.给迷宫矩阵全部赋值“[w]”
        for(int i=0;i<maze.length;i++)
        {
            for(int j=0;j<maze[i].length;j++)
            {
                maze[i][j]="[W]";
            }
        }
        //分离x与y;
        String string=command.getString();
        String [] splits=new String[50];
        if(string.contains("a-z"))
        {
            //测试格式错误：输入命令的格式不符合约定。
            System.out.println("Incorrect command format");
        }
        else
        {
            splits=command.getString().split(";| ");
        }

        //既然你是将String类型转换为int类型，那么你的String里面的值，一定是数组，不然调用parseInt()就会抛出异常的
        for(int i=0;i<splits.length;i++)
        {
            String [] a=splits[i].split(",");
            //System.out.print(a[0]);
            try{
                x[countx++]=Integer.parseInt(a[0]);
                y[county++]=Integer.parseInt(a[1]);
            }catch (NumberFormatException e)
            {
                //测试无效的数字：输入的字符串无法正确的转换为数字。
                System.out.println("Invalid number format​.");
            }
        }
        //4.初次渲染道路（例如3*3）
        for(int i=0;i<command.getHang();i++)
        {
            for(int j=0;j<command.getLie();j++)
            {
                maze[2*i+1][2*j+1]="[R]";
            }
        }
        //5. 再次渲染道路（渲染连通性）
        for(int m=0;m<array.length;m++)
        {
            array[m][0]=2*x[m]+1;array[m][1]=2*y[m]+1;
        }

        String [] arrayLength=command.getString().split(";| ");
        for(int m=0;m<arrayLength.length;m=m+2)
        {
            if(array[m][0]==array[m+1][0]) {
                //System.out.println("行相等，列相差"+Math.abs(array[m][1] - array[m + 1][1]));
                if (Math.abs(array[m][1] - array[m + 1][1]) == 2)
                {
                    if (array[m][1] < array[m + 1][1])
                        maze[(array[m][0])][(array[m][1] + 1)] = "[R]";
                    if (array[m][1] > array[m + 1][1])
                        maze[(array[m][0])][(array[m + 1][1] + 1)] = "[R]";
                }
                //测试连通性错误：如果两个网格无法连通，则属于这种错误。
                else System.out.println("Maze format error.");
            }
            if(array[m][1]==array[m+1][1])
            {
                //System.out.println( "列相等，行相差"+Math.abs(array[m][0]-array[m+1][0]));
                if(Math.abs(array[m][0]-array[m+1][0])==2)
                {
                    if(array[m][0]<array[m+1][0])
                        maze[array[m][0]+1][array[m][1]]="[R]";
                    if(array[m][0]>array[m+1][0])
                        maze[array[m+1][0]+1][array[m][1]]="[R]";
                }
                //测试连通性错误：如果两个网格无法连通，则属于这种错误。
                else System.out.println("Maze format error.");
            }
        }
        return maze;
    }
    public void print(String [][] maze)
    {
        for(int i=0;i<maze.length;i++)
        {
            for(int j=0;j<maze[i].length;j++)
            {
                System.out.print(maze[i][j]+" ");
            }
            System.out.println( );
        }
    }

    @Override
    public String[][] create1(Command command) {

        int [] x=new int [100];
        int [] y=new int [100];
        int countx=0;
        int county=0;
        int hang=command.getHang();
        int lie=command.getLie();
        int [][] array=new int[50][50];
        //1.创建迷宫矩阵
        if(hang<=0 || lie<=0)
        {
            //测试数字超出预定范围：数字超出了允许的范围，例如为负数等。
            System.out.print("Number out of range.");
        }
        String [][] maze =new String[(2*command.getHang()+1)][(2*command.getLie()+1)];
        //2.给迷宫矩阵全部赋值“[w]”
        for(int i=0;i<maze.length;i++)
        {
            for(int j=0;j<maze[i].length;j++)
            {
                maze[i][j]="[W]";
            }
        }
        //分离x与y;
        String string=command.getString();
        String [] splits=new String[50];
        if(string.contains("a-z"))
        {
            //测试格式错误：输入命令的格式不符合约定。
            System.out.println("Incorrect command format");
        }
        else
        {
            splits=command.getString().split(";| ");
        }

        //既然你是将String类型转换为int类型，那么你的String里面的值，一定是数组，不然调用parseInt()就会抛出异常的
        for(int i=0;i<splits.length;i++)
        {
            String [] a=splits[i].split(",");
            //System.out.print(a[0]);
            try{
                x[countx++]=Integer.parseInt(a[0]);
                y[county++]=Integer.parseInt(a[1]);
            }catch (NumberFormatException e)
            {
                //测试无效的数字：输入的字符串无法正确的转换为数字。
                System.out.println("Invalid number format​.");
            }
        }
        //4.初次渲染道路（例如3*3）
        for(int i=0;i<command.getHang();i++)
        {
            for(int j=0;j<command.getLie();j++)
            {
                maze[2*i+1][2*j+1]="[R]";
            }
        }
        //5. 再次渲染道路（渲染连通性）
        for(int m=0;m<array.length;m++)
        {
            array[m][0]=2*x[m]+1;array[m][1]=2*y[m]+1;
        }

        String [] arrayLength=command.getString().split(";| ");
        for(int m=0;m<arrayLength.length;m=m+2)
        {
            if(array[m][0]==array[m+1][0]) {
                //System.out.println("行相等，列相差"+Math.abs(array[m][1] - array[m + 1][1]));
                if (Math.abs(array[m][1] - array[m + 1][1]) == 2)
                {
                    if (array[m][1] < array[m + 1][1])
                        maze[(array[m][0])][(array[m][1] + 1)] = "[R]";
                    if (array[m][1] > array[m + 1][1])
                        maze[(array[m][0])][(array[m + 1][1] + 1)] = "[R]";
                }
                //测试连通性错误：如果两个网格无法连通，则属于这种错误。
                else System.out.println("Maze format error.");
            }
            if(array[m][1]==array[m+1][1])
            {
                //System.out.println( "列相等，行相差"+Math.abs(array[m][0]-array[m+1][0]));
                if(Math.abs(array[m][0]-array[m+1][0])==2)
                {
                    if(array[m][0]<array[m+1][0])
                        maze[array[m][0]+1][array[m][1]]="[R]";
                    if(array[m][0]>array[m+1][0])
                        maze[array[m+1][0]+1][array[m][1]]="[R]";
                }
                //测试连通性错误：如果两个网格无法连通，则属于这种错误。
                else System.out.println("Maze format error.");
            }
        }
        int [][]opt=new int[(2*command.getHang()+1)][(2*command.getLie()+1)];
        for(int i=1;i<maze.length;i++)
        {
            for(int j=1;j<maze[0].length;j++)
            {
                int count=0;
                if(maze[i][j]=="[R]")
                {
                    if(maze[i-1][j]=="[R]")//上
                        count++;
                    if(maze[i][j-1]=="[R]")//左
                        count++;
                    if(maze[i+1][j]=="[R]")//下
                        count++;
                    if(maze[i][j+1]=="[R]")
                        count++;
                    opt[i][j]=count;
                }
            }
        }
        for(int i=0;i<maze.length;i++)
        {
            for(int j=0;j<maze[0].length;j++)
            {
                if(maze[i][j]=="[R]")
                {
                    maze[i][j]="["+opt[i][j]+"]";
                }
            }
        }
        return maze;
    }

    public int pathMin(String [][]maze, int m, int n)
    {
        if(maze.length==0)
            return 0;
        int opt[][]=new int[maze.length][maze[0].length];
        for(int i=0;i<maze.length;i++)
        {
            for(int j=0;j<maze[0].length;j++)
            {
                if(maze[i][j]=="[W]")
                    opt[i][j]=0;
                if(i==1 || j==1)
                {
                    opt[1][1]=0;
                    if(maze[i][1]=="[R]")
                    {
                        if(maze[i-1][1]=="[W]")
                            opt[i][1]=1;
                        else
                            opt[i][1]=opt[i-1][1]+1;
                    }
                    if(maze[1][j]=="[R]")
                    {
                        if(maze[1][j-1]=="[W]")
                            opt[1][j]=1;
                        else
                            opt[1][j]=opt[1][j-1]+1;
                    }
                }

            }
        }
        int value1=0;
        int value2=0;
        for(int i=2;i<maze.length;i++)
        {
            for(int j=2;j<maze[0].length;j++)
            {
                if(maze[i][j]=="[R]")
                {
                    if(maze[i-1][j]=="[R]")
                    {
                        value1=opt[i-1][j];
                    }

                    else{
                        value1=0;
                    }
                    if(maze[i][j+1]=="[R]")
                    {
                        value2=opt[i][j+1];
                    }
                    else
                    {
                        value2=0;
                    }
                     opt[i][j]=Math.min(value1,value2)+opt[i][j];
                }
                else
                {
                    System.out.println("迷宫i="+i+"j="+j+"是墙，走不通");
                }
            }

        }
        return opt[m][n];
    }

}
