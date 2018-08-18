package com.xupt.edu.main;

import com.xupt.edu.factory.MazeFactory;
import com.xupt.edu.factory.Subject;
import com.xupt.edu.pojo.Command;

import java.util.Scanner;

/**
 * @author: zhaowanyue
 * @date: 2018/7/28
 * @description:
 */
public class Main {
    public static void main(String[] args)
    {
        int hang,lie;
        String string;

        Scanner input =new Scanner(System.in);
        Scanner input1 =new Scanner(System.in);
       Scanner input2=new Scanner(System.in);

        hang=input.nextInt();
        lie=input.nextInt();

        string=input1.nextLine();

       String char1=input2.nextLine();

        input.close();
        input1.close();
        input2.close();
        if(char1.equals(""))
        {
            Command command=new Command(hang,lie, string);
            MazeFactory maze=new Subject();
            String [][] result=maze.create(command);
            maze.print(result);
        }
        else if(char1!=null)
        {
            Command command=new Command(hang,lie,string,char1);
            MazeFactory maze=new Subject();
            String[][]result=maze.create1(command);
            maze.print(result);
        }
        //1.创建Command类来封装键盘的输入信息（第一行和第二行）;

//        System.out.println(command);
//        command.print();
        //2.采用抽象工厂的设计模式，创建一个MazeFactory来创造一个迷宫maze;

//        int min=maze.pathMin(result,5,5);
//        System.out.println(min);


    }
}
