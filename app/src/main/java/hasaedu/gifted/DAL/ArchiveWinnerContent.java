package hasaedu.gifted.DAL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hasaedu.gifted.Models.ArchiveWinner;


/**
 * Created by Ashraf on Mar 06, 2015.
 */
public class ArchiveWinnerContent {

    public static List<ArchiveWinner> ArchiveWinners = new ArrayList<ArchiveWinner>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, ArchiveWinner> ArchiveWinners_MAP = new HashMap<String, ArchiveWinner>();

    static {
        // Add 5 sample items.
        addItem(new ArchiveWinner("1", "Winner 1", "Winner 1 Information data", "Project 1 Name", "Project 1 Information", "winner1@archivewinners.com", "1"));
        addItem(new ArchiveWinner("1", "Winner 1", "Winner 2 Information data", "Project 2 Name", "Project 2 Information", "winner1@archivewinners.com", "1"));
        addItem(new ArchiveWinner("1", "Winner 3", "Winner 3 Information data", "Project 3 Name", "Project 3 Information", "winner1@archivewinners.com", "1"));
        addItem(new ArchiveWinner("1", "Winner 4", "Winner 4 Information data", "Project 4 Name", "Project 4 Information", "winner1@archivewinners.com", "1"));
        addItem(new ArchiveWinner("1", "Winner 5", "Winner 5 Information data", "Project 5 Name", "Project 5 Information", "winner1@archivewinners.com", "1"));

        addItem(new ArchiveWinner("1", "Winner 1", "Winner 1 Information data", "Project 1 Name", "Project 1 Information", "winner1@archivewinners.com", "2"));
        addItem(new ArchiveWinner("1", "Winner 1", "Winner 2 Information data", "Project 2 Name", "Project 2 Information", "winner1@archivewinners.com", "2"));
        addItem(new ArchiveWinner("1", "Winner 3", "Winner 3 Information data", "Project 3 Name", "Project 3 Information", "winner1@archivewinners.com", "2"));
        addItem(new ArchiveWinner("1", "Winner 4", "Winner 4 Information data", "Project 4 Name", "Project 4 Information", "winner1@archivewinners.com", "2"));
        addItem(new ArchiveWinner("1", "Winner 5", "Winner 5 Information data", "Project 5 Name", "Project 5 Information", "winner1@archivewinners.com", "2"));


        addItem(new ArchiveWinner("1", "Winner 1", "Winner 1 Information data", "Project 1 Name", "Project 1 Information", "winner1@archivewinners.com", "3"));
        addItem(new ArchiveWinner("1", "Winner 1", "Winner 2 Information data", "Project 2 Name", "Project 2 Information", "winner1@archivewinners.com", "3"));
        addItem(new ArchiveWinner("1", "Winner 3", "Winner 3 Information data", "Project 3 Name", "Project 3 Information", "winner1@archivewinners.com", "3"));
        addItem(new ArchiveWinner("1", "Winner 4", "Winner 4 Information data", "Project 4 Name", "Project 4 Information", "winner1@archivewinners.com", "3"));
        addItem(new ArchiveWinner("1", "Winner 5", "Winner 5 Information data", "Project 5 Name", "Project 5 Information", "winner1@archivewinners.com", "3"));

        addItem(new ArchiveWinner("1", "Winner 1", "Winner 1 Information data", "Project 1 Name", "Project 1 Information", "winner1@archivewinners.com", "4"));
        addItem(new ArchiveWinner("1", "Winner 1", "Winner 2 Information data", "Project 2 Name", "Project 2 Information", "winner1@archivewinners.com", "4"));
        addItem(new ArchiveWinner("1", "Winner 3", "Winner 3 Information data", "Project 3 Name", "Project 3 Information", "winner1@archivewinners.com", "4"));
        addItem(new ArchiveWinner("1", "Winner 4", "Winner 4 Information data", "Project 4 Name", "Project 4 Information", "winner1@archivewinners.com", "4"));
        addItem(new ArchiveWinner("1", "Winner 5", "Winner 5 Information data", "Project 5 Name", "Project 5 Information", "winner1@archivewinners.com", "4"));

        addItem(new ArchiveWinner("1", "Winner 1", "Winner 1 Information data", "Project 1 Name", "Project 1 Information", "winner1@archivewinners.com", "5"));
        addItem(new ArchiveWinner("1", "Winner 1", "Winner 2 Information data", "Project 2 Name", "Project 2 Information", "winner1@archivewinners.com", "5"));
        addItem(new ArchiveWinner("1", "Winner 3", "Winner 3 Information data", "Project 3 Name", "Project 3 Information", "winner1@archivewinners.com", "5"));
        addItem(new ArchiveWinner("1", "Winner 4", "Winner 4 Information data", "Project 4 Name", "Project 4 Information", "winner1@archivewinners.com", "5"));
        addItem(new ArchiveWinner("1", "Winner 5", "Winner 5 Information data", "Project 5 Name", "Project 5 Information", "winner1@archivewinners.com", "5"));

    }

    private static void addItem(ArchiveWinner item) {
        ArchiveWinners.add(item);
        ArchiveWinners_MAP.put(item.id, item);
    }

    public static ArrayList<ArchiveWinner> getWinnerByYearId(String yearid) {
        ArrayList<ArchiveWinner> winners = new ArrayList<ArchiveWinner>();

        for (ArchiveWinner a : ArchiveWinners) {
// or equalsIgnoreCase or whatever your conditon is
            if (a.ArchiveYearId.equals(yearid)) {
// do something
                winners.add(a);
            }

        }
        return winners;
    }

}
