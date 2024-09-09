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
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
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
import q.e;
import q.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class PublishBuyActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private EditText f21857k;

    /* renamed from: l  reason: collision with root package name */
    private EditText f21858l;

    /* renamed from: m  reason: collision with root package name */
    private EditText f21859m;

    /* renamed from: n  reason: collision with root package name */
    private EditText f21860n;

    /* renamed from: o  reason: collision with root package name */
    private EditText f21861o;

    /* renamed from: p  reason: collision with root package name */
    private Button f21862p;

    /* renamed from: q  reason: collision with root package name */
    private int f21863q;

    /* renamed from: r  reason: collision with root package name */
    private Spinner f21864r;

    /* renamed from: s  reason: collision with root package name */
    private MyGridView f21865s;

    /* renamed from: u  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.c f21867u;

    /* renamed from: v  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> f21868v;

    /* renamed from: t  reason: collision with root package name */
    private List<String> f21866t = new ArrayList();

    /* renamed from: w  reason: collision with root package name */
    private List<Map<String, Object>> f21869w = new ArrayList();

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
            PublishBuyActivity.this.f21869w = JsonParse.getList(data, "data");
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("name", "\u8bf7\u9009\u62e9\u7269\u54c1\u7c7b\u578b");
            PublishBuyActivity.this.f21869w.add(0, arrayMap);
            PublishBuyActivity.this.f21868v.c(PublishBuyActivity.this.f21869w);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            PublishBuyActivity.this.finish();
        }
    }

    private void n0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((e) Http.getApiService(e.class)).d()).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ f1 o0(File file) {
        this.f21866t.add(file.getPath());
        this.f21867u.c(this.f21866t);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(AdapterView adapterView, View view, int i4, long j4) {
        k.f18613a.p(this.f1657i, new l() { // from class: com.bxkj.student.life.secondhand.b
            @Override // l1.l
            public final Object invoke(Object obj) {
                f1 o02;
                o02 = PublishBuyActivity.this.o0((File) obj);
                return o02;
            }
        });
    }

    private void q0() {
        if (this.f21864r.getSelectedItemPosition() != -1 && this.f21864r.getSelectedItemPosition() != 0) {
            String string = JsonParse.getString(this.f21868v.getItem(this.f21864r.getSelectedItemPosition()), "id");
            String trim = this.f21857k.getText().toString().trim();
            if (TextUtils.isEmpty(trim)) {
                h0("\u8bf7\u7b80\u5355\u63cf\u8ff0\u4e00\u4e0b\u54e6");
                return;
            }
            String trim2 = this.f21858l.getText().toString().trim();
            if (TextUtils.isEmpty(trim2)) {
                h0("\u8bf7\u5b9a\u4e00\u4e2a\u5408\u9002\u7684\u4ef7\u683c\u54e6");
                return;
            }
            String trim3 = this.f21859m.getText().toString().trim();
            String trim4 = this.f21860n.getText().toString().trim();
            String trim5 = this.f21861o.getText().toString().trim();
            if (TextUtils.isEmpty(trim3) && TextUtils.isEmpty(trim4) && TextUtils.isEmpty(trim5)) {
                h0("\u81f3\u5c11\u586b\u5199\u4e00\u79cd\u8054\u7cfb\u65b9\u5f0f\u54e6");
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (String str : this.f21866t) {
                File file = new File(str);
                String b4 = cn.bluemobi.dylan.base.utils.b.b(r0(file.getPath()));
                arrayList2.add(b4);
                HashMap hashMap = new HashMap(2);
                hashMap.put("imageName", file.getName());
                hashMap.put("imageBase64", b4);
                arrayList.add(hashMap);
            }
            Http.with(this.f1656h).setObservable(((i) Http.getApiService(i.class)).e(LoginUser.getLoginUser().getOpenId(), string, this.f21863q, trim, JSON.toJSONString(arrayList2), trim3, trim5, trim4, trim2)).setDataListener(new c());
            return;
        }
        h0("\u8bf7\u9009\u62e9\u7269\u54c1\u7c7b\u578b");
    }

    public static byte[] r0(String filename) {
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
        this.f21862p.setOnClickListener(this);
        this.f21865s.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.life.secondhand.a
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
                PublishBuyActivity.this.p0(adapterView, view, i4, j4);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427461;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("type")) {
            int intExtra = getIntent().getIntExtra("type", 0);
            this.f21863q = intExtra;
            if (intExtra == 0) {
                setTitle("\u53d1\u5e03\u6c42\u8d2d\u4fe1\u606f");
            } else {
                setTitle("\u53d1\u5e03\u51fa\u552e\u4fe1\u606f");
            }
        }
        List<String> list = this.f21866t;
        Context context = this.f1656h;
        cn.bluemobi.dylan.base.adapter.c cVar = new cn.bluemobi.dylan.base.adapter.c(list, context, 4, u.a(10.0f, context));
        this.f21867u = cVar;
        cVar.e(3);
        this.f21865s.setAdapter((ListAdapter) this.f21867u);
        a aVar = new a(this.f1656h, 2131427755, this.f21869w);
        this.f21868v = aVar;
        this.f21864r.setAdapter((SpinnerAdapter) aVar);
        n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u53d1\u5e03\u6c42\u8d2d\u4fe1\u606f");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21865s = (MyGridView) findViewById(2131231335);
        this.f21864r = (Spinner) findViewById(2131232642);
        this.f21857k = (EditText) findViewById(2131231257);
        this.f21865s = (MyGridView) findViewById(2131231335);
        this.f21858l = (EditText) findViewById(2131231267);
        this.f21859m = (EditText) findViewById(2131231266);
        this.f21860n = (EditText) findViewById(2131231281);
        this.f21861o = (EditText) findViewById(2131231269);
        this.f21862p = (Button) findViewById(2131230995);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        if (v3.getId() != 2131230995) {
            return;
        }
        q0();
    }
}
