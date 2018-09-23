package adjktp.volunteerhub.CustomObjectClasses;

public class VolunteerOpportunity {

    private String mEventName, mPosition, mCompanyName, mLocation, mJobDescription, mDate;
    private double mDuration;
    private int mAttended, mNumberOfAttendees;

    /**
     * date = dd/mm/yyyy
     * location = 2323 some str, city, on, ca
     * duration: x hours
     * attended => -1: did not attend/event cancelled, 0: attending/hosting, 1: attended/hosted
     */

    public VolunteerOpportunity() { }

    public VolunteerOpportunity(String eventName, String position, double duration, String date,String companyName, String location, String jobDescription, int attended, int numberOfAttendees) {
        mEventName = eventName;
        mPosition = position;
        mDuration = duration;
        mDate = date;
        mCompanyName = companyName;
        mLocation = location;
        mJobDescription = jobDescription;
        mAttended = attended;
        mNumberOfAttendees = numberOfAttendees;
    }

    // TODO: remove after testing
    public VolunteerOpportunity(String companyName, String position , String date, int attended) {
        mCompanyName = companyName;
        mPosition = position;
        mDate = date;
        mAttended = attended;
    }

    // TODO: remove after testing
    public VolunteerOpportunity(String eventName, String date , int hosted, int numberOfAttendees) {
        mEventName = eventName;
        mDate = date;
        mAttended = hosted;
        mNumberOfAttendees = numberOfAttendees;
    }

    public String getPosition() {
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

    public int getAttended() {
        return mAttended;
    }

    public void setAttended(int mAttended) {
        this.mAttended = mAttended;
    }

    public void setEventName(String eventName) {
        mEventName = eventName;
    }

    public String getEventName() {
        return mEventName;
    }

    public void setNumberOfAttendees(int numberOfAttendees) {
        mNumberOfAttendees = numberOfAttendees;
    }

    public int getNumberOfattendees() {
        return mNumberOfAttendees;
    }
}

