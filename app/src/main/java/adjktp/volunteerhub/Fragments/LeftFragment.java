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
        rootView = inflater.inflate(R.layout.fragment_left, container, false);





        startListeners();
        rootView.findViewById(R.id.btnPastEvents).callOnClick();

        return rootView;
    }

    private void startListeners() {
        // show past events
        rootView.findViewById(R.id.btnPastEvents).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ImageView) rootView.findViewById(R.id.btnFutureEvents)).setAlpha(50);
                ((ImageView) rootView.findViewById(R.id.btnPastEvents)).setAlpha(255);

                ListView lvPastOpportunities = rootView.findViewById(R.id.lvPastOpportunitiesList);

                // TODO: remove after testing
                ArrayList<VolunteerOpportunity> opportunities = new ArrayList<>();
                opportunities.add(new VolunteerOpportunity("Humber", "SOftware Engineer", "23/12/2017", true));
                opportunities.add(new VolunteerOpportunity("Thomas Cook", "Helper Engineer", "23/12/2017", true));
                opportunities.add(new VolunteerOpportunity("Burlington", "Engineer", "23/12/2017", false));
                opportunities.add(new VolunteerOpportunity("Humber", "SOftware Engineer", "23/12/2017", true));
                opportunities.add(new VolunteerOpportunity("Thomas Tuc", "Something ", "23/12/2017", true));
                opportunities.add(new VolunteerOpportunity("Humber", "SOftware Engineer", "23/12/2017", true));
                opportunities.add(new VolunteerOpportunity("Thomas Cook", "Helper Engineer", "23/12/2017", true));
                opportunities.add(new VolunteerOpportunity("Burlington", "Engineer", "23/12/2017", false));
                opportunities.add(new VolunteerOpportunity("Humber", "SOftware Engineer", "23/12/2017", true));
                opportunities.add(new VolunteerOpportunity("Thomas Tuc", "Something ", "23/12/2017", true));
                opportunities.add(new VolunteerOpportunity("Humber", "SOftware Engineer", "23/12/2017", true));
                opportunities.add(new VolunteerOpportunity("Thomas Cook", "Helper Engineer", "23/12/2017", true));
                opportunities.add(new VolunteerOpportunity("Burlington", "Engineer", "23/12/2017", false));
                opportunities.add(new VolunteerOpportunity("Humber", "SOftware Engineer", "23/12/2017", true));
                opportunities.add(new VolunteerOpportunity("Thomas Tuc", "Something ", "23/12/2017", true));
                opportunities.add(new VolunteerOpportunity("Humber", "SOftware Engineer", "23/12/2017", true));
                opportunities.add(new VolunteerOpportunity("Thomas Cook", "Helper Engineer", "23/12/2017", true));
                opportunities.add(new VolunteerOpportunity("Burlington", "Engineer", "23/12/2017", false));
                opportunities.add(new VolunteerOpportunity("Humber", "SOftware Engineer", "23/12/2017", true));
                opportunities.add(new VolunteerOpportunity("Thomas Tuc", "Something ", "23/12/2017", true));

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
                opportunities.add(new VolunteerOpportunity("Thomas Cook", "Helper Engineer", "23/12/2017", true));
                opportunities.add(new VolunteerOpportunity("Burlington", "Engineer", "23/12/2017", false));
                opportunities.add(new VolunteerOpportunity("Humber", "SOftware Engineer", "23/12/2017", true));
                opportunities.add(new VolunteerOpportunity("Thomas Tuc", "Something ", "23/12/2017", true));

                VolunteerOpportunityAdapter volunteerOpportunityAdapter = new VolunteerOpportunityAdapter(getContext(), opportunities);
                lvPastOpportunities.setAdapter(volunteerOpportunityAdapter);
            }
        });
    }


}



















