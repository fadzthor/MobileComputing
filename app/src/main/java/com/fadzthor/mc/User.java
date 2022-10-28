package com.fadzthor.mc;

public class User {
//    private String npm,nama,prodi;
    public String npm;
    public String nama;
    public String prodi;

    public User(){
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String npm, String nama, String prodi){
        this.npm = npm;
        this.nama = nama;
        this.prodi = prodi;
    }

    public String getNpm() {
        return npm;
    }

    public String getNama() {
        return nama;
    }

    public String getProdi() {
        return prodi;
    }
}

