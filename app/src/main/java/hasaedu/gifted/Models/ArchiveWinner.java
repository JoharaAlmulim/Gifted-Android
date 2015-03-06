package hasaedu.gifted.Models;

/**
 * Created by Ashraf on Mar 06, 2015.
 */
public class ArchiveWinner {

    public String id;
    public String WinnerName;
    public String WinnerInfo;
    public String ProjectTitle;
    public String ProjectDesc;
    public String WinnerEmail;
    public String ArchiveYearId;


    public ArchiveWinner(String id, String WinnerName,String WinnerInfo,String ProjectTitle,String ProjectDesc,String WinnerEmail,String ArchiveYearId) {
        this.id = id;
        this.WinnerName = WinnerName;
        this.WinnerInfo = WinnerInfo;
        this.ProjectTitle = ProjectTitle;
        this.ProjectDesc = ProjectDesc;
        this.WinnerEmail = WinnerEmail;
        this.ArchiveYearId = ArchiveYearId;
    }

    @Override
    public String toString() {
        return WinnerName;
    }
}
