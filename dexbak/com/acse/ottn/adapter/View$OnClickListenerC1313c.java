package com.acse.ottn.adapter;

import android.view.View;
import com.acse.ottn.adapter.AbstractC1314d;
import java.util.List;

/* renamed from: com.acse.ottn.adapter.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class View$OnClickListenerC1313c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f2233a;

    /* renamed from: b */
    final /* synthetic */ AbstractC1314d f2234b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1313c(AbstractC1314d abstractC1314d, int i) {
        this.f2234b = abstractC1314d;
        this.f2233a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1310b c1310b;
        AbstractC1314d.InterfaceC1315a interfaceC1315a;
        C1310b c1310b2;
        AbstractC1314d.InterfaceC1315a interfaceC1315a2;
        List list;
        c1310b = this.f2234b.f2238d;
        c1310b.m57232d();
        interfaceC1315a = this.f2234b.f2239e;
        if (interfaceC1315a != null) {
            interfaceC1315a2 = this.f2234b.f2239e;
            int m57228a = this.f2233a % this.f2234b.m57228a();
            list = this.f2234b.f2236b;
            interfaceC1315a2.mo57217a(m57228a, list.get(this.f2233a % this.f2234b.m57228a()));
        }
        c1310b2 = this.f2234b.f2238d;
        c1310b2.m57234c();
    }
}
