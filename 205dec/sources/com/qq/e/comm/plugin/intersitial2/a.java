package com.qq.e.comm.plugin.intersitial2;

import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.plugin.g0.v;
import com.qq.e.comm.plugin.intersitial2.f;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.plugin.util.r;
import com.qq.e.comm.plugin.util.r1;
import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a implements ADListener {

    /* renamed from: h  reason: collision with root package name */
    private static final String f44417h = a.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private final ADListener f44418a;

    /* renamed from: b  reason: collision with root package name */
    private final f f44419b;

    /* renamed from: c  reason: collision with root package name */
    private NativeExpressADView f44420c;

    /* renamed from: d  reason: collision with root package name */
    private v f44421d;

    /* renamed from: e  reason: collision with root package name */
    private f.s f44422e;

    /* renamed from: f  reason: collision with root package name */
    private b f44423f;

    /* renamed from: g  reason: collision with root package name */
    private String f44424g;

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.intersitial2.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class C0849a extends r1 {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ADEvent f44425d;

        C0849a(ADEvent aDEvent) {
            this.f44425d = aDEvent;
        }

        private void a(ADEvent aDEvent) {
            if (a.this.f44422e != null) {
                a.this.f44422e.a(true);
            }
            r.d(a.this.f44424g, a.this.f44419b);
            if (a.this.f44418a != null) {
                a.this.f44418a.onADEvent(aDEvent);
            }
        }

        @Override // com.qq.e.comm.plugin.util.r1
        public void b() {
            List list;
            d1.a(a.f44417h, "onADEvent ( %d )", Integer.valueOf(this.f44425d.getType()));
            int type = this.f44425d.getType();
            if (type == 100) {
                Object a4 = com.qq.e.comm.plugin.b.a.a(this.f44425d, Object.class);
                if (a4 instanceof v) {
                    if (a.this.f44421d != null) {
                        a.this.f44421d = null;
                    }
                    a.this.f44421d = (v) a4;
                    a(this.f44425d);
                } else if (!(a4 instanceof List) || (list = (List) a4) == null || list.size() <= 0 || !(list.get(0) instanceof NativeExpressADView)) {
                } else {
                    if (a.this.f44420c != null) {
                        a.this.f44420c.destroy();
                    }
                    a.this.f44420c = (NativeExpressADView) list.get(0);
                    a.this.f44420c.render();
                    a(this.f44425d);
                }
            } else if (type == 101) {
                if (((Integer) com.qq.e.comm.plugin.b.a.a(this.f44425d, Integer.class)) != null) {
                    if (a.this.f44422e != null) {
                        a.this.f44422e.a(false);
                    }
                    if (a.this.f44418a != null) {
                        a.this.f44418a.onADEvent(this.f44425d);
                    }
                    if (a.this.f44420c != null) {
                        a.this.f44420c.destroy();
                        a.this.f44420c = null;
                    }
                }
            } else if (type == 103) {
                if (a.this.f44418a != null) {
                    a.this.f44418a.onADEvent(this.f44425d);
                }
                if (a.this.f44422e != null) {
                    a.this.f44422e.a(false);
                }
            } else if (type == 106) {
                a.this.f44419b.close();
                if (!(com.qq.e.comm.plugin.b.a.a(this.f44425d, Object.class) instanceof v) || a.this.f44418a == null) {
                    return;
                }
                a.this.f44418a.onADEvent(this.f44425d);
            } else if (type == 110) {
                if (a.this.f44420c != null) {
                    a.this.f44420c.destroy();
                    a.this.f44420c = null;
                }
                a.this.f44419b.close();
                a.this.f44418a.onADEvent(this.f44425d);
            } else if (type == 303 || type == 1007) {
                if (i.a(a.this.f44424g)) {
                    a.this.f44419b.close();
                }
            } else {
                switch (type) {
                    case 1002:
                        return;
                    case 1003:
                        if (a.this.f44423f != null) {
                            a.this.f44423f.a();
                        }
                        if (i.a(a.this.f44424g)) {
                            a.this.f44419b.close();
                            return;
                        }
                        return;
                    case 1004:
                        if (a.this.f44423f != null) {
                            a.this.f44423f.b();
                            return;
                        }
                        return;
                    default:
                        if (a.this.f44418a != null) {
                            a.this.f44418a.onADEvent(this.f44425d);
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    interface b {
        void a();

        void b();
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class c implements ADListener {

        /* renamed from: a  reason: collision with root package name */
        private final ADListener f44427a;

        /* renamed from: b  reason: collision with root package name */
        private final f f44428b;

        /* renamed from: c  reason: collision with root package name */
        private final String f44429c;

        public c(ADListener aDListener, f fVar, String str) {
            this.f44427a = aDListener;
            this.f44428b = fVar;
            this.f44429c = str;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            ADListener aDListener = this.f44427a;
            if (aDListener != null) {
                aDListener.onADEvent(aDEvent);
            }
            if (aDEvent != null) {
                int type = aDEvent.getType();
                if ((type == 303 || type == 1003 || type == 1007) && i.a(this.f44429c)) {
                    this.f44428b.close();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(f fVar, ADListener aDListener, String str, f.s sVar) {
        this.f44419b = fVar;
        this.f44418a = new c(aDListener, fVar, str);
        this.f44422e = sVar;
        this.f44424g = str;
    }

    @Override // com.qq.e.comm.adevent.ADListener
    public void onADEvent(ADEvent aDEvent) {
        p0.a((Runnable) new C0849a(aDEvent));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        NativeExpressADView nativeExpressADView = this.f44420c;
        if (nativeExpressADView != null) {
            nativeExpressADView.destroy();
            this.f44420c = null;
        }
        if (this.f44421d != null) {
            this.f44421d = null;
        }
    }

    public f.s c() {
        return this.f44422e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v d() {
        return this.f44421d;
    }

    public ADListener e() {
        return this.f44418a;
    }
}
