package com.acse.ottn.animator.a;

import android.view.View;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class w extends com.acse.ottn.animator.b.a<View> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public w(String str) {
        super(str);
    }

    @Override // com.acse.ottn.animator.b.d
    public Float a(View view) {
        return Float.valueOf(com.acse.ottn.animator.c.a.a.a(view).l());
    }

    @Override // com.acse.ottn.animator.b.a
    public void a(View view, float f4) {
        com.acse.ottn.animator.c.a.a.a(view).j(f4);
    }
}
