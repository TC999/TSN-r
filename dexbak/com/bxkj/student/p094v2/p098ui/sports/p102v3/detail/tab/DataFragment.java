package com.bxkj.student.p094v2.p098ui.sports.p102v3.detail.tab;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import com.bxkj.base.p085v2.base.BaseFragment;
import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.base.p085v2.common.utils.DecimalFormatUtils;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.databinding.V3FmDataBinding;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.appeal.V3AppealActivity;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.detail.V3RecordDetailActivity;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.detail.tab.DataFragment;
import com.bxkj.student.p094v2.p103vm.sports.record.RecordDetailVM;
import com.orhanobut.logger.C11792j;
import com.umeng.analytics.AnalyticsConfig;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

/* compiled from: DataFragment.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\t\u001a\u00020\b2\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0002J\u001e\u0010\n\u001a\u00020\b2\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016¨\u0006\u0012"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/detail/tab/DataFragment;", "Lcom/bxkj/base/v2/base/BaseFragment;", "Lcom/bxkj/student/databinding/V3FmDataBinding;", "Lcom/bxkj/student/v2/vm/sports/record/RecordDetailVM;", "", "", "", "dataMap", "Lkotlin/f1;", "k", "i", "", "surplusCount", "h", ExifInterface.LONGITUDE_EAST, "p", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.detail.tab.DataFragment */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class DataFragment extends BaseFragment<V3FmDataBinding, RecordDetailVM> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DataFragment.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.detail.tab.DataFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5765a extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {
        C5765a() {
            super(1);
        }

        /* renamed from: a */
        public final void m38426a(@NotNull iOSTwoButtonDialog it) {
            C14342f0.m8184p(it, "it");
            DataFragment.this.startActivity(new Intent(DataFragment.this.mo43926C(), V3AppealActivity.class).putExtra("exerciseRecordId", DataFragment.this.mo43911x().m37977z()).putExtra("identify", DataFragment.this.mo43911x().m37992A()));
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
            m38426a(iostwobuttondialog);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DataFragment.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0000H\n"}, m12616d2 = {"", "", "", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.detail.tab.DataFragment$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5766b extends Lambda implements InterfaceC15280l<Map<String, ? extends Object>, Unit> {

        /* renamed from: a */
        final /* synthetic */ Map<String, Object> f20683a;

        /* renamed from: b */
        final /* synthetic */ DataFragment f20684b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5766b(Map<String, ? extends Object> map, DataFragment dataFragment) {
            super(1);
            this.f20683a = map;
            this.f20684b = dataFragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public static final void m38423c(DataFragment this$0, int i, View view) {
            C14342f0.m8184p(this$0, "this$0");
            this$0.m38430h(i);
        }

        /* renamed from: b */
        public final void m38424b(@NotNull Map<String, ? extends Object> it) {
            int m43769k;
            final int m43769k2;
            C14342f0.m8184p(it, "it");
            JsonGet jsonGet = JsonGet.f15134a;
            if (jsonGet.m43769k(this.f20683a, "sportType") == 1) {
                m43769k = jsonGet.m43769k(it, "validitySunRun");
            } else {
                m43769k = jsonGet.m43769k(this.f20683a, "sportType") == 2 ? jsonGet.m43769k(it, "validityMorningRun") : -1;
            }
            if (jsonGet.m43769k(this.f20683a, "sportType") == 1) {
                m43769k2 = jsonGet.m43769k(it, "balanceSunRun");
            } else {
                m43769k2 = jsonGet.m43769k(this.f20683a, "sportType") == 2 ? jsonGet.m43769k(it, "balanceMorningRun") : 0;
            }
            double doubleValue = new BigDecimal(System.currentTimeMillis()).subtract(new BigDecimal(jsonGet.m43765o(this.f20683a, AnalyticsConfig.RTD_START_TIME))).divide(new BigDecimal(86400000), 10, 4).doubleValue();
            C11792j.m20469d(C14342f0.m8216C("距离开始时间的天数=", Double.valueOf(doubleValue)), new Object[0]);
            if (m43769k == -1) {
                this.f20684b.mo43920M().btAppeal.setVisibility(8);
            } else if (doubleValue <= m43769k) {
                this.f20684b.m38429i(this.f20683a);
            } else if (C14342f0.m8193g(jsonGet.m43760t(this.f20683a, "status"), "1")) {
                this.f20684b.mo43920M().btAppeal.setVisibility(8);
            } else if (jsonGet.m43776d(this.f20683a, "enable")) {
                this.f20684b.mo43920M().btAppeal.setVisibility(8);
            } else {
                this.f20684b.mo43920M().btAppeal.setVisibility(0);
                this.f20684b.mo43920M().btAppeal.setEnabled(false);
                this.f20684b.mo43920M().btAppeal.setText(jsonGet.m43760t(this.f20683a, "va"));
            }
            Button button = this.f20684b.mo43920M().btAppeal;
            final DataFragment dataFragment = this.f20684b;
            button.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DataFragment.C5766b.m38423c(DataFragment.this, m43769k2, view);
                }
            });
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends Object> map) {
            m38424b(map);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public final void m38430h(int i) {
        String str;
        if (i > 0) {
            str = "还剩" + i + "次申诉机会,确定是否申诉？";
        } else {
            str = "还剩0次申诉机会,无法进行申诉！";
        }
        String str2 = str;
        if (i <= 0) {
            ContextExt.m43851m(mo43926C(), str2);
        } else {
            ContextExt.m43856h(mo43926C(), null, str2, new C5765a(), null, null, null, 57, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public final void m38429i(Map<String, ? extends Object> map) {
        if (TextUtils.isEmpty(mo43911x().m37977z())) {
            if (C14342f0.m8193g(JsonGet.f15134a.m43760t(map, "isException"), "1")) {
                mo43920M().btAppeal.setVisibility(0);
                return;
            } else {
                mo43920M().btAppeal.setVisibility(8);
                return;
            }
        }
        JsonGet jsonGet = JsonGet.f15134a;
        if (C14342f0.m8193g(jsonGet.m43760t(map, "status"), "1")) {
            mo43920M().btAppeal.setVisibility(8);
            return;
        }
        mo43920M().btAppeal.setVisibility(0);
        mo43920M().btAppeal.setEnabled(jsonGet.m43776d(map, "enable"));
        mo43920M().btAppeal.setText(jsonGet.m43760t(map, "va"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static final void m38428j(DataFragment this$0, Map it) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.mo43920M().setMap(it);
        TextView textView = this$0.mo43920M().tvYxlc;
        DecimalFormatUtils decimalFormatUtils = DecimalFormatUtils.f15114a;
        JsonGet jsonGet = JsonGet.f15134a;
        textView.setText(decimalFormatUtils.m43806a(jsonGet.m43774f(it, "totalRangeZong")));
        this$0.mo43920M().tvDblc.setText(jsonGet.m43760t(it, "qualifyTotalRange"));
        ProgressBar progressBar = this$0.mo43920M().pbDistance;
        double m43774f = jsonGet.m43774f(it, "qualifyTotalRange");
        double d = 1000;
        Double.isNaN(d);
        progressBar.setMax((int) (m43774f * d));
        ProgressBar progressBar2 = this$0.mo43920M().pbDistance;
        double m43774f2 = jsonGet.m43774f(it, "totalRangeZong");
        Double.isNaN(d);
        progressBar2.setProgress((int) (m43774f2 * d));
        this$0.mo43920M().tvYxcs.setText(jsonGet.m43760t(it, "totalCountZong"));
        this$0.mo43920M().tvDbcs.setText(jsonGet.m43760t(it, "qualifyTotalCount"));
        this$0.mo43920M().pbCount.setMax(jsonGet.m43769k(it, "qualifyTotalCount"));
        this$0.mo43920M().pbCount.setProgress(jsonGet.m43769k(it, "totalCountZong"));
        TextView textView2 = this$0.mo43920M().tvLjsc;
        BigDecimal divide = new BigDecimal(String.valueOf(jsonGet.m43774f(it, "totalTimeZong"))).divide(new BigDecimal(60), RoundingMode.HALF_EVEN);
        C14342f0.m8185o(divide, "this.divide(other, RoundingMode.HALF_EVEN)");
        BigDecimal divide2 = divide.divide(new BigDecimal(60), RoundingMode.HALF_EVEN);
        C14342f0.m8185o(divide2, "this.divide(other, RoundingMode.HALF_EVEN)");
        textView2.setText(String.valueOf(divide2.setScale(2).doubleValue()));
        this$0.mo43920M().tvPbts.setText(jsonGet.m43760t(it, "totalDay"));
        if (TextUtils.isEmpty(this$0.mo43911x().m37977z())) {
            this$0.mo43920M().cardTotalTagrt.setVisibility(8);
        } else {
            this$0.mo43920M().cardTotalTagrt.setVisibility(0);
        }
        C14342f0.m8185o(it, "it");
        this$0.m38427k(it);
    }

    /* renamed from: k */
    private final void m38427k(Map<String, ? extends Object> map) {
        mo43911x().m37991B(new C5766b(map, this));
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
        mo43920M().setMActivity((V3RecordDetailActivity) mo43912w());
        mo43911x().m37981v().observe(requireActivity(), new Observer() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DataFragment.m38428j(DataFragment.this, (Map) obj);
            }
        });
    }
}
