package com.beizi.fusion.p064b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.sdk.internal.C2624bk;
import com.beizi.fusion.model.Messenger;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.model.ResponseInfo;
import com.beizi.fusion.p072g.AesUtils;
import com.beizi.fusion.p072g.BeiZiStorageUtils;
import com.beizi.fusion.p072g.C3112ad;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3145h;
import com.beizi.fusion.p072g.GzipUtil;
import com.beizi.fusion.p072g.HttpUtil;
import com.beizi.fusion.p072g.SDCardHelper;
import com.beizi.fusion.p072g.StringUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.beizi.fusion.b.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class EventCar {

    /* renamed from: a */
    private static EventCar f10951a;

    /* renamed from: b */
    private Context f10952b;

    /* renamed from: c */
    private List<Messenger.EventsBean> f10953c;

    /* renamed from: d */
    private long f10954d = 128;

    /* renamed from: e */
    private long f10955e = C2624bk.f8681e;

    private EventCar(Context context) {
        this.f10952b = context;
        RequestInfo init = RequestInfo.getInstance(context).init();
        if (init.isInit()) {
            return;
        }
        init.init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m48861c(EventBean eventBean) {
        try {
            ResponseInfo responseInfo = ResponseInfo.getInstance(this.f10952b);
            String m48863a = m48863a(eventBean.m48916d());
            if (responseInfo.getMessenger() != null) {
                this.f10953c = responseInfo.getMessenger().getEvents();
                this.f10954d = Long.valueOf(responseInfo.getMessenger().getFileMaxSize()).longValue();
                this.f10955e = responseInfo.getMessenger().getExpireTime();
                List<Messenger.EventsBean> list = this.f10953c;
                if (list == null || list.size() <= 0) {
                    return;
                }
                for (int i = 0; i < this.f10953c.size(); i++) {
                    Messenger.EventsBean eventsBean = this.f10953c.get(i);
                    List<String> codes = eventsBean.getCodes();
                    if (codes != null && codes.size() > 0) {
                        for (int i2 = 0; i2 < codes.size(); i2++) {
                            if (!TextUtils.isEmpty(eventBean.m48916d()) && !TextUtils.isEmpty(codes.get(i2)) && (eventBean.m48916d().equals(codes.get(i2)) || m48863a.equals(codes.get(i2)))) {
                                if (eventsBean.getIsOnline().equals("1")) {
                                    eventBean.m48921a(eventsBean.getUploadUrl());
                                    m48866a(eventsBean, eventBean);
                                } else {
                                    m48865a(eventsBean, eventBean, true);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public void m48862b(EventBean eventBean) {
        m48861c(eventBean);
    }

    /* renamed from: a */
    public static EventCar m48869a(Context context) {
        if (f10951a == null) {
            synchronized (EventCar.class) {
                if (f10951a == null) {
                    f10951a = new EventCar(context);
                }
            }
        }
        return f10951a;
    }

    /* renamed from: a */
    public void m48868a(final EventBean eventBean) {
        C3145h.m48264b().m48261e().execute(new Runnable() { // from class: com.beizi.fusion.b.c.1
            @Override // java.lang.Runnable
            public void run() {
                EventCar.this.m48861c(eventBean);
            }
        });
    }

    /* renamed from: a */
    private String m48863a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String substring = str.substring(0, str.indexOf(".") + 1);
        return substring + "*";
    }

    /* renamed from: a */
    private void m48866a(Messenger.EventsBean eventsBean, EventBean eventBean) {
        String m48310a;
        if (eventBean != null) {
            try {
                if (TextUtils.isEmpty(eventBean.m48923a())) {
                    return;
                }
                String m48923a = eventBean.m48923a();
                if ("590.200".equalsIgnoreCase(eventBean.m48916d())) {
                    m48923a = eventBean.m48928U();
                }
                int indexOf = m48923a.indexOf("?");
                String substring = m48923a.substring(0, indexOf);
                String substring2 = m48923a.substring(indexOf + 1);
                if ("590.200".equalsIgnoreCase(eventBean.m48916d())) {
                    m48310a = StringUtil.m48309a(this.f10952b, substring2, eventBean, eventBean.m48929T());
                } else {
                    m48310a = StringUtil.m48310a(this.f10952b, substring2, eventBean);
                }
                String m48270a = AesUtils.m48270a(C3112ad.m48504a(), GzipUtil.m48152a(m48310a));
                if (m48270a != null) {
                    String m48507a = HttpUtil.m48507a(substring, m48270a.getBytes());
                    if (!TextUtils.isEmpty(m48507a)) {
                        try {
                            if (new JSONObject(m48507a).optInt("code") != 200) {
                                m48865a(eventsBean, eventBean, true);
                                return;
                            }
                            return;
                        } catch (JSONException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    m48865a(eventsBean, eventBean, true);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void m48870a() {
        int i;
        int i2;
        try {
            C3116af.m48496a("BeiZis", "===================doUpLoadLogs===================:" + Thread.currentThread().getName());
            long currentTimeMillis = System.currentTimeMillis();
            File m48244a = BeiZiStorageUtils.m48244a(this.f10952b);
            C3116af.m48496a("BeiZis", "doUpLoadLogs storagePath == " + m48244a);
            if (m48244a != null) {
                String str = m48244a.getPath() + "/BeiZi/offline/";
                File[] listFiles = new File(str).listFiles();
                if (listFiles == null || listFiles.length <= 0) {
                    return;
                }
                int length = listFiles.length;
                int i3 = 0;
                int i4 = 0;
                while (i4 < length) {
                    File file = listFiles[i4];
                    if (file.isDirectory()) {
                        String str2 = "";
                        File file2 = new File(str, file.getName() + "/10000.txt");
                        if (file2.exists()) {
                            str2 = m48864a(file2);
                        } else {
                            SDCardHelper.m48380a(file);
                        }
                        String str3 = str2;
                        if (!TextUtils.isEmpty(str3)) {
                            File[] listFiles2 = file.listFiles();
                            int length2 = listFiles2.length;
                            int i5 = 0;
                            while (i5 < length2) {
                                File file3 = listFiles2[i5];
                                if (file3.getName().equals("10000.txt")) {
                                    i2 = i4;
                                } else {
                                    i2 = i4;
                                    if (currentTimeMillis - Long.valueOf(file3.getName().substring(i3, file3.getName().indexOf("."))).longValue() < this.f10955e) {
                                        String m48509a = HttpUtil.m48509a(str3, file3);
                                        if (!TextUtils.isEmpty(m48509a)) {
                                            try {
                                                if (new JSONObject(m48509a).optInt("code") == 200) {
                                                    file3.delete();
                                                }
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    } else {
                                        file3.delete();
                                    }
                                }
                                i5++;
                                i4 = i2;
                                i3 = 0;
                            }
                            i = i4;
                            if (file.listFiles().length <= 1) {
                                SDCardHelper.m48380a(file);
                            }
                            i4 = i + 1;
                            i3 = 0;
                        }
                    }
                    i = i4;
                    i4 = i + 1;
                    i3 = 0;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    private static String m48864a(File file) {
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /* renamed from: a */
    private void m48865a(Messenger.EventsBean eventsBean, EventBean eventBean, boolean z) {
        File[] listFiles;
        Log.d("BeiZis", "===================doOffline===================:" + eventBean.m48916d());
        try {
            File m48244a = BeiZiStorageUtils.m48244a(this.f10952b);
            C3116af.m48496a("BeiZis", "doOffline storagePath == " + m48244a);
            if (m48244a != null) {
                String offlineUrl = z ? eventsBean.getOfflineUrl() : eventsBean.getUploadUrl();
                String substring = offlineUrl.substring(0, offlineUrl.indexOf("?"));
                String m48270a = AesUtils.m48270a(C3112ad.m48504a(), StringUtil.m48310a(this.f10952b, offlineUrl.substring(offlineUrl.indexOf("?") + 1), eventBean));
                String str = m48244a.getPath() + "/BeiZi/offline/" + StringUtil.m48308a(eventsBean.toString()) + "/";
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, "10000.txt");
                synchronized (EventCar.class) {
                    if (!file2.exists()) {
                        file2.createNewFile();
                        FileWriter fileWriter = new FileWriter(file2, true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        bufferedWriter.write(substring);
                        bufferedWriter.newLine();
                        bufferedWriter.close();
                        fileWriter.close();
                    }
                }
                long j = 0;
                for (File file3 : file.listFiles()) {
                    String substring2 = file3.getName().substring(0, file3.getName().indexOf("."));
                    if (Long.valueOf(substring2).longValue() > j) {
                        j = Long.valueOf(substring2).longValue();
                    }
                }
                if (j != 0 && j != 10000) {
                    File file4 = new File(str + j + ".txt");
                    if (file4.exists() && file4.length() < this.f10954d * 1000) {
                        FileWriter fileWriter2 = new FileWriter(file4, true);
                        BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
                        bufferedWriter2.write(m48270a);
                        bufferedWriter2.newLine();
                        bufferedWriter2.close();
                        fileWriter2.close();
                        file4.renameTo(new File(file, System.currentTimeMillis() + ".txt"));
                        return;
                    }
                }
                File file5 = new File(file, System.currentTimeMillis() + ".txt");
                file5.createNewFile();
                FileWriter fileWriter3 = new FileWriter(file5, true);
                BufferedWriter bufferedWriter3 = new BufferedWriter(fileWriter3);
                bufferedWriter3.write(m48270a);
                bufferedWriter3.newLine();
                bufferedWriter3.close();
                fileWriter3.close();
            }
        } catch (IOException unused) {
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
