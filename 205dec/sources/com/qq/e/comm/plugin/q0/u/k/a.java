package com.qq.e.comm.plugin.q0.u.k;

import com.qq.e.comm.plugin.q0.h;
import com.qq.e.comm.plugin.q0.s.d;
import com.qq.e.comm.plugin.q0.s.e;
import com.qq.e.comm.plugin.q0.s.g;
import com.qq.e.comm.plugin.q0.u.i;
import com.qq.e.comm.plugin.q0.u.k.b;
import com.qq.e.comm.plugin.util.d0;
import com.qq.e.comm.plugin.util.d1;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a extends i {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.q0.u.k.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class C0880a implements b.InterfaceC0881b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f45623a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f45624b;

        C0880a(a aVar, g gVar, d dVar) {
            this.f45623a = gVar;
            this.f45624b = dVar;
        }

        @Override // com.qq.e.comm.plugin.q0.u.k.b.InterfaceC0881b
        public void a(JSONObject jSONObject) {
            d1.a("CellularNetRequestHandler result " + jSONObject, new Object[0]);
            this.f45623a.a(new e(this.f45624b, e.a.f45548c, jSONObject));
        }
    }

    private void a(g gVar, d dVar) {
        d0.f46406b.submit(new b(dVar.d().optString("url"), new C0880a(this, gVar, dVar)));
    }

    @Override // com.qq.e.comm.plugin.q0.u.i
    public String a() {
        return "requestByCellularNetwork";
    }

    @Override // com.qq.e.comm.plugin.q0.u.i
    public void a(h hVar, d dVar) {
        a(hVar.c(), dVar);
    }
}
