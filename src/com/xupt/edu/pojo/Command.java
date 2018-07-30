package com.xupt.edu.pojo;

/**
 * @author: zhaowanyue
 * @date: 2018/7/28
 * @description:
 */
public class Command {
    int hang;
    int lie;
    String  string;

    public Command() {
    }

    public Command(int hang, int lie, String string) {
        this.hang = hang;
        this.lie = lie;
        this.string = string;
    }

    public int getHang() {
        return hang;
    }

    public void setHang(int hang) {
        this.hang = hang;
    }

    public int getLie() {
        return lie;
    }

    public void setLie(int lie) {
        this.lie = lie;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return "Command{" +
                "hang=" + hang +
                ", lie=" + lie +
                ", string='" + string + '\'' +
                '}';
    }
    public void print()
    {
        String [] splits=string.split(";| ");
        int [] x=new int [100];
        int [] y=new int [100];
        int countx=0;
        int county=0;
        for(int i=0;i<splits.length;i++)
        {
            String [] a= splits[i].split(",");
            try{
                x[countx++]=Integer.parseInt(a[0]);
                y[county++]=Integer.parseInt(a[1]);
            }catch (Exception e)
            {
                System.out.println("Invalid number format​.");
            }
//            System.out.print(splits[i]+" ");
//            System.out.println( );
            //System.out.println(a[0]+" "+a[1]);
          //  System.out.println(x[countx-1]+" "+y[county-1]);
        }
        System.out.println(x[0]+" "+y[0]);
    }
}
