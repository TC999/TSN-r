package com.bxkj.student.home.teaching.learning.question;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.base.view.MyListView;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.http.RequestParameter;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bxkj.student.home.teaching.learning.question.ImageActivity;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.f1;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ImageActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private MyGridView f20926k;

    /* renamed from: l  reason: collision with root package name */
    private Button f20927l;

    /* renamed from: m  reason: collision with root package name */
    private List<String> f20928m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.c f20929n;

    /* renamed from: o  reason: collision with root package name */
    private MyListView f20930o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f20931p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f20932q;

    /* renamed from: r  reason: collision with root package name */
    private LinearLayout f20933r;

    /* renamed from: s  reason: collision with root package name */
    private String f20934s;

    /* renamed from: t  reason: collision with root package name */
    private int f20935t;

    /* renamed from: u  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> f20936u;

    /* renamed from: v  reason: collision with root package name */
    private List<Map<String, Object>> f20937v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.home.teaching.learning.question.ImageActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class C0240a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<String> {
            C0240a(Context context, int layoutId, List datas) {
                super(context, layoutId, datas);
            }

            @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
            /* renamed from: d */
            public void a(ViewHolder holder, String s3) {
                holder.t(2131231436, s3, 2131165501, 2131165501);
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(String[] strArr, AdapterView adapterView, View view, int i4, long j4) {
            g(strArr, i4);
        }

        private void g(String[] arr, int index) {
            Intent intent = new Intent(this.f1702a, ImagePagerActivity.class);
            intent.putExtra("image_urls", arr);
            intent.putExtra("image_index", index);
            ImageActivity.this.startActivity(intent);
            ImageActivity.this.overridePendingTransition(2130772087, 2130772088);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
        /* renamed from: e */
        public void a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            MyGridView myGridView = (MyGridView) holder.h(2131232363);
            final String[] split = JsonParse.getString(stringObjectMap, "answerStr").split(",");
            myGridView.setAdapter((ListAdapter) new C0240a(this.f1702a, 2131427721, Arrays.asList(split)));
            myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.e
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
                    ImageActivity.a.this.f(split, adapterView, view, i4, j4);
                }
            });
            holder.J(2131232909, "\u56de\u7b54\u65f6\u95f4\uff1a" + JsonParse.getString(stringObjectMap, "answerTime"));
            String string = JsonParse.getString(stringObjectMap, "reviewTime");
            holder.N(2131232898, TextUtils.isEmpty(string) ^ true);
            holder.J(2131232898, "\u6279\u6539\u65f6\u95f4\uff1a" + string);
            int i4 = JsonParse.getInt(stringObjectMap, "isRight");
            if (i4 == 0) {
                holder.J(2131233007, "\u662f\u5426\u5408\u683c\uff1a\u4e0d\u5408\u683c");
            } else if (i4 == 1) {
                holder.J(2131233007, "\u662f\u5426\u5408\u683c\uff1a\u5408\u683c");
            } else if (i4 == 2) {
                holder.J(2131233007, "\u662f\u5426\u5408\u683c\uff1a\u5f85\u6279\u6539");
            }
            String string2 = JsonParse.getString(stringObjectMap, "note");
            holder.N(2131233132, !TextUtils.isEmpty(string2));
            holder.J(2131233132, "\u5907\u6ce8\uff1a" + string2);
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
            ImageActivity.this.R().setVisibility(0);
            ImageActivity.this.q0(data);
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
            ImageActivity.this.finish();
        }
    }

    private void l0() {
        if (this.f20928m.size() == 0) {
            h0("\u81f3\u5c11\u4e0a\u4f20\u4e00\u5f20\u56fe\u7247");
            return;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        for (String str : this.f20928m) {
            File file = new File(str);
            arrayList.add(file);
            String str2 = "";
            sb.append(sb.toString().isEmpty() ? "" : ",");
            sb.append(file.getName());
            if (!sb2.toString().isEmpty()) {
                str2 = ",";
            }
            sb2.append(str2);
            sb2.append(cn.bluemobi.dylan.base.utils.b.b(r0(file.getPath())));
        }
        if (TextUtils.isEmpty(sb2)) {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u8bf7\u81f3\u5c11\u4e0a\u4f20\u4e00\u5f20\u56fe\u7247").show();
        } else {
            Http.with(this.f1656h).setTimeout(3L, TimeUnit.MINUTES).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).d(RequestParameter.getRequestBody(this.f20934s), m0("files", arrayList))).setDataListener(new c());
        }
    }

    private void n0() {
        Http.with(this.f1656h).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).c(this.f20934s, this.f20935t)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ f1 o0(File file) {
        this.f20928m.add(file.getPath());
        this.f20929n.c(this.f20928m);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(AdapterView adapterView, View view, int i4, long j4) {
        if (i4 == this.f20928m.size()) {
            com.bxkj.base.v2.common.utils.k.f18613a.p(this.f1657i, new l1.l() { // from class: com.bxkj.student.home.teaching.learning.question.d
                @Override // l1.l
                public final Object invoke(Object obj) {
                    f1 o02;
                    o02 = ImageActivity.this.o0((File) obj);
                    return o02;
                }
            });
        } else {
            com.bxkj.base.util.m.c(this.f1656h, this.f20928m, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(Map<String, Object> data) {
        this.f20937v = JsonParse.getList(data, "questionsRecord");
        this.f20929n.e(JsonParse.getInt(data, "pictureCount", 3));
        if (this.f20937v.isEmpty()) {
            this.f20933r.setVisibility(8);
            this.f20930o.setVisibility(8);
        } else {
            this.f20936u.c(this.f20937v);
        }
        TextView textView = this.f20931p;
        textView.setText("(" + JsonParse.getString(data, "socre") + "\u5206)");
        this.f20932q.setText(Html.fromHtml(JsonParse.getString(data, "questionName")));
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
                com.orhanobut.logger.j.c(Boolean.valueOf(load.isLoaded()));
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
        this.f20926k.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.c
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
                ImageActivity.this.p0(adapterView, view, i4, j4);
            }
        });
        this.f20927l.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427419;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        R().setVisibility(8);
        if (getIntent().hasExtra("questionId")) {
            this.f20934s = getIntent().getStringExtra("questionId");
        }
        if (getIntent().hasExtra("isQualified")) {
            this.f20935t = getIntent().getIntExtra("isQualified", 0);
        }
        int i4 = this.f20935t;
        if (i4 == 1) {
            this.f20927l.setText("\u5df2\u5408\u683c");
            this.f20926k.setVisibility(8);
            this.f20927l.setEnabled(false);
        } else if (i4 == 2) {
            this.f20927l.setText("\u5f85\u6279\u6539");
            this.f20926k.setVisibility(8);
            this.f20927l.setEnabled(false);
        }
        a aVar = new a(this.f1656h, 2131427708, this.f20937v);
        this.f20936u = aVar;
        this.f20930o.setAdapter((ListAdapter) aVar);
        List<String> list = this.f20928m;
        Context context = this.f1656h;
        cn.bluemobi.dylan.base.adapter.c cVar = new cn.bluemobi.dylan.base.adapter.c(list, context, 4, u.a(10.0f, context));
        this.f20929n = cVar;
        cVar.e(3);
        this.f20926k.setAdapter((ListAdapter) this.f20929n);
        n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u5f00\u59cb\u7b54\u9898-\u62cd\u7167");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20926k = (MyGridView) findViewById(2131231335);
        this.f20930o = (MyListView) findViewById(2131232542);
        this.f20931p = (TextView) findViewById(2131233146);
        this.f20932q = (TextView) findViewById(2131233112);
        this.f20933r = (LinearLayout) findViewById(2131232197);
        this.f20927l = (Button) findViewById(2131230967);
    }

    public Map<String, RequestBody> m0(String key, List<File> files) {
        ArrayMap arrayMap = new ArrayMap();
        for (int i4 = 0; i4 < files.size(); i4++) {
            File file = files.get(i4);
            RequestBody create = RequestBody.create(MediaType.parse("image/png"), file);
            arrayMap.put(key + "\"; filename=\"" + file.getName(), create);
        }
        return arrayMap;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        l0();
    }
}
