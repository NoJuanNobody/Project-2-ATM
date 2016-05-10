package io.alejandrolondono;

import java.util.ArrayList;

/**
 * Created by alejandrolondono on 5/7/16.
 */
public class ATM {

    private ArrayList<User> users = new ArrayList<User>();
    private User loggedIn;
    private boolean session = false;




    public boolean isSession() {
        return session;
    }

    public void setSession(boolean session) {
        this.session = session;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(User loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public String login(String userID, int pin){

        String msg="nothing happened.";
        if(session){
            msg = this.getLoggedIn()+" is already Logged into a session";
            return msg;
        }

        for(User user: users){

            if(user.getUserID().equalsIgnoreCase(userID) && pin == user.getPin() ){
                this.setLoggedIn(user);
                msg = user.getFirst()+" "+user.getLast()+" is now logged in this current session";
            }
        }
//        if(getLoggedIn() == null) msg = "your user Identification number or pin is invalid";
        return msg;
    }

    public String logout(){

        if(!session){
            return "already Logged out";
        }
        session = !session;
        //still does not reset variable,
        // need to rely on session bool above
        this.setLoggedIn(null);
        return "exited session, user is now logged out.";
    }
//    CLI


}
