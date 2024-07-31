package com.umeng.socialize.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.stub.StubApp;
import com.umeng.socialize.bean.PlatformName;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.common.ResContainer;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import java.lang.reflect.Method;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class BaseDialog extends Dialog {

    /* renamed from: R */
    public final ResContainer f39640R;
    public Activity mActivity;
    public View mContent;
    public Context mContext;
    public int mFlag;
    public Handler mHandler;
    public SHARE_MEDIA mPlatform;
    public View mProgressbar;
    public Bundle mValues;
    public String mWaitUrl;
    public WebView mWebView;
    public TextView titleMidTv;

    public BaseDialog(Activity activity, SHARE_MEDIA share_media) {
        super(activity, ResContainer.get(activity).style("umeng_socialize_popup_dialog"));
        this.mFlag = 0;
        this.mWaitUrl = "error";
        this.mHandler = new Handler() { // from class: com.umeng.socialize.view.BaseDialog.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                View view;
                super.handleMessage(message);
                if (message.what != 1 || (view = BaseDialog.this.mProgressbar) == null) {
                    return;
                }
                view.setVisibility(8);
            }
        };
        Context origApplicationContext = StubApp.getOrigApplicationContext(activity.getApplicationContext());
        this.mContext = origApplicationContext;
        this.f39640R = ResContainer.get(origApplicationContext);
        this.mActivity = activity;
        this.mPlatform = share_media;
    }

    public void initViews() {
        setOwnerActivity(this.mActivity);
        int layout = this.f39640R.layout("umeng_socialize_oauth_dialog");
        int m13290id = this.f39640R.m13290id("umeng_socialize_follow");
        String str = null;
        View inflate = ((LayoutInflater) this.mActivity.getSystemService("layout_inflater")).inflate(layout, (ViewGroup) null);
        this.mContent = inflate;
        final View findViewById = inflate.findViewById(m13290id);
        findViewById.setVisibility(8);
        int m13290id2 = this.f39640R.m13290id("progress_bar_parent");
        int m13290id3 = this.f39640R.m13290id("umeng_back");
        int m13290id4 = this.f39640R.m13290id("umeng_share_btn");
        int m13290id5 = this.f39640R.m13290id("umeng_title");
        int m13290id6 = this.f39640R.m13290id("umeng_socialize_titlebar");
        View findViewById2 = this.mContent.findViewById(m13290id2);
        this.mProgressbar = findViewById2;
        findViewById2.setVisibility(0);
        ((RelativeLayout) this.mContent.findViewById(m13290id3)).setOnClickListener(new View.OnClickListener() { // from class: com.umeng.socialize.view.BaseDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseDialog.this.dismiss();
            }
        });
        this.mContent.findViewById(m13290id4).setVisibility(8);
        this.titleMidTv = (TextView) this.mContent.findViewById(m13290id5);
        if (this.mPlatform.toString().equals("SINA")) {
            str = PlatformName.SINA;
        } else if (this.mPlatform.toString().equals("DOUBAN")) {
            str = PlatformName.DOUBAN;
        }
        TextView textView = this.titleMidTv;
        textView.setText("授权" + str);
        setUpWebView();
        final View findViewById3 = this.mContent.findViewById(m13290id6);
        final int dip2Px = SocializeUtils.dip2Px(this.mContext, 200.0f);
        FrameLayout frameLayout = new FrameLayout(this.mContext) { // from class: com.umeng.socialize.view.BaseDialog.3
            /* renamed from: a */
            private void m13206a(final View view, final View view2, int i, int i2) {
                if (view2.getVisibility() == 0 && i2 < i) {
                    BaseDialog.this.mHandler.post(new Runnable() { // from class: com.umeng.socialize.view.BaseDialog.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            view2.setVisibility(8);
                            if (view.getVisibility() == 0) {
                                view.setVisibility(8);
                            }
                            requestLayout();
                        }
                    });
                } else if (view2.getVisibility() == 0 || i2 < i) {
                } else {
                    BaseDialog.this.mHandler.post(new Runnable() { // from class: com.umeng.socialize.view.BaseDialog.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            view2.setVisibility(0);
                            requestLayout();
                        }
                    });
                }
            }

            @Override // android.view.View
            protected void onSizeChanged(int i, int i2, int i3, int i4) {
                super.onSizeChanged(i, i2, i3, i4);
                if (SocializeUtils.isFloatWindowStyle(BaseDialog.this.mContext)) {
                    return;
                }
                m13206a(findViewById, findViewById3, dip2Px, i2);
            }
        };
        frameLayout.addView(this.mContent, -1, -1);
        setContentView(frameLayout);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (SocializeUtils.isFloatWindowStyle(this.mContext)) {
            int[] floatWindowSize = SocializeUtils.getFloatWindowSize(this.mContext);
            attributes.width = floatWindowSize[0];
            attributes.height = floatWindowSize[1];
        } else {
            attributes.height = -1;
            attributes.width = -1;
        }
        attributes.gravity = 17;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    public void releaseWebView() {
        try {
            ((ViewGroup) this.mWebView.getParent()).removeView(this.mWebView);
        } catch (Exception unused) {
        }
        try {
            this.mWebView.removeAllViews();
        } catch (Exception unused2) {
        }
        this.mWebView = null;
    }

    public void removeJavascriptInterface(WebView webView) {
    }

    public abstract void setClient(WebView webView);

    public boolean setUpWebView() {
        WebView webView = (WebView) this.mContent.findViewById(this.f39640R.m13290id("webView"));
        this.mWebView = webView;
        setClient(webView);
        this.mWebView.requestFocusFromTouch();
        this.mWebView.setVerticalScrollBarEnabled(false);
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setScrollBarStyle(0);
        this.mWebView.getSettings().setCacheMode(2);
        this.mWebView.setBackgroundColor(-1);
        WebSettings settings = this.mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setAllowFileAccess(false);
        settings.setSavePassword(false);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setGeolocationEnabled(true);
        try {
            Method declaredMethod = WebSettings.class.getDeclaredMethod("setDisplayZoomControls", Boolean.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(settings, Boolean.FALSE);
        } catch (Exception e) {
            SLog.error(e);
        }
        try {
            this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
            this.mWebView.removeJavascriptInterface("accessibility");
            this.mWebView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
        return true;
    }

    public void setWaitUrl(String str) {
        this.mWaitUrl = str;
    }
}
