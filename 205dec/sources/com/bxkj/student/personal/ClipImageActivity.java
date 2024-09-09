package com.bxkj.student.personal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.student.common.crop.view.ClipViewLayout;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ClipImageActivity extends BaseActivity {

    /* renamed from: q  reason: collision with root package name */
    private static final String f22001q = "ClipImageActivity";

    /* renamed from: k  reason: collision with root package name */
    private ClipViewLayout f22002k;

    /* renamed from: l  reason: collision with root package name */
    private ClipViewLayout f22003l;

    /* renamed from: m  reason: collision with root package name */
    private ImageView f22004m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f22005n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f22006o;

    /* renamed from: p  reason: collision with root package name */
    private int f22007p;

    private void i0() {
        Bitmap d4;
        if (this.f22007p == 1) {
            d4 = this.f22002k.d();
        } else {
            d4 = this.f22003l.d();
        }
        if (d4 == null) {
            Log.e("android", "zoomedCropBitmap == null");
            return;
        }
        OutputStream outputStream = null;
        File externalCacheDir = "mounted".equals(Environment.getExternalStorageState()) ? getExternalCacheDir() : null;
        if (externalCacheDir == null || !externalCacheDir.exists()) {
            externalCacheDir = getCacheDir();
        }
        File file = new File(externalCacheDir, "avatar");
        if (!file.exists()) {
            file.mkdirs();
        }
        Uri fromFile = Uri.fromFile(new File(file, "cropped_" + System.currentTimeMillis() + ".jpg"));
        try {
            try {
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
        if (fromFile != null) {
            try {
                outputStream = getContentResolver().openOutputStream(fromFile);
                if (outputStream != null) {
                    d4.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e6) {
                Log.e("android", "Cannot open file: " + fromFile, e6);
                if (outputStream != null) {
                    outputStream.close();
                }
            }
            Intent intent = new Intent();
            intent.setData(fromFile);
            setResult(-1, intent);
            finish();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427382;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f22007p = getIntent().getIntExtra("type", 1);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f22002k = (ClipViewLayout) findViewById(2131231119);
        this.f22003l = (ClipViewLayout) findViewById(2131231120);
        this.f22004m = (ImageView) findViewById(2131231391);
        this.f22005n = (TextView) findViewById(2131231026);
        this.f22006o = (TextView) findViewById(2131230989);
        this.f22004m.setOnClickListener(this);
        this.f22005n.setOnClickListener(this);
        this.f22006o.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        int id = v3.getId();
        if (id == 2131230989) {
            i0();
        } else if (id == 2131231026) {
            finish();
        } else if (id != 2131231391) {
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f22007p == 1) {
            this.f22002k.setVisibility(0);
            this.f22003l.setVisibility(8);
            this.f22002k.setImageSrc(getIntent().getData());
            return;
        }
        this.f22003l.setVisibility(0);
        this.f22002k.setVisibility(8);
        this.f22003l.setImageSrc(getIntent().getData());
    }
}
