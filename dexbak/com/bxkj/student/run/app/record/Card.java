package com.bxkj.student.run.app.record;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.bxkj.student.C4215R;
import com.bxkj.student.run.app.ready.RunType;
import com.github.mikephil.charting.utils.Utils;
import java.text.DecimalFormat;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class Card extends FrameLayout {

    /* renamed from: a */
    private int f19302a;

    /* renamed from: b */
    private Context f19303b;

    public Card(Context mContext) {
        super(mContext);
        this.f19303b = mContext;
        LayoutInflater.from(mContext).inflate(C4215R.C4221layout.card_recorder, this);
    }

    /* renamed from: d */
    private String m39864d(@RunType int runType) {
        if (runType != 1) {
            if (runType != 2) {
                if (runType != 3) {
                    return this.f19303b.getString(C4215R.C4224string.free_run);
                }
                return this.f19303b.getString(C4215R.C4224string.free_run);
            }
            return this.f19303b.getString(C4215R.C4224string.sunshine_run);
        }
        return this.f19303b.getString(C4215R.C4224string.morning_run);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static /* synthetic */ void m39863e(TextView textView, ValueAnimator valueAnimator) {
        textView.setText(valueAnimator.getAnimatedValue().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static /* synthetic */ Double m39862f(float f, Double d, Double d2) {
        double d3 = f;
        Double.isNaN(d3);
        return Double.valueOf((d2.doubleValue() - d.doubleValue()) * d3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public static /* synthetic */ void m39861g(TextView textView, ValueAnimator valueAnimator) {
        textView.setText(new DecimalFormat("0.000").format(((Double) valueAnimator.getAnimatedValue()).doubleValue()));
    }

    public int getRunType() {
        return this.f19302a;
    }

    /* renamed from: h */
    public Card m39860h(int bgColor) {
        ((CardView) findViewById(C4215R.C4219id.card1)).setCardBackgroundColor(bgColor);
        return this;
    }

    /* renamed from: i */
    public Card m39859i(int runType) {
        ((TextView) findViewById(2131233204)).setText(m39864d(runType) + "记录");
        this.f19302a = runType;
        return this;
    }

    public void setCount(int count) {
        final TextView textView = (TextView) findViewById(2131232914);
        ValueAnimator ofInt = ValueAnimator.ofInt(0, count);
        ofInt.setDuration(1000L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bxkj.student.run.app.record.h
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Card.m39863e(textView, valueAnimator);
            }
        });
        ofInt.start();
    }

    public void setDistance(double distance) {
        final TextView textView = (TextView) findViewById(2131232941);
        ValueAnimator ofObject = ValueAnimator.ofObject(new TypeEvaluator() { // from class: com.bxkj.student.run.app.record.f
            @Override // android.animation.TypeEvaluator
            public final Object evaluate(float f, Object obj, Object obj2) {
                Double m39862f;
                m39862f = Card.m39862f(f, (Double) obj, (Double) obj2);
                return m39862f;
            }
        }, Double.valueOf((double) Utils.DOUBLE_EPSILON), Double.valueOf(distance));
        ofObject.setDuration(1000L);
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bxkj.student.run.app.record.g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Card.m39861g(textView, valueAnimator);
            }
        });
        ofObject.start();
    }
}
