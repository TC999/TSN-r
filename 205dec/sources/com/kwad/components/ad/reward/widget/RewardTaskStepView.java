package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.components.ad.reward.l.c;
import com.kwad.sdk.R;
import com.kwad.sdk.n.l;
import com.kwad.sdk.widget.DividerView;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class RewardTaskStepView extends LinearLayout {
    private List<c> Bq;
    private String pZ;

    public RewardTaskStepView(Context context) {
        super(context);
        this.Bq = new ArrayList();
        kf();
    }

    private void ad(boolean z3) {
        DividerView dividerView = (DividerView) l.a(getContext(), R.layout.ksad_reward_task_dialog_dash, this, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ksad_reward_apk_info_card_step_icon_size);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ksad_reward_apk_info_card_step_divider_height);
        dividerView.setDividerColor(getResources().getColor(z3 ? R.color.ksad_reward_main_color : R.color.ksad_reward_undone_color));
        addView(dividerView, dimensionPixelSize, dimensionPixelSize2);
    }

    private void kf() {
        setOrientation(1);
    }

    private void kg() {
        int size = this.Bq.size();
        int i4 = 0;
        while (i4 < size) {
            c cVar = this.Bq.get(i4);
            int i5 = i4 + 1;
            a(i5, cVar.ju(), cVar.jv(), cVar.isCompleted());
            if (i4 < size - 1) {
                ad(this.Bq.get(i5).isCompleted());
            }
            i4 = i5;
        }
    }

    public final void a(List<c> list, String str) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.pZ = str;
        this.Bq.clear();
        this.Bq.addAll(list);
        kg();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public RewardTaskStepView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Bq = new ArrayList();
        kf();
    }

    private void a(int i4, String str, String str2, boolean z3) {
        ViewGroup viewGroup = (ViewGroup) l.a(getContext(), z3 ? R.layout.ksad_reward_task_step_item_checked : R.layout.ksad_reward_task_step_item_unchecked, this, false);
        if (z3) {
            a(viewGroup, str);
        } else {
            a(viewGroup, i4, str2);
        }
        addView(viewGroup);
    }

    public RewardTaskStepView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.Bq = new ArrayList();
        kf();
    }

    @RequiresApi(api = 21)
    public RewardTaskStepView(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.Bq = new ArrayList();
        kf();
    }

    private static void a(ViewGroup viewGroup, String str) {
        ((TextView) viewGroup.findViewById(R.id.ksad_reward_task_step_item_text)).setText(str);
    }

    private void a(ViewGroup viewGroup, int i4, String str) {
        ((TextView) viewGroup.findViewById(R.id.ksad_reward_task_step_item_text)).setText(String.format(str, this.pZ));
        ((TextView) viewGroup.findViewById(R.id.ksad_reward_task_step_item_icon_text)).setText(String.valueOf(i4));
    }
}
