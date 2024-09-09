package com.bxkj.student.personal.customer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.personal.login.LoginActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import l.b;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ContactUsFragment extends BaseFragment {

    /* renamed from: h  reason: collision with root package name */
    private TextView f22125h;

    /* renamed from: i  reason: collision with root package name */
    private ListView f22126i;

    /* renamed from: j  reason: collision with root package name */
    private List<Map<String, Object>> f22127j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> f22128k;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
        /* renamed from: d */
        public void a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            ContactUsFragment.this.Y((TextView) holder.h(2131233109), JsonParse.getString(stringObjectMap, "qq"), JsonParse.getString(stringObjectMap, "androidQqKey"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ContactUsFragment.this.X(JsonParse.getString(data, "customerServicePhone", "4008330860"));
            ContactUsFragment.this.f22127j = JsonParse.getList(data, "customerServiceQq");
            ContactUsFragment.this.f22128k.c(ContactUsFragment.this.f22127j);
            FragmentActivity activity = ContactUsFragment.this.getActivity();
            String string = JsonParse.getString(data, "serviceQq", "884165111");
            if (activity instanceof LoginActivity) {
                ((LoginActivity) activity).D0(string);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f22131a;

        c(final String val$customerServicePhone) {
            this.f22131a = val$customerServicePhone;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            ContactUsFragment.this.U(this.f22131a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f22133a;

        d(final String val$key) {
            this.f22133a = val$key;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            ContactUsFragment.this.W(this.f22133a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f22135a;

        e(final String val$phoneNum) {
            this.f22135a = val$phoneNum;
        }

        @Override // l.b.a
        public void a(String... permission) {
            new iOSOneButtonDialog(((BaseFragment) ContactUsFragment.this).f1665e).setMessage("\u60a8\u62d2\u7edd\u4e86\u62e8\u6253\u7535\u8bdd\u6743\u9650,\u65e0\u6cd5\u8054\u7cfb\u5ba2\u670d\uff01").show();
        }

        @Override // l.b.a
        public void b() {
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setData(Uri.parse("tel:" + this.f22135a));
            ContactUsFragment.this.startActivity(intent);
        }

        @Override // l.b.a
        public void c(String... permission) {
            new iOSOneButtonDialog(((BaseFragment) ContactUsFragment.this).f1665e).setMessage("\u60a8\u62d2\u7edd\u4e86\u62e8\u6253\u7535\u8bdd\u6743\u9650,\u65e0\u6cd5\u8054\u7cfb\u5ba2\u670d\uff01").show();
        }
    }

    private void V() {
        Http.with(this.f1665e).hideLoadingDialog().setObservable(((w.a) Http.getApiService(w.a.class)).X0()).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(String customerServicePhone) {
        SpannableString spannableString = new SpannableString("\u5ba2\u670d\u7535\u8bdd\uff1a" + customerServicePhone);
        spannableString.setSpan(new c(customerServicePhone), 5, spannableString.length(), 33);
        spannableString.setSpan(new UnderlineSpan(), 5, spannableString.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.f1665e, 2131034196)), 5, spannableString.length(), 33);
        this.f22125h.setText(spannableString);
        this.f22125h.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(TextView tv_qq_group, String customerServiceQq, String key) {
        SpannableString spannableString = new SpannableString("\u52a0\u5165QQ\u7fa4\uff1a" + customerServiceQq);
        spannableString.setSpan(new d(key), 6, spannableString.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.f1665e, 2131034196)), 6, spannableString.length(), 33);
        tv_qq_group.setText(spannableString);
        tv_qq_group.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void U(String phoneNum) {
        new l.b(this).c("android.permission.CALL_PHONE").d(new e(phoneNum));
    }

    public boolean W(String key) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26jump_from%3Dwebapi%26k%3D" + key));
        try {
            startActivity(intent);
            return true;
        } catch (Exception unused) {
            new iOSOneButtonDialog(this.f1665e).setMessage("\u60a8\u8fd8\u672a\u5b89\u88c5\u624b\u673aQQ\u6216\u5b89\u88c5\u7684\u624b\u673aQQ\u7248\u672c\u592a\u4f4e").show();
            return false;
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        a aVar = new a(this.f1665e, 2131427686, this.f22127j);
        this.f22128k = aVar;
        this.f22126i.setAdapter((ListAdapter) aVar);
        X("4008330860");
        V();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f22125h = (TextView) c(2131233089);
        this.f22126i = (ListView) c(2131232249);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131427624;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
