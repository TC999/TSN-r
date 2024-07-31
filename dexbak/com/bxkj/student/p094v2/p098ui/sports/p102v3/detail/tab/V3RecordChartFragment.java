package com.bxkj.student.p094v2.p098ui.sports.p102v3.detail.tab;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import cn.bluemobi.dylan.base.utils.DisplayUtil;
import cn.bluemobi.dylan.base.utils.Tools;
import com.bxkj.base.p085v2.base.BaseAdapter;
import com.bxkj.base.p085v2.base.BaseFragment;
import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.C4215R;
import com.bxkj.student.databinding.FmV3SportsChartBinding;
import com.bxkj.student.databinding.ItemForPaceKmBinding;
import com.bxkj.student.p094v2.common.data.SportsDataAnalysis;
import com.bxkj.student.p094v2.p103vm.sports.record.RecordDetailVM;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartAlignType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartZoomType;
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle;
import com.github.aachartmodel.aainfographics.aatools.AAColorKt;
import com.github.aachartmodel.aainfographics.aatools.AAGradientColor;
import com.github.aachartmodel.aainfographics.aatools.AALinearGradientDirection;
import com.github.mikephil.charting.utils.Utils;
import com.kuaishou.weapon.p205p0.C7304t;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections._Collections;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* compiled from: V3RecordChartFragment.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0016\u0010\n\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J \u0010\u0010\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0016\u0010\u0013\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0016\u0010\u0015\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004H\u0002J\u0016\u0010\u0016\u001a\u00020\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016¨\u0006\u001b"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/detail/tab/V3RecordChartFragment;", "Lcom/bxkj/base/v2/base/BaseFragment;", "Lcom/bxkj/student/databinding/FmV3SportsChartBinding;", "Lcom/bxkj/student/v2/vm/sports/record/RecordDetailVM;", "", "", "it", "Lkotlin/f1;", "k", "paceKmList", "j", "", "max", UMModuleRegister.PROCESS, "Landroid/widget/TextView;", "tv", C7304t.f25048d, "paceList", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "i", "stepNumberList", "g", "m", ExifInterface.LONGITUDE_EAST, "p", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class V3RecordChartFragment extends BaseFragment<FmV3SportsChartBinding, RecordDetailVM> {
    /* renamed from: g */
    private final void m38420g(List<Integer> list) {
        double m12030z1;
        Comparable m12250F3;
        TextView textView = mo43920M().tvAvgStep;
        m12030z1 = _Collections.m12030z1(list);
        textView.setText(String.valueOf((int) Math.floor(m12030z1)));
        TextView textView2 = mo43920M().tvBestStep;
        m12250F3 = _Collections.m12250F3(list);
        textView2.setText(String.valueOf(m12250F3));
        mo43920M().AAChartViewStep.aa_drawChartWithChartModel(m38414m(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static final void m38419h(V3RecordChartFragment this$0, Map map) {
        C14342f0.m8184p(this$0, "this$0");
        JsonGet jsonGet = JsonGet.f15134a;
        this$0.m38420g(jsonGet.m43767m(map, "stepNumbers"));
        this$0.m38416k(jsonGet.m43772h(map, "paceMinute"));
        this$0.m38417j(jsonGet.m43772h(map, "paceKm"));
    }

    /* renamed from: i */
    private final AAChartModel m38418i(List<Double> list) {
        int size = list.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = "";
        }
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.m12460W();
            }
            ((Number) obj).doubleValue();
            strArr[i2] = String.valueOf(i3);
            i2 = i3;
        }
        Map<String, Object> linearGradient = AAGradientColor.INSTANCE.linearGradient(AALinearGradientDirection.ToBottom, "rgba(09,62,251,1)", "rgba(204,216,249,0.5)");
        AAChartModel yAxisGridLineWidth = new AAChartModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 4095, null).yAxisTitle("").zoomType(AAChartZoomType.XY).subtitleAlign(AAChartAlignType.Right).subtitleStyle(new AAStyle().position("bottom")).chartType(AAChartType.Areaspline).categories(strArr).markerRadius(0).yAxisGridLineWidth(0);
        Boolean bool = Boolean.FALSE;
        AAChartModel legendEnabled = yAxisGridLineWidth.legendEnabled(bool);
        Object[] objArr = new Object[1];
        AASeriesElement fillColor = new AASeriesElement().enableMouseTracking(bool).name("").lineWidth(1).color(AAColorKt.AARgba(9, 62, 251, 1.0f)).fillColor(linearGradient);
        Object[] array = list.toArray(new Object[0]);
        if (array != null) {
            objArr[0] = fillColor.data(array);
            return legendEnabled.series(objArr);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [T, java.lang.Double] */
    /* JADX WARN: Type inference failed for: r1v9, types: [T, java.lang.Double] */
    /* JADX WARN: Type inference failed for: r4v6, types: [T, java.lang.Double] */
    /* JADX WARN: Type inference failed for: r6v0, types: [T, java.lang.Double] */
    /* renamed from: j */
    private final void m38417j(List<Double> list) {
        double m12040x1;
        String m39241e;
        ?? m12155Y3;
        ?? m12245G3;
        final List m12218L5;
        Object m12137c3;
        TextView textView = mo43920M().tvAvgPace2;
        List<Double> list2 = list.isEmpty() ^ true ? list : null;
        if (list2 == null) {
            m39241e = null;
        } else {
            m12040x1 = _Collections.m12040x1(list2);
            m39241e = SportsDataAnalysis.f19931a.m39241e(m12040x1);
        }
        textView.setText(m39241e);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        m12155Y3 = _Collections.m12155Y3(list);
        objectRef.element = m12155Y3;
        if (m12155Y3 == 0) {
            objectRef.element = Double.valueOf((double) Utils.DOUBLE_EPSILON);
        }
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        m12245G3 = _Collections.m12245G3(list);
        objectRef2.element = m12245G3;
        if (m12245G3 == 0) {
            objectRef2.element = Double.valueOf((double) Utils.DOUBLE_EPSILON);
        }
        TextView textView2 = mo43920M().tvBestPace2;
        SportsDataAnalysis.C5482a c5482a = SportsDataAnalysis.f19931a;
        textView2.setText(c5482a.m39241e(((Number) objectRef.element).doubleValue()));
        m12218L5 = _Collections.m12218L5(list);
        double m43774f = JsonGet.f15134a.m43774f(mo43911x().m37981v().getValue(), "sportRange");
        if (!(m43774f == ((double) ((long) m43774f)))) {
            List list3 = m12218L5.isEmpty() ^ true ? m12218L5 : null;
            if (list3 != null) {
                mo43920M().tvLastKmPace.setText(C14342f0.m8216C("最后不足一公里，配速 ", c5482a.m39241e(((Number) list3.get(list3.size() - 1)).doubleValue())));
                m12137c3 = _Collections.m12137c3(list);
                m12218L5.remove(m12137c3);
            }
        }
        mo43920M().rvPace2.setAdapter(new BaseAdapter<Double, ItemForPaceKmBinding>(objectRef2, this, objectRef, m12218L5) { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment$setKmPace$5

            /* renamed from: b */
            final /* synthetic */ Ref.ObjectRef<Double> f20685b;

            /* renamed from: c */
            final /* synthetic */ V3RecordChartFragment f20686c;

            /* renamed from: d */
            final /* synthetic */ Ref.ObjectRef<Double> f20687d;

            /* renamed from: e */
            final /* synthetic */ List<Double> f20688e;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(m12218L5);
                this.f20688e = m12218L5;
            }

            @Override // com.bxkj.base.p085v2.base.BaseAdapter
            /* renamed from: f */
            public /* bridge */ /* synthetic */ void mo38351f(ItemForPaceKmBinding itemForPaceKmBinding, Double d, int i) {
                m38413m(itemForPaceKmBinding, d.doubleValue(), i);
            }

            /* renamed from: m */
            public void m38413m(@NotNull ItemForPaceKmBinding itemBinding, double d, int i) {
                Drawable drawable;
                C14342f0.m8184p(itemBinding, "itemBinding");
                itemBinding.tvNumber.setText(String.valueOf(i + 1));
                itemBinding.tvAvgPaceHint.setText(SportsDataAnalysis.f19931a.m39241e(d));
                int intValue = new BigDecimal(this.f20685b.element.doubleValue()).setScale(0, 4).intValue();
                itemBinding.pbDistance.setMax(intValue);
                int intValue2 = new BigDecimal(d).setScale(0, 4).intValue();
                itemBinding.pbDistance.setProgress(intValue2);
                V3RecordChartFragment v3RecordChartFragment = this.f20686c;
                TextView textView3 = itemBinding.tvAvgPaceHint;
                C14342f0.m8185o(textView3, "itemBinding.tvAvgPaceHint");
                v3RecordChartFragment.m38415l(intValue, intValue2, textView3);
                ProgressBar progressBar = itemBinding.pbDistance;
                if (C14342f0.m8199a(d, this.f20687d.element)) {
                    drawable = ContextCompat.getDrawable(this.f20686c.mo43926C(), C4215R.C4218drawable.progress_style_pace);
                } else {
                    drawable = ContextCompat.getDrawable(this.f20686c.mo43926C(), C4215R.C4218drawable.progress_style_pace_slow);
                }
                progressBar.setProgressDrawable(drawable);
            }
        });
    }

    /* renamed from: k */
    private final void m38416k(List<Double> list) {
        double m12040x1;
        String m39241e;
        Double m12155Y3;
        TextView textView = mo43920M().tvAvgPace;
        List<Double> list2 = list.isEmpty() ^ true ? list : null;
        if (list2 == null) {
            m39241e = null;
        } else {
            m12040x1 = _Collections.m12040x1(list2);
            m39241e = SportsDataAnalysis.f19931a.m39241e(m12040x1);
        }
        textView.setText(m39241e);
        TextView textView2 = mo43920M().tvBestPace;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!(((Number) obj).doubleValue() == Utils.DOUBLE_EPSILON)) {
                arrayList.add(obj);
            }
        }
        m12155Y3 = _Collections.m12155Y3(arrayList);
        textView2.setText(m12155Y3 != null ? SportsDataAnalysis.f19931a.m39241e(m12155Y3.doubleValue()) : null);
        mo43920M().AAChartView.aa_drawChartWithChartModel(m38418i(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public final void m38415l(int i, int i2, TextView textView) {
        int m57760a = Resources.getSystem().getDisplayMetrics().widthPixels - DisplayUtil.m57760a(mo43926C(), 60.0f);
        textView.measure(-2, Tools.m57620a(30.0f, mo43926C()));
        int measuredWidth = textView.getMeasuredWidth();
        float f = measuredWidth;
        int i3 = m57760a - measuredWidth;
        float f2 = ((m57760a * (i2 / i)) - f) - f;
        if (f2 <= 0.0f) {
            f2 = 0.0f;
        }
        float f3 = i3;
        if (f2 > f3) {
            f2 = f3;
        }
        textView.setTranslationX(f2);
    }

    /* renamed from: m */
    private final AAChartModel m38414m(List<Integer> list) {
        int size = list.size() + 1;
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = "";
        }
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.m12460W();
            }
            ((Number) obj).intValue();
            strArr[i2] = String.valueOf(i3);
            i2 = i3;
        }
        Map<String, Object> linearGradient = AAGradientColor.INSTANCE.linearGradient(AALinearGradientDirection.ToBottom, "rgba(12,191,121,1)", "rgba(221,245,234,0.5)");
        AAChartModel yAxisGridLineWidth = new AAChartModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 4095, null).yAxisTitle("").subtitleAlign(AAChartAlignType.Right).subtitleStyle(new AAStyle().position("bottom")).chartType(AAChartType.Areaspline).categories(strArr).markerRadius(0).yAxisGridLineWidth(0);
        Boolean bool = Boolean.FALSE;
        AAChartModel legendEnabled = yAxisGridLineWidth.legendEnabled(bool);
        Object[] objArr = new Object[1];
        AASeriesElement fillColor = new AASeriesElement().enableMouseTracking(bool).name("步频").lineWidth(1).color(AAColorKt.AARgba(12, 191, 121, 1.0f)).fillColor(linearGradient);
        Object[] array = list.toArray(new Object[0]);
        if (array != null) {
            objArr[0] = fillColor.data(array);
            return legendEnabled.series(objArr);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
        ViewModel viewModel = new ViewModelProvider(requireActivity()).get(RecordDetailVM.class);
        C14342f0.m8185o(viewModel, "ViewModelProvider(requir…cordDetailVM::class.java)");
        mo43919a((BaseViewModel) viewModel);
        mo43911x().m37981v().observe(requireActivity(), new Observer() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                V3RecordChartFragment.m38419h(V3RecordChartFragment.this, (Map) obj);
            }
        });
    }
}
