package Seminar6;

public class WebFramework {
    void save(Comp comp){
        ISQL db = new MySQL();
        db.save();
    }
}
