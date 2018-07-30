package com.xupt.edu.main;

import com.xupt.edu.factory.MazeFactory;
import com.xupt.edu.factory.Subject;
import com.xupt.edu.pojo.Command;

import java.util.ArrayList;
import java.util.List;
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
        hang=input.nextInt();
        lie=input.nextInt();
        string=input1.nextLine();
        //1.创建Command类来封装键盘的输入信息（第一行和第二行）;
        Command command=new Command(hang,lie, string);
        //System.out.println(command);
        //2.采用抽象工厂的设计模式，创建一个MazeFactory来创造一个迷宫maze;
        MazeFactory maze=new Subject();
        maze.create(command);
    }
}