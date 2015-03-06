package hasaedu.gifted.DAL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hasaedu.gifted.Models.ArchiveYears;


/**
 * Created by Ashraf on Mar 04, 2015.
 */
public class ArchiveYearContent {

    public static List<ArchiveYears> ITEMS = new ArrayList<ArchiveYears>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, ArchiveYears> ITEM_MAP = new HashMap<String, ArchiveYears>();

    static {
        // Add 5 sample items.
        addItem(new ArchiveYears("1", "2010"));
        addItem(new ArchiveYears("2", "2011"));
        addItem(new ArchiveYears("3", "2012"));
        addItem(new ArchiveYears("4", "2013"));
        addItem(new ArchiveYears("5", "2014"));
    }

    private static void addItem(ArchiveYears item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }
}
