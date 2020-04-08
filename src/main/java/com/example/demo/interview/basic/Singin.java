package com.example.demo.interview.basic;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Singin {
    private static final String FILE_PATH = "E://test/data";

    public static void main(String[] args) {

        String phoneNum1 = "138 1234 1234";
        String phoneNum2 = "13812345abc";
        String phoneNum3 = "13812345678";
        String phoneNum4 = "1381234 5678";
        String phoneNum5 = "98765432101";

        start(phoneNum5);

    }

    private static void start(String phone){
        if (check(phone)) {
            register(format(phone));
        } else {
            err("非法手机号码！");
        }
        out(String.format("已注册账号：%s", getRegisterPhoneNums()));
    }

    private static void err(Object o) {
        System.err.println(o);
    }
    private static void out(Object o) {
        System.out.println(o);
    }

    /**
     * 创建文件
     * @return
     */
    private static boolean createFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            try {
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                file.createNewFile();
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }

    /**
     * 反序列化
     * @return
     */
    private static Object getRegisterPhoneNums(){
        return SerializableUtils.read(FILE_PATH);
    }

    /**
     * 格式化手机号码
     * @param phoneNum
     * @return
     */
    private static String format(String phoneNum){
        return phoneNum.replaceAll("( )\\1*", "");
    }

    /**
     * 注册
     * @param phoneNum
     */
    public static void register(String phoneNum) {
        try {
            if (!createFile()) {
                err("缓存文件地址错误！");
            } else {
                List<String> data;
                Object object = SerializableUtils.read(FILE_PATH);
                if (object != null) {
                    data = (List<String>) object;
                    boolean contains = data.contains(phoneNum);
                    if (contains) {
                        err("该手机号已被注册！");
                    } else {
                        data.add(phoneNum);
                        out("注册成功！");
                    }
                } else {
                    data = new ArrayList<>();
                    data.add(phoneNum);
                    out("注册成功！");
                }
                SerializableUtils.write(data, FILE_PATH);
            }
        } catch (Exception e) {
            err("序列化异常！");
        }
    }

    /**
     * 校验手机号码是否正确
     * @param phoneNum
     * @return
     */
    private static boolean check(String phoneNum) {
        return phoneNum.matches("1(3[0-9]|5[189]|8[6789])( )?[0-9]{4}( )?[0-9]{4}");
    }
}

class SerializableUtils{
    /**
     * 序列化 将对象存储到文件中
     *
     * @param obj  序列化对象，必须实现可序列化接口
     * @param path 序列化路径
     * @return
     */
    public static boolean write(Object obj, String path) {
        boolean f;
        File file = getFile(path);
        OutputStream out = null;
        ObjectOutputStream objout = null;
        try {
            out = new FileOutputStream(file);
            objout = new ObjectOutputStream(out);
            objout.writeObject(obj);
            f = true;
        } catch (IOException e) {
            f = false;
            e.printStackTrace();
        } finally {
            close(objout);
            close(out);
        }
        return f;
    }

    /**
     * 反序列化 读取存入文件中的对象
     *
     * @param pathname 反序列化路径
     * @return
     */
    public static Object read(String pathname) {
        Object obj = null;
        File file = new File(pathname);
        InputStream in = null;
        ObjectInputStream objin = null;
        try {
            in = new FileInputStream(file);
            objin = new ObjectInputStream(in);
            obj = objin.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(objin);
            close(in);
        }
        return obj;
    }

    public static File getFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    /**
     * 流的关闭操作
     *
     * @param obj 流对象
     */
    public static void close(Object obj) {
        if (obj != null) {
            try {
                invoke(obj, "close");
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 执行一个无参方法
     *
     * @param obj        操作对象
     * @param methodName 属性名
     * @return Object
     * @throws RuntimeException
     */
    public static Object invoke(Object obj, String methodName) throws RuntimeException {
        if (obj == null || methodName == null) {
            return null;
        }
        Object value = null;
        try {
            Method getMethod = obj.getClass().getMethod(methodName);
            if (getMethod == null) {
                return null;
            }
            getMethod.setAccessible(true);
            value = getMethod.invoke(obj);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return value;
    }
}