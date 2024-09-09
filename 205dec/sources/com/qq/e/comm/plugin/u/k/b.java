package com.qq.e.comm.plugin.u.k;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.qq.e.comm.plugin.b.g;
import com.qq.e.comm.plugin.util.c0;
import com.qq.e.comm.plugin.util.c2;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.o2;
import java.lang.ref.WeakReference;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private c f46302c;

    /* renamed from: d  reason: collision with root package name */
    private InterfaceC0902b f46303d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f46304e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f46305f;

    /* renamed from: g  reason: collision with root package name */
    private c2 f46306g;

    /* renamed from: h  reason: collision with root package name */
    private String f46307h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class a extends c2 {

        /* renamed from: h  reason: collision with root package name */
        private final WeakReference<b> f46308h;

        public a(b bVar) {
            super(Long.MAX_VALUE, 200L);
            this.f46308h = new WeakReference<>(bVar);
        }

        @Override // com.qq.e.comm.plugin.util.c2
        public void a(long j4) {
            b bVar = this.f46308h.get();
            if (bVar != null) {
                bVar.a();
            } else {
                h();
            }
        }

        @Override // com.qq.e.comm.plugin.util.c2
        public void d() {
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.u.k.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface InterfaceC0902b {
        void dispatchTouchEvent(MotionEvent motionEvent);
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface c {
        void a(boolean z3);

        void b(boolean z3);
    }

    public b(Context context, String str) {
        super(context);
        this.f46307h = str;
    }

    private void b() {
        c2 c2Var = this.f46306g;
        if (c2Var == null) {
            a aVar = new a(this);
            this.f46306g = aVar;
            aVar.g();
            return;
        }
        c2Var.f();
    }

    private void c() {
        c2 c2Var = this.f46306g;
        if (c2Var != null) {
            c2Var.e();
        }
        a(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterfaceC0902b interfaceC0902b = this.f46303d;
        if (interfaceC0902b != null) {
            interfaceC0902b.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d1.a("NativeExpressAdContaineronAttachedToWindow", new Object[0]);
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d1.a("NativeExpressAdContaineronDetachedFromWindow", new Object[0]);
        c();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        d1.a("NativeExpressAdContaineronFinishTemporaryDetach", new Object[0]);
        b();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        d1.a("NativeExpressAdContaineronStartTemporaryDetach", new Object[0]);
        c();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
        d1.a("NativeExpressAdContaineronWindowVisibilityChanged : %d", Integer.valueOf(i4));
        if (i4 == 0) {
            b();
        } else {
            c();
        }
    }

    public void a(InterfaceC0902b interfaceC0902b) {
        this.f46303d = interfaceC0902b;
    }

    public void a(c cVar) {
        this.f46302c = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        a(o2.a(getContext(), this, c0.a(g.UNIFIED_INTERSTITIAL, this.f46307h)));
    }

    private void a(boolean z3) {
        if (this.f46304e != z3) {
            this.f46304e = z3;
            c cVar = this.f46302c;
            if (cVar != null) {
                cVar.a(z3);
            }
        }
        boolean z4 = z3 && hasWindowFocus();
        if (this.f46305f != z4) {
            this.f46305f = z4;
            c cVar2 = this.f46302c;
            if (cVar2 != null) {
                cVar2.b(z4);
            }
        }
    }
}
