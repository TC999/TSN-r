package com.bxkj.base.p085v2.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import com.bxkj.base.C3801R;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.bxkj.base.v2.common.view.SportCardView */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SportCardView extends FrameLayout {
    public SportCardView(Context context) {
        this(context, null);
    }

    public SportCardView(@NonNull @NotNull Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SportCardView(@NonNull @NotNull Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(C3801R.C3807layout.sport_recorder_card, this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3801R.styleable.SportCardView);
        String string = obtainStyledAttributes.getString(C3801R.styleable.SportCardView_cardTitle);
        String string2 = obtainStyledAttributes.getString(C3801R.styleable.SportCardView_count);
        String string3 = obtainStyledAttributes.getString(C3801R.styleable.SportCardView_distance);
        int color = obtainStyledAttributes.getColor(C3801R.styleable.SportCardView_bgColor, -16776961);
        obtainStyledAttributes.recycle();
        ((CardView) findViewById(C3801R.C3805id.card)).setCardBackgroundColor(color);
        ((TextView) findViewById(C3801R.C3805id.tv_title)).setText(string);
        ((TextView) findViewById(C3801R.C3805id.tv_count)).setText(string2);
        ((TextView) findViewById(C3801R.C3805id.tv_distance)).setText(string3);
    }
}
