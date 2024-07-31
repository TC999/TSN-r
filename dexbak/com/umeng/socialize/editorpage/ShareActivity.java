package com.umeng.socialize.editorpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.common.ResContainer;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import java.io.File;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ShareActivity extends Activity implements View.OnClickListener {

    /* renamed from: c */
    private static final String f39430c = "ShareActivity";

    /* renamed from: d */
    private static int f39431d = 140;

    /* renamed from: a */
    protected ImageView f39432a;

    /* renamed from: f */
    private String f39435f;

    /* renamed from: g */
    private String f39436g;

    /* renamed from: h */
    private String f39437h;

    /* renamed from: i */
    private ResContainer f39438i;

    /* renamed from: j */
    private EditText f39439j;

    /* renamed from: k */
    private TextView f39440k;

    /* renamed from: l */
    private Context f39441l;

    /* renamed from: m */
    private boolean f39442m;

    /* renamed from: n */
    private SHARE_MEDIA f39443n;

    /* renamed from: p */
    private ImageView f39445p;

    /* renamed from: q */
    private TextView f39446q;

    /* renamed from: e */
    private String f39434e = "7.3.2";

    /* renamed from: o */
    private boolean f39444o = false;

    /* renamed from: b */
    TextWatcher f39433b = new TextWatcher() { // from class: com.umeng.socialize.editorpage.ShareActivity.1
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ShareActivity shareActivity = ShareActivity.this;
            shareActivity.f39442m = shareActivity.m13281e();
        }
    };

    /* renamed from: b */
    private String m13284b(String str) {
        if (str.equals("TENCENT")) {
            return getResources().getString(this.f39438i.string("umeng_socialize_sharetotencent"));
        }
        if (str.equals("RENREN")) {
            return getResources().getString(this.f39438i.string("umeng_socialize_sharetorenren"));
        }
        if (str.equals("DOUBAN")) {
            return getResources().getString(this.f39438i.string("umeng_socialize_sharetodouban"));
        }
        if (str.equals("TWITTER")) {
            return getResources().getString(this.f39438i.string("umeng_socialize_sharetotwitter"));
        }
        if (str.equals("LINKEDIN")) {
            return getResources().getString(this.f39438i.string("umeng_socialize_sharetolinkin"));
        }
        return getResources().getString(this.f39438i.string("umeng_socialize_sharetosina"));
    }

    /* renamed from: c */
    private void m13283c() {
        SHARE_MEDIA share_media;
        String obj = this.f39439j.getText().toString();
        if (TextUtils.isEmpty(obj.trim()) && this.f39443n == SHARE_MEDIA.SINA && (TextUtils.isEmpty(this.f39437h) || this.f39437h.equals("web") || this.f39437h.equals("video") || this.f39437h.equals("music"))) {
            Toast.makeText(this.f39441l, UmengText.SHARE.CONTEXT_EMPTY, 0).show();
        } else if (SocializeUtils.countContentLength(obj) <= f39431d || (share_media = this.f39443n) == SHARE_MEDIA.TWITTER || share_media == SHARE_MEDIA.LINKEDIN) {
            if (this.f39442m && this.f39443n != SHARE_MEDIA.TWITTER) {
                Toast.makeText(this.f39441l, UmengText.SHARE.CONTEXT_LONG, 0).show();
                return;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString(SocializeConstants.KEY_TEXT, obj);
            bundle.putString("pic", this.f39437h);
            intent.putExtras(bundle);
            setResult(-1, intent);
            m13289a();
        }
    }

    /* renamed from: d */
    private void m13282d() {
        this.f39437h = null;
        findViewById(this.f39438i.m13290id("root")).setBackgroundColor(Color.parseColor("#D4E0E5"));
        findViewById(this.f39438i.m13290id("umeng_socialize_share_bottom_area")).setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public boolean m13281e() {
        int countContentLength = f39431d - SocializeUtils.countContentLength(this.f39439j.getText().toString());
        TextView textView = this.f39440k;
        textView.setText(SocializeUtils.countContentLength(this.f39439j.getText().toString()) + "/" + f39431d);
        return countContentLength < 0;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (SocializeConstants.BACKKEY_COMPLETE_CLOSE && keyEvent.getKeyCode() == 4) {
            new Handler().postDelayed(new Runnable() { // from class: com.umeng.socialize.editorpage.ShareActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    ShareActivity.this.setResult(1000);
                    ShareActivity.this.finish();
                }
            }, 400L);
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void onCancel(View view) {
        setResult(1000);
        m13289a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == this.f39438i.m13290id("umeng_back")) {
            onCancel(view);
        } else if (id == this.f39438i.m13290id("umeng_share_btn")) {
            m13283c();
        } else if (id == this.f39438i.m13290id("umeng_del")) {
            m13282d();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.f39438i = ResContainer.get(this);
        this.f39444o = SocializeUtils.isFloatWindowStyle(this);
        super.onCreate(bundle);
        this.f39441l = this;
        setContentView(this.f39438i.layout("umeng_socialize_share"));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.softInputMode = 32;
        if (this.f39444o) {
            int[] floatWindowSize = SocializeUtils.getFloatWindowSize(this.f39441l);
            attributes.width = floatWindowSize[0];
            attributes.height = floatWindowSize[1];
        }
        getWindow().setAttributes(attributes);
        SLog.m13211E(UmengText.SHARE.SHAREVIEWV + this.f39434e);
        Bundle extras = getIntent().getExtras();
        this.f39443n = m13286a(extras.getString(SocializeConstants.KEY_PLATFORM));
        f39431d = 140;
        this.f39435f = extras.getString(SocializeConstants.KEY_TEXT);
        this.f39437h = extras.getString("pic");
        this.f39436g = extras.getString("title");
        m13285b();
        this.f39445p = (ImageView) findViewById(this.f39438i.m13290id("umeng_del"));
        this.f39439j.addTextChangedListener(this.f39433b);
        ((TextView) findViewById(this.f39438i.m13290id("umeng_title"))).setText(m13284b(extras.getString(SocializeConstants.KEY_PLATFORM)));
        findViewById(this.f39438i.m13290id("umeng_back")).setOnClickListener(this);
        findViewById(this.f39438i.m13290id("umeng_share_btn")).setOnClickListener(this);
        this.f39445p.setOnClickListener(this);
        this.f39440k = (TextView) findViewById(this.f39438i.m13290id("umeng_socialize_share_word_num"));
        this.f39442m = m13281e();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            setResult(1000);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onResume() {
        this.f39439j.requestFocus();
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    /* renamed from: a */
    private SHARE_MEDIA m13286a(String str) {
        if (str.equals("DOUBAN")) {
            return SHARE_MEDIA.DOUBAN;
        }
        if (str.equals("TWITTER")) {
            return SHARE_MEDIA.TWITTER;
        }
        if (str.equals("LINKEDIN")) {
            return SHARE_MEDIA.LINKEDIN;
        }
        return SHARE_MEDIA.SINA;
    }

    /* renamed from: a */
    protected void m13289a() {
        finish();
    }

    /* renamed from: b */
    private void m13285b() {
        this.f39439j = (EditText) findViewById(this.f39438i.m13290id("umeng_socialize_share_edittext"));
        if (!TextUtils.isEmpty(this.f39435f)) {
            this.f39439j.setText(this.f39435f);
            this.f39439j.setSelection(this.f39435f.length());
        }
        this.f39446q = (TextView) findViewById(this.f39438i.m13290id("umeng_web_title"));
        this.f39432a = (ImageView) findViewById(this.f39438i.m13290id("umeng_share_icon"));
        if (this.f39437h != null) {
            findViewById(this.f39438i.m13290id("umeng_socialize_share_bottom_area")).setVisibility(0);
            ImageView imageView = (ImageView) findViewById(this.f39438i.m13290id("umeng_share_icon"));
            this.f39432a = imageView;
            imageView.setVisibility(0);
            if (this.f39437h.equals("video")) {
                this.f39432a.setImageResource(ResContainer.getResourceId(this.f39441l, "drawable", "umeng_socialize_share_video"));
            } else if (this.f39437h.equals("music")) {
                this.f39432a.setImageResource(ResContainer.getResourceId(this.f39441l, "drawable", "umeng_socialize_share_music"));
            } else if (this.f39437h.equals("web")) {
                this.f39432a.setImageResource(ResContainer.getResourceId(this.f39441l, "drawable", "umeng_socialize_share_web"));
            } else {
                this.f39432a.setImageURI(Uri.fromFile(new File(this.f39437h)));
            }
            if (!TextUtils.isEmpty(this.f39436g)) {
                this.f39446q.setVisibility(0);
                this.f39446q.setText(this.f39436g);
            }
            findViewById(this.f39438i.m13290id("root")).setBackgroundColor(-1);
        } else if (TextUtils.isEmpty(this.f39436g)) {
        } else {
            this.f39432a.setImageResource(ResContainer.getResourceId(this.f39441l, "drawable", "umeng_socialize_share_web"));
            this.f39446q.setVisibility(0);
            this.f39446q.setText(this.f39436g);
        }
    }
}
