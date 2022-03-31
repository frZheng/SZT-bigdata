package cn.java666.sztcommon.util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class readFile {
    /**
     * 读出文件的最后n行
     *
     * @param file 文件
     * @param num  第几行
     * @return
     */
    public static List<String> readLastNLine(File file, int num) {
        if (num == 0) {
            return null;
        }
        //判断该文件是否存在，可读
        if (!file.exists()) {
            System.out.println("file not exists");
            return null;
        }
        if (file.isDirectory()) {
            System.out.println("file is isDirectory");
            return null;
        }
        if (!file.canRead()) {
            System.out.println("file can not read");
            return null;
        }
        List<String> result = new ArrayList<>();
        //行数
        int count = 0;
        //很多中读取模式，选择只读模式
        RandomAccessFile read = null;
        try {
            read = new RandomAccessFile(file, "r");
            //读取文件长度
            long length = read.length();
            //判断长度
            if (length == 0L) {
                return null;
            } else {
                //因为是倒数，所以从最大值开始读起
                long next = length - 1;
                //当下一个大于0，则代表文章有内容
                while (next > 0) {
                    next--;
                    //开始读取
                    read.seek(next);
                    //如果读取到\n代表是读取到一行
                    if (read.readByte() == '\n') {
                        //使用readLine获取当前行
                        String line = read.readLine();
                        //保存结果
                        result.add(line);
                        //行数统计，如果到达了指定的行数，就跳出循环
                        count++;
                        if (count == num) {
                            break;
                        }
                    }
                }
                //next为0，代表长度为1
                if (next == 0) {
                    read.seek(0);
                    result.add(read.readLine());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭文件
            if (read != null) {
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }




    public static void main(String[] args) {
        File file = new File("F:\\zkd\\CODE\\zgz\\SZT-bigdata\\.file\\zfr_file\\szt-data-page.jsons");
        List<String> result1 = readLastNLine(file, 1);
        System.out.println("===================");
        if (null != result1 && result1.size() > 0) {
            for (int i = result1.size() - 1; i >= 0; i--) {
                System.out.println(result1.get(i));
            }
        }
    }








}
