package com.bxkj.student.p094v2.p098ui.sports.p102v3.record;

import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import cn.bluemobi.dylan.base.adapter.FragmentTabAdapter;
import com.bxkj.base.p085v2.base.BaseActivity;
import com.bxkj.student.C4215R;
import com.bxkj.student.common.utils.C4254l;
import com.bxkj.student.databinding.AcV3RecordListBinding;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.record.tab.V3RecordInValidFragment;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.record.tab.V3RecordValidFragment;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.record.tab.V3StatisticsFragment;
import com.bxkj.student.p094v2.p103vm.sports.record.RecordVM;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import kotlin.Metadata;

/* compiled from: V3RecordListActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/record/V3RecordListActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcV3RecordListBinding;", "Lcom/bxkj/student/v2/vm/sports/record/RecordVM;", "Lkotlin/f1;", ExifInterface.LONGITUDE_EAST, "p", "", "i", "Z", "toLocal", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.record.V3RecordListActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class V3RecordListActivity extends BaseActivity<AcV3RecordListBinding, RecordVM> {

    /* renamed from: i */
    private boolean f20720i;

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        TabLayout.Tab tabAt;
        if (getIntent().hasExtra("toLocal")) {
            this.f20720i = getIntent().getBooleanExtra("toLocal", false);
        }
        C4254l.m42811g(mo43912w(), ContextCompat.getColor(mo43926C(), C4215R.C4217color.v3_tab_color3));
        mo43920M().setMActivity(this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new V3StatisticsFragment());
        arrayList.add(new V3RecordValidFragment());
        arrayList.add(new V3RecordInValidFragment());
        new FragmentTabAdapter(getSupportFragmentManager(), arrayList, 2131232182, mo43920M().f16279tb);
        if ((this.f20720i ? this : null) == null || (tabAt = mo43920M().f16279tb.getTabAt(2)) == null) {
            return;
        }
        tabAt.select();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
    }
}
