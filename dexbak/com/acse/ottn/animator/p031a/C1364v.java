package com.acse.ottn.animator.p031a;

import android.view.View;
import com.acse.ottn.animator.p032b.AbstractC1370a;
import com.acse.ottn.animator.p033c.p034a.C1378a;

/* renamed from: com.acse.ottn.animator.a.v */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1364v extends AbstractC1370a<View> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C1364v(String str) {
        super(str);
    }

    @Override // com.acse.ottn.animator.p032b.AbstractC1373d
    /* renamed from: a */
    public Float mo57003a(View view) {
        return Float.valueOf(C1378a.m56966a(view).m56925k());
    }

    @Override // com.acse.ottn.animator.p032b.AbstractC1370a
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo57011a(View view, float f) {
        C1378a.m56966a(view).m56932i(f);
    }
}
