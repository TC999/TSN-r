package cn.bluemobi.dylan.photoview.library;

import android.annotation.TargetApi;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Compat.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int f1882a = 16;

    public static int a(int i4) {
        return c(i4);
    }

    @TargetApi(5)
    private static int b(int i4) {
        return (i4 & 65280) >> 8;
    }

    @TargetApi(11)
    private static int c(int i4) {
        return (i4 & 65280) >> 8;
    }

    public static void d(View view, Runnable runnable) {
        e(view, runnable);
    }

    @TargetApi(16)
    private static void e(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
