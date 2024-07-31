package com.p521ss.android.downloadlib.p536n;

import android.text.TextUtils;
import androidx.annotation.NonNull;

/* renamed from: com.ss.android.downloadlib.n.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12232a {

    /* renamed from: com.ss.android.downloadlib.n.a$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC12234ok<T> {
        /* renamed from: a */
        T mo18645a();
    }

    /* renamed from: ok */
    public static <T> T m18647ok(boolean z, String str, @NonNull InterfaceC12234ok<T> interfaceC12234ok) {
        try {
            return interfaceC12234ok.mo18645a();
        } catch (Throwable th) {
            if (!(th instanceof C12237ok)) {
                C12235bl.m18640ok().m18635ok(z, th, str);
                if (TextUtils.isEmpty(str)) {
                    throw th;
                }
                return null;
            }
            throw th;
        }
    }

    /* renamed from: ok */
    public static <T> T m18649ok(InterfaceC12234ok<T> interfaceC12234ok) {
        return (T) m18647ok(true, null, interfaceC12234ok);
    }

    /* renamed from: ok */
    public static void m18648ok(final Runnable runnable) {
        m18649ok(new InterfaceC12234ok<Void>() { // from class: com.ss.android.downloadlib.n.a.1
            @Override // com.p521ss.android.downloadlib.p536n.C12232a.InterfaceC12234ok
            /* renamed from: ok */
            public Void mo18645a() {
                runnable.run();
                return null;
            }
        });
    }
}
