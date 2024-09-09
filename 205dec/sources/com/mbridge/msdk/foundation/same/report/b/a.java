package com.mbridge.msdk.foundation.same.report.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.b;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.report.d;
import com.stub.StubApp;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* compiled from: CrashHandlerUtil.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f39690c;

    /* renamed from: a  reason: collision with root package name */
    Handler f39691a = new Handler() { // from class: com.mbridge.msdk.foundation.same.report.b.a.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Context context;
            HashMap hashMap;
            super.handleMessage(message);
            if (message.what == 101 && (context = (Context) a.this.f39692b.get()) != null) {
                Object obj = message.obj;
                if (!(obj instanceof HashMap) || (hashMap = (HashMap) obj) == null) {
                    return;
                }
                new d(context).a((String) hashMap.get("crashinfo"), (File) hashMap.get("file"));
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<Context> f39692b;

    /* renamed from: d  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f39693d;

    /* renamed from: e  reason: collision with root package name */
    private Throwable f39694e;

    private a(Context context) {
        this.f39692b = new WeakReference<>(context);
    }

    private int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    private static String c(Context context) {
        try {
            return StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e4) {
            Log.e("", e4.getMessage());
            return "";
        }
    }

    private String d(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            this.f39694e = th;
            com.mbridge.msdk.c.a b4 = b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
            if (b4 == null) {
                b4 = b.a().b();
            }
            String L2 = b4.L() == null ? "mbridge" : b4.L();
            List<String> a4 = a(L2, "<mvpackage>(.*?)</mvpackage>");
            if (a4.size() > 0) {
                for (int i4 = 0; i4 < a4.size(); i4++) {
                    a(a(th), a4.get(i4), th, thread);
                }
                return;
            }
            a(a(th), L2, th, thread);
        } catch (Exception e4) {
            a(thread, th);
            e4.printStackTrace();
        }
    }

    public static a a(Context context) {
        if (f39690c == null) {
            synchronized (a.class) {
                if (f39690c == null) {
                    f39690c = new a(context);
                }
            }
        }
        return f39690c;
    }

    private HashMap<String, Object> b() {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (this.f39694e == null) {
            return null;
        }
        String b4 = e.b(c.MBRIDGE_CRASH_INFO);
        File file = new File(b4 + TTPathConst.sSeparator);
        if (!file.exists()) {
            file.mkdirs();
        }
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
        File file2 = new File(b4 + TTPathConst.sSeparator + "sdkcrash" + format + ".txt");
        try {
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file2)));
            printWriter.println(a(this.f39694e, format));
            printWriter.println("====");
            this.f39694e.printStackTrace(printWriter);
            printWriter.close();
            hashMap.put("file", file2);
            hashMap.put("time", format);
            return hashMap;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public final void a() {
        this.f39693d = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private String a(Throwable th, String str) {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject();
            Context context = this.f39692b.get();
            if (context == null) {
                return "";
            }
            double maxMemory = Runtime.getRuntime().maxMemory();
            Double.isNaN(maxMemory);
            float f4 = (float) ((maxMemory * 1.0d) / 1048576.0d);
            double d4 = Runtime.getRuntime().totalMemory();
            Double.isNaN(d4);
            float f5 = (float) ((d4 * 1.0d) / 1048576.0d);
            double freeMemory = Runtime.getRuntime().freeMemory();
            Double.isNaN(freeMemory);
            float f6 = (float) ((freeMemory * 1.0d) / 1048576.0d);
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            long usableSpace = externalStorageDirectory.getUsableSpace();
            long totalSpace = externalStorageDirectory.getTotalSpace();
            String formatFileSize = Formatter.formatFileSize(context, usableSpace);
            String formatFileSize2 = Formatter.formatFileSize(context, totalSpace);
            jSONObject.put("max_memory", String.valueOf(f4));
            jSONObject.put("memoryby_app", String.valueOf(f5));
            jSONObject.put("remaining_memory", f6);
            jSONObject.put("sdcard_remainder", formatFileSize);
            jSONObject.put("totalspacestr", formatFileSize2);
            jSONObject.put("crashtime", str);
            String b4 = com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.SDK_APP_ID);
            if (!TextUtils.isEmpty(b4)) {
                jSONObject.put("appid", b4);
            }
            try {
                jSONObject.put("osversion", Build.VERSION.SDK_INT);
                jSONObject.put("appversioncode", b(context));
                str2 = "appversionname";
            } catch (Exception unused) {
                str2 = "appversionname";
            }
            try {
                jSONObject.put(str2, c(context));
                jSONObject.put("appname", d(context));
            } catch (Exception unused2) {
                jSONObject.put("osversion", 0);
                jSONObject.put("appversioncode", "-1");
                jSONObject.put(str2, "-1");
                jSONObject.put("appname", "");
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                jSONObject.put("crashinfo", stringWriter.toString());
                String jSONObject2 = jSONObject.toString();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("key=2000052");
                stringBuffer.append("&exception=" + jSONObject2);
                return stringBuffer.toString();
            }
            StringWriter stringWriter2 = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter2));
            jSONObject.put("crashinfo", stringWriter2.toString());
            String jSONObject22 = jSONObject.toString();
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("key=2000052");
            stringBuffer2.append("&exception=" + jSONObject22);
            return stringBuffer2.toString();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }

    private String a(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < stackTrace.length; i4++) {
            sb.append(stackTrace[i4].toString() + "\n");
        }
        return sb.toString();
    }

    private void a(String str, String str2, Throwable th, Thread thread) {
        if (str.contains(str2)) {
            HashMap<String, Object> b4 = b();
            if (b4 == null || b4.get("file") == null) {
                return;
            }
            Message obtain = Message.obtain();
            HashMap hashMap = new HashMap();
            hashMap.put("crashinfo", a(th, (String) b4.get("time")));
            hashMap.put("file", b4.get("file"));
            obtain.obj = hashMap;
            obtain.what = 101;
            this.f39691a.sendMessage(obtain);
            a(thread, th);
            return;
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f39693d;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    private List<String> a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
            Matcher matcher = Pattern.compile(str2).matcher(str);
            while (matcher.find()) {
                arrayList.add(matcher.group(1));
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return arrayList;
    }

    private void a(Thread thread, Throwable th) {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e4) {
            e4.printStackTrace();
        }
        Process.killProcess(Process.myPid());
    }
}
