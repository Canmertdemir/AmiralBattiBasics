import java.util.List;

public class ZirhliGemi extends Gemi {

    public ZirhliGemi(String gemi_adi, String gemi_kodu, List<String> gemi_guverte_silahlari) {
        super(
                "Zırhlı Gemi",
                gemi_adi,
                gemi_kodu,
                gemi_guverte_silahlari,
                150,                          // yüksek mürettebat
                gemi_guverte_silahlari.size(),
                100,                          // yüksek zırh
                0.1,                          // düşük kritik hasar olasılığı
                2,                            // orta çarpan
                400                           // yüksek sağlık
        );
    }

    @Override
    public void saldir(Gemi hedefGemi) {
        int saldiriGucu = 60;
        System.out.println(gemi_adi + " hedefe top atışı yapıyor: " + hedefGemi.getGemiAdi());
        hedefGemi.hasarAlma(saldiriGucu);
    }

    @Override
    public void kritikHasar(int hasar) {
        int ekstraHasar = (int)(hasar * kritik_hasar_carpani);
        System.out.println(gemi_adi + " KRİTİK top atışı yaptı! Ekstra hasar: " + ekstraHasar);
        saglik -= ekstraHasar;
        if (saglik < 0) saglik = 0;
    }
}
