/*
 * Karasoft (c) 2015.
 *
 * Ashraf Ezzat
 */

package hasaedu.gifted.DAL;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hasaedu.gifted.Models.CalendarEvent;
import hasaedu.gifted.Models.Program;


/**
 * Created by Ashraf on Mar 09, 2015.
 */
public class CalendarEventContent {

    public static List<CalendarEvent> CalendarEvents = new ArrayList<CalendarEvent>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, CalendarEvent> Program_MAP = new HashMap<String, CalendarEvent>();


    static {

        Calendar cal = Calendar.getInstance();


        cal.add(Calendar.DATE, -5);
        Date blueDate = cal.getTime();
        // Add 5 sample items.
        addItem(new CalendarEvent("1", "Event 1", "Event 1 Description", blueDate));
        cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        blueDate = cal.getTime();

        addItem(new CalendarEvent("2", "Event 2", "Event 2 Description", blueDate));
        cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        blueDate = cal.getTime();
        addItem(new CalendarEvent("3", "Event 2", "Event 2 Description", blueDate));
        cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 5);
        blueDate = cal.getTime();
        addItem(new CalendarEvent("4", "Event 3", "Event 3 Description", blueDate));
        cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 8);
        blueDate = cal.getTime();
        addItem(new CalendarEvent("5", "Event 4", "Event 4 Description", blueDate));


    }

    public static void addItem(CalendarEvent item) {
        CalendarEvents.add(item);
        Program_MAP.put(item.id, item);
    }

    public static Date removeTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static ArrayList<CalendarEvent> getEventByDate(Date dateid) {
        ArrayList<CalendarEvent> calevent = new ArrayList<CalendarEvent>();


        for (CalendarEvent a : CalendarEvents) {

            if (removeTime(a.eventDate).equals(removeTime(dateid))) {
                calevent.add(a);
            }
        }
        return calevent;
    }
}
