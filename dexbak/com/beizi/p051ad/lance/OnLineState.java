package com.beizi.p051ad.lance;

import android.content.Context;
import com.beizi.p051ad.lance.p062a.LogUtil;

/* renamed from: com.beizi.ad.lance.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class OnLineState {

    /* renamed from: c */
    private static OnLineState f10817c;

    /* renamed from: a */
    public OnLineStateClass f10818a;

    /* renamed from: b */
    private String f10819b = "OnLineState";

    private OnLineState(Context context) {
        if (context == null) {
            LogUtil.m49044c("OnLineState", "OnLineState init failed,because context cann't be null ");
            return;
        }
        OnLineStateClass onLineStateClass = new OnLineStateClass();
        this.f10818a = onLineStateClass;
        onLineStateClass.m49017a(context);
    }

    /* renamed from: a */
    public static OnLineState m49019a(Context context) {
        if (f10817c == null) {
            synchronized (OnLineState.class) {
                if (f10817c == null) {
                    f10817c = new OnLineState(context);
                }
            }
        }
        return f10817c;
    }

    /* renamed from: a */
    public void m49018a(OnLineImpl onLineImpl) {
        OnLineStateClass onLineStateClass = this.f10818a;
        if (onLineStateClass != null) {
            onLineStateClass.m49016a(onLineImpl);
        } else {
            LogUtil.m49046a(this.f10819b, "please init OnLineState first ,you can init it with 'OnLineState.init(context);' in you BaseApplication ");
        }
    }
}
