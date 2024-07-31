package com.bxkj.student.home.physicaltest.apply;

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
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.GridViewAddImagesAdapter;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
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
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import p617l1.InterfaceC15280l;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ApplyScoreDoubtActivity extends BaseActivity {

    /* renamed from: k */
    private EditText f16379k;

    /* renamed from: l */
    private EditText f16380l;

    /* renamed from: m */
    private EditText f16381m;

    /* renamed from: n */
    private TextView f16382n;

    /* renamed from: o */
    private EditText f16383o;

    /* renamed from: p */
    private EditText f16384p;

    /* renamed from: q */
    private MyGridView f16385q;

    /* renamed from: r */
    private Button f16386r;

    /* renamed from: t */
    private GridViewAddImagesAdapter f16388t;

    /* renamed from: u */
    private Spinner f16389u;

    /* renamed from: v */
    private CommonAdapter<Map<String, Object>> f16390v;

    /* renamed from: x */
    private String f16392x;

    /* renamed from: s */
    private List<String> f16387s = new ArrayList();

    /* renamed from: w */
    private List<Map<String, Object>> f16391w = new ArrayList();

    /* renamed from: com.bxkj.student.home.physicaltest.apply.ApplyScoreDoubtActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4330a extends CommonAdapter<Map<String, Object>> {
        C4330a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
        /* renamed from: d */
        public void mo40086a(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(2131232981, JsonParse.getString(stringObjectMap, "examName"));
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "actualScore") + JsonParse.getString(stringObjectMap, "examunit"));
            holder.m57874J(2131233146, JsonParse.getString(stringObjectMap, "score") + "分");
            holder.m57874J(2131233116, JsonParse.getString(stringObjectMap, "rank"));
            holder.m57862h(2131233169).setVisibility(4);
            holder.m57870N(2131231389, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.physicaltest.apply.ApplyScoreDoubtActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4331b extends HttpCallBack {
        C4331b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) ApplyScoreDoubtActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyScoreDoubtActivity.this.m57932R().setVisibility(0);
            ApplyScoreDoubtActivity.this.f16391w = (List) data.get("data");
            ApplyScoreDoubtActivity.this.f16390v.m57842c(ApplyScoreDoubtActivity.this.f16391w);
        }
    }

    /* renamed from: com.bxkj.student.home.physicaltest.apply.ApplyScoreDoubtActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4332c implements AdapterView.OnItemSelectedListener {
        C4332c() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String string = JsonParse.getString((Map) ApplyScoreDoubtActivity.this.f16390v.getItem(position), "examName");
            String string2 = JsonParse.getString((Map) ApplyScoreDoubtActivity.this.f16390v.getItem(position), "examunit");
            if (string.contains("身高") && string.contains("体重")) {
                ((View) ApplyScoreDoubtActivity.this.f16380l.getParent()).setVisibility(0);
                ((View) ApplyScoreDoubtActivity.this.f16381m.getParent()).setVisibility(0);
                ((View) ApplyScoreDoubtActivity.this.f16379k.getParent()).setVisibility(8);
                return;
            }
            ((View) ApplyScoreDoubtActivity.this.f16380l.getParent()).setVisibility(8);
            ((View) ApplyScoreDoubtActivity.this.f16381m.getParent()).setVisibility(8);
            ((View) ApplyScoreDoubtActivity.this.f16379k.getParent()).setVisibility(0);
            ApplyScoreDoubtActivity.this.f16382n.setText(string2);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.physicaltest.apply.ApplyScoreDoubtActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4333d extends HttpCallBack {
        C4333d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyScoreDoubtActivity.this.m57919h0("申请成功");
            ScoreDoubtActivity scoreDoubtActivity = (ScoreDoubtActivity) AppManager.m57776n().getActivity(ScoreDoubtActivity.class);
            if (scoreDoubtActivity != null) {
                scoreDoubtActivity.m42639n0();
            }
            ApplyScoreDoubtActivity.this.finish();
        }
    }

    /* renamed from: s0 */
    private void m42660s0() {
        String str;
        String trim = this.f16383o.getText().toString().trim();
        String trim2 = this.f16384p.getText().toString().trim();
        if (trim.isEmpty()) {
            m57919h0("申请理由不能为空");
        } else if (TextUtils.isEmpty(trim2)) {
            m57919h0("联系电话不能为空");
        } else {
            String string = JsonParse.getString(this.f16390v.getItem(this.f16389u.getSelectedItemPosition()), "examName");
            String string2 = JsonParse.getString(this.f16390v.getItem(this.f16389u.getSelectedItemPosition()), "actualScore");
            String trim3 = this.f16379k.getText().toString().trim();
            if (string.contains("身高") && string.contains("体重")) {
                str = this.f16380l.getText().toString().trim() + "/" + this.f16381m.getText().toString().trim();
            } else {
                str = trim3;
            }
            Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m143T(LoginUser.getLoginUser().getUserId(), this.f16392x, JsonParse.getString(this.f16390v.getItem(this.f16389u.getSelectedItemPosition()), "examid"), string2, str, trim2, trim)).setDataListener(new C4333d());
        }
    }

    /* renamed from: t0 */
    private void m42659t0() {
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m65v0(this.f16392x)).setDataListener(new C4331b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public /* synthetic */ Unit m42658u0(File file) {
        this.f16387s.add(file.getPath());
        this.f16388t.m57886c(this.f16387s);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public /* synthetic */ void m42657v0(AdapterView adapterView, View view, int i, long j) {
        ImageSelectUtils.f15123a.m43786p(this.f1670i, new InterfaceC15280l() { // from class: com.bxkj.student.home.physicaltest.apply.b
            @Override // p617l1.InterfaceC15280l
            public final Object invoke(Object obj) {
                Unit m42658u0;
                m42658u0 = ApplyScoreDoubtActivity.this.m42658u0((File) obj);
                return m42658u0;
            }
        });
    }

    /* renamed from: w0 */
    public static byte[] m42656w0(String filename) {
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
        this.f16389u.setOnItemSelectedListener(new C4332c());
        this.f16385q.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.physicaltest.apply.a
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                ApplyScoreDoubtActivity.this.m42657v0(adapterView, view, i, j);
            }
        });
        this.f16386r.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_apply_test_score;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("meaScoreId")) {
            this.f16392x = getIntent().getStringExtra("meaScoreId");
        }
        List<String> list = this.f16387s;
        Context context = this.f1669h;
        GridViewAddImagesAdapter gridViewAddImagesAdapter = new GridViewAddImagesAdapter(list, context, 4, Tools.m57620a(10.0f, context));
        this.f16388t = gridViewAddImagesAdapter;
        gridViewAddImagesAdapter.m57884e(3);
        this.f16385q.setAdapter((ListAdapter) this.f16388t);
        C4330a c4330a = new C4330a(this.f1669h, C4215R.C4221layout.item_for_apply_test_score, this.f16391w);
        this.f16390v = c4330a;
        this.f16389u.setAdapter((SpinnerAdapter) c4330a);
        m57932R().setVisibility(4);
        m42659t0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("体测成绩申诉");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16379k = (EditText) findViewById(C4215R.C4219id.et_score);
        this.f16380l = (EditText) findViewById(C4215R.C4219id.et_height);
        this.f16381m = (EditText) findViewById(C4215R.C4219id.et_weight);
        this.f16382n = (TextView) findViewById(C4215R.C4219id.tv_unit);
        this.f16383o = (EditText) findViewById(2131231256);
        this.f16384p = (EditText) findViewById(2131231266);
        this.f16385q = (MyGridView) findViewById(2131231335);
        this.f16386r = (Button) findViewById(2131230967);
        this.f16389u = (Spinner) findViewById(2131232642);
        this.f16385q.setVisibility(8);
        this.f16389u.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        m42660s0();
    }
}
