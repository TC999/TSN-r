package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.av;
import com.baidu.mobads.sdk.internal.bu;
import com.baidu.mobads.sdk.internal.x;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class PatchAdView extends RelativeLayout {
    private static final String AD_CLICKED = "onAdClicked";
    private static final String PLAY_END = "playCompletion";
    private static final String PLAY_ERROR = "playFailure";
    private static final String PLAY_START = "onAdShow";
    private static final String TAG = "PacthAdView";
    private View mAdView;
    private IPatchAdListener mListener;
    private ClassLoader mLoader;
    private final String mRemoteClassName;
    private Context mViewContext;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class InvocationHandlerImp implements InvocationHandler {
        InvocationHandlerImp() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            if (TextUtils.isEmpty(name)) {
                return null;
            }
            if (name.equals("playCompletion")) {
                if (PatchAdView.this.mListener != null) {
                    PatchAdView.this.mListener.playCompletion();
                }
            } else if (name.equals("playFailure")) {
                if (PatchAdView.this.mListener != null) {
                    PatchAdView.this.mListener.playError();
                }
            } else if (name.equals("onAdShow")) {
                if (PatchAdView.this.mListener != null) {
                    PatchAdView.this.mListener.onAdShow();
                }
            } else if (name.equals("onAdClicked") && PatchAdView.this.mListener != null) {
                PatchAdView.this.mListener.onAdClicked();
            }
            return null;
        }
    }

    public PatchAdView(Context context) {
        super(context);
        this.mRemoteClassName = x.f13028i;
        init(context);
        setBackgroundColor(Color.parseColor("#000000"));
    }

    private void init(Context context) {
        this.mViewContext = context;
        Object[] objArr = {context};
        ClassLoader a4 = bu.a(context);
        this.mLoader = a4;
        View view = (View) av.a(this.mRemoteClassName, a4, new Class[]{Context.class}, objArr);
        this.mAdView = view;
        if (view != null) {
            addView(view, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public long getCurrentPosition() {
        View view = this.mAdView;
        if (view != null) {
            Object a4 = av.a(this.mRemoteClassName, view, this.mLoader, "getCurrentPosition", new Class[0], new Object[0]);
            if (a4 instanceof Number) {
                return ((Long) a4).longValue();
            }
            return 0L;
        }
        return 0L;
    }

    public long getDuration() {
        View view = this.mAdView;
        if (view != null) {
            Object a4 = av.a(this.mRemoteClassName, view, this.mLoader, "getDuration", new Class[0], new Object[0]);
            if (a4 instanceof Number) {
                return ((Long) a4).longValue();
            }
            return 0L;
        }
        return 0L;
    }

    public void setAdData(XAdVideoResponse xAdVideoResponse) {
        View view;
        if (xAdVideoResponse == null || (view = this.mAdView) == null) {
            return;
        }
        av.a(this.mRemoteClassName, view, this.mLoader, "setAdData", new Class[]{Object.class}, xAdVideoResponse);
    }

    public void setPatchAdListener(IPatchAdListener iPatchAdListener) {
        this.mListener = iPatchAdListener;
        try {
            Class<?> a4 = av.a("com.component.patchad.IPatchAdListener", this.mLoader);
            if (a4 != null) {
                Object newProxyInstance = Proxy.newProxyInstance(a4.getClassLoader(), new Class[]{a4}, new InvocationHandlerImp());
                View view = this.mAdView;
                if (view != null) {
                    av.a(this.mRemoteClassName, view, this.mLoader, "setPatchAdListener", new Class[]{a4}, newProxyInstance);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void setVideoVolume(boolean z3) {
        View view = this.mAdView;
        if (view != null) {
            av.a(this.mRemoteClassName, view, this.mLoader, "setVideoVolume", new Class[]{Boolean.TYPE}, Boolean.valueOf(z3));
        }
    }
}
