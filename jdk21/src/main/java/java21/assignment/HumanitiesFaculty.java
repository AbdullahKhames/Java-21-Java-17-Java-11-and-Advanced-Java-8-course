package java21.assignment;

public final class HumanitiesFaculty extends Faculty{
    public void humanities(){
        System.out.println("We teach social care, European studies etc…");
    }
    @Override
    public String toString(){
        return "Humanties";
    }
}