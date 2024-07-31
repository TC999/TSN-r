package com.bxkj.student.home.teaching.homework.question;

import android.app.Dialog;
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
import com.bxkj.student.home.teaching.homework.HomeWorkApiService;
import com.bxkj.student.home.teaching.homework.question.ImageActivity;
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

    /* renamed from: B */
    private static final String f17005B = "temp_photo.jpg";

    /* renamed from: A */
    private List<Map<String, Object>> f17006A;

    /* renamed from: k */
    private MyGridView f17007k;

    /* renamed from: l */
    private Button f17008l;

    /* renamed from: m */
    private TextView f17009m;

    /* renamed from: o */
    private Dialog f17011o;

    /* renamed from: r */
    private File f17014r;

    /* renamed from: s */
    private GridViewAddImagesAdapter f17015s;

    /* renamed from: t */
    private MyListView f17016t;

    /* renamed from: u */
    private TextView f17017u;

    /* renamed from: v */
    private TextView f17018v;

    /* renamed from: w */
    private LinearLayout f17019w;

    /* renamed from: x */
    private String f17020x;

    /* renamed from: y */
    private int f17021y;

    /* renamed from: z */
    private CommonAdapter<Map<String, Object>> f17022z;

    /* renamed from: n */
    private List<String> f17010n = new ArrayList();

    /* renamed from: p */
    private final int f17012p = 170;

    /* renamed from: q */
    private final int f17013q = 187;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.homework.question.ImageActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4530a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.home.teaching.homework.question.ImageActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class C4531a extends CommonAdapter<String> {
            C4531a(Context context, int layoutId, List datas) {
                super(context, layoutId, datas);
            }

            @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
            /* renamed from: d */
            public void mo40086a(ViewHolder holder, String s) {
                holder.m57850t(C4215R.C4219id.iv_img, s, 2131165501, 2131165501);
            }
        }

        C4530a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: f */
        public /* synthetic */ void m42087f(String[] strArr, AdapterView adapterView, View view, int i, long j) {
            m42086g(strArr, i);
        }

        /* renamed from: g */
        private void m42086g(String[] arr, int index) {
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
            myGridView.setAdapter((ListAdapter) new C4531a(this.f1716a, C4215R.C4221layout.item_for_lost_img, Arrays.asList(split)));
            myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.e
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                    ImageActivity.C4530a.this.m42087f(split, adapterView, view, i, j);
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
    /* renamed from: com.bxkj.student.home.teaching.homework.question.ImageActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4532b extends HttpCallBack {
        C4532b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ImageActivity.this.m57932R().setVisibility(0);
            ImageActivity.this.m42091q0(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.homework.question.ImageActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4533c extends HttpCallBack {
        C4533c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ImageActivity.this.finish();
        }
    }

    /* renamed from: l0 */
    private void m42096l0() {
        if (this.f17010n.size() == 0) {
            m57919h0("至少上传一张图片");
            return;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        for (String str : this.f17010n) {
            File file = new File(str);
            arrayList.add(file);
            String str2 = "";
            sb.append(sb.toString().isEmpty() ? "" : ",");
            sb.append(file.getName());
            if (!sb2.toString().isEmpty()) {
                str2 = ",";
            }
            sb2.append(str2);
            sb2.append(C1138b.m57768b(m42090r0(file.getPath())));
        }
        if (TextUtils.isEmpty(sb2)) {
            new iOSOneButtonDialog(this.f1669h).setMessage("请至少上传一张图片").show();
        } else {
            Http.with(this.f1669h).setTimeout(3L, TimeUnit.MINUTES).setObservable(((HomeWorkApiService) Http.getApiService(HomeWorkApiService.class)).m42109d(RequestParameter.getRequestBody(this.f17020x), m42095m0("files", arrayList))).setDataListener(new C4533c());
        }
    }

    /* renamed from: n0 */
    private void m42094n0() {
        Http.with(this.f1669h).setObservable(((HomeWorkApiService) Http.getApiService(HomeWorkApiService.class)).m42110c(this.f17020x, this.f17021y)).setDataListener(new C4532b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ Unit m42093o0(File file) {
        this.f17010n.add(file.getPath());
        this.f17015s.m57886c(this.f17010n);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0 */
    public /* synthetic */ void m42092p0(AdapterView adapterView, View view, int i, long j) {
        if (i == this.f17010n.size()) {
            ImageSelectUtils.f15123a.m43786p(this.f1670i, new InterfaceC15280l() { // from class: com.bxkj.student.home.teaching.homework.question.d
                @Override // p617l1.InterfaceC15280l
                public final Object invoke(Object obj) {
                    Unit m42093o0;
                    m42093o0 = ImageActivity.this.m42093o0((File) obj);
                    return m42093o0;
                }
            });
        } else {
            C3906m.m44067c(this.f1669h, this.f17010n, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public void m42091q0(Map<String, Object> data) {
        boolean z = JsonParse.getBoolean(data, "isFlag");
        int i = this.f17021y;
        if (i == 1) {
            this.f17008l.setText("已合格");
            this.f17007k.setVisibility(8);
            this.f17008l.setEnabled(false);
        } else if (i == 2) {
            this.f17008l.setText("待批改");
            this.f17007k.setVisibility(8);
            this.f17008l.setEnabled(false);
        } else if (z) {
            this.f17008l.setText("提交");
            this.f17008l.setEnabled(true);
        } else {
            this.f17008l.setText("不合格");
            this.f17008l.setEnabled(false);
            this.f17007k.setVisibility(8);
            this.f17009m.setVisibility(0);
            this.f17009m.setText(JsonParse.getString(data, "markAnswer"));
        }
        this.f17006A = JsonParse.getList(data, "questionsRecord");
        this.f17015s.m57884e(JsonParse.getInt(data, "pictureCount", 3));
        if (this.f17006A.isEmpty()) {
            this.f17019w.setVisibility(8);
            this.f17016t.setVisibility(8);
        } else {
            this.f17022z.m57842c(this.f17006A);
        }
        TextView textView = this.f17017u;
        textView.setText("(" + JsonParse.getString(data, "socre") + "分)");
        this.f17018v.setText(Html.fromHtml(JsonParse.getString(data, "questionName")));
    }

    /* renamed from: r0 */
    public static byte[] m42090r0(String filename) {
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
        this.f17007k.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.c
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                ImageActivity.this.m42092p0(adapterView, view, i, j);
            }
        });
        this.f17008l.setOnClickListener(this);
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
            this.f17020x = getIntent().getStringExtra("questionId");
        }
        if (getIntent().hasExtra("isQualified")) {
            this.f17021y = getIntent().getIntExtra("isQualified", 0);
        }
        C4530a c4530a = new C4530a(this.f1669h, C4215R.C4221layout.item_for_learn_images_grid, this.f17006A);
        this.f17022z = c4530a;
        this.f17016t.setAdapter((ListAdapter) c4530a);
        List<String> list = this.f17010n;
        Context context = this.f1669h;
        GridViewAddImagesAdapter gridViewAddImagesAdapter = new GridViewAddImagesAdapter(list, context, 4, Tools.m57620a(10.0f, context));
        this.f17015s = gridViewAddImagesAdapter;
        gridViewAddImagesAdapter.m57884e(3);
        this.f17007k.setAdapter((ListAdapter) this.f17015s);
        m42094n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("课后作业开始答题-拍照");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17007k = (MyGridView) findViewById(2131231335);
        this.f17016t = (MyListView) findViewById(C4215R.C4219id.rv_answer);
        this.f17017u = (TextView) findViewById(2131233146);
        this.f17018v = (TextView) findViewById(C4215R.C4219id.tv_question);
        this.f17019w = (LinearLayout) findViewById(C4215R.C4219id.ll_history_answer);
        this.f17008l = (Button) findViewById(2131230967);
        this.f17009m = (TextView) findViewById(C4215R.C4219id.tv_right_answer);
    }

    /* renamed from: m0 */
    public Map<String, RequestBody> m42095m0(String key, List<File> files) {
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
        m42096l0();
    }
}
