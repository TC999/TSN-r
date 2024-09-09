package cn.jiguang.cl;

import android.text.TextUtils;
import cn.jiguang.api.JAction;
import cn.jiguang.api.JActionExtra;
import cn.jiguang.api.JCoreManager;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    private static volatile a f3447d;

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, g> f3444a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, JAction> f3445b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<String, JActionExtra> f3446c = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private static final Object f3448e = new Object();

    private a() {
    }

    public static a a() {
        if (f3447d == null) {
            synchronized (f3448e) {
                if (f3447d == null) {
                    f3447d = new a();
                }
            }
        }
        return f3447d;
    }

    public JAction a(String str) {
        if (f3445b.containsKey(str)) {
            return f3445b.get(str);
        }
        return null;
    }

    public void a(String str, String str2) {
        d.a("DispacthManager", "addAction type:" + str + ",action:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (!f3444a.containsKey(str)) {
            g gVar = new g();
            JCoreManager.addDispatchAction(str, g.class.getCanonicalName());
            f3444a.put(str, gVar);
        }
        if (f3445b.containsKey(str)) {
            return;
        }
        try {
            Object newInstance = Class.forName(str2).newInstance();
            if (newInstance instanceof JAction) {
                f3445b.put(str, (JAction) newInstance);
            }
        } catch (Throwable th) {
            d.d("DispacthManager", "#unexcepted - instance " + str2 + " class failed:" + th);
        }
    }

    public JActionExtra b(String str) {
        if (f3446c.containsKey(str)) {
            return f3446c.get(str);
        }
        return null;
    }

    public void b(String str, String str2) {
        d.a("DispacthManager", "addActionExtra type:" + str + ",action:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (!f3444a.containsKey(str)) {
            g gVar = new g();
            JCoreManager.addDispatchAction(str, g.class.getCanonicalName());
            f3444a.put(str, gVar);
        }
        if (f3446c.containsKey(str)) {
            return;
        }
        try {
            Object newInstance = Class.forName(str2).newInstance();
            if (newInstance instanceof JActionExtra) {
                f3446c.put(str, (JActionExtra) newInstance);
            }
        } catch (Throwable th) {
            d.d("DispacthManager", "#unexcepted - instance " + str2 + " class failed:" + th);
        }
    }
}
