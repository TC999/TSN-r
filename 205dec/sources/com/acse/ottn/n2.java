package com.acse.ottn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.acse.ottn.util.HelpShopAppUtil;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class n2 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public String f6059a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f6060b = new Handler();

    /* renamed from: c  reason: collision with root package name */
    public Runnable f6061c = new a();

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(n2.this.f6059a));
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.addFlags(268435456);
                HelpShopAppUtil.getContext().startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f6059a = intent.getStringExtra("url");
        this.f6060b.postDelayed(this.f6061c, 1000L);
    }
}
