package com.bxkj.student.v2.ui.sports.set;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.student.databinding.AcV2SoundSetFrequencyBinding;
import com.bxkj.student.v2.vm.sports.set.SoundFrequencySetVM;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: SoundFrequencyActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/set/SoundFrequencyActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcV2SoundSetFrequencyBinding;", "Lcom/bxkj/student/v2/vm/sports/set/SoundFrequencySetVM;", "Lkotlin/f1;", "E", "p", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class SoundFrequencyActivity extends BaseActivity<AcV2SoundSetFrequencyBinding, SoundFrequencySetVM> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(SoundFrequencyActivity this$0, RadioGroup radioGroup, int i4) {
        f0.p(this$0, "this$0");
        com.bxkj.base.v2.data.a.b.a().H(this$0.M().rg.indexOfChild(this$0.M().rg.findViewById(i4)));
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        M().setMActivity(this);
        View childAt = M().rg.getChildAt(com.bxkj.base.v2.data.a.b.a().g());
        if (childAt == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.RadioButton");
        }
        ((RadioButton) childAt).setChecked(true);
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        M().rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.bxkj.student.v2.ui.sports.set.a
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i4) {
                SoundFrequencyActivity.d(SoundFrequencyActivity.this, radioGroup, i4);
            }
        });
    }
}
