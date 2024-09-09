package com.bytedance.c.w.ux.c;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.c.w.xv;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class e {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    private static volatile e f26578e;

    /* renamed from: a  reason: collision with root package name */
    private Context f26579a;

    /* renamed from: b  reason: collision with root package name */
    private Map<xv, g> f26580b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private f f26581c;

    /* renamed from: d  reason: collision with root package name */
    private d f26582d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f26583a;

        static {
            int[] iArr = new int[xv.values().length];
            f26583a = iArr;
            try {
                iArr[xv.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26583a[xv.ANR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26583a[xv.CUSTOM_JAVA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private e(@NonNull Context context) {
        this.f26579a = context;
        this.f26581c = new f(this.f26579a);
        this.f26582d = new d(this.f26579a);
    }

    public static e a() {
        if (f26578e != null) {
            return f26578e;
        }
        throw new IllegalArgumentException("CrashContextAssembly not init");
    }

    @Nullable
    private g b(xv xvVar) {
        g gVar = this.f26580b.get(xvVar);
        if (gVar != null) {
            return gVar;
        }
        int i4 = a.f26583a[xvVar.ordinal()];
        if (i4 == 1) {
            gVar = new c(this.f26579a, this.f26581c, this.f26582d);
        } else if (i4 == 2) {
            gVar = new com.bytedance.c.w.ux.c.a(this.f26579a, this.f26581c, this.f26582d);
        } else if (i4 == 3) {
            gVar = new b(this.f26579a, this.f26581c, this.f26582d);
        }
        if (gVar != null) {
            this.f26580b.put(xvVar, gVar);
        }
        return gVar;
    }

    public static void d(Context context) {
        if (f26578e == null) {
            f26578e = new e(context);
        }
    }

    public com.bytedance.c.w.xv.a c(xv xvVar, com.bytedance.c.w.xv.a aVar) {
        g b4;
        return (xvVar == null || (b4 = b(xvVar)) == null) ? aVar : b4.a(aVar);
    }
}
