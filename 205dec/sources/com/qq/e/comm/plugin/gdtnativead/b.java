package com.qq.e.comm.plugin.gdtnativead;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.p0;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class b implements ADListener {

    /* renamed from: g  reason: collision with root package name */
    private static final String f43762g = b.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private final com.qq.e.comm.plugin.u.i f43763a;

    /* renamed from: b  reason: collision with root package name */
    private final ViewGroup f43764b;

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.b.n f43765c;

    /* renamed from: d  reason: collision with root package name */
    private final ADListener f43766d;

    /* renamed from: e  reason: collision with root package name */
    private ADListener f43767e;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f43768f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ADListener f43769c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f43770d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object[] f43771e;

        a(b bVar, ADListener aDListener, int i4, Object[] objArr) {
            this.f43769c = aDListener;
            this.f43770d = i4;
            this.f43771e = objArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            ADListener aDListener = this.f43769c;
            if (aDListener != null) {
                aDListener.onADEvent(new ADEvent(this.f43770d, this.f43771e));
            }
        }
    }

    public b(ADListener aDListener, ViewGroup viewGroup, com.qq.e.comm.plugin.b.n nVar, com.qq.e.comm.plugin.u.i iVar) {
        this.f43766d = aDListener;
        this.f43764b = viewGroup;
        this.f43765c = nVar;
        this.f43763a = iVar;
    }

    private boolean b(ADEvent aDEvent) {
        int type = aDEvent.getType();
        if (type == 210) {
            d1.a(f43762g, "onVideoReady");
            b(210, this.f43764b, Integer.valueOf(this.f43763a.getVideoDuration()));
        } else if (type == 301) {
            b(301, this.f43764b);
        } else if (type != 302) {
            switch (type) {
                case 201:
                    d1.a(f43762g, "onVideoCached");
                    b(201, this.f43764b);
                    break;
                case 202:
                    d1.a(f43762g, "onVideoStart");
                    b(202, this.f43764b);
                    break;
                case 203:
                    d1.a(f43762g, "onVideoResume");
                    b(202, this.f43764b);
                    break;
                case 204:
                case 205:
                    d1.a(f43762g, "onVideoPause");
                    b(204, this.f43764b);
                    break;
                case 206:
                    d1.a(f43762g, "onVideoComplete");
                    b(206, this.f43764b);
                    break;
                case 207:
                    d1.b(f43762g, "onVideoError");
                    b(207, this.f43764b, 5002);
                    break;
                default:
                    switch (type) {
                        case 1001:
                            d1.a(f43762g, "onVideoDownloading");
                            b(211, this.f43764b);
                            break;
                        case 1002:
                            a(1002, this.f43764b);
                            break;
                        case 1003:
                            a(1003, this.f43764b);
                            break;
                        default:
                            b(aDEvent.getType(), new Object[0]);
                            break;
                    }
            }
        } else {
            b(302, this.f43764b);
        }
        return true;
    }

    public void a(ADListener aDListener) {
        this.f43767e = aDListener;
    }

    @Override // com.qq.e.comm.adevent.ADListener
    public void onADEvent(ADEvent aDEvent) {
        if (a(aDEvent)) {
            return;
        }
        b(aDEvent);
    }

    private boolean a(ADEvent aDEvent) {
        int type = aDEvent.getType();
        if (type == 103) {
            d1.a(f43762g, "onExposed");
            a(103, this.f43764b);
        } else if (type == 303) {
            a(303, this.f43764b);
        } else if (type == 105) {
            d1.a(f43762g, "onClick");
            a(105, this.f43764b);
        } else if (type == 106) {
            d1.a(f43762g, "onAdClosed");
            this.f43764b.removeAllViews();
            a(106, this.f43764b);
        } else if (type == 109) {
            d1.a(f43762g, "onRenderSuccess");
            if (this.f43768f != null) {
                return true;
            }
            View e4 = this.f43763a.e();
            this.f43764b.addView(e4, e4.getLayoutParams());
            this.f43768f = Boolean.TRUE;
            a(109, this.f43764b);
            com.qq.e.comm.plugin.o0.h.f fVar = (com.qq.e.comm.plugin.o0.h.f) com.qq.e.comm.plugin.b.a.a(aDEvent, com.qq.e.comm.plugin.o0.h.f.class);
            this.f43765c.a(new o(fVar));
            if (fVar != null) {
                d1.a(f43762g, "onVideoInit");
                b(209, this.f43764b);
            }
        } else if (type != 110) {
            return false;
        } else {
            d1.b(f43762g, "onRenderFail");
            if (this.f43768f != null) {
                return true;
            }
            this.f43768f = Boolean.FALSE;
            a(110, this.f43764b);
        }
        return true;
    }

    private void a(int i4, Object... objArr) {
        a(this.f43766d, i4, objArr);
    }

    private void a(ADListener aDListener, int i4, Object... objArr) {
        a aVar = new a(this, aDListener, i4, objArr);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            p0.a((Runnable) aVar);
        } else {
            aVar.run();
        }
    }

    private void b(int i4, Object... objArr) {
        a(this.f43767e, i4, objArr);
    }
}
