package com.bxkj.student.p094v2.p098ui.sports.set;

import androidx.exifinterface.media.ExifInterface;
import com.bxkj.base.p085v2.base.BaseActivity;
import com.bxkj.student.databinding.AcV2SportsSetBinding;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.record.V3RecordListActivity;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.set.V3StatisticsActivity;
import com.bxkj.student.p094v2.p103vm.sports.set.SportsSetVM;
import kotlin.Metadata;

/* compiled from: SportsSetActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004¨\u0006\u000f"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/set/SportsSetActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcV2SportsSetBinding;", "Lcom/bxkj/student/v2/vm/sports/set/SportsSetVM;", "Lkotlin/f1;", ExifInterface.LONGITUDE_EAST, "p", "N", "P", "O", "R", "Q", ExifInterface.LATITUDE_SOUTH, "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.set.SportsSetActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class SportsSetActivity extends BaseActivity<AcV2SportsSetBinding, SportsSetVM> {
    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        mo43920M().setMSportsSetActivity(this);
    }

    /* renamed from: N */
    public final void m38604N() {
        startActivity(getIntent().setClass(mo43926C(), SportsDescriptionActivity.class).putExtra("showBottom", false));
    }

    /* renamed from: O */
    public final void m38603O() {
        startActivity(getIntent().setClass(mo43926C(), SportsRankActivity.class));
    }

    /* renamed from: P */
    public final void m38602P() {
        startActivity(getIntent().setClass(mo43926C(), V3RecordListActivity.class));
    }

    /* renamed from: Q */
    public final void m38601Q() {
        startActivity(getIntent().setClass(mo43926C(), SoundFrequencyActivity.class));
    }

    /* renamed from: R */
    public final void m38600R() {
        startActivity(getIntent().setClass(mo43926C(), V3StatisticsActivity.class));
    }

    /* renamed from: S */
    public final void m38599S() {
        startActivity(getIntent().setClass(mo43926C(), PermissionSetActivity.class));
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
    }
}
