package hasaedu.gifted.Models;

/**
 * Created by Ashraf on Mar 05, 2015.
 */
public class Program {

    public String id;
    public String ProgramName;
    public String ProgramIcon;
    public String ProgramDesc;
    public String ProgramCatId;

    public Program(String id, String content,String desc,String icon,String catid) {
        this.id = id;
        this.ProgramName = content;
        this.ProgramIcon = icon;
        this.ProgramDesc = desc;
        this.ProgramCatId = catid;
    }

    @Override
    public String toString() {
        return ProgramName;
    }

}
