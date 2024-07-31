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
import com.baidu.idl.face.platform.FaceEnvironment;
import com.bxkj.student.C4215R;
import com.bxkj.student.common.crop.view.ClipViewLayout;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ClipImageActivity extends BaseActivity {

    /* renamed from: q */
    private static final String f18701q = "ClipImageActivity";

    /* renamed from: k */
    private ClipViewLayout f18702k;

    /* renamed from: l */
    private ClipViewLayout f18703l;

    /* renamed from: m */
    private ImageView f18704m;

    /* renamed from: n */
    private TextView f18705n;

    /* renamed from: o */
    private TextView f18706o;

    /* renamed from: p */
    private int f18707p;

    /* renamed from: i0 */
    private void m40583i0() {
        Bitmap m42923d;
        if (this.f18707p == 1) {
            m42923d = this.f18702k.m42923d();
        } else {
            m42923d = this.f18703l.m42923d();
        }
        if (m42923d == null) {
            Log.e(FaceEnvironment.f8430OS, "zoomedCropBitmap == null");
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
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (fromFile != null) {
            try {
                outputStream = getContentResolver().openOutputStream(fromFile);
                if (outputStream != null) {
                    m42923d.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e3) {
                Log.e(FaceEnvironment.f8430OS, "Cannot open file: " + fromFile, e3);
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
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_clip_image;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f18707p = getIntent().getIntExtra("type", 1);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18702k = (ClipViewLayout) findViewById(C4215R.C4219id.clipViewLayout1);
        this.f18703l = (ClipViewLayout) findViewById(C4215R.C4219id.clipViewLayout2);
        this.f18704m = (ImageView) findViewById(C4215R.C4219id.iv_back);
        this.f18705n = (TextView) findViewById(C4215R.C4219id.btn_cancel);
        this.f18706o = (TextView) findViewById(2131230989);
        this.f18704m.setOnClickListener(this);
        this.f18705n.setOnClickListener(this);
        this.f18706o.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        if (id == 2131230989) {
            m40583i0();
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
        if (this.f18707p == 1) {
            this.f18702k.setVisibility(0);
            this.f18703l.setVisibility(8);
            this.f18702k.setImageSrc(getIntent().getData());
            return;
        }
        this.f18703l.setVisibility(0);
        this.f18702k.setVisibility(8);
        this.f18703l.setImageSrc(getIntent().getData());
    }
}
