package com.gf.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Title: <br>
 * Packet:com.gf.utils<br>
 * Description: <br>
 * Author:GuoFu<br>
 * Create Date: 2018/11/29.<br>
 * Modify User: <br>
 * Modify Date: <br>
 * Modify Description: <br>
 */
public class PathUtils {
    public static String getCurrentWorkPath() throws UnsupportedEncodingException {
        String currentWorkPath = PathUtils.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        currentWorkPath = URLDecoder.decode(currentWorkPath.substring(0, currentWorkPath.lastIndexOf("/") + 1), "utf8");
        return currentWorkPath;
    }
}
