package activities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import dataBase.FileReader;

import java.io.IOException;
import java.util.List;

public class MerchantAdapter extends RecyclerView.Adapter<MerchantAdapter.ViewHolder> {

    /** Declares the variables for the layouts that are used in each card of the recycler view.
     *
     */
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView merchantName, merchantHours, merchantAddress;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            merchantName = itemView.findViewById(R.id.merchantName);
            merchantHours = itemView.findViewById(R.id.merchantHours);
            merchantAddress = itemView.findViewById(R.id.merchantAddress);
        }
    }

    LayoutInflater inflater;
    private final List<List<String>> MERCHANT_LIST;

    /**
     * Constructs a MerchantAdapter object.
     * @throws IOException if the construction doesn't work
     */
    public MerchantAdapter() throws IOException {
        FileReader merchantReader = new FileReader("tcard/MerchantsData.csv");
        MERCHANT_LIST = merchantReader.reader();
    }

    /**
     * Inflate the layout for the list item
     * @param parent describes the view of the item and its position in the recycler view
     * @param viewType for different types of items in recycler list. (This is useless for us since they all look
     *                 the same)
     * @return a view holder object
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_merchant_layout, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Configures the layouts of the merchants page. For each card in the recycler view, get the respective merchant
     * information from the merchant database and set them to the texts in the card.
     * @param holder the holder for each card in the recycler view.
     * @param position the position of the merchant info in the list that we need to use to update the recycler view.
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.merchantName.setText(MERCHANT_LIST.get(position).get(0));
        holder.merchantHours.setText(MERCHANT_LIST.get(position).get(1));
        holder.merchantAddress.setText(MERCHANT_LIST.get(position).get(2));
    }

    /**
     * Called by RecyclerView when it starts observing this Adapter.
     * @param recyclerView the actual recycler view
     */
    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    /**
     * gets the number of items in the recycler view.
     * @return an int of the count.
     */
    @Override
    public int getItemCount() {
        return MERCHANT_LIST.size();
    }


}
