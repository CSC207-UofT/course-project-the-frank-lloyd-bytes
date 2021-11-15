package activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import androidx.fragment.app.Fragment;
import com.google.zxing.WriterException;

public class QRCodeFragment extends Fragment {
    ImageView qrImage;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.qr_code_tab_fragment, container, false);
        qrImage = view.findViewById(R.id.qrPlaceHolder);
        Bundle bundle = getArguments();
        String input = bundle.getString("allInfo");

        QRGEncoder qrgEncoder = new QRGEncoder(input, QRGContents.Type.TEXT, 150);
        Bitmap bitmap = qrgEncoder.getBitmap();
        qrImage.setImageBitmap(bitmap);



        return view;
    }}