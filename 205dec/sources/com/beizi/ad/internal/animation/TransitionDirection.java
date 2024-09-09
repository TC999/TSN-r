package com.beizi.ad.internal.animation;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public enum TransitionDirection {
    UP,
    DOWN,
    RIGHT,
    LEFT;

    public static TransitionDirection getDirectionForInt(int i4) {
        TransitionDirection[] values;
        for (TransitionDirection transitionDirection : values()) {
            if (transitionDirection.ordinal() == i4) {
                return transitionDirection;
            }
        }
        return UP;
    }
}
