package com.bxkj.student.run.app.lockscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.student.common.utils.m;
import com.bxkj.student.run.app.lockscreen.SwipeBackLayout;
import com.romainpiel.shimmer.ShimmerTextView;
import com.romainpiel.shimmer.b;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class LockScreenActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TextView f22439k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f22440l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f22441m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f22442n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f22443o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f22444p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f22445q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f22446r;

    /* renamed from: s  reason: collision with root package name */
    private BroadcastReceiver f22447s;

    /* renamed from: t  reason: collision with root package name */
    private ShimmerTextView f22448t;

    /* renamed from: u  reason: collision with root package name */
    private b f22449u;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("NOTIFY_RUN_DATA")) {
                if (intent.hasExtra("distance")) {
                    LockScreenActivity.this.f22442n.setText(intent.getStringExtra("distance"));
                }
                if (intent.hasExtra("speed")) {
                    LockScreenActivity.this.f22443o.setText(intent.getStringExtra("speed"));
                }
                if (intent.hasExtra("peisu")) {
                    LockScreenActivity.this.f22444p.setText(intent.getStringExtra("peisu"));
                }
                if (intent.hasExtra("time")) {
                    LockScreenActivity.this.f22445q.setText(intent.getStringExtra("time"));
                }
            } else if (intent.getAction().equals("UPDATE_STEP")) {
                if (intent.hasExtra("stepCount")) {
                    LockScreenActivity.this.f22446r.setText(String.valueOf(intent.getIntExtra("stepCount", 0)));
                }
            } else if (intent.getAction().equals("RUN_PAUSE_NOTIFICATION")) {
                if (intent.hasExtra("message")) {
                    LockScreenActivity.this.f22441m.setText(intent.getStringExtra("message"));
                }
            } else if (intent.getAction().equals("RUN_CONTINUE_NOTIFICATION")) {
                LockScreenActivity.this.f22441m.setText("");
            } else if (intent.getAction().equals("RUN_DEBUG_INFO") && intent.hasExtra("msg")) {
                LockScreenActivity.this.f22440l.setText(intent.getStringExtra("msg"));
            }
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void O() {
        getWindow().addFlags(4194304);
        getWindow().addFlags(524288);
        super.O();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427430;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        Intent intent = getIntent();
        if (intent.hasExtra("distance")) {
            this.f22442n.setText(intent.getStringExtra("distance"));
        }
        if (intent.hasExtra("speed")) {
            this.f22443o.setText(intent.getStringExtra("speed"));
        }
        if (intent.hasExtra("peisu")) {
            this.f22444p.setText(intent.getStringExtra("peisu"));
        }
        if (intent.hasExtra("time")) {
            this.f22445q.setText(intent.getStringExtra("time"));
        }
        if (intent.hasExtra("stepCount")) {
            this.f22446r.setText(String.valueOf(intent.getIntExtra("stepCount", 0)));
        }
        if (intent.hasExtra("lastPauseMessage")) {
            this.f22441m.setText(intent.getStringExtra("lastPauseMessage"));
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("NOTIFY_RUN_DATA");
        intentFilter.addAction("UPDATE_STEP");
        intentFilter.addAction("RUN_PAUSE_NOTIFICATION");
        intentFilter.addAction("RUN_CONTINUE_NOTIFICATION");
        intentFilter.addAction("RUN_DEBUG_INFO");
        a aVar = new a();
        this.f22447s = aVar;
        registerReceiver(aVar, intentFilter, "com.bxkj.student.sports.permissions.MY_BROADCAST", null);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        e0(false);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        try {
            findViewById(2131232686).getRootView().getRootView().setBackgroundResource(2131558821);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        m.d(this);
        this.f22448t = (ShimmerTextView) findViewById(2131232241);
        this.f22449u = new b();
        ((SwipeBackLayout) findViewById(2131232686)).setSwipeBackListener(new SwipeBackLayout.b(this));
        this.f22440l = (TextView) findViewById(2131232936);
        this.f22441m = (TextView) findViewById(2131232960);
        this.f22439k = (TextView) findViewById(2131232846);
        this.f22442n = (TextView) findViewById(2131232941);
        this.f22443o = (TextView) findViewById(2131233162);
        this.f22444p = (TextView) findViewById(2131233076);
        this.f22445q = (TextView) findViewById(2131233198);
        this.f22446r = (TextView) findViewById(2131233170);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        BroadcastReceiver broadcastReceiver = this.f22447s;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.f22447s = null;
        }
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        int keyCode2 = event.getKeyCode();
        if (keyCode2 == 4 || keyCode2 == 82) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f22449u.t(this.f22448t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        this.f22449u.h();
        super.onStop();
    }
}
