package com.acse.ottn.adapter;

import android.view.View;
import com.acse.ottn.adapter.d;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f4784a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d f4785b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, int i4) {
        this.f4785b = dVar;
        this.f4784a = i4;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar;
        d.a aVar;
        b bVar2;
        d.a aVar2;
        List list;
        bVar = this.f4785b.f4789d;
        bVar.d();
        aVar = this.f4785b.f4790e;
        if (aVar != null) {
            aVar2 = this.f4785b.f4790e;
            int a4 = this.f4784a % this.f4785b.a();
            list = this.f4785b.f4787b;
            aVar2.a(a4, list.get(this.f4784a % this.f4785b.a()));
        }
        bVar2 = this.f4785b.f4789d;
        bVar2.c();
    }
}
