/*
 * Karasoft (c) 2015.
 *
 * Ashraf Ezzat
 */

package hasaedu.gifted.Models;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Ashraf on Mar 07, 2015.
 */
public class CalendarEvent {

    public String id;
    public String eventTitle;
    public String eventDesc;
    public Date eventDate;


    public CalendarEvent(String id, String eventTitle, String eventDesc, Date eventDate) {
        this.id = id;
        this.eventTitle = eventTitle;
        this.eventDesc = eventDesc;
        this.eventDate = eventDate;
    }

    public Calendar getAsCalendar() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(eventDate);

        return cal;
    }

    public Date getDateNoTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(eventDate);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }


    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
        return eventTitle + "(" + formatter.format(eventDate) + ")";
    }

}
