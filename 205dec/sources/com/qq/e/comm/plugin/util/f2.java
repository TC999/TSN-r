package com.qq.e.comm.plugin.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f2 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f46420a = "f2";

    /* renamed from: b  reason: collision with root package name */
    private static final long f46421b = com.qq.e.comm.plugin.d0.a.d().f().a("tlrfs", 512) * 1024;

    /* renamed from: c  reason: collision with root package name */
    private static final File f46422c = new File(com.qq.e.comm.plugin.d0.a.d().a().getApplicationContext().getCacheDir(), "tools_log");

    /* renamed from: d  reason: collision with root package name */
    private static final File f46423d = new File(f46422c + File.separator + "A");

    /* renamed from: e  reason: collision with root package name */
    private static final File f46424e = new File(f46422c + File.separator + "B");

    public static void a(String str, Object obj, Object... objArr) {
        if (a()) {
            try {
                if (!f46422c.exists()) {
                    f46422c.mkdir();
                }
                if (!f46423d.exists()) {
                    f46423d.createNewFile();
                }
                if (!f46424e.exists()) {
                    f46424e.createNewFile();
                }
                if (objArr != null && objArr.length > 0) {
                    obj = String.format(obj.toString(), objArr);
                }
                d1.a("%s---originLog %s: %s", f46420a, str, obj);
                String a4 = a(obj.toString(), str);
                if (f46423d.length() < f46421b) {
                    b1.a(f46423d, a4);
                } else if (f46424e.length() < f46421b) {
                    b1.a(f46424e, a4);
                } else {
                    b1.b(f46423d.lastModified() < f46424e.lastModified() ? f46423d : f46424e, a4);
                }
            } catch (Exception e4) {
                d1.b(f46420a, e4.toString());
            }
        }
    }

    private static boolean a() {
        return o.a() && com.qq.e.comm.plugin.d0.a.d().a().getSharedPreferences("gdt_mock", 0).getBoolean("needRecord", false);
    }

    private static String a(String str, String str2) {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date());
        String a4 = h1.a(format + str2 + str, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApbco3xK9deb07zYc2Kot\njdDnU4aR3J6Tr4QNcei0lDFyb5l9twwTlAhwx+jDxCFQE2GvZPw0ru3fLlnwIOGv\nxvBRozZiXsmNYGnR/ntK708th9huZ2TWB3cfqepevOWEyMP3dasnY5puz/6BMxUL\nMbbLGPR5eWpaqUra6mZ8k6tKlNQoItSwAQTikVztS7SW23FTMB5z5gdhJ1EDV5+w\n8w8/fcwsgP+aR5FwkPYRRzPukspt4N+fJq1cyxTwCmKkobmvWzn699IXHItAOqqH\nt3ZW6EbgELlLFd94dtVL7OyiIxhQiyJ0Ulv3XOdjiCqLWSMCUImTnRCmmX+Kdka9\nzQIDAQAB");
        return "------------------------------------------------------------" + a4;
    }
}
