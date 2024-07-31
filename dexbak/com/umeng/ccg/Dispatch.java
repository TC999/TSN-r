package com.umeng.ccg;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.HashMap;

/* renamed from: com.umeng.ccg.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Dispatch {

    /* renamed from: a */
    public static final int f38556a = 101;

    /* renamed from: b */
    public static final int f38557b = 102;

    /* renamed from: c */
    public static final int f38558c = 103;

    /* renamed from: d */
    public static final int f38559d = 104;

    /* renamed from: e */
    public static final int f38560e = 105;

    /* renamed from: f */
    public static final int f38561f = 106;

    /* renamed from: g */
    public static final int f38562g = 107;

    /* renamed from: h */
    public static final int f38563h = 0;

    /* renamed from: i */
    public static final int f38564i = 1;

    /* renamed from: j */
    public static final int f38565j = 2;

    /* renamed from: k */
    public static final int f38566k = 201;

    /* renamed from: l */
    public static final int f38567l = 202;

    /* renamed from: m */
    public static final int f38568m = 203;

    /* renamed from: n */
    public static final int f38569n = 301;

    /* renamed from: o */
    public static final int f38570o = 302;

    /* renamed from: p */
    public static final int f38571p = 303;

    /* renamed from: q */
    private static HandlerThread f38572q = null;

    /* renamed from: r */
    private static Handler f38573r = null;

    /* renamed from: s */
    private static HashMap<Integer, InterfaceC13189a> f38574s = null;

    /* renamed from: t */
    private static final int f38575t = 256;

    /* compiled from: Dispatch.java */
    /* renamed from: com.umeng.ccg.c$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC13189a {
        /* renamed from: a */
        void mo14090a(Object obj, int i);
    }

    private Dispatch() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m14096b(Message message) {
        int i = message.arg1;
        Object obj = message.obj;
        Integer valueOf = Integer.valueOf(i / 100);
        HashMap<Integer, InterfaceC13189a> hashMap = f38574s;
        if (hashMap == null) {
            return;
        }
        InterfaceC13189a interfaceC13189a = hashMap.containsKey(valueOf) ? f38574s.get(valueOf) : null;
        if (interfaceC13189a != null) {
            interfaceC13189a.mo14090a(obj, i);
        }
    }

    /* renamed from: a */
    public static void m14100a(Context context, int i, int i2, InterfaceC13189a interfaceC13189a, Object obj, long j) {
        if (context == null || interfaceC13189a == null) {
            return;
        }
        if (f38574s == null) {
            f38574s = new HashMap<>();
        }
        Integer valueOf = Integer.valueOf(i2 / 100);
        if (!f38574s.containsKey(valueOf)) {
            f38574s.put(valueOf, interfaceC13189a);
        }
        if (f38572q == null || f38573r == null) {
            m14101a();
        }
        try {
            Handler handler = f38573r;
            if (handler != null) {
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = i;
                obtainMessage.arg1 = i2;
                obtainMessage.obj = obj;
                f38573r.sendMessageDelayed(obtainMessage, j);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static void m14099a(Context context, int i, InterfaceC13189a interfaceC13189a, Object obj) {
        m14100a(context, 256, i, interfaceC13189a, obj, 0L);
    }

    /* renamed from: a */
    public static void m14098a(Context context, int i, InterfaceC13189a interfaceC13189a, Object obj, long j) {
        m14100a(context, 256, i, interfaceC13189a, obj, j);
    }

    /* renamed from: a */
    private static synchronized void m14101a() {
        synchronized (Dispatch.class) {
            try {
                if (f38572q == null) {
                    HandlerThread handlerThread = new HandlerThread("ccg_dispatch");
                    f38572q = handlerThread;
                    handlerThread.start();
                    if (f38573r == null) {
                        f38573r = new Handler(f38572q.getLooper()) { // from class: com.umeng.ccg.c.1
                            @Override // android.os.Handler
                            public void handleMessage(Message message) {
                                if (message.what != 256) {
                                    return;
                                }
                                Dispatch.m14096b(message);
                            }
                        };
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
