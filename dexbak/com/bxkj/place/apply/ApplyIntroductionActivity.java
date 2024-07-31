package com.bxkj.place.apply;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.place.C4159R;
import java.util.Map;
import p650v.PlaceApiService;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ApplyIntroductionActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f15795k;

    /* renamed from: l */
    private int f15796l;

    /* renamed from: com.bxkj.place.apply.ApplyIntroductionActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4170a extends HttpCallBack {
        C4170a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyIntroductionActivity.this.f15795k.setText(JsonParse.getString(data, "data"));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4159R.C4165layout.ac_place_apply_description;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        Http.with(this.f1669h).setObservable(((PlaceApiService) Http.getApiService(PlaceApiService.class)).m213h(this.f15796l)).setDataListener(new C4170a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        if (getIntent().hasExtra("appointType")) {
            this.f15796l = getIntent().getIntExtra("appointType", 1);
        }
        setTitle(this.f15796l == 2 ? "申请场地说明" : "预约场地说明");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f15795k = (TextView) findViewById(C4159R.C4163id.tv_description);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
