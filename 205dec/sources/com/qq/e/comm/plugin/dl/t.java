package com.qq.e.comm.plugin.dl;

import android.content.Context;
import android.widget.ImageView;
import com.qq.e.dl.l.h;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class t extends com.qq.e.dl.l.a<c> {

    /* renamed from: x  reason: collision with root package name */
    private com.qq.e.comm.plugin.g0.e f42602x;

    /* renamed from: y  reason: collision with root package name */
    private int f42603y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f42604z;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b implements h.e {
        @Override // com.qq.e.dl.l.h.e
        public com.qq.e.dl.l.h a(com.qq.e.dl.a aVar) {
            return new t(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class c extends ImageView implements com.qq.e.dl.l.e {
        public c(Context context) {
            super(context);
        }

        @Override // com.qq.e.dl.l.e
        public void a(com.qq.e.dl.l.h hVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.a
    /* renamed from: b */
    public c a(com.qq.e.dl.a aVar) {
        return new c(aVar.b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.h
    public void u() {
        super.u();
        com.qq.e.comm.plugin.g0.e eVar = this.f42602x;
        if (eVar == null) {
            return;
        }
        boolean z3 = !this.f42604z && com.qq.e.comm.plugin.util.l.a(eVar);
        com.qq.e.comm.plugin.util.l.a((ImageView) this.f47039w, this.f42603y, this.f42604z, z3);
        if (z3) {
            List<com.qq.e.dl.l.j.c> h4 = h();
            com.qq.e.dl.l.j.c cVar = null;
            Iterator<com.qq.e.dl.l.j.c> it = h4.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.qq.e.dl.l.j.c next = it.next();
                if (next.f47120a == 1) {
                    cVar = next;
                    break;
                }
            }
            if (cVar == null) {
                h4.add(new com.qq.e.dl.l.j.c(1, "adLogoClick"));
                d();
            }
        }
    }

    private t(com.qq.e.dl.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.h
    public boolean a(String str, com.qq.e.dl.k.g gVar) {
        char c4;
        int hashCode = str.hashCode();
        if (hashCode == -1169023802) {
            if (str.equals("adModel")) {
                c4 = 0;
            }
            c4 = '\uffff';
        } else if (hashCode != -737911981) {
            if (hashCode == 3281 && str.equals("fw")) {
                c4 = 2;
            }
            c4 = '\uffff';
        } else {
            if (str.equals("iconType")) {
                c4 = 1;
            }
            c4 = '\uffff';
        }
        if (c4 == 0) {
            this.f42602x = (com.qq.e.comm.plugin.g0.e) gVar.c(new JSONObject[0]);
        } else if (c4 == 1) {
            this.f42603y = gVar.b(new JSONObject[0]);
        } else if (c4 != 2) {
            return super.a(str, gVar);
        } else {
            this.f42604z = gVar.b(new JSONObject[0]) == 1;
        }
        return true;
    }
}
