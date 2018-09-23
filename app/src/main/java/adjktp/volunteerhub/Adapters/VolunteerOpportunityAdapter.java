package adjktp.volunteerhub.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import adjktp.volunteerhub.CustomObjectClasses.VolunteerOpportunity;
import adjktp.volunteerhub.R;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class VolunteerOpportunityAdapter extends ArrayAdapter {

    public VolunteerOpportunityAdapter(Context context, ArrayList<VolunteerOpportunity> opportunities) {
        super(context, 0, opportunities);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        VolunteerOpportunity currentOpportunity = (VolunteerOpportunity) getItem(position);

        if (convertView == null) {
            LayoutInflater li =(LayoutInflater)getContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_volunteer_opportunity, parent, false);
        }

        // set ui elements
        ((TextView) convertView.findViewById(R.id.tvBigLeft)).setText(currentOpportunity.getCompanyName());
        ((TextView) convertView.findViewById(R.id.tvSmallLeft)).setText(currentOpportunity.getmPosition());
        ((TextView) convertView.findViewById(R.id.tvSmallRightTop)).setText(currentOpportunity.getDate());
        if (currentOpportunity.getAttended()) {
            ((TextView) convertView.findViewById(R.id.tvSmallRightBottom)).setText("Attended");
        } else {
            ((TextView) convertView.findViewById(R.id.tvSmallRightBottom)).setText("Not Attended");

        }

        return convertView;
    }
}
