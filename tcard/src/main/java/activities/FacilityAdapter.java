package activities;

import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import controllers.FacilitiesManager;
import controllers.UserManager;

import java.io.IOException;
import java.util.ArrayList;

public class FacilityAdapter extends RecyclerView.Adapter<FacilityAdapter.ViewHolder> {
    private ArrayList<ArrayList<String>> facilityInfo;
    private FacilitiesManager facilitiesManager;
    private UserManager userManager;
    /**
     * Constructor for a facility adapter, pass in the facility map so the adapter can use it
     * @param facilityMap gets the facility array list from the database
     * @throws IOException if the construction doesn't work
     */
    public FacilityAdapter(ArrayList<ArrayList<String>> facilityMap, FacilitiesManager facilitiesManager,
                           UserManager userManager){
        this.facilityInfo = facilityMap;
        this.facilitiesManager = facilitiesManager;
        this.userManager = userManager;
    }

    /** declares the variables for the layouts that that is used in each card in the recycler view, assigning these
     * to a variable so that we can use it later and set them to each facility's information
     *
     */
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView facilityName, facilityHours, facilityAddress;
        ArrayList<String> facility;

        public ViewHolder(final View itemView) {
            super(itemView);
            facilityName = itemView.findViewById(R.id.facilityName);
            facilityAddress = itemView.findViewById(R.id.facilityAddress);
            facilityHours = itemView.findViewById(R.id.facilityHours);

            itemView.findViewById(R.id.checkFacilityAccess).setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   String name = facilityName.getText().toString();
                   Boolean R = facilitiesManager.evaluateHelper(userManager.getUser(),
                           facilitiesManager.getFacility(name));
                   Toast.makeText(itemView.getContext(), facility.get(0), Toast.LENGTH_SHORT).show();
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
        ArrayList<String> facility = facilityInfo.get(position);

        holder.facilityName.setText(name);
        holder.facilityAddress.setText(address);
        holder.facilityHours.setText(hours);
        holder.facility = facility;

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
