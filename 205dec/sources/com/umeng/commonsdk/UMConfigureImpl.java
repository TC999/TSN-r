package com.umeng.commonsdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.au;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.utils.onMessageSendListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class UMConfigureImpl {

    /* renamed from: e  reason: collision with root package name */
    private static final int f53284e = 1000;

    /* renamed from: f  reason: collision with root package name */
    private static ScheduledExecutorService f53285f;

    /* renamed from: g  reason: collision with root package name */
    private static Context f53286g;

    /* renamed from: a  reason: collision with root package name */
    private static String f53280a = au.b().b("dtfn");

    /* renamed from: b  reason: collision with root package name */
    private static CopyOnWriteArrayList<onMessageSendListener> f53281b = new CopyOnWriteArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private static int f53282c = 0;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f53283d = false;

    /* renamed from: h  reason: collision with root package name */
    private static int f53287h = 0;

    /* renamed from: i  reason: collision with root package name */
    private static Runnable f53288i = new Runnable() { // from class: com.umeng.commonsdk.UMConfigureImpl.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (UMConfigureImpl.f53282c == 0 || UMConfigureImpl.f53287h >= 10) {
                    if (!UMConfigureImpl.f53283d) {
                        boolean unused = UMConfigureImpl.f53283d = true;
                        UMConfigureImpl.b(UMConfigureImpl.f53286g);
                    }
                    if (UMConfigureImpl.f53285f != null) {
                        UMConfigureImpl.f53285f.shutdown();
                        ScheduledExecutorService unused2 = UMConfigureImpl.f53285f = null;
                    }
                }
                UMConfigureImpl.f();
            } catch (Exception unused3) {
            }
        }
    };

    static /* synthetic */ int f() {
        int i4 = f53287h;
        f53287h = i4 + 1;
        return i4;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        f53286g = context;
        try {
            if (f53282c >= 1) {
                if (!d(context)) {
                    UMEnvelopeBuild.setTransmissionSendFlag(false);
                    c(context);
                    if (f53285f == null) {
                        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
                        f53285f = newScheduledThreadPool;
                        newScheduledThreadPool.scheduleAtFixedRate(f53288i, 0L, 100L, TimeUnit.MILLISECONDS);
                    }
                } else {
                    UMEnvelopeBuild.setTransmissionSendFlag(true);
                }
            } else {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
            }
        } catch (Exception unused) {
        }
    }

    public static synchronized void registerInterruptFlag() {
        synchronized (UMConfigureImpl.class) {
            try {
                f53282c++;
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void registerMessageSendListener(onMessageSendListener onmessagesendlistener) {
        CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList;
        synchronized (UMConfigureImpl.class) {
            try {
                CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList2 = f53281b;
                if (copyOnWriteArrayList2 != null) {
                    copyOnWriteArrayList2.add(onmessagesendlistener);
                }
                if (UMEnvelopeBuild.getTransmissionSendFlag() && (copyOnWriteArrayList = f53281b) != null && copyOnWriteArrayList.size() > 0) {
                    Iterator<onMessageSendListener> it = f53281b.iterator();
                    while (it.hasNext()) {
                        it.next().onMessageSend();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void removeInterruptFlag() {
        synchronized (UMConfigureImpl.class) {
            try {
                f53282c--;
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void removeMessageSendListener(onMessageSendListener onmessagesendlistener) {
        synchronized (UMConfigureImpl.class) {
            try {
                CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList = f53281b;
                if (copyOnWriteArrayList != null) {
                    copyOnWriteArrayList.remove(onmessagesendlistener);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void b(Context context) {
        synchronized (UMConfigureImpl.class) {
            try {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
                CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList = f53281b;
                if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                    Iterator<onMessageSendListener> it = f53281b.iterator();
                    while (it.hasNext()) {
                        it.next().onMessageSend();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private static void c(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f53280a, 0);
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean(f53280a, true);
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean d(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f53280a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getBoolean(f53280a, false);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
