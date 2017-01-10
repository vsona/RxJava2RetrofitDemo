package net.vsona.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.security.MessageDigest;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

/**
 * Author   : wangsf
 * Data     : 2016-09-18  15:10
 * Describe : 字符串相关
 */
public class StringUtils {
    private final static Pattern emailer = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
    private final static String[] hexDigits = {
            "0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "a", "b", "c", "d", "e", "f"};

    private static final int MOBILE_LENGTH = 11;

    public static String unGzipBytesToString(InputStream in) {

        try {
            PushbackInputStream pis = new PushbackInputStream(in, 2);
            byte[] signature = new byte[2];
            pis.read(signature);
            pis.unread(signature);
            int head = ((signature[0] & 0x00FF) | ((signature[1] << 8) & 0xFF00));
            if (head != GZIPInputStream.GZIP_MAGIC) {
                return new String(toByteArray(pis), "UTF-8").trim();
            }
            GZIPInputStream gzip = new GZIPInputStream(pis);
            byte[] readBuf = new byte[8 * 1024];
            ByteArrayOutputStream outputByte = new ByteArrayOutputStream();
            int readCount = 0;
            do {
                readCount = gzip.read(readBuf);
                if (readCount > 0) {
                    outputByte.write(readBuf, 0, readCount);
                }
            } while (readCount > 0);
            closeQuietly(gzip);
            closeQuietly(pis);
            closeQuietly(in);
            if (outputByte.size() > 0) {
                return new String(outputByte.toByteArray());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String md5Encode(String origin) {
        String resultString = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(origin.getBytes()));
        } catch (Exception ex) {

        }
        return resultString;
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n >>> 4 & 0xf;
        int d2 = n & 0xf;
        return hexDigits[d1] + hexDigits[d2];
    }


    /**
     * 关闭InputStream
     */
    public static void closeQuietly(InputStream is) {
        try {
            if (is != null) {
                is.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭InputStream
     */
    public static void closeQuietly(OutputStream os) {
        try {
            if (os != null) {
                os.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将input流转为byte数组，自动关闭
     *
     * @param input
     * @return
     */
    public static byte[] toByteArray(InputStream input) throws Exception {
        if (input == null) {
            return null;
        }
        ByteArrayOutputStream output = null;
        byte[] result = null;
        try {
            output = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024 * 100];
            int n = 0;
            while (-1 != (n = input.read(buffer))) {
                output.write(buffer, 0, n);
            }
            result = output.toByteArray();
        } finally {
            closeQuietly(input);
            closeQuietly(output);
        }
        return result;
    }

    /**
     * 判断给定字符串是否空白串。
     * 空白串是指由空格、制表符、回车符、换行符组成的字符串
     * 若输入字符串为null或空字符串，返回true
     *
     * @param input
     * @return boolean
     */
    public static boolean isEmpty(String input) {
        if (input == null || "".equals(input))
            return true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断是不是一个合法的电子邮件地址
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        if (email == null || email.trim().length() == 0)
            return false;
        return emailer.matcher(email).matches();
    }

}
