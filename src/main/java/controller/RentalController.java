package controller;

import model.Penyewa;
import model.StreetSkate;
import model.CruiserSkate;
import java.util.ArrayList;

public class RentalController {
    private ArrayList<Penyewa> daftarRental = new ArrayList<>();

    public RentalController() {
        tambahData(new Penyewa("RNT-01", "Farel Wijaya", 2, 
            new StreetSkate("SKT-01", "Element", 50000, "52mm")));
        tambahData(new Penyewa("RNT-02", "Budi Santoso", 3, 
            new CruiserSkate("CRS-01", "Penny Board", 45000, "27 inch")));
    }

    public boolean isIdAda(String idRental) {
        for (Penyewa p : daftarRental) {
            if (p.getIdRental().equalsIgnoreCase(idRental)) return true;
        }
        return false;
    }

    public void tambahData(Penyewa p) {
        daftarRental.add(p);
        p.konfirmasiPenyewaan();
    }

    public ArrayList<Penyewa> getDaftarRental() {
        return daftarRental;
    }

    public boolean updateLamaSewa(String idRental, int lamaBaru) {
        for (Penyewa p : daftarRental) {
            if (p.getIdRental().equalsIgnoreCase(idRental)) {
                p.setLamaSewa(lamaBaru);
                return true;
            }
        }
        return false;
    }

    public boolean hapusData(String idRental) {
        return daftarRental.removeIf(p -> p.getIdRental().equalsIgnoreCase(idRental));
    }
}