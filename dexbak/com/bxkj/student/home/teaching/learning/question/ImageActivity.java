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
import cn.bluemobi.dylan.base.adapter.GridViewAddImagesAdapter;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.C1138b;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.base.view.MyListView;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.http.RequestParameter;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bxkj.base.p085v2.common.utils.ImageSelectUtils;
import com.bxkj.base.util.C3906m;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.learning.LearningApiService;
import com.bxkj.student.home.teaching.learning.question.ImageActivity;
import com.orhanobut.logger.C11792j;
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
import kotlin.Unit;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import p617l1.InterfaceC15280l;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ImageActivity extends BaseActivity {

    /* renamed from: k */
    private MyGridView f17583k;

    /* renamed from: l */
    private Button f17584l;

    /* renamed from: m */
    private List<String> f17585m = new ArrayList();

    /* renamed from: n */
    private GridViewAddImagesAdapter f17586n;

    /* renamed from: o */
    private MyListView f17587o;

    /* renamed from: p */
    private TextView f17588p;

    /* renamed from: q */
    private TextView f17589q;

    /* renamed from: r */
    private LinearLayout f17590r;

    /* renamed from: s */
    private String f17591s;

    /* renamed from: t */
    private int f17592t;

    /* renamed from: u */
    private CommonAdapter<Map<String, Object>> f17593u;

    /* renamed from: v */
    private List<Map<String, Object>> f17594v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.question.ImageActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4715a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.home.teaching.learning.question.ImageActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class C4716a extends CommonAdapter<String> {
            C4716a(Context context, int layoutId, List datas) {
                super(context, layoutId, datas);
            }

            @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
            /* renamed from: d */
            public void mo40086a(ViewHolder holder, String s) {
                holder.m57850t(C4215R.C4219id.iv_img, s, 2131165501, 2131165501);
            }
        }

        C4715a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: f */
        public /* synthetic */ void m41525f(String[] strArr, AdapterView adapterView, View view, int i, long j) {
            m41524g(strArr, i);
        }

        /* renamed from: g */
        private void m41524g(String[] arr, int index) {
            Intent intent = new Intent(this.f1716a, ImagePagerActivity.class);
            intent.putExtra(ImagePagerActivity.f1869h, arr);
            intent.putExtra(ImagePagerActivity.f1868g, index);
            ImageActivity.this.startActivity(intent);
            ImageActivity.this.overridePendingTransition(2130772087, 2130772088);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
        /* renamed from: e */
        public void mo40086a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            MyGridView myGridView = (MyGridView) holder.m57862h(C4215R.C4219id.my_grid);
            final String[] split = JsonParse.getString(stringObjectMap, "answerStr").split(",");
            myGridView.setAdapter((ListAdapter) new C4716a(this.f1716a, C4215R.C4221layout.item_for_lost_img, Arrays.asList(split)));
            myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.e
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                    ImageActivity.C4715a.this.m41525f(split, adapterView, view, i, j);
                }
            });
            holder.m57874J(C4215R.C4219id.tv_commit_time, "回答时间：" + JsonParse.getString(stringObjectMap, "answerTime"));
            String string = JsonParse.getString(stringObjectMap, "reviewTime");
            holder.m57870N(C4215R.C4219id.tv_check_time, TextUtils.isEmpty(string) ^ true);
            holder.m57874J(C4215R.C4219id.tv_check_time, "批改时间：" + string);
            int i = JsonParse.getInt(stringObjectMap, "isRight");
            if (i == 0) {
                holder.m57874J(C4215R.C4219id.tv_isOK, "是否合格：不合格");
            } else if (i == 1) {
                holder.m57874J(C4215R.C4219id.tv_isOK, "是否合格：合格");
            } else if (i == 2) {
                holder.m57874J(C4215R.C4219id.tv_isOK, "是否合格：待批改");
            }
            String string2 = JsonParse.getString(stringObjectMap, "note");
            holder.m57870N(C4215R.C4219id.tv_reviewer, !TextUtils.isEmpty(string2));
            holder.m57874J(C4215R.C4219id.tv_reviewer, "备注：" + string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.question.ImageActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4717b extends HttpCallBack {
        C4717b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ImageActivity.this.m57932R().setVisibility(0);
            ImageActivity.this.m41529q0(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.question.ImageActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4718c extends HttpCallBack {
        C4718c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ImageActivity.this.finish();
        }
    }

    /* renamed from: l0 */
    private void m41534l0() {
        if (this.f17585m.size() == 0) {
            m57919h0("至少上传一张图片");
            return;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        for (String str : this.f17585m) {
            File file = new File(str);
            arrayList.add(file);
            String str2 = "";
            sb.append(sb.toString().isEmpty() ? "" : ",");
            sb.append(file.getName());
            if (!sb2.toString().isEmpty()) {
                str2 = ",";
            }
            sb2.append(str2);
            sb2.append(C1138b.m57768b(m41528r0(file.getPath())));
        }
        if (TextUtils.isEmpty(sb2)) {
            new iOSOneButtonDialog(this.f1669h).setMessage("请至少上传一张图片").show();
        } else {
            Http.with(this.f1669h).setTimeout(3L, TimeUnit.MINUTES).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41638d(RequestParameter.getRequestBody(this.f17591s), m41533m0("files", arrayList))).setDataListener(new C4718c());
        }
    }

    /* renamed from: n0 */
    private void m41532n0() {
        Http.with(this.f1669h).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41639c(this.f17591s, this.f17592t)).setDataListener(new C4717b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ Unit m41531o0(File file) {
        this.f17585m.add(file.getPath());
        this.f17586n.m57886c(this.f17585m);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0 */
    public /* synthetic */ void m41530p0(AdapterView adapterView, View view, int i, long j) {
        if (i == this.f17585m.size()) {
            ImageSelectUtils.f15123a.m43786p(this.f1670i, new InterfaceC15280l() { // from class: com.bxkj.student.home.teaching.learning.question.d
                @Override // p617l1.InterfaceC15280l
                public final Object invoke(Object obj) {
                    Unit m41531o0;
                    m41531o0 = ImageActivity.this.m41531o0((File) obj);
                    return m41531o0;
                }
            });
        } else {
            C3906m.m44067c(this.f1669h, this.f17585m, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public void m41529q0(Map<String, Object> data) {
        this.f17594v = JsonParse.getList(data, "questionsRecord");
        this.f17586n.m57884e(JsonParse.getInt(data, "pictureCount", 3));
        if (this.f17594v.isEmpty()) {
            this.f17590r.setVisibility(8);
            this.f17587o.setVisibility(8);
        } else {
            this.f17593u.m57842c(this.f17594v);
        }
        TextView textView = this.f17588p;
        textView.setText("(" + JsonParse.getString(data, "socre") + "分)");
        this.f17589q.setText(Html.fromHtml(JsonParse.getString(data, "questionName")));
    }

    /* renamed from: r0 */
    public static byte[] m41528r0(String filename) {
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
        this.f17583k.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.c
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                ImageActivity.this.m41530p0(adapterView, view, i, j);
            }
        });
        this.f17584l.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_learn_camera_question;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        m57932R().setVisibility(8);
        if (getIntent().hasExtra("questionId")) {
            this.f17591s = getIntent().getStringExtra("questionId");
        }
        if (getIntent().hasExtra("isQualified")) {
            this.f17592t = getIntent().getIntExtra("isQualified", 0);
        }
        int i = this.f17592t;
        if (i == 1) {
            this.f17584l.setText("已合格");
            this.f17583k.setVisibility(8);
            this.f17584l.setEnabled(false);
        } else if (i == 2) {
            this.f17584l.setText("待批改");
            this.f17583k.setVisibility(8);
            this.f17584l.setEnabled(false);
        }
        C4715a c4715a = new C4715a(this.f1669h, C4215R.C4221layout.item_for_learn_images_grid, this.f17594v);
        this.f17593u = c4715a;
        this.f17587o.setAdapter((ListAdapter) c4715a);
        List<String> list = this.f17585m;
        Context context = this.f1669h;
        GridViewAddImagesAdapter gridViewAddImagesAdapter = new GridViewAddImagesAdapter(list, context, 4, Tools.m57620a(10.0f, context));
        this.f17586n = gridViewAddImagesAdapter;
        gridViewAddImagesAdapter.m57884e(3);
        this.f17583k.setAdapter((ListAdapter) this.f17586n);
        m41532n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("开始答题-拍照");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17583k = (MyGridView) findViewById(2131231335);
        this.f17587o = (MyListView) findViewById(C4215R.C4219id.rv_answer);
        this.f17588p = (TextView) findViewById(2131233146);
        this.f17589q = (TextView) findViewById(C4215R.C4219id.tv_question);
        this.f17590r = (LinearLayout) findViewById(C4215R.C4219id.ll_history_answer);
        this.f17584l = (Button) findViewById(2131230967);
    }

    /* renamed from: m0 */
    public Map<String, RequestBody> m41533m0(String key, List<File> files) {
        ArrayMap arrayMap = new ArrayMap();
        for (int i = 0; i < files.size(); i++) {
            File file = files.get(i);
            RequestBody create = RequestBody.create(MediaType.parse("image/png"), file);
            arrayMap.put(key + "\"; filename=\"" + file.getName(), create);
        }
        return arrayMap;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        m41534l0();
    }
}
