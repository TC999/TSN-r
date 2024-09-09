package com.bxkj.student.run.extraclass;

import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.student.databinding.AcExtraExerciseTypeBinding;
import kotlin.Metadata;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: SignTypeActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/bxkj/student/run/extraclass/SignTypeActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcExtraExerciseTypeBinding;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Lkotlin/f1;", "E", "p", "N", "O", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class SignTypeActivity extends BaseActivity<AcExtraExerciseTypeBinding, BaseViewModel> {
    @Override // com.bxkj.base.v2.base.a
    public void E() {
        M().setSignTypeActivity(this);
    }

    public final void N() {
        startActivity(getIntent().setClass(C(), QrScanSignActivity.class).putExtra("signType", "1"));
    }

    public final void O() {
        startActivity(getIntent().setClass(C(), QrScanSignActivity.class).putExtra("signType", "0"));
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
