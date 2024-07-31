package com.beizi.p051ad.internal.animation;

/* renamed from: com.beizi.ad.internal.animation.TransitionDirection */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public enum TransitionDirection {
    UP,
    DOWN,
    RIGHT,
    LEFT;

    public static TransitionDirection getDirectionForInt(int i) {
        TransitionDirection[] values;
        for (TransitionDirection transitionDirection : values()) {
            if (transitionDirection.ordinal() == i) {
                return transitionDirection;
            }
        }
        return UP;
    }
}
