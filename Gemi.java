import java.util.List;

public class Gemi {
    String gemi_tipi;
    String gemi_adi;
    String gemi_kodu;
    List<String> gemi_guverte_silahlari;
    int murettebat_sayisi;
    int silah_sayisi;
    int zirh;
    double kritik_hasar_olasiligi;
    int kritik_hasar_carpani;
    int saglik;

    public Gemi(String gemi_tipi, String gemi_adi, String gemi_kodu, List<String> gemi_guverte_silahlari, int murettebat_sayisi, int silah_sayisi, int zirh, double kritik_hasar_olasiligi, int kritik_hasar_carpani) {
        this.gemi_tipi = gemi_tipi;
        this.gemi_adi = gemi_adi;
        this.gemi_kodu = gemi_kodu;
        this.gemi_guverte_silahlari = gemi_guverte_silahlari;
        this.murettebat_sayisi = murettebat_sayisi;
        this.silah_sayisi = silah_sayisi;
        this.zirh = zirh;
        this.kritik_hasar_olasiligi = kritik_hasar_olasiligi;
        this.kritik_hasar_carpani = kritik_hasar_carpani;
        this.saglik = saglik;
    }

    public String getGemiTipi() {
        return gemi_tipi;
    }

    public String getGemiAdi() {
        return gemi_adi;
    }

    public String getGemiKodu() {
        return gemi_kodu;
    }

    public List<String> getGemiGuverteSilahlari() {
        return gemi_guverte_silahlari;
    }

    public int getMurettebatSayisi() {
        return murettebat_sayisi;
    }

    public int getSilahSayisi() {
        return silah_sayisi;
    }

    public int getZirh() {
        return zirh;
    }

    public double getKritikHasarOlasiligi() {
        return kritik_hasar_olasiligi;
    }

    public int getKritikHasarCarpani() {
        return kritik_hasar_carpani;
    }

    public void setZirh(int zirh) {
        this.zirh = zirh;
    }

    public void setKritikHasarOlasiligi(double kritik_hasar_olasiligi) {
        this.kritik_hasar_olasiligi = kritik_hasar_olasiligi;
    }

    public void setKritikHasarCarpani(int kritik_hasar_carpani) {
        this.kritik_hasar_carpani = kritik_hasar_carpani;
    }

    public int hasaralma(int saldirigucu) {
        saglik -= silah_sayisi * kritik_hasar_olasiligi * kritik_hasar_carpani * silah_sayisi;
        return saglik;
        if (can < 0) {
            can = 0;
        }

}

public abstract void saldir(Gemi hedefGemi);
public abstract void kritik_hasar(int hasar);
