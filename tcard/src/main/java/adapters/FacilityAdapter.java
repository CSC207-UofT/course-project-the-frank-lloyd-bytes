package adapters;

import activities.R;
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
    private final ArrayList<ArrayList<String>> FACILITY_INFO;
    private final FacilitiesManager facilitiesManager;
    private final UserManager userManager;
    /**
     * Constructor for a facility adapter, pass in the facility map so the adapter can use it
     * @param facilityMap gets the facility array list from the database
     * @throws IOException if the construction doesn't work
     */
    public FacilityAdapter(ArrayList<ArrayList<String>> facilityMap, FacilitiesManager facilitiesManager,
                           UserManager userManager){
        this.FACILITY_INFO = facilityMap;
        this.facilitiesManager = facilitiesManager;
        this.userManager = userManager;
    }

    /** declares the variables for the layouts that that is used in each card in the recycler view, assigning these
     * to a variable so that we can use it later and set them to each facility's information
     * the button is also initiated and set up in this method.
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
                   if (R){
                       Toast.makeText(itemView.getContext(), "You have access to this facility, you may enter.", Toast.LENGTH_SHORT).show();
                   }
                   else{
                       Toast.makeText(itemView.getContext(), "You do not have access to this facility.", Toast.LENGTH_SHORT).show();
                   }
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
     * the database and set them to the texts
     * @param holder for each of the cards in the recycler view
     * @param position for which position in the arraylist that we need to implement in the recycler view
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = FACILITY_INFO.get(position).get(0);
        String address = FACILITY_INFO.get(position).get(1);
        String hours = FACILITY_INFO.get(position).get(3);
        ArrayList<String> facility = FACILITY_INFO.get(position);
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
        return FACILITY_INFO.size();
    }
}
