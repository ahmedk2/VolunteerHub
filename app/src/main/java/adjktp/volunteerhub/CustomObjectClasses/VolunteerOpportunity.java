package adjktp.volunteerhub.CustomObjectClasses;

public class VolunteerOpportunity {

    private String mPosition, mCompanyName, mLocation, mJobDescription, mDate;
    private double mDuration;
    private boolean mAttended;

    public VolunteerOpportunity() { }

    public VolunteerOpportunity(String position, double duration, String date,String companyName, String location, String jobDescription, boolean attended) {
        mPosition = position;
        mDuration = duration;
        mDate = date;
        mCompanyName = companyName;
        mLocation = location;
        mJobDescription = jobDescription;
        mAttended = attended;
    }

    // TODO: remove after testing
    public VolunteerOpportunity(String companyName, String position , String date, boolean attended) {
        mCompanyName = companyName;
        mPosition = position;
        mDate = date;
        mAttended = attended;
    }

    public String getmPosition() {
        return mPosition;
    }

    public void setPosition(String mPosition) {
        this.mPosition = mPosition;
    }

    public String getCompanyName() {
        return mCompanyName;
    }

    public void setCompanyName(String mCompanyName) {
        this.mCompanyName = mCompanyName;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public String getJobDescription() {
        return mJobDescription;
    }

    public void setJobDescription(String mJobDescription) {
        this.mJobDescription = mJobDescription;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String mDate) {
        this.mDate = mDate;
    }

    public double getDuration() {
        return mDuration;
    }

    public void setDuration(double mDuration) {
        this.mDuration = mDuration;
    }

    public boolean getAttended() {
        return mAttended;
    }

    public void setAttended(boolean mAttended) {
        this.mAttended = mAttended;
    }
}

