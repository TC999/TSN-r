package cn.jpush.android.d;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.ad.m;
import cn.jpush.android.helper.Logger;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static Queue<a> f4122a;

    public static synchronized void a(Context context, String str) {
        synchronized (c.class) {
            if (context == null) {
                Logger.w("MsgQueueUtils", "unexcepted , context is null");
                return;
            }
            File filesDir = context.getFilesDir();
            if (filesDir == null) {
                Logger.w("MsgQueueUtils", "can't get files dir");
                return;
            }
            File file = new File(filesDir, str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    private static synchronized void a(Context context, String str, ArrayList<a> arrayList) {
        synchronized (c.class) {
            Logger.v("MsgQueueUtils", "Action - saveObjects");
            if (context == null) {
                Logger.w("MsgQueueUtils", "unexcepted , context is null");
            } else if (arrayList == null) {
                Logger.w("MsgQueueUtils", "mObjectList is null");
            } else {
                File file = new File(context.getFilesDir(), str);
                JSONArray jSONArray = new JSONArray();
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    jSONArray.put(arrayList.get(i4).a());
                }
                cn.jpush.android.ad.c.a(file.getAbsolutePath(), jSONArray.toString());
            }
        }
    }

    public static boolean a(Context context, a aVar) {
        if (f4122a == null) {
            f4122a = new ConcurrentLinkedQueue();
            try {
                ArrayList<a> b4 = b(context, "msg_queue_v350");
                if (b4 != null && !b4.isEmpty()) {
                    Iterator<a> it = b4.iterator();
                    while (it.hasNext()) {
                        f4122a.offer(it.next());
                    }
                }
            } catch (Exception e4) {
                Logger.ww("MsgQueueUtils", "init lastMsgQueue failed:" + e4.getMessage());
            }
        }
        if (context == null) {
            Logger.ww("MsgQueueUtils", "#unexcepted - context was null");
            return false;
        }
        if (aVar == null) {
            Logger.ww("MsgQueueUtils", "#unexcepted - entityKey was null");
        }
        if (f4122a.contains(aVar)) {
            Logger.e("MsgQueueUtils", "Duplicated msg. Give up processing - " + aVar);
            return true;
        }
        if (f4122a.size() >= 200) {
            f4122a.poll();
        }
        f4122a.offer(aVar);
        try {
            ArrayList<a> b5 = b(context, "msg_queue_v350");
            if (b5 == null) {
                b5 = new ArrayList<>();
            }
            if (b5.size() >= 50) {
                b5.remove(0);
            }
            b5.add(aVar);
            a(context, "msg_queue_v350", b5);
        } catch (Exception e5) {
            Logger.ww("MsgQueueUtils", "msg save in sp failed:" + e5.getMessage());
        }
        return false;
    }

    private static synchronized ArrayList<a> b(Context context, String str) {
        synchronized (c.class) {
            if (context == null) {
                Logger.w("MsgQueueUtils", "unexcepted , context is null");
                return null;
            }
            ArrayList<a> arrayList = new ArrayList<>();
            File file = new File(context.getFilesDir(), str);
            if (file.exists()) {
                String c4 = cn.jpush.android.ad.c.c(file);
                if (!TextUtils.isEmpty(c4)) {
                    JSONArray jSONArray = new JSONArray(c4);
                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                        arrayList.add(a.a(jSONArray.getJSONObject(i4)));
                    }
                }
            }
            m.a((Closeable) null);
            return arrayList;
        }
    }
}
