package com.umeng.ccg;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: Dispatch.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f53227a = 101;

    /* renamed from: b  reason: collision with root package name */
    public static final int f53228b = 102;

    /* renamed from: c  reason: collision with root package name */
    public static final int f53229c = 103;

    /* renamed from: d  reason: collision with root package name */
    public static final int f53230d = 104;

    /* renamed from: e  reason: collision with root package name */
    public static final int f53231e = 105;

    /* renamed from: f  reason: collision with root package name */
    public static final int f53232f = 106;

    /* renamed from: g  reason: collision with root package name */
    public static final int f53233g = 107;

    /* renamed from: h  reason: collision with root package name */
    public static final int f53234h = 0;

    /* renamed from: i  reason: collision with root package name */
    public static final int f53235i = 1;

    /* renamed from: j  reason: collision with root package name */
    public static final int f53236j = 2;

    /* renamed from: k  reason: collision with root package name */
    public static final int f53237k = 201;

    /* renamed from: l  reason: collision with root package name */
    public static final int f53238l = 202;

    /* renamed from: m  reason: collision with root package name */
    public static final int f53239m = 203;

    /* renamed from: n  reason: collision with root package name */
    public static final int f53240n = 301;

    /* renamed from: o  reason: collision with root package name */
    public static final int f53241o = 302;

    /* renamed from: p  reason: collision with root package name */
    public static final int f53242p = 303;

    /* renamed from: q  reason: collision with root package name */
    private static HandlerThread f53243q = null;

    /* renamed from: r  reason: collision with root package name */
    private static Handler f53244r = null;

    /* renamed from: s  reason: collision with root package name */
    private static HashMap<Integer, a> f53245s = null;

    /* renamed from: t  reason: collision with root package name */
    private static final int f53246t = 256;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: Dispatch.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface a {
        void a(Object obj, int i4);
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Message message) {
        int i4 = message.arg1;
        Object obj = message.obj;
        Integer valueOf = Integer.valueOf(i4 / 100);
        HashMap<Integer, a> hashMap = f53245s;
        if (hashMap == null) {
            return;
        }
        a aVar = hashMap.containsKey(valueOf) ? f53245s.get(valueOf) : null;
        if (aVar != null) {
            aVar.a(obj, i4);
        }
    }

    public static void a(Context context, int i4, int i5, a aVar, Object obj, long j4) {
        if (context == null || aVar == null) {
            return;
        }
        if (f53245s == null) {
            f53245s = new HashMap<>();
        }
        Integer valueOf = Integer.valueOf(i5 / 100);
        if (!f53245s.containsKey(valueOf)) {
            f53245s.put(valueOf, aVar);
        }
        if (f53243q == null || f53244r == null) {
            a();
        }
        try {
            Handler handler = f53244r;
            if (handler != null) {
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = i4;
                obtainMessage.arg1 = i5;
                obtainMessage.obj = obj;
                f53244r.sendMessageDelayed(obtainMessage, j4);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, int i4, a aVar, Object obj) {
        a(context, 256, i4, aVar, obj, 0L);
    }

    public static void a(Context context, int i4, a aVar, Object obj, long j4) {
        a(context, 256, i4, aVar, obj, j4);
    }

    private static synchronized void a() {
        synchronized (c.class) {
            try {
                if (f53243q == null) {
                    HandlerThread handlerThread = new HandlerThread("ccg_dispatch");
                    f53243q = handlerThread;
                    handlerThread.start();
                    if (f53244r == null) {
                        f53244r = new Handler(f53243q.getLooper()) { // from class: com.umeng.ccg.c.1
                            @Override // android.os.Handler
                            public void handleMessage(Message message) {
                                if (message.what != 256) {
                                    return;
                                }
                                c.b(message);
                            }
                        };
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
