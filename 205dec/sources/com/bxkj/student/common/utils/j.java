package com.bxkj.student.common.utils;

import android.media.SoundPool;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: R8$$SyntheticClass */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final /* synthetic */ class j implements SoundPool.OnLoadCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SoundUtils f19638a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f19639b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f19640c;

    public /* synthetic */ j(SoundUtils soundUtils, int i4, float f4) {
        this.f19638a = soundUtils;
        this.f19639b = i4;
        this.f19640c = f4;
    }

    @Override // android.media.SoundPool.OnLoadCompleteListener
    public final void onLoadComplete(SoundPool soundPool, int i4, int i5) {
        SoundUtils.l(this.f19638a, this.f19639b, this.f19640c, soundPool, i4, i5);
    }
}
