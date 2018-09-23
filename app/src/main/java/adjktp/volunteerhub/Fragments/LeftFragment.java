package adjktp.volunteerhub.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import adjktp.volunteerhub.Adapters.VolunteerOpportunityAdapter;
import adjktp.volunteerhub.CustomObjectClasses.VolunteerOpportunity;
import adjktp.volunteerhub.R;
import adjktp.volunteerhub.SQLiteFiles.DatabaseHelper;

import static android.content.ContentValues.TAG;

public class LeftFragment extends Fragment {

    // widgets
    private View rootView;

    // firebase widgets
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    // TODO: FIREBAEE USER
    DatabaseReference pastEventsCompanyRef = db.getReference("Companies/applecomputers/past_events");
    DatabaseReference futureEventsCompanyRef = db.getReference("Companies/applecomputers/past_events");
    DatabaseReference opportunitiesRef = db.getReference("Opportunities");

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
            //createUIForVolunteer()
            startListenersForVolunteer();
        }else {
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



//                // TODO: remove after testing
//                opportunities.add(new VolunteerOpportunity("Thomas Cook", "Helper Engineer", "23/12/2017", 0));
//                opportunities.add(new VolunteerOpportunity("Burlington", "Engineer", "23/12/2017", 0));
//                opportunities.add(new VolunteerOpportunity("Humber", "SOftware Engineer", "23/12/2017", 0));
//                opportunities.add(new VolunteerOpportunity("Thomas Tuc", "Something ", "23/12/2017", 0));

            }
        });
    }

    private void createUIForCompany() {
        rootView.findViewById(R.id.btnPastEvents).setVisibility(View.GONE);
        rootView.findViewById(R.id.btnAddNewEvents).setVisibility(View.GONE);
        rootView.findViewById(R.id.btnFutureEvents).setVisibility(View.GONE);

        pastEventsCompanyRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<VolunteerOpportunity> vo = new ArrayList<>();
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Log.e(TAG, "onDataChange: "+child.getValue());
                    vo.add(child.getValue(VolunteerOpportunity.class));
                }
                ListView lv = rootView.findViewById(R.id.lvPastOpportunitiesList);
                VolunteerOpportunityAdapter vd = new VolunteerOpportunityAdapter(getContext(), vo);
                lv.setAdapter(vd);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });

    }


}



















