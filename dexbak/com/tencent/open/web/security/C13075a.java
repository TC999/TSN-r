package com.tencent.open.web.security;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.tencent.open.log.SLog;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.web.security.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13075a extends InputConnectionWrapper {

    /* renamed from: a */
    public static String f37459a;

    /* renamed from: b */
    public static boolean f37460b;

    /* renamed from: c */
    public static boolean f37461c;

    public C13075a(InputConnection inputConnection, boolean z) {
        super(inputConnection, z);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i) {
        f37461c = true;
        f37459a = charSequence.toString();
        SLog.m15123v("openSDK_LOG.CaptureInputConnection", "-->commitText: " + charSequence.toString());
        return super.commitText(charSequence, i);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            SLog.m15127i("openSDK_LOG.CaptureInputConnection", "sendKeyEvent");
            f37459a = String.valueOf((char) keyEvent.getUnicodeChar());
            f37461c = true;
            SLog.m15131d("openSDK_LOG.CaptureInputConnection", "s: " + f37459a);
        }
        SLog.m15131d("openSDK_LOG.CaptureInputConnection", "-->sendKeyEvent: " + f37459a);
        return super.sendKeyEvent(keyEvent);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i) {
        f37461c = true;
        f37459a = charSequence.toString();
        SLog.m15123v("openSDK_LOG.CaptureInputConnection", "-->setComposingText: " + charSequence.toString());
        return super.setComposingText(charSequence, i);
    }
}
