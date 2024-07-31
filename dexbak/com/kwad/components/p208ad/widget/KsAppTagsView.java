package com.kwad.components.p208ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.p445n.C10887l;
import java.util.List;

/* renamed from: com.kwad.components.ad.widget.KsAppTagsView */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KsAppTagsView extends LinearLayout {

    /* renamed from: Id */
    private int f28014Id;

    public KsAppTagsView(Context context) {
        super(context);
        this.f28014Id = 3;
    }

    /* renamed from: a */
    public final void m30444a(List<String> list, @LayoutRes int i) {
        if (list == null) {
            return;
        }
        int i2 = 0;
        for (String str : list) {
            i2++;
            if (i2 > this.f28014Id) {
                return;
            }
            m30445a(this, str, i);
        }
    }

    public void setAppTags(List<String> list) {
        m30444a(list, C9659R.C9663layout.ksad_reward_apk_info_card_tag_item);
    }

    public void setMaxCount(int i) {
        this.f28014Id = i;
    }

    public KsAppTagsView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28014Id = 3;
    }

    /* renamed from: a */
    private static void m30445a(LinearLayout linearLayout, String str, @LayoutRes int i) {
        TextView textView = (TextView) C10887l.m24563a(linearLayout.getContext(), i, linearLayout, false);
        textView.setText(str);
        linearLayout.addView(textView);
    }

    public KsAppTagsView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28014Id = 3;
    }

    @RequiresApi(api = 21)
    public KsAppTagsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f28014Id = 3;
    }
}
