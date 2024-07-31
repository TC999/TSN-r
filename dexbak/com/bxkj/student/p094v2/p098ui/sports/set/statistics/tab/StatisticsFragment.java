package com.bxkj.student.p094v2.p098ui.sports.set.statistics.tab;

import android.graphics.Matrix;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import cn.bluemobi.dylan.base.utils.Tools;
import com.bxkj.base.p085v2.base.BaseFragment;
import com.bxkj.student.databinding.FmV2SportsStatisticsBinding;
import com.bxkj.student.p094v2.common.view.CustomBarChart;
import com.bxkj.student.p094v2.p103vm.sports.set.SportsStatisticsVM;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StatisticsFragment.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J$\u0010\u0012\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000eR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/set/statistics/tab/StatisticsFragment;", "Lcom/bxkj/base/v2/base/BaseFragment;", "Lcom/bxkj/student/databinding/FmV2SportsStatisticsBinding;", "Lcom/bxkj/student/v2/vm/sports/set/SportsStatisticsVM;", "Lkotlin/f1;", "e", "", "xCount", "", "f", "type", "g", ExifInterface.LONGITUDE_EAST, "p", "", "", "", "it", "h", "Lcom/github/mikephil/charting/charts/BarChart;", "j", "Lcom/github/mikephil/charting/charts/BarChart;", "barChart", "", "k", "Ljava/util/List;", "listData", C7304t.f25048d, "F", "scalePercent", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.set.statistics.tab.StatisticsFragment */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class StatisticsFragment extends BaseFragment<FmV2SportsStatisticsBinding, SportsStatisticsVM> {

    /* renamed from: j */
    private BarChart f20553j;
    @Nullable

    /* renamed from: k */
    private List<Float> f20554k;

    /* renamed from: l */
    private final float f20555l = 0.13333334f;

    /* compiled from: StatisticsFragment.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/set/statistics/tab/StatisticsFragment$a", "Lcom/github/mikephil/charting/formatter/ValueFormatter;", "", DomainCampaignEx.LOOPBACK_VALUE, "", "getFormattedValue", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.set.statistics.tab.StatisticsFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5709a extends ValueFormatter {

        /* renamed from: a */
        final /* synthetic */ int f20556a;

        C5709a(int i) {
            this.f20556a = i;
        }

        @Override // com.github.mikephil.charting.formatter.ValueFormatter
        @NotNull
        public String getFormattedValue(float f) {
            int i = (int) f;
            int i2 = this.f20556a;
            if (i2 == 1) {
                String m57594n = Tools.m57594n(i);
                C14342f0.m8185o(m57594n, "{\n                    To…anzi(v)\n                }");
                return m57594n;
            } else if (i2 == 2) {
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                sb.append((char) 26085);
                return sb.toString();
            } else if (i2 == 3) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i);
                sb2.append((char) 21608);
                return sb2.toString();
            } else {
                return i + "";
            }
        }
    }

    /* renamed from: e */
    private final void m38598e() {
        Description description = new Description();
        description.setText("");
        BarChart barChart = this.f20553j;
        BarChart barChart2 = null;
        if (barChart == null) {
            C14342f0.m8200S("barChart");
            barChart = null;
        }
        barChart.setDescription(description);
        BarChart barChart3 = this.f20553j;
        if (barChart3 == null) {
            C14342f0.m8200S("barChart");
            barChart3 = null;
        }
        barChart3.setNoDataText("暂无数据");
        BarChart barChart4 = this.f20553j;
        if (barChart4 == null) {
            C14342f0.m8200S("barChart");
            barChart4 = null;
        }
        barChart4.getAxisLeft().setAxisMinimum(0.0f);
        BarChart barChart5 = this.f20553j;
        if (barChart5 == null) {
            C14342f0.m8200S("barChart");
            barChart5 = null;
        }
        barChart5.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        BarChart barChart6 = this.f20553j;
        if (barChart6 == null) {
            C14342f0.m8200S("barChart");
            barChart6 = null;
        }
        barChart6.getXAxis().setDrawGridLines(false);
        BarChart barChart7 = this.f20553j;
        if (barChart7 == null) {
            C14342f0.m8200S("barChart");
            barChart7 = null;
        }
        barChart7.getAxisRight().setEnabled(false);
        BarChart barChart8 = this.f20553j;
        if (barChart8 == null) {
            C14342f0.m8200S("barChart");
            barChart8 = null;
        }
        barChart8.getAxisLeft().setDrawGridLines(false);
        BarChart barChart9 = this.f20553j;
        if (barChart9 == null) {
            C14342f0.m8200S("barChart");
            barChart9 = null;
        }
        barChart9.getAxisRight().setDrawGridLines(false);
        BarChart barChart10 = this.f20553j;
        if (barChart10 == null) {
            C14342f0.m8200S("barChart");
            barChart10 = null;
        }
        barChart10.getXAxis().setDrawGridLines(false);
        BarChart barChart11 = this.f20553j;
        if (barChart11 == null) {
            C14342f0.m8200S("barChart");
            barChart11 = null;
        }
        barChart11.dispatchSetSelected(false);
        BarChart barChart12 = this.f20553j;
        if (barChart12 == null) {
            C14342f0.m8200S("barChart");
            barChart12 = null;
        }
        barChart12.getLegend().setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        BarChart barChart13 = this.f20553j;
        if (barChart13 == null) {
            C14342f0.m8200S("barChart");
            barChart13 = null;
        }
        barChart13.getLegend().setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        BarChart barChart14 = this.f20553j;
        if (barChart14 == null) {
            C14342f0.m8200S("barChart");
            barChart14 = null;
        }
        barChart14.setTouchEnabled(true);
        Matrix matrix = new Matrix();
        List<Float> list = this.f20554k;
        C14342f0.m8187m(list);
        matrix.postScale(m38597f(list.size()), 1.0f);
        BarChart barChart15 = this.f20553j;
        if (barChart15 == null) {
            C14342f0.m8200S("barChart");
            barChart15 = null;
        }
        ViewPortHandler viewPortHandler = barChart15.getViewPortHandler();
        BarChart barChart16 = this.f20553j;
        if (barChart16 == null) {
            C14342f0.m8200S("barChart");
            barChart16 = null;
        }
        viewPortHandler.refresh(matrix, barChart16, false);
        BarChart barChart17 = this.f20553j;
        if (barChart17 == null) {
            C14342f0.m8200S("barChart");
            barChart17 = null;
        }
        barChart17.setPinchZoom(false);
        BarChart barChart18 = this.f20553j;
        if (barChart18 == null) {
            C14342f0.m8200S("barChart");
        } else {
            barChart2 = barChart18;
        }
        barChart2.setDoubleTapToZoomEnabled(false);
    }

    /* renamed from: f */
    private final float m38597f(int i) {
        return i * this.f20555l;
    }

    /* renamed from: g */
    private final void m38596g(int i) {
        ArrayList arrayList = new ArrayList();
        List<Float> list = this.f20554k;
        C14342f0.m8187m(list);
        int size = list.size() - 1;
        if (size >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                List<Float> list2 = this.f20554k;
                C14342f0.m8187m(list2);
                arrayList.add(new BarEntry(i2 + 1.0f, list2.get(i2).floatValue()));
                if (i3 > size) {
                    break;
                }
                i2 = i3;
            }
        }
        BarDataSet barDataSet = new BarDataSet(arrayList, "里程(KM)");
        barDataSet.setColor(ContextCompat.getColor(mo43926C(), 2131034489));
        barDataSet.setBarBorderColor(ContextCompat.getColor(mo43926C(), 2131034196));
        barDataSet.setDrawValues(false);
        barDataSet.setHighLightAlpha(37);
        BarChart barChart = this.f20553j;
        BarChart barChart2 = null;
        if (barChart == null) {
            C14342f0.m8200S("barChart");
            barChart = null;
        }
        XAxis xAxis = barChart.getXAxis();
        C14342f0.m8185o(xAxis, "barChart.getXAxis()");
        xAxis.setGranularity(1.0f);
        xAxis.setValueFormatter(new C5709a(i));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(barDataSet);
        BarData barData = new BarData(arrayList2);
        barData.setBarWidth(0.2f);
        BarChart barChart3 = this.f20553j;
        if (barChart3 == null) {
            C14342f0.m8200S("barChart");
        } else {
            barChart2 = barChart3;
        }
        barChart2.setData(barData);
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        CustomBarChart customBarChart = mo43920M().barChart;
        C14342f0.m8185o(customBarChart, "mDataBinding.barChart");
        this.f20553j = customBarChart;
        if (customBarChart == null) {
            C14342f0.m8200S("barChart");
            customBarChart = null;
        }
        customBarChart.setNoDataText("暂无数据");
    }

    /* renamed from: h */
    public final void m38595h(int i, @NotNull Map<String, Object> it) {
        C14342f0.m8184p(it, "it");
        if (i == 1) {
            Object obj = it.get("week");
            if (obj instanceof List) {
                this.f20554k = TypeIntrinsics.m8020g(obj);
            }
        } else if (i == 2) {
            Object obj2 = it.get("month");
            if (obj2 instanceof List) {
                this.f20554k = TypeIntrinsics.m8020g(obj2);
            }
        } else if (i == 3) {
            Object obj3 = it.get("sysTerm");
            if (obj3 instanceof List) {
                this.f20554k = TypeIntrinsics.m8020g(obj3);
            }
        }
        m38598e();
        m38596g(i);
        BarChart barChart = this.f20553j;
        if (barChart == null) {
            C14342f0.m8200S("barChart");
            barChart = null;
        }
        barChart.animateY(1000);
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
    }
}
