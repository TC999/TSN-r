package com.bxkj.student.p094v2.p098ui.sports.p102v3.detail.tab;

import android.text.TextUtils;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.bxkj.base.p085v2.base.BaseFragment;
import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.base.p085v2.common.utils.DecimalFormatUtils;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.databinding.V3FmBasicBinding;
import com.bxkj.student.p094v2.common.view.TrackProgressView;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.detail.V3RecordDetailActivity;
import com.bxkj.student.p094v2.p103vm.sports.record.RecordDetailVM;
import com.bxkj.student.run.app.utils.FormatUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;

/* compiled from: BasicFragment.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016¨\u0006\n"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/detail/tab/BasicFragment;", "Lcom/bxkj/base/v2/base/BaseFragment;", "Lcom/bxkj/student/databinding/V3FmBasicBinding;", "Lcom/bxkj/student/v2/vm/sports/record/RecordDetailVM;", "Lkotlin/f1;", "h", ExifInterface.LONGITUDE_EAST, "p", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.detail.tab.BasicFragment */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class BasicFragment extends BaseFragment<V3FmBasicBinding, RecordDetailVM> {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public static final void m38436g(BasicFragment this$0) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.getChildFragmentManager().beginTransaction().add(2131232182, new V3RecordChartFragment()).commitAllowingStateLoss();
        this$0.m38435h();
    }

    /* renamed from: h */
    private final void m38435h() {
        ViewModel viewModel = new ViewModelProvider(requireActivity()).get(RecordDetailVM.class);
        C14342f0.m8185o(viewModel, "ViewModelProvider(requir…cordDetailVM::class.java)");
        mo43919a((BaseViewModel) viewModel);
        mo43920M().setMActivity((V3RecordDetailActivity) mo43912w());
        mo43911x().m37981v().observe(requireActivity(), new Observer() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BasicFragment.m38434i(BasicFragment.this, (Map) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public static final void m38434i(BasicFragment this$0, Map map) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.mo43920M().setMap(map);
        if (TextUtils.isEmpty(this$0.mo43911x().m37977z())) {
            this$0.mo43920M().card2.setVisibility(8);
            this$0.mo43920M().card3.setVisibility(8);
        } else {
            TextView textView = this$0.mo43920M().tvResult;
            JsonGet jsonGet = JsonGet.f15134a;
            textView.setText(C14342f0.m8216C("NO.", jsonGet.m43760t(map, "exerciseStatistics")));
            this$0.mo43920M().tvRank.setText(DecimalFormatUtils.f15114a.m43806a(jsonGet.m43774f(map, "totalRange")));
            this$0.mo43920M().card2.setVisibility(0);
            this$0.mo43920M().tvCj.setText(jsonGet.m43760t(map, "recordBreaking"));
            this$0.mo43920M().card3.setVisibility(jsonGet.m43776d(map, "isMax") ? 0 : 8);
        }
        TrackProgressView trackProgressView = this$0.mo43920M().tpStep;
        JsonGet jsonGet2 = JsonGet.f15134a;
        trackProgressView.setMaxProgress(jsonGet2.m43769k(map, "stepSetting"));
        this$0.mo43920M().tpStep.setProgress(FormatUtils.m39617t(jsonGet2.m43760t(map, "stepNumbers")));
        if (map != null) {
            if ((jsonGet2.m43769k(map, "stepSetting") == 0 ? map : null) != null) {
                this$0.mo43920M().tpStep.setMaxProgress(100);
                this$0.mo43920M().tpStep.setProgress(100);
            }
        }
        TrackProgressView trackProgressView2 = this$0.mo43920M().tpDistance;
        double m43774f = jsonGet2.m43774f(map, "rangeSetting");
        double d = 1000;
        Double.isNaN(d);
        trackProgressView2.setMaxProgress((int) (m43774f * d));
        TrackProgressView trackProgressView3 = this$0.mo43920M().tpDistance;
        double m43774f2 = jsonGet2.m43774f(map, "sportRange");
        Double.isNaN(d);
        trackProgressView3.setProgress((int) (m43774f2 * d));
        if (map != null) {
            double m43774f3 = jsonGet2.m43774f(map, "rangeSetting");
            Double.isNaN(d);
            if ((((int) (m43774f3 * d)) == 0 ? map : null) != null) {
                this$0.mo43920M().tpDistance.setMaxProgress(100);
                this$0.mo43920M().tpDistance.setProgress(100);
            }
        }
        this$0.mo43920M().tpTime.setMaxProgress(jsonGet2.m43769k(map, "startQualifiedTimeSetting") * 60);
        this$0.mo43920M().tpTime.setProgress(jsonGet2.m43769k(map, "sportTime"));
        if (jsonGet2.m43769k(map, "sportTime") > jsonGet2.m43769k(map, "endQualifiedTimeSetting") * 60) {
            this$0.mo43920M().tpTime.setProgress(0);
        }
        if (map == null) {
            return;
        }
        if (!(jsonGet2.m43769k(map, "startQualifiedTimeSetting") == 0)) {
            map = null;
        }
        if (map == null) {
            return;
        }
        this$0.mo43920M().tpTime.setMaxProgress(100);
        this$0.mo43920M().tpTime.setProgress(100);
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        mo43912w().getWindow().getDecorView().post(new Runnable() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.b
            @Override // java.lang.Runnable
            public final void run() {
                BasicFragment.m38436g(BasicFragment.this);
            }
        });
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
    }
}
