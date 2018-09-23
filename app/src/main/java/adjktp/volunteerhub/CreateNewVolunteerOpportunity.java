package adjktp.volunteerhub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import adjktp.volunteerhub.CustomObjectClasses.VolunteerOpportunity;

public class CreateNewVolunteerOpportunity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference opportunityRef = database.getReference("Opportunities");
    DatabaseReference companyRef = database.getReference("Companies");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_volunteer_opportunity);

        // make app fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        findViewById(R.id.btnPostVolunteerEvent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("sdd", "Sdsds");
                postVolunteerEventToDB();
            }
        });
    }

    private void postVolunteerEventToDB() {
        Log.e("", "Post button has been clicked");
        String uuid = UUID.randomUUID().toString();
        String companyName = "Apple Computers";
        String eventName = ((TextView) findViewById(R.id.etEventName)).getText().toString();
        String position = ((TextView) findViewById(R.id.etPosition)).getText().toString();
        String location = ((TextView) findViewById(R.id.etLocation)).getText().toString();
        String date = ((TextView) findViewById(R.id.etDate)).getText().toString();
        String startTime = ((TextView) findViewById(R.id.etStartTime)).getText().toString();
        double duration = Double.parseDouble(((TextView) findViewById(R.id.etDuration)).getText().toString());
        int numberOfAttendees = Integer.parseInt(((TextView) findViewById(R.id.etNumberOFAttending)).getText().toString());
        String description = ((TextView) findViewById(R.id.etDescription)).getText().toString();
        String skillsInfo = ((TextView) findViewById(R.id.etSkillsInfo)).getText().toString();
        int attended = 0;

        VolunteerOpportunity opportunity = new VolunteerOpportunity(uuid, companyName, eventName, position,location,duration, date, numberOfAttendees, startTime, description, skillsInfo, attended);


        opportunityRef.child(uuid).setValue(opportunity);

        // TODO: Change to acc username
        companyRef.child("applecomputers/future_events").child(uuid).setValue(opportunity);


        finish();
    }


}
