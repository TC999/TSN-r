package com.p521ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.p534h.C12205p;
import com.p521ss.android.downloadlib.p536n.C12235bl;
import com.p521ss.android.socialbase.appdownloader.C12293bl;

/* renamed from: com.ss.android.downloadlib.activity.JumpKllkActivity */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class JumpKllkActivity extends TTDelegateActivity {
    @Override // com.p521ss.android.downloadlib.activity.TTDelegateActivity
    /* renamed from: ok */
    protected void mo19359ok() {
        Intent intent = getIntent();
        if (getIntent() == null) {
            C12235bl.m18640ok().m18639ok("handleIntent is null");
            C12293bl.m18426ok((Activity) this);
            return;
        }
        String stringExtra = intent.getStringExtra("p");
        long longExtra = intent.getLongExtra("id", 0L);
        if (TextUtils.isEmpty(stringExtra) || longExtra == 0) {
            C12235bl.m18640ok().m18639ok("getPackage or id is null");
            C12293bl.m18426ok((Activity) this);
        }
        boolean booleanExtra = intent.getBooleanExtra("dl", false);
        String stringExtra2 = intent.getStringExtra("bk");
        if (booleanExtra & (!TextUtils.isEmpty(stringExtra2))) {
            C12205p.m18699ok((Context) this, stringExtra, longExtra, stringExtra2, true);
            C12293bl.m18426ok((Activity) this);
            return;
        }
        int optInt = C12128r.m18946q().optInt("ab", 0);
        C12205p.m18698ok(this, stringExtra, longExtra, optInt == 1);
        if (optInt != 1) {
            C12293bl.m18426ok((Activity) this);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        C12293bl.m18426ok((Activity) this);
    }
}
