package com.bxkj.base.chat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.HttpRequest;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.R;
import com.bxkj.base.chat.ReportChatActivity;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.z;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ReportChatActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b2\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0014J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0006\u0010\u000e\u001a\u00020\u0002R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R&\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010!\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u0012\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001bR\u0018\u0010%\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u001bR*\u0010)\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00063"}, d2 = {"Lcom/bxkj/base/chat/ReportChatActivity;", "Lcn/bluemobi/dylan/base/BaseActivity;", "Lkotlin/f1;", "p0", "Landroid/view/View;", "v", "onClick", "U", "", "P", "Landroid/os/Bundle;", "V", "T", "N", "o0", "Landroidx/recyclerview/widget/RecyclerView;", "k", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "", "", "", "l", "Ljava/util/List;", "datas", "m", "Ljava/lang/String;", "chatName", "n", "I", "getChatType$annotations", "()V", "chatType", "o", "groupId", "p", "toUserId", "Lcn/bluemobi/dylan/base/adapter/common/recyclerview/CommonAdapter;", CampaignEx.JSON_KEY_AD_Q, "Lcn/bluemobi/dylan/base/adapter/common/recyclerview/CommonAdapter;", "adapter", "Landroid/widget/EditText;", "r", "Landroid/widget/EditText;", "et_reply", "Landroid/widget/Button;", "s", "Landroid/widget/Button;", "bt_ok", "<init>", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class ReportChatActivity extends BaseActivity {
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private RecyclerView f18230k;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private String f18232m;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private String f18234o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    private String f18235p;
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f18236q;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    private EditText f18237r;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    private Button f18238s;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final List<Map<String, Object>> f18231l = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private int f18233n = 1;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ReportChatActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/base/chat/ReportChatActivity$a", "Lcn/bluemobi/dylan/http/HttpCallBack;", "", "", "", "data", "Lkotlin/f1;", "netOnSuccess", "base_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(@NotNull Map<String, ? extends Object> data) {
            f0.p(data, "data");
            ReportChatActivity.this.f18235p = JsonParse.getString(data, "userIds");
            List<Map<String, Object>> list = JsonParse.getList(JsonParse.getMap(data, "messages"), "data");
            CommonAdapter commonAdapter = ReportChatActivity.this.f18236q;
            if (commonAdapter == null) {
                return;
            }
            commonAdapter.g(list);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ReportChatActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/base/chat/ReportChatActivity$b", "Lcn/bluemobi/dylan/http/HttpCallBack;", "", "", "", "data", "Lkotlin/f1;", "netOnSuccess", "base_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class b extends HttpCallBack {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(ReportChatActivity this$0, View view) {
            f0.p(this$0, "this$0");
            this$0.finish();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(@NotNull Map<String, ? extends Object> data) {
            f0.p(data, "data");
            iOSOneButtonDialog message = new iOSOneButtonDialog(((BaseActivity) ReportChatActivity.this).f1656h).setMessage("\u4e3e\u62a5\u6210\u529f\uff0c\u7b49\u5f85\u540e\u5ba1\u6838\uff0c\u8bf7\u8010\u5fc3\u7b49\u5f85");
            final ReportChatActivity reportChatActivity = ReportChatActivity.this;
            message.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.chat.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReportChatActivity.b.b(ReportChatActivity.this, view);
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(ReportChatActivity this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.p0();
    }

    private static /* synthetic */ void n0() {
    }

    private final void p0() {
        List<Map<String, Object>> d4;
        EditText editText = this.f18237r;
        String valueOf = String.valueOf(editText == null ? null : editText.getText());
        int length = valueOf.length() - 1;
        int i4 = 0;
        boolean z3 = false;
        while (i4 <= length) {
            boolean z4 = f0.t(valueOf.charAt(!z3 ? i4 : length), 32) <= 0;
            if (z3) {
                if (!z4) {
                    break;
                }
                length--;
            } else if (z4) {
                i4++;
            } else {
                z3 = true;
            }
        }
        String obj = valueOf.subSequence(i4, length + 1).toString();
        if (obj.length() == 0) {
            h0("\u5185\u5bb9\u4e0d\u80fd\u4e3a\u7a7a");
            return;
        }
        String userId = LoginUser.getLoginUser().getUserId();
        if (!LoginUser.getLoginUser().isLogin()) {
            userId = LoginUser.getLoginUser().getTempUserId();
        }
        String str = userId;
        StringBuilder sb = new StringBuilder();
        CommonAdapter<Map<String, Object>> commonAdapter = this.f18236q;
        if (commonAdapter != null && (d4 = commonAdapter.d()) != null) {
            Iterator<T> it = d4.iterator();
            while (it.hasNext()) {
                Map<String, ? extends Object> map = (Map) it.next();
                com.bxkj.base.v2.common.utils.l lVar = com.bxkj.base.v2.common.utils.l.f18624a;
                lVar.d(map, "isChecked");
                sb.append(lVar.t(map, "userName"));
                sb.append(":");
                sb.append(lVar.t(map, "msg"));
            }
        }
        Http.with(this.f1656h).hideSuccessMessage().setObservable(((q.f) Http.getApiService(q.f.class)).t(LoginUser.getLoginUser().getSchoolId(), str, z.h(this.f1656h), "Android", "\u3010\u4e3e\u62a5\u804a\u5929\u3011" + ((Object) sb) + '\u3010' + obj + '\u3011', "a.jpg", LoginUser.getLoginUser().getRealName(), LoginUser.getLoginUser().getAccount(), this.f18233n == 1 ? this.f18235p : this.f18234o)).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        Button button = this.f18238s;
        if (button == null) {
            return;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.chat.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReportChatActivity.m0(ReportChatActivity.this, view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_report_chat;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("chatName")) {
            this.f18232m = getIntent().getStringExtra("chatName");
        }
        if (getIntent().hasExtra("chatType")) {
            this.f18233n = getIntent().getIntExtra("chatType", 1);
        }
        if (getIntent().hasExtra("groupId")) {
            this.f18234o = getIntent().getStringExtra("groupId");
        }
        if (getIntent().hasExtra("userId")) {
            this.f18235p = getIntent().getStringExtra("userId");
        }
        ReportChatActivity$initData$1 reportChatActivity$initData$1 = new ReportChatActivity$initData$1(this.f1656h, R.layout.item_for_report_message, this.f18231l);
        this.f18236q = reportChatActivity$initData$1;
        RecyclerView recyclerView = this.f18230k;
        if (recyclerView != null) {
            recyclerView.setAdapter(reportChatActivity$initData$1);
        }
        o0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u4e3e\u62a5\u8be5\u804a\u5929");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(@Nullable Bundle bundle) {
        View findViewById = findViewById(R.id.recyclerView);
        if (findViewById != null) {
            this.f18230k = (RecyclerView) findViewById;
            this.f18237r = (EditText) findViewById(R.id.et_reply);
            this.f18238s = (Button) findViewById(R.id.bt_ok);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
    }

    public final void o0() {
        HttpRequest hideLoadingDialog = Http.with(this.f1656h).hideLoadingDialog();
        q.a aVar = (q.a) Http.getApiService(q.a.class);
        int i4 = this.f18233n;
        hideLoadingDialog.setObservable(aVar.c(i4, i4 == 1 ? this.f18235p : null, i4 == 2 ? this.f18234o : null, 100, 1, null)).setDataListener(new a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
    }
}
