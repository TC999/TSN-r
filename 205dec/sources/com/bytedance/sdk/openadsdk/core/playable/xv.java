package com.bytedance.sdk.openadsdk.core.playable;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.widget.playable.loading.PlayableLoadingLayout;
import com.bytedance.sdk.openadsdk.widget.PlayableLoadingView;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    JSONObject f34480c;

    /* renamed from: f  reason: collision with root package name */
    private final long f34481f = SystemClock.elapsedRealtime();

    /* renamed from: r  reason: collision with root package name */
    private int f34482r;
    private int sr;
    private PlayableLoadingLayout ux;

    /* renamed from: w  reason: collision with root package name */
    private final me f34483w;
    private final PlayableLoadingView xv;

    public xv(PlayableLoadingView playableLoadingView, me meVar) {
        this.xv = playableLoadingView;
        this.f34483w = meVar;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ux() {
        if (this.f34482r >= 100) {
            return;
        }
        q.f().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.playable.xv.1
            @Override // java.lang.Runnable
            public void run() {
                xv.this.ux.setProgress(xv.this.f34482r);
                xv.this.f34482r++;
                xv.this.ux();
            }
        }, 1000L);
    }

    public boolean sr() {
        PlayableLoadingView playableLoadingView = this.xv;
        return playableLoadingView != null && playableLoadingView.getVisibility() == 0;
    }

    public void w() {
        PlayableLoadingView playableLoadingView = this.xv;
        if (playableLoadingView == null || this.ux == null) {
            return;
        }
        playableLoadingView.c();
        this.ux.c();
    }

    public void xv() {
        PlayableLoadingView playableLoadingView = this.xv;
        if (playableLoadingView == null || this.ux == null) {
            return;
        }
        playableLoadingView.w();
        this.ux.w();
    }

    public void c() {
        PlayableLoadingView playableLoadingView = this.xv;
        if (playableLoadingView != null && this.f34483w != null) {
            try {
                Context context = playableLoadingView.getContext();
                PlayableLoadingLayout playableLoadingLayout = new PlayableLoadingLayout(context, this.f34480c);
                this.ux = playableLoadingLayout;
                this.xv.addView(playableLoadingLayout);
                this.ux.c(context);
            } catch (Throwable unused) {
            }
        }
    }

    public void w(me meVar, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "csj_remove_pl_loading_page");
        hashMap.put("playable_userFeel_loading_duration", Long.valueOf(SystemClock.elapsedRealtime() - this.f34481f));
        com.bytedance.sdk.openadsdk.core.a.xv.p(meVar, str, "playable_track", hashMap);
    }

    public void c(com.bytedance.sdk.openadsdk.core.w.sr srVar) {
        PlayableLoadingLayout playableLoadingLayout = this.ux;
        if (playableLoadingLayout != null) {
            playableLoadingLayout.setBtnPlayOnClickListener(srVar);
            this.ux.setBtnPlayOnTouchListener(srVar);
        }
    }

    public void c(int i4) {
        PlayableLoadingLayout playableLoadingLayout = this.ux;
        if (playableLoadingLayout != null) {
            if (i4 < 90) {
                playableLoadingLayout.setProgress(i4);
                return;
            }
            this.f34482r = 90;
            ux();
        }
    }

    public void c(String str, int i4, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("remove_loading_page_type", Integer.valueOf(i4));
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("playable_url", str2);
        }
        com.bytedance.sdk.openadsdk.core.a.xv.p(this.f34483w, str, "remove_loading_page", hashMap);
    }

    public void c(me meVar, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("playable_loading_style", this.sr);
            jSONObject.put("event", "csj_playable_loading_show");
            com.bytedance.sdk.openadsdk.core.a.xv.xv(meVar, str, "playable_track", jSONObject);
        } catch (Throwable unused) {
        }
    }
}
