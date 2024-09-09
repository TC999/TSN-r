package com.bxkj.student.v2.ui.sports.v3.detail;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import cn.bluemobi.dylan.base.view.NoSlidingViewPager;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.common.utils.m;
import com.bxkj.student.databinding.AcV3RecordDetailBinding;
import com.bxkj.student.v2.common.utils.e;
import com.bxkj.student.v2.common.utils.i;
import com.bxkj.student.v2.ui.sports.v3.detail.tab.BasicFragment;
import com.bxkj.student.v2.ui.sports.v3.detail.tab.DataFragment;
import com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment;
import com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordTraceFragment;
import com.bxkj.student.v2.vm.sports.record.RecordDetailVM;
import d2.l;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.z0;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: V3RecordDetailActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\b\u0010\u000b\u001a\u00020\u0004H\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/detail/V3RecordDetailActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcV3RecordDetailBinding;", "Lcom/bxkj/student/v2/vm/sports/record/RecordDetailVM;", "Lkotlin/f1;", "P", "E", "N", "Q", "R", "S", "p", "Lcom/bxkj/student/v2/ui/sports/v3/detail/tab/V3RecordTraceFragment;", "i", "Lcom/bxkj/student/v2/ui/sports/v3/detail/tab/V3RecordTraceFragment;", "recordTraceFragment", "", "", "j", "[Ljava/lang/String;", "titles", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class V3RecordDetailActivity extends BaseActivity<AcV3RecordDetailBinding, RecordDetailVM> {

    /* renamed from: i  reason: collision with root package name */
    private V3RecordTraceFragment f24092i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final String[] f24093j = {"\u6982\u51b5", "\u8f68\u8ff9", "\u56fe\u8868", "\u6570\u636e"};

    /* compiled from: V3RecordDetailActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0000H\n"}, d2 = {"", "", "", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static final class a extends Lambda implements l<Map<String, ? extends Object>, f1> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Bitmap f24095b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Bitmap bitmap) {
            super(1);
            this.f24095b = bitmap;
        }

        public final void a(@NotNull Map<String, ? extends Object> it) {
            Map<String, ? extends Object> j02;
            f0.p(it, "it");
            File a4 = e.f23349a.a(V3RecordDetailActivity.this.C(), this.f24095b);
            if (a4 != null) {
                i iVar = i.f23368a;
                Context C = V3RecordDetailActivity.this.C();
                m mVar = m.a;
                j02 = z0.j0(l0.a("name", mVar.t(it, "name")), l0.a("linkUrl", mVar.t(it, "linkUrl")), l0.a("imagePath", a4.getPath()));
                iVar.d(C, j02);
            }
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(Map<String, ? extends Object> map) {
            a(map);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(V3RecordDetailActivity this$0) {
        f0.p(this$0, "this$0");
        this$0.P();
    }

    private final void P() {
        final ArrayList arrayList = new ArrayList();
        this.f24092i = new V3RecordTraceFragment();
        arrayList.add(new BasicFragment());
        V3RecordTraceFragment v3RecordTraceFragment = this.f24092i;
        if (v3RecordTraceFragment == null) {
            f0.S("recordTraceFragment");
            v3RecordTraceFragment = null;
        }
        arrayList.add(v3RecordTraceFragment);
        arrayList.add(new V3RecordChartFragment());
        arrayList.add(new DataFragment());
        NoSlidingViewPager noSlidingViewPager = M().viewPager;
        final FragmentManager supportFragmentManager = getSupportFragmentManager();
        noSlidingViewPager.setAdapter(new FragmentPagerAdapter(supportFragmentManager) { // from class: com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity$setData$1
            @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
            public void destroyItem(@NotNull ViewGroup container, int i4, @NotNull Object object) {
                f0.p(container, "container");
                f0.p(object, "object");
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                return arrayList.size();
            }

            @Override // androidx.fragment.app.FragmentPagerAdapter
            @NotNull
            public Fragment getItem(int i4) {
                return arrayList.get(i4);
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            @Nullable
            public CharSequence getPageTitle(int i4) {
                String[] strArr;
                strArr = V3RecordDetailActivity.this.f24093j;
                return strArr[i4];
            }
        });
        M().tb.setupWithViewPager(M().viewPager);
        if (getIntent().hasExtra("exerciseRecordId")) {
            x().F(getIntent().getStringExtra("exerciseRecordId"));
        }
        if (getIntent().hasExtra("identify")) {
            x().G(getIntent().getStringExtra("identify"));
        }
        N();
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        M().setMActivity(this);
        com.bxkj.student.common.utils.l.g(w(), ContextCompat.getColor(C(), 2131034571));
        M().setMActivity(this);
        getWindow().getDecorView().post(new Runnable() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.a
            @Override // java.lang.Runnable
            public final void run() {
                V3RecordDetailActivity.O(V3RecordDetailActivity.this);
            }
        });
    }

    public final void N() {
        if (TextUtils.isEmpty(x().A())) {
            x().x();
        } else {
            x().w();
        }
    }

    public final void Q() {
        V3RecordTraceFragment v3RecordTraceFragment = this.f24092i;
        if (v3RecordTraceFragment == null) {
            f0.S("recordTraceFragment");
            v3RecordTraceFragment = null;
        }
        v3RecordTraceFragment.W();
    }

    public final void R() {
        new V3ExceptionDialog().show(J(), "V3ExceptionDialog");
    }

    public final void S() {
        new V3RankTipsDialog().show(J(), "showRankTipsDialog");
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
