package io.alejandrolondono;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by alejandrolondono on 5/7/16.
 */
public class User {

    ArrayList<Account> accounts = new ArrayList<Account>();
    String first;
    String last;
    String userId = "U"+UUID.randomUUID().toString();



}
