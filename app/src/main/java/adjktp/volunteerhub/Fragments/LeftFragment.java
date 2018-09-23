package adjktp.volunteerhub.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import adjktp.volunteerhub.Adapters.VolunteerOpportunityAdapter;
import adjktp.volunteerhub.CustomObjectClasses.VolunteerOpportunity;
import adjktp.volunteerhub.R;
import adjktp.volunteerhub.SQLiteFiles.DatabaseHelper;

public class LeftFragment extends Fragment {

    //widgets
    private View rootView;

    public LeftFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_past_future_events, container, false);

        // find ouot user type
        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        if (dbHelper.getValue("userIsVolunteer") == "1") {
            // make ui for volunteer
            //createUIForVolunteer()
            startListenersForVolunteer();

        }else {
            // make ui for company
            createUIForCompany();

        }

        rootView.findViewById(R.id.btnPastEvents).callOnClick();

        return rootView;
    }

    private void startListenersForVolunteer() {
        // show past events
        rootView.findViewById(R.id.btnPastEvents).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ImageView) rootView.findViewById(R.id.btnFutureEvents)).setAlpha(50);
                ((ImageView) rootView.findViewById(R.id.btnPastEvents)).setAlpha(255);

                ListView lvPastOpportunities = rootView.findViewById(R.id.lvPastOpportunitiesList);

                // TODO: remove after testing
                ArrayList<VolunteerOpportunity> opportunities = new ArrayList<>();
                opportunities.add(new VolunteerOpportunity("Humber", "SOftware Engineer", "23/12/2017", 1));
                opportunities.add(new VolunteerOpportunity("Thomas Cook", "Helper Engineer", "23/12/2017", 1));
                opportunities.add(new VolunteerOpportunity("Burlington", "Engineer", "23/12/2017", 1));
                opportunities.add(new VolunteerOpportunity("Humber", "SOftware Engineer", "23/12/2017", 0));
                opportunities.add(new VolunteerOpportunity("Thomas Tuc", "Something ", "23/12/2017", 1));
                opportunities.add(new VolunteerOpportunity("Humber", "SOftware Engineer", "23/12/2017", 0));
                opportunities.add(new VolunteerOpportunity("Thomas Cook", "Helper Engineer", "23/12/2017", 1));
                opportunities.add(new VolunteerOpportunity("Burlington", "Engineer", "23/12/2017", 1));
                opportunities.add(new VolunteerOpportunity("Humber", "SOftware Engineer", "23/12/2017", 1));
                opportunities.add(new VolunteerOpportunity("Thomas Tuc", "Something ", "23/12/2017", 1));
                opportunities.add(new VolunteerOpportunity("Humber", "SOftware Engineer", "23/12/2017", 1));
                opportunities.add(new VolunteerOpportunity("Thomas Cook", "Helper Engineer", "23/12/2017", 1));
                opportunities.add(new VolunteerOpportunity("Burlington", "Engineer", "23/12/2017", 1));
                opportunities.add(new VolunteerOpportunity("Humber", "SOftware Engineer", "23/12/2017", 1));
                opportunities.add(new VolunteerOpportunity("Thomas Tuc", "Something ", "23/12/2017", 1));
                opportunities.add(new VolunteerOpportunity("Humber", "SOftware Engineer", "23/12/2017", 0));
                opportunities.add(new VolunteerOpportunity("Thomas Cook", "Helper Engineer", "23/12/2017", 0));
                opportunities.add(new VolunteerOpportunity("Burlington", "Engineer", "23/12/2017", 0));
                opportunities.add(new VolunteerOpportunity("Humber", "SOftware Engineer", "23/12/2017", 1));
                opportunities.add(new VolunteerOpportunity("Thomas Tuc", "Something ", "23/12/2017", 0));

                VolunteerOpportunityAdapter volunteerOpportunityAdapter = new VolunteerOpportunityAdapter(getContext(), opportunities);

                lvPastOpportunities.setAdapter(volunteerOpportunityAdapter);
            }
        });

        // show future events
        rootView.findViewById(R.id.btnFutureEvents).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ImageView) rootView.findViewById(R.id.btnPastEvents)).setImageAlpha(50);
                ((ImageView) rootView.findViewById(R.id.btnFutureEvents)).setImageAlpha(255);

                ListView lvPastOpportunities = rootView.findViewById(R.id.lvPastOpportunitiesList);


                // TODO: remove after testing
                ArrayList<VolunteerOpportunity> opportunities = new ArrayList<>();
                opportunities.add(new VolunteerOpportunity("Thomas Cook", "Helper Engineer", "23/12/2017", 0));
                opportunities.add(new VolunteerOpportunity("Burlington", "Engineer", "23/12/2017", 0));
                opportunities.add(new VolunteerOpportunity("Humber", "SOftware Engineer", "23/12/2017", 0));
                opportunities.add(new VolunteerOpportunity("Thomas Tuc", "Something ", "23/12/2017", 0));

                VolunteerOpportunityAdapter volunteerOpportunityAdapter = new VolunteerOpportunityAdapter(getContext(), opportunities);
                lvPastOpportunities.setAdapter(volunteerOpportunityAdapter);
            }
        });
    }

    private void createUIForCompany() {
        rootView.findViewById(R.id.btnPastEvents).setVisibility(View.GONE);
        rootView.findViewById(R.id.btnAddNewEvents).setVisibility(View.GONE);
        rootView.findViewById(R.id.btnFutureEvents).setVisibility(View.GONE);


        ArrayList<VolunteerOpportunity> opportunities = new ArrayList<>();
        opportunities.add(new VolunteerOpportunity("Lg", "23/6/2019", 1, 132));
        opportunities.add(new VolunteerOpportunity("Local Reading", "23/2/2019", 1, 9));
        opportunities.add(new VolunteerOpportunity("Act", "23/9/2019", -1, 98));
        opportunities.add(new VolunteerOpportunity("Local Reading", "23/2/2019", -1, 9));
        opportunities.add(new VolunteerOpportunity("Act", "23/9/2019", 1, 98));
        opportunities.add(new VolunteerOpportunity("Lg", "23/6/2019", 1, 132));
        opportunities.add(new VolunteerOpportunity("Something iniovative", "23/10/2019", -1, 56));


        ListView employerPastEvents = rootView.findViewById(R.id.lvPastOpportunitiesList);
        VolunteerOpportunityAdapter adapter = new VolunteerOpportunityAdapter(getContext(), opportunities);
        employerPastEvents.setAdapter(adapter);
    }


}



















