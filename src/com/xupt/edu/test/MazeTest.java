package com.xupt.edu.test;

import com.xupt.edu.factory.MazeFactory;
import com.xupt.edu.factory.Subject;
import com.xupt.edu.pojo.Command;
import org.junit.Test;

import java.util.Scanner;

public class MazeTest {

    /**
     * 设计测试用例：测试无效的数字：输入的字符串无法正确的转换为数字。
     * Commmand参数：
     *      hang:3
     *      lie:3
     *      string:"**0,1 0,2;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1"
     */
    @Test
    public void testNumber()
    {
        Command command=new Command(3,3, "**0,1 0,2;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1");
        MazeFactory maze=new Subject();
        String [][] result=maze.create(command);
        maze.print(result);
    }

    /**
     * 设计测试用例：测试数字超出预定范围：数字超出了允许的范围，例如为负数等。
     * Commmand参数：
     *      hang:-1
     *      lie:3
     *      string:"0,1 0,2;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1"
     */
    @Test
    public void testNumberScope()
    {
        Command command=new Command(-1,3, "0,1 0,2;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1");
        MazeFactory maze=new Subject();
        String [][] result=maze.create(command);
        maze.print(result);
    }
    /**
     * 设计测试用例：测试格式错误：输入命令的格式不符合约定。
     * Commmand参数：
     *      hang:3
     *      lie:3
     *      string:"hello world"
     */
    @Test
    public void testFormat()
    {
        Command command=new Command(3,3, "hello world");
        MazeFactory maze=new Subject();
        String [][] result=maze.create(command);
        maze.print(result);
    }
    /**
     * 设计测试用例：测试连通性错误：如果两个网格无法连通，则属于这种错误。
     * Commmand参数：
     *      hang:3
     *      lie:3
     *      string:"0,1 0,3;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1"
     */
    @Test
    public void testLinked()
    {
        Command command=new Command(3,3, "0,1 0,3;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1");
        MazeFactory maze=new Subject();
        String [][] result=maze.create(command);
        maze.print(result);
    }

}
