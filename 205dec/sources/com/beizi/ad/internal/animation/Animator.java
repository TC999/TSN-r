package com.beizi.ad.internal.animation;

import android.content.Context;
import android.widget.ViewAnimator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class Animator extends ViewAnimator {
    private Transition animation;
    private TransitionDirection direction;
    private long duration;
    private TransitionType type;

    public Animator(Context context, TransitionType transitionType, TransitionDirection transitionDirection, long j4) {
        super(context);
        this.animation = null;
        this.type = transitionType;
        this.direction = transitionDirection;
        this.duration = j4;
        this.animation = AnimationFactory.create(transitionType, j4, transitionDirection);
        setAnimation();
    }

    @Override // android.view.View
    public void clearAnimation() {
        setInAnimation(null);
        setOutAnimation(null);
    }

    public TransitionDirection getTransitionDirection() {
        return this.direction;
    }

    public long getTransitionDuration() {
        return this.duration;
    }

    public TransitionType getTransitionType() {
        return this.type;
    }

    public void setAnimation() {
        Transition transition = this.animation;
        if (transition != null) {
            setInAnimation(transition.getInAnimation());
            setOutAnimation(this.animation.getOutAnimation());
        }
    }

    public void setTransitionDirection(TransitionDirection transitionDirection) {
        if (this.direction != transitionDirection) {
            this.direction = transitionDirection;
            this.animation = AnimationFactory.create(this.type, this.duration, transitionDirection);
            setAnimation();
        }
    }

    public void setTransitionDuration(long j4) {
        if (this.duration != j4) {
            this.duration = j4;
            this.animation = AnimationFactory.create(this.type, j4, this.direction);
            setAnimation();
        }
    }

    public void setTransitionType(TransitionType transitionType) {
        if (this.type != transitionType) {
            this.type = transitionType;
            this.animation = AnimationFactory.create(transitionType, this.duration, this.direction);
            setAnimation();
        }
    }
}
