/*
 * Karasoft (c) 2015.
 *
 * Ashraf Ezzat
 */

package hasaedu.gifted.Models;

/**
 * Created by Ashraf on Mar 12, 2015.
 */
public class CurrentUser {
    public String name;
    public String email;
    public String apiKey;
    public String userRole;
    public String userMobile;

    public CurrentUser(String name, String email, String apikey, String userrole, String mobile) {

        this.email = email;
        this.name = name;
        this.apiKey = apikey;
        this.userRole = userrole;
        this.userMobile = mobile;

    }
}
