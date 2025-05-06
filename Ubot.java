import java.util.List;

public class Ubot extends Gemi {

    public Ubot(String gemi_adi, String gemi_kodu, List<String> gemi_guverte_silahlari) {
        super(
                "Denizaltı",                  // gemi_tipi
                gemi_adi,
                gemi_kodu,
                gemi_guverte_silahlari,
                30,                           // murettebat_sayisi (küçük mürettebat)
                gemi_guverte_silahlari.size(), // silah_sayisi
                50,                           // zirh (orta seviye)
                0.3,                          // kritik_hasar_olasiligi (yüksek)
                3,                            // kritik_hasar_carpani (yüksek etki)
                200                           // saglik (orta)
        );
    }

    @Override
    public void saldir(Gemi hedefGemi) {
        int saldiriGucu = 40; // sabit bir saldırı gücü, örn: torpido
        System.out.println(gemi_adi + " hedefe saldırıyor: " + hedefGemi.getGemiAdi());
        hedefGemi.hasarAlma(saldiriGucu);
    }

    @Override
    public void kritikHasar(int hasar) {
        int ekstraHasar = (int)(hasar * kritik_hasar_carpani);
        System.out.println(gemi_adi + " KRİTİK HASAR verdi! Ekstra hasar: " + ekstraHasar);
        saglik -= ekstraHasar;
        if (saglik < 0) saglik = 0;
    }
}
