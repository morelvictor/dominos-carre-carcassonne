package model;

public class SideCarcassonne extends Side{
    Sike sike;
    public boolean partisan;

    public enum Sike { 
        CHEMIN("c"), PRE("p"), VILLE("v");
        String value;
        private Sike(String v){
            value = v;
        }
        
    }

    public void setPartisan(boolean partisan) {
        this.partisan = partisan;
    }

    public boolean getPartisan(){
        return partisan;
    }

    public SideCarcassonne(Sike s){
        sike = s;
        partisan = false;
    }

    @Override
    public void revert() {
    }


    @Override
    public int getPoints(Side o) {
        if(o instanceof SideCarcassonne){
            if(((SideCarcassonne)o).sike == this.sike) return 0;
        }
        return -1;
    }

}
