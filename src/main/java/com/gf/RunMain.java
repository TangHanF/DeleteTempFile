package com.gf;

import com.gf.utils.PathUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Title: <br>
 * Packet:com.gf<br>
 * Description: <br>
 * Author:GuoFu<br>
 * Create Date: 2018/11/29.<br>
 * Modify User: <br>
 * Modify Date: <br>
 * Modify Description: <br>
 */
public class RunMain {
    public static void main(String[] args) throws IOException {
        String prefix[] = new String[]{"._", ".~"};

        List<String> fileList = FileUtils.readLines(new File(PathUtils.getCurrentWorkPath() + "del_files.txt"), "utf8");
        for (int i = 0; i < fileList.size(); i++) {
            String path = fileList.get(i);
            if (path.indexOf("#") == 0)
                return;
            File file = new File(path);
            System.out.println("**********正在处理：" + FilenameUtils.getName(path));
            deleteFile(file, prefix);
        }


    }

    /**
     * 递归删除 文件/文件夹
     *
     * @param file
     */
    public static void deleteFile(File file, String[] prefixArr) {
        if (file.exists()) {
            if (file.isFile()) {
                String fileName = FilenameUtils.getName(file.getName());
                for (int i = 0; i < prefixArr.length; i++) {
                    if (prefixArr[i].equals(fileName.substring(0, 2))) {
                        boolean flag = file.delete();
                        System.out.println(String.format("\t删除 [%s] %s", fileName, flag));
                    }
                }

            } else if (file.isDirectory()) {
                File files[] = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    deleteFile(files[i], prefixArr);
                }
            }
        }
    }
}
