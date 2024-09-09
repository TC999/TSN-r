package com.bxkj.student.v2.ui.sports.set.statistics.tab;

import android.graphics.Matrix;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.utils.u;
import com.bxkj.base.v2.base.BaseFragment;
import com.bxkj.student.databinding.FmV2SportsStatisticsBinding;
import com.bxkj.student.v2.common.view.CustomBarChart;
import com.bxkj.student.v2.vm.sports.set.SportsStatisticsVM;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: StatisticsFragment.kt */
@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J$\u0010\u0012\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000eR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/bxkj/student/v2/ui/sports/set/statistics/tab/StatisticsFragment;", "Lcom/bxkj/base/v2/base/BaseFragment;", "Lcom/bxkj/student/databinding/FmV2SportsStatisticsBinding;", "Lcom/bxkj/student/v2/vm/sports/set/SportsStatisticsVM;", "Lkotlin/f1;", "e", "", "xCount", "", "f", "type", "g", "E", "p", "", "", "", "it", "h", "Lcom/github/mikephil/charting/charts/BarChart;", "j", "Lcom/github/mikephil/charting/charts/BarChart;", "barChart", "", "k", "Ljava/util/List;", "listData", "l", "F", "scalePercent", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class StatisticsFragment extends BaseFragment<FmV2SportsStatisticsBinding, SportsStatisticsVM> {

    /* renamed from: j  reason: collision with root package name */
    private BarChart f23952j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private List<Float> f23953k;

    /* renamed from: l  reason: collision with root package name */
    private final float f23954l = 0.13333334f;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: StatisticsFragment.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/bxkj/student/v2/ui/sports/set/statistics/tab/StatisticsFragment$a", "Lcom/github/mikephil/charting/formatter/ValueFormatter;", "", "value", "", "getFormattedValue", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a extends ValueFormatter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f23955a;

        a(int i4) {
            this.f23955a = i4;
        }

        @Override // com.github.mikephil.charting.formatter.ValueFormatter
        @NotNull
        public String getFormattedValue(float f4) {
            int i4 = (int) f4;
            int i5 = this.f23955a;
            if (i5 == 1) {
                String n4 = u.n(i4);
                f0.o(n4, "{\n                    To\u2026anzi(v)\n                }");
                return n4;
            } else if (i5 == 2) {
                StringBuilder sb = new StringBuilder();
                sb.append(i4);
                sb.append('\u65e5');
                return sb.toString();
            } else if (i5 == 3) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i4);
                sb2.append('\u5468');
                return sb2.toString();
            } else {
                return i4 + "";
            }
        }
    }

    private final void e() {
        Description description = new Description();
        description.setText("");
        BarChart barChart = this.f23952j;
        BarChart barChart2 = null;
        if (barChart == null) {
            f0.S("barChart");
            barChart = null;
        }
        barChart.setDescription(description);
        BarChart barChart3 = this.f23952j;
        if (barChart3 == null) {
            f0.S("barChart");
            barChart3 = null;
        }
        barChart3.setNoDataText("\u6682\u65e0\u6570\u636e");
        BarChart barChart4 = this.f23952j;
        if (barChart4 == null) {
            f0.S("barChart");
            barChart4 = null;
        }
        barChart4.getAxisLeft().setAxisMinimum(0.0f);
        BarChart barChart5 = this.f23952j;
        if (barChart5 == null) {
            f0.S("barChart");
            barChart5 = null;
        }
        barChart5.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        BarChart barChart6 = this.f23952j;
        if (barChart6 == null) {
            f0.S("barChart");
            barChart6 = null;
        }
        barChart6.getXAxis().setDrawGridLines(false);
        BarChart barChart7 = this.f23952j;
        if (barChart7 == null) {
            f0.S("barChart");
            barChart7 = null;
        }
        barChart7.getAxisRight().setEnabled(false);
        BarChart barChart8 = this.f23952j;
        if (barChart8 == null) {
            f0.S("barChart");
            barChart8 = null;
        }
        barChart8.getAxisLeft().setDrawGridLines(false);
        BarChart barChart9 = this.f23952j;
        if (barChart9 == null) {
            f0.S("barChart");
            barChart9 = null;
        }
        barChart9.getAxisRight().setDrawGridLines(false);
        BarChart barChart10 = this.f23952j;
        if (barChart10 == null) {
            f0.S("barChart");
            barChart10 = null;
        }
        barChart10.getXAxis().setDrawGridLines(false);
        BarChart barChart11 = this.f23952j;
        if (barChart11 == null) {
            f0.S("barChart");
            barChart11 = null;
        }
        barChart11.dispatchSetSelected(false);
        BarChart barChart12 = this.f23952j;
        if (barChart12 == null) {
            f0.S("barChart");
            barChart12 = null;
        }
        barChart12.getLegend().setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        BarChart barChart13 = this.f23952j;
        if (barChart13 == null) {
            f0.S("barChart");
            barChart13 = null;
        }
        barChart13.getLegend().setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        BarChart barChart14 = this.f23952j;
        if (barChart14 == null) {
            f0.S("barChart");
            barChart14 = null;
        }
        barChart14.setTouchEnabled(true);
        Matrix matrix = new Matrix();
        List<Float> list = this.f23953k;
        f0.m(list);
        matrix.postScale(f(list.size()), 1.0f);
        BarChart barChart15 = this.f23952j;
        if (barChart15 == null) {
            f0.S("barChart");
            barChart15 = null;
        }
        ViewPortHandler viewPortHandler = barChart15.getViewPortHandler();
        BarChart barChart16 = this.f23952j;
        if (barChart16 == null) {
            f0.S("barChart");
            barChart16 = null;
        }
        viewPortHandler.refresh(matrix, barChart16, false);
        BarChart barChart17 = this.f23952j;
        if (barChart17 == null) {
            f0.S("barChart");
            barChart17 = null;
        }
        barChart17.setPinchZoom(false);
        BarChart barChart18 = this.f23952j;
        if (barChart18 == null) {
            f0.S("barChart");
        } else {
            barChart2 = barChart18;
        }
        barChart2.setDoubleTapToZoomEnabled(false);
    }

    private final float f(int i4) {
        return i4 * this.f23954l;
    }

    private final void g(int i4) {
        ArrayList arrayList = new ArrayList();
        List<Float> list = this.f23953k;
        f0.m(list);
        int size = list.size() - 1;
        if (size >= 0) {
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                List<Float> list2 = this.f23953k;
                f0.m(list2);
                arrayList.add(new BarEntry(i5 + 1.0f, list2.get(i5).floatValue()));
                if (i6 > size) {
                    break;
                }
                i5 = i6;
            }
        }
        BarDataSet barDataSet = new BarDataSet(arrayList, "\u91cc\u7a0b(KM)");
        barDataSet.setColor(ContextCompat.getColor(C(), 2131034489));
        barDataSet.setBarBorderColor(ContextCompat.getColor(C(), 2131034196));
        barDataSet.setDrawValues(false);
        barDataSet.setHighLightAlpha(37);
        BarChart barChart = this.f23952j;
        BarChart barChart2 = null;
        if (barChart == null) {
            f0.S("barChart");
            barChart = null;
        }
        XAxis xAxis = barChart.getXAxis();
        f0.o(xAxis, "barChart.getXAxis()");
        xAxis.setGranularity(1.0f);
        xAxis.setValueFormatter(new a(i4));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(barDataSet);
        BarData barData = new BarData(arrayList2);
        barData.setBarWidth(0.2f);
        BarChart barChart3 = this.f23952j;
        if (barChart3 == null) {
            f0.S("barChart");
        } else {
            barChart2 = barChart3;
        }
        barChart2.setData(barData);
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        CustomBarChart customBarChart = M().barChart;
        f0.o(customBarChart, "mDataBinding.barChart");
        this.f23952j = customBarChart;
        if (customBarChart == null) {
            f0.S("barChart");
            customBarChart = null;
        }
        customBarChart.setNoDataText("\u6682\u65e0\u6570\u636e");
    }

    public final void h(int i4, @NotNull Map<String, Object> it) {
        f0.p(it, "it");
        if (i4 == 1) {
            Object obj = it.get("week");
            if (obj instanceof List) {
                this.f23953k = t0.g(obj);
            }
        } else if (i4 == 2) {
            Object obj2 = it.get("month");
            if (obj2 instanceof List) {
                this.f23953k = t0.g(obj2);
            }
        } else if (i4 == 3) {
            Object obj3 = it.get("sysTerm");
            if (obj3 instanceof List) {
                this.f23953k = t0.g(obj3);
            }
        }
        e();
        g(i4);
        BarChart barChart = this.f23952j;
        if (barChart == null) {
            f0.S("barChart");
            barChart = null;
        }
        barChart.animateY(1000);
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
