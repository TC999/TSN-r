package com.beizi.fusion.p072g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.baidu.mobads.sdk.internal.C2624bk;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.model.ResponseInfo;
import com.beizi.fusion.p066d.AdManager;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.stub.StubApp;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.Date;
import master.flame.danmaku.danmaku.parser.IDataSource;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.beizi.fusion.g.r */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CrashHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private static CrashHandler f11409a = new CrashHandler();

    /* renamed from: b */
    private Thread.UncaughtExceptionHandler f11410b;

    /* renamed from: c */
    private Context f11411c;

    private CrashHandler() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m48221b(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
        }
        printWriter.close();
        String obj = stringWriter.toString();
        m48224a(obj);
        m48222b(obj);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            m48223a(th);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f11410b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            Process.killProcess(Process.myPid());
        }
    }

    /* renamed from: a */
    public static CrashHandler m48227a() {
        return f11409a;
    }

    /* renamed from: a */
    public void m48226a(Context context) {
        this.f11410b = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f11411c = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    /* renamed from: a */
    private void m48224a(String str) {
        String m48267a;
        String m48507a;
        try {
            PackageInfo packageInfo = this.f11411c.getPackageManager().getPackageInfo(this.f11411c.getPackageName(), 1);
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("appId", AdManager.m48786a().m48782b());
            jSONObject.put(TTDownloadField.TT_PACKAGE_NAME, this.f11411c.getPackageName());
            jSONObject.put(TTDownloadField.TT_VERSION_NAME, packageInfo.versionName);
            jSONObject.put(TTDownloadField.TT_VERSION_CODE, String.valueOf(packageInfo.versionCode));
            jSONObject.put("sdkVersion", "4.90.4.5");
            jSONObject2.put("osVersion", Build.VERSION.RELEASE + "_" + Build.VERSION.SDK_INT);
            jSONObject2.put("vendor", Build.MANUFACTURER);
            jSONObject2.put(C2624bk.f8685i, Build.MODEL);
            jSONObject.put(ConstantHelper.LOG_DE, jSONObject2);
            jSONObject.put("crashMessage", str);
            if (!TextUtils.isEmpty(ResponseInfo.getInstance(this.f11411c).getCrashUrl()) && ResponseInfo.getInstance(this.f11411c).getCrashUrl().startsWith(IDataSource.f43971a)) {
                m48267a = ResponseInfo.getInstance(this.f11411c).getCrashUrl();
            } else {
                m48267a = C3144f.m48267a(BeiZis.getTransferProtocol() ? "aHR0cHM6Ly9hcGktaHRwLmJlaXppLmJpei9tYi9zZGsvY3Jhc2gvdjE=" : "aHR0cDovL2FwaS5odHAuYWQtc2NvcGUuY29tLmNuOjQ1NjAwL21iL3Nkay9jcmFzaC92MQ==");
                if (TextUtils.isEmpty(m48267a)) {
                    return;
                }
            }
            if (TextUtils.isEmpty(m48267a) || (m48507a = HttpUtil.m48507a(m48267a, jSONObject.toString().getBytes())) == null) {
                return;
            }
            C3116af.m48496a("lance", "post:" + m48507a);
        } catch (PackageManager.NameNotFoundException e) {
            e = e;
            e.printStackTrace();
        } catch (JSONException e2) {
            e = e2;
            e.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m48222b(String str) {
        Context context;
        try {
            context = this.f11411c;
        } catch (Exception unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (context == null) {
            return;
        }
        File m48244a = BeiZiStorageUtils.m48244a(context);
        C3116af.m48496a("BeiZis", "CrashHandler storagePath == " + m48244a);
        if (m48244a != null) {
            String str2 = m48244a.getPath() + "/Beizi/log/";
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            String format = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS").format(new Date(System.currentTimeMillis()));
            File file2 = new File(str2 + "crash_" + format + ".trace");
            file2.createNewFile();
            FileWriter fileWriter = new FileWriter(file2, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(format);
            bufferedWriter.write("\r\n");
            bufferedWriter.write("------------------crash----------------------");
            bufferedWriter.write("\r\n");
            bufferedWriter.write(str);
            bufferedWriter.write("\r\n");
            bufferedWriter.write("-------------------end-----------------------");
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        }
        C3116af.m48496a("lance", "writeLog ok");
    }

    /* renamed from: a */
    private boolean m48223a(final Throwable th) {
        if (th == null) {
            return false;
        }
        new Thread(new Runnable() { // from class: com.beizi.fusion.g.r.1
            @Override // java.lang.Runnable
            public void run() {
                Looper.prepare();
                CrashHandler.this.m48221b(th);
                Looper.loop();
            }
        }).start();
        try {
            Thread.sleep(1000L);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return true;
        }
    }
}
