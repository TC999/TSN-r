package com.bxkj.base.v2.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import com.bxkj.base.R;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class SportCardView extends FrameLayout {
    public SportCardView(Context context) {
        this(context, null);
    }

    public SportCardView(@NonNull @NotNull Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SportCardView(@NonNull @NotNull Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        LayoutInflater.from(context).inflate(R.layout.sport_recorder_card, this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SportCardView);
        String string = obtainStyledAttributes.getString(R.styleable.SportCardView_cardTitle);
        String string2 = obtainStyledAttributes.getString(R.styleable.SportCardView_count);
        String string3 = obtainStyledAttributes.getString(R.styleable.SportCardView_distance);
        int color = obtainStyledAttributes.getColor(R.styleable.SportCardView_bgColor, -16776961);
        obtainStyledAttributes.recycle();
        ((CardView) findViewById(R.id.card)).setCardBackgroundColor(color);
        ((TextView) findViewById(R.id.tv_title)).setText(string);
        ((TextView) findViewById(R.id.tv_count)).setText(string2);
        ((TextView) findViewById(R.id.tv_distance)).setText(string3);
    }
}
