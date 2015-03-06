package hasaedu.gifted.Models;

/**
 * Created by Ashraf on Mar 04, 2015.
 */
public class ProgramCategory {

    public String id;
    public String CatName;

    public ProgramCategory(String id, String content) {
        this.id = id;
        this.CatName = content;
    }

    @Override
    public String toString() {
        return CatName;
    }

}

