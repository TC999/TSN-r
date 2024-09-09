package cn.jiguang.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import cn.jiguang.cm.d;
import cn.jiguang.cn.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, SharedPreferences> f3657a = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static Handler f3660a;

        /* renamed from: b  reason: collision with root package name */
        private static final Object f3661b = new Object();

        /* renamed from: c  reason: collision with root package name */
        private static final LinkedList<Runnable> f3662c = new LinkedList<>();

        /* renamed from: d  reason: collision with root package name */
        private static boolean f3663d = true;

        /* renamed from: e  reason: collision with root package name */
        private static final Object f3664e = new Object();

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: cn.jiguang.g.b$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public static class HandlerC0063a extends Handler {
            HandlerC0063a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    d.a("FUTURE_TASK", new cn.jiguang.cm.b() { // from class: cn.jiguang.g.b.a.a.1
                        @Override // cn.jiguang.cm.b
                        public void a() {
                            a.c();
                        }
                    });
                }
            }
        }

        public static void a(Runnable runnable, boolean z3) {
            try {
                Handler b4 = b();
                if (b4 != null) {
                    synchronized (f3661b) {
                        f3662c.add(runnable);
                        if (z3 && f3663d) {
                            b4.sendEmptyMessageDelayed(1, 100L);
                        } else {
                            b4.sendEmptyMessage(1);
                        }
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.bq.d.i("Sp", "sp task add queue failed, " + th.getMessage());
            }
        }

        private static Handler b() {
            if (f3660a == null) {
                synchronized (f3661b) {
                    if (f3660a == null) {
                        f3660a = new HandlerC0063a(Looper.getMainLooper());
                    }
                }
            }
            return f3660a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void c() {
            LinkedList linkedList;
            try {
                System.currentTimeMillis();
                synchronized (f3664e) {
                    synchronized (f3661b) {
                        LinkedList<Runnable> linkedList2 = f3662c;
                        linkedList = (LinkedList) linkedList2.clone();
                        linkedList2.clear();
                        Handler b4 = b();
                        if (b4 != null) {
                            b4.removeMessages(1);
                        }
                    }
                    if (linkedList.size() > 0) {
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            ((Runnable) it.next()).run();
                        }
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.bq.d.i("Sp", "sp commit task error, " + th.getMessage());
            }
        }
    }

    public static <T> T a(Context context, cn.jiguang.g.a<T> aVar) {
        T t3 = (T) b(context, aVar);
        return t3 != null ? t3 : aVar.f3654e;
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

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void a(Context context, cn.jiguang.g.a<T> aVar, cn.jiguang.g.a<T> aVar2) {
        Object b4;
        if (b(context, aVar) != null || (b4 = b(context, aVar2)) == null) {
            return;
        }
        a(context, aVar.a((cn.jiguang.g.a<T>) b4));
        a(context, aVar2.a((cn.jiguang.g.a<T>) null));
    }

    public static void a(Context context, String str) {
        SharedPreferences e4 = e(context, str);
        if (e4 != null) {
            e4.edit().clear().apply();
        }
    }

    private static void a(final Context context, boolean z3, final cn.jiguang.g.a<?>... aVarArr) {
        try {
            cn.jiguang.cm.b bVar = new cn.jiguang.cm.b() { // from class: cn.jiguang.g.b.1
                @Override // cn.jiguang.cm.b
                public void a() {
                    cn.jiguang.g.a[] aVarArr2;
                    SharedPreferences e4;
                    try {
                        HashMap hashMap = new HashMap();
                        for (cn.jiguang.g.a aVar : aVarArr) {
                            SharedPreferences.Editor editor = (SharedPreferences.Editor) hashMap.get(aVar.f3652c);
                            if (editor == null && (e4 = b.e(context, aVar.f3652c)) != null) {
                                editor = e4.edit();
                                hashMap.put(aVar.f3652c, editor);
                            }
                            b.b(editor, aVar.f3653d, aVar.f3654e, aVar.f3656g);
                        }
                        for (String str : hashMap.keySet()) {
                            SharedPreferences.Editor editor2 = (SharedPreferences.Editor) hashMap.get(str);
                            if (editor2 != null && !editor2.commit()) {
                                cn.jiguang.bq.d.i("Sp", "sp commit failed, sp_file: " + str);
                            }
                        }
                    } catch (Throwable th) {
                        cn.jiguang.bq.d.i("Sp", "sp commit failed, " + th.getMessage());
                    }
                }
            };
            if (z3) {
                a.a(bVar, false);
            } else {
                bVar.run();
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, cn.jiguang.g.a<?>... aVarArr) {
        if (aVarArr == null || aVarArr.length <= 0) {
            return;
        }
        if (!a()) {
            b(context, aVarArr);
            return;
        }
        cn.jiguang.bq.d.c("Sp", "main thread, async sp set");
        a(context, true, aVarArr);
    }

    private static boolean a() {
        try {
            return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("Sp", "[isMainThread] failed:" + th.getMessage());
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T b(Context context, cn.jiguang.g.a<T> aVar) {
        Object a4 = a(e(context, aVar.f3652c), aVar.f3653d, aVar.f3654e);
        if (a4 == null && aVar.f3655f) {
            a4 = (T) a(d(context, aVar.f3652c), aVar.f3653d, aVar.f3654e);
        }
        if (a4 != null) {
            if (aVar.f3656g && (a4 instanceof String)) {
                String str = a4;
                if (str.length() > 0) {
                    a4 = (T) g.b(str, cn.jiguang.a.a.f2017i);
                }
            }
            aVar.a((cn.jiguang.g.a<T>) a4);
            return (T) a4;
        }
        return null;
    }

    public static void b(Context context, cn.jiguang.g.a<?>... aVarArr) {
        if (aVarArr == null || aVarArr.length <= 0) {
            return;
        }
        a(context, false, aVarArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void b(SharedPreferences.Editor editor, String str, T t3, boolean z3) {
        if (editor != null) {
            if (t3 == null) {
                editor.remove(str);
            } else if (t3 instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) t3).booleanValue());
            } else if (t3 instanceof String) {
                if (z3) {
                    String str2 = (String) t3;
                    if (str2.length() > 0) {
                        t3 = (T) g.a(str2, cn.jiguang.a.a.f2017i);
                    }
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
        String str2 = (String) a(context, cn.jiguang.g.a.U());
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        str2.startsWith("1.");
    }

    public static void c(Context context, cn.jiguang.g.a<?>... aVarArr) {
        if (aVarArr == null || aVarArr.length <= 0) {
            return;
        }
        for (cn.jiguang.g.a<?> aVar : aVarArr) {
            a(context, aVar);
        }
    }

    private static SharedPreferences d(Context context, String str) {
        if (context != null) {
            context.getSharedPreferences(str, 4);
            return context.getSharedPreferences(str, 0);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SharedPreferences e(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, SharedPreferences> map = f3657a;
        SharedPreferences sharedPreferences = map.get(str);
        if (sharedPreferences != null || context == null) {
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = context.getSharedPreferences(str, 0);
        map.put(str, sharedPreferences2);
        c(context, str);
        return sharedPreferences2;
    }
}
