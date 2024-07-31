package com.umeng.commonsdk.framework;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.kuaishou.weapon.p205p0.C7282g;
import com.stub.StubApp;
import com.tencent.connect.common.Constants;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.UMInternalConfig;
import com.umeng.commonsdk.internal.UMInternalData;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.NetWorkManager;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.umeng.commonsdk.framework.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UMNetWorkSender implements UMImprintChangeCallback {

    /* renamed from: a */
    private static HandlerThread f38751a = null;

    /* renamed from: b */
    private static Handler f38752b = null;

    /* renamed from: c */
    private static Handler f38753c = null;

    /* renamed from: d */
    private static final int f38754d = 200;

    /* renamed from: e */
    private static final int f38755e = 273;

    /* renamed from: f */
    private static final int f38756f = 274;

    /* renamed from: g */
    private static final int f38757g = 512;

    /* renamed from: h */
    private static final int f38758h = 769;

    /* renamed from: i */
    private static FileObserverC13222a f38759i = null;

    /* renamed from: j */
    private static ConnectivityManager f38760j = null;

    /* renamed from: k */
    private static IntentFilter f38761k = null;

    /* renamed from: l */
    private static volatile boolean f38762l = false;

    /* renamed from: m */
    private static ArrayList<UMSenderStateNotify> f38763m = null;

    /* renamed from: p */
    private static final String f38766p = "report_policy";

    /* renamed from: q */
    private static final String f38767q = "report_interval";

    /* renamed from: s */
    private static final int f38769s = 15;

    /* renamed from: t */
    private static final int f38770t = 3;

    /* renamed from: u */
    private static final int f38771u = 90;

    /* renamed from: x */
    private static BroadcastReceiver f38774x;

    /* renamed from: n */
    private static Object f38764n = new Object();

    /* renamed from: o */
    private static ReentrantLock f38765o = new ReentrantLock();

    /* renamed from: r */
    private static boolean f38768r = false;

    /* renamed from: v */
    private static int f38772v = 15;

    /* renamed from: w */
    private static Object f38773w = new Object();

    /* compiled from: UMNetWorkSender.java */
    /* renamed from: com.umeng.commonsdk.framework.a$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class FileObserverC13222a extends FileObserver {
        public FileObserverC13222a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, String str) {
            if ((i & 8) != 8) {
                return;
            }
            ULog.m13796d("--->>> envelope file created >>> " + str);
            UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            UMNetWorkSender.m13987c(273);
        }
    }

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            f38760j = (ConnectivityManager) appContext.getSystemService("connectivity");
        }
        f38774x = new BroadcastReceiver() { // from class: com.umeng.commonsdk.framework.a.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    UMWorkDispatch.sendEvent(context, UMInternalConfig.f38781E, UMInternalData.m13974a(context).m13975a(), null);
                }
            }
        };
    }

    public UMNetWorkSender(Context context, Handler handler) {
        if (f38760j == null) {
            Context appContext = UMGlobalContext.getAppContext();
            if (f38760j != null) {
                f38760j = (ConnectivityManager) appContext.getSystemService("connectivity");
            }
        }
        f38753c = handler;
        try {
            if (f38751a == null) {
                HandlerThread handlerThread = new HandlerThread("NetWorkSender");
                f38751a = handlerThread;
                handlerThread.start();
                if (f38759i == null) {
                    FileObserverC13222a fileObserverC13222a = new FileObserverC13222a(UMFrUtils.getEnvelopeDirPath(context));
                    f38759i = fileObserverC13222a;
                    fileObserverC13222a.startWatching();
                    ULog.m13796d("--->>> FileMonitor has already started!");
                }
                m13980j();
                if (f38752b == null) {
                    f38752b = new Handler(f38751a.getLooper()) { // from class: com.umeng.commonsdk.framework.a.3
                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            int i = message.what;
                            if (i == 273) {
                                ULog.m13796d("--->>> handleMessage: recv MSG_PROCESS_NEXT msg.");
                                try {
                                    UMNetWorkSender.f38765o.tryLock(1L, TimeUnit.SECONDS);
                                    try {
                                        UMNetWorkSender.m13976n();
                                    } catch (Throwable unused) {
                                    }
                                    UMNetWorkSender.f38765o.unlock();
                                } catch (Throwable unused2) {
                                }
                            } else if (i == UMNetWorkSender.f38756f) {
                                UMNetWorkSender.m13978l();
                            } else if (i != 512) {
                            } else {
                                UMNetWorkSender.m13977m();
                            }
                        }
                    };
                }
                ImprintHandler.getImprintService(context).registImprintCallback(f38766p, this);
                ImprintHandler.getImprintService(context).registImprintCallback(f38767q, this);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    /* renamed from: b */
    public static int m13991b() {
        int i;
        synchronized (f38773w) {
            i = f38772v;
        }
        return i;
    }

    /* renamed from: c */
    public static void m13988c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m13987c(int i) {
        Handler handler;
        if (!f38762l || (handler = f38752b) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i;
        f38752b.sendMessage(obtainMessage);
    }

    /* renamed from: d */
    public static void m13986d() {
        if (f38765o.tryLock()) {
            try {
                m13990b(273);
            } finally {
                f38765o.unlock();
            }
        }
    }

    /* renamed from: e */
    public static void m13985e() {
        m13996a((int) f38756f, 3000);
    }

    /* renamed from: j */
    private void m13980j() {
        synchronized (f38773w) {
            if (Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE.equals(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), f38766p, ""))) {
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                f38768r = true;
                f38772v = 15;
                int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), f38767q, Constants.VIA_REPORT_TYPE_WPA_STATE)).intValue();
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + intValue);
                if (intValue >= 3 && intValue <= 90) {
                    f38772v = intValue * 1000;
                }
                f38772v = 15;
            } else {
                f38768r = false;
            }
        }
    }

    /* renamed from: k */
    private static void m13979k() {
        if (f38751a != null) {
            f38751a = null;
        }
        if (f38752b != null) {
            f38752b = null;
        }
        if (f38753c != null) {
            f38753c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static void m13978l() {
        int size;
        synchronized (f38764n) {
            ArrayList<UMSenderStateNotify> arrayList = f38763m;
            if (arrayList != null && (size = arrayList.size()) > 0) {
                for (int i = 0; i < size; i++) {
                    f38763m.get(i).onSenderIdle();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public static void m13977m() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public static void m13976n() {
        ULog.m13796d("--->>> handleProcessNext: Enter...");
        if (f38762l) {
            Context appContext = UMModuleRegister.getAppContext();
            try {
                if (UMFrUtils.envelopeFileNumber(appContext) > 0) {
                    ULog.m13796d("--->>> The envelope file exists.");
                    if (UMFrUtils.envelopeFileNumber(appContext) > 200) {
                        ULog.m13796d("--->>> Number of envelope files is greater than 200, remove old files first.");
                        UMFrUtils.removeRedundantEnvelopeFiles(appContext, 200);
                    }
                    File envelopeFile = UMFrUtils.getEnvelopeFile(appContext);
                    if (envelopeFile != null) {
                        String path = envelopeFile.getPath();
                        ULog.m13796d("--->>> Ready to send envelope file [" + path + "].");
                        UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> send envelope file [ " + path + "].");
                        if (new NetWorkManager(appContext).m13829a(envelopeFile)) {
                            ULog.m13796d("--->>> Send envelope file success, delete it.");
                            if (!UMFrUtils.removeEnvelopeFile(envelopeFile)) {
                                ULog.m13796d("--->>> Failed to delete already processed file. We try again after delete failed.");
                                UMFrUtils.removeEnvelopeFile(envelopeFile);
                            }
                            m13987c(273);
                            return;
                        }
                        ULog.m13796d("--->>> Send envelope file failed, abandon and wait next trigger!");
                        return;
                    }
                }
                m13985e();
            } catch (Throwable th) {
                UMCrashManager.reportCrash(appContext, th);
            }
        }
    }

    @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
    public void onImprintValueChanged(String str, String str2) {
        synchronized (f38773w) {
            if (f38766p.equals(str)) {
                if (Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE.equals(str2)) {
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                    f38768r = true;
                } else {
                    f38768r = false;
                }
            }
            if (f38767q.equals(str)) {
                int intValue = Integer.valueOf(str2).intValue();
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + intValue);
                if (intValue >= 3 && intValue <= 90) {
                    f38772v = intValue * 1000;
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> really set report_interval value to: " + f38772v);
                }
                f38772v = 15000;
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> really set report_interval value to: " + f38772v);
            }
        }
    }

    /* renamed from: a */
    public static void m13994a(Context context) {
        if (f38760j != null || context == null) {
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        f38760j = connectivityManager;
        if (connectivityManager != null) {
            UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> createCMIfNeeded:注册网络状态监听器。");
            m13989b(context);
        }
    }

    @SuppressLint({"NewApi", "MissingPermission"})
    /* renamed from: b */
    public static void m13989b(Context context) {
        if (context == null) {
            UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> registerNetReceiver: context is null, registerNetReceiver failed.");
        } else if (Build.VERSION.SDK_INT >= 33) {
            if (DeviceConfig.checkPermission(context, C7282g.f24944b)) {
                NetworkRequest build = new NetworkRequest.Builder().addTransportType(0).addTransportType(1).build();
                if (f38760j != null) {
                    final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> 注册网络状态监听器:registerNetworkCallback");
                    f38760j.registerNetworkCallback(build, new ConnectivityManager.NetworkCallback() { // from class: com.umeng.commonsdk.framework.a.1
                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onAvailable(Network network) {
                            Context context2 = origApplicationContext;
                            UMWorkDispatch.sendEvent(context2, UMInternalConfig.f38781E, UMInternalData.m13974a(context2).m13975a(), null);
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                            super.onCapabilitiesChanged(network, networkCapabilities);
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onLost(Network network) {
                            UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> onLost");
                            Context context2 = origApplicationContext;
                            UMWorkDispatch.sendEvent(context2, UMInternalConfig.f38781E, UMInternalData.m13974a(context2).m13975a(), null, 2000L);
                        }
                    });
                    return;
                }
                return;
            }
            UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> ACCESS_NETWORK_STATE permission access denied.");
        } else if (DeviceConfig.checkPermission(context, C7282g.f24944b)) {
            if (f38760j == null || f38761k != null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            f38761k = intentFilter;
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            if (f38774x != null) {
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> 注册网络状态监听器:registerReceiver");
                context.registerReceiver(f38774x, f38761k);
            }
        } else {
            UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> ACCESS_NETWORK_STATE permission access denied.");
        }
    }

    /* renamed from: a */
    public static void m13993a(UMSenderStateNotify uMSenderStateNotify) {
        synchronized (f38764n) {
            if (f38763m == null) {
                f38763m = new ArrayList<>();
            }
            if (uMSenderStateNotify != null) {
                for (int i = 0; i < f38763m.size(); i++) {
                    if (uMSenderStateNotify == f38763m.get(i)) {
                        UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> addConnStateObserver: input item has exist.");
                        return;
                    }
                }
                f38763m.add(uMSenderStateNotify);
            }
        }
    }

    /* renamed from: a */
    public static boolean m13998a() {
        boolean z;
        synchronized (f38773w) {
            z = f38768r;
        }
        return z;
    }

    /* renamed from: a */
    public static void m13992a(boolean z) {
        int size;
        f38762l = z;
        if (z) {
            synchronized (f38764n) {
                ArrayList<UMSenderStateNotify> arrayList = f38763m;
                if (arrayList != null && (size = arrayList.size()) > 0) {
                    for (int i = 0; i < size; i++) {
                        f38763m.get(i).onConnectionAvailable();
                    }
                }
            }
            UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "网络状态通知：尝试发送 MSG_PROCESS_NEXT");
            m13986d();
            return;
        }
        ULog.m13784i("--->>> network disconnected.");
        f38762l = false;
    }

    /* renamed from: b */
    private static void m13990b(int i) {
        Handler handler;
        if (!f38762l || (handler = f38752b) == null || handler.hasMessages(i)) {
            return;
        }
        Message obtainMessage = f38752b.obtainMessage();
        obtainMessage.what = i;
        f38752b.sendMessage(obtainMessage);
    }

    /* renamed from: a */
    private static void m13995a(int i, long j) {
        Handler handler;
        if (!f38762l || (handler = f38752b) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i;
        UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> sendMsgDelayed: " + j);
        f38752b.sendMessageDelayed(obtainMessage, j);
    }

    /* renamed from: a */
    private static void m13996a(int i, int i2) {
        Handler handler;
        if (!f38762l || (handler = f38752b) == null) {
            return;
        }
        handler.removeMessages(i);
        Message obtainMessage = f38752b.obtainMessage();
        obtainMessage.what = i;
        f38752b.sendMessageDelayed(obtainMessage, i2);
    }
}
