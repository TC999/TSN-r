package com.kwad.components.p208ad.reward.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.components.p208ad.reward.p260l.InterfaceC8013c;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.widget.DividerView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.components.ad.reward.widget.RewardTaskStepView */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class RewardTaskStepView extends LinearLayout {

    /* renamed from: Bq */
    private List<InterfaceC8013c> f27536Bq;

    /* renamed from: pZ */
    private String f27537pZ;

    public RewardTaskStepView(Context context) {
        super(context);
        this.f27536Bq = new ArrayList();
        m30964kf();
    }

    /* renamed from: ad */
    private void m30965ad(boolean z) {
        DividerView dividerView = (DividerView) C10887l.m24563a(getContext(), C9659R.C9663layout.ksad_reward_task_dialog_dash, this, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(C9659R.dimen.ksad_reward_apk_info_card_step_icon_size);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(C9659R.dimen.ksad_reward_apk_info_card_step_divider_height);
        dividerView.setDividerColor(getResources().getColor(z ? C9659R.C9660color.ksad_reward_main_color : C9659R.C9660color.ksad_reward_undone_color));
        addView(dividerView, dimensionPixelSize, dimensionPixelSize2);
    }

    /* renamed from: kf */
    private void m30964kf() {
        setOrientation(1);
    }

    /* renamed from: kg */
    private void m30963kg() {
        int size = this.f27536Bq.size();
        int i = 0;
        while (i < size) {
            InterfaceC8013c interfaceC8013c = this.f27536Bq.get(i);
            int i2 = i + 1;
            m30969a(i2, interfaceC8013c.mo31868ju(), interfaceC8013c.mo31867jv(), interfaceC8013c.isCompleted());
            if (i < size - 1) {
                m30965ad(this.f27536Bq.get(i2).isCompleted());
            }
            i = i2;
        }
    }

    /* renamed from: a */
    public final void m30966a(List<InterfaceC8013c> list, String str) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f27537pZ = str;
        this.f27536Bq.clear();
        this.f27536Bq.addAll(list);
        m30963kg();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public RewardTaskStepView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f27536Bq = new ArrayList();
        m30964kf();
    }

    /* renamed from: a */
    private void m30969a(int i, String str, String str2, boolean z) {
        ViewGroup viewGroup = (ViewGroup) C10887l.m24563a(getContext(), z ? C9659R.C9663layout.ksad_reward_task_step_item_checked : C9659R.C9663layout.ksad_reward_task_step_item_unchecked, this, false);
        if (z) {
            m30967a(viewGroup, str);
        } else {
            m30968a(viewGroup, i, str2);
        }
        addView(viewGroup);
    }

    public RewardTaskStepView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27536Bq = new ArrayList();
        m30964kf();
    }

    @RequiresApi(api = 21)
    public RewardTaskStepView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f27536Bq = new ArrayList();
        m30964kf();
    }

    /* renamed from: a */
    private static void m30967a(ViewGroup viewGroup, String str) {
        ((TextView) viewGroup.findViewById(C9659R.C9662id.ksad_reward_task_step_item_text)).setText(str);
    }

    /* renamed from: a */
    private void m30968a(ViewGroup viewGroup, int i, String str) {
        ((TextView) viewGroup.findViewById(C9659R.C9662id.ksad_reward_task_step_item_text)).setText(String.format(str, this.f27537pZ));
        ((TextView) viewGroup.findViewById(C9659R.C9662id.ksad_reward_task_step_item_icon_text)).setText(String.valueOf(i));
    }
}
