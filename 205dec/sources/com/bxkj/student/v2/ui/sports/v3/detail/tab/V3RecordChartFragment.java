package com.bxkj.student.v2.ui.sports.v3.detail.tab;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import cn.bluemobi.dylan.base.utils.u;
import com.bxkj.base.v2.base.BaseAdapter;
import com.bxkj.base.v2.base.BaseFragment;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.common.utils.l;
import com.bxkj.student.databinding.FmV3SportsChartBinding;
import com.bxkj.student.databinding.ItemForPaceKmBinding;
import com.bxkj.student.v2.common.data.c;
import com.bxkj.student.v2.vm.sports.record.RecordDetailVM;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartAlignType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartZoomType;
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle;
import com.github.aachartmodel.aainfographics.aatools.AAColorKt;
import com.github.aachartmodel.aainfographics.aatools.AAGradientColor;
import com.github.aachartmodel.aainfographics.aatools.AALinearGradientDirection;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.v;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: V3RecordChartFragment.kt */
@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0016\u0010\n\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J \u0010\u0010\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0016\u0010\u0013\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0016\u0010\u0015\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004H\u0002J\u0016\u0010\u0016\u001a\u00020\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/detail/tab/V3RecordChartFragment;", "Lcom/bxkj/base/v2/base/BaseFragment;", "Lcom/bxkj/student/databinding/FmV3SportsChartBinding;", "Lcom/bxkj/student/v2/vm/sports/record/RecordDetailVM;", "", "", "it", "Lkotlin/f1;", "k", "paceKmList", "j", "", "max", "process", "Landroid/widget/TextView;", "tv", "l", "paceList", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "i", "stepNumberList", "g", "m", "E", "p", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class V3RecordChartFragment extends BaseFragment<FmV3SportsChartBinding, RecordDetailVM> {
    private final void g(List<Integer> list) {
        M().tvAvgStep.setText(String.valueOf((int) Math.floor(v.z1(list))));
        M().tvBestStep.setText(String.valueOf(v.F3(list)));
        M().AAChartViewStep.aa_drawChartWithChartModel(m(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(V3RecordChartFragment this$0, Map map) {
        f0.p(this$0, "this$0");
        l lVar = l.f18624a;
        this$0.g(lVar.m(map, "stepNumbers"));
        this$0.k(lVar.h(map, "paceMinute"));
        this$0.j(lVar.h(map, "paceKm"));
    }

    private final AAChartModel i(List<Double> list) {
        int size = list.size();
        String[] strArr = new String[size];
        for (int i4 = 0; i4 < size; i4++) {
            strArr[i4] = "";
        }
        int i5 = 0;
        for (Object obj : list) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                v.W();
            }
            ((Number) obj).doubleValue();
            strArr[i5] = String.valueOf(i6);
            i5 = i6;
        }
        Map<String, Object> linearGradient = AAGradientColor.INSTANCE.linearGradient(AALinearGradientDirection.ToBottom, "rgba(09,62,251,1)", "rgba(204,216,249,0.5)");
        AAChartModel yAxisGridLineWidth = new AAChartModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 4095, null).yAxisTitle("").zoomType(AAChartZoomType.XY).subtitleAlign(AAChartAlignType.Right).subtitleStyle(new AAStyle().position("bottom")).chartType(AAChartType.Areaspline).categories(strArr).markerRadius(0).yAxisGridLineWidth(0);
        Boolean bool = Boolean.FALSE;
        AAChartModel legendEnabled = yAxisGridLineWidth.legendEnabled(bool);
        Object[] objArr = new Object[1];
        AASeriesElement fillColor = new AASeriesElement().enableMouseTracking(bool).name("").lineWidth(1).color(AAColorKt.AARgba(9, 62, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, 1.0f)).fillColor(linearGradient);
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
    private final void j(List<Double> list) {
        TextView textView = M().tvAvgPace2;
        List<Double> list2 = list.isEmpty() ^ true ? list : null;
        textView.setText(list2 == null ? null : com.bxkj.student.v2.common.data.c.a.e(v.x1(list2)));
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? Y3 = v.Y3(list);
        objectRef.element = Y3;
        if (Y3 == 0) {
            objectRef.element = Double.valueOf(0.0d);
        }
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        ?? G3 = v.G3(list);
        objectRef2.element = G3;
        if (G3 == 0) {
            objectRef2.element = Double.valueOf(0.0d);
        }
        TextView textView2 = M().tvBestPace2;
        c.a aVar = com.bxkj.student.v2.common.data.c.a;
        textView2.setText(aVar.e(((Number) objectRef.element).doubleValue()));
        final List L5 = v.L5(list);
        double f4 = l.f18624a.f(x().v().getValue(), "sportRange");
        if (!(f4 == ((double) ((long) f4)))) {
            List list3 = L5.isEmpty() ^ true ? L5 : null;
            if (list3 != null) {
                M().tvLastKmPace.setText(f0.C("\u6700\u540e\u4e0d\u8db3\u4e00\u516c\u91cc\uff0c\u914d\u901f ", aVar.e(((Number) list3.get(list3.size() - 1)).doubleValue())));
                L5.remove(v.c3(list));
            }
        }
        M().rvPace2.setAdapter(new BaseAdapter<Double, ItemForPaceKmBinding>(objectRef2, this, objectRef, L5) { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment$setKmPace$5

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Ref.ObjectRef<Double> f24104b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ V3RecordChartFragment f24105c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ Ref.ObjectRef<Double> f24106d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ List<Double> f24107e;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(L5);
                this.f24107e = L5;
            }

            @Override // com.bxkj.base.v2.base.BaseAdapter
            public /* bridge */ /* synthetic */ void f(ItemForPaceKmBinding itemForPaceKmBinding, Double d4, int i4) {
                m(itemForPaceKmBinding, d4.doubleValue(), i4);
            }

            public void m(@NotNull ItemForPaceKmBinding itemBinding, double d4, int i4) {
                Drawable drawable;
                f0.p(itemBinding, "itemBinding");
                itemBinding.tvNumber.setText(String.valueOf(i4 + 1));
                itemBinding.tvAvgPaceHint.setText(com.bxkj.student.v2.common.data.c.a.e(d4));
                int intValue = new BigDecimal(this.f24104b.element.doubleValue()).setScale(0, 4).intValue();
                itemBinding.pbDistance.setMax(intValue);
                int intValue2 = new BigDecimal(d4).setScale(0, 4).intValue();
                itemBinding.pbDistance.setProgress(intValue2);
                V3RecordChartFragment v3RecordChartFragment = this.f24105c;
                TextView textView3 = itemBinding.tvAvgPaceHint;
                f0.o(textView3, "itemBinding.tvAvgPaceHint");
                v3RecordChartFragment.l(intValue, intValue2, textView3);
                ProgressBar progressBar = itemBinding.pbDistance;
                if (f0.a(d4, this.f24106d.element)) {
                    drawable = ContextCompat.getDrawable(this.f24105c.C(), 2131165901);
                } else {
                    drawable = ContextCompat.getDrawable(this.f24105c.C(), 2131165902);
                }
                progressBar.setProgressDrawable(drawable);
            }
        });
    }

    private final void k(List<Double> list) {
        TextView textView = M().tvAvgPace;
        List<Double> list2 = list.isEmpty() ^ true ? list : null;
        textView.setText(list2 == null ? null : com.bxkj.student.v2.common.data.c.a.e(v.x1(list2)));
        TextView textView2 = M().tvBestPace;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!(((Number) obj).doubleValue() == 0.0d)) {
                arrayList.add(obj);
            }
        }
        Double Y3 = v.Y3(arrayList);
        textView2.setText(Y3 != null ? com.bxkj.student.v2.common.data.c.a.e(Y3.doubleValue()) : null);
        M().AAChartView.aa_drawChartWithChartModel(i(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(int i4, int i5, TextView textView) {
        int a4 = Resources.getSystem().getDisplayMetrics().widthPixels - cn.bluemobi.dylan.base.utils.d.a(C(), 60.0f);
        textView.measure(-2, u.a(30.0f, C()));
        int measuredWidth = textView.getMeasuredWidth();
        float f4 = measuredWidth;
        int i6 = a4 - measuredWidth;
        float f5 = ((a4 * (i5 / i4)) - f4) - f4;
        if (f5 <= 0.0f) {
            f5 = 0.0f;
        }
        float f6 = i6;
        if (f5 > f6) {
            f5 = f6;
        }
        textView.setTranslationX(f5);
    }

    private final AAChartModel m(List<Integer> list) {
        int size = list.size() + 1;
        String[] strArr = new String[size];
        for (int i4 = 0; i4 < size; i4++) {
            strArr[i4] = "";
        }
        int i5 = 0;
        for (Object obj : list) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                v.W();
            }
            ((Number) obj).intValue();
            strArr[i5] = String.valueOf(i6);
            i5 = i6;
        }
        Map<String, Object> linearGradient = AAGradientColor.INSTANCE.linearGradient(AALinearGradientDirection.ToBottom, "rgba(12,191,121,1)", "rgba(221,245,234,0.5)");
        AAChartModel yAxisGridLineWidth = new AAChartModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 4095, null).yAxisTitle("").subtitleAlign(AAChartAlignType.Right).subtitleStyle(new AAStyle().position("bottom")).chartType(AAChartType.Areaspline).categories(strArr).markerRadius(0).yAxisGridLineWidth(0);
        Boolean bool = Boolean.FALSE;
        AAChartModel legendEnabled = yAxisGridLineWidth.legendEnabled(bool);
        Object[] objArr = new Object[1];
        AASeriesElement fillColor = new AASeriesElement().enableMouseTracking(bool).name("\u6b65\u9891").lineWidth(1).color(AAColorKt.AARgba(12, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, 121, 1.0f)).fillColor(linearGradient);
        Object[] array = list.toArray(new Object[0]);
        if (array != null) {
            objArr[0] = fillColor.data(array);
            return legendEnabled.series(objArr);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        ViewModel viewModel = new ViewModelProvider(requireActivity()).get(RecordDetailVM.class);
        f0.o(viewModel, "ViewModelProvider(requir\u2026cordDetailVM::class.java)");
        a((BaseViewModel) viewModel);
        x().v().observe(requireActivity(), new Observer() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                V3RecordChartFragment.h(V3RecordChartFragment.this, (Map) obj);
            }
        });
    }
}
