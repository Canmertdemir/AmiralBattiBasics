import java.util.List;

public class Ubot extends Gemi {

    public Ubot(String gemi_adi, String gemi_kodu, List<String> gemi_guverte_silahlari) {
        super("Denizaltı", gemi_adi, gemi_kodu, gemi_guverte_silahlari,
                30, gemi_guverte_silahlari.size(), 50,
                0.3, 3, 200);
    }

    @Override
    public void saldir(Gemi hedefGemi) {
        int saldiriGucu = 40;
        System.out.println(gemi_adi + " hedefe torpido saldırısı yapıyor: " + hedefGemi.getGemiAdi());
        hedefGemi.hasarAlma(saldiriGucu);
    }

    @Override
    public void kritikHasar(int hasar) {
        int ekstraHasar = (int) (hasar * kritik_hasar_carpani);
        System.out.println(gemi_adi + " KRİTİK HASAR verdi! Ekstra hasar: " + ekstraHasar);
        saglik -= ekstraHasar;
        if (saglik < 0) saglik = 0;
    }

    @Override
    public void torpidoAt(Gemi hedefGemi) {
        int hasar = 60;
        System.out.println(gemi_adi + " torpido atıyor!");
        hedefGemi.hasarAlma(hasar);
    }

    @Override
    public void suAltiBombasi(Gemi hedefGemi) {
        int hasar = 20;
        System.out.println(gemi_adi + " su altı bombası atıyor!");
        hedefGemi.hasarAlma(hasar);
    }
    @Override
    public void ozelSaldiri(Gemi hedefGemi) {
        System.out.println(gemi_adi + " özel zırhlı top saldırısı yapıyor!");
        hedefGemi.hasarAlma(75);  // Zırhlı geminin özel saldırısı
    }
}
