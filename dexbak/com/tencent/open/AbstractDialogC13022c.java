package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import com.tencent.open.log.SLog;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractDialogC13022c extends Dialog {

    /* renamed from: a */
    protected C13006b f37323a;
    @SuppressLint({"NewApi"})

    /* renamed from: b */
    protected final WebChromeClient f37324b;

    public AbstractDialogC13022c(Context context, int i) {
        super(context, i);
        this.f37324b = new WebChromeClient() { // from class: com.tencent.open.c.1
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (consoleMessage == null) {
                    return false;
                }
                SLog.m15127i("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + consoleMessage.message() + " -- From  111 line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
                AbstractDialogC13022c.this.mo15147a(consoleMessage.message());
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public void onConsoleMessage(String str, int i2, String str2) {
                SLog.m15127i("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + str + " -- From 222 line " + i2 + " of " + str2);
            }
        };
    }

    /* renamed from: a */
    protected abstract void mo15147a(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f37323a = new C13006b();
    }
}
