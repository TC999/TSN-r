package com.umeng.commonsdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.PathCenter;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.utils.onMessageSendListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UMConfigureImpl {

    /* renamed from: e */
    private static final int f38613e = 1000;

    /* renamed from: f */
    private static ScheduledExecutorService f38614f;

    /* renamed from: g */
    private static Context f38615g;

    /* renamed from: a */
    private static String f38609a = PathCenter.m14695b().m14694b(PathCenter.f37696o);

    /* renamed from: b */
    private static CopyOnWriteArrayList<onMessageSendListener> f38610b = new CopyOnWriteArrayList<>();

    /* renamed from: c */
    private static int f38611c = 0;

    /* renamed from: d */
    private static boolean f38612d = false;

    /* renamed from: h */
    private static int f38616h = 0;

    /* renamed from: i */
    private static Runnable f38617i = new Runnable() { // from class: com.umeng.commonsdk.UMConfigureImpl.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (UMConfigureImpl.f38611c == 0 || UMConfigureImpl.f38616h >= 10) {
                    if (!UMConfigureImpl.f38612d) {
                        boolean unused = UMConfigureImpl.f38612d = true;
                        UMConfigureImpl.m14043b(UMConfigureImpl.f38615g);
                    }
                    if (UMConfigureImpl.f38614f != null) {
                        UMConfigureImpl.f38614f.shutdown();
                        ScheduledExecutorService unused2 = UMConfigureImpl.f38614f = null;
                    }
                }
                UMConfigureImpl.m14037f();
            } catch (Exception unused3) {
            }
        }
    };

    /* renamed from: f */
    static /* synthetic */ int m14037f() {
        int i = f38616h;
        f38616h = i + 1;
        return i;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        f38615g = context;
        try {
            if (f38611c >= 1) {
                if (!m14039d(context)) {
                    UMEnvelopeBuild.setTransmissionSendFlag(false);
                    m14041c(context);
                    if (f38614f == null) {
                        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
                        f38614f = newScheduledThreadPool;
                        newScheduledThreadPool.scheduleAtFixedRate(f38617i, 0L, 100L, TimeUnit.MILLISECONDS);
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
                f38611c++;
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void registerMessageSendListener(onMessageSendListener onmessagesendlistener) {
        CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList;
        synchronized (UMConfigureImpl.class) {
            try {
                CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList2 = f38610b;
                if (copyOnWriteArrayList2 != null) {
                    copyOnWriteArrayList2.add(onmessagesendlistener);
                }
                if (UMEnvelopeBuild.getTransmissionSendFlag() && (copyOnWriteArrayList = f38610b) != null && copyOnWriteArrayList.size() > 0) {
                    Iterator<onMessageSendListener> it = f38610b.iterator();
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
                f38611c--;
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void removeMessageSendListener(onMessageSendListener onmessagesendlistener) {
        synchronized (UMConfigureImpl.class) {
            try {
                CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList = f38610b;
                if (copyOnWriteArrayList != null) {
                    copyOnWriteArrayList.remove(onmessagesendlistener);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static synchronized void m14043b(Context context) {
        synchronized (UMConfigureImpl.class) {
            try {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
                CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList = f38610b;
                if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                    Iterator<onMessageSendListener> it = f38610b.iterator();
                    while (it.hasNext()) {
                        it.next().onMessageSend();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: c */
    private static void m14041c(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f38609a, 0);
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean(f38609a, true);
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: d */
    private static boolean m14039d(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f38609a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getBoolean(f38609a, false);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
