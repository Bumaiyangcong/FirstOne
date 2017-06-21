package com.bumaiyangcong.login_example;

import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by pange on 公元17-06-08.
 */

class UserInfoUtil {

    public static boolean saveUserInfo(EditText username, EditText password) {

        try {
            String  userinfo=username+"##"+password;//封装用户名密码
            String path="/data/data/com.bumaiyangcong.login_example/";//制定保存的路径
            File file = new File(path, "userinfo.txt");//创建file
            FileOutputStream fileOutputStream = new FileOutputStream(file);//创建文件写入流
            fileOutputStream.write(userinfo.getBytes());//将用户名密码写入文件
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return false;
    }


}
