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
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.stub.StubApp;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.util.LinkedList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: UMSLNetWorkSender.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final int f53530a = 273;

    /* renamed from: b  reason: collision with root package name */
    private static Context f53531b = null;

    /* renamed from: c  reason: collision with root package name */
    private static HandlerThread f53532c = null;

    /* renamed from: d  reason: collision with root package name */
    private static Handler f53533d = null;

    /* renamed from: f  reason: collision with root package name */
    private static final int f53535f = 274;

    /* renamed from: g  reason: collision with root package name */
    private static final int f53536g = 275;

    /* renamed from: h  reason: collision with root package name */
    private static final int f53537h = 512;

    /* renamed from: i  reason: collision with root package name */
    private static a f53538i;

    /* renamed from: j  reason: collision with root package name */
    private static IntentFilter f53539j;

    /* renamed from: k  reason: collision with root package name */
    private static volatile boolean f53540k;

    /* renamed from: e  reason: collision with root package name */
    private static Object f53534e = new Object();

    /* renamed from: l  reason: collision with root package name */
    private static LinkedList<String> f53541l = new LinkedList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: UMSLNetWorkSender.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a extends FileObserver {
        public a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i4, String str) {
            if ((i4 & 8) != 8) {
                return;
            }
            UMRTLog.i("MobclickRT", "--->>> envelope file created >>> " + str);
            b.a((int) MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_RES_FINSIH_TIME);
        }
    }

    public b(Context context) {
        synchronized (f53534e) {
            if (context != null) {
                try {
                    Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    f53531b = origApplicationContext;
                    if (origApplicationContext != null && f53532c == null) {
                        HandlerThread handlerThread = new HandlerThread("SL-NetWorkSender");
                        f53532c = handlerThread;
                        handlerThread.start();
                        if (f53538i == null) {
                            String str = f53531b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f53524f;
                            File file = new File(str);
                            if (!file.exists()) {
                                UMRTLog.e("MobclickRT", "--->>> 2\u53f7\u6570\u636e\u4ed3\u76ee\u5f55\u4e0d\u5b58\u5728\uff0c\u521b\u5efa\u4e4b\u3002");
                                file.mkdir();
                            }
                            a aVar = new a(str);
                            f53538i = aVar;
                            aVar.startWatching();
                            UMRTLog.e("MobclickRT", "--->>> 2\u53f7\u6570\u636e\u4ed3File Monitor\u542f\u52a8.");
                        }
                        if (f53533d == null) {
                            f53533d = new Handler(f53532c.getLooper()) { // from class: com.umeng.commonsdk.stateless.b.1
                                @Override // android.os.Handler
                                public void handleMessage(Message message) {
                                    int i4 = message.what;
                                    if (i4 != 512) {
                                        switch (i4) {
                                            case 273:
                                                b.l();
                                                return;
                                            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_RES_FINSIH_TIME /* 274 */:
                                                b.n();
                                                return;
                                            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME /* 275 */:
                                                b.p();
                                                break;
                                            default:
                                                return;
                                        }
                                    }
                                    b.q();
                                }
                            };
                        }
                    }
                }
            }
        }
    }

    public static void a(boolean z3) {
        f53540k = z3;
        if (z3) {
            UMRTLog.e("MobclickRT", "--->>>\u7f51\u7edc\u53ef\u7528\uff1a \u89e6\u53d12\u53f7\u6570\u636e\u4ed3\u4fe1\u5c01\u6d88\u8d39\u52a8\u4f5c\u3002");
            b(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_RES_FINSIH_TIME);
            return;
        }
        UMRTLog.e("MobclickRT", "--->>>\u7f51\u7edc\u65ad\u8fde\uff1a 2\u53f7\u6570\u636e\u4ed3");
    }

    public static void b(int i4) {
        Handler handler;
        try {
            if (!f53540k || (handler = f53533d) == null || handler.hasMessages(i4)) {
                return;
            }
            Message obtainMessage = f53533d.obtainMessage();
            obtainMessage.what = i4;
            f53533d.sendMessage(obtainMessage);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f53531b, th);
        }
    }

    public static void c() {
        b(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME);
    }

    public static void d() {
        b(512);
    }

    private static void i() {
        File[] c4 = d.c(f53531b);
        if (c4 != null) {
            if (f53541l.size() > 0) {
                f53541l.clear();
            }
            for (File file : c4) {
                f53541l.add(file.getAbsolutePath());
            }
        }
    }

    private static String j() {
        String str = null;
        try {
            String peek = f53541l.peek();
            if (peek != null) {
                try {
                    f53541l.removeFirst();
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
    private static void k() {
        String pollFirst;
        if (f53541l.size() <= 0) {
            UMRTLog.e("MobclickRT", "--->>> todoList\u65e0\u5185\u5bb9\uff0c\u65e0\u9700\u5904\u7406\u3002");
            return;
        }
        do {
            pollFirst = f53541l.pollFirst();
            if (!TextUtils.isEmpty(pollFirst)) {
                File file = new File(pollFirst);
                if (!file.exists()) {
                    UMRTLog.e("MobclickRT", "--->>> \u4fe1\u5c01\u6587\u4ef6\u4e0d\u5b58\u5728\uff0c\u5904\u7406\u4e0b\u4e00\u4e2a\u6587\u4ef6\u3002");
                    continue;
                } else {
                    c cVar = new c(f53531b);
                    byte[] bArr = null;
                    try {
                        bArr = d.a(pollFirst);
                    } catch (Exception unused) {
                    }
                    String name = file.getName();
                    String substring = !TextUtils.isEmpty(name) ? name.substring(0, 1) : "u";
                    String c4 = d.c(d.d(name));
                    if (cVar.a(bArr, c4, com.umeng.commonsdk.vchannel.a.f53819c.equalsIgnoreCase(c4) ? com.umeng.commonsdk.vchannel.a.f53817a : "", substring) && !file.delete()) {
                        file.delete();
                        continue;
                    }
                }
            }
        } while (pollFirst != null);
        f53541l.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        File a4;
        if (!f53540k || f53531b == null) {
            return;
        }
        do {
            try {
                a4 = d.a(f53531b);
                if (a4 != null && a4.getParentFile() != null && !TextUtils.isEmpty(a4.getParentFile().getName())) {
                    c cVar = new c(f53531b);
                    String str = new String(Base64.decode(a4.getParentFile().getName(), 0));
                    if (!"umpx_internal".equalsIgnoreCase(str) && !"umpx_crash".equalsIgnoreCase(str) && !"umpx_oplus_lbs".equalsIgnoreCase(str)) {
                        ULog.i("walle", "[stateless] handleProcessNext, pathUrl is " + str);
                        byte[] bArr = null;
                        try {
                            bArr = d.a(a4.getAbsolutePath());
                        } catch (Exception unused) {
                        }
                        String str2 = com.umeng.commonsdk.vchannel.a.f53819c.equalsIgnoreCase(str) ? com.umeng.commonsdk.vchannel.a.f53817a : "";
                        String str3 = UMServerURL.PATH_SHARE.equalsIgnoreCase(str) ? "s" : "u";
                        if (cVar.a(bArr, str, str2, (UMServerURL.PATH_PUSH_LAUNCH.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_REGIST.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_LOG.equalsIgnoreCase(str)) ? "p" : "p")) {
                            ULog.i("walle", "[stateless] Send envelope file success, delete it.");
                            File file = new File(a4.getAbsolutePath());
                            if (file.delete()) {
                                continue;
                            } else {
                                ULog.i("walle", "[stateless] Failed to delete already processed file. We try again after delete failed.");
                                file.delete();
                                continue;
                            }
                        } else {
                            ULog.i("walle", "[stateless] Send envelope file failed, abandon and wait next trigger!");
                            return;
                        }
                    }
                    new File(a4.getAbsolutePath()).delete();
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(f53531b, th);
            }
        } while (a4 != null);
        m();
    }

    private static void m() {
        try {
            File file = new File(f53531b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f53523e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e("MobclickRT", "--->>> 2\u53f7\u6570\u636e\u4ed3\uff1a\u5220\u9664stateless\u76ee\u5f55\u3002");
                d.a(file);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n() {
        if (!f53540k || f53531b == null) {
            return;
        }
        i();
        k();
        c();
    }

    private static void o() {
        try {
            File file = new File(f53531b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f53523e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e("MobclickRT", "--->>>2\u53f7\u6570\u636e\u4ed3\uff1a\u68c0\u6d4b\u5230stateless\u76ee\u5f55\u3002");
                b(273);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p() {
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q() {
    }

    public static boolean a() {
        synchronized (f53534e) {
            return f53538i != null;
        }
    }

    public static void b() {
        UMRTLog.e("MobclickRT", "--->>>\u4fe1\u5c01\u6784\u5efa\u6210\u529f\uff1a \u89e6\u53d12\u53f7\u6570\u636e\u4ed3\u4fe1\u5c01\u6d88\u8d39\u52a8\u4f5c\u3002");
        b(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_RES_FINSIH_TIME);
    }

    public static void a(int i4) {
        Handler handler;
        if (!f53540k || (handler = f53533d) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i4;
        f53533d.sendMessage(obtainMessage);
    }
}
