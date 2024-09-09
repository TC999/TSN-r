package com.bxkj.student.v2.ui.sports.v3.record;

import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.adapter.b;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.student.common.utils.l;
import com.bxkj.student.databinding.AcV3RecordListBinding;
import com.bxkj.student.v2.ui.sports.v3.record.tab.V3RecordInValidFragment;
import com.bxkj.student.v2.ui.sports.v3.record.tab.V3RecordValidFragment;
import com.bxkj.student.v2.ui.sports.v3.record.tab.V3StatisticsFragment;
import com.bxkj.student.v2.vm.sports.record.RecordVM;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: V3RecordListActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/record/V3RecordListActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcV3RecordListBinding;", "Lcom/bxkj/student/v2/vm/sports/record/RecordVM;", "Lkotlin/f1;", "E", "p", "", "i", "Z", "toLocal", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class V3RecordListActivity extends BaseActivity<AcV3RecordListBinding, RecordVM> {

    /* renamed from: i  reason: collision with root package name */
    private boolean f24139i;

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        TabLayout.Tab tabAt;
        if (getIntent().hasExtra("toLocal")) {
            this.f24139i = getIntent().getBooleanExtra("toLocal", false);
        }
        l.g(w(), ContextCompat.getColor(C(), 2131034571));
        M().setMActivity(this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new V3StatisticsFragment());
        arrayList.add(new V3RecordValidFragment());
        arrayList.add(new V3RecordInValidFragment());
        new b(getSupportFragmentManager(), arrayList, 2131232182, M().tb);
        if ((this.f24139i ? this : null) == null || (tabAt = M().tb.getTabAt(2)) == null) {
            return;
        }
        tabAt.select();
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
