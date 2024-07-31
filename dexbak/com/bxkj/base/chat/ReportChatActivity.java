package com.bxkj.base.chat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.HttpRequest;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.C3801R;
import com.bxkj.base.chat.ReportChatActivity;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.SystemUtils;
import com.kuaishou.weapon.p205p0.C7202bq;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p635q.ChatApiService;
import p635q.MainApiService;

/* compiled from: ReportChatActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b2\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0014J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0006\u0010\u000e\u001a\u00020\u0002R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R&\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010!\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u0012\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001bR\u0018\u0010%\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001bR*\u0010)\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00063"}, m12616d2 = {"Lcom/bxkj/base/chat/ReportChatActivity;", "Lcn/bluemobi/dylan/base/BaseActivity;", "Lkotlin/f1;", C7202bq.f24604g, "Landroid/view/View;", "v", "onClick", "U", "", "P", "Landroid/os/Bundle;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.GPS_DIRECTION_TRUE, "N", "o0", "Landroidx/recyclerview/widget/RecyclerView;", "k", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "", "", "", C7304t.f25048d, "Ljava/util/List;", "datas", "m", "Ljava/lang/String;", "chatName", "n", "I", "getChatType$annotations", "()V", "chatType", "o", "groupId", "p", "toUserId", "Lcn/bluemobi/dylan/base/adapter/common/recyclerview/CommonAdapter;", CampaignEx.JSON_KEY_AD_Q, "Lcn/bluemobi/dylan/base/adapter/common/recyclerview/CommonAdapter;", "adapter", "Landroid/widget/EditText;", "r", "Landroid/widget/EditText;", "et_reply", "Landroid/widget/Button;", "s", "Landroid/widget/Button;", "bt_ok", "<init>", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ReportChatActivity extends BaseActivity {
    @Nullable

    /* renamed from: k */
    private RecyclerView f14744k;
    @Nullable

    /* renamed from: m */
    private String f14746m;
    @Nullable

    /* renamed from: o */
    private String f14748o;
    @Nullable

    /* renamed from: p */
    private String f14749p;
    @Nullable

    /* renamed from: q */
    private CommonAdapter<Map<String, Object>> f14750q;
    @Nullable

    /* renamed from: r */
    private EditText f14751r;
    @Nullable

    /* renamed from: s */
    private Button f14752s;
    @NotNull

    /* renamed from: l */
    private final List<Map<String, Object>> f14745l = new ArrayList();

    /* renamed from: n */
    private int f14747n = 1;

    /* compiled from: ReportChatActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/base/chat/ReportChatActivity$a", "Lcn/bluemobi/dylan/http/HttpCallBack;", "", "", "", "data", "Lkotlin/f1;", "netOnSuccess", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.chat.ReportChatActivity$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3846a extends HttpCallBack {
        C3846a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(@NotNull Map<String, ? extends Object> data) {
            C14342f0.m8184p(data, "data");
            ReportChatActivity.this.f14749p = JsonParse.getString(data, "userIds");
            List<Map<String, Object>> list = JsonParse.getList(JsonParse.getMap(data, "messages"), "data");
            CommonAdapter commonAdapter = ReportChatActivity.this.f14750q;
            if (commonAdapter == null) {
                return;
            }
            commonAdapter.m57836g(list);
        }
    }

    /* compiled from: ReportChatActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/base/chat/ReportChatActivity$b", "Lcn/bluemobi/dylan/http/HttpCallBack;", "", "", "", "data", "Lkotlin/f1;", "netOnSuccess", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.chat.ReportChatActivity$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3847b extends HttpCallBack {
        C3847b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public static final void m44227b(ReportChatActivity this$0, View view) {
            C14342f0.m8184p(this$0, "this$0");
            this$0.finish();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(@NotNull Map<String, ? extends Object> data) {
            C14342f0.m8184p(data, "data");
            iOSOneButtonDialog message = new iOSOneButtonDialog(((BaseActivity) ReportChatActivity.this).f1669h).setMessage("举报成功，等待后审核，请耐心等待");
            final ReportChatActivity reportChatActivity = ReportChatActivity.this;
            message.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.chat.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReportChatActivity.C3847b.m44227b(ReportChatActivity.this, view);
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public static final void m44235m0(ReportChatActivity this$0, View view) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.m44232p0();
    }

    /* renamed from: n0 */
    private static /* synthetic */ void m44234n0() {
    }

    /* renamed from: p0 */
    private final void m44232p0() {
        List<Map<String, Object>> m57837d;
        EditText editText = this.f14751r;
        String valueOf = String.valueOf(editText == null ? null : editText.getText());
        int length = valueOf.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = C14342f0.m8180t(valueOf.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String obj = valueOf.subSequence(i, length + 1).toString();
        if (obj.length() == 0) {
            m57919h0("内容不能为空");
            return;
        }
        String userId = LoginUser.getLoginUser().getUserId();
        if (!LoginUser.getLoginUser().isLogin()) {
            userId = LoginUser.getLoginUser().getTempUserId();
        }
        String str = userId;
        StringBuilder sb = new StringBuilder();
        CommonAdapter<Map<String, Object>> commonAdapter = this.f14750q;
        if (commonAdapter != null && (m57837d = commonAdapter.m57837d()) != null) {
            Iterator<T> it = m57837d.iterator();
            while (it.hasNext()) {
                Map<String, ? extends Object> map = (Map) it.next();
                JsonGet jsonGet = JsonGet.f15134a;
                jsonGet.m43776d(map, "isChecked");
                sb.append(jsonGet.m43760t(map, "userName"));
                sb.append(":");
                sb.append(jsonGet.m43760t(map, "msg"));
            }
        }
        Http.with(this.f1669h).hideSuccessMessage().setObservable(((MainApiService) Http.getApiService(MainApiService.class)).m2257t(LoginUser.getLoginUser().getSchoolId(), str, SystemUtils.m43998h(this.f1669h), "Android", "【举报聊天】" + ((Object) sb) + (char) 12304 + obj + (char) 12305, "a.jpg", LoginUser.getLoginUser().getRealName(), LoginUser.getLoginUser().getAccount(), this.f14747n == 1 ? this.f14749p : this.f14748o)).setDataListener(new C3847b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        Button button = this.f14752s;
        if (button == null) {
            return;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.chat.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReportChatActivity.m44235m0(ReportChatActivity.this, view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C3801R.C3807layout.ac_report_chat;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("chatName")) {
            this.f14746m = getIntent().getStringExtra("chatName");
        }
        if (getIntent().hasExtra("chatType")) {
            this.f14747n = getIntent().getIntExtra("chatType", 1);
        }
        if (getIntent().hasExtra("groupId")) {
            this.f14748o = getIntent().getStringExtra("groupId");
        }
        if (getIntent().hasExtra("userId")) {
            this.f14749p = getIntent().getStringExtra("userId");
        }
        ReportChatActivity$initData$1 reportChatActivity$initData$1 = new ReportChatActivity$initData$1(this.f1669h, C3801R.C3807layout.item_for_report_message, this.f14745l);
        this.f14750q = reportChatActivity$initData$1;
        RecyclerView recyclerView = this.f14744k;
        if (recyclerView != null) {
            recyclerView.setAdapter(reportChatActivity$initData$1);
        }
        m44233o0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("举报该聊天");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(@Nullable Bundle bundle) {
        View findViewById = findViewById(C3801R.C3805id.recyclerView);
        if (findViewById != null) {
            this.f14744k = (RecyclerView) findViewById;
            this.f14751r = (EditText) findViewById(C3801R.C3805id.et_reply);
            this.f14752s = (Button) findViewById(C3801R.C3805id.bt_ok);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
    }

    /* renamed from: o0 */
    public final void m44233o0() {
        HttpRequest hideLoadingDialog = Http.with(this.f1669h).hideLoadingDialog();
        ChatApiService chatApiService = (ChatApiService) Http.getApiService(ChatApiService.class);
        int i = this.f14747n;
        hideLoadingDialog.setObservable(chatApiService.m2316c(i, i == 1 ? this.f14749p : null, i == 2 ? this.f14748o : null, 100, 1, null)).setDataListener(new C3846a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
    }
}
