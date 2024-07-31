package cn.bluemobi.dylan.base.utils;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;

/* renamed from: cn.bluemobi.dylan.base.utils.m */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class KeyboardChangeListener implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: e */
    private static final String f1814e = "ListenerHandler";

    /* renamed from: a */
    private View f1815a;

    /* renamed from: b */
    private int f1816b;

    /* renamed from: c */
    private int f1817c;

    /* renamed from: d */
    private InterfaceC1140a f1818d;

    /* compiled from: KeyboardChangeListener.java */
    /* renamed from: cn.bluemobi.dylan.base.utils.m$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1140a {
        /* renamed from: a */
        void m57726a(boolean z, int i);
    }

    public KeyboardChangeListener(Activity activity) {
        if (activity == null) {
            Log.i(f1814e, "contextObj is null");
            return;
        }
        View m57728c = m57728c(activity);
        this.f1815a = m57728c;
        if (m57728c != null) {
            m57730a();
        }
    }

    /* renamed from: a */
    private void m57730a() {
        this.f1815a.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    /* renamed from: c */
    private View m57728c(Activity activity) {
        return activity.findViewById(16908290);
    }

    /* renamed from: b */
    public void m57729b() {
        View view = this.f1815a;
        if (view != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* renamed from: d */
    public void m57727d(InterfaceC1140a interfaceC1140a) {
        this.f1818d = interfaceC1140a;
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
            android.view.View r0 = r4.f1815a
            int r0 = r0.getHeight()
            if (r0 != 0) goto L10
            java.lang.String r0 = "ListenerHandler"
            java.lang.String r1 = "currHeight is 0"
            android.util.Log.i(r0, r1)
            return
        L10:
            int r1 = r4.f1817c
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L1c
            r4.f1817c = r0
            r4.f1816b = r0
        L1a:
            r1 = 0
            goto L21
        L1c:
            if (r1 == r0) goto L1a
            r4.f1817c = r0
            r1 = 1
        L21:
            if (r1 == 0) goto L32
            int r1 = r4.f1816b
            if (r1 != r0) goto L29
            r2 = 0
            goto L2b
        L29:
            int r3 = r1 - r0
        L2b:
            cn.bluemobi.dylan.base.utils.m$a r0 = r4.f1818d
            if (r0 == 0) goto L32
            r0.m57726a(r2, r3)
        L32:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.bluemobi.dylan.base.utils.KeyboardChangeListener.onGlobalLayout():void");
    }
}
