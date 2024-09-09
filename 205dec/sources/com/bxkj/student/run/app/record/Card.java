package com.bxkj.student.run.app.record;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.bxkj.student.run.app.ready.RunType;
import java.text.DecimalFormat;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class Card extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f22538a;

    /* renamed from: b  reason: collision with root package name */
    private Context f22539b;

    public Card(Context mContext) {
        super(mContext);
        this.f22539b = mContext;
        LayoutInflater.from(mContext).inflate(2131427561, this);
    }

    private String d(@RunType int runType) {
        if (runType != 1) {
            if (runType != 2) {
                if (runType != 3) {
                    return this.f22539b.getString(2131820816);
                }
                return this.f22539b.getString(2131820816);
            }
            return this.f22539b.getString(2131821368);
        }
        return this.f22539b.getString(2131821059);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(TextView textView, ValueAnimator valueAnimator) {
        textView.setText(valueAnimator.getAnimatedValue().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double f(float f4, Double d4, Double d5) {
        double d6 = f4;
        Double.isNaN(d6);
        return Double.valueOf((d5.doubleValue() - d4.doubleValue()) * d6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(TextView textView, ValueAnimator valueAnimator) {
        textView.setText(new DecimalFormat("0.000").format(((Double) valueAnimator.getAnimatedValue()).doubleValue()));
    }

    public int getRunType() {
        return this.f22538a;
    }

    public Card h(int bgColor) {
        ((CardView) findViewById(2131231052)).setCardBackgroundColor(bgColor);
        return this;
    }

    public Card i(int runType) {
        ((TextView) findViewById(2131233204)).setText(d(runType) + "\u8bb0\u5f55");
        this.f22538a = runType;
        return this;
    }

    public void setCount(int count) {
        final TextView textView = (TextView) findViewById(2131232914);
        ValueAnimator ofInt = ValueAnimator.ofInt(0, count);
        ofInt.setDuration(1000L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bxkj.student.run.app.record.h
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Card.e(textView, valueAnimator);
            }
        });
        ofInt.start();
    }

    public void setDistance(double distance) {
        final TextView textView = (TextView) findViewById(2131232941);
        ValueAnimator ofObject = ValueAnimator.ofObject(new TypeEvaluator() { // from class: com.bxkj.student.run.app.record.f
            @Override // android.animation.TypeEvaluator
            public final Object evaluate(float f4, Object obj, Object obj2) {
                Double f5;
                f5 = Card.f(f4, (Double) obj, (Double) obj2);
                return f5;
            }
        }, Double.valueOf(0.0d), Double.valueOf(distance));
        ofObject.setDuration(1000L);
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bxkj.student.run.app.record.g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Card.g(textView, valueAnimator);
            }
        });
        ofObject.start();
    }
}
