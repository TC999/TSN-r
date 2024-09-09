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
import com.bxkj.base.R;
import com.bxkj.base.user.LoginUser;
import java.util.Map;
import okhttp3.ResponseBody;
import q.d;
import q.g;
import q.h;
import q.i;
import retrofit2.Response;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class AuthorizationDialog extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private c f18133a;

    /* renamed from: b  reason: collision with root package name */
    private int f18134b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AuthorizationDialog.this.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            AuthorizationDialog.this.dismiss();
            if (AuthorizationDialog.this.f18133a != null) {
                AuthorizationDialog.this.f18133a.a();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface c {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        e<Response<ResponseBody>> g4;
        int i4 = this.f18134b;
        if (i4 == 0) {
            g4 = ((g) Http.getApiService(g.class)).z(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId(), LoginUser.getLoginUser().getRealName(), LoginUser.getLoginUser().getSex(), LoginUser.getLoginUser().getAccount(), LoginUser.getLoginUser().getPhone());
        } else if (i4 == 1) {
            g4 = ((q.e) Http.getApiService(q.e.class)).g(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId(), LoginUser.getLoginUser().getRealName(), LoginUser.getLoginUser().getSex(), LoginUser.getLoginUser().getAccount(), LoginUser.getLoginUser().getPhone());
        } else if (i4 == 2) {
            g4 = ((i) Http.getApiService(i.class)).h(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId(), LoginUser.getLoginUser().getRealName(), LoginUser.getLoginUser().getSex(), LoginUser.getLoginUser().getAccount(), LoginUser.getLoginUser().getPhone());
        } else if (i4 == 3) {
            g4 = ((d) Http.getApiService(d.class)).f(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId(), LoginUser.getLoginUser().getRealName(), LoginUser.getLoginUser().getSex(), LoginUser.getLoginUser().getAccount(), LoginUser.getLoginUser().getPhone());
        } else if (i4 == 4) {
            g4 = ((h) Http.getApiService(h.class)).l(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId(), LoginUser.getLoginUser().getRealName(), LoginUser.getLoginUser().getSex(), LoginUser.getLoginUser().getAccount(), LoginUser.getLoginUser().getPhone());
        } else {
            g4 = i4 == 5 ? ((q.b) Http.getApiService(q.b.class)).g(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId(), LoginUser.getLoginUser().getRealName(), LoginUser.getLoginUser().getSex(), LoginUser.getLoginUser().getAccount(), LoginUser.getLoginUser().getPhone()) : null;
        }
        Http.with(getContext()).setObservable(g4).setDataListener(new b());
    }

    public DialogFragment e(int i4) {
        this.f18134b = i4;
        return this;
    }

    public AuthorizationDialog f(c cVar) {
        this.f18133a = cVar;
        return this;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_authorization, viewGroup);
        TextView textView = (TextView) inflate.findViewById(R.id.bt_ok);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_name);
        int i4 = this.f18134b;
        if (i4 == 0) {
            textView2.setText(R.string.app_mall);
        } else if (i4 == 1) {
            textView2.setText("\u5e2e\u5e2e\u5fd9");
        } else if (i4 == 2) {
            textView2.setText("\u4e8c\u624b\u5e02\u573a");
        } else if (i4 == 3) {
            textView2.setText("\u6c42\u804c\u62db\u8058");
        } else if (i4 == 4) {
            textView2.setText("\u8dd1\u817f");
        } else if (i4 == 5) {
            textView2.setText("\u6350\u8d60\u5bc4\u5356");
        }
        textView.setOnClickListener(new a());
        return inflate;
    }
}
