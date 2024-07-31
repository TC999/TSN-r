package com.romainpiel.shimmer;

import com.romainpiel.shimmer.ShimmerViewHelper;

/* renamed from: com.romainpiel.shimmer.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface ShimmerViewBase {
    /* renamed from: a */
    boolean mo20279a();

    /* renamed from: b */
    boolean mo20278b();

    float getGradientX();

    int getPrimaryColor();

    int getReflectionColor();

    void setAnimationSetupCallback(ShimmerViewHelper.InterfaceC11839a interfaceC11839a);

    void setGradientX(float f);

    void setPrimaryColor(int i);

    void setReflectionColor(int i);

    void setShimmering(boolean z);
}
