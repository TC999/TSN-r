package com.baidu.liantian.core;

import android.content.pm.ActivityInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: ActivityInfoArray.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b> f12154a;

    public a(ActivityInfo[] activityInfoArr) {
        int length;
        this.f12154a = null;
        if (activityInfoArr == null || (length = activityInfoArr.length) <= 0) {
            return;
        }
        this.f12154a = new ArrayList<>(length);
        for (int i4 = 0; i4 < length; i4++) {
            if (activityInfoArr[i4] != null) {
                b bVar = new b();
                bVar.f12162h = activityInfoArr[i4].configChanges;
                bVar.f12160f = activityInfoArr[i4].flags;
                bVar.f12166l = activityInfoArr[i4].labelRes;
                bVar.f12156b = activityInfoArr[i4].launchMode;
                if (activityInfoArr[i4].nonLocalizedLabel != null) {
                    bVar.f12167m = activityInfoArr[i4].nonLocalizedLabel.toString();
                }
                bVar.f12164j = activityInfoArr[i4].name;
                bVar.f12165k = activityInfoArr[i4].packageName;
                bVar.f12157c = activityInfoArr[i4].permission;
                bVar.f12161g = activityInfoArr[i4].screenOrientation;
                bVar.f12163i = activityInfoArr[i4].softInputMode;
                bVar.f12159e = activityInfoArr[i4].targetActivity;
                bVar.f12158d = activityInfoArr[i4].taskAffinity;
                bVar.f12155a = activityInfoArr[i4].theme;
                this.f12154a.add(bVar);
            }
        }
    }

    public final byte[] a() {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (IOException unused) {
                objectOutputStream = null;
            } catch (Throwable th2) {
                objectOutputStream = null;
                th = th2;
            }
        } catch (IOException unused2) {
            byteArrayOutputStream = null;
            objectOutputStream = null;
        } catch (Throwable th3) {
            objectOutputStream = null;
            th = th3;
            byteArrayOutputStream = null;
        }
        try {
            objectOutputStream.writeObject(this.f12154a);
            objectOutputStream.close();
            byteArrayOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                objectOutputStream.close();
                byteArrayOutputStream.close();
            } catch (IOException unused3) {
                com.baidu.liantian.b.e.a();
            }
            return byteArray;
        } catch (IOException unused4) {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException unused5) {
                    com.baidu.liantian.b.e.a();
                    return null;
                }
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException unused6) {
                    com.baidu.liantian.b.e.a();
                    throw th;
                }
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw th;
        }
    }

    public static ArrayList<b> a(byte[] bArr) {
        ObjectInputStream objectInputStream;
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (Throwable unused) {
                objectInputStream = null;
            }
        } catch (Throwable unused2) {
            objectInputStream = null;
            byteArrayInputStream = null;
        }
        try {
            ArrayList<b> arrayList = (ArrayList) objectInputStream.readObject();
            try {
                objectInputStream.close();
                byteArrayInputStream.close();
            } catch (IOException unused3) {
                com.baidu.liantian.b.e.a();
            }
            return arrayList;
        } catch (Throwable unused4) {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException unused5) {
                    com.baidu.liantian.b.e.a();
                    return null;
                }
            }
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            return null;
        }
    }
}
