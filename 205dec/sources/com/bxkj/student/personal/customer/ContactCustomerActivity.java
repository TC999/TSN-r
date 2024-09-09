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
import cn.bluemobi.dylan.base.adapter.common.recyclerview.MultiItemCommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.common.utils.k;
import com.orhanobut.logger.j;
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
import kotlin.f1;
import l1.l;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ContactCustomerActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private EditText f22097k;

    /* renamed from: l  reason: collision with root package name */
    private Button f22098l;

    /* renamed from: m  reason: collision with root package name */
    private ImageView f22099m;

    /* renamed from: n  reason: collision with root package name */
    private MultiItemCommonAdapter<Map<String, Object>> f22100n;

    /* renamed from: o  reason: collision with root package name */
    private LinearLayoutManager f22101o;

    /* renamed from: p  reason: collision with root package name */
    private RecyclerView f22102p;

    /* renamed from: q  reason: collision with root package name */
    private SmartRefreshLayout f22103q;

    /* renamed from: r  reason: collision with root package name */
    private List<Map<String, Object>> f22104r = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    protected int f22105s = 10;

    /* renamed from: t  reason: collision with root package name */
    protected int f22106t = 1;

    /* renamed from: u  reason: collision with root package name */
    protected int f22107u = 1;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s3) {
            if (ContactCustomerActivity.this.f22097k.getText().toString().trim().isEmpty()) {
                ContactCustomerActivity.this.f22099m.setVisibility(0);
                ContactCustomerActivity.this.f22098l.setVisibility(8);
                return;
            }
            ContactCustomerActivity.this.f22099m.setVisibility(8);
            ContactCustomerActivity.this.f22098l.setVisibility(0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s3, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s3, int start, int before, int count) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b implements cn.bluemobi.dylan.base.adapter.common.recyclerview.a<Map<String, Object>> {
        b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
        public int b(int itemType) {
            return itemType == 1 ? 2131427754 : 2131427748;
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
        /* renamed from: c */
        public int a(int position, Map<String, Object> stringObjectMap) {
            return LoginUser.getLoginUser().getUserId().equals(JsonParse.getString(stringObjectMap, "userId")) ? 1 : 0;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class c extends MultiItemCommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f22111a;

            a(final Map val$stringObjectMap) {
                this.f22111a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                ContactCustomerActivity.this.y0(JsonParse.getString(this.f22111a, "content"));
            }
        }

        c(Context context, List datas, cn.bluemobi.dylan.base.adapter.common.recyclerview.a multiItemTypeSupport) {
            super(context, datas, multiItemTypeSupport);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            if (JsonParse.getString(stringObjectMap, "isImg").equals("1")) {
                ImageView imageView = (ImageView) holder.h(2131231382);
                holder.N(2131232200, true);
                holder.N(2131233124, false);
                try {
                    holder.s(2131231382, JsonParse.getString(stringObjectMap, "content"));
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            } else {
                holder.N(2131232200, false);
                holder.N(2131233124, true);
                holder.J(2131233124, JsonParse.getString(stringObjectMap, "content"));
            }
            if (LoginUser.getLoginUser().getUserId().equals(JsonParse.getString(stringObjectMap, "userId"))) {
                holder.J(2131233216, LoginUser.getLoginUser().getRealName());
            } else {
                holder.J(2131233216, "\u7cfb\u7edf");
            }
            holder.J(2131232926, JsonParse.getString(stringObjectMap, "replyTime"));
            holder.w(2131231382, new a(stringObjectMap));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ContactCustomerActivity.this.f22097k.setText("");
            ContactCustomerActivity.this.f22103q.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e implements s0.e {
        e() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            ContactCustomerActivity contactCustomerActivity = ContactCustomerActivity.this;
            int i4 = contactCustomerActivity.f22107u;
            int i5 = contactCustomerActivity.f22105s;
            int i6 = i4 / i5;
            int i7 = contactCustomerActivity.f22106t;
            if (i4 % i5 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                contactCustomerActivity.f22103q.y();
                Toast.makeText(((BaseActivity) ContactCustomerActivity.this).f1656h, "\u5df2\u5168\u90e8\u52a0\u8f7d\u5b8c\u6bd5", 0).show();
                return;
            }
            contactCustomerActivity.f22106t = i7 + 1;
            contactCustomerActivity.u0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            ContactCustomerActivity.this.z0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class f extends HttpCallBack {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ContactCustomerActivity.this.f22102p.smoothScrollToPosition(ContactCustomerActivity.this.f22100n.getItemCount() - 1);
            }
        }

        f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            ContactCustomerActivity.this.f22103q.V(0);
            ContactCustomerActivity.this.f22103q.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ContactCustomerActivity.this.f22107u = Integer.parseInt(u.O(data, "total"));
            List<Map<String, Object>> list = JsonParse.getList(data, "data");
            ContactCustomerActivity contactCustomerActivity = ContactCustomerActivity.this;
            if (contactCustomerActivity.f22106t == 1) {
                contactCustomerActivity.f22104r.clear();
                ContactCustomerActivity.this.f22104r.addAll(list);
                if (ContactCustomerActivity.this.f22104r.isEmpty()) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
                    HashMap hashMap = new HashMap(2);
                    hashMap.put("replyTime", simpleDateFormat.format(new Date()));
                    hashMap.put("content", "\u4e3a\u4e86\u670d\u52a1\u8d28\u91cf\uff0c\u6211\u4eec\u5c06\u91c7\u53d6\u5b9e\u540d\u5236\uff0c\u8bf7\u8ba4\u771f\u53cd\u9988");
                    ContactCustomerActivity.this.f22104r.add(hashMap);
                    HashMap hashMap2 = new HashMap(2);
                    hashMap2.put("replyTime", simpleDateFormat.format(new Date()));
                    hashMap2.put("content", "\u8bf7\u8f93\u5165\u60a8\u7684\u5b9d\u8d35\u610f\u89c1\u6216\u5efa\u8bae,\u6211\u4eec\u5c06\u52aa\u529b\u6539\u8fdb");
                    ContactCustomerActivity.this.f22104r.add(hashMap2);
                    HashMap hashMap3 = new HashMap(2);
                    hashMap3.put("replyTime", simpleDateFormat.format(new Date()));
                    hashMap3.put("content", "\u8bf7\u7559\u4e0b\u60a8\u7684\u8054\u7cfb\u65b9\u5f0f\uff0c\u4ee5\u4fbf\u6211\u4eec\u56de\u590d\u60a8");
                    ContactCustomerActivity.this.f22104r.add(hashMap3);
                }
                ContactCustomerActivity.this.f22100n.notifyDataSetChanged();
                if (ContactCustomerActivity.this.f22100n.getItemCount() > 0) {
                    ContactCustomerActivity.this.f22102p.post(new a());
                    return;
                }
                return;
            }
            contactCustomerActivity.f22104r.addAll(0, list);
            ContactCustomerActivity.this.f22100n.notifyItemRangeInserted(-list.size(), list.size());
            ContactCustomerActivity.this.f22102p.getChildAt(ContactCustomerActivity.this.f22101o.findFirstVisibleItemPosition());
            LinearLayoutManager linearLayoutManager = ContactCustomerActivity.this.f22101o;
            int itemCount = ContactCustomerActivity.this.f22100n.getItemCount();
            ContactCustomerActivity contactCustomerActivity2 = ContactCustomerActivity.this;
            linearLayoutManager.scrollToPositionWithOffset(itemCount - (contactCustomerActivity2.f22105s * (contactCustomerActivity2.f22106t - 1)), -u.a(50.0f, ((BaseActivity) contactCustomerActivity2).f1656h));
        }
    }

    private void A0(File file) {
        String trim;
        if (file != null && file.exists()) {
            trim = cn.bluemobi.dylan.base.utils.b.b(B0(file.getPath()));
        } else {
            trim = this.f22097k.getText().toString().trim();
            if (trim.isEmpty()) {
                h0("\u5185\u5bb9\u4e0d\u80fd\u4e3a\u7a7a");
                return;
            }
        }
        String str = trim;
        String userId = LoginUser.getLoginUser().getUserId();
        if (!LoginUser.getLoginUser().isLogin()) {
            userId = LoginUser.getLoginUser().getTempUserId();
        }
        Http.with(this.f1656h).setObservable(((q.f) Http.getApiService(q.f.class)).t(LoginUser.getLoginUser().getSchoolId(), userId, v0(), "Android", str, file == null ? null : file.getName(), LoginUser.getLoginUser().getTempUserName(), LoginUser.getLoginUser().getTempUserNumber(), LoginUser.getLoginUser().getTempUserPhone())).setDataListener(new d());
    }

    public static byte[] B0(String filename) {
        Throwable th;
        FileChannel fileChannel;
        try {
            fileChannel = new RandomAccessFile(filename, "r").getChannel();
        } catch (IOException e4) {
            e = e4;
            fileChannel = null;
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
            try {
                fileChannel.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            throw th;
        }
        try {
            try {
                MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, fileChannel.size()).load();
                j.c(Boolean.valueOf(load.isLoaded()));
                byte[] bArr = new byte[(int) fileChannel.size()];
                if (load.remaining() > 0) {
                    load.get(bArr, 0, load.remaining());
                }
                try {
                    fileChannel.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
                return bArr;
            } catch (Throwable th3) {
                th = th3;
                fileChannel.close();
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            e.printStackTrace();
            try {
                fileChannel.close();
            } catch (IOException e8) {
                e8.printStackTrace();
            }
            return null;
        }
    }

    private String v0() {
        try {
            return this.f1656h.getPackageManager().getPackageInfo(this.f1656h.getPackageName(), 0).versionName;
        } catch (Exception e4) {
            e4.printStackTrace();
            return "0.1";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ f1 x0(File file) {
        A0(file);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(String showUrl) {
        if (this.f22104r == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < this.f22104r.size(); i4++) {
            if (JsonParse.getString(this.f22104r.get(i4), "isImg").equals("1")) {
                arrayList.add(JsonParse.getString(this.f22104r.get(i4), "content"));
            }
        }
        Intent intent = new Intent(this.f1656h, ImagePagerActivity.class);
        intent.putExtra("image_urls", (String[]) arrayList.toArray(new String[arrayList.size()]));
        intent.putExtra("image_index", arrayList.indexOf(showUrl));
        startActivity(intent);
        overridePendingTransition(2130772087, 2130772088);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f22098l.setOnClickListener(this);
        this.f22099m.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427401;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f22097k.addTextChangedListener(new a());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f1656h);
        this.f22101o = linearLayoutManager;
        this.f22102p.setLayoutManager(linearLayoutManager);
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController.setOrder(1);
        this.f22102p.setLayoutAnimation(layoutAnimationController);
        c cVar = new c(this.f1656h, this.f22104r, new b());
        this.f22100n = cVar;
        this.f22102p.setAdapter(cVar);
        w0();
        this.f22103q.q();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8054\u7cfb\u5ba2\u670d");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f22102p = (RecyclerView) findViewById(2131232481);
        this.f22103q = (SmartRefreshLayout) findViewById(2131232482);
        this.f22097k = (EditText) findViewById(2131231273);
        this.f22098l = (Button) findViewById(2131230989);
        this.f22099m = (ImageView) findViewById(2131230950);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        int id = v3.getId();
        if (id == 2131230950) {
            k.f18613a.p(this.f1657i, new l() { // from class: com.bxkj.student.personal.customer.a
                @Override // l1.l
                public final Object invoke(Object obj) {
                    f1 x02;
                    x02 = ContactCustomerActivity.this.x0((File) obj);
                    return x02;
                }
            });
        } else if (id != 2131230989) {
        } else {
            A0(null);
        }
    }

    public void u0() {
        String userId = LoginUser.getLoginUser().getUserId();
        if (!LoginUser.getLoginUser().isLogin()) {
            userId = LoginUser.getLoginUser().getTempUserId();
        }
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((q.f) Http.getApiService(q.f.class)).c(LoginUser.getLoginUser().getSchoolId(), userId, this.f22106t, this.f22105s)).setDataListener(new f());
    }

    public void w0() {
        this.f22103q.Y(2.0f);
        this.f22103q.G(u.a(50.0f, this.f1656h));
        this.f22103q.n1(new e());
    }

    public void z0() {
        this.f22106t = 1;
        u0();
    }
}
