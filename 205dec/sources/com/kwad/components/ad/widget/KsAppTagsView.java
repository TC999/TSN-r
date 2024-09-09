package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;
import com.kwad.sdk.n.l;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class KsAppTagsView extends LinearLayout {
    private int Id;

    public KsAppTagsView(Context context) {
        super(context);
        this.Id = 3;
    }

    public final void a(List<String> list, @LayoutRes int i4) {
        if (list == null) {
            return;
        }
        int i5 = 0;
        for (String str : list) {
            i5++;
            if (i5 > this.Id) {
                return;
            }
            a(this, str, i4);
        }
    }

    public void setAppTags(List<String> list) {
        a(list, R.layout.ksad_reward_apk_info_card_tag_item);
    }

    public void setMaxCount(int i4) {
        this.Id = i4;
    }

    public KsAppTagsView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Id = 3;
    }

    private static void a(LinearLayout linearLayout, String str, @LayoutRes int i4) {
        TextView textView = (TextView) l.a(linearLayout.getContext(), i4, linearLayout, false);
        textView.setText(str);
        linearLayout.addView(textView);
    }

    public KsAppTagsView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.Id = 3;
    }

    @RequiresApi(api = 21)
    public KsAppTagsView(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.Id = 3;
    }
}
