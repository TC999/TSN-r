package com.bxkj.place.apply;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.place.R;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ApplyIntroductionActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TextView f19277k;

    /* renamed from: l  reason: collision with root package name */
    private int f19278l;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyIntroductionActivity.this.f19277k.setText(JsonParse.getString(data, "data"));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_place_apply_description;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        Http.with(this.f1656h).setObservable(((v.b) Http.getApiService(v.b.class)).h(this.f19278l)).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        if (getIntent().hasExtra("appointType")) {
            this.f19278l = getIntent().getIntExtra("appointType", 1);
        }
        setTitle(this.f19278l == 2 ? "\u7533\u8bf7\u573a\u5730\u8bf4\u660e" : "\u9884\u7ea6\u573a\u5730\u8bf4\u660e");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19277k = (TextView) findViewById(R.id.tv_description);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
