package tech.gujin.tinkersample;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

import java.io.File;

public class MainActivity extends Activity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((TextView) findViewById(R.id.tv_msg)).setText("此版本存在BUG");

        File file = new File(getExternalCacheDir(), "/patch_signed_7zip.apk");
        if (file.exists()) {
            TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), file.getAbsolutePath());
        }
    }
}