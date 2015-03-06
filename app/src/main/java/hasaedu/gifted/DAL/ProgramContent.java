package hasaedu.gifted.DAL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hasaedu.gifted.Models.Program;


/**
 * Created by Ashraf on Mar 05, 2015.
 */
public class ProgramContent {

    public static List<Program> Programs = new ArrayList<Program>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, Program> Program_MAP = new HashMap<String, Program>();

    static {
        // Add 5 sample items.
        addItem(new Program("1", "Student Program 1", "Program Description", "icon", "1"));
        addItem(new Program("2", "Student Program 2", "Program Description", "icon", "1"));
        addItem(new Program("3", "Student Program 3", "Program Description", "icon", "1"));
        addItem(new Program("4", "Student Program 4", "Program Description", "icon", "1"));
        addItem(new Program("5", "Student Program 5", "Program Description", "icon", "1"));

        addItem(new Program("6", "Parent Program 1", "Program Description", "icon", "2"));
        addItem(new Program("7", "Parent Program 2", "Program Description", "icon", "2"));
        addItem(new Program("8", "Parent Program 3", "Program Description", "icon", "2"));
        addItem(new Program("9", "Parent Program 4", "Program Description", "icon", "2"));
        addItem(new Program("10", "Parent Program 5", "Program Description", "icon", "2"));


        addItem(new Program("11", "Teacher Program 1", "Program Description", "icon", "3"));
        addItem(new Program("12", "Teacher Program 2", "Program Description", "icon", "3"));
        addItem(new Program("13", "Teacher Program 3", "Program Description", "icon", "3"));
        addItem(new Program("14", "Teacher Program 4", "Program Description", "icon", "3"));
        addItem(new Program("15", "Teacher Program 5", "Program Description", "icon", "3"));

    }

    private static void addItem(Program item) {
        Programs.add(item);
        Program_MAP.put(item.id, item);
    }

    public static ArrayList<Program> getProgramByCatId(String catid) {
        ArrayList<Program> prog = new ArrayList<Program>();

        for (Program a : Programs) {
// or equalsIgnoreCase or whatever your conditon is
            if (a.ProgramCatId.equals(catid)) {
// do something
                prog.add(a);
            }

        }
        return prog;
    }
}
