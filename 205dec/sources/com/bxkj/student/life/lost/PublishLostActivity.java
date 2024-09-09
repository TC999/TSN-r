package com.bxkj.student.life.lost;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.cardview.widget.CardView;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.common.utils.k;
import com.orhanobut.logger.j;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.f1;
import l1.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class PublishLostActivity extends BaseActivity {
    private cn.bluemobi.dylan.base.adapter.c A;
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> B;
    private CommonAdapter<Map<String, Object>> E;

    /* renamed from: k  reason: collision with root package name */
    private EditText f21462k;

    /* renamed from: l  reason: collision with root package name */
    private EditText f21463l;

    /* renamed from: m  reason: collision with root package name */
    private EditText f21464m;

    /* renamed from: n  reason: collision with root package name */
    private EditText f21465n;

    /* renamed from: o  reason: collision with root package name */
    private EditText f21466o;

    /* renamed from: p  reason: collision with root package name */
    private Button f21467p;

    /* renamed from: q  reason: collision with root package name */
    private CheckBox f21468q;

    /* renamed from: r  reason: collision with root package name */
    private CardView f21469r;

    /* renamed from: s  reason: collision with root package name */
    private LinearLayout f21470s;

    /* renamed from: t  reason: collision with root package name */
    private RecyclerView f21471t;

    /* renamed from: u  reason: collision with root package name */
    private RadioGroup f21472u;

    /* renamed from: v  reason: collision with root package name */
    private int f21473v;

    /* renamed from: w  reason: collision with root package name */
    private Spinner f21474w;

    /* renamed from: x  reason: collision with root package name */
    private MyGridView f21475x;

    /* renamed from: y  reason: collision with root package name */
    private List<String> f21476y = new ArrayList();

    /* renamed from: z  reason: collision with root package name */
    private final int f21477z = 204;
    private List<Map<String, Object>> C = new ArrayList();
    private List<Map<String, Object>> D = new ArrayList();

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
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "name"));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f21480a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ViewHolder f21481b;

            a(final Map val$stringObjectMap, final ViewHolder val$holder) {
                this.f21480a = val$stringObjectMap;
                this.f21481b = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                PublishLostActivity.this.D.remove(this.f21480a);
                b.this.notifyItemRemoved(this.f21481b.f());
            }
        }

        b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131233112, JsonParse.getString(stringObjectMap, "question"));
            holder.J(2131232843, JsonParse.getString(stringObjectMap, "answer"));
            holder.w(2131230970, new a(stringObjectMap, holder));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class c implements CompoundButton.OnCheckedChangeListener {
        c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            PublishLostActivity.this.f21469r.setVisibility(isChecked ? 0 : 8);
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
            PublishLostActivity.this.C = JsonParse.getList(data, "data");
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("name", "\u8bf7\u9009\u62e9\u7269\u54c1\u7c7b\u578b");
            PublishLostActivity.this.C.add(0, arrayMap);
            PublishLostActivity.this.B.c(PublishLostActivity.this.C);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e extends HttpCallBack {
        e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            PublishLostActivity.this.finish();
        }
    }

    private void p0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((q.e) Http.getApiService(q.e.class)).d()).setDataListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ f1 q0(File file) {
        this.f21476y.add(file.getPath());
        this.A.c(this.f21476y);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(AdapterView adapterView, View view, int i4, long j4) {
        k.f18613a.p(this.f1657i, new l() { // from class: com.bxkj.student.life.lost.b
            @Override // l1.l
            public final Object invoke(Object obj) {
                f1 q02;
                q02 = PublishLostActivity.this.q0((File) obj);
                return q02;
            }
        });
    }

    private void s0() {
        String str;
        int i4;
        if (this.f21474w.getSelectedItemPosition() != -1 && this.f21474w.getSelectedItemPosition() != 0) {
            String string = JsonParse.getString(this.B.getItem(this.f21474w.getSelectedItemPosition()), "id");
            String trim = this.f21462k.getText().toString().trim();
            if (TextUtils.isEmpty(trim)) {
                h0("\u8bf7\u7b80\u5355\u63cf\u8ff0\u4e00\u4e0b\u54e6");
                return;
            }
            String trim2 = this.f21463l.getText().toString().trim();
            String trim3 = this.f21464m.getText().toString().trim();
            String trim4 = this.f21465n.getText().toString().trim();
            String trim5 = this.f21466o.getText().toString().trim();
            if (TextUtils.isEmpty(trim3) && TextUtils.isEmpty(trim4) && TextUtils.isEmpty(trim5)) {
                h0("\u81f3\u5c11\u586b\u5199\u4e00\u79cd\u8054\u7cfb\u65b9\u5f0f\u54e6");
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (String str2 : this.f21476y) {
                File file = new File(str2);
                String b4 = cn.bluemobi.dylan.base.utils.b.b(t0(file.getPath()));
                arrayList2.add(b4);
                HashMap hashMap = new HashMap(2);
                hashMap.put("imageName", file.getName());
                hashMap.put("imageBase64", b4);
                arrayList.add(hashMap);
            }
            String jSONString = JSON.toJSONString(arrayList2);
            if (this.f21473v != 0 || !this.f21468q.isChecked()) {
                str = "0";
            } else if (this.D.size() == 0) {
                h0("\u81f3\u5c11\u6dfb\u52a0\u4e00\u4e2a\u95ee\u9898\u548c\u7b54\u6848");
                return;
            } else {
                str = "1";
            }
            String str3 = str;
            if (this.f21472u.getCheckedRadioButtonId() != this.f21472u.getChildAt(0).getId()) {
                if (this.f21472u.getCheckedRadioButtonId() == this.f21472u.getChildAt(1).getId()) {
                    i4 = 2;
                } else if (this.f21472u.getCheckedRadioButtonId() == this.f21472u.getChildAt(2).getId()) {
                    i4 = 1;
                }
                Http.with(this.f1656h).setObservable(((q.e) Http.getApiService(q.e.class)).e(LoginUser.getLoginUser().getOpenId(), string, this.f21473v, trim, jSONString, trim3, trim5, trim4, trim2, str3, i4, JSON.toJSONString(this.D))).setDataListener(new e());
                return;
            }
            i4 = 3;
            Http.with(this.f1656h).setObservable(((q.e) Http.getApiService(q.e.class)).e(LoginUser.getLoginUser().getOpenId(), string, this.f21473v, trim, jSONString, trim3, trim5, trim4, trim2, str3, i4, JSON.toJSONString(this.D))).setDataListener(new e());
            return;
        }
        h0("\u8bf7\u9009\u62e9\u7269\u54c1\u7c7b\u578b");
    }

    public static byte[] t0(String filename) {
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

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f21467p.setOnClickListener(this);
        this.f21470s.setOnClickListener(this);
        this.f21475x.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.life.lost.a
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
                PublishLostActivity.this.r0(adapterView, view, i4, j4);
            }
        });
        this.f21468q.setOnCheckedChangeListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427462;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("type")) {
            int intExtra = getIntent().getIntExtra("type", 1);
            this.f21473v = intExtra;
            if (intExtra == 1) {
                setTitle("\u53d1\u5e03\u5bfb\u7269\u542f\u793a");
                this.f21468q.setVisibility(8);
            } else {
                setTitle("\u53d1\u5e03\u5931\u7269\u62db\u9886");
            }
        }
        List<String> list = this.f21476y;
        Context context = this.f1656h;
        cn.bluemobi.dylan.base.adapter.c cVar = new cn.bluemobi.dylan.base.adapter.c(list, context, 4, u.a(10.0f, context));
        this.A = cVar;
        cVar.e(3);
        this.f21475x.setAdapter((ListAdapter) this.A);
        a aVar = new a(this.f1656h, 2131427755, this.C);
        this.B = aVar;
        this.f21474w.setAdapter((SpinnerAdapter) aVar);
        p0();
        this.f21471t.setLayoutManager(new LinearLayoutManager(this.f1656h));
        b bVar = new b(this.f1656h, 2131427743, this.D);
        this.E = bVar;
        this.f21471t.setAdapter(bVar);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u53d1\u5e03\u5bfb\u7269\u542f\u4e8b");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21475x = (MyGridView) findViewById(2131231335);
        this.f21474w = (Spinner) findViewById(2131232642);
        this.f21462k = (EditText) findViewById(2131231257);
        this.f21475x = (MyGridView) findViewById(2131231335);
        this.f21463l = (EditText) findViewById(2131231267);
        this.f21464m = (EditText) findViewById(2131231266);
        this.f21465n = (EditText) findViewById(2131231281);
        this.f21466o = (EditText) findViewById(2131231269);
        this.f21467p = (Button) findViewById(2131230995);
        this.f21468q = (CheckBox) findViewById(2131231087);
        this.f21469r = (CardView) findViewById(2131231057);
        this.f21470s = (LinearLayout) findViewById(2131232164);
        this.f21471t = (RecyclerView) findViewById(2131232553);
        this.f21472u = (RadioGroup) findViewById(2131232491);
        this.f21469r.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        int id = v3.getId();
        if (id == 2131230995) {
            s0();
        } else if (id != 2131232164) {
        } else {
            if (this.E.getItemCount() < 3) {
                startActivityForResult(new Intent(this.f1656h, AddQuestionActivity.class), 204);
            } else {
                h0("\u6700\u591a\u4e09\u4e2a\u95ee\u9898\u54e6\uff01");
            }
        }
    }
}
