package com.bxkj.student.p094v2.p098ui.main;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.p085v2.base.BaseFragment;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.base.p085v2.p086h5.H5BaseWebViewClient;
import com.bxkj.student.databinding.V2MainTabMsgFragmentBinding;
import com.bxkj.student.p094v2.p098ui.p099h5.p100js.C5652JS;
import com.bxkj.student.p094v2.p103vm.MainViewModel;
import com.orhanobut.logger.C11792j;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.text.StringsJVM;

/* compiled from: MsgFragment.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\n"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/main/MsgFragment;", "Lcom/bxkj/base/v2/base/BaseFragment;", "Lcom/bxkj/student/databinding/V2MainTabMsgFragmentBinding;", "Lcom/bxkj/student/v2/vm/MainViewModel;", "Lkotlin/f1;", ExifInterface.LONGITUDE_EAST, "p", "g", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.main.MsgFragment */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class MsgFragment extends BaseFragment<V2MainTabMsgFragmentBinding, MainViewModel> {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static final void m38668f(MsgFragment this$0, String it) {
        String m6568k2;
        C14342f0.m8184p(this$0, "this$0");
        StringBuilder sb = new StringBuilder();
        C14342f0.m8185o(it, "it");
        LoggedInUser.C3984b c3984b = LoggedInUser.f15182b;
        m6568k2 = StringsJVM.m6568k2(it, "${school}", c3984b.m43634a().m43646p(), false, 4, null);
        sb.append(m6568k2);
        sb.append("?token=");
        sb.append(c3984b.m43634a().m43662b());
        String sb2 = sb.toString();
        C11792j.m20469d(C14342f0.m8216C("消息地址：", sb2), new Object[0]);
        this$0.mo43920M().smartWebView.m57493j(sb2);
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        m43975d(mo43912w());
    }

    /* renamed from: g */
    public final void m38667g() {
        MsgFragment msgFragment = m43977b() ? this : null;
        if (msgFragment == null) {
            return;
        }
        if ((LoggedInUser.f15182b.m43634a().m43637y() ? msgFragment : null) == null) {
            return;
        }
        mo43920M().smartWebView.getWebView().reload();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
        SmartWebView smartWebView = mo43920M().smartWebView;
        C14342f0.m8185o(smartWebView, "this");
        smartWebView.setWebViewClient(new H5BaseWebViewClient(smartWebView));
        smartWebView.getWebView().addJavascriptInterface(new C5652JS(mo43912w(), mo43920M().smartWebView.getWebView()), "tsn");
        mo43911x().m38160Z().observe(mo43912w(), new Observer() { // from class: com.bxkj.student.v2.ui.main.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MsgFragment.m38668f(MsgFragment.this, (String) obj);
            }
        });
    }
}
