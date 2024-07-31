package com.umeng.commonsdk.stateless;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.IntentFilter;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.stub.StubApp;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.UMInternalConfig;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.vchannel.Constant;
import java.io.File;
import java.util.LinkedList;

/* renamed from: com.umeng.commonsdk.stateless.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UMSLNetWorkSender {

    /* renamed from: a */
    public static final int f38894a = 273;

    /* renamed from: b */
    private static Context f38895b = null;

    /* renamed from: c */
    private static HandlerThread f38896c = null;

    /* renamed from: d */
    private static Handler f38897d = null;

    /* renamed from: f */
    private static final int f38899f = 274;

    /* renamed from: g */
    private static final int f38900g = 275;

    /* renamed from: h */
    private static final int f38901h = 512;

    /* renamed from: i */
    private static FileObserverC13239a f38902i;

    /* renamed from: j */
    private static IntentFilter f38903j;

    /* renamed from: k */
    private static volatile boolean f38904k;

    /* renamed from: e */
    private static Object f38898e = new Object();

    /* renamed from: l */
    private static LinkedList<String> f38905l = new LinkedList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UMSLNetWorkSender.java */
    /* renamed from: com.umeng.commonsdk.stateless.b$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class FileObserverC13239a extends FileObserver {
        public FileObserverC13239a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, String str) {
            if ((i & 8) != 8) {
                return;
            }
            UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            UMSLNetWorkSender.m13887a((int) UMSLNetWorkSender.f38899f);
        }
    }

    public UMSLNetWorkSender(Context context) {
        synchronized (f38898e) {
            if (context != null) {
                try {
                    Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    f38895b = origApplicationContext;
                    if (origApplicationContext != null && f38896c == null) {
                        HandlerThread handlerThread = new HandlerThread("SL-NetWorkSender");
                        f38896c = handlerThread;
                        handlerThread.start();
                        if (f38902i == null) {
                            String str = f38895b.getFilesDir() + File.separator + UMSLConfig.f38888f;
                            File file = new File(str);
                            if (!file.exists()) {
                                UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓目录不存在，创建之。");
                                file.mkdir();
                            }
                            FileObserverC13239a fileObserverC13239a = new FileObserverC13239a(str);
                            f38902i = fileObserverC13239a;
                            fileObserverC13239a.startWatching();
                            UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓File Monitor启动.");
                        }
                        if (f38897d == null) {
                            f38897d = new Handler(f38896c.getLooper()) { // from class: com.umeng.commonsdk.stateless.b.1
                                @Override // android.os.Handler
                                public void handleMessage(Message message) {
                                    int i = message.what;
                                    if (i != 512) {
                                        switch (i) {
                                            case UMSLNetWorkSender.f38894a /* 273 */:
                                                UMSLNetWorkSender.m13874l();
                                                return;
                                            case UMSLNetWorkSender.f38899f /* 274 */:
                                                UMSLNetWorkSender.m13872n();
                                                return;
                                            case UMSLNetWorkSender.f38900g /* 275 */:
                                                UMSLNetWorkSender.m13870p();
                                                break;
                                            default:
                                                return;
                                        }
                                    }
                                    UMSLNetWorkSender.m13869q();
                                }
                            };
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static void m13886a(boolean z) {
        f38904k = z;
        if (z) {
            UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>>网络可用： 触发2号数据仓信封消费动作。");
            m13884b(f38899f);
            return;
        }
        UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>>网络断连： 2号数据仓");
    }

    /* renamed from: b */
    public static void m13884b(int i) {
        Handler handler;
        try {
            if (!f38904k || (handler = f38897d) == null || handler.hasMessages(i)) {
                return;
            }
            Message obtainMessage = f38897d.obtainMessage();
            obtainMessage.what = i;
            f38897d.sendMessage(obtainMessage);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f38895b, th);
        }
    }

    /* renamed from: c */
    public static void m13883c() {
        m13884b(f38900g);
    }

    /* renamed from: d */
    public static void m13882d() {
        m13884b(512);
    }

    /* renamed from: i */
    private static void m13877i() {
        File[] m13852c = UMSLUtils.m13852c(f38895b);
        if (m13852c != null) {
            if (f38905l.size() > 0) {
                f38905l.clear();
            }
            for (File file : m13852c) {
                f38905l.add(file.getAbsolutePath());
            }
        }
    }

    /* renamed from: j */
    private static String m13876j() {
        String str = null;
        try {
            String peek = f38905l.peek();
            if (peek != null) {
                try {
                    f38905l.removeFirst();
                    return peek;
                } catch (Throwable unused) {
                    str = peek;
                    return str;
                }
            }
            return peek;
        } catch (Throwable unused2) {
        }
    }

    @TargetApi(9)
    /* renamed from: k */
    private static void m13875k() {
        String pollFirst;
        if (f38905l.size() <= 0) {
            UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> todoList无内容，无需处理。");
            return;
        }
        do {
            pollFirst = f38905l.pollFirst();
            if (!TextUtils.isEmpty(pollFirst)) {
                File file = new File(pollFirst);
                if (!file.exists()) {
                    UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> 信封文件不存在，处理下一个文件。");
                    continue;
                } else {
                    UMSLNetWorkSenderHelper uMSLNetWorkSenderHelper = new UMSLNetWorkSenderHelper(f38895b);
                    byte[] bArr = null;
                    try {
                        bArr = UMSLUtils.m13858a(pollFirst);
                    } catch (Exception unused) {
                    }
                    String name = file.getName();
                    String substring = !TextUtils.isEmpty(name) ? name.substring(0, 1) : "u";
                    String m13851c = UMSLUtils.m13851c(UMSLUtils.m13850d(name));
                    if (uMSLNetWorkSenderHelper.m13867a(bArr, m13851c, Constant.f39229c.equalsIgnoreCase(m13851c) ? Constant.f39227a : "", substring) && !file.delete()) {
                        file.delete();
                        continue;
                    }
                }
            }
        } while (pollFirst != null);
        f38905l.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static void m13874l() {
        File m13864a;
        if (!f38904k || f38895b == null) {
            return;
        }
        do {
            try {
                m13864a = UMSLUtils.m13864a(f38895b);
                if (m13864a != null && m13864a.getParentFile() != null && !TextUtils.isEmpty(m13864a.getParentFile().getName())) {
                    UMSLNetWorkSenderHelper uMSLNetWorkSenderHelper = new UMSLNetWorkSenderHelper(f38895b);
                    String str = new String(Base64.decode(m13864a.getParentFile().getName(), 0));
                    if (!UMInternalConfig.f38789a.equalsIgnoreCase(str) && !UMInternalConfig.f38790b.equalsIgnoreCase(str) && !UMInternalConfig.f38784H.equalsIgnoreCase(str)) {
                        ULog.m13781i("walle", "[stateless] handleProcessNext, pathUrl is " + str);
                        byte[] bArr = null;
                        try {
                            bArr = UMSLUtils.m13858a(m13864a.getAbsolutePath());
                        } catch (Exception unused) {
                        }
                        String str2 = Constant.f39229c.equalsIgnoreCase(str) ? Constant.f39227a : "";
                        String str3 = UMServerURL.PATH_SHARE.equalsIgnoreCase(str) ? "s" : "u";
                        if (uMSLNetWorkSenderHelper.m13867a(bArr, str, str2, (UMServerURL.PATH_PUSH_LAUNCH.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_REGIST.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_LOG.equalsIgnoreCase(str)) ? "p" : "p")) {
                            ULog.m13781i("walle", "[stateless] Send envelope file success, delete it.");
                            File file = new File(m13864a.getAbsolutePath());
                            if (file.delete()) {
                                continue;
                            } else {
                                ULog.m13781i("walle", "[stateless] Failed to delete already processed file. We try again after delete failed.");
                                file.delete();
                                continue;
                            }
                        } else {
                            ULog.m13781i("walle", "[stateless] Send envelope file failed, abandon and wait next trigger!");
                            return;
                        }
                    }
                    new File(m13864a.getAbsolutePath()).delete();
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(f38895b, th);
            }
        } while (m13864a != null);
        m13873m();
    }

    /* renamed from: m */
    private static void m13873m() {
        try {
            File file = new File(f38895b.getFilesDir() + File.separator + UMSLConfig.f38887e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓：删除stateless目录。");
                UMSLUtils.m13859a(file);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public static void m13872n() {
        if (!f38904k || f38895b == null) {
            return;
        }
        m13877i();
        m13875k();
        m13883c();
    }

    /* renamed from: o */
    private static void m13871o() {
        try {
            File file = new File(f38895b.getFilesDir() + File.separator + UMSLConfig.f38887e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>>2号数据仓：检测到stateless目录。");
                m13884b(f38894a);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public static void m13870p() {
        m13871o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public static void m13869q() {
    }

    /* renamed from: a */
    public static boolean m13888a() {
        synchronized (f38898e) {
            return f38902i != null;
        }
    }

    /* renamed from: b */
    public static void m13885b() {
        UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>>信封构建成功： 触发2号数据仓信封消费动作。");
        m13884b(f38899f);
    }

    /* renamed from: a */
    public static void m13887a(int i) {
        Handler handler;
        if (!f38904k || (handler = f38897d) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i;
        f38897d.sendMessage(obtainMessage);
    }
}
