package id.ac.unand.pmob1311521032.pokemon;

/**
 * Created by ZikRi on 06/10/2016.
 */

public class Pokemon {
    private int _ID;
    private String Nama;
    private int ATK;
    private int HP;
    public int get_ID() {
        return _ID;
    }
    public void set_ID(int id) {
        this._ID = id;
    }
    public String getNama() {
        return Nama;
    }
    public void setNama(String nama) {
        this.Nama = nama;
    }
    public int getATK() {
        return ATK;
    }
    public void setATK(int atk) {
        this.ATK = atk;
    }
    public int getHP() {
        return HP;
    }
    public void setHP(int hp) {
        this.HP = hp;
    }
    public String toString()
    {
        return "Pokemon \nNama:"+ Nama +" \nATK:"+ ATK+ " \nHP:"+ HP;
    }
    public Pokemon(){

    }
}
