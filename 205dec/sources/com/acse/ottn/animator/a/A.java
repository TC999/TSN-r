package com.acse.ottn.animator.a;

import android.view.View;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class A extends com.acse.ottn.animator.b.a<View> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public A(String str) {
        super(str);
    }

    @Override // com.acse.ottn.animator.b.d
    public Float a(View view) {
        return Float.valueOf(com.acse.ottn.animator.c.a.a.a(view).g());
    }

    @Override // com.acse.ottn.animator.b.a
    public void a(View view, float f4) {
        com.acse.ottn.animator.c.a.a.a(view).g(f4);
    }
}