package com.qq.e.dl.l.k.g;

import com.qq.e.dl.i.g;
import com.qq.e.dl.k.j;
import com.qq.e.dl.l.h;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c extends com.qq.e.dl.l.k.d<com.qq.e.dl.l.k.g.b> {

    /* renamed from: x  reason: collision with root package name */
    private final e f47208x;

    /* renamed from: y  reason: collision with root package name */
    private d f47209y;

    /* renamed from: z  reason: collision with root package name */
    private com.qq.e.dl.l.k.g.a f47210z;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b implements h.e {
        @Override // com.qq.e.dl.l.h.e
        public h a(com.qq.e.dl.a aVar) {
            if (com.qq.e.comm.plugin.j.c.a.a()) {
                return new c(aVar);
            }
            return null;
        }
    }

    @Override // com.qq.e.dl.l.h
    public void a(g gVar, com.qq.e.dl.l.g gVar2, JSONObject jSONObject) {
        Map<String, j> map;
        g[] gVarArr = gVar.f46974b;
        if (gVarArr != null && gVarArr.length > 0) {
            Map<String, com.qq.e.dl.k.c> map2 = gVar.f46977e;
            d dVar = new d((map2 != null && map2.containsKey("50")) || ((map = gVar.f46975c) != null && map.containsKey("50")), gVarArr, gVar2, this);
            this.f47209y = dVar;
            this.f47208x.setAdapter(dVar);
            this.f47210z = new com.qq.e.dl.l.k.g.a(this);
        }
        super.a(gVar, gVar2, jSONObject);
    }

    @Override // com.qq.e.dl.l.k.d, com.qq.e.dl.l.h
    public void c(JSONObject jSONObject) {
        d dVar = this.f47209y;
        if (dVar != null && !dVar.a()) {
            this.f47209y.a(jSONObject);
        }
        super.c(jSONObject);
    }

    @Override // com.qq.e.dl.l.k.d
    public boolean v() {
        return true;
    }

    @Override // com.qq.e.dl.l.h
    /* renamed from: y */
    public e m() {
        return this.f47208x;
    }

    private c(com.qq.e.dl.a aVar) {
        super(aVar);
        e eVar = new e(aVar.b());
        this.f47208x = eVar;
        eVar.a(this);
        this.f47070h = new com.qq.e.dl.l.k.g.b(this, this.f47208x);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.qq.e.dl.l.k.d, com.qq.e.dl.l.h
    public boolean a(String str, com.qq.e.dl.k.g gVar) {
        char c4;
        switch (str.hashCode()) {
            case 1691:
                if (str.equals("50")) {
                    c4 = 0;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1692:
                if (str.equals("51")) {
                    c4 = 3;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1693:
                if (str.equals("52")) {
                    c4 = 1;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1694:
                if (str.equals("53")) {
                    c4 = 2;
                    break;
                }
                c4 = '\uffff';
                break;
            default:
                c4 = '\uffff';
                break;
        }
        if (c4 == 0) {
            d dVar = this.f47209y;
            if (dVar != null && dVar.a()) {
                this.f47209y.a(gVar.c(new JSONObject[0]));
            }
        } else if (c4 == 1) {
            int b4 = gVar.b(new JSONObject[0]);
            d dVar2 = this.f47209y;
            if (dVar2 != null) {
                dVar2.a((b4 & 2) != 0);
            }
            com.qq.e.dl.l.k.g.a aVar = this.f47210z;
            if (aVar != null) {
                aVar.a((b4 & 1) == 0);
                this.f47210z.b(b4 & 28);
            }
        } else if (c4 == 2) {
            com.qq.e.dl.l.k.g.a aVar2 = this.f47210z;
            if (aVar2 != null) {
                aVar2.c(gVar.b(new JSONObject[0]));
            }
        } else if (c4 != 3) {
            return super.a(str, gVar);
        } else {
            ((com.qq.e.dl.l.k.g.b) this.f47070h).a(gVar.b(new JSONObject[0]));
        }
        return true;
    }

    @Override // com.qq.e.dl.l.k.d, com.qq.e.dl.l.h
    public void a(h.d dVar) {
        d dVar2 = this.f47209y;
        if (dVar2 != null) {
            dVar2.a(dVar);
        }
    }
}
