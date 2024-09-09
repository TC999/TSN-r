package com.qq.e.comm.plugin.dl;

import android.content.Context;
import android.view.View;
import com.qq.e.dl.l.h;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class z extends com.qq.e.dl.l.a<c> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b implements h.e {
        @Override // com.qq.e.dl.l.h.e
        public com.qq.e.dl.l.h a(com.qq.e.dl.a aVar) {
            return new z(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class c extends com.qq.e.comm.plugin.fs.f.e.a implements com.qq.e.dl.l.e {

        /* renamed from: m  reason: collision with root package name */
        private com.qq.e.dl.l.h f42651m;

        public c(Context context) {
            super(context);
        }

        @Override // com.qq.e.dl.l.e
        public void a(com.qq.e.dl.l.h hVar) {
            this.f42651m = hVar;
        }

        @Override // android.view.View
        protected void onVisibilityChanged(View view, int i4) {
            this.f42651m.a(view, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.a
    /* renamed from: b */
    public c a(com.qq.e.dl.a aVar) {
        return new c(aVar.b());
    }

    private z(com.qq.e.dl.a aVar) {
        super(aVar);
        this.f47076n.a("3", com.qq.e.dl.k.l.c((Object) 124));
        this.f47076n.a("4", com.qq.e.dl.k.l.c((Object) 40));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.qq.e.dl.l.h
    public boolean a(String str, com.qq.e.dl.k.g gVar) {
        char c4;
        int hashCode = str.hashCode();
        if (hashCode == -1169023802) {
            if (str.equals("adModel")) {
                c4 = 6;
            }
            c4 = '\uffff';
        } else if (hashCode == 57) {
            if (str.equals("9")) {
                c4 = 4;
            }
            c4 = '\uffff';
        } else if (hashCode == 51) {
            if (str.equals("3")) {
                c4 = 0;
            }
            c4 = '\uffff';
        } else if (hashCode != 52) {
            switch (hashCode) {
                case 1567:
                    if (str.equals("10")) {
                        c4 = 5;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1568:
                    if (str.equals("11")) {
                        c4 = 2;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1569:
                    if (str.equals("12")) {
                        c4 = 3;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                default:
                    c4 = '\uffff';
                    break;
            }
        } else {
            if (str.equals("4")) {
                c4 = 1;
            }
            c4 = '\uffff';
        }
        switch (c4) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                break;
            default:
                return super.a(str, gVar);
            case 6:
                ((c) this.f47039w).a((com.qq.e.comm.plugin.g0.e) gVar.c(new JSONObject[0]));
                break;
        }
        return true;
    }
}
