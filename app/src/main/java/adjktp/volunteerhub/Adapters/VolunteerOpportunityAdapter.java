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
import java.util.Random;

import adjktp.volunteerhub.CustomObjectClasses.VolunteerOpportunity;
import adjktp.volunteerhub.R;
import adjktp.volunteerhub.SQLiteFiles.DatabaseHelper;

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

        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        if (dbHelper.getValue("userIsVolunteer") == "1") {
            // set ui for volunteer
            // set ui elements
            ((TextView) convertView.findViewById(R.id.tvBigLeft)).setText(currentOpportunity.getCompanyName());
            ((TextView) convertView.findViewById(R.id.tvSmallLeft)).setText(currentOpportunity.getPosition());
            ((TextView) convertView.findViewById(R.id.tvSmallRightTop)).setText(currentOpportunity.getDate());
            if (currentOpportunity.getAttended() == 1) {
                ((TextView) convertView.findViewById(R.id.tvSmallRightBottom)).setText("Attended");
            } else if (currentOpportunity.getAttended() == 0) {
                ((TextView) convertView.findViewById(R.id.tvSmallRightBottom)).setText("Attending");
            } else {
                ((TextView) convertView.findViewById(R.id.tvSmallRightBottom)).setText("Not Attended");
            }

        }else {
            // set ui for company
            // TODO: remove for prod
            Random random = new Random();
            ((TextView) convertView.findViewById(R.id.tvBigLeft)).setText(currentOpportunity.getEventName());
            ((TextView) convertView.findViewById(R.id.tvSmallLeft)).setText(currentOpportunity.getDate());
            ((TextView) convertView.findViewById(R.id.tvSmallRightTop)).setText(currentOpportunity.getNumberOfattendees() + "/"+ random.nextInt(500) + " attended");
            if (currentOpportunity.getAttended() == 1) {
                ((TextView) convertView.findViewById(R.id.tvSmallRightBottom)).setText("Hosted");
            } else if (currentOpportunity.getAttended() == 0) {
                ((TextView) convertView.findViewById(R.id.tvSmallRightBottom)).setText("Hosting");
            } else {
                ((TextView) convertView.findViewById(R.id.tvSmallRightBottom)).setText("Not Hosted");

            }

        }



        return convertView;
    }
}
