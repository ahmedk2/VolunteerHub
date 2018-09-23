package adjktp.volunteerhub.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import adjktp.volunteerhub.CreateNewVolunteerOpportunity;
import adjktp.volunteerhub.CustomObjectClasses.VolunteerOpportunity;
import adjktp.volunteerhub.R;
import adjktp.volunteerhub.SQLiteFiles.DatabaseHelper;

import static android.content.ContentValues.TAG;

public class MiddleFragment extends Fragment {


    // firebase widgets
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference futureEventsCompanyRef = db.getReference("Companies/applecomputers/future_events");

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
        if (dbHelper.getValue("userIsVolunteer").equals("1")) {
            // design ui for volunteer
            createUIForVolunteer();

        } else {
            // design ui for company: pull in future events
            createUIForCompany();
        }

        return rootView;
    }

    private void createUIForVolunteer() {
        rootView.findViewById(R.id.btnPastEvents).setVisibility(View.GONE);
        rootView.findViewById(R.id.btnAddNewEvents).setVisibility(View.GONE);
        rootView.findViewById(R.id.btnFutureEvents).setVisibility(View.GONE);
    }

    private void createUIForCompany() {
        rootView.findViewById(R.id.btnPastEvents).setVisibility(View.INVISIBLE);
        rootView.findViewById(R.id.btnFutureEvents).setVisibility(View.INVISIBLE);

        // listener for creating new opportunities
        ((ImageView) rootView.findViewById(R.id.btnAddNewEvents)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), CreateNewVolunteerOpportunity.class);
                startActivity(i);
            }
        });

        futureEventsCompanyRef.addValueEventListener(new ValueEventListener() {
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
