package LogicBehind;

public class WrongMoveException extends RuntimeException{
    public WrongMoveException(String msg){
        super(msg);
    }
}

// So im actually building this to insert it in my main
// This way I can control the possiblity of the user to choose : so if for example the player says : dhjkashd instead of Hit or Stand
// then an error would be received so it can't insert anything except that one.
// This way tho it doesn't work like I want it to work

/*public class WrongMoveException extends RuntimeException{
    public WrongMoveException(String msg){
        super(msg);
    }
}
 */

// should I implement the check also in the main ?? , or should it be done here ?