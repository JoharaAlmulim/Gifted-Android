package hasaedu.gifted.DAL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import hasaedu.gifted.Models.ProgramCategory;

/**
 * Created by Ashraf on Mar 04, 2015.
 */
public class ProgramCategoryContent {

    public static List<ProgramCategory> ProgramCategories = new ArrayList<ProgramCategory>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, ProgramCategory> ProgramCategory_MAP = new HashMap<String, ProgramCategory>();

    static {
        // Add 5 sample items.
        addItem(new ProgramCategory("1", "Student"));
        addItem(new ProgramCategory("2", "Parent"));
        addItem(new ProgramCategory("3", "Teacher"));

    }

    private static void addItem(ProgramCategory item) {
        ProgramCategories.add(item);
        ProgramCategory_MAP.put(item.id, item);
    }
}
