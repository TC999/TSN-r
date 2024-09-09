package com.beizi.ad.internal.animation;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public enum TransitionType {
    NONE,
    RANDOM,
    FADE,
    PUSH,
    MOVEIN,
    REVEAL;

    public static TransitionType getTypeForInt(int i4) {
        TransitionType[] values;
        for (TransitionType transitionType : values()) {
            if (transitionType.ordinal() == i4) {
                return transitionType;
            }
        }
        return NONE;
    }
}
