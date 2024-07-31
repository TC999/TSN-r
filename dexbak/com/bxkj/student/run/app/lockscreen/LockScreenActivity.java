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
import com.bxkj.student.C4215R;
import com.bxkj.student.common.utils.StatusUtil;
import com.bxkj.student.run.app.RunBroadcastActionType;
import com.bxkj.student.run.app.lockscreen.SwipeBackLayout;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class LockScreenActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f19202k;

    /* renamed from: l */
    private TextView f19203l;

    /* renamed from: m */
    private TextView f19204m;

    /* renamed from: n */
    private TextView f19205n;

    /* renamed from: o */
    private TextView f19206o;

    /* renamed from: p */
    private TextView f19207p;

    /* renamed from: q */
    private TextView f19208q;

    /* renamed from: r */
    private TextView f19209r;

    /* renamed from: s */
    private BroadcastReceiver f19210s;

    /* renamed from: t */
    private ShimmerTextView f19211t;

    /* renamed from: u */
    private Shimmer f19212u;

    /* renamed from: com.bxkj.student.run.app.lockscreen.LockScreenActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5267a extends BroadcastReceiver {
        C5267a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(RunBroadcastActionType.NOTIFY_RUN_DATA)) {
                if (intent.hasExtra("distance")) {
                    LockScreenActivity.this.f19205n.setText(intent.getStringExtra("distance"));
                }
                if (intent.hasExtra("speed")) {
                    LockScreenActivity.this.f19206o.setText(intent.getStringExtra("speed"));
                }
                if (intent.hasExtra("peisu")) {
                    LockScreenActivity.this.f19207p.setText(intent.getStringExtra("peisu"));
                }
                if (intent.hasExtra(RtspHeaders.Values.TIME)) {
                    LockScreenActivity.this.f19208q.setText(intent.getStringExtra(RtspHeaders.Values.TIME));
                }
            } else if (intent.getAction().equals(RunBroadcastActionType.UPDATE_STEP)) {
                if (intent.hasExtra("stepCount")) {
                    LockScreenActivity.this.f19209r.setText(String.valueOf(intent.getIntExtra("stepCount", 0)));
                }
            } else if (intent.getAction().equals(RunBroadcastActionType.RUN_PAUSE_NOTIFICATION)) {
                if (intent.hasExtra("message")) {
                    LockScreenActivity.this.f19204m.setText(intent.getStringExtra("message"));
                }
            } else if (intent.getAction().equals(RunBroadcastActionType.RUN_CONTINUE_NOTIFICATION)) {
                LockScreenActivity.this.f19204m.setText("");
            } else if (intent.getAction().equals(RunBroadcastActionType.RUN_DEBUG_INFO) && intent.hasExtra("msg")) {
                LockScreenActivity.this.f19203l.setText(intent.getStringExtra("msg"));
            }
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: O */
    public void mo39959O() {
        getWindow().addFlags(4194304);
        getWindow().addFlags(524288);
        super.mo39959O();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_lockmain;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        Intent intent = getIntent();
        if (intent.hasExtra("distance")) {
            this.f19205n.setText(intent.getStringExtra("distance"));
        }
        if (intent.hasExtra("speed")) {
            this.f19206o.setText(intent.getStringExtra("speed"));
        }
        if (intent.hasExtra("peisu")) {
            this.f19207p.setText(intent.getStringExtra("peisu"));
        }
        if (intent.hasExtra(RtspHeaders.Values.TIME)) {
            this.f19208q.setText(intent.getStringExtra(RtspHeaders.Values.TIME));
        }
        if (intent.hasExtra("stepCount")) {
            this.f19209r.setText(String.valueOf(intent.getIntExtra("stepCount", 0)));
        }
        if (intent.hasExtra("lastPauseMessage")) {
            this.f19204m.setText(intent.getStringExtra("lastPauseMessage"));
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(RunBroadcastActionType.NOTIFY_RUN_DATA);
        intentFilter.addAction(RunBroadcastActionType.UPDATE_STEP);
        intentFilter.addAction(RunBroadcastActionType.RUN_PAUSE_NOTIFICATION);
        intentFilter.addAction(RunBroadcastActionType.RUN_CONTINUE_NOTIFICATION);
        intentFilter.addAction(RunBroadcastActionType.RUN_DEBUG_INFO);
        C5267a c5267a = new C5267a();
        this.f19210s = c5267a;
        registerReceiver(c5267a, intentFilter, "com.bxkj.student.sports.permissions.MY_BROADCAST", null);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        m57922e0(false);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        try {
            findViewById(C4215R.C4219id.swipeback).getRootView().getRootView().setBackgroundResource(C4215R.mipmap.login_bg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        StatusUtil.m42797d(this);
        this.f19211t = (ShimmerTextView) findViewById(C4215R.C4219id.lockmain_shimmer);
        this.f19212u = new Shimmer();
        ((SwipeBackLayout) findViewById(C4215R.C4219id.swipeback)).setSwipeBackListener(new SwipeBackLayout.C5269b(this));
        this.f19203l = (TextView) findViewById(C4215R.C4219id.tv_debug_info);
        this.f19204m = (TextView) findViewById(C4215R.C4219id.tv_face_status);
        this.f19202k = (TextView) findViewById(2131232846);
        this.f19205n = (TextView) findViewById(2131232941);
        this.f19206o = (TextView) findViewById(C4215R.C4219id.tv_speed);
        this.f19207p = (TextView) findViewById(C4215R.C4219id.tv_peisu);
        this.f19208q = (TextView) findViewById(2131233198);
        this.f19209r = (TextView) findViewById(2131233170);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        BroadcastReceiver broadcastReceiver = this.f19210s;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.f19210s = null;
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
        this.f19212u.m20280t(this.f19211t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        this.f19212u.m20292h();
        super.onStop();
    }
}
