package com.bxkj.student.home.teaching.learning.detail;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.p085v2.common.ext.PermissionExt;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.exam.FaceDetectExamActivity;
import com.bxkj.student.home.teaching.learning.LearningApiService;
import com.bxkj.student.home.teaching.learning.question.list.QuestionListActivity;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.BaseMediaObject;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import java.util.Map;
import kotlin.Unit;
import p617l1.InterfaceC15269a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BottomFragment extends BaseFragment {

    /* renamed from: A */
    private int f17258A;

    /* renamed from: B */
    private int f17259B;

    /* renamed from: C */
    private int f17260C;

    /* renamed from: D */
    private int f17261D;

    /* renamed from: E */
    private C4655k f17262E;

    /* renamed from: h */
    private Button f17263h;

    /* renamed from: i */
    private LinearLayout f17264i;

    /* renamed from: j */
    private TextView f17265j;

    /* renamed from: k */
    private TextView f17266k;

    /* renamed from: l */
    private TextView f17267l;

    /* renamed from: m */
    private TextView f17268m;

    /* renamed from: n */
    private TextView f17269n;

    /* renamed from: o */
    private TextView f17270o;

    /* renamed from: p */
    private BaseMediaObject f17271p;

    /* renamed from: q */
    private ShareAction f17272q;

    /* renamed from: r */
    private UMShareListener f17273r;

    /* renamed from: s */
    private String f17274s;

    /* renamed from: t */
    private String f17275t;

    /* renamed from: u */
    private int f17276u;

    /* renamed from: v */
    private int f17277v;

    /* renamed from: w */
    private int f17278w;

    /* renamed from: x */
    private int f17279x;

    /* renamed from: y */
    private int f17280y;

    /* renamed from: z */
    private int f17281z;

    /* renamed from: com.bxkj.student.home.teaching.learning.detail.BottomFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4611a implements UMShareListener {

        /* renamed from: com.bxkj.student.home.teaching.learning.detail.BottomFragment$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C4612a extends HttpCallBack {
            C4612a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
            }
        }

        C4611a() {
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(((BaseFragment) BottomFragment.this).f1678e, " 分享取消了", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onError(SHARE_MEDIA platform, Throwable t) {
            t.printStackTrace();
            Context context = ((BaseFragment) BottomFragment.this).f1678e;
            Toast.makeText(context, " 分享失败啦," + t.getMessage(), 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onResult(SHARE_MEDIA platform) {
            Http.with(((BaseFragment) BottomFragment.this).f1678e).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41622t(BottomFragment.this.f17275t, "3", 1)).setDataListener(new C4612a());
            Toast.makeText(((BaseFragment) BottomFragment.this).f1678e, " 分享成功啦", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onStart(SHARE_MEDIA share_media) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.detail.BottomFragment$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4613b extends HttpCallBack {
        C4613b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            BottomFragment bottomFragment = BottomFragment.this;
            bottomFragment.f17276u = bottomFragment.f17276u == 0 ? 1 : 0;
            BottomFragment.this.m41840t0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.detail.BottomFragment$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4614c extends HttpCallBack {
        C4614c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            BottomFragment bottomFragment = BottomFragment.this;
            bottomFragment.f17277v = bottomFragment.f17277v == 0 ? 1 : 0;
            BottomFragment.this.m41845o0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g0 */
    public /* synthetic */ void m41853g0(View view) {
        m41837w0(SHARE_MEDIA.WEIXIN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h0 */
    public /* synthetic */ void m41852h0(View view) {
        m41837w0(SHARE_MEDIA.WEIXIN_CIRCLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0 */
    public /* synthetic */ void m41851i0(View view) {
        m41837w0(SHARE_MEDIA.QQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j0 */
    public /* synthetic */ void m41850j0(View view) {
        m41837w0(SHARE_MEDIA.QZONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0 */
    public /* synthetic */ void m41849k0(View view) {
        Http.with(this.f1678e).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41622t(this.f17275t, "1", this.f17276u == 0 ? 1 : 0)).setDataListener(new C4613b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l0 */
    public /* synthetic */ void m41848l0(View view) {
        Http.with(this.f1678e).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41622t(this.f17275t, "2", this.f17277v == 0 ? 1 : 0)).setDataListener(new C4614c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public /* synthetic */ void m41847m0(View view) {
        startActivity(new Intent(this.f1678e, QuestionListActivity.class).putExtra("type", 1).putExtra("resourceId", this.f17274s));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0 */
    public /* synthetic */ Unit m41846n0(Intent intent, int i) {
        startActivityForResult(intent.setClass(this.f1678e, FaceDetectExamActivity.class), i);
        this.f1679f.overridePendingTransition(2130771987, 2130771986);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public void m41845o0() {
        if (this.f17277v == 1) {
            m41844p0();
        } else {
            m41843q0();
        }
    }

    /* renamed from: p0 */
    private void m41844p0() {
        Drawable drawable = getResources().getDrawable(C4215R.mipmap.goods_collection_star_red);
        drawable.setBounds(0, 0, Tools.m57620a(21.0f, this.f1678e), Tools.m57620a(21.0f, this.f1678e));
        this.f17266k.setCompoundDrawables(null, drawable, null, null);
        this.f17266k.setText("已收藏");
    }

    /* renamed from: q0 */
    private void m41843q0() {
        Drawable drawable = getResources().getDrawable(C4215R.mipmap.empty_star);
        drawable.setBounds(0, 0, Tools.m57620a(21.0f, this.f1678e), Tools.m57620a(21.0f, this.f1678e));
        this.f17266k.setCompoundDrawables(null, drawable, null, null);
        this.f17266k.setText("收藏");
    }

    /* renamed from: r0 */
    private void m41842r0() {
        Drawable drawable = getResources().getDrawable(C4215R.mipmap.zan_focus);
        drawable.setBounds(0, 0, Tools.m57620a(21.0f, this.f1678e), Tools.m57620a(21.0f, this.f1678e));
        this.f17265j.setCompoundDrawables(null, drawable, null, null);
        this.f17265j.setText("已点赞");
    }

    /* renamed from: s0 */
    private void m41841s0() {
        Drawable drawable = getResources().getDrawable(C4215R.mipmap.zan_normal);
        drawable.setBounds(0, 0, Tools.m57620a(21.0f, this.f1678e), Tools.m57620a(21.0f, this.f1678e));
        this.f17265j.setCompoundDrawables(null, drawable, null, null);
        this.f17265j.setText("点赞");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public void m41840t0() {
        if (this.f17276u == 1) {
            m41842r0();
        } else {
            m41841s0();
        }
    }

    /* renamed from: w0 */
    private void m41837w0(SHARE_MEDIA platform) {
        this.f17272q.setPlatform(platform);
        this.f17272q.setCallback(this.f17273r);
        BaseMediaObject baseMediaObject = this.f17271p;
        if (baseMediaObject instanceof UMVideo) {
            this.f17272q.withMedia((UMVideo) baseMediaObject);
        } else if (baseMediaObject instanceof UMWeb) {
            this.f17272q.withMedia((UMWeb) baseMediaObject);
        }
        this.f17272q.share();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: b */
    public void mo39445b() {
        this.f17273r = new C4611a();
        this.f17267l.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.m41853g0(view);
            }
        });
        this.f17268m.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.m41852h0(view);
            }
        });
        this.f17269n.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.m41851i0(view);
            }
        });
        this.f17270o.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.m41850j0(view);
            }
        });
        this.f17265j.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.m41849k0(view);
            }
        });
        this.f17266k.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.m41848l0(view);
            }
        });
        this.f17263h.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.m41847m0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: e */
    protected void mo39444e() {
        Bundle arguments = getArguments();
        if (arguments.containsKey("id")) {
            this.f17274s = arguments.getString("id");
        }
        if (arguments.containsKey("detailId")) {
            this.f17275t = arguments.getString("detailId");
        }
        if (arguments.containsKey("isLike")) {
            this.f17276u = arguments.getInt("isLike", 0);
        }
        if (arguments.containsKey("isCollection")) {
            this.f17277v = arguments.getInt("isCollection", 0);
        }
        if (arguments.containsKey("duration")) {
            this.f17278w = arguments.getInt("duration", 0);
        }
        if (arguments.containsKey("popTime")) {
            this.f17279x = arguments.getInt("popTime", 0);
        }
        if (arguments.containsKey("hasQuestion")) {
            this.f17280y = arguments.getInt("hasQuestion", 0);
        }
        if (arguments.containsKey("isComplete")) {
            this.f17281z = arguments.getInt("isComplete", 0);
        }
        if (arguments.containsKey("isOk")) {
            this.f17258A = arguments.getInt("isOk", 0);
        }
        if (arguments.containsKey("opreateFlag")) {
            this.f17259B = arguments.getInt("opreateFlag", 0);
        }
        if (arguments.containsKey("valType")) {
            this.f17260C = arguments.getInt("valType", 1);
        }
        if (arguments.containsKey("integral")) {
            this.f17261D = arguments.getInt("integral", 1);
        }
        m41840t0();
        m41845o0();
        this.f17272q = new ShareAction(getActivity());
        int i = this.f17259B;
        if (i == 0) {
            this.f17262E = new C4655k(this, this.f1678e, this.f17278w, this.f17279x, this.f17274s, this.f17275t, this.f17263h, this.f17280y, this.f17260C, this.f17261D);
            if (this.f17278w == 0) {
                this.f17263h.setVisibility(8);
            } else {
                ((LearnDetailActivity) getActivity()).m41822w0(true);
                this.f17262E.m41699T();
            }
            this.f17263h.setEnabled(false);
        } else if (i == 1) {
            this.f17263h.setText("已完成");
            this.f17263h.setEnabled(false);
        } else if (i == 2) {
            this.f17263h.setText("开始答题");
            this.f17263h.setEnabled(true);
        } else if (i == 3) {
            this.f17263h.setText("查看答题");
            this.f17263h.setEnabled(true);
        } else {
            this.f17263h.setVisibility(8);
            this.f17263h.setEnabled(false);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: f */
    protected void mo39443f(View view) {
        this.f17263h = (Button) m57916c(C4215R.C4219id.bt_question);
        this.f17264i = (LinearLayout) m57916c(2131232167);
        this.f17265j = (TextView) m57916c(C4215R.C4219id.tv_zan);
        this.f17266k = (TextView) m57916c(C4215R.C4219id.tv_collect);
        this.f17267l = (TextView) m57916c(C4215R.C4219id.tv_wechat);
        this.f17268m = (TextView) m57916c(C4215R.C4219id.tv_moments);
        this.f17269n = (TextView) m57916c(C4215R.C4219id.tv_qq);
        this.f17270o = (TextView) m57916c(C4215R.C4219id.tv_qzone);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: i */
    protected int mo39442i() {
        return C4215R.C4221layout.fm_bottom;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(final int requestCode, int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 170 && resultCode == 187) {
            C4655k c4655k = this.f17262E;
            if (c4655k != null) {
                c4655k.m41715D();
            }
            new iOSOneButtonDialog(this.f1678e).setMessage("人脸识别成功，请继续学习").show();
        } else if (requestCode == 170 && resultCode == 170) {
            PermissionExt.m43841c((FragmentActivity) this.f1678e, "人脸识别", new InterfaceC15269a() { // from class: com.bxkj.student.home.teaching.learning.detail.u
                @Override // p617l1.InterfaceC15269a
                public final Object invoke() {
                    Unit m41846n0;
                    m41846n0 = BottomFragment.this.m41846n0(data, requestCode);
                    return m41846n0;
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        C4655k c4655k = this.f17262E;
        if (c4655k != null) {
            c4655k.m41698U();
        }
        C4655k c4655k2 = this.f17262E;
        if (c4655k2 != null) {
            c4655k2.m41702Q();
        }
        super.onDestroy();
    }

    /* renamed from: u0 */
    public void m41839u0(boolean b) {
        C4655k c4655k = this.f17262E;
        if (c4655k != null) {
            c4655k.m41701R(b);
        }
    }

    /* renamed from: v0 */
    public void m41838v0(BaseMediaObject baseMediaObject) {
        this.f17271p = baseMediaObject;
    }
}
