package com.bxkj.student.v2.ui.sports.set;

import androidx.lifecycle.Observer;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.student.databinding.AcV2SportsRankBinding;
import com.bxkj.student.v2.vm.sports.set.SportsRankVM;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: SportsRankActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/set/SportsRankActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcV2SportsRankBinding;", "Lcom/bxkj/student/v2/vm/sports/set/SportsRankVM;", "Lkotlin/f1;", "E", "p", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class SportsRankActivity extends BaseActivity<AcV2SportsRankBinding, SportsRankVM> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(SportsRankActivity this$0, Map map) {
        f0.p(this$0, "this$0");
        this$0.M().setDataMap(map);
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        M().setMActvity(this);
        x().u();
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        x().t().observe(w(), new Observer() { // from class: com.bxkj.student.v2.ui.sports.set.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SportsRankActivity.d(SportsRankActivity.this, (Map) obj);
            }
        });
    }
}
