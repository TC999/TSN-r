package com.bytedance.pangle.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.pangle.p119d.C6083e;

/* renamed from: com.bytedance.pangle.receiver.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6189a extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context context, final Intent intent) {
        if (C6197c.m37017a().f22131c.contains(Integer.valueOf(hashCode()))) {
            C6197c.m37017a().m37016a(context, intent);
        } else {
            C6083e.m37211b(new Runnable() { // from class: com.bytedance.pangle.receiver.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    C6197c.m37017a().m37016a(context, intent);
                }
            });
        }
    }
}
