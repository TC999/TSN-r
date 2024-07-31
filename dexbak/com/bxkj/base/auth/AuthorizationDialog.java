package com.bxkj.base.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.C3801R;
import com.bxkj.base.user.LoginUser;
import java.util.Map;
import okhttp3.ResponseBody;
import p635q.DonationApiService;
import p635q.JobApiService;
import p635q.LostApiService;
import p635q.MallApiService;
import p635q.RunnerApiService;
import p635q.SecondHandApiService;
import p640rx.Observable;
import retrofit2.Response;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AuthorizationDialog extends DialogFragment {

    /* renamed from: a */
    private InterfaceC3814c f14644a;

    /* renamed from: b */
    private int f14645b;

    /* renamed from: com.bxkj.base.auth.AuthorizationDialog$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class View$OnClickListenerC3812a implements View.OnClickListener {
        View$OnClickListenerC3812a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AuthorizationDialog.this.m44333d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.base.auth.AuthorizationDialog$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3813b extends HttpCallBack {
        C3813b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            AuthorizationDialog.this.dismiss();
            if (AuthorizationDialog.this.f14644a != null) {
                AuthorizationDialog.this.f14644a.mo44321a();
            }
        }
    }

    /* renamed from: com.bxkj.base.auth.AuthorizationDialog$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3814c {
        /* renamed from: a */
        void mo44321a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m44333d() {
        Observable<Response<ResponseBody>> m2306g;
        int i = this.f14645b;
        if (i == 0) {
            m2306g = ((MallApiService) Http.getApiService(MallApiService.class)).m2222z(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId(), LoginUser.getLoginUser().getRealName(), LoginUser.getLoginUser().getSex(), LoginUser.getLoginUser().getAccount(), LoginUser.getLoginUser().getPhone());
        } else if (i == 1) {
            m2306g = ((LostApiService) Http.getApiService(LostApiService.class)).m2281g(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId(), LoginUser.getLoginUser().getRealName(), LoginUser.getLoginUser().getSex(), LoginUser.getLoginUser().getAccount(), LoginUser.getLoginUser().getPhone());
        } else if (i == 2) {
            m2306g = ((SecondHandApiService) Http.getApiService(SecondHandApiService.class)).m2192h(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId(), LoginUser.getLoginUser().getRealName(), LoginUser.getLoginUser().getSex(), LoginUser.getLoginUser().getAccount(), LoginUser.getLoginUser().getPhone());
        } else if (i == 3) {
            m2306g = ((JobApiService) Http.getApiService(JobApiService.class)).m2294f(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId(), LoginUser.getLoginUser().getRealName(), LoginUser.getLoginUser().getSex(), LoginUser.getLoginUser().getAccount(), LoginUser.getLoginUser().getPhone());
        } else if (i == 4) {
            m2306g = ((RunnerApiService) Http.getApiService(RunnerApiService.class)).m2210l(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId(), LoginUser.getLoginUser().getRealName(), LoginUser.getLoginUser().getSex(), LoginUser.getLoginUser().getAccount(), LoginUser.getLoginUser().getPhone());
        } else {
            m2306g = i == 5 ? ((DonationApiService) Http.getApiService(DonationApiService.class)).m2306g(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId(), LoginUser.getLoginUser().getRealName(), LoginUser.getLoginUser().getSex(), LoginUser.getLoginUser().getAccount(), LoginUser.getLoginUser().getPhone()) : null;
        }
        Http.with(getContext()).setObservable(m2306g).setDataListener(new C3813b());
    }

    /* renamed from: e */
    public DialogFragment m44332e(int i) {
        this.f14645b = i;
        return this;
    }

    /* renamed from: f */
    public AuthorizationDialog m44331f(InterfaceC3814c interfaceC3814c) {
        this.f14644a = interfaceC3814c;
        return this;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C3801R.C3807layout.dialog_authorization, viewGroup);
        TextView textView = (TextView) inflate.findViewById(C3801R.C3805id.bt_ok);
        TextView textView2 = (TextView) inflate.findViewById(C3801R.C3805id.tv_name);
        int i = this.f14645b;
        if (i == 0) {
            textView2.setText(C3801R.C3809string.app_mall);
        } else if (i == 1) {
            textView2.setText("帮帮忙");
        } else if (i == 2) {
            textView2.setText("二手市场");
        } else if (i == 3) {
            textView2.setText("求职招聘");
        } else if (i == 4) {
            textView2.setText("跑腿");
        } else if (i == 5) {
            textView2.setText("捐赠寄卖");
        }
        textView.setOnClickListener(new View$OnClickListenerC3812a());
        return inflate;
    }
}
