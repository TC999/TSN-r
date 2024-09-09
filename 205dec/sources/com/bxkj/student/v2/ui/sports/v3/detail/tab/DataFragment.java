package com.bxkj.student.v2.ui.sports.v3.detail.tab;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import com.bxkj.base.v2.base.BaseFragment;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.student.databinding.V3FmDataBinding;
import com.bxkj.student.v2.ui.sports.v3.appeal.V3AppealActivity;
import com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity;
import com.bxkj.student.v2.ui.sports.v3.detail.tab.DataFragment;
import com.bxkj.student.v2.vm.sports.record.RecordDetailVM;
import com.orhanobut.logger.j;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import l1.l;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DataFragment.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\t\u001a\u00020\b2\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0002J\u001e\u0010\n\u001a\u00020\b2\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/detail/tab/DataFragment;", "Lcom/bxkj/base/v2/base/BaseFragment;", "Lcom/bxkj/student/databinding/V3FmDataBinding;", "Lcom/bxkj/student/v2/vm/sports/record/RecordDetailVM;", "", "", "", "dataMap", "Lkotlin/f1;", "k", "i", "", "surplusCount", "h", "E", "p", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class DataFragment extends BaseFragment<V3FmDataBinding, RecordDetailVM> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DataFragment.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a extends Lambda implements l<iOSTwoButtonDialog, f1> {
        a() {
            super(1);
        }

        public final void a(@NotNull iOSTwoButtonDialog it) {
            f0.p(it, "it");
            DataFragment.this.startActivity(new Intent(DataFragment.this.C(), V3AppealActivity.class).putExtra("exerciseRecordId", DataFragment.this.x().z()).putExtra("identify", DataFragment.this.x().A()));
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DataFragment.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0000H\n"}, d2 = {"", "", "", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b extends Lambda implements l<Map<String, ? extends Object>, f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f24102a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DataFragment f24103b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Map<String, ? extends Object> map, DataFragment dataFragment) {
            super(1);
            this.f24102a = map;
            this.f24103b = dataFragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(DataFragment this$0, int i4, View view) {
            f0.p(this$0, "this$0");
            this$0.h(i4);
        }

        public final void b(@NotNull Map<String, ? extends Object> it) {
            int k4;
            final int k5;
            f0.p(it, "it");
            com.bxkj.base.v2.common.utils.l lVar = com.bxkj.base.v2.common.utils.l.f18624a;
            if (lVar.k(this.f24102a, "sportType") == 1) {
                k4 = lVar.k(it, "validitySunRun");
            } else {
                k4 = lVar.k(this.f24102a, "sportType") == 2 ? lVar.k(it, "validityMorningRun") : -1;
            }
            if (lVar.k(this.f24102a, "sportType") == 1) {
                k5 = lVar.k(it, "balanceSunRun");
            } else {
                k5 = lVar.k(this.f24102a, "sportType") == 2 ? lVar.k(it, "balanceMorningRun") : 0;
            }
            double doubleValue = new BigDecimal(System.currentTimeMillis()).subtract(new BigDecimal(lVar.o(this.f24102a, "startTime"))).divide(new BigDecimal(86400000), 10, 4).doubleValue();
            j.d(f0.C("\u8ddd\u79bb\u5f00\u59cb\u65f6\u95f4\u7684\u5929\u6570=", Double.valueOf(doubleValue)), new Object[0]);
            if (k4 == -1) {
                this.f24103b.M().btAppeal.setVisibility(8);
            } else if (doubleValue <= k4) {
                this.f24103b.i(this.f24102a);
            } else if (f0.g(lVar.t(this.f24102a, "status"), "1")) {
                this.f24103b.M().btAppeal.setVisibility(8);
            } else if (lVar.d(this.f24102a, "enable")) {
                this.f24103b.M().btAppeal.setVisibility(8);
            } else {
                this.f24103b.M().btAppeal.setVisibility(0);
                this.f24103b.M().btAppeal.setEnabled(false);
                this.f24103b.M().btAppeal.setText(lVar.t(this.f24102a, "va"));
            }
            Button button = this.f24103b.M().btAppeal;
            final DataFragment dataFragment = this.f24103b;
            button.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DataFragment.b.c(DataFragment.this, k5, view);
                }
            });
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(Map<String, ? extends Object> map) {
            b(map);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(int i4) {
        String str;
        if (i4 > 0) {
            str = "\u8fd8\u5269" + i4 + "\u6b21\u7533\u8bc9\u673a\u4f1a,\u786e\u5b9a\u662f\u5426\u7533\u8bc9\uff1f";
        } else {
            str = "\u8fd8\u52690\u6b21\u7533\u8bc9\u673a\u4f1a,\u65e0\u6cd5\u8fdb\u884c\u7533\u8bc9\uff01";
        }
        String str2 = str;
        if (i4 <= 0) {
            ContextExtKt.m(C(), str2);
        } else {
            ContextExtKt.h(C(), null, str2, new a(), null, null, null, 57, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(Map<String, ? extends Object> map) {
        if (TextUtils.isEmpty(x().z())) {
            if (f0.g(com.bxkj.base.v2.common.utils.l.f18624a.t(map, "isException"), "1")) {
                M().btAppeal.setVisibility(0);
                return;
            } else {
                M().btAppeal.setVisibility(8);
                return;
            }
        }
        com.bxkj.base.v2.common.utils.l lVar = com.bxkj.base.v2.common.utils.l.f18624a;
        if (f0.g(lVar.t(map, "status"), "1")) {
            M().btAppeal.setVisibility(8);
            return;
        }
        M().btAppeal.setVisibility(0);
        M().btAppeal.setEnabled(lVar.d(map, "enable"));
        M().btAppeal.setText(lVar.t(map, "va"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(DataFragment this$0, Map it) {
        f0.p(this$0, "this$0");
        this$0.M().setMap(it);
        TextView textView = this$0.M().tvYxlc;
        com.bxkj.base.v2.common.utils.e eVar = com.bxkj.base.v2.common.utils.e.f18604a;
        com.bxkj.base.v2.common.utils.l lVar = com.bxkj.base.v2.common.utils.l.f18624a;
        textView.setText(eVar.a(lVar.f(it, "totalRangeZong")));
        this$0.M().tvDblc.setText(lVar.t(it, "qualifyTotalRange"));
        ProgressBar progressBar = this$0.M().pbDistance;
        double f4 = lVar.f(it, "qualifyTotalRange");
        double d4 = 1000;
        Double.isNaN(d4);
        progressBar.setMax((int) (f4 * d4));
        ProgressBar progressBar2 = this$0.M().pbDistance;
        double f5 = lVar.f(it, "totalRangeZong");
        Double.isNaN(d4);
        progressBar2.setProgress((int) (f5 * d4));
        this$0.M().tvYxcs.setText(lVar.t(it, "totalCountZong"));
        this$0.M().tvDbcs.setText(lVar.t(it, "qualifyTotalCount"));
        this$0.M().pbCount.setMax(lVar.k(it, "qualifyTotalCount"));
        this$0.M().pbCount.setProgress(lVar.k(it, "totalCountZong"));
        TextView textView2 = this$0.M().tvLjsc;
        BigDecimal divide = new BigDecimal(String.valueOf(lVar.f(it, "totalTimeZong"))).divide(new BigDecimal(60), RoundingMode.HALF_EVEN);
        f0.o(divide, "this.divide(other, RoundingMode.HALF_EVEN)");
        BigDecimal divide2 = divide.divide(new BigDecimal(60), RoundingMode.HALF_EVEN);
        f0.o(divide2, "this.divide(other, RoundingMode.HALF_EVEN)");
        textView2.setText(String.valueOf(divide2.setScale(2).doubleValue()));
        this$0.M().tvPbts.setText(lVar.t(it, "totalDay"));
        if (TextUtils.isEmpty(this$0.x().z())) {
            this$0.M().cardTotalTagrt.setVisibility(8);
        } else {
            this$0.M().cardTotalTagrt.setVisibility(0);
        }
        f0.o(it, "it");
        this$0.k(it);
    }

    private final void k(Map<String, ? extends Object> map) {
        x().B(new b(map, this));
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        ViewModel viewModel = new ViewModelProvider(requireActivity()).get(RecordDetailVM.class);
        f0.o(viewModel, "ViewModelProvider(requir\u2026cordDetailVM::class.java)");
        a((BaseViewModel) viewModel);
        M().setMActivity((V3RecordDetailActivity) w());
        x().v().observe(requireActivity(), new Observer() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DataFragment.j(DataFragment.this, (Map) obj);
            }
        });
    }
}
