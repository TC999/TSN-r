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
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.common.ResContainer;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ShareActivity extends Activity implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private static final String f54015c = "ShareActivity";

    /* renamed from: d  reason: collision with root package name */
    private static int f54016d = 140;

    /* renamed from: a  reason: collision with root package name */
    protected ImageView f54017a;

    /* renamed from: f  reason: collision with root package name */
    private String f54020f;

    /* renamed from: g  reason: collision with root package name */
    private String f54021g;

    /* renamed from: h  reason: collision with root package name */
    private String f54022h;

    /* renamed from: i  reason: collision with root package name */
    private ResContainer f54023i;

    /* renamed from: j  reason: collision with root package name */
    private EditText f54024j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f54025k;

    /* renamed from: l  reason: collision with root package name */
    private Context f54026l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f54027m;

    /* renamed from: n  reason: collision with root package name */
    private SHARE_MEDIA f54028n;

    /* renamed from: p  reason: collision with root package name */
    private ImageView f54030p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f54031q;

    /* renamed from: e  reason: collision with root package name */
    private String f54019e = "7.3.2";

    /* renamed from: o  reason: collision with root package name */
    private boolean f54029o = false;

    /* renamed from: b  reason: collision with root package name */
    TextWatcher f54018b = new TextWatcher() { // from class: com.umeng.socialize.editorpage.ShareActivity.1
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            ShareActivity shareActivity = ShareActivity.this;
            shareActivity.f54027m = shareActivity.e();
        }
    };

    private String b(String str) {
        if (str.equals("TENCENT")) {
            return getResources().getString(this.f54023i.string("umeng_socialize_sharetotencent"));
        }
        if (str.equals("RENREN")) {
            return getResources().getString(this.f54023i.string("umeng_socialize_sharetorenren"));
        }
        if (str.equals("DOUBAN")) {
            return getResources().getString(this.f54023i.string("umeng_socialize_sharetodouban"));
        }
        if (str.equals("TWITTER")) {
            return getResources().getString(this.f54023i.string("umeng_socialize_sharetotwitter"));
        }
        if (str.equals("LINKEDIN")) {
            return getResources().getString(this.f54023i.string("umeng_socialize_sharetolinkin"));
        }
        return getResources().getString(this.f54023i.string("umeng_socialize_sharetosina"));
    }

    private void c() {
        SHARE_MEDIA share_media;
        String obj = this.f54024j.getText().toString();
        if (TextUtils.isEmpty(obj.trim()) && this.f54028n == SHARE_MEDIA.SINA && (TextUtils.isEmpty(this.f54022h) || this.f54022h.equals("web") || this.f54022h.equals("video") || this.f54022h.equals("music"))) {
            Toast.makeText(this.f54026l, UmengText.SHARE.CONTEXT_EMPTY, 0).show();
        } else if (SocializeUtils.countContentLength(obj) <= f54016d || (share_media = this.f54028n) == SHARE_MEDIA.TWITTER || share_media == SHARE_MEDIA.LINKEDIN) {
            if (this.f54027m && this.f54028n != SHARE_MEDIA.TWITTER) {
                Toast.makeText(this.f54026l, UmengText.SHARE.CONTEXT_LONG, 0).show();
                return;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("txt", obj);
            bundle.putString("pic", this.f54022h);
            intent.putExtras(bundle);
            setResult(-1, intent);
            a();
        }
    }

    private void d() {
        this.f54022h = null;
        findViewById(this.f54023i.id("root")).setBackgroundColor(Color.parseColor("#D4E0E5"));
        findViewById(this.f54023i.id("umeng_socialize_share_bottom_area")).setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        int countContentLength = f54016d - SocializeUtils.countContentLength(this.f54024j.getText().toString());
        TextView textView = this.f54025k;
        textView.setText(SocializeUtils.countContentLength(this.f54024j.getText().toString()) + TTPathConst.sSeparator + f54016d);
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
        a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == this.f54023i.id("umeng_back")) {
            onCancel(view);
        } else if (id == this.f54023i.id("umeng_share_btn")) {
            c();
        } else if (id == this.f54023i.id("umeng_del")) {
            d();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.f54023i = ResContainer.get(this);
        this.f54029o = SocializeUtils.isFloatWindowStyle(this);
        super.onCreate(bundle);
        this.f54026l = this;
        setContentView(this.f54023i.layout("umeng_socialize_share"));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.softInputMode = 32;
        if (this.f54029o) {
            int[] floatWindowSize = SocializeUtils.getFloatWindowSize(this.f54026l);
            attributes.width = floatWindowSize[0];
            attributes.height = floatWindowSize[1];
        }
        getWindow().setAttributes(attributes);
        SLog.E(UmengText.SHARE.SHAREVIEWV + this.f54019e);
        Bundle extras = getIntent().getExtras();
        this.f54028n = a(extras.getString("media"));
        f54016d = 140;
        this.f54020f = extras.getString("txt");
        this.f54022h = extras.getString("pic");
        this.f54021g = extras.getString("title");
        b();
        this.f54030p = (ImageView) findViewById(this.f54023i.id("umeng_del"));
        this.f54024j.addTextChangedListener(this.f54018b);
        ((TextView) findViewById(this.f54023i.id("umeng_title"))).setText(b(extras.getString("media")));
        findViewById(this.f54023i.id("umeng_back")).setOnClickListener(this);
        findViewById(this.f54023i.id("umeng_share_btn")).setOnClickListener(this);
        this.f54030p.setOnClickListener(this);
        this.f54025k = (TextView) findViewById(this.f54023i.id("umeng_socialize_share_word_num"));
        this.f54027m = e();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        if (i4 == 4 && keyEvent.getRepeatCount() == 0) {
            setResult(1000);
        }
        return super.onKeyDown(i4, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i4, KeyEvent keyEvent) {
        return super.onKeyUp(i4, keyEvent);
    }

    @Override // android.app.Activity
    protected void onResume() {
        this.f54024j.requestFocus();
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    private SHARE_MEDIA a(String str) {
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

    protected void a() {
        finish();
    }

    private void b() {
        this.f54024j = (EditText) findViewById(this.f54023i.id("umeng_socialize_share_edittext"));
        if (!TextUtils.isEmpty(this.f54020f)) {
            this.f54024j.setText(this.f54020f);
            this.f54024j.setSelection(this.f54020f.length());
        }
        this.f54031q = (TextView) findViewById(this.f54023i.id("umeng_web_title"));
        this.f54017a = (ImageView) findViewById(this.f54023i.id("umeng_share_icon"));
        if (this.f54022h != null) {
            findViewById(this.f54023i.id("umeng_socialize_share_bottom_area")).setVisibility(0);
            ImageView imageView = (ImageView) findViewById(this.f54023i.id("umeng_share_icon"));
            this.f54017a = imageView;
            imageView.setVisibility(0);
            if (this.f54022h.equals("video")) {
                this.f54017a.setImageResource(ResContainer.getResourceId(this.f54026l, "drawable", "umeng_socialize_share_video"));
            } else if (this.f54022h.equals("music")) {
                this.f54017a.setImageResource(ResContainer.getResourceId(this.f54026l, "drawable", "umeng_socialize_share_music"));
            } else if (this.f54022h.equals("web")) {
                this.f54017a.setImageResource(ResContainer.getResourceId(this.f54026l, "drawable", "umeng_socialize_share_web"));
            } else {
                this.f54017a.setImageURI(Uri.fromFile(new File(this.f54022h)));
            }
            if (!TextUtils.isEmpty(this.f54021g)) {
                this.f54031q.setVisibility(0);
                this.f54031q.setText(this.f54021g);
            }
            findViewById(this.f54023i.id("root")).setBackgroundColor(-1);
        } else if (TextUtils.isEmpty(this.f54021g)) {
        } else {
            this.f54017a.setImageResource(ResContainer.getResourceId(this.f54026l, "drawable", "umeng_socialize_share_web"));
            this.f54031q.setVisibility(0);
            this.f54031q.setText(this.f54021g);
        }
    }
}
