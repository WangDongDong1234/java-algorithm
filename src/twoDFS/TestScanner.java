package twoDFS;

import java.util.Scanner;

/**
 * @program: java-algorithm
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-09-06 10:27
 **/
public class TestScanner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个字符串(中间能加空格或符号)");
        String a = input.nextLine();
        System.out.println("请输入一个字符串(中间不能加空格或符号)");
        String b = input.next();
        System.out.println("请输入一个整数");
        int c;
        c = input.nextInt();
        System.out.println("请输入一个double类型的小数");
        double d = input.nextDouble();
        System.out.println("请输入一个float类型的小数");
        float f = input.nextFloat();
        System.out.println("按顺序输出abcdf的值：");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(f);
        //构造Scanner类的对象scan，接收从控制台输入的信息
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入你的姓名");
        //接收一个字符串，可以加除Enter以为的所有符号，包括空格和Tab
        String name = scan.nextLine();
        System.out.println("请输入你的ID");
        String ID ;
        // hasNextLine()方法判断当前是否有输入，当键盘有输入后执行循环
        while(scan.hasNextLine()) {
            // 判断输入的值是否为整数类型，当为整数类型时执行循环
            if(scan.hasNextInt()) {
                ID = scan.nextLine();
                System.out.println("你输入的姓名为："+name);
                System.out.println("你输入的ID为："+ID);
                break;
            }else {
                System.out.println("请输入数字哦！");
                ID = scan.nextLine();
                continue;
            }
        }

    }
}
