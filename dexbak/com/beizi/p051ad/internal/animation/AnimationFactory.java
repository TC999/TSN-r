package com.beizi.p051ad.internal.animation;

import java.util.ArrayList;
import java.util.Collections;

/* renamed from: com.beizi.ad.internal.animation.AnimationFactory */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AnimationFactory {

    /* renamed from: com.beizi.ad.internal.animation.AnimationFactory$1 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static /* synthetic */ class C28581 {
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

    public static Transition create(TransitionType transitionType, long j, TransitionDirection transitionDirection) {
        TransitionType transitionType2 = TransitionType.RANDOM;
        if (transitionType == transitionType2) {
            ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, TransitionType.values());
            arrayList.remove(TransitionType.NONE);
            arrayList.remove(transitionType2);
            Collections.shuffle(arrayList);
            transitionType = (TransitionType) arrayList.get(0);
        }
        int i = C28581.$SwitchMap$com$beizi$ad$internal$animation$TransitionType[transitionType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return new Reveal(j, transitionDirection);
                }
                return new MoveIn(j, transitionDirection);
            }
            return new Push(j, transitionDirection);
        }
        return new Fade(j);
    }
}
