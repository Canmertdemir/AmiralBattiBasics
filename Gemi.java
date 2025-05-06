import java.util.List;

public abstract class Gemi {
    protected String gemi_tipi;
    protected String gemi_adi;
    protected String gemi_kodu;
    protected List<String> gemi_guverte_silahlari;
    protected int murettebat_sayisi;
    protected int silah_sayisi;
    protected int zirh;
    protected double kritik_hasar_olasiligi;
    protected int kritik_hasar_carpani;
    protected int saglik;

    // Constructor
    public Gemi(String gemi_tipi, String gemi_adi, String gemi_kodu,
                List<String> gemi_guverte_silahlari, int murettebat_sayisi,
                int silah_sayisi, int zirh, double kritik_hasar_olasiligi,
                int kritik_hasar_carpani, int saglik) {
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

    // Getter method for gemi_adi
    public String getGemiAdi() {
        return gemi_adi;
    }
    public String saglikDurumu() {
        return Integer.toString(saglik);  // Sağlık bilgisini döndürüyor.
    }

    // Health management method (taking damage)
    public void hasarAlma(int hasar) {
        int netHasar = hasar - (zirh / 10);  // Zırhın etkisini hesapla
        if (Math.random() < kritik_hasar_olasiligi) {
            kritikHasar(netHasar);  // Kritik hasar durumu
        } else {
            saglik -= netHasar;  // Normal hasar
        }

        if (saglik < 0) {
            saglik = 0;  // Sağlık sıfırın altına inmemeli
        }

        System.out.println(gemi_adi + " kalan sağlık: " + saglik);
    }

    // Abstract methods to be implemented in subclasses
    public abstract void saldir(Gemi hedefGemi);
    public abstract void kritikHasar(int hasar);
    public abstract void torpidoAt(Gemi hedefGemi);  // Tek bir soyut metod bırakıldı
    public abstract void suAltiBombasi(Gemi hedefGemi);
    public abstract void ozelSaldiri(Gemi hedefGemi); // Bu metod da soyut sınıfta tanımlanıyor

}
