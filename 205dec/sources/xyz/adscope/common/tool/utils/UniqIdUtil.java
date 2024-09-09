package xyz.adscope.common.tool.utils;

import android.text.TextUtils;
import java.io.PrintStream;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import xyz.adscope.common.tool.security.Base64Util;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class UniqIdUtil {

    /* renamed from: f  reason: collision with root package name */
    public static UniqIdUtil f65056f = new UniqIdUtil();

    /* renamed from: a  reason: collision with root package name */
    public String f65057a;

    /* renamed from: b  reason: collision with root package name */
    public final Random f65058b = new SecureRandom();

    /* renamed from: c  reason: collision with root package name */
    public final UniqTimer f65059c = new UniqTimer();

    /* renamed from: d  reason: collision with root package name */
    public boolean f65060d = false;

    /* renamed from: e  reason: collision with root package name */
    public final String f65061e = "MTI3LjAuMC4x";

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public class UniqTimer {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicLong f65062a;

        public UniqTimer() {
            this.f65062a = new AtomicLong(System.currentTimeMillis());
        }

        public String getCurrentTime() {
            if (!UniqIdUtil.timestamp2Date(this.f65062a.incrementAndGet()).equals(UniqIdUtil.timestamp2Date(System.currentTimeMillis()))) {
                this.f65062a.set(System.currentTimeMillis() + UniqIdUtil.this.f65058b.nextInt(10000));
            }
            return UniqIdUtil.b(this.f65062a.incrementAndGet());
        }
    }

    public UniqIdUtil() {
        String decode = Base64Util.decode("MTI3LjAuMC4x");
        String str = this.f65057a;
        if (str == null || str.trim().length() == 0 || decode.equals(this.f65057a)) {
            this.f65057a = String.valueOf(System.currentTimeMillis());
        }
        String str2 = this.f65057a;
        this.f65057a = str2.substring(str2.length() - 2).replace(".", "0");
        if (this.f65060d) {
            PrintStream printStream = System.out;
            printStream.println("[UniqID]hostAddr is:" + this.f65057a + "----length:" + this.f65057a.length());
        }
    }

    public static String b(long j4) {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(j4));
    }

    public static UniqIdUtil getInstance() {
        UniqIdUtil uniqIdUtil = f65056f;
        uniqIdUtil.f65060d = false;
        return uniqIdUtil;
    }

    public static UniqIdUtil getInstanceWithLog() {
        UniqIdUtil uniqIdUtil = f65056f;
        uniqIdUtil.f65060d = true;
        return uniqIdUtil;
    }

    public static String left(String str, int i4) {
        if (str == null) {
            return null;
        }
        return i4 < 0 ? "" : str.length() <= i4 ? str : str.substring(0, i4);
    }

    public static String leftPad(String str, int i4, char c4) {
        if (str == null) {
            return null;
        }
        int length = i4 - str.length();
        return length <= 0 ? str : length > 8192 ? leftPad(str, i4, String.valueOf(c4)) : repeat(c4, length).concat(str);
    }

    public static String leftPad(String str, int i4, String str2) {
        if (str == null) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        int length = str2.length();
        int length2 = i4 - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length != 1 || length2 > 8192) {
            if (length2 == length) {
                return str2.concat(str);
            }
            if (length2 < length) {
                return str2.substring(0, length2).concat(str);
            }
            char[] cArr = new char[length2];
            char[] charArray = str2.toCharArray();
            for (int i5 = 0; i5 < length2; i5++) {
                cArr[i5] = charArray[i5 % length];
            }
            return new String(cArr).concat(str);
        }
        return leftPad(str, i4, str2.charAt(0));
    }

    public static String repeat(char c4, int i4) {
        if (i4 <= 0) {
            return "";
        }
        char[] cArr = new char[i4];
        Arrays.fill(cArr, c4);
        return new String(cArr);
    }

    public static String timestamp2Date(long j4) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(j4 * 1000));
    }

    public String getUniqID() {
        StringBuffer stringBuffer = new StringBuffer();
        String uniqTime = getUniqTime();
        int nextInt = this.f65058b.nextInt(8999999) + 1000000;
        stringBuffer.append(uniqTime);
        stringBuffer.append(this.f65057a);
        stringBuffer.append(getUniqThreadCode());
        stringBuffer.append(nextInt);
        if (this.f65060d) {
            PrintStream printStream = System.out;
            printStream.println("[UniqID.randomNumber]" + nextInt + "----length:" + String.valueOf(nextInt).length());
            PrintStream printStream2 = System.out;
            printStream2.println("[UniqID.getUniqID]" + stringBuffer.toString() + "----length:" + String.valueOf(stringBuffer).length());
        }
        return stringBuffer.toString();
    }

    public String getUniqThreadCode() {
        String left = left(String.valueOf(Thread.currentThread().hashCode()), 9);
        if (this.f65060d) {
            PrintStream printStream = System.out;
            printStream.println("[UniqID.getUniqThreadCode]" + left + "----length:" + left.length());
        }
        return leftPad(left, 9, "0");
    }

    public String getUniqTime() {
        String currentTime = this.f65059c.getCurrentTime();
        if (this.f65060d) {
            PrintStream printStream = System.out;
            printStream.println("[UniqID.getUniqTime]" + currentTime + "----length:" + currentTime.length());
        }
        return currentTime;
    }
}
