package com.qq.e.comm.plugin.i.d0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.plugin.callback.biz.DialogStateCallback;
import com.qq.e.comm.plugin.f0.f;
import com.qq.e.comm.plugin.g0.e;
import com.qq.e.comm.plugin.util.e2;
import com.qq.e.comm.plugin.util.k;
import java.lang.ref.WeakReference;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d implements com.qq.e.comm.plugin.i.d0.b {

    /* renamed from: a  reason: collision with root package name */
    protected WeakReference<Context> f44096a;

    /* renamed from: b  reason: collision with root package name */
    protected WeakReference<com.qq.e.comm.plugin.apkmanager.w.a> f44097b;

    /* renamed from: c  reason: collision with root package name */
    private InterfaceC0844d f44098c;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements DownloadConfirmCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.i.d0.c f44099a;

        a(com.qq.e.comm.plugin.i.d0.c cVar) {
            this.f44099a = cVar;
        }

        @Override // com.qq.e.comm.compliance.DownloadConfirmCallBack
        public void onCancel() {
            com.qq.e.comm.plugin.i.d0.c cVar = this.f44099a;
            if (cVar != null) {
                cVar.onCancel();
            }
            if (d.this.f44098c != null) {
                d.this.f44098c.b();
            }
        }

        @Override // com.qq.e.comm.compliance.DownloadConfirmCallBack
        public void onConfirm() {
            com.qq.e.comm.plugin.i.d0.c cVar = this.f44099a;
            if (cVar != null) {
                cVar.onConfirm();
            }
            if (d.this.f44098c != null) {
                d.this.f44098c.b();
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements com.qq.e.comm.plugin.i.d0.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.i.d0.c f44101a;

        b(com.qq.e.comm.plugin.i.d0.c cVar) {
            this.f44101a = cVar;
        }

        @Override // com.qq.e.comm.plugin.i.d0.c
        public void a(boolean z3) {
            com.qq.e.comm.plugin.i.d0.c cVar = this.f44101a;
            if (cVar != null) {
                cVar.a(z3);
            }
            if (d.this.f44098c == null || !z3) {
                return;
            }
            d.this.f44098c.a();
        }

        @Override // com.qq.e.comm.plugin.i.d0.c
        public void b(boolean z3) {
            com.qq.e.comm.plugin.i.d0.c cVar = this.f44101a;
            if (cVar != null) {
                cVar.b(z3);
            }
            if (d.this.f44098c != null) {
                d.this.f44098c.b();
            }
        }

        @Override // com.qq.e.comm.plugin.i.d0.c
        public void onCancel() {
            com.qq.e.comm.plugin.i.d0.c cVar = this.f44101a;
            if (cVar != null) {
                cVar.onCancel();
            }
        }

        @Override // com.qq.e.comm.plugin.i.d0.c
        public boolean onConfirm() {
            com.qq.e.comm.plugin.i.d0.c cVar = this.f44101a;
            if (cVar != null) {
                return cVar.onConfirm();
            }
            return true;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class c implements InterfaceC0844d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DialogStateCallback f44103a;

        c(d dVar, DialogStateCallback dialogStateCallback) {
            this.f44103a = dialogStateCallback;
        }

        @Override // com.qq.e.comm.plugin.i.d0.d.InterfaceC0844d
        public void a() {
            this.f44103a.d().b(3);
        }

        @Override // com.qq.e.comm.plugin.i.d0.d.InterfaceC0844d
        public void b() {
            this.f44103a.onDismiss().b(3);
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.i.d0.d$d  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private interface InterfaceC0844d {
        void a();

        void b();
    }

    public d(Context context) {
        this(context, null);
    }

    @Override // com.qq.e.comm.plugin.i.d0.b
    public void a(String str, com.qq.e.comm.plugin.i.d0.c cVar) {
    }

    @Override // com.qq.e.comm.plugin.i.d0.b
    public void b(String str, e eVar) {
        com.qq.e.comm.plugin.i.d.b(str, eVar);
    }

    @Override // com.qq.e.comm.plugin.i.d0.b
    public void c() {
    }

    public d(Context context, com.qq.e.comm.plugin.apkmanager.w.a aVar) {
        this.f44096a = new WeakReference<>(context);
        this.f44097b = new WeakReference<>(aVar);
    }

    @Override // com.qq.e.comm.plugin.i.d0.b
    public void a(String str) {
        Context context = this.f44096a.get();
        if (context instanceof Activity) {
            new com.qq.e.comm.plugin.r0.e(context).b(str);
        }
    }

    @Override // com.qq.e.comm.plugin.i.d0.b
    public void b(String str) {
        Context context = this.f44096a.get();
        if (context == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str));
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    @Override // com.qq.e.comm.plugin.i.d0.b
    public boolean a(String str, e eVar) {
        if (eVar == null) {
            return false;
        }
        return com.qq.e.comm.plugin.i.d.a(str, eVar);
    }

    @Override // com.qq.e.comm.plugin.i.d0.b
    public void a(boolean z3) {
        if (z3) {
            return;
        }
        e2.d("\u8df3\u8f6c\u5931\u8d25\uff0c\u53ef\u80fd\u672a\u5b89\u88c5\u5e94\u7528\u3002");
    }

    @Override // com.qq.e.comm.plugin.i.d0.b
    public void a(com.qq.e.comm.plugin.g0.b bVar) {
        if (bVar == null) {
            return;
        }
        String a4 = bVar.a();
        int j4 = bVar.j();
        if (com.qq.e.comm.plugin.apkmanager.w.d.e(j4)) {
            e2.d("\u6b63\u5728\u52aa\u529b\u4e0b\u8f7d\uff0c\u8bf7\u8010\u5fc3\u7b49\u5f85");
        } else if (com.qq.e.comm.plugin.apkmanager.w.d.d(j4)) {
            e2.d("\u5f00\u59cb\u5b89\u88c5" + a4);
        } else if (j4 == 0) {
            e2.d("\u5f00\u59cb\u4e0b\u8f7d" + a4);
        }
    }

    @Override // com.qq.e.comm.plugin.i.d0.b
    public void b() {
        e2.d("\u672a\u77e5\u5f02\u5e38\uff0c\u7a0d\u540e\u91cd\u8bd5");
    }

    @Override // com.qq.e.comm.plugin.i.d0.b
    public void a(e eVar, DownloadConfirmListener downloadConfirmListener, com.qq.e.comm.plugin.i.d0.c cVar, int i4) {
        Activity b4 = k.b(this.f44096a.get());
        if (b4 == null) {
            if (cVar != null) {
                cVar.a(false);
            }
        } else if (downloadConfirmListener != null) {
            int i5 = com.qq.e.comm.plugin.apkmanager.w.d.d(i4) ? 257 : 1;
            if (cVar != null) {
                cVar.a(true);
            }
            downloadConfirmListener.onDownloadConfirm(b4, i5, eVar.r(), new a(cVar));
            InterfaceC0844d interfaceC0844d = this.f44098c;
            if (interfaceC0844d != null) {
                interfaceC0844d.a();
            }
        } else {
            f.a(b4, eVar, new b(cVar), i4);
        }
    }

    @Override // com.qq.e.comm.plugin.i.d0.b
    public com.qq.e.comm.plugin.apkmanager.w.a a() {
        return this.f44097b.get();
    }

    public void a(e eVar) {
        DialogStateCallback dialogStateCallback;
        if (eVar == null || (dialogStateCallback = (DialogStateCallback) com.qq.e.comm.plugin.h.a.b(eVar.l0(), DialogStateCallback.class)) == null) {
            return;
        }
        this.f44098c = new c(this, dialogStateCallback);
    }
}
