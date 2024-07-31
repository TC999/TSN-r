package com.beizi.p051ad.internal.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.core.view.ViewCompat;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.internal.utilities.ViewUtil;

/* renamed from: com.beizi.ad.internal.view.h */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class VideoEnabledWebChromeClient extends BaseWebChromeClient {

    /* renamed from: a */
    private WebChromeClient.CustomViewCallback f10764a;

    /* renamed from: b */
    private FrameLayout f10765b;

    /* renamed from: c */
    private Activity f10766c;

    /* renamed from: d */
    private AdViewImpl f10767d;

    /* renamed from: e */
    private AdWebView f10768e;

    public VideoEnabledWebChromeClient(Activity activity) {
        this.f10766c = activity;
    }

    /* renamed from: a */
    private void m49094a(FrameLayout frameLayout) {
        ImageButton imageButton = new ImageButton(this.f10766c);
        imageButton.setImageDrawable(this.f10766c.getResources().getDrawable(17301560));
        imageButton.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 53));
        imageButton.setBackgroundColor(0);
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoEnabledWebChromeClient.this.onHideCustomView();
            }
        });
        frameLayout.addView(imageButton);
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        AdViewImpl adViewImpl = this.f10767d;
        if (adViewImpl == null || adViewImpl.mo49147e() || this.f10767d.m49255a()) {
            return;
        }
        this.f10767d.getAdDispatcher().mo49214b();
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(final String str, final GeolocationPermissions.Callback callback) {
        AdWebView adWebView = this.f10768e;
        AlertDialog.Builder builder = new AlertDialog.Builder(adWebView != null ? ViewUtil.getTopContext(adWebView) : this.f10766c);
        builder.setTitle(String.format(this.f10766c.getResources().getString(C2750R.C2755string.html5_geo_permission_prompt_title), str));
        builder.setMessage(C2750R.C2755string.html5_geo_permission_prompt);
        builder.setPositiveButton(C2750R.C2755string.allow, new DialogInterface.OnClickListener() { // from class: com.beizi.ad.internal.view.h.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                callback.invoke(str, true, true);
            }
        });
        builder.setNegativeButton(C2750R.C2755string.deny, new DialogInterface.OnClickListener() { // from class: com.beizi.ad.internal.view.h.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                callback.invoke(str, false, false);
            }
        });
        builder.create().show();
        AdViewImpl adViewImpl = this.f10767d;
        if (adViewImpl == null || adViewImpl.mo49147e() || this.f10767d.m49255a()) {
            return;
        }
        this.f10767d.getAdDispatcher().mo49213c();
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        ViewGroup viewGroup;
        super.onHideCustomView();
        Activity activity = this.f10766c;
        if (activity != null && this.f10765b != null) {
            AdWebView adWebView = this.f10768e;
            if (adWebView != null) {
                viewGroup = (ViewGroup) adWebView.getRootView().findViewById(16908290);
            } else {
                viewGroup = (ViewGroup) activity.findViewById(16908290);
            }
            if (viewGroup == null) {
                HaoboLog.m49284w(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.fullscreen_video_hide_error));
                return;
            }
            viewGroup.removeView(this.f10765b);
            WebChromeClient.CustomViewCallback customViewCallback = this.f10764a;
            if (customViewCallback != null) {
                try {
                    customViewCallback.onCustomViewHidden();
                    return;
                } catch (NullPointerException e) {
                    String str = HaoboLog.baseLogTag;
                    HaoboLog.m49290e(str, "Exception calling customViewCallback  onCustomViewHidden: " + e.getMessage());
                    return;
                }
            }
            return;
        }
        HaoboLog.m49284w(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.fullscreen_video_hide_error));
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, customViewCallback);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        ViewGroup viewGroup;
        super.onShowCustomView(view, customViewCallback);
        Activity activity = this.f10766c;
        if (activity == null) {
            HaoboLog.m49284w(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.fullscreen_video_show_error));
            return;
        }
        AdWebView adWebView = this.f10768e;
        if (adWebView != null) {
            viewGroup = (ViewGroup) adWebView.getRootView().findViewById(16908290);
        } else {
            viewGroup = (ViewGroup) activity.findViewById(16908290);
        }
        if (viewGroup == null) {
            HaoboLog.m49284w(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.fullscreen_video_show_error));
            return;
        }
        this.f10764a = customViewCallback;
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            this.f10765b = frameLayout;
            frameLayout.setClickable(true);
            this.f10765b.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            try {
                m49094a(this.f10765b);
                viewGroup.addView(this.f10765b, new ViewGroup.LayoutParams(-1, -1));
                return;
            } catch (Exception e) {
                HaoboLog.m49292d(HaoboLog.baseLogTag, e.toString());
                return;
            }
        }
        this.f10765b = null;
    }

    public VideoEnabledWebChromeClient(AdWebView adWebView) {
        this.f10766c = (Activity) adWebView.getContextFromMutableContext();
        this.f10768e = adWebView;
        this.f10767d = adWebView.adViewImpl;
    }
}
