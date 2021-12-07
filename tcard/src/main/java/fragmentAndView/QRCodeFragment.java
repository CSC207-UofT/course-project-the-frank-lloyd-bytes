package fragmentAndView;

import activities.R;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import androidx.fragment.app.Fragment;


public class QRCodeFragment extends Fragment {
    /**
     * This is one of the fragments that's displayed in the Dashboard through ViewPager2
     * A QR code that contains the criteria (status, year, department)
     * of the User object is generated and displayed
     */
    ImageView qrImage;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.qr_code_tab_fragment, container, false);
        qrImage = view.findViewById(R.id.qrPlaceHolder);
        Bundle bundle = getArguments();
        assert bundle != null;
        String input = bundle.getString("allInfo");
        QRGEncoder qrgEncoder = new QRGEncoder(input, QRGContents.Type.TEXT, 200);
        Bitmap bitmap = qrgEncoder.getBitmap();
        qrImage.setImageBitmap(bitmap);
        return view;
    }}