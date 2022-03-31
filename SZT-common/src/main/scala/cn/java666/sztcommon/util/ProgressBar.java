package cn.java666.sztcommon.util;

import org.junit.Test;

//public class ProgressBar {
//
//    private int index = 0;
//    private String finish;
//    private String unFinish;
//
//
//    // 进度条粒度
//    private final int PROGRESS_SIZE = 50;
//    private int BITE = 2;
//
//    private String getNChar(int num, char ch){
//        StringBuilder builder = new StringBuilder();
//        for(int i = 0; i < num; i++){
//            builder.append(ch);
//        }
//        return builder.toString();
//    }
//
//    @Test
//    public void printProgress() throws InterruptedException {
//        System.out.print("Progress:");
//
//        finish = getNChar(index / BITE, '█');
//        unFinish = getNChar(PROGRESS_SIZE - index / BITE, '─');
//        String target = String.format("%3d%%[%s%s]", index, finish, unFinish);
//        System.out.print(target);
//
//        while (index <= 100){
//            finish = getNChar(index / BITE, '█');
//            unFinish = getNChar(PROGRESS_SIZE - index / BITE, '─');
//
//            target = String.format("%3d%%├%s%s┤", index, finish, unFinish);
//            System.out.print(getNChar(PROGRESS_SIZE + 6, '\b'));
//            System.out.print(target);
//
//            Thread.sleep(50);
//            index++;
//        }
//    }
//}

public class ProgressBar {

    final String progress = "Progress:";
    int last_val;
//    public static void main(String[] args){
//
//        ProgressBar progressBar = new ProgressBar(0);
//        for (int i = 0; i < 300; i++)
//            progressBar.printProgress(i/2);
//    }

    void printToPre(int num){
        for(int i = 0; i < num; i++){
            System.out.print("\b");
        }
    }
    public ProgressBar() {
        System.out.print(progress);
        System.out.print("_%");
    }

    public ProgressBar(int last_val) {
        this.last_val = last_val;
        System.out.print(progress);
        System.out.print(last_val + "%");
    }

    void printProgress(int position) {

//        if (last_val < 10)
//            printToPre(2);
//        else if (last_val < 100)
//            printToPre(3);
//        else
//            printToPre(4);

        printToPre(String.valueOf(last_val).length() + 1);

        System.out.print(position);
        System.out.print("%");

//        try {
//            Thread.sleep(100);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
        last_val = position;
    }
}



