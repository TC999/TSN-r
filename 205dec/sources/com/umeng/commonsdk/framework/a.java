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
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.stub.StubApp;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.b;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.c;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: UMNetWorkSender.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a implements UMImprintChangeCallback {

    /* renamed from: a  reason: collision with root package name */
    private static HandlerThread f53398a = null;

    /* renamed from: b  reason: collision with root package name */
    private static Handler f53399b = null;

    /* renamed from: c  reason: collision with root package name */
    private static Handler f53400c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final int f53401d = 200;

    /* renamed from: e  reason: collision with root package name */
    private static final int f53402e = 273;

    /* renamed from: f  reason: collision with root package name */
    private static final int f53403f = 274;

    /* renamed from: g  reason: collision with root package name */
    private static final int f53404g = 512;

    /* renamed from: h  reason: collision with root package name */
    private static final int f53405h = 769;

    /* renamed from: i  reason: collision with root package name */
    private static FileObserverC1058a f53406i = null;

    /* renamed from: j  reason: collision with root package name */
    private static ConnectivityManager f53407j = null;

    /* renamed from: k  reason: collision with root package name */
    private static IntentFilter f53408k = null;

    /* renamed from: l  reason: collision with root package name */
    private static volatile boolean f53409l = false;

    /* renamed from: m  reason: collision with root package name */
    private static ArrayList<UMSenderStateNotify> f53410m = null;

    /* renamed from: p  reason: collision with root package name */
    private static final String f53413p = "report_policy";

    /* renamed from: q  reason: collision with root package name */
    private static final String f53414q = "report_interval";

    /* renamed from: s  reason: collision with root package name */
    private static final int f53416s = 15;

    /* renamed from: t  reason: collision with root package name */
    private static final int f53417t = 3;

    /* renamed from: u  reason: collision with root package name */
    private static final int f53418u = 90;

    /* renamed from: x  reason: collision with root package name */
    private static BroadcastReceiver f53421x;

    /* renamed from: n  reason: collision with root package name */
    private static Object f53411n = new Object();

    /* renamed from: o  reason: collision with root package name */
    private static ReentrantLock f53412o = new ReentrantLock();

    /* renamed from: r  reason: collision with root package name */
    private static boolean f53415r = false;

    /* renamed from: v  reason: collision with root package name */
    private static int f53419v = 15;

    /* renamed from: w  reason: collision with root package name */
    private static Object f53420w = new Object();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: UMNetWorkSender.java */
    /* renamed from: com.umeng.commonsdk.framework.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static class FileObserverC1058a extends FileObserver {
        public FileObserverC1058a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i4, String str) {
            if ((i4 & 8) != 8) {
                return;
            }
            ULog.d("--->>> envelope file created >>> " + str);
            UMRTLog.i("MobclickRT", "--->>> envelope file created >>> " + str);
            a.c(273);
        }
    }

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            f53407j = (ConnectivityManager) appContext.getSystemService("connectivity");
        }
        f53421x = new BroadcastReceiver() { // from class: com.umeng.commonsdk.framework.a.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    UMWorkDispatch.sendEvent(context, 32803, b.a(context).a(), null);
                }
            }
        };
    }

    public a(Context context, Handler handler) {
        if (f53407j == null) {
            Context appContext = UMGlobalContext.getAppContext();
            if (f53407j != null) {
                f53407j = (ConnectivityManager) appContext.getSystemService("connectivity");
            }
        }
        f53400c = handler;
        try {
            if (f53398a == null) {
                HandlerThread handlerThread = new HandlerThread("NetWorkSender");
                f53398a = handlerThread;
                handlerThread.start();
                if (f53406i == null) {
                    FileObserverC1058a fileObserverC1058a = new FileObserverC1058a(UMFrUtils.getEnvelopeDirPath(context));
                    f53406i = fileObserverC1058a;
                    fileObserverC1058a.startWatching();
                    ULog.d("--->>> FileMonitor has already started!");
                }
                j();
                if (f53399b == null) {
                    f53399b = new Handler(f53398a.getLooper()) { // from class: com.umeng.commonsdk.framework.a.3
                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            int i4 = message.what;
                            if (i4 == 273) {
                                ULog.d("--->>> handleMessage: recv MSG_PROCESS_NEXT msg.");
                                try {
                                    a.f53412o.tryLock(1L, TimeUnit.SECONDS);
                                    try {
                                        a.n();
                                    } catch (Throwable unused) {
                                    }
                                    a.f53412o.unlock();
                                } catch (Throwable unused2) {
                                }
                            } else if (i4 == 274) {
                                a.l();
                            } else if (i4 != 512) {
                            } else {
                                a.m();
                            }
                        }
                    };
                }
                ImprintHandler.getImprintService(context).registImprintCallback("report_policy", this);
                ImprintHandler.getImprintService(context).registImprintCallback("report_interval", this);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static int b() {
        int i4;
        synchronized (f53420w) {
            i4 = f53419v;
        }
        return i4;
    }

    public static void c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(int i4) {
        Handler handler;
        if (!f53409l || (handler = f53399b) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i4;
        f53399b.sendMessage(obtainMessage);
    }

    public static void d() {
        if (f53412o.tryLock()) {
            try {
                b(273);
            } finally {
                f53412o.unlock();
            }
        }
    }

    public static void e() {
        a((int) MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_RES_FINSIH_TIME, 3000);
    }

    private void j() {
        synchronized (f53420w) {
            if ("11".equals(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), "report_policy", ""))) {
                UMRTLog.i("MobclickRT", "--->>> switch to report_policy 11");
                f53415r = true;
                f53419v = 15;
                int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), "report_interval", "15")).intValue();
                UMRTLog.i("MobclickRT", "--->>> set report_interval value to: " + intValue);
                if (intValue >= 3 && intValue <= 90) {
                    f53419v = intValue * 1000;
                }
                f53419v = 15;
            } else {
                f53415r = false;
            }
        }
    }

    private static void k() {
        if (f53398a != null) {
            f53398a = null;
        }
        if (f53399b != null) {
            f53399b = null;
        }
        if (f53400c != null) {
            f53400c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        int size;
        synchronized (f53411n) {
            ArrayList<UMSenderStateNotify> arrayList = f53410m;
            if (arrayList != null && (size = arrayList.size()) > 0) {
                for (int i4 = 0; i4 < size; i4++) {
                    f53410m.get(i4).onSenderIdle();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n() {
        ULog.d("--->>> handleProcessNext: Enter...");
        if (f53409l) {
            Context appContext = UMModuleRegister.getAppContext();
            try {
                if (UMFrUtils.envelopeFileNumber(appContext) > 0) {
                    ULog.d("--->>> The envelope file exists.");
                    if (UMFrUtils.envelopeFileNumber(appContext) > 200) {
                        ULog.d("--->>> Number of envelope files is greater than 200, remove old files first.");
                        UMFrUtils.removeRedundantEnvelopeFiles(appContext, 200);
                    }
                    File envelopeFile = UMFrUtils.getEnvelopeFile(appContext);
                    if (envelopeFile != null) {
                        String path = envelopeFile.getPath();
                        ULog.d("--->>> Ready to send envelope file [" + path + "].");
                        UMRTLog.i("MobclickRT", "--->>> send envelope file [ " + path + "].");
                        if (new c(appContext).a(envelopeFile)) {
                            ULog.d("--->>> Send envelope file success, delete it.");
                            if (!UMFrUtils.removeEnvelopeFile(envelopeFile)) {
                                ULog.d("--->>> Failed to delete already processed file. We try again after delete failed.");
                                UMFrUtils.removeEnvelopeFile(envelopeFile);
                            }
                            c(273);
                            return;
                        }
                        ULog.d("--->>> Send envelope file failed, abandon and wait next trigger!");
                        return;
                    }
                }
                e();
            } catch (Throwable th) {
                UMCrashManager.reportCrash(appContext, th);
            }
        }
    }

    @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
    public void onImprintValueChanged(String str, String str2) {
        synchronized (f53420w) {
            if ("report_policy".equals(str)) {
                if ("11".equals(str2)) {
                    UMRTLog.i("MobclickRT", "--->>> switch to report_policy 11");
                    f53415r = true;
                } else {
                    f53415r = false;
                }
            }
            if ("report_interval".equals(str)) {
                int intValue = Integer.valueOf(str2).intValue();
                UMRTLog.i("MobclickRT", "--->>> set report_interval value to: " + intValue);
                if (intValue >= 3 && intValue <= 90) {
                    f53419v = intValue * 1000;
                    UMRTLog.i("MobclickRT", "--->>> really set report_interval value to: " + f53419v);
                }
                f53419v = 15000;
                UMRTLog.i("MobclickRT", "--->>> really set report_interval value to: " + f53419v);
            }
        }
    }

    public static void a(Context context) {
        if (f53407j != null || context == null) {
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        f53407j = connectivityManager;
        if (connectivityManager != null) {
            UMRTLog.i("MobclickRT", "--->>> createCMIfNeeded:\u6ce8\u518c\u7f51\u7edc\u72b6\u6001\u76d1\u542c\u5668\u3002");
            b(context);
        }
    }

    @SuppressLint({"NewApi", "MissingPermission"})
    public static void b(Context context) {
        if (context == null) {
            UMRTLog.e("MobclickRT", "--->>> registerNetReceiver: context is null, registerNetReceiver failed.");
        } else if (Build.VERSION.SDK_INT >= 33) {
            if (DeviceConfig.checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                NetworkRequest build = new NetworkRequest.Builder().addTransportType(0).addTransportType(1).build();
                if (f53407j != null) {
                    final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    UMRTLog.i("MobclickRT", "--->>> \u6ce8\u518c\u7f51\u7edc\u72b6\u6001\u76d1\u542c\u5668:registerNetworkCallback");
                    f53407j.registerNetworkCallback(build, new ConnectivityManager.NetworkCallback() { // from class: com.umeng.commonsdk.framework.a.1
                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onAvailable(Network network) {
                            Context context2 = origApplicationContext;
                            UMWorkDispatch.sendEvent(context2, 32803, b.a(context2).a(), null);
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                            super.onCapabilitiesChanged(network, networkCapabilities);
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onLost(Network network) {
                            UMRTLog.i("MobclickRT", "--->>> onLost");
                            Context context2 = origApplicationContext;
                            UMWorkDispatch.sendEvent(context2, 32803, b.a(context2).a(), null, 2000L);
                        }
                    });
                    return;
                }
                return;
            }
            UMRTLog.i("MobclickRT", "--->>> ACCESS_NETWORK_STATE permission access denied.");
        } else if (DeviceConfig.checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            if (f53407j == null || f53408k != null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            f53408k = intentFilter;
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            if (f53421x != null) {
                UMRTLog.i("MobclickRT", "--->>> \u6ce8\u518c\u7f51\u7edc\u72b6\u6001\u76d1\u542c\u5668:registerReceiver");
                context.registerReceiver(f53421x, f53408k);
            }
        } else {
            UMRTLog.i("MobclickRT", "--->>> ACCESS_NETWORK_STATE permission access denied.");
        }
    }

    public static void a(UMSenderStateNotify uMSenderStateNotify) {
        synchronized (f53411n) {
            if (f53410m == null) {
                f53410m = new ArrayList<>();
            }
            if (uMSenderStateNotify != null) {
                for (int i4 = 0; i4 < f53410m.size(); i4++) {
                    if (uMSenderStateNotify == f53410m.get(i4)) {
                        UMRTLog.i("MobclickRT", "--->>> addConnStateObserver: input item has exist.");
                        return;
                    }
                }
                f53410m.add(uMSenderStateNotify);
            }
        }
    }

    public static boolean a() {
        boolean z3;
        synchronized (f53420w) {
            z3 = f53415r;
        }
        return z3;
    }

    public static void a(boolean z3) {
        int size;
        f53409l = z3;
        if (z3) {
            synchronized (f53411n) {
                ArrayList<UMSenderStateNotify> arrayList = f53410m;
                if (arrayList != null && (size = arrayList.size()) > 0) {
                    for (int i4 = 0; i4 < size; i4++) {
                        f53410m.get(i4).onConnectionAvailable();
                    }
                }
            }
            UMRTLog.e("MobclickRT", "\u7f51\u7edc\u72b6\u6001\u901a\u77e5\uff1a\u5c1d\u8bd5\u53d1\u9001 MSG_PROCESS_NEXT");
            d();
            return;
        }
        ULog.i("--->>> network disconnected.");
        f53409l = false;
    }

    private static void b(int i4) {
        Handler handler;
        if (!f53409l || (handler = f53399b) == null || handler.hasMessages(i4)) {
            return;
        }
        Message obtainMessage = f53399b.obtainMessage();
        obtainMessage.what = i4;
        f53399b.sendMessage(obtainMessage);
    }

    private static void a(int i4, long j4) {
        Handler handler;
        if (!f53409l || (handler = f53399b) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i4;
        UMRTLog.i("MobclickRT", "--->>> sendMsgDelayed: " + j4);
        f53399b.sendMessageDelayed(obtainMessage, j4);
    }

    private static void a(int i4, int i5) {
        Handler handler;
        if (!f53409l || (handler = f53399b) == null) {
            return;
        }
        handler.removeMessages(i4);
        Message obtainMessage = f53399b.obtainMessage();
        obtainMessage.what = i4;
        f53399b.sendMessageDelayed(obtainMessage, i5);
    }
}
