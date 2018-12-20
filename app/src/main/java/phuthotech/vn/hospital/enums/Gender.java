package phuthotech.vn.hospital.enums;

/**
 * Created by kingpes on 9/5/18.
 */

public enum  Gender {
    MF(10),
    Male(1),
    Female(0);

    private int type;

    public int getType(){
        return this.type;
    }

    Gender(int type){
        this.type = type;
    }

    public static Gender toType(int type){
        switch (type){
            case 0:
                return Male;
            case 1:
                return Female;
        }
        return MF;
    }

}
