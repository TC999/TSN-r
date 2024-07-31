package com.bxkj.student.p094v2.p098ui.sports.p102v3.detail;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import cn.bluemobi.dylan.base.view.NoSlidingViewPager;
import com.bxkj.base.p085v2.base.BaseActivity;
import com.bxkj.student.C4215R;
import com.bxkj.student.common.utils.C4254l;
import com.bxkj.student.databinding.AcV3RecordDetailBinding;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.detail.tab.BasicFragment;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.detail.tab.DataFragment;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.detail.tab.V3RecordChartFragment;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.detail.tab.V3RecordTraceFragment;
import com.bxkj.student.p094v2.p103vm.sports.record.RecordDetailVM;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: V3RecordDetailActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\b\u0010\u000b\u001a\u00020\u0004H\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/detail/V3RecordDetailActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcV3RecordDetailBinding;", "Lcom/bxkj/student/v2/vm/sports/record/RecordDetailVM;", "Lkotlin/f1;", "P", ExifInterface.LONGITUDE_EAST, "N", "Q", "R", ExifInterface.LATITUDE_SOUTH, "p", "Lcom/bxkj/student/v2/ui/sports/v3/detail/tab/V3RecordTraceFragment;", "i", "Lcom/bxkj/student/v2/ui/sports/v3/detail/tab/V3RecordTraceFragment;", "recordTraceFragment", "", "", "j", "[Ljava/lang/String;", "titles", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class V3RecordDetailActivity extends BaseActivity<AcV3RecordDetailBinding, RecordDetailVM> {

    /* renamed from: i */
    private V3RecordTraceFragment f20677i;
    @NotNull

    /* renamed from: j */
    private final String[] f20678j = {"概况", "轨迹", "图表", "数据"};

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public static final void m38445O(V3RecordDetailActivity this$0) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.m38444P();
    }

    /* renamed from: P */
    private final void m38444P() {
        final ArrayList arrayList = new ArrayList();
        this.f20677i = new V3RecordTraceFragment();
        arrayList.add(new BasicFragment());
        V3RecordTraceFragment v3RecordTraceFragment = this.f20677i;
        if (v3RecordTraceFragment == null) {
            C14342f0.m8200S("recordTraceFragment");
            v3RecordTraceFragment = null;
        }
        arrayList.add(v3RecordTraceFragment);
        arrayList.add(new V3RecordChartFragment());
        arrayList.add(new DataFragment());
        NoSlidingViewPager noSlidingViewPager = mo43920M().viewPager;
        final FragmentManager supportFragmentManager = getSupportFragmentManager();
        noSlidingViewPager.setAdapter(new FragmentPagerAdapter(supportFragmentManager) { // from class: com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity$setData$1
            @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
            public void destroyItem(@NotNull ViewGroup container, int i, @NotNull Object object) {
                C14342f0.m8184p(container, "container");
                C14342f0.m8184p(object, "object");
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                return arrayList.size();
            }

            @Override // androidx.fragment.app.FragmentPagerAdapter
            @NotNull
            public Fragment getItem(int i) {
                return arrayList.get(i);
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            @Nullable
            public CharSequence getPageTitle(int i) {
                String[] strArr;
                strArr = V3RecordDetailActivity.this.f20678j;
                return strArr[i];
            }
        });
        mo43920M().f16278tb.setupWithViewPager(mo43920M().viewPager);
        if (getIntent().hasExtra("exerciseRecordId")) {
            mo43911x().m37987F(getIntent().getStringExtra("exerciseRecordId"));
        }
        if (getIntent().hasExtra("identify")) {
            mo43911x().m37986G(getIntent().getStringExtra("identify"));
        }
        m38446N();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        mo43920M().setMActivity(this);
        C4254l.m42811g(mo43912w(), ContextCompat.getColor(mo43926C(), C4215R.C4217color.v3_tab_color3));
        mo43920M().setMActivity(this);
        getWindow().getDecorView().post(new Runnable() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.a
            @Override // java.lang.Runnable
            public final void run() {
                V3RecordDetailActivity.m38445O(V3RecordDetailActivity.this);
            }
        });
    }

    /* renamed from: N */
    public final void m38446N() {
        if (TextUtils.isEmpty(mo43911x().m37992A())) {
            mo43911x().m37979x();
        } else {
            mo43911x().m37980w();
        }
    }

    /* renamed from: Q */
    public final void m38443Q() {
        V3RecordTraceFragment v3RecordTraceFragment = this.f20677i;
        if (v3RecordTraceFragment == null) {
            C14342f0.m8200S("recordTraceFragment");
            v3RecordTraceFragment = null;
        }
        v3RecordTraceFragment.m38401W();
    }

    /* renamed from: R */
    public final void m38442R() {
        new V3ExceptionDialog().show(mo43923J(), "V3ExceptionDialog");
    }

    /* renamed from: S */
    public final void m38441S() {
        new V3RankTipsDialog().show(mo43923J(), "showRankTipsDialog");
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
    }
}
