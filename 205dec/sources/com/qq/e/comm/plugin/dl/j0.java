package com.qq.e.comm.plugin.dl;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.dl.l.h;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class j0 extends com.qq.e.dl.l.a<b> {

    /* renamed from: x  reason: collision with root package name */
    private String f42473x;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a implements h.e {
        @Override // com.qq.e.dl.l.h.e
        public com.qq.e.dl.l.h a(com.qq.e.dl.a aVar) {
            return new j0(aVar);
        }
    }

    j0(com.qq.e.dl.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.a
    /* renamed from: b */
    public b a(com.qq.e.dl.a aVar) {
        return new b(aVar.b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.h
    public void u() {
        super.u();
        if (this.f47079q.a()) {
            m().setWillNotDraw(false);
        }
        if (TextUtils.isEmpty(this.f42473x)) {
            return;
        }
        ((b) this.f47039w).a(this.f42473x);
        this.f42473x = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.h
    public boolean a(String str, com.qq.e.dl.k.g gVar) {
        char c4;
        int hashCode = str.hashCode();
        if (hashCode != -1169023802) {
            if (hashCode == 116079 && str.equals("url")) {
                c4 = 1;
            }
            c4 = '\uffff';
        } else {
            if (str.equals("adModel")) {
                c4 = 0;
            }
            c4 = '\uffff';
        }
        if (c4 == 0) {
            ((b) this.f47039w).b((com.qq.e.comm.plugin.g0.e) gVar.c(new JSONObject[0]));
        } else if (c4 != 1) {
            return super.a(str, gVar);
        } else {
            this.f42473x = gVar.toString();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b extends com.qq.e.dl.l.k.e.c {

        /* renamed from: d  reason: collision with root package name */
        private com.qq.e.comm.plugin.q0.h f42474d;

        public b(Context context) {
            super(context);
        }

        void a(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (this.f42474d == null) {
                a((com.qq.e.comm.plugin.g0.e) null);
            }
            this.f42474d.loadUrl(str);
        }

        void b(com.qq.e.comm.plugin.g0.e eVar) {
            if (eVar == null || this.f42474d != null) {
                return;
            }
            a(eVar);
        }

        private void a(com.qq.e.comm.plugin.g0.e eVar) {
            com.qq.e.comm.plugin.q0.h a4 = new com.qq.e.comm.plugin.q0.d(getContext(), eVar, true).a();
            this.f42474d = a4;
            addView(a4.a());
        }
    }
}
