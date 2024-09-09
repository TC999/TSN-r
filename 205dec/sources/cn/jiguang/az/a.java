package cn.jiguang.az;

import android.text.TextUtils;
import android.util.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static List<String> f2508a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public static List<String> f2509b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f2510c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public static List<String> f2511d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public static List<String> f2512e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public static List<String> f2513f = new ArrayList();

    static {
        List<String> list;
        List asList;
        if (TextUtils.isEmpty("")) {
            return;
        }
        for (String str : new String(Base64.decode("", 2)).split("~")) {
            String[] split = str.split("-");
            if (split[0].equals("imei")) {
                list = f2508a;
                asList = Arrays.asList(split[1].split("\\|"));
            } else if (split[0].equals("iccid")) {
                list = f2509b;
                asList = Arrays.asList(split[1].split("\\|"));
            } else if (split[0].equals("imsi")) {
                list = f2510c;
                asList = Arrays.asList(split[1].split("\\|"));
            } else if (split[0].equals("meid")) {
                list = f2511d;
                asList = Arrays.asList(split[1].split("\\|"));
            } else if (split[0].equals("gsm")) {
                list = f2512e;
                asList = Arrays.asList(split[1].split("\\|"));
            }
            list.addAll(asList);
        }
        f2513f.addAll(f2512e);
        f2513f.addAll(f2508a);
        f2513f.addAll(f2510c);
        f2513f.addAll(f2509b);
        f2513f.addAll(f2511d);
    }

    public static String a(int i4, int i5) {
        List<String> list;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4 || i5 >= f2512e.size()) {
                            return "";
                        }
                        list = f2512e;
                    } else if (i5 >= f2509b.size()) {
                        return "";
                    } else {
                        list = f2509b;
                    }
                } else if (i5 >= f2511d.size()) {
                    return "";
                } else {
                    list = f2511d;
                }
            } else if (i5 >= f2510c.size()) {
                return "";
            } else {
                list = f2510c;
            }
        } else if (i5 >= f2508a.size()) {
            return "";
        } else {
            list = f2508a;
        }
        return list.get(i5);
    }
}
