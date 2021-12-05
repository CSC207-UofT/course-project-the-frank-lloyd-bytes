package activities;

import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import controllers.MerchantManager;

import java.io.IOException;

public class MerchantAdapter extends RecyclerView.Adapter<MerchantAdapter.ViewHolder> {
    private final MerchantManager MERCHANT_MANAGER;

    /**
     * Constructs a MerchantAdapter object.
     * @param merchantManager a MerchantManager instance.
     * @throws IOException if the construction doesn't work
     */
    public MerchantAdapter(MerchantManager merchantManager) throws IOException {
        MERCHANT_MANAGER = merchantManager;
    }

    /** Declare the variables for the layouts that are used in each card of the recycler view. Assign these
     * to a variable for later use.
     *
     */
    public class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView name, address, hours;

        public ViewHolder(final View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.merchantName);
            address = itemView.findViewById(R.id.merchantAddress);
            hours = itemView.findViewById(R.id.merchantHours);

            itemView.findViewById(R.id.seeMerchantDiscounts).setOnClickListener(v -> {
                String applicableDiscounts = MERCHANT_MANAGER.checkApplicableDiscounts(name.getText().toString());

//                Toast.makeText(itemView.getContext(), applicableDiscounts, Toast.LENGTH_SHORT).show();
                Snackbar mySnackbar = Snackbar.make(v, applicableDiscounts, Snackbar.LENGTH_LONG);
                mySnackbar.show();

            });
        }
    }

    /**
     * Inflate the layout for the list item
     * @param parent describes the view of the item and its position in the recycler view
     * @param viewType for different types of items in recycler list, this is useless for us since they all look
     *                 the same
     * @return a viewholder object
     */
    @NonNull
    @Override
    public MerchantAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_merchant_layout, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Configuring the layouts of the merchants page. For each card view in recycler view, get the information from the
     * database and set them to the texts.
     * @param holder for each of the cards in the recycler view
     * @param position for which position in the arraylist that we need to implement in the recycler view
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String addressString = "Address: " + MERCHANT_MANAGER.getMerchantList().get(position).get(1);
        String hoursString = "Hours: " + MERCHANT_MANAGER.getMerchantList().get(position).get(2);

        holder.name.setText(MERCHANT_MANAGER.getMerchantList().get(position).get(0));
        holder.address.setText(addressString);
        holder.hours.setText(hoursString);
    }

    /**
     * Gets the number of items in the recycler view.
     * @return an int of the count
     */
    @Override
    public int getItemCount() {
        return MERCHANT_MANAGER.getMerchantList().size();
    }
}
