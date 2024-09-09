package com.bxkj.student.v2.ui.main;

import androidx.lifecycle.Observer;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.v2.base.BaseFragment;
import com.bxkj.base.v2.data.a;
import com.bxkj.student.databinding.V2MainTabMsgFragmentBinding;
import com.bxkj.student.v2.ui.h5.js.JS;
import com.bxkj.student.v2.vm.MainViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.text.w;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: MsgFragment.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/bxkj/student/v2/ui/main/MsgFragment;", "Lcom/bxkj/base/v2/base/BaseFragment;", "Lcom/bxkj/student/databinding/V2MainTabMsgFragmentBinding;", "Lcom/bxkj/student/v2/vm/MainViewModel;", "Lkotlin/f1;", "E", "p", "g", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class MsgFragment extends BaseFragment<V2MainTabMsgFragmentBinding, MainViewModel> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(MsgFragment this$0, String it) {
        String k22;
        f0.p(this$0, "this$0");
        StringBuilder sb = new StringBuilder();
        f0.o(it, "it");
        a.b bVar = com.bxkj.base.v2.data.a.f18673h;
        k22 = w.k2(it, "${school}", bVar.a().w(), false, 4, null);
        sb.append(k22);
        sb.append("?token=");
        sb.append(bVar.a().d());
        String sb2 = sb.toString();
        com.orhanobut.logger.j.d(f0.C("\u6d88\u606f\u5730\u5740\uff1a", sb2), new Object[0]);
        this$0.M().smartWebView.j(sb2);
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        d(w());
    }

    public final void g() {
        MsgFragment msgFragment = b() ? this : null;
        if (msgFragment == null) {
            return;
        }
        if ((com.bxkj.base.v2.data.a.f18673h.a().G() ? msgFragment : null) == null) {
            return;
        }
        M().smartWebView.getWebView().reload();
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        SmartWebView smartWebView = M().smartWebView;
        f0.o(smartWebView, "this");
        smartWebView.setWebViewClient(new com.bxkj.base.v2.h5.d(smartWebView));
        smartWebView.getWebView().addJavascriptInterface(new JS(w(), M().smartWebView.getWebView()), "tsn");
        x().Z().observe(w(), new Observer() { // from class: com.bxkj.student.v2.ui.main.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MsgFragment.f(MsgFragment.this, (String) obj);
            }
        });
    }
}
