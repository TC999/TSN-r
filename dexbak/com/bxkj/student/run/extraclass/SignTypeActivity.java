package com.bxkj.student.run.extraclass;

import androidx.exifinterface.media.ExifInterface;
import com.bxkj.base.p085v2.base.BaseActivity;
import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.student.databinding.AcExtraExerciseTypeBinding;
import kotlin.Metadata;

/* compiled from: SignTypeActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004¨\u0006\u000b"}, m12616d2 = {"Lcom/bxkj/student/run/extraclass/SignTypeActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcExtraExerciseTypeBinding;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Lkotlin/f1;", ExifInterface.LONGITUDE_EAST, "p", "N", "O", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class SignTypeActivity extends BaseActivity<AcExtraExerciseTypeBinding, BaseViewModel> {
    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        mo43920M().setSignTypeActivity(this);
    }

    /* renamed from: N */
    public final void m39460N() {
        startActivity(getIntent().setClass(mo43926C(), QrScanSignActivity.class).putExtra("signType", "1"));
    }

    /* renamed from: O */
    public final void m39459O() {
        startActivity(getIntent().setClass(mo43926C(), QrScanSignActivity.class).putExtra("signType", "0"));
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
    }
}
