package activities;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import usecases.FacilityMap;
import controllers.FacilityManager;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FacilityAdapter extends RecyclerView.Adapter<FacilityAdapter.ViewHolder> {
    private ArrayList<ArrayList<String>> facilityInfo;
    /**
     * Constructor for a facility adapter, pass in the facility map so the adapter can use it
     * @param facilityMap gets the facility array list from the database
     * @throws IOException if the construction doesn't work
     */
    public FacilityAdapter(ArrayList<ArrayList<String>> facilityMap){
        facilityInfo = facilityMap;
    }

    /** declares the variables for the layouts that that is used in each card in the recycler view, assigning these
     * to a variable so that we can use it later and set them to each facility's information
     *
     */
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView facilityName, facilityHours, facilityAddress;

        public ViewHolder(final View itemView) {
            super(itemView);
            facilityName = itemView.findViewById(R.id.facilityName);
            facilityAddress = itemView.findViewById(R.id.facilityAddress);
            facilityHours = itemView.findViewById(R.id.facilityHours);
        }
    }

    FacilityManager facilityManager;
    {
        try {
            facilityManager = new FacilityManager();
        } catch (IOException e) {
            e.printStackTrace();
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
    public FacilityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_facility_layout, parent, false);
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
        String name = facilityInfo.get(position).get(0);
        String address = facilityInfo.get(position).get(1);
        String hours = facilityInfo.get(position).get(3);

        holder.facilityName.setText(name);
        holder.facilityAddress.setText(address);
        holder.facilityHours.setText(hours);
    }

    /**
     * gets the item of the recycler view, or the database
     * @return an int of the count
     */
    @Override
    public int getItemCount() {
        return facilityInfo.size();
    }


}
