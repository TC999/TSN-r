package com.bxkj.student.v2.ui.sports.v3.detail.tab;

import android.text.TextUtils;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.bxkj.base.v2.base.BaseFragment;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.common.utils.l;
import com.bxkj.student.databinding.V3FmBasicBinding;
import com.bxkj.student.v2.common.view.TrackProgressView;
import com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity;
import com.bxkj.student.v2.vm.sports.record.RecordDetailVM;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BasicFragment.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/detail/tab/BasicFragment;", "Lcom/bxkj/base/v2/base/BaseFragment;", "Lcom/bxkj/student/databinding/V3FmBasicBinding;", "Lcom/bxkj/student/v2/vm/sports/record/RecordDetailVM;", "Lkotlin/f1;", "h", "E", "p", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class BasicFragment extends BaseFragment<V3FmBasicBinding, RecordDetailVM> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(BasicFragment this$0) {
        f0.p(this$0, "this$0");
        this$0.getChildFragmentManager().beginTransaction().add(2131232182, new V3RecordChartFragment()).commitAllowingStateLoss();
        this$0.h();
    }

    private final void h() {
        ViewModel viewModel = new ViewModelProvider(requireActivity()).get(RecordDetailVM.class);
        f0.o(viewModel, "ViewModelProvider(requir\u2026cordDetailVM::class.java)");
        a((BaseViewModel) viewModel);
        M().setMActivity((V3RecordDetailActivity) w());
        x().v().observe(requireActivity(), new Observer() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BasicFragment.i(BasicFragment.this, (Map) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(BasicFragment this$0, Map map) {
        f0.p(this$0, "this$0");
        this$0.M().setMap(map);
        if (TextUtils.isEmpty(this$0.x().z())) {
            this$0.M().card2.setVisibility(8);
            this$0.M().card3.setVisibility(8);
        } else {
            TextView textView = this$0.M().tvResult;
            l lVar = l.f18624a;
            textView.setText(f0.C("NO.", lVar.t(map, "exerciseStatistics")));
            this$0.M().tvRank.setText(com.bxkj.base.v2.common.utils.e.f18604a.a(lVar.f(map, "totalRange")));
            this$0.M().card2.setVisibility(0);
            this$0.M().tvCj.setText(lVar.t(map, "recordBreaking"));
            this$0.M().card3.setVisibility(lVar.d(map, "isMax") ? 0 : 8);
        }
        TrackProgressView trackProgressView = this$0.M().tpStep;
        l lVar2 = l.f18624a;
        trackProgressView.setMaxProgress(lVar2.k(map, "stepSetting"));
        this$0.M().tpStep.setProgress(com.bxkj.student.run.app.utils.i.t(lVar2.t(map, "stepNumbers")));
        if (map != null) {
            if ((lVar2.k(map, "stepSetting") == 0 ? map : null) != null) {
                this$0.M().tpStep.setMaxProgress(100);
                this$0.M().tpStep.setProgress(100);
            }
        }
        TrackProgressView trackProgressView2 = this$0.M().tpDistance;
        double f4 = lVar2.f(map, "rangeSetting");
        double d4 = 1000;
        Double.isNaN(d4);
        trackProgressView2.setMaxProgress((int) (f4 * d4));
        TrackProgressView trackProgressView3 = this$0.M().tpDistance;
        double f5 = lVar2.f(map, "sportRange");
        Double.isNaN(d4);
        trackProgressView3.setProgress((int) (f5 * d4));
        if (map != null) {
            double f6 = lVar2.f(map, "rangeSetting");
            Double.isNaN(d4);
            if ((((int) (f6 * d4)) == 0 ? map : null) != null) {
                this$0.M().tpDistance.setMaxProgress(100);
                this$0.M().tpDistance.setProgress(100);
            }
        }
        this$0.M().tpTime.setMaxProgress(lVar2.k(map, "startQualifiedTimeSetting") * 60);
        this$0.M().tpTime.setProgress(lVar2.k(map, "sportTime"));
        if (lVar2.k(map, "sportTime") > lVar2.k(map, "endQualifiedTimeSetting") * 60) {
            this$0.M().tpTime.setProgress(0);
        }
        if (map == null) {
            return;
        }
        if (!(lVar2.k(map, "startQualifiedTimeSetting") == 0)) {
            map = null;
        }
        if (map == null) {
            return;
        }
        this$0.M().tpTime.setMaxProgress(100);
        this$0.M().tpTime.setProgress(100);
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        w().getWindow().getDecorView().post(new Runnable() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.b
            @Override // java.lang.Runnable
            public final void run() {
                BasicFragment.g(BasicFragment.this);
            }
        });
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
