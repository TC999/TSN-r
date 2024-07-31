package com.beizi.p051ad.internal.animation;

/* renamed from: com.beizi.ad.internal.animation.TransitionType */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public enum TransitionType {
    NONE,
    RANDOM,
    FADE,
    PUSH,
    MOVEIN,
    REVEAL;

    public static TransitionType getTypeForInt(int i) {
        TransitionType[] values;
        for (TransitionType transitionType : values()) {
            if (transitionType.ordinal() == i) {
                return transitionType;
            }
        }
        return NONE;
    }
}
