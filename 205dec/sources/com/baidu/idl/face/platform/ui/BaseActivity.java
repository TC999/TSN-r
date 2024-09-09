package com.baidu.idl.face.platform.ui;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.stub.StubApp;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BaseActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestPermissions(99);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i4, String[] strArr, int[] iArr) {
        StubApp.interface22(i4, strArr, iArr);
        for (int i5 = 0; i5 < strArr.length; i5++) {
            int i6 = iArr[i5];
        }
    }

    public void requestPermissions(int i4) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                ArrayList arrayList = new ArrayList();
                if (checkSelfPermission("android.permission.CAMERA") != 0) {
                    arrayList.add("android.permission.CAMERA");
                }
                if (checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
                    arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
                }
                if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                    arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                }
                if (arrayList.size() >= 1) {
                    int size = arrayList.size();
                    String[] strArr = new String[size];
                    for (int i5 = 0; i5 < size; i5++) {
                        strArr[i5] = (String) arrayList.get(i5);
                    }
                    requestPermissions(strArr, i4);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void showCustomToast(String str) {
        View inflate = getLayoutInflater().inflate(R.layout.setting_toast_layout, (ViewGroup) findViewById(R.id.toast_layout));
        ((TextView) inflate.findViewById(R.id.toast_txt)).setText(str);
        Toast toast = new Toast(this);
        toast.setDuration(0);
        toast.setGravity(17, 0, 0);
        toast.setView(inflate);
        toast.show();
    }
}
