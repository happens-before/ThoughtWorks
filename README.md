/**
 * @author: zhaowanyue
 * @date: 2018/7/28
 * @description:README.md
 */
一.主函数思路：
1.创建Command类来封装键盘的输入信息（第一行和第二行）;
2.采用抽象工厂的设计模式，创建一个MazeFactory来创造一个迷宫maze;
二.结构：
com.xupt.edu.factory
      ----MazeFactory（接口）
      ----Subject（类）
com.xupt.edu.main
      ----Main（主函数）
com.xupt.edu.pojo
      ----Command（输入信息类）
com.xupt.edu.test
      ----MazeTest（juit测试）
         ----testNumber() (测试无效的数字)
         ----testNumberScope()(测试数字超出预定范围)
         ----testFormat() (测试格式错误)
         ----testLinked() (测试连通性错误)
三.Subject（类）.create方法的设计思路：
1.创建迷宫矩阵
String [][] maze =new String[(2*command.getHang()+1)][(2*command.getLie()+1)];
2.给迷宫矩阵全部赋值“[w]”
maze[i][j]="[W]";
3.分割command字符串
String [] splits=command.getString().split(";|,| ");//分离x与y;
4.初次渲染道路（例如3*3）
maze[2*i+1][2*j+1]="[R]";
5. 再次渲染道路（渲染连通性）
    5.1.将3*3的道路连通性转换到7*7的迷宫的对应位置。
        array[m][0]=2*x[m]+1;array[m][1]=2*y[m]+1;
    5.2.遍历7*7迷宫连通性的对应位置，判断是否哪些道路直接连通，然后打通中间的墙。
        for(int m=0;m<array.length;m=m+2)
                {
                    if(array[m][0]==array[m+1][0])
                    {
                        if(array[m][1]<array[m+1][1])
                        maze[(array[m][0])][(array[m][1]+1)]="[R]";
                        if(array[m][1]>array[m+1][1])
                            maze[(array[m][0])][(array[m+1][1]+1)]="[R]";
                    }
                    if(array[m][1]==array[m+1][1])
                    {
                        if(array[m][0]<array[m+1][0])
                            maze[array[m][0]+1][array[m][1]]="[R]";
                        if(array[m][0]>array[m+1][0])
                            maze[array[m+1][0]+1][array[m][1]]="[R]";
                    }
                }
6.打印迷宫     
System.out.print(maze[i][j]+" ");
四.测试(juit测试)
1.测试无效的数字：输入的字符串无法正确的转换为数字。
Command command=new Command(3,3, "**0,1 0,2;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1");
2.测试数字超出预定范围：数字超出了允许的范围，例如为负数等。
Command command=new Command(-1,3, "0,1 0,2;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1");
3.测试格式错误：输入命令的格式不符合约定。    
Command command=new Command(3,3, "hello world");
4.测试连通性错误：如果两个网格无法连通，则属于这种错误。
Command command=new Command(3,3, "0,1 0,3;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1");
五.运行结果示例
第一组运行结果：
3 3
0,1 0,2;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1
[W] [W] [W] [W] [W] [W] [W] 
[W] [R] [W] [R] [R] [R] [W] 
[W] [R] [W] [R] [W] [R] [W] 
[W] [R] [R] [R] [R] [R] [W] 
[W] [W] [W] [R] [W] [R] [W] 
[W] [R] [R] [R] [W] [R] [W] 
[W] [W] [W] [W] [W] [W] [W] 
第二组运行结果
5 4
0,0 1,0;1,0 1,1;1,1 1,2;0,1 0,2;0,2 0,3;0,3 1,3;1,3 2,3;1,2 2,2;2,1 2,2;2,0 2,1;2,0 3,0;3,0 3,1;3,1 4,1;3,1 3,2;4,0 4,1;3,2 4,2;2,3 3,3;3,3 4,3;0,2 1,2
[W] [W] [W] [W] [W] [W] [W] [W] [W] 
[W] [R] [W] [R] [R] [R] [R] [R] [W] 
[W] [R] [W] [W] [W] [R] [W] [R] [W] 
[W] [R] [R] [R] [R] [R] [W] [R] [W] 
[W] [W] [W] [W] [W] [R] [W] [R] [W] 
[W] [R] [R] [R] [R] [R] [W] [R] [W] 
[W] [R] [W] [W] [W] [W] [W] [R] [W] 
[W] [R] [R] [R] [R] [R] [W] [R] [W] 
[W] [W] [W] [R] [W] [R] [W] [R] [W] 
[W] [R] [R] [R] [W] [R] [W] [R] [W] 
[W] [W] [W] [W] [W] [W] [W] [W] [W] 
        
 