/*
 * Karasoft (c) 2015.
 *
 * Ashraf Ezzat
 */

package hasaedu.gifted.Models;

/**
 * Created by Ashraf on Mar 07, 2015.
 */
public class Register {

    public String id;
    public String Name;
    public String ProgramIcon;
    public String ProgramDesc;
    public String ProgramCatId;

    public Register(String id, String name, String desc, String icon, String catid) {
        this.id = id;
        this.Name = name;
        this.ProgramIcon = icon;
        this.ProgramDesc = desc;
        this.ProgramCatId = catid;
    }

    @Override
    public String toString() {
        return Name;
    }
}
