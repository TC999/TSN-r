package com.mbridge.msdk.foundation.same.report.p488b;

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
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.p468a.p469a.SharedPerferenceManager;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDir;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDirManager;
import com.mbridge.msdk.foundation.same.report.ReportController;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import com.snail.antifake.deviceid.ShellAdbUtils;
import com.stub.StubApp;
import io.netty.handler.codec.rtsp.RtspHeaders;
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
import master.flame.danmaku.danmaku.parser.IDataSource;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.foundation.same.report.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class CrashHandlerUtil implements Thread.UncaughtExceptionHandler {

    /* renamed from: c */
    private static volatile CrashHandlerUtil f30917c;

    /* renamed from: a */
    Handler f30918a = new Handler() { // from class: com.mbridge.msdk.foundation.same.report.b.a.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Context context;
            HashMap hashMap;
            super.handleMessage(message);
            if (message.what == 101 && (context = (Context) CrashHandlerUtil.this.f30919b.get()) != null) {
                Object obj = message.obj;
                if (!(obj instanceof HashMap) || (hashMap = (HashMap) obj) == null) {
                    return;
                }
                new ReportController(context).m22096a((String) hashMap.get("crashinfo"), (File) hashMap.get(IDataSource.f43973c));
            }
        }
    };

    /* renamed from: b */
    private WeakReference<Context> f30919b;

    /* renamed from: d */
    private Thread.UncaughtExceptionHandler f30920d;

    /* renamed from: e */
    private Throwable f30921e;

    private CrashHandlerUtil(Context context) {
        this.f30919b = new WeakReference<>(context);
    }

    /* renamed from: b */
    private int m22119b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: c */
    private static String m22118c(Context context) {
        try {
            return StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("", e.getMessage());
            return "";
        }
    }

    /* renamed from: d */
    private String m22117d(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            this.f30921e = th;
            Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
            if (m23252b == null) {
                m23252b = SettingManager.m23261a().m23253b();
            }
            String m23430L = m23252b.m23430L() == null ? "mbridge" : m23252b.m23430L();
            List<String> m22125a = m22125a(m23430L, "<mvpackage>(.*?)</mvpackage>");
            if (m22125a.size() > 0) {
                for (int i = 0; i < m22125a.size(); i++) {
                    m22124a(m22122a(th), m22125a.get(i), th, thread);
                }
                return;
            }
            m22124a(m22122a(th), m23430L, th, thread);
        } catch (Exception e) {
            m22123a(thread, th);
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static CrashHandlerUtil m22127a(Context context) {
        if (f30917c == null) {
            synchronized (CrashHandlerUtil.class) {
                if (f30917c == null) {
                    f30917c = new CrashHandlerUtil(context);
                }
            }
        }
        return f30917c;
    }

    /* renamed from: b */
    private HashMap<String, Object> m22120b() {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (this.f30921e == null) {
            return null;
        }
        String m22347b = MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_CRASH_INFO);
        File file = new File(m22347b + "/");
        if (!file.exists()) {
            file.mkdirs();
        }
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
        File file2 = new File(m22347b + "/sdkcrash" + format + ".txt");
        try {
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file2)));
            printWriter.println(m22121a(this.f30921e, format));
            printWriter.println("====");
            this.f30921e.printStackTrace(printWriter);
            printWriter.close();
            hashMap.put(IDataSource.f43973c, file2);
            hashMap.put(RtspHeaders.Values.TIME, format);
            return hashMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public final void m22128a() {
        this.f30920d = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /* renamed from: a */
    private String m22121a(Throwable th, String str) {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject();
            Context context = this.f30919b.get();
            if (context == null) {
                return "";
            }
            double maxMemory = Runtime.getRuntime().maxMemory();
            Double.isNaN(maxMemory);
            float f = (float) ((maxMemory * 1.0d) / 1048576.0d);
            double d = Runtime.getRuntime().totalMemory();
            Double.isNaN(d);
            float f2 = (float) ((d * 1.0d) / 1048576.0d);
            double freeMemory = Runtime.getRuntime().freeMemory();
            Double.isNaN(freeMemory);
            float f3 = (float) ((freeMemory * 1.0d) / 1048576.0d);
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            long usableSpace = externalStorageDirectory.getUsableSpace();
            long totalSpace = externalStorageDirectory.getTotalSpace();
            String formatFileSize = Formatter.formatFileSize(context, usableSpace);
            String formatFileSize2 = Formatter.formatFileSize(context, totalSpace);
            jSONObject.put("max_memory", String.valueOf(f));
            jSONObject.put("memoryby_app", String.valueOf(f2));
            jSONObject.put("remaining_memory", f3);
            jSONObject.put("sdcard_remainder", formatFileSize);
            jSONObject.put("totalspacestr", formatFileSize2);
            jSONObject.put("crashtime", str);
            String m22944b = SharedPerferenceManager.m22949a().m22944b(MBridgeConstans.SDK_APP_ID);
            if (!TextUtils.isEmpty(m22944b)) {
                jSONObject.put("appid", m22944b);
            }
            try {
                jSONObject.put("osversion", Build.VERSION.SDK_INT);
                jSONObject.put("appversioncode", m22119b(context));
                str2 = "appversionname";
            } catch (Exception unused) {
                str2 = "appversionname";
            }
            try {
                jSONObject.put(str2, m22118c(context));
                jSONObject.put("appname", m22117d(context));
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

    /* renamed from: a */
    private String m22122a(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stackTrace.length; i++) {
            sb.append(stackTrace[i].toString() + ShellAdbUtils.f33810d);
        }
        return sb.toString();
    }

    /* renamed from: a */
    private void m22124a(String str, String str2, Throwable th, Thread thread) {
        if (str.contains(str2)) {
            HashMap<String, Object> m22120b = m22120b();
            if (m22120b == null || m22120b.get(IDataSource.f43973c) == null) {
                return;
            }
            Message obtain = Message.obtain();
            HashMap hashMap = new HashMap();
            hashMap.put("crashinfo", m22121a(th, (String) m22120b.get(RtspHeaders.Values.TIME)));
            hashMap.put(IDataSource.f43973c, m22120b.get(IDataSource.f43973c));
            obtain.obj = hashMap;
            obtain.what = 101;
            this.f30918a.sendMessage(obtain);
            m22123a(thread, th);
            return;
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f30920d;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    /* renamed from: a */
    private List<String> m22125a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
            Matcher matcher = Pattern.compile(str2).matcher(str);
            while (matcher.find()) {
                arrayList.add(matcher.group(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m22123a(Thread thread, Throwable th) {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Process.killProcess(Process.myPid());
    }
}
