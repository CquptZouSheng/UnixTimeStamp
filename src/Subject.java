import java.util.Scanner;

/**
 * Created by Zou on 2016/10/5.
 */

/**
 * 学姐大法好
 * 一楼拜学姐
*/

public class Subject {
    public static final int CCT=8;
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Please input the Unix timestamp:");
        long time=input.nextLong();
        UnixTimeStamp mUnixTimeStamp=new UnixTimeStamp(time);
        //传入时间

        mUnixTimeStamp.time=mUnixTimeStamp.TimeZoneChange(CCT);
        //转换时差

        mUnixTimeStamp.Change();
        //时间戳转换成标准时间

        System.out.println("UTC+"+CCT+":"+mUnixTimeStamp.year+"/"+mUnixTimeStamp.month+"/"
                +mUnixTimeStamp.date+" "+mUnixTimeStamp.hour+":"+mUnixTimeStamp.minute+":"+mUnixTimeStamp.time);
        //打印结果
    }
}
