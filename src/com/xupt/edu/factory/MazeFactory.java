package com.xupt.edu.factory;

import com.xupt.edu.pojo.Command;

public interface MazeFactory {
     String[][] create(Command command);
     void print(String[][] maze);
     int pathMin(String [][]maze,int m,int n);
}
