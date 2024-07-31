package cn.bluemobi.dylan.photoview.library;

import android.annotation.TargetApi;
import android.view.View;
import androidx.core.view.MotionEventCompat;

/* renamed from: cn.bluemobi.dylan.photoview.library.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class Compat {

    /* renamed from: a */
    private static final int f1897a = 16;

    /* renamed from: a */
    public static int m57558a(int i) {
        return m57556c(i);
    }

    @TargetApi(5)
    /* renamed from: b */
    private static int m57557b(int i) {
        return (i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    @TargetApi(11)
    /* renamed from: c */
    private static int m57556c(int i) {
        return (i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    /* renamed from: d */
    public static void m57555d(View view, Runnable runnable) {
        m57554e(view, runnable);
    }

    @TargetApi(16)
    /* renamed from: e */
    private static void m57554e(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
