package cn.jiguang.push.asus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class PushMessageReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static ExecutorService f3765a;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0059, code lost:
        if (r15 == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007b, code lost:
        if (r18.equals("ups.turnOn") == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.content.Context r17, java.lang.String r18, long r19, org.json.JSONObject r21) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.push.asus.PushMessageReceiver.a(android.content.Context, java.lang.String, long, org.json.JSONObject):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.Context r9, long r10, java.lang.String r12, java.lang.String r13) {
        /*
            r8 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "receive cmd:"
            r0.<init>(r1)
            r0.append(r12)
            java.lang.String r1 = ",rid:"
            r0.append(r1)
            r0.append(r10)
            java.lang.String r1 = ",content:"
            r0.append(r1)
            r0.append(r13)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "PushMessageReceiver"
            cn.jpush.android.i.b.a(r1, r0)
            boolean r0 = android.text.TextUtils.isEmpty(r13)
            if (r0 != 0) goto L33
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L2f
            r0.<init>(r13)     // Catch: org.json.JSONException -> L2f
            goto L34
        L2f:
            r13 = move-exception
            r13.printStackTrace()
        L33:
            r0 = 0
        L34:
            r7 = r0
            if (r7 != 0) goto L3d
            java.lang.String r9 = "handle json null"
            cn.jpush.android.i.b.g(r1, r9)
            return
        L3d:
            r2 = r8
            r3 = r9
            r4 = r12
            r5 = r10
            r2.a(r3, r4, r5, r7)     // Catch: java.lang.Throwable -> L45
            return
        L45:
            r9 = move-exception
            r9.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.push.asus.PushMessageReceiver.a(android.content.Context, long, java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Context context, Intent intent) {
        if ("com.ups.push.PUSH_RESPONSE".equals(intent.getAction())) {
            a(context, intent.getLongExtra("message_rid", -1L), intent.getStringExtra("message_cmd"), intent.getStringExtra("message_content"));
        }
    }

    public abstract void a(Context context, cn.jpush.android.c.a aVar);

    public abstract void a(Context context, String str);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (f3765a == null) {
            f3765a = Executors.newSingleThreadExecutor();
        }
        f3765a.execute(new a(this, context, intent));
    }
}
