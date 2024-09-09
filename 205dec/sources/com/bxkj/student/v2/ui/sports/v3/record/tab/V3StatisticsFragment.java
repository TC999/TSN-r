package com.bxkj.student.v2.ui.sports.v3.record.tab;

import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import cn.bluemobi.dylan.base.utils.u;
import com.bxkj.base.v2.base.BaseFragment;
import com.bxkj.base.v2.common.utils.e;
import com.bxkj.base.v2.common.utils.l;
import com.bxkj.student.databinding.FmV3RecordListTotalBinding;
import com.bxkj.student.v2.ui.sports.set.statistics.tab.StatisticsFragment;
import com.bxkj.student.v2.vm.sports.set.SportsStatisticsVM;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType;
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement;
import com.github.aachartmodel.aainfographics.aatools.AAColorKt;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.v;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: V3StatisticsFragment.kt */
@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/record/tab/V3StatisticsFragment;", "Lcom/bxkj/base/v2/base/BaseFragment;", "Lcom/bxkj/student/databinding/FmV3RecordListTotalBinding;", "Lcom/bxkj/student/v2/vm/sports/set/SportsStatisticsVM;", "", "position", "", "", "", "it", "Lkotlin/f1;", "h", "i", "E", "p", "", "", "j", "Ljava/util/List;", "listData", "", "k", "xTitle", "Lcom/bxkj/student/v2/ui/sports/set/statistics/tab/StatisticsFragment;", "l", "Lcom/bxkj/student/v2/ui/sports/set/statistics/tab/StatisticsFragment;", "statisticsFragment", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class V3StatisticsFragment extends BaseFragment<FmV3RecordListTotalBinding, SportsStatisticsVM> {
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private List<Double> f24161j = v.E();
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private List<String> f24162k = new ArrayList();
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private StatisticsFragment f24163l;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3StatisticsFragment.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/record/tab/V3StatisticsFragment$a", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", "Lkotlin/f1;", "onTabSelected", "onTabUnselected", "onTabReselected", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a implements TabLayout.OnTabSelectedListener {
        a() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(@Nullable TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(@Nullable TabLayout.Tab tab) {
            Map<String, Object> value = V3StatisticsFragment.this.x().t().getValue();
            if (value == null) {
                return;
            }
            V3StatisticsFragment v3StatisticsFragment = V3StatisticsFragment.this;
            if (tab == null) {
                return;
            }
            v3StatisticsFragment.h(tab.getPosition(), value);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(@Nullable TabLayout.Tab tab) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(V3StatisticsFragment this$0, Map it) {
        f0.p(this$0, "this$0");
        int selectedTabPosition = this$0.M().tbType.getSelectedTabPosition();
        f0.o(it, "it");
        this$0.h(selectedTabPosition, it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(int i4, Map<String, Object> map) {
        this.f24162k.clear();
        int i5 = 0;
        if (i4 == 0) {
            TextView textView = M().tvDay;
            l lVar = l.f18624a;
            textView.setText(lVar.t(map, "weekDay"));
            TextView textView2 = M().tvAvgDistance;
            e eVar = e.f18604a;
            textView2.setText(eVar.a(lVar.f(map, "weekAvgRange")));
            M().tvAvgCount.setText(lVar.t(map, "weekAvgCount"));
            M().tvAvgTime.setText(lVar.t(map, "weekAvgTime"));
            M().tvDistance.setText(eVar.a(lVar.f(map, "weekTotalMileage")));
            M().tvCount.setText(lVar.t(map, "weekNum"));
            M().tvTime.setText(lVar.t(map, "weekTime"));
            M().tvHeart.setText(lVar.t(map, "weekCalorie"));
            M().tvPace.setText(lVar.t(map, "weekAvgSpeed"));
            M().tvStep.setText(lVar.t(map, "weekAvgstep"));
            M().tvStepDistance.setText(lVar.t(map, "weekStride"));
            List<Double> h4 = lVar.h(map, "week");
            this.f24161j = h4;
            for (Object obj : h4) {
                int i6 = i5 + 1;
                if (i5 < 0) {
                    v.W();
                }
                ((Number) obj).doubleValue();
                List<String> list = this.f24162k;
                String n4 = u.n(i6);
                f0.o(n4, "changeWeekToHanzi(index+1)");
                list.add(n4);
                i5 = i6;
            }
        } else if (i4 != 1) {
            TextView textView3 = M().tvDay;
            l lVar2 = l.f18624a;
            textView3.setText(lVar2.t(map, "sysTermDay"));
            TextView textView4 = M().tvAvgDistance;
            e eVar2 = e.f18604a;
            textView4.setText(eVar2.a(lVar2.f(map, "sysTermAvgRange")));
            M().tvAvgCount.setText(lVar2.t(map, "sysTermAvgCount"));
            M().tvAvgTime.setText(lVar2.t(map, "sysTermAvgTime"));
            M().tvDistance.setText(eVar2.a(lVar2.f(map, "sysTermTotalMileage")));
            M().tvCount.setText(lVar2.t(map, "sysTermNum"));
            M().tvTime.setText(lVar2.t(map, "sysTermTime"));
            M().tvPace.setText(lVar2.t(map, "sysTermAvgSpeed"));
            M().tvHeart.setText(lVar2.t(map, "sysTermCalorie"));
            M().tvStep.setText(lVar2.t(map, "sysTermAvgstep"));
            M().tvStepDistance.setText(lVar2.t(map, "sysTermStride"));
            List<Double> h5 = lVar2.h(map, "sysTerm");
            this.f24161j = h5;
            for (Object obj2 : h5) {
                int i7 = i5 + 1;
                if (i5 < 0) {
                    v.W();
                }
                ((Number) obj2).doubleValue();
                List<String> list2 = this.f24162k;
                StringBuilder sb = new StringBuilder();
                sb.append(i7);
                sb.append('\u5468');
                list2.add(sb.toString());
                i5 = i7;
            }
        } else {
            TextView textView5 = M().tvDay;
            l lVar3 = l.f18624a;
            textView5.setText(lVar3.t(map, "monthDay"));
            TextView textView6 = M().tvAvgDistance;
            e eVar3 = e.f18604a;
            textView6.setText(eVar3.a(lVar3.f(map, "monthAvgRange")));
            M().tvAvgCount.setText(lVar3.t(map, "monthAvgCount"));
            M().tvAvgTime.setText(lVar3.t(map, "monthAvgTime"));
            M().tvDistance.setText(eVar3.a(lVar3.f(map, "monthTotalMileage")));
            M().tvCount.setText(lVar3.t(map, "monthNum"));
            M().tvTime.setText(lVar3.t(map, "monthTime"));
            M().tvPace.setText(lVar3.t(map, "monthAvgSpeed"));
            M().tvHeart.setText(lVar3.t(map, "monthCalorie"));
            M().tvStep.setText(lVar3.t(map, "monthAvgstep"));
            M().tvStepDistance.setText(lVar3.t(map, "monthStride"));
            List<Double> h6 = lVar3.h(map, "month");
            this.f24161j = h6;
            for (Object obj3 : h6) {
                int i8 = i5 + 1;
                if (i5 < 0) {
                    v.W();
                }
                ((Number) obj3).doubleValue();
                List<String> list3 = this.f24162k;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i8);
                sb2.append('\u65e5');
                list3.add(sb2.toString());
                i5 = i8;
            }
        }
        StatisticsFragment statisticsFragment = this.f24163l;
        if (statisticsFragment == null) {
            return;
        }
        statisticsFragment.h(i4 + 1, map);
    }

    private final void i() {
        AAChartModel yAxisTitle = new AAChartModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 4095, null).chartType(AAChartType.Column).title("").subtitle("").yAxisTitle("");
        Boolean bool = Boolean.FALSE;
        AAChartModel dataLabelsEnabled = yAxisTitle.dataLabelsEnabled(bool);
        Boolean bool2 = Boolean.TRUE;
        AAChartModel yAxisGridLineWidth = dataLabelsEnabled.yAxisLabelsEnabled(bool2).xAxisLabelsEnabled(bool2).legendEnabled(bool).tooltipEnabled(bool).yAxisGridLineWidth(0);
        Object[] array = this.f24162k.toArray(new String[0]);
        if (array != null) {
            AAChartModel yAxisVisible = yAxisGridLineWidth.categories((String[]) array).yAxisVisible(bool2);
            Object[] objArr = new Object[1];
            AASeriesElement color = new AASeriesElement().name("").lineWidth(0).enableMouseTracking(bool2).borderRadius(Float.valueOf(8.0f)).color(AAColorKt.AARgba(0, 203, 134, 1.0f));
            Object[] array2 = this.f24161j.toArray(new Object[0]);
            if (array2 != null) {
                objArr[0] = color.data(array2);
                M().AAChartView.aa_drawChartWithChartModel(yAxisVisible.series(objArr));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        x().u();
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        Fragment findFragmentById = getChildFragmentManager().findFragmentById(2131231317);
        if (findFragmentById != null) {
            this.f24163l = (StatisticsFragment) findFragmentById;
            M().tbType.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new a());
            x().t().observe(w(), new Observer() { // from class: com.bxkj.student.v2.ui.sports.v3.record.tab.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    V3StatisticsFragment.g(V3StatisticsFragment.this, (Map) obj);
                }
            });
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.bxkj.student.v2.ui.sports.set.statistics.tab.StatisticsFragment");
    }
}
