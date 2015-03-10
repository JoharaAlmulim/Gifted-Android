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
    public String name;
    public String email;
    public String password;
    public String passwordAgain;
    public String mobile;
    public boolean receiveSms;

    public Register(String id, String name, String email, String password, String passwordAgain, String mobile, boolean receiveSms) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.passwordAgain = passwordAgain;
        this.mobile = mobile;
        this.receiveSms = receiveSms;
    }

    @Override
    public String toString() {
        return name;
    }
}
