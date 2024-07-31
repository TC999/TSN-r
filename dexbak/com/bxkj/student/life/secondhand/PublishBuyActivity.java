package com.bxkj.student.life.secondhand;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.collection.ArrayMap;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.GridViewAddImagesAdapter;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.C1138b;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.bxkj.base.p085v2.common.utils.ImageSelectUtils;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.orhanobut.logger.C11792j;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import p617l1.InterfaceC15280l;
import p635q.LostApiService;
import p635q.SecondHandApiService;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PublishBuyActivity extends BaseActivity {

    /* renamed from: k */
    private EditText f18550k;

    /* renamed from: l */
    private EditText f18551l;

    /* renamed from: m */
    private EditText f18552m;

    /* renamed from: n */
    private EditText f18553n;

    /* renamed from: o */
    private EditText f18554o;

    /* renamed from: p */
    private Button f18555p;

    /* renamed from: q */
    private int f18556q;

    /* renamed from: r */
    private Spinner f18557r;

    /* renamed from: s */
    private MyGridView f18558s;

    /* renamed from: u */
    private GridViewAddImagesAdapter f18560u;

    /* renamed from: v */
    private CommonAdapter<Map<String, Object>> f18561v;

    /* renamed from: t */
    private List<String> f18559t = new ArrayList();

    /* renamed from: w */
    private List<Map<String, Object>> f18562w = new ArrayList();

    /* renamed from: com.bxkj.student.life.secondhand.PublishBuyActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5053a extends CommonAdapter<Map<String, Object>> {
        C5053a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
        /* renamed from: d */
        public void mo40086a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "name"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.secondhand.PublishBuyActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5054b extends HttpCallBack {
        C5054b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            PublishBuyActivity.this.f18562w = JsonParse.getList(data, "data");
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("name", "请选择物品类型");
            PublishBuyActivity.this.f18562w.add(0, arrayMap);
            PublishBuyActivity.this.f18561v.m57842c(PublishBuyActivity.this.f18562w);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.secondhand.PublishBuyActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5055c extends HttpCallBack {
        C5055c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            PublishBuyActivity.this.finish();
        }
    }

    /* renamed from: n0 */
    private void m40726n0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((LostApiService) Http.getApiService(LostApiService.class)).m2284d()).setDataListener(new C5054b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ Unit m40725o0(File file) {
        this.f18559t.add(file.getPath());
        this.f18560u.m57886c(this.f18559t);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0 */
    public /* synthetic */ void m40724p0(AdapterView adapterView, View view, int i, long j) {
        ImageSelectUtils.f15123a.m43786p(this.f1670i, new InterfaceC15280l() { // from class: com.bxkj.student.life.secondhand.b
            @Override // p617l1.InterfaceC15280l
            public final Object invoke(Object obj) {
                Unit m40725o0;
                m40725o0 = PublishBuyActivity.this.m40725o0((File) obj);
                return m40725o0;
            }
        });
    }

    /* renamed from: q0 */
    private void m40723q0() {
        if (this.f18557r.getSelectedItemPosition() != -1 && this.f18557r.getSelectedItemPosition() != 0) {
            String string = JsonParse.getString(this.f18561v.getItem(this.f18557r.getSelectedItemPosition()), "id");
            String trim = this.f18550k.getText().toString().trim();
            if (TextUtils.isEmpty(trim)) {
                m57919h0("请简单描述一下哦");
                return;
            }
            String trim2 = this.f18551l.getText().toString().trim();
            if (TextUtils.isEmpty(trim2)) {
                m57919h0("请定一个合适的价格哦");
                return;
            }
            String trim3 = this.f18552m.getText().toString().trim();
            String trim4 = this.f18553n.getText().toString().trim();
            String trim5 = this.f18554o.getText().toString().trim();
            if (TextUtils.isEmpty(trim3) && TextUtils.isEmpty(trim4) && TextUtils.isEmpty(trim5)) {
                m57919h0("至少填写一种联系方式哦");
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (String str : this.f18559t) {
                File file = new File(str);
                String m57768b = C1138b.m57768b(m40722r0(file.getPath()));
                arrayList2.add(m57768b);
                HashMap hashMap = new HashMap(2);
                hashMap.put("imageName", file.getName());
                hashMap.put("imageBase64", m57768b);
                arrayList.add(hashMap);
            }
            Http.with(this.f1669h).setObservable(((SecondHandApiService) Http.getApiService(SecondHandApiService.class)).m2195e(LoginUser.getLoginUser().getOpenId(), string, this.f18556q, trim, JSON.toJSONString(arrayList2), trim3, trim5, trim4, trim2)).setDataListener(new C5055c());
            return;
        }
        m57919h0("请选择物品类型");
    }

    /* renamed from: r0 */
    public static byte[] m40722r0(String filename) {
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

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18555p.setOnClickListener(this);
        this.f18558s.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.life.secondhand.a
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                PublishBuyActivity.this.m40724p0(adapterView, view, i, j);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_publish_buy;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("type")) {
            int intExtra = getIntent().getIntExtra("type", 0);
            this.f18556q = intExtra;
            if (intExtra == 0) {
                setTitle("发布求购信息");
            } else {
                setTitle("发布出售信息");
            }
        }
        List<String> list = this.f18559t;
        Context context = this.f1669h;
        GridViewAddImagesAdapter gridViewAddImagesAdapter = new GridViewAddImagesAdapter(list, context, 4, Tools.m57620a(10.0f, context));
        this.f18560u = gridViewAddImagesAdapter;
        gridViewAddImagesAdapter.m57884e(3);
        this.f18558s.setAdapter((ListAdapter) this.f18560u);
        C5053a c5053a = new C5053a(this.f1669h, 2131427755, this.f18562w);
        this.f18561v = c5053a;
        this.f18557r.setAdapter((SpinnerAdapter) c5053a);
        m40726n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("发布求购信息");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18558s = (MyGridView) findViewById(2131231335);
        this.f18557r = (Spinner) findViewById(2131232642);
        this.f18550k = (EditText) findViewById(C4215R.C4219id.et_desc);
        this.f18558s = (MyGridView) findViewById(2131231335);
        this.f18551l = (EditText) findViewById(C4215R.C4219id.et_price);
        this.f18552m = (EditText) findViewById(2131231266);
        this.f18553n = (EditText) findViewById(C4215R.C4219id.et_wechat);
        this.f18554o = (EditText) findViewById(C4215R.C4219id.et_qq);
        this.f18555p = (Button) findViewById(C4215R.C4219id.bt_publish);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() != 2131230995) {
            return;
        }
        m40723q0();
    }
}
