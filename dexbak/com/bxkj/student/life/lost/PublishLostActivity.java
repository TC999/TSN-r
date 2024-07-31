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
import com.p518qq.p519e.comm.adevent.AdEventType;
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

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PublishLostActivity extends BaseActivity {

    /* renamed from: A */
    private GridViewAddImagesAdapter f18131A;

    /* renamed from: B */
    private CommonAdapter<Map<String, Object>> f18132B;

    /* renamed from: E */
    private cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter<Map<String, Object>> f18135E;

    /* renamed from: k */
    private EditText f18136k;

    /* renamed from: l */
    private EditText f18137l;

    /* renamed from: m */
    private EditText f18138m;

    /* renamed from: n */
    private EditText f18139n;

    /* renamed from: o */
    private EditText f18140o;

    /* renamed from: p */
    private Button f18141p;

    /* renamed from: q */
    private CheckBox f18142q;

    /* renamed from: r */
    private CardView f18143r;

    /* renamed from: s */
    private LinearLayout f18144s;

    /* renamed from: t */
    private RecyclerView f18145t;

    /* renamed from: u */
    private RadioGroup f18146u;

    /* renamed from: v */
    private int f18147v;

    /* renamed from: w */
    private Spinner f18148w;

    /* renamed from: x */
    private MyGridView f18149x;

    /* renamed from: y */
    private List<String> f18150y = new ArrayList();

    /* renamed from: z */
    private final int f18151z = AdEventType.VIDEO_PAUSE;

    /* renamed from: C */
    private List<Map<String, Object>> f18133C = new ArrayList();

    /* renamed from: D */
    private List<Map<String, Object>> f18134D = new ArrayList();

    /* renamed from: com.bxkj.student.life.lost.PublishLostActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4919a extends CommonAdapter<Map<String, Object>> {
        C4919a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
        /* renamed from: d */
        public void mo40086a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "name"));
        }
    }

    /* renamed from: com.bxkj.student.life.lost.PublishLostActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4920b extends cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.life.lost.PublishLostActivity$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4921a implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f18154a;

            /* renamed from: b */
            final /* synthetic */ ViewHolder f18155b;

            View$OnClickListenerC4921a(final Map val$stringObjectMap, final ViewHolder val$holder) {
                this.f18154a = val$stringObjectMap;
                this.f18155b = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PublishLostActivity.this.f18134D.remove(this.f18154a);
                C4920b.this.notifyItemRemoved(this.f18155b.m57864f());
            }
        }

        C4920b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(C4215R.C4219id.tv_question, JsonParse.getString(stringObjectMap, "question"));
            holder.m57874J(C4215R.C4219id.tv_answer, JsonParse.getString(stringObjectMap, "answer"));
            holder.m57847w(2131230970, new View$OnClickListenerC4921a(stringObjectMap, holder));
        }
    }

    /* renamed from: com.bxkj.student.life.lost.PublishLostActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4922c implements CompoundButton.OnCheckedChangeListener {
        C4922c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            PublishLostActivity.this.f18143r.setVisibility(isChecked ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.lost.PublishLostActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4923d extends HttpCallBack {
        C4923d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            PublishLostActivity.this.f18133C = JsonParse.getList(data, "data");
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("name", "请选择物品类型");
            PublishLostActivity.this.f18133C.add(0, arrayMap);
            PublishLostActivity.this.f18132B.m57842c(PublishLostActivity.this.f18133C);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.lost.PublishLostActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4924e extends HttpCallBack {
        C4924e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            PublishLostActivity.this.finish();
        }
    }

    /* renamed from: p0 */
    private void m41021p0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((LostApiService) Http.getApiService(LostApiService.class)).m2284d()).setDataListener(new C4923d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public /* synthetic */ Unit m41020q0(File file) {
        this.f18150y.add(file.getPath());
        this.f18131A.m57886c(this.f18150y);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0 */
    public /* synthetic */ void m41019r0(AdapterView adapterView, View view, int i, long j) {
        ImageSelectUtils.f15123a.m43786p(this.f1670i, new InterfaceC15280l() { // from class: com.bxkj.student.life.lost.b
            @Override // p617l1.InterfaceC15280l
            public final Object invoke(Object obj) {
                Unit m41020q0;
                m41020q0 = PublishLostActivity.this.m41020q0((File) obj);
                return m41020q0;
            }
        });
    }

    /* renamed from: s0 */
    private void m41018s0() {
        String str;
        int i;
        if (this.f18148w.getSelectedItemPosition() != -1 && this.f18148w.getSelectedItemPosition() != 0) {
            String string = JsonParse.getString(this.f18132B.getItem(this.f18148w.getSelectedItemPosition()), "id");
            String trim = this.f18136k.getText().toString().trim();
            if (TextUtils.isEmpty(trim)) {
                m57919h0("请简单描述一下哦");
                return;
            }
            String trim2 = this.f18137l.getText().toString().trim();
            String trim3 = this.f18138m.getText().toString().trim();
            String trim4 = this.f18139n.getText().toString().trim();
            String trim5 = this.f18140o.getText().toString().trim();
            if (TextUtils.isEmpty(trim3) && TextUtils.isEmpty(trim4) && TextUtils.isEmpty(trim5)) {
                m57919h0("至少填写一种联系方式哦");
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (String str2 : this.f18150y) {
                File file = new File(str2);
                String m57768b = C1138b.m57768b(m41017t0(file.getPath()));
                arrayList2.add(m57768b);
                HashMap hashMap = new HashMap(2);
                hashMap.put("imageName", file.getName());
                hashMap.put("imageBase64", m57768b);
                arrayList.add(hashMap);
            }
            String jSONString = JSON.toJSONString(arrayList2);
            if (this.f18147v != 0 || !this.f18142q.isChecked()) {
                str = "0";
            } else if (this.f18134D.size() == 0) {
                m57919h0("至少添加一个问题和答案");
                return;
            } else {
                str = "1";
            }
            String str3 = str;
            if (this.f18146u.getCheckedRadioButtonId() != this.f18146u.getChildAt(0).getId()) {
                if (this.f18146u.getCheckedRadioButtonId() == this.f18146u.getChildAt(1).getId()) {
                    i = 2;
                } else if (this.f18146u.getCheckedRadioButtonId() == this.f18146u.getChildAt(2).getId()) {
                    i = 1;
                }
                Http.with(this.f1669h).setObservable(((LostApiService) Http.getApiService(LostApiService.class)).m2283e(LoginUser.getLoginUser().getOpenId(), string, this.f18147v, trim, jSONString, trim3, trim5, trim4, trim2, str3, i, JSON.toJSONString(this.f18134D))).setDataListener(new C4924e());
                return;
            }
            i = 3;
            Http.with(this.f1669h).setObservable(((LostApiService) Http.getApiService(LostApiService.class)).m2283e(LoginUser.getLoginUser().getOpenId(), string, this.f18147v, trim, jSONString, trim3, trim5, trim4, trim2, str3, i, JSON.toJSONString(this.f18134D))).setDataListener(new C4924e());
            return;
        }
        m57919h0("请选择物品类型");
    }

    /* renamed from: t0 */
    public static byte[] m41017t0(String filename) {
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
        this.f18141p.setOnClickListener(this);
        this.f18144s.setOnClickListener(this);
        this.f18149x.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.life.lost.a
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                PublishLostActivity.this.m41019r0(adapterView, view, i, j);
            }
        });
        this.f18142q.setOnCheckedChangeListener(new C4922c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_publish_lost;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("type")) {
            int intExtra = getIntent().getIntExtra("type", 1);
            this.f18147v = intExtra;
            if (intExtra == 1) {
                setTitle("发布寻物启示");
                this.f18142q.setVisibility(8);
            } else {
                setTitle("发布失物招领");
            }
        }
        List<String> list = this.f18150y;
        Context context = this.f1669h;
        GridViewAddImagesAdapter gridViewAddImagesAdapter = new GridViewAddImagesAdapter(list, context, 4, Tools.m57620a(10.0f, context));
        this.f18131A = gridViewAddImagesAdapter;
        gridViewAddImagesAdapter.m57884e(3);
        this.f18149x.setAdapter((ListAdapter) this.f18131A);
        C4919a c4919a = new C4919a(this.f1669h, 2131427755, this.f18133C);
        this.f18132B = c4919a;
        this.f18148w.setAdapter((SpinnerAdapter) c4919a);
        m41021p0();
        this.f18145t.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C4920b c4920b = new C4920b(this.f1669h, C4215R.C4221layout.item_for_question, this.f18134D);
        this.f18135E = c4920b;
        this.f18145t.setAdapter(c4920b);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("发布寻物启事");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18149x = (MyGridView) findViewById(2131231335);
        this.f18148w = (Spinner) findViewById(2131232642);
        this.f18136k = (EditText) findViewById(C4215R.C4219id.et_desc);
        this.f18149x = (MyGridView) findViewById(2131231335);
        this.f18137l = (EditText) findViewById(C4215R.C4219id.et_price);
        this.f18138m = (EditText) findViewById(2131231266);
        this.f18139n = (EditText) findViewById(C4215R.C4219id.et_wechat);
        this.f18140o = (EditText) findViewById(C4215R.C4219id.et_qq);
        this.f18141p = (Button) findViewById(C4215R.C4219id.bt_publish);
        this.f18142q = (CheckBox) findViewById(C4215R.C4219id.cb_show_question);
        this.f18143r = (CardView) findViewById(C4215R.C4219id.cardView_question);
        this.f18144s = (LinearLayout) findViewById(C4215R.C4219id.ll_add);
        this.f18145t = (RecyclerView) findViewById(C4215R.C4219id.rv_question_answer);
        this.f18146u = (RadioGroup) findViewById(C4215R.C4219id.rg_count);
        this.f18143r.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        if (id == 2131230995) {
            m41018s0();
        } else if (id != 2131232164) {
        } else {
            if (this.f18135E.getItemCount() < 3) {
                startActivityForResult(new Intent(this.f1669h, AddQuestionActivity.class), AdEventType.VIDEO_PAUSE);
            } else {
                m57919h0("最多三个问题哦！");
            }
        }
    }
}
