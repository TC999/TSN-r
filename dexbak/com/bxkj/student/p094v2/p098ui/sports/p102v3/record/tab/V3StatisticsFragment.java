package com.bxkj.student.p094v2.p098ui.sports.p102v3.record.tab;

import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import cn.bluemobi.dylan.base.utils.Tools;
import com.bxkj.base.p085v2.base.BaseFragment;
import com.bxkj.base.p085v2.common.utils.DecimalFormatUtils;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.C4215R;
import com.bxkj.student.databinding.FmV3RecordListTotalBinding;
import com.bxkj.student.p094v2.p098ui.sports.set.statistics.tab.StatisticsFragment;
import com.bxkj.student.p094v2.p103vm.sports.set.SportsStatisticsVM;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType;
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement;
import com.github.aachartmodel.aainfographics.aatools.AAColorKt;
import com.google.android.material.tabs.TabLayout;
import com.kuaishou.weapon.p205p0.C7304t;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: V3StatisticsFragment.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/record/tab/V3StatisticsFragment;", "Lcom/bxkj/base/v2/base/BaseFragment;", "Lcom/bxkj/student/databinding/FmV3RecordListTotalBinding;", "Lcom/bxkj/student/v2/vm/sports/set/SportsStatisticsVM;", "", "position", "", "", "", "it", "Lkotlin/f1;", "h", "i", ExifInterface.LONGITUDE_EAST, "p", "", "", "j", "Ljava/util/List;", "listData", "", "k", "xTitle", "Lcom/bxkj/student/v2/ui/sports/set/statistics/tab/StatisticsFragment;", C7304t.f25048d, "Lcom/bxkj/student/v2/ui/sports/set/statistics/tab/StatisticsFragment;", "statisticsFragment", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.record.tab.V3StatisticsFragment */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class V3StatisticsFragment extends BaseFragment<FmV3RecordListTotalBinding, SportsStatisticsVM> {
    @NotNull

    /* renamed from: j */
    private List<Double> f20742j;
    @NotNull

    /* renamed from: k */
    private List<String> f20743k;
    @Nullable

    /* renamed from: l */
    private StatisticsFragment f20744l;

    /* compiled from: V3StatisticsFragment.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/v3/record/tab/V3StatisticsFragment$a", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", "Lkotlin/f1;", "onTabSelected", "onTabUnselected", "onTabReselected", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.record.tab.V3StatisticsFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5798a implements TabLayout.OnTabSelectedListener {
        C5798a() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(@Nullable TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(@Nullable TabLayout.Tab tab) {
            Map<String, Object> value = V3StatisticsFragment.this.mo43911x().m37931t().getValue();
            if (value == null) {
                return;
            }
            V3StatisticsFragment v3StatisticsFragment = V3StatisticsFragment.this;
            if (tab == null) {
                return;
            }
            v3StatisticsFragment.m38343h(tab.getPosition(), value);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(@Nullable TabLayout.Tab tab) {
        }
    }

    public V3StatisticsFragment() {
        List<Double> m12478E;
        m12478E = CollectionsKt__CollectionsKt.m12478E();
        this.f20742j = m12478E;
        this.f20743k = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public static final void m38344g(V3StatisticsFragment this$0, Map it) {
        C14342f0.m8184p(this$0, "this$0");
        int selectedTabPosition = this$0.mo43920M().tbType.getSelectedTabPosition();
        C14342f0.m8185o(it, "it");
        this$0.m38343h(selectedTabPosition, it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public final void m38343h(int i, Map<String, Object> map) {
        this.f20743k.clear();
        int i2 = 0;
        if (i == 0) {
            TextView textView = mo43920M().tvDay;
            JsonGet jsonGet = JsonGet.f15134a;
            textView.setText(jsonGet.m43760t(map, "weekDay"));
            TextView textView2 = mo43920M().tvAvgDistance;
            DecimalFormatUtils decimalFormatUtils = DecimalFormatUtils.f15114a;
            textView2.setText(decimalFormatUtils.m43806a(jsonGet.m43774f(map, "weekAvgRange")));
            mo43920M().tvAvgCount.setText(jsonGet.m43760t(map, "weekAvgCount"));
            mo43920M().tvAvgTime.setText(jsonGet.m43760t(map, "weekAvgTime"));
            mo43920M().tvDistance.setText(decimalFormatUtils.m43806a(jsonGet.m43774f(map, "weekTotalMileage")));
            mo43920M().tvCount.setText(jsonGet.m43760t(map, "weekNum"));
            mo43920M().tvTime.setText(jsonGet.m43760t(map, "weekTime"));
            mo43920M().tvHeart.setText(jsonGet.m43760t(map, "weekCalorie"));
            mo43920M().tvPace.setText(jsonGet.m43760t(map, "weekAvgSpeed"));
            mo43920M().tvStep.setText(jsonGet.m43760t(map, "weekAvgstep"));
            mo43920M().tvStepDistance.setText(jsonGet.m43760t(map, "weekStride"));
            List<Double> m43772h = jsonGet.m43772h(map, "week");
            this.f20742j = m43772h;
            for (Object obj : m43772h) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.m12460W();
                }
                ((Number) obj).doubleValue();
                List<String> list = this.f20743k;
                String m57594n = Tools.m57594n(i3);
                C14342f0.m8185o(m57594n, "changeWeekToHanzi(index+1)");
                list.add(m57594n);
                i2 = i3;
            }
        } else if (i != 1) {
            TextView textView3 = mo43920M().tvDay;
            JsonGet jsonGet2 = JsonGet.f15134a;
            textView3.setText(jsonGet2.m43760t(map, "sysTermDay"));
            TextView textView4 = mo43920M().tvAvgDistance;
            DecimalFormatUtils decimalFormatUtils2 = DecimalFormatUtils.f15114a;
            textView4.setText(decimalFormatUtils2.m43806a(jsonGet2.m43774f(map, "sysTermAvgRange")));
            mo43920M().tvAvgCount.setText(jsonGet2.m43760t(map, "sysTermAvgCount"));
            mo43920M().tvAvgTime.setText(jsonGet2.m43760t(map, "sysTermAvgTime"));
            mo43920M().tvDistance.setText(decimalFormatUtils2.m43806a(jsonGet2.m43774f(map, "sysTermTotalMileage")));
            mo43920M().tvCount.setText(jsonGet2.m43760t(map, "sysTermNum"));
            mo43920M().tvTime.setText(jsonGet2.m43760t(map, "sysTermTime"));
            mo43920M().tvPace.setText(jsonGet2.m43760t(map, "sysTermAvgSpeed"));
            mo43920M().tvHeart.setText(jsonGet2.m43760t(map, "sysTermCalorie"));
            mo43920M().tvStep.setText(jsonGet2.m43760t(map, "sysTermAvgstep"));
            mo43920M().tvStepDistance.setText(jsonGet2.m43760t(map, "sysTermStride"));
            List<Double> m43772h2 = jsonGet2.m43772h(map, "sysTerm");
            this.f20742j = m43772h2;
            for (Object obj2 : m43772h2) {
                int i4 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.m12460W();
                }
                ((Number) obj2).doubleValue();
                List<String> list2 = this.f20743k;
                StringBuilder sb = new StringBuilder();
                sb.append(i4);
                sb.append((char) 21608);
                list2.add(sb.toString());
                i2 = i4;
            }
        } else {
            TextView textView5 = mo43920M().tvDay;
            JsonGet jsonGet3 = JsonGet.f15134a;
            textView5.setText(jsonGet3.m43760t(map, "monthDay"));
            TextView textView6 = mo43920M().tvAvgDistance;
            DecimalFormatUtils decimalFormatUtils3 = DecimalFormatUtils.f15114a;
            textView6.setText(decimalFormatUtils3.m43806a(jsonGet3.m43774f(map, "monthAvgRange")));
            mo43920M().tvAvgCount.setText(jsonGet3.m43760t(map, "monthAvgCount"));
            mo43920M().tvAvgTime.setText(jsonGet3.m43760t(map, "monthAvgTime"));
            mo43920M().tvDistance.setText(decimalFormatUtils3.m43806a(jsonGet3.m43774f(map, "monthTotalMileage")));
            mo43920M().tvCount.setText(jsonGet3.m43760t(map, "monthNum"));
            mo43920M().tvTime.setText(jsonGet3.m43760t(map, "monthTime"));
            mo43920M().tvPace.setText(jsonGet3.m43760t(map, "monthAvgSpeed"));
            mo43920M().tvHeart.setText(jsonGet3.m43760t(map, "monthCalorie"));
            mo43920M().tvStep.setText(jsonGet3.m43760t(map, "monthAvgstep"));
            mo43920M().tvStepDistance.setText(jsonGet3.m43760t(map, "monthStride"));
            List<Double> m43772h3 = jsonGet3.m43772h(map, "month");
            this.f20742j = m43772h3;
            for (Object obj3 : m43772h3) {
                int i5 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.m12460W();
                }
                ((Number) obj3).doubleValue();
                List<String> list3 = this.f20743k;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i5);
                sb2.append((char) 26085);
                list3.add(sb2.toString());
                i2 = i5;
            }
        }
        StatisticsFragment statisticsFragment = this.f20744l;
        if (statisticsFragment == null) {
            return;
        }
        statisticsFragment.m38595h(i + 1, map);
    }

    /* renamed from: i */
    private final void m38342i() {
        AAChartModel yAxisTitle = new AAChartModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 4095, null).chartType(AAChartType.Column).title("").subtitle("").yAxisTitle("");
        Boolean bool = Boolean.FALSE;
        AAChartModel dataLabelsEnabled = yAxisTitle.dataLabelsEnabled(bool);
        Boolean bool2 = Boolean.TRUE;
        AAChartModel yAxisGridLineWidth = dataLabelsEnabled.yAxisLabelsEnabled(bool2).xAxisLabelsEnabled(bool2).legendEnabled(bool).tooltipEnabled(bool).yAxisGridLineWidth(0);
        Object[] array = this.f20743k.toArray(new String[0]);
        if (array != null) {
            AAChartModel yAxisVisible = yAxisGridLineWidth.categories((String[]) array).yAxisVisible(bool2);
            Object[] objArr = new Object[1];
            AASeriesElement color = new AASeriesElement().name("").lineWidth(0).enableMouseTracking(bool2).borderRadius(Float.valueOf(8.0f)).color(AAColorKt.AARgba(0, 203, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE, 1.0f));
            Object[] array2 = this.f20742j.toArray(new Object[0]);
            if (array2 != null) {
                objArr[0] = color.data(array2);
                mo43920M().AAChartView.aa_drawChartWithChartModel(yAxisVisible.series(objArr));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        mo43911x().m37930u();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
        Fragment findFragmentById = getChildFragmentManager().findFragmentById(C4215R.C4219id.fm_chat);
        if (findFragmentById != null) {
            this.f20744l = (StatisticsFragment) findFragmentById;
            mo43920M().tbType.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new C5798a());
            mo43911x().m37931t().observe(mo43912w(), new Observer() { // from class: com.bxkj.student.v2.ui.sports.v3.record.tab.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    V3StatisticsFragment.m38344g(V3StatisticsFragment.this, (Map) obj);
                }
            });
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.bxkj.student.v2.ui.sports.set.statistics.tab.StatisticsFragment");
    }
}
