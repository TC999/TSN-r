package com.qq.e.comm.plugin.banner2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.plugin.gdtnativead.n;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.plugin.util.r1;
import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class a implements ADListener {

    /* renamed from: d  reason: collision with root package name */
    private static final String f42087d = a.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f42088a;

    /* renamed from: b  reason: collision with root package name */
    private final ADListener f42089b;

    /* renamed from: c  reason: collision with root package name */
    private NativeExpressADView f42090c;

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.banner2.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class C0792a extends r1 {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ADEvent f42091d;

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.banner2.a$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class View$OnAttachStateChangeListenerC0793a implements View.OnAttachStateChangeListener {
            View$OnAttachStateChangeListenerC0793a() {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                a.this.f42090c.render();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        }

        C0792a(ADEvent aDEvent) {
            this.f42091d = aDEvent;
        }

        @Override // com.qq.e.comm.plugin.util.r1
        public void b() {
            d1.a(a.f42087d, "onADEvent ( %d )", Integer.valueOf(this.f42091d.getType()));
            int type = this.f42091d.getType();
            if (type != 100) {
                if (type == 101) {
                    a.this.f42089b.onADEvent(this.f42091d);
                    return;
                } else if (type != 105) {
                    if (((NativeExpressADView) this.f42091d.getParam(NativeExpressADView.class)) != null) {
                        a.this.f42089b.onADEvent(this.f42091d);
                        return;
                    }
                    return;
                } else if (((NativeExpressADView) this.f42091d.getParam(NativeExpressADView.class)) != null) {
                    a.this.f42089b.onADEvent(this.f42091d);
                    return;
                } else {
                    return;
                }
            }
            List list = (List) this.f42091d.getParam(List.class);
            if (list == null || list.size() <= 0 || !(list.get(0) instanceof NativeExpressADView)) {
                return;
            }
            int childCount = a.this.f42088a.getChildCount();
            if (childCount > 0) {
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = a.this.f42088a.getChildAt(i4);
                    if (childAt instanceof NativeExpressADView) {
                        ((NativeExpressADView) childAt).destroy();
                    }
                }
                a.this.f42088a.removeAllViews();
            }
            a.this.f42090c = (NativeExpressADView) list.get(0);
            if (a.this.f42090c instanceof n) {
                ((n) a.this.f42090c).a(a.this.f42089b);
            }
            if (a.this.f42090c.isValid()) {
                a.this.f42090c.addOnAttachStateChangeListener(new View$OnAttachStateChangeListenerC0793a());
                a.this.f42088a.addView(a.this.f42090c, new FrameLayout.LayoutParams(-1, -1));
                a.this.f42089b.onADEvent(this.f42091d);
                return;
            }
            a.this.f42089b.onADEvent(new ADEvent(110, new Object[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ViewGroup viewGroup, ADListener aDListener) {
        this.f42088a = viewGroup;
        this.f42089b = aDListener;
    }

    @Override // com.qq.e.comm.adevent.ADListener
    public void onADEvent(ADEvent aDEvent) {
        p0.a((Runnable) new C0792a(aDEvent));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeExpressADView b() {
        return this.f42090c;
    }
}
