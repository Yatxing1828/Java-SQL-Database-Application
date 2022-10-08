package Database_Proj;

public class AnyRes {
    int user_id;
    int profile_id;

    public AnyRes(int user_id, int profile_id) {
        this.user_id = user_id;
        this.profile_id = profile_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getProfile_id() {
        return profile_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id; 
    }
    public void setProfile_id(int profile_id) {
        this.profile_id = profile_id;
    }
}
