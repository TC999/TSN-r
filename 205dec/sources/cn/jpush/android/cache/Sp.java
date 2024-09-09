package cn.jpush.android.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.ad.f;
import cn.jpush.android.ad.l;
import cn.jpush.android.ad.m;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class Sp {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, SharedPreferences> f4109a = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static Handler f4112a;

        /* renamed from: e  reason: collision with root package name */
        private static Context f4116e;

        /* renamed from: b  reason: collision with root package name */
        private static final Object f4113b = new Object();

        /* renamed from: c  reason: collision with root package name */
        private static final LinkedList<Runnable> f4114c = new LinkedList<>();

        /* renamed from: d  reason: collision with root package name */
        private static boolean f4115d = true;

        /* renamed from: f  reason: collision with root package name */
        private static final Object f4117f = new Object();

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: cn.jpush.android.cache.Sp$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public static class HandlerC0068a extends Handler {
            HandlerC0068a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    JCoreHelper.futureExecutor(a.f4116e, new f() { // from class: cn.jpush.android.cache.Sp.a.a.1
                        @Override // cn.jpush.android.ad.f
                        public void a() {
                            a.c(a.f4116e);
                        }
                    });
                }
            }
        }

        public static void a(Context context, Runnable runnable, boolean z3) {
            try {
                Handler b4 = b(context);
                if (b4 != null) {
                    synchronized (f4113b) {
                        f4114c.add(runnable);
                        if (z3 && f4115d) {
                            b4.sendEmptyMessageDelayed(1, 100L);
                        } else {
                            b4.sendEmptyMessage(1);
                        }
                    }
                }
            } catch (Throwable th) {
                Logger.w("Sp", "sp task add queue failed, " + th.getMessage());
            }
        }

        private static Handler b(Context context) {
            f4116e = context != null ? StubApp.getOrigApplicationContext(context.getApplicationContext()) : JPushConstants.getAppContext(null);
            if (f4112a == null) {
                synchronized (f4113b) {
                    if (f4112a == null) {
                        f4112a = new HandlerC0068a(Looper.getMainLooper());
                    }
                }
            }
            return f4112a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void c(Context context) {
            LinkedList linkedList;
            try {
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (f4117f) {
                    synchronized (f4113b) {
                        LinkedList<Runnable> linkedList2 = f4114c;
                        linkedList = (LinkedList) linkedList2.clone();
                        linkedList2.clear();
                        Handler b4 = b(context);
                        if (b4 != null) {
                            b4.removeMessages(1);
                        }
                    }
                    if (linkedList.size() > 0) {
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            ((Runnable) it.next()).run();
                        }
                        if (JConstants.DEBUG_MODE) {
                            Logger.d("Sp", "sp processing " + linkedList.size() + " items took " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                        }
                    }
                }
            } catch (Throwable th) {
                Logger.w("Sp", "sp commit task error, " + th.getMessage());
            }
        }
    }

    private static <T> T a(SharedPreferences sharedPreferences, String str, T t3) {
        if (sharedPreferences != null && sharedPreferences.contains(str)) {
            try {
                if (t3 instanceof Boolean) {
                    return (T) Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) t3).booleanValue()));
                }
                if (t3 instanceof String) {
                    return (T) sharedPreferences.getString(str, (String) t3);
                }
                if (t3 instanceof Integer) {
                    return (T) Integer.valueOf(sharedPreferences.getInt(str, ((Integer) t3).intValue()));
                }
                if (t3 instanceof Long) {
                    return (T) Long.valueOf(sharedPreferences.getLong(str, ((Long) t3).longValue()));
                }
                if (t3 instanceof Float) {
                    return (T) Float.valueOf(sharedPreferences.getFloat(str, ((Float) t3).floatValue()));
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static void a(final Context context, boolean z3, final Key<?>... keyArr) {
        f fVar = new f() { // from class: cn.jpush.android.cache.Sp.1
            @Override // cn.jpush.android.ad.f
            public void a() {
                Key[] keyArr2;
                SharedPreferences b4;
                try {
                    HashMap hashMap = new HashMap();
                    for (Key key : keyArr) {
                        SharedPreferences.Editor editor = (SharedPreferences.Editor) hashMap.get(key.f4104a);
                        if (editor == null && (b4 = Sp.b(context, key.f4104a)) != null) {
                            editor = b4.edit();
                            hashMap.put(key.f4104a, editor);
                        }
                        Sp.b(editor, key.f4105b, key.f4106c, key.f4108e);
                    }
                    for (String str : hashMap.keySet()) {
                        SharedPreferences.Editor editor2 = (SharedPreferences.Editor) hashMap.get(str);
                        if (editor2 != null && !editor2.commit()) {
                            Logger.w("Sp", "sp commit failed, sp_file: " + str);
                        }
                    }
                } catch (Throwable th) {
                    Logger.w("Sp", "sp commit failed, " + th.getMessage());
                }
            }
        };
        try {
            if (z3) {
                a.a(context, fVar, false);
            } else {
                fVar.run();
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean a() {
        return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SharedPreferences b(Context context, String str) {
        Context appContext;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, SharedPreferences> map = f4109a;
        SharedPreferences sharedPreferences = map.get(str);
        if (sharedPreferences != null || (appContext = JPushConstants.getAppContext(context)) == null) {
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = appContext.getSharedPreferences(str, 0);
        map.put(str, sharedPreferences2);
        c(appContext, str);
        return sharedPreferences2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void b(SharedPreferences.Editor editor, String str, T t3, boolean z3) {
        if (editor != null) {
            if (t3 == null) {
                editor.remove(str);
            } else if (t3 instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) t3).booleanValue());
            } else if (t3 instanceof String) {
                String str2 = (String) t3;
                if (z3 && str2.length() > 0) {
                    t3 = (T) l.a(str2, m.f4027a);
                }
                editor.putString(str, (String) t3);
            } else if (t3 instanceof Integer) {
                editor.putInt(str, ((Integer) t3).intValue());
            } else if (t3 instanceof Long) {
                editor.putLong(str, ((Long) t3).longValue());
            } else if (t3 instanceof Float) {
                editor.putFloat(str, ((Float) t3).floatValue());
            }
        }
    }

    private static void c(Context context, String str) {
    }

    public static void clear(Context context, String str) {
        SharedPreferences b4 = b(context, str);
        if (b4 != null) {
            b4.edit().clear().apply();
        }
    }

    public static <T> T get(Context context, Key<T> key) {
        T t3 = (T) getWithNull(context, key);
        return t3 != null ? t3 : key.f4106c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getWithNull(Context context, Key<T> key) {
        Object a4 = a(b(context, key.f4104a), key.f4105b, key.f4106c);
        if (a4 == null && key.f4107d) {
            a4 = (T) a(reload(context, key.f4104a), key.f4105b, key.f4106c);
        }
        if (a4 != null) {
            if (key.f4108e && (a4 instanceof String)) {
                String str = a4;
                if (str.length() > 0) {
                    a4 = (T) l.b(str, m.f4027a);
                }
            }
            key.set(a4);
            return (T) a4;
        }
        return null;
    }

    public static void read(Context context, Key<?>... keyArr) {
        if (keyArr == null || keyArr.length <= 0) {
            return;
        }
        for (Key<?> key : keyArr) {
            get(context, key);
        }
    }

    public static SharedPreferences reload(Context context, String str) {
        Context appContext = JPushConstants.getAppContext(context);
        if (appContext != null) {
            appContext.getSharedPreferences(str, 4);
            return appContext.getSharedPreferences(str, 0);
        }
        return null;
    }

    public static void set(Context context, Key<?>... keyArr) {
        if (keyArr == null || keyArr.length <= 0) {
            return;
        }
        if (!a()) {
            sync_set(context, keyArr);
            return;
        }
        Logger.d("Sp", "main thread, async sp set");
        a(context, true, keyArr);
    }

    public static void sync_set(Context context, Key<?>... keyArr) {
        if (keyArr == null || keyArr.length <= 0) {
            return;
        }
        a(context, false, keyArr);
    }
}
