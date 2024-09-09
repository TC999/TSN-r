package com.beizi.ad.internal.animation;

import java.util.ArrayList;
import java.util.Collections;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AnimationFactory {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* renamed from: com.beizi.ad.internal.animation.AnimationFactory$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$beizi$ad$internal$animation$TransitionType;

        static {
            int[] iArr = new int[TransitionType.values().length];
            $SwitchMap$com$beizi$ad$internal$animation$TransitionType = iArr;
            try {
                iArr[TransitionType.FADE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$beizi$ad$internal$animation$TransitionType[TransitionType.PUSH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$beizi$ad$internal$animation$TransitionType[TransitionType.MOVEIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$beizi$ad$internal$animation$TransitionType[TransitionType.REVEAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static Transition create(TransitionType transitionType, long j4, TransitionDirection transitionDirection) {
        TransitionType transitionType2 = TransitionType.RANDOM;
        if (transitionType == transitionType2) {
            ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, TransitionType.values());
            arrayList.remove(TransitionType.NONE);
            arrayList.remove(transitionType2);
            Collections.shuffle(arrayList);
            transitionType = (TransitionType) arrayList.get(0);
        }
        int i4 = AnonymousClass1.$SwitchMap$com$beizi$ad$internal$animation$TransitionType[transitionType.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        return null;
                    }
                    return new Reveal(j4, transitionDirection);
                }
                return new MoveIn(j4, transitionDirection);
            }
            return new Push(j4, transitionDirection);
        }
        return new Fade(j4);
    }
}
