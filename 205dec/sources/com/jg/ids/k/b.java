package com.jg.ids.k;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\93344.dex */
public final class b extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private String f37856a;

    /* renamed from: b  reason: collision with root package name */
    private int f37857b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ a f37858c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, Handler handler, String str, int i4) {
        super(null);
        this.f37858c = aVar;
        this.f37856a = str;
        this.f37857b = i4;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z3) {
        super.onChange(z3);
        this.f37858c.b(this.f37857b, this.f37856a);
    }
}
