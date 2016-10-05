/**
 * Created by Zou on 2016/10/5.
 */
public class UnixTimeStamp {
    int year=1970,month=1,date=1,hour,minute;
    long time;
    int flag=0;//立个flag（划掉）判定闰年

    public UnixTimeStamp(long time) {//传入时间参数
        this.time=time;
    }

    public long TimeZoneChange(int timezone){//时差转换
        time=time+3600*timezone;
        return time;
    }

    public void Change(){
        if (time>=0) {
            while ((flag == 0 && time >= 31536000) || (flag == 1 && time >= 31622400)) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        flag = 1;
                    } else {
                        flag = 0;
                    }
                } else {
                    if (year % 4 == 0) {
                        flag = 1;
                    } else {
                        flag = 0;
                    }
                }
                if (flag == 0) {
                    time = time - 31536000;
                    year++;
                } else {
                    time = time - 31622400;
                    year++;
                }
            }//计算年份
            if (time >= 2678400) {
                time = time - 2678400;
                month++;
            }//一月
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    flag = 1;
                } else {
                    flag = 0;
                }
            } else {
                if (year % 4 == 0) {
                    flag = 1;
                } else {
                    flag = 0;
                }
            }
            if (flag == 1 && time >= 2505600) {
                time = time - 2505600;
                month++;
            }
            if (flag == 0 && time >= 2419200) {
                time = time - 2419200;
                month++;
            }//二月
            if (time >= 2678400) {
                time = time - 2678400;
                month++;
            }//三月
            if (time >= 2592000) {
                time = time - 2592000;
                month++;
            }//四月
            if (time >= 2678400) {
                time = time - 2678400;
                month++;
            }//五月
            if (time >= 2592000) {
                time = time - 2592000;
                month++;
            }//六月
            if (time >= 2678400) {
                time = time - 2678400;
                month++;
            }//七月
            if (time >= 2678400) {
                time = time - 2678400;
                month++;
            }//八月
            if (time >= 2592000) {
                time = time - 2592000;
                month++;
            }//九月
            if (time >= 2678400) {
                time = time - 2678400;
                month++;
            }//十月
            if (time >= 2592000) {
                time = time - 2592000;
                month++;
            }//十一月
            while (time >= 86400) {
                time = time - 86400;
                date++;
            }
            while (time >= 3600) {
                time = time - 3600;
                hour++;
            }
            while (time >= 60) {
                time = time - 60;
                minute++;
            }
        }
        /** 处理1970年之后的情况 */
        else{
            month=12;
            date=31;
            hour=23;
            minute=59;
            while ((flag == 0 && time <= -31536000) || (flag == 1 && time <= -31622400)) {
                if ((year-1) % 100 == 0) {
                    if ((year-1) % 400 == 0) {
                        flag = 1;
                    } else {
                        flag = 0;
                    }
                } else {
                    if ((year-1) % 4 == 0) {
                        flag = 1;
                    } else {
                        flag = 0;
                    }
                }
                if (flag == 0) {
                    time = time + 31536000;
                    year--;
                } else {
                    time = time + 31622400;
                    year--;
                }
            }
            year--;
            if (time <= -2678400) {
                time = time + 2678400;
                month--;
                date=30;
            }//十二月
            if (time <= -2592000) {
                time = time + 2592000;
                month--;
                date=31;
            }//十一月
            if (time <= -2678400) {
                time = time + 2678400;
                month--;
                date=30;
            }//十月
            if (time <= -2592000) {
                time = time + 2592000;
                month--;
                date=31;
            }//九月
            if (time <= -2678400) {
                time = time + 2678400;
                month--;
                date=31;
            }//八月
            if (time <= -2678400) {
                time = time + 2678400;
                month--;
                date=30;
            }//七月
            if (time <= -2592000) {
                time = time + 2592000;
                month--;
                date=31;
            }//六月
            if (time <= -2678400) {
                time = time + 2678400;
                month--;
                date=30;
            }//五月
            if (time <= -2592000) {
                time = time + 2592000;
                month--;
                date=31;
            }//四月
            if (time <= -2678400) {
                time = time + 2678400;
                month--;
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        date=29;
                    }
                    else {
                        date = 28;
                    }
                }
                else {
                    if (year % 4 == 0) {
                        date = 29;
                    }
                    else {
                        date = 28;
                    }
                }
            }//三月
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    flag = 1;
                }
                else {
                    flag = 0;
                }
            }
            else {
                if (year % 4 == 0) {
                    flag = 1;
                }
                else {
                    flag = 0;
                }
            }
            if (flag == 1 && time <= -2505600) {
                time = time + 2505600;
                month--;
                date=31;
            }
            if (flag == 0 && time <= -2419200) {
                time = time + 2419200;
                month--;
                date=31;
            }//二月
            while (time <= -86400) {
                time = time + 86400;
                date--;
            }
            while (time <= -3600) {
                time = time + 3600;
                hour--;
            }
            while (time <= -60) {
                time = time + 60;
                minute--;
            }
            time=60+time;
            if (time==60){
                time=0;
                minute++;
            }
            if (minute==60){
                minute=0;
                hour++;
            }
            if (hour==24){
                hour=0;
                date++;
            }
            if ((date>31&&((month==1)||(month==3)||(month==5)||(month==7)||(month==8)||
                    (month==10)||(month==12)))||(date>30&&((month==4)||(month==6)||(month==9)||
                    (month==11)))||(flag==1&&month==2&&date>29)||(flag==0&&month==2&&date>28)){
                date=1;
                month++;
            }
            if (month>12){
                month=1;
                year++;
            }
        }
        /** 处理1970年之前的情况 */
    }
}
