package cn.bluemobi.dylan.base.utils;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: KeyboardChangeListener.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class m implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: e  reason: collision with root package name */
    private static final String f1800e = "ListenerHandler";

    /* renamed from: a  reason: collision with root package name */
    private View f1801a;

    /* renamed from: b  reason: collision with root package name */
    private int f1802b;

    /* renamed from: c  reason: collision with root package name */
    private int f1803c;

    /* renamed from: d  reason: collision with root package name */
    private a f1804d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: KeyboardChangeListener.java */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface a {
        void a(boolean z3, int i4);
    }

    public m(Activity activity) {
        if (activity == null) {
            Log.i("ListenerHandler", "contextObj is null");
            return;
        }
        View c4 = c(activity);
        this.f1801a = c4;
        if (c4 != null) {
            a();
        }
    }

    private void a() {
        this.f1801a.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    private View c(Activity activity) {
        return activity.findViewById(16908290);
    }

    public void b() {
        View view = this.f1801a;
        if (view != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public void d(a aVar) {
        this.f1804d = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onGlobalLayout() {
        /*
            r4 = this;
            android.view.View r0 = r4.f1801a
            int r0 = r0.getHeight()
            if (r0 != 0) goto L10
            java.lang.String r0 = "ListenerHandler"
            java.lang.String r1 = "currHeight is 0"
            android.util.Log.i(r0, r1)
            return
        L10:
            int r1 = r4.f1803c
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L1c
            r4.f1803c = r0
            r4.f1802b = r0
        L1a:
            r1 = 0
            goto L21
        L1c:
            if (r1 == r0) goto L1a
            r4.f1803c = r0
            r1 = 1
        L21:
            if (r1 == 0) goto L32
            int r1 = r4.f1802b
            if (r1 != r0) goto L29
            r2 = 0
            goto L2b
        L29:
            int r3 = r1 - r0
        L2b:
            cn.bluemobi.dylan.base.utils.m$a r0 = r4.f1804d
            if (r0 == 0) goto L32
            r0.a(r2, r3)
        L32:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.bluemobi.dylan.base.utils.m.onGlobalLayout():void");
    }
}
