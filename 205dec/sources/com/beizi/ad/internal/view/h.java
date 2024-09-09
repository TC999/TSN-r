package com.beizi.ad.internal.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.beizi.ad.R;
import com.beizi.ad.internal.utilities.HaoboLog;
import com.beizi.ad.internal.utilities.ViewUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: VideoEnabledWebChromeClient.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class h extends a {

    /* renamed from: a  reason: collision with root package name */
    private WebChromeClient.CustomViewCallback f14329a;

    /* renamed from: b  reason: collision with root package name */
    private FrameLayout f14330b;

    /* renamed from: c  reason: collision with root package name */
    private Activity f14331c;

    /* renamed from: d  reason: collision with root package name */
    private AdViewImpl f14332d;

    /* renamed from: e  reason: collision with root package name */
    private AdWebView f14333e;

    public h(Activity activity) {
        this.f14331c = activity;
    }

    private void a(FrameLayout frameLayout) {
        ImageButton imageButton = new ImageButton(this.f14331c);
        imageButton.setImageDrawable(this.f14331c.getResources().getDrawable(17301560));
        imageButton.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 53));
        imageButton.setBackgroundColor(0);
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.onHideCustomView();
            }
        });
        frameLayout.addView(imageButton);
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        AdViewImpl adViewImpl = this.f14332d;
        if (adViewImpl == null || adViewImpl.e() || this.f14332d.a()) {
            return;
        }
        this.f14332d.getAdDispatcher().b();
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(final String str, final GeolocationPermissions.Callback callback) {
        AdWebView adWebView = this.f14333e;
        AlertDialog.Builder builder = new AlertDialog.Builder(adWebView != null ? ViewUtil.getTopContext(adWebView) : this.f14331c);
        builder.setTitle(String.format(this.f14331c.getResources().getString(R.string.html5_geo_permission_prompt_title), str));
        builder.setMessage(R.string.html5_geo_permission_prompt);
        builder.setPositiveButton(R.string.allow, new DialogInterface.OnClickListener() { // from class: com.beizi.ad.internal.view.h.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                callback.invoke(str, true, true);
            }
        });
        builder.setNegativeButton(R.string.deny, new DialogInterface.OnClickListener() { // from class: com.beizi.ad.internal.view.h.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                callback.invoke(str, false, false);
            }
        });
        builder.create().show();
        AdViewImpl adViewImpl = this.f14332d;
        if (adViewImpl == null || adViewImpl.e() || this.f14332d.a()) {
            return;
        }
        this.f14332d.getAdDispatcher().c();
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        ViewGroup viewGroup;
        super.onHideCustomView();
        Activity activity = this.f14331c;
        if (activity != null && this.f14330b != null) {
            AdWebView adWebView = this.f14333e;
            if (adWebView != null) {
                viewGroup = (ViewGroup) adWebView.getRootView().findViewById(16908290);
            } else {
                viewGroup = (ViewGroup) activity.findViewById(16908290);
            }
            if (viewGroup == null) {
                HaoboLog.w(HaoboLog.baseLogTag, HaoboLog.getString(R.string.fullscreen_video_hide_error));
                return;
            }
            viewGroup.removeView(this.f14330b);
            WebChromeClient.CustomViewCallback customViewCallback = this.f14329a;
            if (customViewCallback != null) {
                try {
                    customViewCallback.onCustomViewHidden();
                    return;
                } catch (NullPointerException e4) {
                    String str = HaoboLog.baseLogTag;
                    HaoboLog.e(str, "Exception calling customViewCallback  onCustomViewHidden: " + e4.getMessage());
                    return;
                }
            }
            return;
        }
        HaoboLog.w(HaoboLog.baseLogTag, HaoboLog.getString(R.string.fullscreen_video_hide_error));
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, int i4, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, customViewCallback);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        ViewGroup viewGroup;
        super.onShowCustomView(view, customViewCallback);
        Activity activity = this.f14331c;
        if (activity == null) {
            HaoboLog.w(HaoboLog.baseLogTag, HaoboLog.getString(R.string.fullscreen_video_show_error));
            return;
        }
        AdWebView adWebView = this.f14333e;
        if (adWebView != null) {
            viewGroup = (ViewGroup) adWebView.getRootView().findViewById(16908290);
        } else {
            viewGroup = (ViewGroup) activity.findViewById(16908290);
        }
        if (viewGroup == null) {
            HaoboLog.w(HaoboLog.baseLogTag, HaoboLog.getString(R.string.fullscreen_video_show_error));
            return;
        }
        this.f14329a = customViewCallback;
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            this.f14330b = frameLayout;
            frameLayout.setClickable(true);
            this.f14330b.setBackgroundColor(-16777216);
            try {
                a(this.f14330b);
                viewGroup.addView(this.f14330b, new ViewGroup.LayoutParams(-1, -1));
                return;
            } catch (Exception e4) {
                HaoboLog.d(HaoboLog.baseLogTag, e4.toString());
                return;
            }
        }
        this.f14330b = null;
    }

    public h(AdWebView adWebView) {
        this.f14331c = (Activity) adWebView.getContextFromMutableContext();
        this.f14333e = adWebView;
        this.f14332d = adWebView.adViewImpl;
    }
}
