package com.baidu.mobads.sdk.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class cq extends i {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ cp f12710b;

    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface a {
        void onAttachedToWindow();

        @SuppressLint({"MissingSuperCall"})
        void onDetachedFromWindow();

        boolean onKeyDown(int i4, KeyEvent keyEvent);

        void onLayoutComplete(int i4, int i5);

        void onWindowFocusChanged(boolean z3);

        void onWindowVisibilityChanged(int i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(cp cpVar) {
        this.f12710b = cpVar;
    }

    @Override // com.baidu.mobads.sdk.internal.i
    protected Object i() {
        String a4;
        String a5;
        Context context;
        String a6;
        try {
            a4 = this.f12710b.a("key_crash_trace");
            a5 = this.f12710b.a("key_crash_ad");
            if (TextUtils.isEmpty(a4)) {
                return null;
            }
            cm a7 = cm.a();
            context = this.f12710b.f12708m;
            a7.a(context);
            a6 = this.f12710b.a("key_crash_source");
            a7.a(a6, a4, a5);
            this.f12710b.g();
            return null;
        } catch (Exception e4) {
            bv.a().a(e4);
            return null;
        }
    }
}
