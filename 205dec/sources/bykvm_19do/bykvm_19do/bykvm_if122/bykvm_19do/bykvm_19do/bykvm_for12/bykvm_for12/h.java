package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12;

import android.content.Context;
import java.util.HashMap;

/* compiled from: TncInstanceManager.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static volatile h f758a;

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<Integer, f> f759b;

    /* renamed from: c  reason: collision with root package name */
    private static HashMap<Integer, a> f760c;

    private h() {
        f759b = new HashMap<>();
        f760c = new HashMap<>();
    }

    public static synchronized h a() {
        h hVar;
        synchronized (h.class) {
            if (f758a == null) {
                synchronized (h.class) {
                    if (f758a == null) {
                        f758a = new h();
                    }
                }
            }
            hVar = f758a;
        }
        return hVar;
    }

    public f a(int i4) {
        if (f759b.get(Integer.valueOf(i4)) == null) {
            f759b.put(Integer.valueOf(i4), new f(i4));
        }
        return f759b.get(Integer.valueOf(i4));
    }

    public a a(int i4, Context context) {
        if (f760c.get(Integer.valueOf(i4)) == null) {
            f760c.put(Integer.valueOf(i4), new a(context, i4));
        }
        return f760c.get(Integer.valueOf(i4));
    }
}
