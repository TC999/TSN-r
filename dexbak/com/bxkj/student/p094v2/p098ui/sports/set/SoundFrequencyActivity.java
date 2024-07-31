package com.bxkj.student.p094v2.p098ui.sports.set;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.exifinterface.media.ExifInterface;
import com.bxkj.base.p085v2.base.BaseActivity;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.student.databinding.AcV2SoundSetFrequencyBinding;
import com.bxkj.student.p094v2.p103vm.sports.set.SoundFrequencySetVM;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;

/* compiled from: SoundFrequencyActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\t"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/set/SoundFrequencyActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcV2SoundSetFrequencyBinding;", "Lcom/bxkj/student/v2/vm/sports/set/SoundFrequencySetVM;", "Lkotlin/f1;", ExifInterface.LONGITUDE_EAST, "p", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.set.SoundFrequencyActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class SoundFrequencyActivity extends BaseActivity<AcV2SoundSetFrequencyBinding, SoundFrequencySetVM> {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static final void m38610d(SoundFrequencyActivity this$0, RadioGroup radioGroup, int i) {
        C14342f0.m8184p(this$0, "this$0");
        LoggedInUser.f15182b.m43634a().m43683H(this$0.mo43920M().f16277rg.indexOfChild(this$0.mo43920M().f16277rg.findViewById(i)));
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        mo43920M().setMActivity(this);
        View childAt = mo43920M().f16277rg.getChildAt(LoggedInUser.f15182b.m43634a().m43655g());
        if (childAt == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.RadioButton");
        }
        ((RadioButton) childAt).setChecked(true);
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
        mo43920M().f16277rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.bxkj.student.v2.ui.sports.set.a
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                SoundFrequencyActivity.m38610d(SoundFrequencyActivity.this, radioGroup, i);
            }
        });
    }
}
