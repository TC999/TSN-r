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
import cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.C4215R;
import com.bxkj.student.personal.login.LoginActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p615l.RequestPermission;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ContactUsFragment extends BaseFragment {

    /* renamed from: h */
    private TextView f18841h;

    /* renamed from: i */
    private ListView f18842i;

    /* renamed from: j */
    private List<Map<String, Object>> f18843j = new ArrayList();

    /* renamed from: k */
    private CommonAdapter<Map<String, Object>> f18844k;

    /* renamed from: com.bxkj.student.personal.customer.ContactUsFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5149a extends CommonAdapter<Map<String, Object>> {
        C5149a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
        /* renamed from: d */
        public void mo40086a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            ContactUsFragment.this.m40446Y((TextView) holder.m57862h(C4215R.C4219id.tv_qq), JsonParse.getString(stringObjectMap, "qq"), JsonParse.getString(stringObjectMap, "androidQqKey"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.customer.ContactUsFragment$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5150b extends HttpCallBack {
        C5150b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ContactUsFragment.this.m40447X(JsonParse.getString(data, "customerServicePhone", "4008330860"));
            ContactUsFragment.this.f18843j = JsonParse.getList(data, "customerServiceQq");
            ContactUsFragment.this.f18844k.m57842c(ContactUsFragment.this.f18843j);
            FragmentActivity activity = ContactUsFragment.this.getActivity();
            String string = JsonParse.getString(data, "serviceQq", "884165111");
            if (activity instanceof LoginActivity) {
                ((LoginActivity) activity).m40441D0(string);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.customer.ContactUsFragment$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5151c extends ClickableSpan {

        /* renamed from: a */
        final /* synthetic */ String f18847a;

        C5151c(final String val$customerServicePhone) {
            this.f18847a = val$customerServicePhone;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            ContactUsFragment.this.m40450U(this.f18847a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.customer.ContactUsFragment$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5152d extends ClickableSpan {

        /* renamed from: a */
        final /* synthetic */ String f18849a;

        C5152d(final String val$key) {
            this.f18849a = val$key;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            ContactUsFragment.this.m40448W(this.f18849a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.customer.ContactUsFragment$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5153e implements RequestPermission.InterfaceC15268a {

        /* renamed from: a */
        final /* synthetic */ String f18851a;

        C5153e(final String val$phoneNum) {
            this.f18851a = val$phoneNum;
        }

        @Override // p615l.RequestPermission.InterfaceC15268a
        /* renamed from: a */
        public void mo3478a(String... permission) {
            new iOSOneButtonDialog(((BaseFragment) ContactUsFragment.this).f1678e).setMessage("您拒绝了拨打电话权限,无法联系客服！").show();
        }

        @Override // p615l.RequestPermission.InterfaceC15268a
        /* renamed from: b */
        public void mo3477b() {
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setData(Uri.parse("tel:" + this.f18851a));
            ContactUsFragment.this.startActivity(intent);
        }

        @Override // p615l.RequestPermission.InterfaceC15268a
        /* renamed from: c */
        public void mo3476c(String... permission) {
            new iOSOneButtonDialog(((BaseFragment) ContactUsFragment.this).f1678e).setMessage("您拒绝了拨打电话权限,无法联系客服！").show();
        }
    }

    /* renamed from: V */
    private void m40449V() {
        Http.with(this.f1678e).hideLoadingDialog().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m134X0()).setDataListener(new C5150b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X */
    public void m40447X(String customerServicePhone) {
        SpannableString spannableString = new SpannableString("客服电话：" + customerServicePhone);
        spannableString.setSpan(new C5151c(customerServicePhone), 5, spannableString.length(), 33);
        spannableString.setSpan(new UnderlineSpan(), 5, spannableString.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.f1678e, 2131034196)), 5, spannableString.length(), 33);
        this.f18841h.setText(spannableString);
        this.f18841h.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y */
    public void m40446Y(TextView tv_qq_group, String customerServiceQq, String key) {
        SpannableString spannableString = new SpannableString("加入QQ群：" + customerServiceQq);
        spannableString.setSpan(new C5152d(key), 6, spannableString.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.f1678e, 2131034196)), 6, spannableString.length(), 33);
        tv_qq_group.setText(spannableString);
        tv_qq_group.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* renamed from: U */
    public void m40450U(String phoneNum) {
        new RequestPermission(this).m3480c("android.permission.CALL_PHONE").m3479d(new C5153e(phoneNum));
    }

    /* renamed from: W */
    public boolean m40448W(String key) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26jump_from%3Dwebapi%26k%3D" + key));
        try {
            startActivity(intent);
            return true;
        } catch (Exception unused) {
            new iOSOneButtonDialog(this.f1678e).setMessage("您还未安装手机QQ或安装的手机QQ版本太低").show();
            return false;
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: b */
    public void mo39445b() {
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: e */
    protected void mo39444e() {
        C5149a c5149a = new C5149a(this.f1678e, C4215R.C4221layout.item_for_contact_qq_group, this.f18843j);
        this.f18844k = c5149a;
        this.f18842i.setAdapter((ListAdapter) c5149a);
        m40447X("4008330860");
        m40449V();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: f */
    protected void mo39443f(View view) {
        this.f18841h = (TextView) m57916c(2131233089);
        this.f18842i = (ListView) m57916c(C4215R.C4219id.lv_qq_group);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: i */
    protected int mo39442i() {
        return C4215R.C4221layout.fm_contact_us;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
