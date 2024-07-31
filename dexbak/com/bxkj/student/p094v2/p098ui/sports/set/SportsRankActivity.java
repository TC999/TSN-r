package com.bxkj.student.p094v2.p098ui.sports.set;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import com.bxkj.base.p085v2.base.BaseActivity;
import com.bxkj.student.databinding.AcV2SportsRankBinding;
import com.bxkj.student.p094v2.p103vm.sports.set.SportsRankVM;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;

/* compiled from: SportsRankActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\t"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/set/SportsRankActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcV2SportsRankBinding;", "Lcom/bxkj/student/v2/vm/sports/set/SportsRankVM;", "Lkotlin/f1;", ExifInterface.LONGITUDE_EAST, "p", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.set.SportsRankActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class SportsRankActivity extends BaseActivity<AcV2SportsRankBinding, SportsRankVM> {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static final void m38605d(SportsRankActivity this$0, Map map) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.mo43920M().setDataMap(map);
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        mo43920M().setMActvity(this);
        mo43911x().m37934u();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
        mo43911x().m37935t().observe(mo43912w(), new Observer() { // from class: com.bxkj.student.v2.ui.sports.set.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SportsRankActivity.m38605d(SportsRankActivity.this, (Map) obj);
            }
        });
    }
}
