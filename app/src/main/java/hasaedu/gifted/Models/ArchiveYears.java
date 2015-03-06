package hasaedu.gifted.Models;

/**
 * Created by Ashraf on Mar 04, 2015.
 */
public class ArchiveYears {

    public String id;
    public String YearName;

    public ArchiveYears(String id, String content) {
        this.id = id;
        this.YearName = content;
    }

    @Override
    public String toString() {
        return YearName;
    }

}
