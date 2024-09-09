package cn.jiguang.bq;

import android.content.Context;
import android.util.Log;
import cn.jiguang.f.f;
import cn.jiguang.internal.JConstants;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f2831a = "jpush_log";

    /* renamed from: b  reason: collision with root package name */
    public static String f2832b = "internal_debug_log.txt";

    /* renamed from: c  reason: collision with root package name */
    private static final SimpleDateFormat f2833c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);

    /* renamed from: d  reason: collision with root package name */
    private static final Object f2834d = new Object();

    public static void a() {
        try {
            synchronized (f2834d) {
                Context appContext = JConstants.getAppContext(null);
                if (appContext == null) {
                    appContext = f.a();
                }
                if (appContext == null) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(appContext.getFilesDir());
                String str = File.separator;
                sb.append(str);
                sb.append(f2831a);
                sb.append(str);
                File file = new File(sb.toString());
                if (!file.exists()) {
                    file.delete();
                    return;
                }
                if (file.listFiles() != null) {
                    for (File file2 : file.listFiles()) {
                        file2.delete();
                    }
                }
                file.delete();
            }
        } catch (Throwable th) {
            d.i("Logger", "clearLogFiles error is " + th.getMessage());
        }
    }

    private static void a(final String str) {
        try {
            cn.jiguang.cm.d.a("ONCE_TASK", new Runnable() { // from class: cn.jiguang.bq.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        synchronized (c.f2834d) {
                            Context appContext = JConstants.getAppContext(null);
                            if (appContext == null) {
                                appContext = f.a();
                            }
                            if (appContext == null) {
                                return;
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append(appContext.getFilesDir());
                            String str2 = File.separator;
                            sb.append(str2);
                            sb.append(c.f2831a);
                            sb.append(str2);
                            String sb2 = sb.toString();
                            File file = new File(sb2 + c.f2832b);
                            File parentFile = file.getParentFile();
                            if (!parentFile.exists()) {
                                parentFile.mkdirs();
                            }
                            if (!file.exists()) {
                                file.createNewFile();
                                d.a("Logger", "create log file: " + file.getName());
                            }
                            cn.jiguang.f.c.a(file, str + "\n");
                        }
                    } catch (Throwable th) {
                        d.i("Logger", "write logs to file error is " + th.getMessage());
                    }
                }
            });
        } catch (Throwable th) {
            d.i("Logger", "saveLogs error is " + th.getMessage());
        }
    }

    public static void a(String str, String str2, String str3, String str4, Throwable th) {
        str3 = (str3 == null || str3.trim().equals("")) ? "Logger" : "Logger";
        if (str4 == null) {
            return;
        }
        try {
            String format = f2833c.format(new Date());
            BufferedReader bufferedReader = new BufferedReader(new StringReader(str4), 256);
            String str5 = "[" + str3 + "] ";
            String a4 = cn.jiguang.f.a.a(f.a());
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    a(((Object) format) + " " + a4 + " " + str + TTPathConst.sSeparator + str2 + ": " + str5 + readLine);
                } catch (IOException e4) {
                    d.l("Logger", e4.getMessage());
                }
            }
            if (th != null) {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                a(((Object) format) + " " + str + stringWriter.toString());
            }
        } catch (Throwable th2) {
            Log.w("Logger", "log2File call failed:" + th2.getMessage());
        }
    }
}
