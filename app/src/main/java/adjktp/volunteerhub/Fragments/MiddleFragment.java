package adjktp.volunteerhub.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import adjktp.volunteerhub.Adapters.VolunteerOpportunityAdapter;
import adjktp.volunteerhub.CreateNewVolunteerOpportunity;
import adjktp.volunteerhub.CustomObjectClasses.VolunteerOpportunity;
import adjktp.volunteerhub.R;
import adjktp.volunteerhub.SQLiteFiles.DatabaseHelper;

public class MiddleFragment extends Fragment {

    // widgets
    private View rootView;

    public MiddleFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_past_future_events, container, false);

        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        if (dbHelper.getValue("userIsVolunteer") == "1") {
            // design ui for volunteer


        } else {
            // design ui for company: pull in future events
            createUIForCompany();
        }

        return rootView;
    }

    private void createUIForCompany() {
        rootView.findViewById(R.id.btnPastEvents).setVisibility(View.GONE);
        rootView.findViewById(R.id.btnFutureEvents).setVisibility(View.GONE);

        // listener for creating new opportunities
        ((ImageView) rootView.findViewById(R.id.btnAddNewEvents)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), CreateNewVolunteerOpportunity.class);
                startActivity(i);
            }
        });


        ArrayList<VolunteerOpportunity> opportunities = new ArrayList<>();
        opportunities.add(new VolunteerOpportunity("Local Reading", "23/2/2019", 0, 9));
        opportunities.add(new VolunteerOpportunity("Something about cleing", "23/9/2019", 0, 98));
        opportunities.add(new VolunteerOpportunity("Hello Smile", "23/6/2019", 0, 132));
        opportunities.add(new VolunteerOpportunity("Something iniovative", "23/10/2019", 0, 56));


        ListView employerPastEvents = rootView.findViewById(R.id.lvPastOpportunitiesList);
        VolunteerOpportunityAdapter adapter = new VolunteerOpportunityAdapter(getContext(), opportunities);
        employerPastEvents.setAdapter(adapter);
    }
}
