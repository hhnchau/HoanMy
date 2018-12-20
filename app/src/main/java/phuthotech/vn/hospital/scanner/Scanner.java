package phuthotech.vn.hospital.scanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import phuthotech.vn.hospital.R;
import phuthotech.vn.hospital.loading.Loading;
import phuthotech.vn.hospital.model.HealthCard;
import phuthotech.vn.hospital.utils.Utils;

/**
 * Created by kingpes on 8/23/18.
 */

public class Scanner extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scanner_activity);

        ViewGroup frame = findViewById(R.id.frameScanner);
        scannerView = new ZXingScannerView(this);
        frame.addView(scannerView);
    }

    @Override
    protected void onResume() {
        super.onResume();

        scannerView.setResultHandler(this);
        scannerView.startCamera();

    }

    @Override
    protected void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        Loading.getInstance().show(this);
        String qr = result.getText();
        String[] dataParse = qr.split("\\|");

        HealthCard healthCard = new HealthCard();
        if (dataParse.length>0)
            healthCard.setSn(dataParse[0]);
        if (dataParse.length>1)
            healthCard.setName(Utils.convertHexStrToUnicode(dataParse[1]));
        if (dataParse.length>2)
            healthCard.setBirthday(dataParse[2]);
        if (dataParse.length>3)
            healthCard.setGender(Integer.parseInt(dataParse[3]));
        if (dataParse.length>4)
            healthCard.setAddress(Utils.convertHexStrToUnicode(dataParse[4]));
        if (dataParse.length>5)
            healthCard.setFirstRegistration(dataParse[5]);
        if (dataParse.length>6)
            healthCard.setStartDate(dataParse[6]);
        if (dataParse.length>7)
            healthCard.setEndDate(dataParse[7]);
        if (dataParse.length>8)
            healthCard.setReleaseDate(dataParse[8]);
        if (dataParse.length>9)
            healthCard.setManagerCode(dataParse[9]);
        if (dataParse.length>10)
            healthCard.setParentName(Utils.convertHexStrToUnicode(dataParse[10]));
        if (dataParse.length>11)
            healthCard.setObjectCode(dataParse[11]);
        if (dataParse.length>12)
            healthCard.setTimeOver5Year(dataParse[12]);
        if (dataParse.length>13)
            healthCard.setStringTest(dataParse[13]);
        if (dataParse.length>14)
            healthCard.setCharEnd(dataParse[14]);
        onReturn(healthCard);
    }

    private void onReturn(HealthCard healthCard){
        Intent intent = new Intent();
        intent.putExtra("SCANNER", healthCard);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Loading.getInstance().hide();
    }
}
