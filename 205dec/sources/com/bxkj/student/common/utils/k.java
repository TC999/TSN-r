package com.bxkj.student.common.utils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: R8$$SyntheticClass */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SoundUtils f19641a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f19642b;

    public /* synthetic */ k(SoundUtils soundUtils, int i4) {
        this.f19641a = soundUtils;
        this.f19642b = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SoundUtils.e(this.f19641a, this.f19642b);
    }
}
