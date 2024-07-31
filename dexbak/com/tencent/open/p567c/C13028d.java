package com.tencent.open.p567c;

import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.open.log.SLog;
import com.tencent.open.web.security.C13075a;
import com.tencent.open.web.security.SecureJsInterface;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.c.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13028d extends C13026b {

    /* renamed from: a */
    public static boolean f37330a;

    /* renamed from: b */
    private KeyEvent f37331b;

    /* renamed from: c */
    private C13075a f37332c;

    public C13028d(Context context) {
        super(context);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int unicodeChar;
        SLog.m15131d("openSDK_LOG.SecureWebView", "-->dispatchKeyEvent, is device support: " + f37330a);
        if (!f37330a) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 4) {
                if (keyCode != 66) {
                    if (keyCode != 67) {
                        if (keyEvent.getUnicodeChar() == 0) {
                            return super.dispatchKeyEvent(keyEvent);
                        }
                        if (SecureJsInterface.isPWDEdit && (((unicodeChar = keyEvent.getUnicodeChar()) >= 33 && unicodeChar <= 95) || (unicodeChar >= 97 && unicodeChar <= 125))) {
                            KeyEvent keyEvent2 = new KeyEvent(0, 17);
                            this.f37331b = keyEvent2;
                            return super.dispatchKeyEvent(keyEvent2);
                        }
                        return super.dispatchKeyEvent(keyEvent);
                    }
                    C13075a.f37460b = true;
                    return super.dispatchKeyEvent(keyEvent);
                }
                return super.dispatchKeyEvent(keyEvent);
            }
            return super.dispatchKeyEvent(keyEvent);
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        SLog.m15127i("openSDK_LOG.SecureWebView", "-->create input connection, is edit: " + SecureJsInterface.isPWDEdit);
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        SLog.m15123v("openSDK_LOG.SecureWebView", "-->onCreateInputConnection, inputConn is " + onCreateInputConnection);
        if (onCreateInputConnection != null) {
            f37330a = true;
            C13075a c13075a = new C13075a(super.onCreateInputConnection(editorInfo), false);
            this.f37332c = c13075a;
            return c13075a;
        }
        f37330a = false;
        return onCreateInputConnection;
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int unicodeChar;
        SLog.m15131d("openSDK_LOG.SecureWebView", "-->onKeyDown, is device support: " + f37330a);
        if (!f37330a) {
            return super.onKeyDown(i, keyEvent);
        }
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 4) {
                if (keyCode != 66) {
                    if (keyCode != 67) {
                        if (keyEvent.getUnicodeChar() == 0) {
                            return super.onKeyDown(i, keyEvent);
                        }
                        if (SecureJsInterface.isPWDEdit && (((unicodeChar = keyEvent.getUnicodeChar()) >= 33 && unicodeChar <= 95) || (unicodeChar >= 97 && unicodeChar <= 125))) {
                            KeyEvent keyEvent2 = new KeyEvent(0, 17);
                            this.f37331b = keyEvent2;
                            return super.onKeyDown(keyEvent2.getKeyCode(), this.f37331b);
                        }
                        return super.onKeyDown(i, keyEvent);
                    }
                    C13075a.f37460b = true;
                    return super.onKeyDown(i, keyEvent);
                }
                return super.onKeyDown(i, keyEvent);
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
