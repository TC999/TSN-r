package com.bxkj.student.personal.customer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.InterfaceC1125a;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.MultiItemCommonAdapter;
import cn.bluemobi.dylan.base.utils.C1138b;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bxkj.base.p085v2.common.utils.ImageSelectUtils;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.orhanobut.logger.C11792j;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import p617l1.InterfaceC15280l;
import p635q.MainApiService;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ContactCustomerActivity extends BaseActivity {

    /* renamed from: k */
    private EditText f18813k;

    /* renamed from: l */
    private Button f18814l;

    /* renamed from: m */
    private ImageView f18815m;

    /* renamed from: n */
    private MultiItemCommonAdapter<Map<String, Object>> f18816n;

    /* renamed from: o */
    private LinearLayoutManager f18817o;

    /* renamed from: p */
    private RecyclerView f18818p;

    /* renamed from: q */
    private SmartRefreshLayout f18819q;

    /* renamed from: r */
    private List<Map<String, Object>> f18820r = new ArrayList();

    /* renamed from: s */
    protected int f18821s = 10;

    /* renamed from: t */
    protected int f18822t = 1;

    /* renamed from: u */
    protected int f18823u = 1;

    /* renamed from: com.bxkj.student.personal.customer.ContactCustomerActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5140a implements TextWatcher {
        C5140a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            if (ContactCustomerActivity.this.f18813k.getText().toString().trim().isEmpty()) {
                ContactCustomerActivity.this.f18815m.setVisibility(0);
                ContactCustomerActivity.this.f18814l.setVisibility(8);
                return;
            }
            ContactCustomerActivity.this.f18815m.setVisibility(8);
            ContactCustomerActivity.this.f18814l.setVisibility(0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    }

    /* renamed from: com.bxkj.student.personal.customer.ContactCustomerActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5141b implements InterfaceC1125a<Map<String, Object>> {
        C5141b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.InterfaceC1125a
        /* renamed from: b */
        public int mo40464b(int itemType) {
            return itemType == 1 ? C4215R.C4221layout.item_for_say : C4215R.C4221layout.item_for_reply;
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.InterfaceC1125a
        /* renamed from: c */
        public int mo40465a(int position, Map<String, Object> stringObjectMap) {
            return LoginUser.getLoginUser().getUserId().equals(JsonParse.getString(stringObjectMap, "userId")) ? 1 : 0;
        }
    }

    /* renamed from: com.bxkj.student.personal.customer.ContactCustomerActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5142c extends MultiItemCommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.personal.customer.ContactCustomerActivity$c$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC5143a implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f18827a;

            View$OnClickListenerC5143a(final Map val$stringObjectMap) {
                this.f18827a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ContactCustomerActivity.this.m40467y0(JsonParse.getString(this.f18827a, "content"));
            }
        }

        C5142c(Context context, List datas, InterfaceC1125a multiItemTypeSupport) {
            super(context, datas, multiItemTypeSupport);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            if (JsonParse.getString(stringObjectMap, "isImg").equals("1")) {
                ImageView imageView = (ImageView) holder.m57862h(C4215R.C4219id.f15999iv);
                holder.m57870N(2131232200, true);
                holder.m57870N(C4215R.C4219id.tv_reply, false);
                try {
                    holder.m57851s(C4215R.C4219id.f15999iv, JsonParse.getString(stringObjectMap, "content"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                holder.m57870N(2131232200, false);
                holder.m57870N(C4215R.C4219id.tv_reply, true);
                holder.m57874J(C4215R.C4219id.tv_reply, JsonParse.getString(stringObjectMap, "content"));
            }
            if (LoginUser.getLoginUser().getUserId().equals(JsonParse.getString(stringObjectMap, "userId"))) {
                holder.m57874J(2131233216, LoginUser.getLoginUser().getRealName());
            } else {
                holder.m57874J(2131233216, "系统");
            }
            holder.m57874J(2131232926, JsonParse.getString(stringObjectMap, "replyTime"));
            holder.m57847w(C4215R.C4219id.f15999iv, new View$OnClickListenerC5143a(stringObjectMap));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.customer.ContactCustomerActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5144d extends HttpCallBack {
        C5144d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ContactCustomerActivity.this.f18813k.setText("");
            ContactCustomerActivity.this.f18819q.mo2024q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.customer.ContactCustomerActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5145e implements OnRefreshLoadmoreListener {
        C5145e() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            ContactCustomerActivity contactCustomerActivity = ContactCustomerActivity.this;
            int i = contactCustomerActivity.f18823u;
            int i2 = contactCustomerActivity.f18821s;
            int i3 = i / i2;
            int i4 = contactCustomerActivity.f18822t;
            if (i % i2 != 0) {
                i3++;
            }
            if (i4 >= i3) {
                contactCustomerActivity.f18819q.mo2078B();
                Toast.makeText(((BaseActivity) ContactCustomerActivity.this).f1669h, "已全部加载完毕", 0).show();
                return;
            }
            contactCustomerActivity.f18822t = i4 + 1;
            contactCustomerActivity.m40471u0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            ContactCustomerActivity.this.m40466z0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.customer.ContactCustomerActivity$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5146f extends HttpCallBack {

        /* renamed from: com.bxkj.student.personal.customer.ContactCustomerActivity$f$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class RunnableC5147a implements Runnable {
            RunnableC5147a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ContactCustomerActivity.this.f18818p.smoothScrollToPosition(ContactCustomerActivity.this.f18816n.getItemCount() - 1);
            }
        }

        C5146f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            ContactCustomerActivity.this.f18819q.mo2057W(0);
            ContactCustomerActivity.this.f18819q.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ContactCustomerActivity.this.f18823u = Integer.parseInt(Tools.m57632O(data, "total"));
            List<Map<String, Object>> list = JsonParse.getList(data, "data");
            ContactCustomerActivity contactCustomerActivity = ContactCustomerActivity.this;
            if (contactCustomerActivity.f18822t == 1) {
                contactCustomerActivity.f18820r.clear();
                ContactCustomerActivity.this.f18820r.addAll(list);
                if (ContactCustomerActivity.this.f18820r.isEmpty()) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
                    HashMap hashMap = new HashMap(2);
                    hashMap.put("replyTime", simpleDateFormat.format(new Date()));
                    hashMap.put("content", "为了服务质量，我们将采取实名制，请认真反馈");
                    ContactCustomerActivity.this.f18820r.add(hashMap);
                    HashMap hashMap2 = new HashMap(2);
                    hashMap2.put("replyTime", simpleDateFormat.format(new Date()));
                    hashMap2.put("content", "请输入您的宝贵意见或建议,我们将努力改进");
                    ContactCustomerActivity.this.f18820r.add(hashMap2);
                    HashMap hashMap3 = new HashMap(2);
                    hashMap3.put("replyTime", simpleDateFormat.format(new Date()));
                    hashMap3.put("content", "请留下您的联系方式，以便我们回复您");
                    ContactCustomerActivity.this.f18820r.add(hashMap3);
                }
                ContactCustomerActivity.this.f18816n.notifyDataSetChanged();
                if (ContactCustomerActivity.this.f18816n.getItemCount() > 0) {
                    ContactCustomerActivity.this.f18818p.post(new RunnableC5147a());
                    return;
                }
                return;
            }
            contactCustomerActivity.f18820r.addAll(0, list);
            ContactCustomerActivity.this.f18816n.notifyItemRangeInserted(-list.size(), list.size());
            ContactCustomerActivity.this.f18818p.getChildAt(ContactCustomerActivity.this.f18817o.findFirstVisibleItemPosition());
            LinearLayoutManager linearLayoutManager = ContactCustomerActivity.this.f18817o;
            int itemCount = ContactCustomerActivity.this.f18816n.getItemCount();
            ContactCustomerActivity contactCustomerActivity2 = ContactCustomerActivity.this;
            linearLayoutManager.scrollToPositionWithOffset(itemCount - (contactCustomerActivity2.f18821s * (contactCustomerActivity2.f18822t - 1)), -Tools.m57620a(50.0f, ((BaseActivity) contactCustomerActivity2).f1669h));
        }
    }

    /* renamed from: A0 */
    private void m40485A0(File file) {
        String trim;
        if (file != null && file.exists()) {
            trim = C1138b.m57768b(m40484B0(file.getPath()));
        } else {
            trim = this.f18813k.getText().toString().trim();
            if (trim.isEmpty()) {
                m57919h0("内容不能为空");
                return;
            }
        }
        String str = trim;
        String userId = LoginUser.getLoginUser().getUserId();
        if (!LoginUser.getLoginUser().isLogin()) {
            userId = LoginUser.getLoginUser().getTempUserId();
        }
        Http.with(this.f1669h).setObservable(((MainApiService) Http.getApiService(MainApiService.class)).m2257t(LoginUser.getLoginUser().getSchoolId(), userId, m40470v0(), "Android", str, file == null ? null : file.getName(), LoginUser.getLoginUser().getTempUserName(), LoginUser.getLoginUser().getTempUserNumber(), LoginUser.getLoginUser().getTempUserPhone())).setDataListener(new C5144d());
    }

    /* renamed from: B0 */
    public static byte[] m40484B0(String filename) {
        Throwable th;
        FileChannel fileChannel;
        try {
            fileChannel = new RandomAccessFile(filename, "r").getChannel();
        } catch (IOException e) {
            e = e;
            fileChannel = null;
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
            try {
                fileChannel.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            throw th;
        }
        try {
            try {
                MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, fileChannel.size()).load();
                C11792j.m20470c(Boolean.valueOf(load.isLoaded()));
                byte[] bArr = new byte[(int) fileChannel.size()];
                if (load.remaining() > 0) {
                    load.get(bArr, 0, load.remaining());
                }
                try {
                    fileChannel.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return bArr;
            } catch (Throwable th3) {
                th = th3;
                fileChannel.close();
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            e.printStackTrace();
            try {
                fileChannel.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: v0 */
    private String m40470v0() {
        try {
            return this.f1669h.getPackageManager().getPackageInfo(this.f1669h.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "0.1";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0 */
    public /* synthetic */ Unit m40468x0(File file) {
        m40485A0(file);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0 */
    public void m40467y0(String showUrl) {
        if (this.f18820r == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f18820r.size(); i++) {
            if (JsonParse.getString(this.f18820r.get(i), "isImg").equals("1")) {
                arrayList.add(JsonParse.getString(this.f18820r.get(i), "content"));
            }
        }
        Intent intent = new Intent(this.f1669h, ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.f1869h, (String[]) arrayList.toArray(new String[arrayList.size()]));
        intent.putExtra(ImagePagerActivity.f1868g, arrayList.indexOf(showUrl));
        startActivity(intent);
        overridePendingTransition(2130772087, 2130772088);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18814l.setOnClickListener(this);
        this.f18815m.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_feedback_repay;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f18813k.addTextChangedListener(new C5140a());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f1669h);
        this.f18817o = linearLayoutManager;
        this.f18818p.setLayoutManager(linearLayoutManager);
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController.setOrder(1);
        this.f18818p.setLayoutAnimation(layoutAnimationController);
        C5142c c5142c = new C5142c(this.f1669h, this.f18820r, new C5141b());
        this.f18816n = c5142c;
        this.f18818p.setAdapter(c5142c);
        m40469w0();
        this.f18819q.mo2024q();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("联系客服");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18818p = (RecyclerView) findViewById(2131232481);
        this.f18819q = (SmartRefreshLayout) findViewById(2131232482);
        this.f18813k = (EditText) findViewById(2131231273);
        this.f18814l = (Button) findViewById(2131230989);
        this.f18815m = (ImageView) findViewById(2131230950);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        if (id == 2131230950) {
            ImageSelectUtils.f15123a.m43786p(this.f1670i, new InterfaceC15280l() { // from class: com.bxkj.student.personal.customer.a
                @Override // p617l1.InterfaceC15280l
                public final Object invoke(Object obj) {
                    Unit m40468x0;
                    m40468x0 = ContactCustomerActivity.this.m40468x0((File) obj);
                    return m40468x0;
                }
            });
        } else if (id != 2131230989) {
        } else {
            m40485A0(null);
        }
    }

    /* renamed from: u0 */
    public void m40471u0() {
        String userId = LoginUser.getLoginUser().getUserId();
        if (!LoginUser.getLoginUser().isLogin()) {
            userId = LoginUser.getLoginUser().getTempUserId();
        }
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((MainApiService) Http.getApiService(MainApiService.class)).m2274c(LoginUser.getLoginUser().getSchoolId(), userId, this.f18822t, this.f18821s)).setDataListener(new C5146f());
    }

    /* renamed from: w0 */
    public void m40469w0() {
        this.f18819q.mo2054Z(2.0f);
        this.f18819q.mo2070J(Tools.m57620a(50.0f, this.f1669h));
        this.f18819q.mo2019v(new C5145e());
    }

    /* renamed from: z0 */
    public void m40466z0() {
        this.f18822t = 1;
        m40471u0();
    }
}
