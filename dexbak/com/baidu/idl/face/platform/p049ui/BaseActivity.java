package com.baidu.idl.face.platform.p049ui;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.kuaishou.weapon.p205p0.C7282g;
import com.stub.StubApp;
import java.util.ArrayList;

/* renamed from: com.baidu.idl.face.platform.ui.BaseActivity */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BaseActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestPermissions(99);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        StubApp.interface22(i, strArr, iArr);
        for (int i2 = 0; i2 < strArr.length; i2++) {
            int i3 = iArr[i2];
        }
    }

    public void requestPermissions(int i) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                ArrayList arrayList = new ArrayList();
                if (checkSelfPermission("android.permission.CAMERA") != 0) {
                    arrayList.add("android.permission.CAMERA");
                }
                if (checkSelfPermission(C7282g.f24951i) != 0) {
                    arrayList.add(C7282g.f24951i);
                }
                if (checkSelfPermission(C7282g.f24952j) != 0) {
                    arrayList.add(C7282g.f24952j);
                }
                if (arrayList.size() >= 1) {
                    int size = arrayList.size();
                    String[] strArr = new String[size];
                    for (int i2 = 0; i2 < size; i2++) {
                        strArr[i2] = (String) arrayList.get(i2);
                    }
                    requestPermissions(strArr, i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showCustomToast(String str) {
        View inflate = getLayoutInflater().inflate(C2505R.C2510layout.setting_toast_layout, (ViewGroup) findViewById(C2505R.C2508id.toast_layout));
        ((TextView) inflate.findViewById(C2505R.C2508id.toast_txt)).setText(str);
        Toast toast = new Toast(this);
        toast.setDuration(0);
        toast.setGravity(17, 0, 0);
        toast.setView(inflate);
        toast.show();
    }
}
