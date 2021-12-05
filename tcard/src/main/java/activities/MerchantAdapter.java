package activities;

import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import controllers.MerchantManager;

import java.io.IOException;

public class MerchantAdapter extends RecyclerView.Adapter<MerchantAdapter.ViewHolder> {
    private final MerchantManager MERCHANT_MANAGER;

    /**
     * Constructor for a facility adapter, pass in the facility map so the adapter can use it
     * @param merchantManager gets the facility array list from the database
     * @throws IOException if the construction doesn't work
     */
    public MerchantAdapter(MerchantManager merchantManager) throws IOException {
        MERCHANT_MANAGER = merchantManager;
    }

    /** declares the variables for the layouts that that is used in each card in the recycler view, assigning these
     * to a variable so that we can use it later and set them to each facility's information
     *
     */
    public class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView MERCHANT_NAME, MERCHANT_ADDRESS,MERCHANT_HOURS;

        public ViewHolder(final View itemView) {
            super(itemView);
            MERCHANT_NAME = itemView.findViewById(R.id.merchantName);
            MERCHANT_ADDRESS = itemView.findViewById(R.id.merchantAddress);
            MERCHANT_HOURS = itemView.findViewById(R.id.merchantHours);

            itemView.findViewById(R.id.seeYourDiscounts).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String applicableDiscounts = MERCHANT_MANAGER.checkApplicableDiscounts(MERCHANT_NAME.getText().toString());

                    Toast.makeText(itemView.getContext(), applicableDiscounts, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    /**
     * inflate the layout for the list item
     * @param parent describes the view of the item and its position in the recycler view
     * @param viewType for different types of items in recycler list, this is useless for us since they all look
     *                 the same
     * @return a viewholder, or how the recycler looks
     */
    @NonNull
    @Override
    public MerchantAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_merchant_layout, parent, false);
        return new ViewHolder(view);
    }

    /**
     * configuring the layouts of the facilities page. for each card view in recycler view, get the information from
     * from the database and set them to the texts
     * @param holder for each of the cards in the recycler view
     * @param position for which position in the arraylist that we need to implement in the recycler view
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.MERCHANT_NAME.setText(MERCHANT_MANAGER.getMerchantList().get(position).get(0));
        holder.MERCHANT_ADDRESS.setText(MERCHANT_MANAGER.getMerchantList().get(position).get(1));
        holder.MERCHANT_HOURS.setText(MERCHANT_MANAGER.getMerchantList().get(position).get(2));
    }

    /**
     * gets the item of the recycler view, or the database
     * @return an int of the count
     */
    @Override
    public int getItemCount() {
        return MERCHANT_MANAGER.getMerchantList().size();
    }
}

//package activities;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//import controllers.UserManager;
//import dataBase.FileReader;
//
//import java.io.IOException;
//import java.util.List;
//
//public class MerchantAdapter extends RecyclerView.Adapter<MerchantAdapter.ViewHolder> {
//
//    MerchantAdapter merchantAdapter;
//    UserManager userManager;
//    FileReader merchantReader = new FileReader("tcard/MerchantsData.csv");
//
//    /** Declares the variables for the layouts that are used in each card of the recycler view.
//     *
//     */
//    public class ViewHolder extends RecyclerView.ViewHolder{
//        TextView merchantName, merchantHours, merchantAddress;
//        public ViewHolder(final View itemView) {
//            super(itemView);
//            merchantName = itemView.findViewById(R.id.merchantName);
//            merchantHours = itemView.findViewById(R.id.merchantHours);
//            merchantAddress = itemView.findViewById(R.id.merchantAddress);
//
//            itemView.findViewById(R.id.checkFacilityAccess).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    String name = facilityName.getText().toString();
//                    Boolean R = facilitiesManager.evaluateHelper(userManager.getUser(),
//                            facilitiesManager.getFacility(name));
//                    Toast.makeText(itemView.getContext(), R.toString(), Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
//    }
//
//    private final List<List<String>> MERCHANT_LIST;
//
//    /**
//     * Constructs a MerchantAdapter object.
//     * @throws IOException if the construction doesn't work
//     */
//    public MerchantAdapter() throws IOException {
//        FileReader merchantReader = new FileReader("tcard/MerchantsData.csv");
//        MERCHANT_LIST = merchantReader.reader();
//    }
//
//    /**
//     * Inflate the layout for the list item
//     * @param parent describes the view of the item and its position in the recycler view
//     * @param viewType for different types of items in recycler list. (This is useless for us since they all look
//     *                 the same)
//     * @return a view holder object
//     */
//    @NonNull
//    @Override
//    public MerchantAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = inflater.inflate(R.layout.activity_merchant_layout, parent, false);
//        return new ViewHolder(view);
//    }
//
//    /**
//     * Configures the layouts of the merchants page. For each card in the recycler view, get the respective merchant
//     * information from the merchant database and set them to the texts in the card.
//     * @param holder the holder for each card in the recycler view.
//     * @param position the position of the merchant info in the list that we need to use to update the recycler view.
//     */
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.merchantName.setText(MERCHANT_LIST.get(position).get(0));
//        holder.merchantHours.setText(MERCHANT_LIST.get(position).get(1));
//        holder.merchantAddress.setText(MERCHANT_LIST.get(position).get(2));
//    }
//
//    /**
//     * gets the number of items in the recycler view.
//     * @return an int of the count.
//     */
//    @Override
//    public int getItemCount() {
//        return MERCHANT_LIST.size();
//    }
//
//
//}
